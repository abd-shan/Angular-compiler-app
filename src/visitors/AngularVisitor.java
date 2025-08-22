package visitors;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import css.Css;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import html.DivNode;
import html.Html;
import symbolTable.html.HtmlSymbolTable;
import program.Program;
import symbolTable.component.Component;
import symbolTable.component.ComponentTable;
import symbolTable.ts.Symbol;
import symbolTable.ts.SymbolTable;
import ts.*;
import ts.expressions.Attribute;
import ts.expressions.Expression;
import ts.expressions.Variable;
import ts.types.*;
import ts.types.Number;
import html.DivChild.*;
import html.Paragraph.*;
import html.DivAttribute.*;




public class AngularVisitor extends AngularParserBaseVisitor {
    Program program;
    String scope = "";
    public SymbolTable symbolTable = new SymbolTable();
    Stack<String> scopeStack = new Stack<>();

    public LinkedList<String> errors = new LinkedList<>();
    public ComponentTable componentTable=new ComponentTable();
    private String currentComponentName = "";
    public HtmlSymbolTable htmlSymbolTable = new HtmlSymbolTable();





    @Override
    public Object visitProgram(AngularParser.ProgramContext ctx) {
        String selector = ctx.STRING().getText().replace("\"", "").replace("'", "");
        boolean standalone = ctx.TRUE() != null;

        List<String> staticImports = new ArrayList<>();


        if (ctx.componentList() != null) {
            for (var s : ctx.componentList().STRING()) {
                staticImports.add(s.getText().replace("\"", "").replace("'", ""));
            }
        }

        String className = ctx.ID().getText();
        currentComponentName = className;

        Component component = new Component(className, selector, standalone, staticImports);
        componentTable.addComponent(component);

        for (var imp : ctx.importStatement()) {
            String importedClass = imp.ID().getText();
            componentTable.registerImport(importedClass);

            component.getImports().add(importedClass);
        }

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
        return visit(ctx.html());
    }


    @Override
    public Object visitHtml(AngularParser.HtmlContext ctx) {
        List<DivNode> divs = new ArrayList<>();
        for (AngularParser.DivContext divCtx : ctx.div()) {
            DivNode divNode = (DivNode) visit(divCtx);
            divs.add(divNode);
        }
        return new Html(divs);
    }



    @Override
    public Object visitDivNode(AngularParser.DivNodeContext ctx) {
        String tagName = ctx.ID(0).getText();
        List<DivAttribute> attributes = new ArrayList<>();

        if (!tagName.isEmpty() && Character.isUpperCase(tagName.charAt(0))) {
            Component currentComponent = componentTable.getComponentByClass(currentComponentName);

            boolean isImported = currentComponent != null &&
                    (currentComponent.importsComponent(tagName) || componentTable.isImportedViaStatement(tagName));

            if (!isImported) {
                errors.add("Semantic Error at line " + ctx.ID(0).getSymbol().getLine() +
                        ": Component '" + tagName + "' is not defined or imported.");
            }
        }

        for (AngularParser.DivAttributeContext attrCtx : ctx.divAttribute()) {
            DivAttribute attr = (DivAttribute) visit(attrCtx);
            attributes.add(attr);
        }

        List<DivChild> children = new ArrayList<>();
        for (AngularParser.DivChildContext childCtx : ctx.divChild()) {
            DivChild child = (DivChild) visit(childCtx);
            children.add(child);
        }

        return new DivNode(tagName, attributes, children);
    }

//
//    @Override
////    public Object visitClassOrId(AngularParser.ClassOrIdContext ctx) {
////        return new ClassOrId(ctx.ATTRIBUTE().getText());
////    }
//
//    @Override
//    public Object visitNgDirective(AngularParser.NgDirectiveContext ctx) {
//        return new NgDirective(ctx.getText());
//    }

    @Override
    public Object visitEventBinding(AngularParser.EventBindingContext ctx) {
        return new EventBinding(ctx.getText());
    }


