package visitors;

import css.Css;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import html.Html;
import program.Program;
import ts.*;
import ts.expressions.Attribute;
import ts.expressions.Expression;
import ts.expressions.Variable;
import ts.types.Bool;
import ts.types.Number;
import ts.types.Text;
import ts.types.Type;

public class AngularVisitor extends AngularParserBaseVisitor {
    Program program;
    String scope = "";
    public SymbolTable symbolTable = new SymbolTable();

    @Override
    public Object visitProgram(AngularParser.ProgramContext ctx) {


        Css css = (Css) visitCssOption(ctx.cssOption());
        TypeScript ts = (TypeScript) visitTs(ctx.ts());
        Html html = (Html) visitHtmlOption(ctx.htmlOption());

        program = new Program(html, css, ts);

        return program;
    }


    @Override
    public Object visitCssOption(AngularParser.CssOptionContext ctx) {
        Css css = new Css((String) ctx.css().getText());
        return css;
    }

//    <<<<<<<<<<<<<<<<<< Html

    @Override
    public Object visitHtmlOption(AngularParser.HtmlOptionContext ctx) {
        return super.visitHtmlOption(ctx);
    }


    @Override
    public Object visitHtml(AngularParser.HtmlContext ctx) {
        return super.visitHtml(ctx);
    }

    @Override
    public Object visitDiv(AngularParser.DivContext ctx) {
        return super.visitDiv(ctx);
    }

    @Override
    public Object visitParagragh(AngularParser.ParagraghContext ctx) {
        return super.visitParagragh(ctx);
    }

    @Override
    public Object visitH2Element(AngularParser.H2ElementContext ctx) {
        return super.visitH2Element(ctx);
    }

    @Override
    public Object visitPElement(AngularParser.PElementContext ctx) {
        return super.visitPElement(ctx);
    }

    @Override
    public Object visitImg(AngularParser.ImgContext ctx) {
        return super.visitImg(ctx);
    }

    @Override
    public Object visitBr(AngularParser.BrContext ctx) {
        return super.visitBr(ctx);
    }

    @Override
    public Object visitClassid(AngularParser.ClassidContext ctx) {
        return super.visitClassid(ctx);
    }

    @Override
    public Object visitNg(AngularParser.NgContext ctx) {
        return super.visitNg(ctx);
    }

    @Override
    public Object visitEvent(AngularParser.EventContext ctx) {
        return super.visitEvent(ctx);
    }
//>>>>>>>>>>>>>>>>>>>>>>
//    <<<<<<<<<<<<<<<<<<<< Typescript

    @Override
    public Object visitTs(AngularParser.TsContext ctx) {
        TypeScript typeScript = new TypeScript();

        for (int i = 0; i < ctx.attribute().size(); i++) {
            Attribute attribute = (Attribute) visit(ctx.attribute(i));
            typeScript.addAttribute(attribute);
        }

        if (ctx.constructor() != null) {
            Constructor constructor = (Constructor) visit(ctx.constructor());
            typeScript.setConstructor(constructor);
        }
        for (int i = 0; i < ctx.method().size(); i++) {
//            Method method = (Method) visit(ctx.method(i));
//            typeScript.addMethod(method);
        }

        return typeScript;

    }

