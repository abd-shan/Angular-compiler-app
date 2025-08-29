package semantic;

import symbolTable.Scope;
import symbolTable.Symbol;
import symbolTable.SymbolTable;

import java.util.*;

// all commit are written by abd-shan.
public class TypeScriptSemanticAnalyzer {
    private final SymbolTable tsTable;
    private final List<String> errors = new ArrayList<>();

    private static final Set<String> CLASS_MEMBER_TYPES = Set.of(
            "field", "variable", "param", "method", "constructor"
    );

    private static final Set<String> USAGE_TYPES = Set.of(
            "usage", "call"
    );


    private static final boolean DEBUG = false;

    public TypeScriptSemanticAnalyzer(SymbolTable tsTable) {
        this.tsTable = tsTable;
    }

    public void analyze() {
        checkUndefinedThisMembers();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    // ----------------- Helpers -----------------

    private Scope getRoot() {
        Scope cur = null;
        try {
            cur = tsTable.getCurrentScope();
        } catch (Throwable t) {
            // ignore
        }
        if (cur == null) return null;
        while (cur.getParent() != null) cur = cur.getParent();
        return cur;
    }

    private boolean isClassScope(Scope s) {
        if (s == null) return false;
        for (Symbol sym : s.getSymbols().values()) {
            String type = sym.getType();
            if (type != null && CLASS_MEMBER_TYPES.contains(type)) {
                return true;
            }
        }
        return false;
    }

    private Scope enclosingClassScope(Scope s) {
        Scope cur = s;
        while (cur != null) {
            if (isClassScope(cur)) return cur;
            cur = cur.getParent();
        }
        return null;
    }


    private String normalizeSymbolName(String raw) {
        if (raw == null) return null;
        String s = raw;
        if (s.startsWith("this.")) s = s.substring("this.".length());
        int cut = firstNonIdentifierPos(s);
        if (cut >= 0) s = s.substring(0, cut);
        return s;
    }


    private Map<Scope, Set<String>> indexClassMembers() {
        Map<Scope, Set<String>> map = new IdentityHashMap<>();
        Scope root = getRoot();
        if (root == null) return map;

        Deque<Scope> dq = new ArrayDeque<>();
        dq.add(root);
        List<Scope> classScopes = new ArrayList<>();

        while (!dq.isEmpty()) {
            Scope s = dq.poll();
            dq.addAll(s.getChildren());
            if (isClassScope(s)) classScopes.add(s);
        }

        for (Scope cls : classScopes) {
            Set<String> members = new HashSet<>();
            for (Symbol sym : cls.getSymbols().values()) {
                String n = sym.getName();
                if (n == null) continue;
                // normalized name (so "this.products", "products", "products.some" -> "products")
                String norm = normalizeSymbolName(n);
                if (norm != null && !norm.isEmpty()) {
                    members.add(norm);
                }
                // also store raw name as-is (in case your table stores weird variants)
                members.add(n);
            }
            map.put(cls, members);
            if (DEBUG) {
                String cname = cls.getName() != null ? cls.getName() : "<anon>";
                System.out.println("[DEBUG] indexed class scope: " + cname + " -> members: " + members);
            }
        }

        return map;
    }

    private String formatError(Scope scope, Symbol atSym, String msg) {
        String scopeName = (scope != null && scope.getName() != null) ? scope.getName() : "<unknown-scope>";
        if (atSym != null && atSym.getLine() > 0 && atSym.getColumn() > 0) {
            return "[TS Scope: " + scopeName + "] " + msg +
                    " (line " + atSym.getLine() + ", col " + atSym.getColumn() + ")";
        }
        return "[TS Scope: " + scopeName + "] " + msg +
                (atSym != null && atSym.getName() != null ? " (at: " + atSym.getName() + ")" : "");
    }

    // ----------------- Check: this.member -----------------

    private void checkUndefinedThisMembers() {
        Scope root = getRoot();
        if (root == null) return;

        Map<Scope, Set<String>> classMembers = indexClassMembers();

        Deque<Scope> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            Scope s = dq.poll();
            dq.addAll(s.getChildren());

            Scope cls = enclosingClassScope(s);
            if (cls == null) continue;

            Set<String> members = classMembers.getOrDefault(cls, Collections.emptySet());

            for (Symbol sym : s.getSymbols().values()) {
                String n = sym.getName();
                if (n == null) continue;

                // only this.
                if (!n.startsWith("this.")) continue;

                // sure if we use var
                String symType = sym.getType();
                if (symType != null && !USAGE_TYPES.contains(symType)) {
                    continue;
                }

                String after = n.substring("this.".length());
                if (after.isEmpty()) continue;

                String member = normalizeSymbolName(after);
                if (member == null || member.isEmpty()) continue;

                boolean found = false;
                // 1check
                if (members.contains(member) || members.contains("this." + member)) {
                    found = true;
                } else {
                    // check scope
                    for (Symbol classSym : cls.getSymbols().values()) {
                        String csName = classSym.getName();
                        String csNorm = normalizeSymbolName(csName);
                        if (member.equals(csNorm) || member.equals(csName)) {
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    // print debug for seek issues( by abd-shan )
                    if (DEBUG) {
                        String clsName = cls.getName() != null ? cls.getName() : "<anon>";
                        System.out.println("[DEBUG] Missing member check:");
                        System.out.println("  usage symbol: '" + n + "' (normalized -> '" + member + "') in scope '" + s.getName() + "'");
                        System.out.println("  class scope: '" + clsName + "'");
                        System.out.println("  indexed members set: " + members);
                        System.out.println("  class symbols:");
                        for (Symbol cs : cls.getSymbols().values()) {
                            System.out.println("    - name: '" + cs.getName() + "'  type: '" + cs.getType() + "'");
                        }
                    }

                    String suggestion = findClosest(member, members);
                    String suggestionPart = (suggestion != null) ? " Did you mean '" + suggestion + "'?" : "";
                    errors.add(
                            formatError(s, sym, "Undefined member '" + member + "' accessed via 'this.'" + suggestionPart)
                    );
                }
            }
        }
    }

    private int firstNonIdentifierPos(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean ok = (c == '_' || c == '$') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9');
            if (!ok) return i;
        }
        return -1;
    }

    // --------- Small utility: closest string (Levenshtein) ---------

    private String findClosest(String target, Set<String> candidates) {
        if (candidates == null || candidates.isEmpty()) return null;
        String best = null;
        int bestDist = Integer.MAX_VALUE;
        for (String c : candidates) {
            if (c == null) continue;

            String cNorm = normalizeSymbolName(c);
            if (cNorm == null) cNorm = c;
            int d = levenshtein(target, cNorm);
            if (d < bestDist) {
                bestDist = d;
                best = cNorm;
            }
        }
        if (bestDist <= Math.max(1, target.length() / 3)) {
            return best;
        }
        return null;
    }

    private int levenshtein(String a, String b) {
        int n = a.length(), m = b.length();
        if (n == 0) return m;
        if (m == 0) return n;
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int j = 0; j <= m; j++) prev[j] = j;
        for (int i = 1; i <= n; i++) {
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                cur[j] = Math.min(Math.min(cur[j - 1] + 1, prev[j] + 1), prev[j - 1] + cost);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[m];
    }
}
