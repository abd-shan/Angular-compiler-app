package generator;

import ast.program.AngularApp;
import ast.program.AngularFile;
import ast.program.ComponentFile;
import ast.html.HtmlDocument;
import ast.html.Node;
import ast.html.element.ElementNode;
import ast.html.element.InterpolationNode;
import ast.html.element.TextNode;
import ast.html.attribute.*;
import ast.ts.expressions.*;
import ast.ts.statements.DeclareAndAssignAttribute;
import ast.ts.statements.TsStatement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlGenerator {

    private static final String OUTPUT_DIR = "output";

    public HtmlGenerator(AngularApp angularApp) {
        Map<String, List<Map<String, TsExpression>>> data = extractObjectArrays(angularApp);

        List<ComponentFile> files = angularApp.getComponentFiles();
        ensureOutputDir();

        for (ComponentFile file : files) {
            String className = file.getClassName();
            File htmlFile = new File(OUTPUT_DIR, className + ".html");

            String bodyHtml = "";
            HtmlDocument doc = file.getTemplate();
            if (doc != null) {
                bodyHtml = renderHtmlDocument(doc, file, data);
            } else {
                bodyHtml = "<!-- empty template -->";
            }

            writeHtmlFile(htmlFile, className, file.getStyles(), bodyHtml);
            System.out.println("Created: " + htmlFile.getAbsolutePath());
        }
    }

    private void ensureOutputDir() {
        File out = new File(OUTPUT_DIR);
        if (!out.exists()) {
            if (!out.mkdirs()) {
                System.err.println("Could not create output directory: " + OUTPUT_DIR);
            }
        }
    }

    private String renderHtmlDocument(HtmlDocument doc, ComponentFile file, Map<String, List<Map<String, TsExpression>>> data) {
        StringBuilder sb = new StringBuilder();
        for (Node node : doc.getNodes()) {
            sb.append(renderNode(node, file, data));
        }
        return sb.toString().trim();
    }

    private String renderElementNode(ElementNode el, ComponentFile file, Map<String, List<Map<String, TsExpression>>> data) {
        try {
            Class<?> cls = el.getClass();

            Field tagField = getFieldRecursive(cls, "tagName");
            tagField.setAccessible(true);
            String tagName = (String) tagField.get(el);

            Field attrsField = getFieldRecursive(cls, "attributes");
            attrsField.setAccessible(true);
            List<?> attrs = (List<?>) attrsField.get(el);

            Field childrenField = getFieldRecursive(cls, "children");
            childrenField.setAccessible(true);
            List<?> children = (List<?>) childrenField.get(el);

            Field selfClosingField = getFieldRecursive(cls, "selfClosing");
            selfClosingField.setAccessible(true);
            boolean selfClosing = (boolean) selfClosingField.get(el);

            // Check if this element has an ngFor attribute
            NgForAttribute ngForAttr = null;
            if (attrs != null) {
                for (Object attr : attrs) {
                    if (attr instanceof NgForAttribute) {
                        ngForAttr = (NgForAttribute) attr;
                        break;
                    }
                }
            }

            // If ngFor is present, handle the loop
            if (ngForAttr != null) {
                String expr = extractQuotedExpression(ngForAttr.toString());
                if (expr != null && !expr.isBlank()) {
                    String normalized = expr.trim().replaceAll("^let\\s+", "").replaceAll("\\s+of\\s+", " in ");
                    String[] parts = normalized.split("\\s+in\\s+");
                    if (parts.length == 2) {
                        String itemVar = parts[0].trim();
                        String arrayName = parts[1].trim();

                        List<Map<String, TsExpression>> items = data.get(arrayName);
                        if (items != null) {
                            StringBuilder loopSb = new StringBuilder();
                            for (Map<String, TsExpression> item : items) {
                                loopSb.append("<").append(tagName);

                                // Render attributes (excluding ngFor)
                                if (attrs != null && !attrs.isEmpty()) {
                                    for (Object a : attrs) {
                                        if (a instanceof ast.html.attribute.HtmlAttribute && !(a instanceof NgForAttribute)) {
                                            String rendered = renderAttributeWithData((ast.html.attribute.HtmlAttribute) a, item, itemVar);
                                            if (!rendered.isEmpty()) {
                                                loopSb.append(" ").append(rendered);
                                            }
                                        }
                                    }
                                }

                                loopSb.append(">");

                                // Render children with item data
                                if (children != null && !children.isEmpty()) {
                                    for (Object c : children) {
                                        if (c instanceof Node) {
                                            loopSb.append(renderNodeWithData((Node) c, file, item, itemVar));
                                        } else {
                                            loopSb.append(escapeText(Objects.toString(c, "")));
                                        }
                                    }
                                }

                                loopSb.append("</").append(tagName).append(">");
                            }
                            return loopSb.toString();
                        }
                    }
                }
            }

            // Normal rendering (no ngFor)
            StringBuilder sb = new StringBuilder();
            sb.append("<").append(tagName);

            // render attributes
            if (attrs != null && !attrs.isEmpty()) {
                for (Object a : attrs) {
                    if (a instanceof ast.html.attribute.HtmlAttribute) {
                        String rendered = renderAttribute((ast.html.attribute.HtmlAttribute) a, data);
                        if (!rendered.isEmpty()) {
                            sb.append(" ").append(rendered);
                        }
                    } else {
                        sb.append(" ").append(escapeAttribute(a == null ? "" : a.toString()));
                    }
                }
            }

            if (selfClosing) {
                sb.append(" />");
                return sb.toString();
            } else {
                sb.append(">");
            }

            // render children
            if (children != null && !children.isEmpty()) {
                for (Object c : children) {
                    if (c instanceof Node) {
                        sb.append(renderNode((Node) c, file, data));
                    } else {
                        sb.append(escapeText(Objects.toString(c, "")));
                    }
                }
            }

            sb.append("</").append(tagName).append(">");
            return sb.toString();
        } catch (ReflectiveOperationException ex) {
            System.err.println("Reflection failed rendering ElementNode; falling back to toString(): " + ex.getMessage());
            return escapeText(el.toString());
        }
    }

    private String renderAttributeWithData(ast.html.attribute.HtmlAttribute attr, Map<String, TsExpression> itemData, String itemVar) {
        if (attr == null) return "";

        // AngularPropertyBinding with item data
        if (attr instanceof AngularPropertyBinding) {
            AngularPropertyBinding pb = (AngularPropertyBinding) attr;
            String expr = pb.getExpression();

            if (expr.startsWith(itemVar + ".")) {
                String field = expr.substring(itemVar.length() + 1);
                TsExpression value = itemData.get(field);
                if (value != null) {
                    // Extract the actual string value without quotes for attributes
                    String stringValue = extractStringValue(value);
                    return pb.getProperty() + "=\"" + escapeAttribute(stringValue) + "\"";
                }
            }
            return pb.getProperty() + "=\"{{ " + escapeAttribute(expr) + " }}\"";
        }

        // Standard attribute handling
        if (attr instanceof StandardAttribute sa) {
            return sa.getName() + "=\"" + escapeAttribute(sa.getValue()) + "\"";
        }

        if (attr instanceof BooleanAttribute ba) {
            return ba.getName();
        }

        // For other attribute types, use the normal render method
        return renderAttribute(attr, Map.of());
    }

    private String renderNodeWithData(Node node, ComponentFile file, Map<String, TsExpression> itemData, String itemVar) {
        if (node == null) return "";

        if (node instanceof ElementNode) {
            return renderElementNodeWithData((ElementNode) node, file, itemData, itemVar);
        } else if (node instanceof InterpolationNode) {
            String raw = node.toString().trim();
            String expr = raw.replaceAll("^\\{\\{\\s*", "")
                    .replaceAll("\\s*\\}\\}$", "")
                    .trim();

            // Handle item.field expressions
            if (expr.startsWith(itemVar + ".")) {
                String field = expr.substring(itemVar.length() + 1);
                TsExpression value = itemData.get(field);
                if (value != null) {
                    // Extract the actual string value without quotes for text content
                    String stringValue = extractStringValue(value);
                    return escapeText(stringValue);
                }
            }

            return "{{ " + expr + " }}";
        } else if (node instanceof TextNode) {
            return escapeText(node.toString());
        } else {
            return escapeText(node.toString());
        }
    }

    private String renderElementNodeWithData(ElementNode el, ComponentFile file, Map<String, TsExpression> itemData, String itemVar) {
        try {
            Class<?> cls = el.getClass();

            Field tagField = getFieldRecursive(cls, "tagName");
            tagField.setAccessible(true);
            String tagName = (String) tagField.get(el);

            Field attrsField = getFieldRecursive(cls, "attributes");
            attrsField.setAccessible(true);
            List<?> attrs = (List<?>) attrsField.get(el);

            Field childrenField = getFieldRecursive(cls, "children");
            childrenField.setAccessible(true);
            List<?> children = (List<?>) childrenField.get(el);

            Field selfClosingField = getFieldRecursive(cls, "selfClosing");
            selfClosingField.setAccessible(true);
            boolean selfClosing = (boolean) selfClosingField.get(el);

            StringBuilder sb = new StringBuilder();
            sb.append("<").append(tagName);

            // render attributes with item data
            if (attrs != null && !attrs.isEmpty()) {
                for (Object a : attrs) {
                    if (a instanceof ast.html.attribute.HtmlAttribute) {
                        String rendered = renderAttributeWithData((ast.html.attribute.HtmlAttribute) a, itemData, itemVar);
                        if (!rendered.isEmpty()) {
                            sb.append(" ").append(rendered);
                        }
                    } else {
                        sb.append(" ").append(escapeAttribute(a == null ? "" : a.toString()));
                    }
                }
            }

            if (selfClosing) {
                sb.append(" />");
                return sb.toString();
            } else {
                sb.append(">");
            }

            // render children with item data
            if (children != null && !children.isEmpty()) {
                for (Object c : children) {
                    if (c instanceof Node) {
                        sb.append(renderNodeWithData((Node) c, file, itemData, itemVar));
                    } else {
                        sb.append(escapeText(Objects.toString(c, "")));
                    }
                }
            }

            sb.append("</").append(tagName).append(">");
            return sb.toString();
        } catch (ReflectiveOperationException ex) {
            System.err.println("Reflection failed rendering ElementNode; falling back to toString(): " + ex.getMessage());
            return escapeText(el.toString());
        }
    }

    // Helper method to extract string values from TsExpression objects
    private String extractStringValue(TsExpression expression) {
        if (expression instanceof PrimaryExpression) {
            PrimaryExpression primary = (PrimaryExpression) expression;
            if (primary.getAtom() instanceof StringLiteral) {
                StringLiteral stringLiteral = (StringLiteral) primary.getAtom();
                return stringLiteral.getValue(); // This should return the actual string without quotes
            } /*else if (primary.getAtom() instanceof NumericLiteral) {
                NumericLiteral numericLiteral = (NumericLiteral) primary.getAtom();
                return numericLiteral.getValue().toString();
            }*/
        }
        // Fallback: try to extract from toString() and remove quotes
        String str = expression.toString();
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    private String extractQuotedExpression(String s) {
        if (s == null) return null;
        Matcher m = Pattern.compile("\"([^\"]*)\"").matcher(s);
        if (m.find()) return m.group(1);
        return null;
    }

    private Field getFieldRecursive(Class<?> cls, String fieldName) throws NoSuchFieldException {
        Class<?> current = cls;
        while (current != null) {
            try {
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field '" + fieldName + "' not found in " + cls);
    }

    private String escapeAttribute(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private String escapeText(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private void writeHtmlFile(File file, String title, String styles, String bodyHtml) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("<!DOCTYPE html>\n");
            fw.write("<html lang=\"en\">\n");
            fw.write("<head>\n");
            fw.write("  <meta charset=\"utf-8\" />\n");
            fw.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
            fw.write("  <title>" + escapeAttribute(title) + "</title>\n");
            fw.write("  <style>\n");
            if (styles != null && !styles.isBlank()) {
                fw.write(styles.trim() + "\n");
            }
            fw.write("  </style>\n");
            fw.write("</head>\n");
            fw.write("<body>\n");
            fw.write(bodyHtml + "\n");
            fw.write("\n<!-- Runtime note: JS renderer should parse data-for/data-if/data-on-*/data-model and " +
                    "evaluate {{ }} interpolations against component state. -->\n");
            fw.write("</body>\n");
            fw.write("</html>\n");
        } catch (IOException e) {
            System.err.println("Failed to write file " + file.getAbsolutePath() + ": " + e.getMessage());
        }
    }

    private Map<String, List<Map<String, TsExpression>>> extractObjectArrays(AngularApp angularApp) {
        Map<String, List<Map<String, TsExpression>>> result = new LinkedHashMap<>();

        List<TsStatement> statements = angularApp.getStateFiles()
                .getFirst()
                .getServiceClasses()
                .getFirst()
                .getTsCode()
                .getStatements();

        for (TsStatement stmt : statements) {
            if (stmt instanceof DeclareAndAssignAttribute statement) {
                String name = statement.getName();

                List<Map<String, TsExpression>> objectList = new ArrayList<>();

                if (statement.getExpression() instanceof PrimaryExpression pe1 &&
                        pe1.getAtom() instanceof NewExpression newExpr &&
                        !newExpr.getArguments().isEmpty() &&
                        newExpr.getArguments().getFirst() instanceof PrimaryExpression pe2 &&
                        pe2.getAtom() instanceof ArrayLiteral array) {

                    for (TsExpression expr : array.getElements()) {
                        if (expr instanceof PrimaryExpression pe &&
                                pe.getAtom() instanceof ObjectLiteral obj) {

                            Map<String, TsExpression> propertyMap = new LinkedHashMap<>();
                            for (KeyValuePair kv : obj.getProperties()) {
                                propertyMap.put(kv.getKey(), kv.getValue());
                            }
                            objectList.add(propertyMap);
                        }
                    }
                }

                result.put(name, objectList);
            }
        }

        return result;
    }

    private String renderAttribute(ast.html.attribute.HtmlAttribute attr, Map<String, List<Map<String, TsExpression>>> data) {
        if (attr == null) return "";

        // NgForAttribute - handled separately in renderElementNode
        if (attr instanceof NgForAttribute) {
            return "";
        }

        // NgIfAttribute
        if (attr instanceof NgIfAttribute) {
            String expr = extractQuotedExpression(attr.toString());
            if (expr == null) return "";
            return "data-if=\"" + escapeAttribute(expr.trim()) + "\"";
        }

        // AngularEventBinding
        if (attr instanceof AngularEventBinding) {
            AngularEventBinding eb = (AngularEventBinding) attr;
            return "data-on-" + eb.getEvent() + "=\"" + escapeAttribute(eb.getHandler()) + "\"";
        }

        // AngularPropertyBinding
        if (attr instanceof AngularPropertyBinding) {
            AngularPropertyBinding pb = (AngularPropertyBinding) attr;
            String expr = pb.getExpression();

            if (expr.contains(".")) {
                String[] parts = expr.split("\\.", 2);
                String varName = parts[0];
                String field = parts[1];

                List<Map<String, TsExpression>> objs = data.get(varName + "s");
                if (objs != null && !objs.isEmpty()) {
                    // For property bindings outside ngFor, use the first item or handle differently
                    if (objs.size() > 0 && objs.get(0).containsKey(field)) {
                        TsExpression value = objs.get(0).get(field);
                        String stringValue = extractStringValue(value);
                        return pb.getProperty() + "=\"" + escapeAttribute(stringValue) + "\"";
                    }
                }
            }

            return pb.getProperty() + "=\"{{ " + escapeAttribute(expr) + " }}\"";
        }

        // AngularTwoWayBinding
        if (attr instanceof AngularTwoWayBinding) {
            AngularTwoWayBinding tw = (AngularTwoWayBinding) attr;
            return "data-model=\"" + escapeAttribute(tw.getExpression()) + "\" " +
                    tw.getProperty() + "=\"{{ " + escapeAttribute(tw.getExpression()) + " }}\"";
        }

        // StandardAttribute
        if (attr instanceof StandardAttribute sa) {
            return sa.getName() + "=\"" + escapeAttribute(sa.getValue()) + "\"";
        }

        // BooleanAttribute
        if (attr instanceof BooleanAttribute ba) {
            return ba.getName();
        }

        String raw = attr.toString();
        return raw.contains("=") ? raw : escapeAttribute(raw);
    }

    private String renderNode(Node node, ComponentFile file, Map<String, List<Map<String, TsExpression>>> data) {
        if (node == null) return "";

        if (node instanceof ElementNode) {
            return renderElementNode((ElementNode) node, file, data);

        } else if (node instanceof InterpolationNode) {
            String raw = node.toString().trim();
            String expr = raw.replaceAll("^\\{\\{\\s*", "")
                    .replaceAll("\\s*\\}\\}$", "")
                    .trim();

            // resolve TS variables
            for (TsStatement statement : file.getTsCode().getStatements()) {
                if (statement instanceof DeclareAndAssignAttribute) {
                    DeclareAndAssignAttribute decl = (DeclareAndAssignAttribute) statement;
                    if (expr.equals(decl.getName())) {
                        TsExpression value = decl.getExpression();
                        String stringValue = extractStringValue(value);
                        return escapeText(stringValue);
                    }
                }
            }

            return "{{ " + expr + " }}";

        } else if (node instanceof TextNode) {
            return escapeText(node.toString());
        } else {
            return escapeText(node.toString());
        }
    }
}