    @Override
    public Object visitBrTag(AngularParser.BrTagContext ctx) {
        AngularParser.BrContext brCtx = ctx.br();

        String tagName = brCtx.getToken(AngularParser.ID, 0).getText();
        String binding = brCtx.getToken(AngularParser.ANGULAR_BINDING, 0).getText();
        scopeStack.push(tagName);
        String currentScope = String.join(" > ", scopeStack);

        String attributes = brCtx.getText();

        htmlSymbolTable.addSymbol(tagName, attributes, currentScope);
        scopeStack.pop();
        checkBindingForUndefinedVariable(binding, ctx.getStart().getLine());
        return new BrTag(tagName, binding);
    }


    @Override
    public Object visitImageElement(AngularParser.ImageElementContext ctx) {
        AngularParser.ImageContext iCtx = ctx.image();

        String tagName = iCtx.ID().getText();
        String property = iCtx.ANGULAR_ATTRIBUTE_PROPERTY().getText();
        scopeStack.push(tagName);
        String currentScope = String.join(" > ", scopeStack);

        String attributes = iCtx.getText();

        htmlSymbolTable.addSymbol(tagName, attributes, currentScope);
         scopeStack.pop();
        Pattern pattern = Pattern.compile("\\[.*?\\]\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(property);
        if (matcher.find()) {
            String expression = matcher.group(1).trim();
            String[] parts = expression.split("\\.");
            String variableName = parts[0].trim();

            if (symbolTable.findSymbol(variableName, scope) == null) {
                int line = ctx.getStart().getLine();
                String error = "Semantic Error at line " + line + ": Variable '" + variableName + "' is not defined in [src] binding.";
                errors.add(error);
            }
        }
        return new ImageElement(
                tagName,
                property
        );
    }


    @Override
    public Object visitNestedDiv(AngularParser.NestedDivContext ctx) {
        DivNode nested = (DivNode) visit(ctx.div());
        return new NestedDiv(nested);
    }

    @Override
    public Object visitParagraphWrapper(AngularParser.ParagraphWrapperContext ctx) {
        html.Paragraph.ParagraphElement paragraph = (html.Paragraph.ParagraphElement) visit(ctx.paragraph());
        return new html.DivChild.ParagraphWrapper(paragraph);
    }

    @Override
    public Object visitH_Element(AngularParser.H_ElementContext ctx) {
        AngularParser.HElementContext hCtx = ctx.hElement();

        String tagName = hCtx.ID(0).getText();
        String binding=hCtx.ANGULAR_BINDING().getText();
        scopeStack.push(tagName);
        String currentScope = String.join(" > ", scopeStack);

        String attributes = hCtx.getText();
        htmlSymbolTable.addSymbol(tagName, attributes, currentScope);
        scopeStack.pop();
        checkBindingForUndefinedVariable(binding, ctx.getStart().getLine());
        return new H_Element(
                tagName,
                binding,
                hCtx.ID(1).getText()
        );
    }




    @Override
    public Object visitP_Element(AngularParser.P_ElementContext ctx) {
        AngularParser.PElementContext pCtx = ctx.pElement();

        String tagName = "p";
        String binding=pCtx.ANGULAR_BINDING().getText();
        scopeStack.push(tagName);
        String currentScope = String.join(" > ", scopeStack);

        String attributes = pCtx.getText();
        htmlSymbolTable.addSymbol(tagName, attributes, currentScope);
        scopeStack.pop();
        checkBindingForUndefinedVariable(binding, ctx.getStart().getLine());
        return new P_Element(binding);
    }

    private void checkBindingForUndefinedVariable(String binding, int line) {
        String expression = binding.replaceAll("\\{\\{", "").replaceAll("}}", "").trim();

        String[] parts = expression.split("\\.");
        String variableName = parts[0].trim();

        if (symbolTable.findSymbol(variableName, scope) == null) {
            String error = "Semantic Error at line " + line + ": Variable '" + variableName + "' is not defined.";
            errors.add(error);
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>
//    <<<<<<<<<<<<<<<<<<<< Typescript

    @Override
    public Object visitTs(AngularParser.TsContext ctx) {
        TypeScript typeScript = new TypeScript();

        for (int i = 0; i < ctx.tsAttribute().size(); i++) {
            Attribute attribute = (Attribute) visit(ctx.tsAttribute(i));
            typeScript.addAttribute(attribute);
        }

        if (ctx.constructor() != null) {
            Constructor constructor = (Constructor) visit(ctx.constructor());
            typeScript.setConstructor(constructor);
        }
        for (int i = 0; i < ctx.method().size(); i++) {
            Method method = (Method) visit(ctx.method(i));
            typeScript.addMethod(method);
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
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " already exists ");
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
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " already exists ");
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
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " already exists,");
        }


        return new Variable(name, kind);
    }

