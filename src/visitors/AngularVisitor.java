package visitors;

import css.Css;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import html.Html;
import program.Program;
import ts.TypeScript;

public class AngularVisitor extends AngularParserBaseVisitor {
    Program program;


    @Override
    public Object visitProgram(AngularParser.ProgramContext ctx) {


        Css css = (Css) visitCssOption(ctx.cssOption());
        TypeScript ts = (TypeScript) visitTs(ctx.ts());
        Html html = (Html) visitHtmlOption(ctx.htmlOption());

//        program.setCss(css);
//        program.setHtml(html);
//        program.setTypeScript(typeScript);

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
        return super.visitTs(ctx);
    }

    @Override
    public Object visitDeclareAttribute(AngularParser.DeclareAttributeContext ctx) {
        return super.visitDeclareAttribute(ctx);
    }

    @Override
    public Object visitDeclareAndAssignAttribute(AngularParser.DeclareAndAssignAttributeContext ctx) {
        return super.visitDeclareAndAssignAttribute(ctx);
    }

    @Override
    public Object visitDeclareVariable(AngularParser.DeclareVariableContext ctx) {
        return super.visitDeclareVariable(ctx);
    }

    @Override
    public Object visitDeclareAndAssign(AngularParser.DeclareAndAssignContext ctx) {
        return super.visitDeclareAndAssign(ctx);
    }

    @Override
    public Object visitAssignVariable(AngularParser.AssignVariableContext ctx) {
        return super.visitAssignVariable(ctx);
    }

    @Override
    public Object visitAssignAttribute(AngularParser.AssignAttributeContext ctx) {
        return super.visitAssignAttribute(ctx);
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
    public Object visitConstructor(AngularParser.ConstructorContext ctx) {
        return super.visitConstructor(ctx);
    }

    @Override
    public Object visitType(AngularParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Object visitStoredID(AngularParser.StoredIDContext ctx) {
        return super.visitStoredID(ctx);
    }

    @Override
    public Object visitString(AngularParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override
    public Object visitNumber(AngularParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    @Override
    public Object visitBoolean(AngularParser.BooleanContext ctx) {
        return super.visitBoolean(ctx);
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