    @Override
    public Object visitDeclareAttribute(AngularParser.DeclareAttributeContext ctx) {
        String name = ctx.ID().getText();
        Kind kind;
        if (ctx.type().NUMBER() != null) {
            kind = Kind.number;
        } else if (ctx.type().BOOLEAN() != null) {
            kind = Kind.bool;
        } else if (ctx.type().STRINGDL() != null) {
            kind = Kind.string;
        } else {
            kind = Kind.any;
        }
        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null) symbolTable.addSymbol(name, kind, scope);
        else {
            // error attribute already declared
            System.out.println("Error: Symbol " + name + " already exists");
            System.exit(1);
        }
        return new Attribute(name, kind);
    }

    @Override
    public Object visitDeclareAndAssignAttribute(AngularParser.DeclareAndAssignAttributeContext ctx) {
        String name = ctx.ID().getText();
        Kind kind;
        Type type;
        if (ctx.type().NUMBER() != null) {
            kind = Kind.number;
            type = (Number) visit(ctx.literal());
        } else if (ctx.type().BOOLEAN() != null) {
            kind = Kind.bool;
            type = (Bool) visit(ctx.literal());
        } else if (ctx.type().STRINGDL() != null) {
            kind = Kind.string;
            type = (Text) visit(ctx.literal());
        } else {
            kind = Kind.any;
            type = (Type) visit(ctx.literal());
        }

        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null) symbolTable.addSymbol(name, kind, type, scope);
        else {
            // error attribute already declared
            System.out.println("Error: Symbol " + name + " already exists");
            System.exit(1);
        }

        return new Attribute(name, kind);
    }

    @Override
    public Object visitConstructor(AngularParser.ConstructorContext ctx) {
        scope += ".constructor";
        Constructor constructor = new Constructor();

        for (int i = 0; i < ctx.expression().size(); i++) {
            Expression expression = (Expression) visit(ctx.expression(i));
            constructor.addExpression(expression);
        }
        scope = scope.substring(0, scope.length() - ".constructor".length());

        return constructor;
    }

    @Override
    public Object visitDeclareVariable(AngularParser.DeclareVariableContext ctx) {
        String name = ctx.ID().getText();
        Kind kind;
        if (ctx.type().NUMBER() != null) {
            kind = Kind.number;
        } else if (ctx.type().BOOLEAN() != null) {
            kind = Kind.bool;
        } else if (ctx.type().STRINGDL() != null) {
            kind = Kind.string;
        } else kind = Kind.any;

        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null)
            symbolTable.addSymbol(name, kind, scope);
        else {
            // error variable already declared in this scope
            System.out.println("Error: Symbol " + name + " already exists");
            System.exit(1);
        }


        return new Variable(name, kind);
    }

    @Override
    public Object visitDeclareAndAssign(AngularParser.DeclareAndAssignContext ctx) {
        String name = ctx.ID().getText();
        Kind kind;
        Type type;
        if (ctx.type().NUMBER() != null) {
//            try {
            kind = Kind.number;
            type = (Number) visit(ctx.literal());
//            } catch (ClassCastException e) {
//                System.out.println("expected number, found something else");
//                type = null;
//            }
        } else if (ctx.type().BOOLEAN() != null) {
            kind = Kind.bool;
            type = (Bool) visit(ctx.literal());
        } else if (ctx.type().STRINGDL() != null) {
            kind = Kind.string;
            type = (Text) visit(ctx.literal());
        } else {
            kind = Kind.any;
            type = (Type) visit(ctx.literal());
        }

        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null)
            symbolTable.addSymbol(name, kind, type, scope);
        else {
            // error variable already declared in this scope
            System.out.println("Error: Symbol " + name + " already exists");
            System.exit(1);
        }
        return new Variable(name, kind);
    }

    @Override
    public Object visitAssignVariable(AngularParser.AssignVariableContext ctx) {
        String name = ctx.ID().getText();
        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null) {
            System.out.println("Error: Symbol " + name + " not found");
            System.exit(1);
        }
        Kind kind = symbol.getKind();
        Type type;
        if (kind == Kind.number) {
            type = (Number) visit(ctx.literal());
        } else if (kind == Kind.bool) {
            type = (Bool) visit(ctx.literal());
        } else if (kind == Kind.string) {
            type = (Text) visit(ctx.literal());
        } else
            type = (Type) visit(ctx.literal());

        symbol.setType(type);

        return new Variable(name, kind);
    }

    @Override
    public Object visitAssignAttribute(AngularParser.AssignAttributeContext ctx) {
        String name = ctx.ID().getText();

        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null) {
            System.out.println("Error: Symbol " + name + " not found");
            System.exit(1);
        }
        Kind kind = symbol.getKind();
        Type type;
        if (kind == Kind.number) {
            type = (Number) visit(ctx.literal());
        } else if (kind == Kind.bool) {
            type = (Bool) visit(ctx.literal());
        } else if (kind == Kind.string) {
            type = (Text) visit(ctx.literal());
        } else
            type = (Type) visit(ctx.literal());

        symbol.setType(type);

        return null;
    }

    @Override
    public Object visitStoredID(AngularParser.StoredIDContext ctx) {
        String name = ctx.ID().getText();
        Symbol symbol = symbolTable.findSymbol(name, scope);
        return symbol.getType();
    }

    @Override
    public Object visitString(AngularParser.StringContext ctx) {
        return new Text(ctx.getText());
    }

    @Override
    public Object visitNumber(AngularParser.NumberContext ctx) {
        return new Number(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Object visitBoolean(AngularParser.BooleanContext ctx) {
        Bool bool;
        if (ctx.TRUE() != null) {
            bool = new Bool(true);
        } else {
            bool = new Bool(false);
        }
        return bool;
    }

    @Override
    public Object visitIf(AngularParser.IfContext ctx) {
        return super.visitIf(ctx);
    }

    @Override
    public Object visitFor(AngularParser.ForContext ctx) {
        return super.visitFor(ctx);
    }


    @Override
    public Object visitKeyValue(AngularParser.KeyValueContext ctx) {
        return super.visitKeyValue(ctx);
    }

    @Override
    public Object visitArray(AngularParser.ArrayContext ctx) {
        return super.visitArray(ctx);
    }

    @Override
    public Object visitMethod(AngularParser.MethodContext ctx) {
        return super.visitMethod(ctx);
    }

    @Override
    public Object visitMethodParams(AngularParser.MethodParamsContext ctx) {
        return super.visitMethodParams(ctx);
    }


}