    @Override
    public Object visitDeclareAndAssign(AngularParser.DeclareAndAssignContext ctx) {
        String name = ctx.ID().getText();
        Kind kind;
        Type type;
        if (ctx.type().NUMBER() != null) {
            kind = Kind.number;
            try {
                type = (Number) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Expected number, found something else");
            }
        } else if (ctx.type().BOOLEAN() != null) {
            kind = Kind.bool;
            try {
                type = (Bool) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Expected boolean, found something else");
            }
        } else if (ctx.type().STRINGDL() != null) {
            kind = Kind.string;
            try {
                type = (Text) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Expected string, found something else");
            }
        } else {
            kind = Kind.any;
            type = (Type) visit(ctx.literal());
        }

        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null)
            symbolTable.addSymbol(name, kind, type, scope);
        else {
            // error variable already declared in this scope
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " already exists");
        }
        return new Variable(name, kind);
    }

    @Override
    public Object visitAssignVariable(AngularParser.AssignVariableContext ctx) {
        String name = ctx.ID().getText();
        Symbol symbol = symbolTable.findSymbol(name, scope);
        if (symbol == null) {
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " not declared already");
        }
        Kind kind = symbol.getKind();
        Type type;
        if (kind == Kind.number) {
            try {
                type = (Number) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line" + ctx.ID().getSymbol().getLine() + ": Expected number, found something else");
            }
        } else if (kind == Kind.bool) {
            try {
                type = (Bool) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line" + ctx.ID().getSymbol().getLine() + ": Expected boolean, found something else");
            }
        } else if (kind == Kind.string) {
            try {
                type = (Text) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line" + ctx.ID().getSymbol().getLine() + ": Expected string, found something else");
            }
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
            errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Symbol " + name + " not declared already");
        }
        Kind kind = symbol.getKind();
        Type type;
        if (kind == Kind.number) {
            try {
                type = (Number) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line " + ctx.ID().getSymbol().getLine() + ": Expected number, found something else");
            }
        } else if (kind == Kind.bool) {
            try {
                type = (Bool) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line" + ctx.ID().getSymbol().getLine() + ": Expected boolean, found something else");
            }
        } else if (kind == Kind.string) {
            try {
                type = (Text) visit(ctx.literal());
            } catch (ClassCastException e) {
                type = null;
                errors.add("Error at line" + ctx.ID().getSymbol().getLine() + ": Expected string, found something else");
            }
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
        KeyValuePair keyValuePair = new KeyValuePair();

        for (int i = 0; i < ctx.ID().size(); i++) {
            keyValuePair.addToKeyValue(ctx.ID(i).getText(), ctx.STRING(i).getText());
        }
        return keyValuePair;
    }

    @Override
    public Object visitArray(AngularParser.ArrayContext ctx) {
        Array array = new Array();
        for (int i = 0; i <ctx.literal().size(); i++) {
            array.add((Type) visit(ctx.literal(i)));
        }
        return array;
    }

    @Override
    public Object visitMethod(AngularParser.MethodContext ctx) {
        String last = "." + ctx.ID().getText() + ctx.ID().getSymbol().getLine();
        scope += last;
        String name = ctx.ID().getText();

        Method method = new Method(name);

        for (int i = 0; i < ctx.expression().size(); i++) {
            Expression expression = (Expression) visit(ctx.expression(i));
            method.addExpression(expression);
        }

        scope = scope.substring(0, scope.length() - last.length());

        return method;

    }

    @Override
    public Object visitMethodParams(AngularParser.MethodParamsContext ctx) {
        return super.visitMethodParams(ctx);
    }


}
