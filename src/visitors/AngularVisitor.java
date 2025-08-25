package visitors;

import component.ProvideStoreExpression;
import component.ProviderExpression;
import component.ProvidersOption;
import component.SimpleProvider;
import css.ExternalStyle;
import css.InlineStyles;
import css.StylesOption;
import css.Stylesheet;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import helper.ProviderList;
import html.ExternalTemplate;
import html.HtmlOption;
import html.HtmlTemplate;
import html.InlineTemplate;
import importStatement.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import program.AngularApp;
import program.AngularFile;
import program.ComponentFile;
import program.StateFile;
import state.*;
import ts.TypeScript;
import ts.stateManagement.StateProperty;
import ts.stateManagement.StateValue;
import ts.stateManagement.ValueType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AngularVisitor extends AngularParserBaseVisitor<Object> {



    @Override
    public AngularApp visitAngularApp(AngularParser.AngularAppContext ctx) {
        AngularApp app = new AngularApp();

        for (AngularParser.AngularFileContext fileCtx : ctx.angularFile()) {
            AngularFile file = visitAngularFile(fileCtx); //    ComponentFile or StateFile
            app.addFile( file);
        }

        return app;
    }

    @Override
    public AngularFile visitAngularFile(AngularParser.AngularFileContext ctx) {
        if (ctx.componentFile() != null) {
            return visitComponentFile(ctx.componentFile()); // ComponentFile
        }

        if (ctx.stateFile() != null) {
            return visitStateFile(ctx.stateFile()); // StateFile
        }

        return null;
    }


    @Override
    public StateFile visitStateFile(AngularParser.StateFileContext ctx) {
        StateFile stateFile = new StateFile();

        // ==== import statements ====

        for (AngularParser.ImportStatementContext impCtx : ctx.importStatement()) {
            String importStmt = String.valueOf(visitImportStatement(impCtx)); //   String
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
        //  injectable decorator
        InjectableDecorator injectableDecorator = null;
        if (ctx.injectableDecorator() != null) {
            injectableDecorator = (InjectableDecorator) visitInjectableDecorator(ctx.injectableDecorator());
        }

        String className = ctx.ID().getText();

        String tsCode = ctx.ts().getText();

        boolean isExported = ctx.EXPORT() != null;

        return new StateServiceClass(injectableDecorator,className, tsCode, isExported );
    }

    @Override
    public Object visitInjectableDecorator(AngularParser.InjectableDecoratorContext ctx) {
        InjectableOptions options = null;
        if (ctx.injectableOptions() != null) {
            options = (InjectableOptions) visitInjectableOptions(ctx.injectableOptions());
        }

        return new InjectableDecorator(options);
    }

    @Override
    public Object visitInjectableOptions(AngularParser.InjectableOptionsContext ctx) {
        String providedIn = ctx.STRING().getText();
        return new InjectableOptions(providedIn);
    }

    @Override
    public Object visitStateInterface(AngularParser.StateInterfaceContext ctx) {
        String interfaceName = ctx.ID().getText();
        boolean isExported = ctx.EXPORT() != null;

        StateInterface stateInterface = new StateInterface(interfaceName, isExported);


        for (AngularParser.StateInterfacePropertyContext propCtx : ctx.stateInterfaceProperty()) {
            StateInterfaceProperty property = (StateInterfaceProperty) visitStateInterfaceProperty(propCtx);
            stateInterface.addProperty(property);
        }

        return stateInterface;
    }

    @Override
    public Object visitStateInterfaceProperty(AngularParser.StateInterfacePropertyContext ctx) {
        String propertyName = ctx.ID().getText();
        String propertyType = ctx.tsType().getText();

        return new StateInterfaceProperty(propertyName, propertyType);
    }

    @Override
    public Object visitStateVariable(AngularParser.StateVariableContext ctx) {
        String variableName = ctx.ID(0).getText();
        String variableType = ctx.ID(1).getText();
        boolean isExported = ctx.EXPORT() != null;
        boolean isConst = ctx.CONST() != null;
        Object value = visitObjectValue(ctx.objectValue());

        return new StateVariable(variableName, variableType, value, isExported, isConst);
    }

    @Override
    public Object visitStateAction(AngularParser.StateActionContext ctx) {
        String actionName = ctx.ID().getText();
        boolean isExported = ctx.EXPORT() != null;
        boolean isConst = ctx.CONST() != null;
        String actionString = ctx.STRING().getText();

        String expression = null;
        if (ctx.tsExpr() != null) {
            expression = ctx.tsExpr().getText();
        }

        return new StateAction(actionName, actionString, expression, isExported, isConst);
    }

    @Override
    public Object visitStateReducer(AngularParser.StateReducerContext ctx) {
        String reducerName = ctx.ID(0).getText();
        String initialState = ctx.ID(1).getText();
        boolean isExported = ctx.EXPORT() != null;
        boolean isConst = ctx.CONST() != null;

        StateReducer reducer = new StateReducer(reducerName, initialState, isExported, isConst);

        //  reducerOnList
        ReducerOnList onList = (ReducerOnList) visitReducerOnList(ctx.reducerOnList());
        for (ReducerOn on : onList.getOnList()) {
            reducer.addOn(on);
        }

        return reducer;
    }

    @Override
    public Object visitReducerOnList(AngularParser.ReducerOnListContext ctx) {
        ReducerOnList onList = new ReducerOnList();

        for (int i = 0; i < ctx.ID().size(); i++) {
            String action = ctx.ID(i).getText();
            String arrowFunction = ctx.arrowFunction(i).getText();

            onList.addOn(new ReducerOn(action, arrowFunction));
        }

        return onList;
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
        // providers option
        ProvidersOption providersOption = null;
        if (ctx.providersOption() != null) {
            providersOption = visitProvidersOption(ctx.providersOption());
        }


        TypeScript tsCode = new TypeScript(); // placeholder

        return new ComponentFile(className, selector, standalone, componentImports, template, styles,providersOption, tsCode);
    }

    @Override
    public ProvidersOption visitProvidersOption(AngularParser.ProvidersOptionContext ctx) {
        if (ctx == null) {
            return null;
        }

        ProviderList providerList = (ProviderList) visitProviderList(ctx.providerList());
        return new ProvidersOption(providerList.getProviders());
    }

    @Override
    public ProviderList visitProviderList(AngularParser.ProviderListContext ctx) {
        ProviderList providerList = new ProviderList();

        if (ctx != null) {
            for (AngularParser.ProviderExpressionContext exprCtx : ctx.providerExpression()) {
                ProviderExpression provider = (ProviderExpression) visit(exprCtx);
                if (provider != null) {
                    providerList.addProvider(provider);
                }
            }
        }

        return providerList;
    }

    @Override
    public ProviderExpression visitProvideStoreExpression(AngularParser.ProvideStoreExpressionContext ctx) {
        String functionName = ctx.ID(0).getText();
        String configKey = ctx.ID(1).getText();
        String configValue = ctx.ID(2).getText();

        return new ProvideStoreExpression(functionName, configKey, configValue);
    }

    @Override
    public ProviderExpression visitSimpleProvider(AngularParser.SimpleProviderContext ctx) {
        return new SimpleProvider(ctx.ID().getText());
    }

    @Override
    public StylesOption visitCssOption(AngularParser.CssOptionContext ctx) {
        if (ctx.STYLES() != null) {
            // Inline styles
            String cssContent = ctx.css() != null ? ctx.css().getText() : "";
            return new InlineStyles(cssContent);
        } else if (ctx.STYLES_URL() != null) {
            // External styles
            String stylesUrl = ctx.STRING().getText();
            return new ExternalStyle(stylesUrl);
        }

        return null;
    }

    @Override
    public HtmlOption visitInlineTemplate(AngularParser.InlineTemplateContext ctx) {
        String htmlContent = ctx.html() != null ? ctx.html().getText() : "";
        return new InlineTemplate(htmlContent);
    }

    @Override
    public HtmlOption visitExternalTemplate(AngularParser.ExternalTemplateContext ctx) {
        return new ExternalTemplate(ctx.STRING().getText());
    }

    @Override
    public ImportStatement visitImportStatement(AngularParser.ImportStatementContext ctx) {
        ImportClause clause = (ImportClause) visitImportClause(ctx.importClause());
        String modulePath = ctx.STRING().getText();

        return new ImportStatement(clause, modulePath);
    }

    @Override
    public ImportClause visitImportClause(AngularParser.ImportClauseContext ctx) {
        if (ctx.defaultImport() != null) {
            DefaultImport defaultImport = (DefaultImport) visitDefaultImport(ctx.defaultImport());

            if (ctx.namespaceImport() != null) {
                NamespaceImport namespaceImport = (NamespaceImport) visitNamespaceImport(ctx.namespaceImport());
                return new DefaultImportClause(defaultImport.getImportName(), namespaceImport, null);
            } else if (ctx.namedImports() != null) {
                NamedImports namedImports = (NamedImports) visitNamedImports(ctx.namedImports());
                return new DefaultImportClause(defaultImport.getImportName(), null, namedImports);
            } else {
                return new DefaultImportClause(defaultImport.getImportName(), null, null);
            }
        } else if (ctx.namespaceImport() != null) {
            NamespaceImport namespaceImport = (NamespaceImport) visitNamespaceImport(ctx.namespaceImport());
            return new NamespaceImportClause(namespaceImport);
        } else if (ctx.namedImports() != null) {
            NamedImports namedImports = (NamedImports) visitNamedImports(ctx.namedImports());
            return new NamedImportsClause(namedImports);
        }

        return null;
    }

    @Override
    public DefaultImport visitDefaultImport(AngularParser.DefaultImportContext ctx) {
        String importName = ctx.getText();
        return new DefaultImport(importName);
    }

    @Override
    public NamespaceImport visitNamespaceImport(AngularParser.NamespaceImportContext ctx) {
        String namespaceName = ctx.ID().getText();
        return new NamespaceImport(namespaceName);
    }

    @Override
    public NamedImports visitNamedImports(AngularParser.NamedImportsContext ctx) {
        if (ctx.importSpecList() != null) {
            return (NamedImports) visitImportSpecList(ctx.importSpecList());
        }
        return new NamedImports(new ArrayList<>());
    }

    @Override
    public NamedImports visitImportSpecList(AngularParser.ImportSpecListContext ctx) {
        List<ImportSpecifier> specifiers = new ArrayList<>();

        for (AngularParser.ImportSpecifierContext specCtx : ctx.importSpecifier()) {
            ImportSpecifier specifier = (ImportSpecifier) visitImportSpecifier(specCtx);
            specifiers.add(specifier);
        }

        return new NamedImports(specifiers);
    }

    @Override
    public ImportSpecifier visitImportSpecifier(AngularParser.ImportSpecifierContext ctx) {
        String imported = visitDefaultImport(ctx.defaultImport(0)).getImportName();
        String alias = null;

        if (ctx.AS() != null && ctx.defaultImport().size() > 1) {
            alias = visitDefaultImport(ctx.defaultImport(1)).getImportName();
        }

        return new ImportSpecifier(imported, alias);
    }

    @Override
    public List<String> visitComponentList(AngularParser.ComponentListContext ctx) {
        List<String> components = new ArrayList<>();

        for (TerminalNode idNode : ctx.ID()) {
            components.add(idNode.getText());
        }

        return components;
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

    /**
     * ObjectStateValue - يمثل قيمة كائن تحتوي على خصائص أخرى
     */
    public class ObjectStateValue implements StateValue {
        private final List<StateProperty> properties;

        public ObjectStateValue(List<StateProperty> properties) {
            this.properties = properties != null ? new ArrayList<>(properties) : new ArrayList<>();
        }

        @Override
        public ValueType getType() {
            return ValueType.OBJECT;
        }

        public List<StateProperty> getProperties() {
            return Collections.unmodifiableList(properties);
        }

        public void addProperty(StateProperty property) {
            if (property != null) {
                properties.add(property);
            }
        }

        public StateProperty getProperty(String name) {
            return properties.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < properties.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(properties.get(i).toString());
            }
            sb.append("}");
            return sb.toString();
        }

        @Override
        public String toCodeString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < properties.size(); i++) {
                if (i > 0) sb.append(", ");
                StateProperty prop = properties.get(i);
                sb.append(prop.getName()).append(": ").append(prop.getValue().toCodeString());
            }
            sb.append("}");
            return sb.toString();
        }
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
