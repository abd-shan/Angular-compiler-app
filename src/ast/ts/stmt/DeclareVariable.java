package ast.ts.stmt;

import ast.ts.statements.TsStatement;
import ast.ts.types.TsType;

import java.util.Objects;

public class DeclareVariable implements TsStatement {
    private final String keyword;
    private final String name;
    private final TsType type;

    public DeclareVariable(String keyword, String name, TsType type) {
        this.keyword = Objects.requireNonNull(keyword);
        this.name = Objects.requireNonNull(name);
        this.type = type;
    }

    @Override
    public String toString() {
        return keyword + " " + name + (type != null ? ": " + type.toString() : "") + ";";
    }
}