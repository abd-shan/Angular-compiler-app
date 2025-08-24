package visitors;

import css.Stylesheet;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import html.HtmlTemplate;
import program.AngularApp;
import program.ComponentFile;
import program.StateFile;
import state.*;
import ts.TypeScript;

import java.util.ArrayList;
import java.util.List;

public class AngularVisitor extends AngularParserBaseVisitor<Object> {



    public AngularApp visitAngularApp(AngularParser.AngularAppContext ctx) {
        AngularApp app = new AngularApp();


        for (AngularParser.AngularFileContext fileCtx : ctx.angularFile()) {
            ComponentFile file = visitAngularFile(fileCtx);
            app.addProgram(file);
        }

        return app;
    }

    @Override
    public ComponentFile visitAngularFile(AngularParser.AngularFileContext ctx) {
        if (ctx.componentFile() != null) {
            return (ComponentFile) visitComponentFile(ctx.componentFile());
        }


        //  stateFile
        return null;
    }

    @Override
    public StateFile visitStateFile(AngularParser.StateFileContext ctx) {
        StateFile stateFile = new StateFile();

        // ==== import statements ====
        for (AngularParser.ImportStatementContext impCtx : ctx.importStatement()) {
            String importStmt = (String) visitImportStatement(impCtx); //   String
            stateFile.addImport(importStmt);
        }

        // ====   interfaces, variables, actions, reducers, services ====
        for (AngularParser.StateInterfaceContext ifaceCtx : ctx.stateInterface()) {
            StateInterface iface = (StateInterface) visitStateInterface(ifaceCtx);
            stateFile.addInterface(iface);
        }

        for (AngularParser.StateVariableContext varCtx : ctx.stateVariable()) {
            StateVariable var = (StateVariable) visitStateVariable(varCtx);
            stateFile.addVariable(var);
        }

        for (AngularParser.StateActionContext actionCtx : ctx.stateAction()) {
            StateAction action = (StateAction) visitStateAction(actionCtx);
            stateFile.addAction(action);
        }

        for (AngularParser.StateReducerContext reducerCtx : ctx.stateReducer()) {
            StateReducer reducer = (StateReducer) visitStateReducer(reducerCtx);
            stateFile.addReducer(reducer);
        }

        for (AngularParser.StateServiceClassContext svcCtx : ctx.stateServiceClass()) {
            StateServiceClass service = (StateServiceClass) visitStateServiceClass(svcCtx);
            stateFile.addServiceClass(service);
        }

        return stateFile;
    }


    @Override
    public Object visitStateServiceClass(AngularParser.StateServiceClassContext ctx) {
        return super.visitStateServiceClass(ctx);
    }

    @Override
    public Object visitInjectableDecorator(AngularParser.InjectableDecoratorContext ctx) {
        return super.visitInjectableDecorator(ctx);
    }

    @Override
    public Object visitInjectableOptions(AngularParser.InjectableOptionsContext ctx) {
        return super.visitInjectableOptions(ctx);
    }

    @Override
    public Object visitStateInterface(AngularParser.StateInterfaceContext ctx) {
        return super.visitStateInterface(ctx);
    }

    @Override
    public Object visitStateInterfaceProperty(AngularParser.StateInterfacePropertyContext ctx) {
        return super.visitStateInterfaceProperty(ctx);
    }

    @Override
    public Object visitStateVariable(AngularParser.StateVariableContext ctx) {
        return super.visitStateVariable(ctx);
    }

    @Override
    public Object visitStateAction(AngularParser.StateActionContext ctx) {
        return super.visitStateAction(ctx);
    }

    @Override
    public Object visitStateReducer(AngularParser.StateReducerContext ctx) {
        return super.visitStateReducer(ctx);
    }

    @Override
    public Object visitReducerOnList(AngularParser.ReducerOnListContext ctx) {
        return super.visitReducerOnList(ctx);
    }

