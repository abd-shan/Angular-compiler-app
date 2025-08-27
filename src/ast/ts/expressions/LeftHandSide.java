package ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Represents a left-hand side expression for assignments
 */
public class LeftHandSide implements TsExpression {
    private final boolean hasThis;
    private final String baseName;
    private final List<Access> accesses;

    public LeftHandSide(boolean hasThis, String baseName, List<Access> accesses) {
        this.hasThis = hasThis;
        this.baseName = Objects.requireNonNull(baseName);
        this.accesses = accesses != null ? new ArrayList<>(accesses) : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (hasThis) {
            sb.append("this.");
        }
        sb.append(baseName);

        for (Access access : accesses) {
            sb.append(access.toString());
        }

        return sb.toString();
    }

    public static abstract class Access {
        public abstract String toString();
    }

    public static class DotAccess extends Access {
        private final String name;

        public DotAccess(String name) {
            this.name = Objects.requireNonNull(name);
        }

        @Override
        public String toString() {
            return "." + name;
        }
    }

    public static class BracketAccess extends Access {
        private final TsExpression expression;

        public BracketAccess(TsExpression expression) {
            this.expression = Objects.requireNonNull(expression);
        }

        @Override
        public String toString() {
            return "[" + expression.toString() + "]";
        }
    }
}
