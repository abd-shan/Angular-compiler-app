package ast.ts.modifiers;

public class AccessModifier implements Modifier {
    public enum Access {
        PUBLIC("public"),
        PRIVATE("private"),
        PROTECTED("protected");

        private final String keyword;

        Access(String keyword) {
            this.keyword = keyword;
        }

        @Override
        public String toString() {
            return keyword;
        }
    }

    private Access access;

    public AccessModifier(Access access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return access.toString();
    }

    // Getters and setters
    public Access getAccess() { return access; }
}