    public ComponentFile visitComponentFile(AngularParser.ComponentFileContext ctx) {
        //  selector
        String selector = ctx.STRING().getText().replace("\"", "").replace("'", "");


        boolean standalone = false;
        if (ctx.STANDALONE() != null) {
            standalone = ctx.TRUE() != null;
        }


        List<String> componentImports = new ArrayList<>();
        if (ctx.componentList() != null) {
            ctx.componentList().ID().forEach(id -> componentImports.add(id.getText()));
        }


        String className = ctx.ID(0).getText();


        HtmlTemplate template = null;
        Stylesheet styles = null;


        TypeScript tsCode = new TypeScript(); // placeholder

        return new ComponentFile(className, selector, standalone, componentImports, template, styles, tsCode);
    }

    @Override
    public Object visitProvidersOption(AngularParser.ProvidersOptionContext ctx) {
        return super.visitProvidersOption(ctx);
    }

    @Override
    public Object visitProviderList(AngularParser.ProviderListContext ctx) {
        return super.visitProviderList(ctx);
    }

    @Override
    public Object visitProvideStoreExpression(AngularParser.ProvideStoreExpressionContext ctx) {
        return super.visitProvideStoreExpression(ctx);
    }

    @Override
    public Object visitSimpleProvider(AngularParser.SimpleProviderContext ctx) {
        return super.visitSimpleProvider(ctx);
    }

    @Override
    public Object visitCssOption(AngularParser.CssOptionContext ctx) {
        return super.visitCssOption(ctx);
    }

    @Override
    public Object visitInlineTemplate(AngularParser.InlineTemplateContext ctx) {
        return super.visitInlineTemplate(ctx);
    }

    @Override
    public Object visitExternalTemplate(AngularParser.ExternalTemplateContext ctx) {
        return super.visitExternalTemplate(ctx);
    }

    @Override
    public Object visitImportStatement(AngularParser.ImportStatementContext ctx) {
        return super.visitImportStatement(ctx);
    }

    @Override
    public Object visitImportClause(AngularParser.ImportClauseContext ctx) {
        return super.visitImportClause(ctx);
    }

    @Override
    public Object visitDefaultImport(AngularParser.DefaultImportContext ctx) {
        return super.visitDefaultImport(ctx);
    }

    @Override
    public Object visitNamespaceImport(AngularParser.NamespaceImportContext ctx) {
        return super.visitNamespaceImport(ctx);
    }

    @Override
    public Object visitNamedImports(AngularParser.NamedImportsContext ctx) {
        return super.visitNamedImports(ctx);
    }

    @Override
    public Object visitImportSpecList(AngularParser.ImportSpecListContext ctx) {
        return super.visitImportSpecList(ctx);
    }

    @Override
    public Object visitImportSpecifier(AngularParser.ImportSpecifierContext ctx) {
        return super.visitImportSpecifier(ctx);
    }

    @Override
    public Object visitComponentList(AngularParser.ComponentListContext ctx) {
        return super.visitComponentList(ctx);
    }

    @Override
    public Object visitTs(AngularParser.TsContext ctx) {
        return super.visitTs(ctx);
    }

    @Override
    public Object visitTsStatement(AngularParser.TsStatementContext ctx) {
        return super.visitTsStatement(ctx);
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
    public Object visitStateDecl(AngularParser.StateDeclContext ctx) {
        return super.visitStateDecl(ctx);
    }

    @Override
    public Object visitStateProperty(AngularParser.StatePropertyContext ctx) {
        return super.visitStateProperty(ctx);
    }

    @Override
    public Object visitStateValue(AngularParser.StateValueContext ctx) {
        return super.visitStateValue(ctx);
    }

    @Override
    public Object visitArrayValue(AngularParser.ArrayValueContext ctx) {
        return super.visitArrayValue(ctx);
    }

    @Override
    public Object visitObjectValue(AngularParser.ObjectValueContext ctx) {
        return super.visitObjectValue(ctx);
    }

    @Override
    public Object visitConstructor(AngularParser.ConstructorContext ctx) {
        return super.visitConstructor(ctx);
    }

    @Override
    public Object visitConstructorParams(AngularParser.ConstructorParamsContext ctx) {
        return super.visitConstructorParams(ctx);
    }

    @Override
    public Object visitConstructorParam(AngularParser.ConstructorParamContext ctx) {
        return super.visitConstructorParam(ctx);
    }

    @Override
    public Object visitMethod(AngularParser.MethodContext ctx) {
        return super.visitMethod(ctx);
    }

    @Override
    public Object visitMethodParams(AngularParser.MethodParamsContext ctx) {
        return super.visitMethodParams(ctx);
    }

    @Override
    public Object visitMethodParam(AngularParser.MethodParamContext ctx) {
        return super.visitMethodParam(ctx);
    }

    @Override
    public Object visitParamType(AngularParser.ParamTypeContext ctx) {
        return super.visitParamType(ctx);
    }

    @Override
    public Object visitTsType(AngularParser.TsTypeContext ctx) {
        return super.visitTsType(ctx);
    }

    @Override
    public Object visitGenericOrBasicType(AngularParser.GenericOrBasicTypeContext ctx) {
        return super.visitGenericOrBasicType(ctx);
    }

    @Override
    public Object visitGenericType(AngularParser.GenericTypeContext ctx) {
        return super.visitGenericType(ctx);
    }

    @Override
    public Object visitGenericTypeParam(AngularParser.GenericTypeParamContext ctx) {
        return super.visitGenericTypeParam(ctx);
    }

    @Override
    public Object visitArrayType(AngularParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public Object visitType(AngularParser.TypeContext ctx) {
        return super.visitType(ctx);
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
    public Object visitAssign(AngularParser.AssignContext ctx) {
        return super.visitAssign(ctx);
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
    public Object visitReturnStatement(AngularParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Object visitExprStatement(AngularParser.ExprStatementContext ctx) {
        return super.visitExprStatement(ctx);
    }

    @Override
    public Object visitTernaryExpr(AngularParser.TernaryExprContext ctx) {
        return super.visitTernaryExpr(ctx);
    }

    @Override
    public Object visitOrExpr(AngularParser.OrExprContext ctx) {
        return super.visitOrExpr(ctx);
    }

    @Override
    public Object visitToAnd(AngularParser.ToAndContext ctx) {
        return super.visitToAnd(ctx);
    }

    @Override
    public Object visitLeftHandSide(AngularParser.LeftHandSideContext ctx) {
        return super.visitLeftHandSide(ctx);
    }

    @Override
    public Object visitToEq(AngularParser.ToEqContext ctx) {
        return super.visitToEq(ctx);
    }

    @Override
    public Object visitAndExpr(AngularParser.AndExprContext ctx) {
        return super.visitAndExpr(ctx);
    }

    @Override
    public Object visitToRel(AngularParser.ToRelContext ctx) {
        return super.visitToRel(ctx);
    }

    @Override
    public Object visitEqNeq(AngularParser.EqNeqContext ctx) {
        return super.visitEqNeq(ctx);
    }

    @Override
    public Object visitToAdd(AngularParser.ToAddContext ctx) {
        return super.visitToAdd(ctx);
    }

    @Override
    public Object visitRelational(AngularParser.RelationalContext ctx) {
        return super.visitRelational(ctx);
    }

    @Override
    public Object visitAddSub(AngularParser.AddSubContext ctx) {
        return super.visitAddSub(ctx);
    }

    @Override
    public Object visitToMul(AngularParser.ToMulContext ctx) {
        return super.visitToMul(ctx);
    }

    @Override
    public Object visitToUnary(AngularParser.ToUnaryContext ctx) {
        return super.visitToUnary(ctx);
    }

    @Override
    public Object visitMulDiv(AngularParser.MulDivContext ctx) {
        return super.visitMulDiv(ctx);
    }

    @Override
    public Object visitUnaryOp(AngularParser.UnaryOpContext ctx) {
        return super.visitUnaryOp(ctx);
    }

    @Override
    public Object visitToPrimary(AngularParser.ToPrimaryContext ctx) {
        return super.visitToPrimary(ctx);
    }

    @Override
    public Object visitTsPrimary(AngularParser.TsPrimaryContext ctx) {
        return super.visitTsPrimary(ctx);
    }

    @Override
    public Object visitThisRef(AngularParser.ThisRefContext ctx) {
        return super.visitThisRef(ctx);
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
    public Object visitBooleanTrue(AngularParser.BooleanTrueContext ctx) {
        return super.visitBooleanTrue(ctx);
    }

    @Override
    public Object visitBooleanFalse(AngularParser.BooleanFalseContext ctx) {
        return super.visitBooleanFalse(ctx);
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
    public Object visitParen(AngularParser.ParenContext ctx) {
        return super.visitParen(ctx);
    }

    @Override
    public Object visitArrowFn(AngularParser.ArrowFnContext ctx) {
        return super.visitArrowFn(ctx);
    }

    @Override
    public Object visitNull(AngularParser.NullContext ctx) {
        return super.visitNull(ctx);
    }

    @Override
    public Object visitNewExpression(AngularParser.NewExpressionContext ctx) {
        return super.visitNewExpression(ctx);
    }

    @Override
    public Object visitDotCall(AngularParser.DotCallContext ctx) {
        return super.visitDotCall(ctx);
    }

    @Override
    public Object visitDotAccess(AngularParser.DotAccessContext ctx) {
        return super.visitDotAccess(ctx);
    }

    @Override
    public Object visitBracketAccess(AngularParser.BracketAccessContext ctx) {
        return super.visitBracketAccess(ctx);
    }

    @Override
    public Object visitCall(AngularParser.CallContext ctx) {
        return super.visitCall(ctx);
    }

    @Override
    public Object visitGenericTypeArguments(AngularParser.GenericTypeArgumentsContext ctx) {
        return super.visitGenericTypeArguments(ctx);
    }

    @Override
    public Object visitSpreadOrExpr(AngularParser.SpreadOrExprContext ctx) {
        return super.visitSpreadOrExpr(ctx);
    }

    @Override
    public Object visitArrowFunction(AngularParser.ArrowFunctionContext ctx) {
        return super.visitArrowFunction(ctx);
    }

    @Override
    public Object visitKeyValuePair(AngularParser.KeyValuePairContext ctx) {
        return super.visitKeyValuePair(ctx);
    }

    @Override
    public Object visitPrimitiveDataType(AngularParser.PrimitiveDataTypeContext ctx) {
        return super.visitPrimitiveDataType(ctx);
    }

    @Override
    public Object visitHtml(AngularParser.HtmlContext ctx) {
        return super.visitHtml(ctx);
    }

    @Override
    public Object visitNode(AngularParser.NodeContext ctx) {
        return super.visitNode(ctx);
    }

    @Override
    public Object visitInterpolation(AngularParser.InterpolationContext ctx) {
        return super.visitInterpolation(ctx);
    }

    @Override
    public Object visitTextNode(AngularParser.TextNodeContext ctx) {
        return super.visitTextNode(ctx);
    }

    @Override
    public Object visitElement(AngularParser.ElementContext ctx) {
        return super.visitElement(ctx);
    }

    @Override
    public Object visitHtmlAttribute(AngularParser.HtmlAttributeContext ctx) {
        return super.visitHtmlAttribute(ctx);
    }

    @Override
    public Object visitNgForDirective(AngularParser.NgForDirectiveContext ctx) {
        return super.visitNgForDirective(ctx);
    }

    @Override
    public Object visitNgIfDirective(AngularParser.NgIfDirectiveContext ctx) {
        return super.visitNgIfDirective(ctx);
    }

    @Override
    public Object visitCss(AngularParser.CssContext ctx) {
        return super.visitCss(ctx);
    }

    @Override
    public Object visitCssDeclaration(AngularParser.CssDeclarationContext ctx) {
        return super.visitCssDeclaration(ctx);
    }
}
