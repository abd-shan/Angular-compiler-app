package visitors;

import ast.component.ProvideStoreExpression;
import ast.component.ProviderExpression;
import ast.component.ProvidersOption;
import ast.component.SimpleProvider;
import ast.css.ExternalStyle;
import ast.css.InlineStyles;
import ast.css.StylesOption;
import ast.program.*;
import ast.router.RouteElement;
import gen.AngularLexer;
import gen.AngularParser;
import gen.AngularParserBaseVisitor;
import helper.ProviderList;
import helper.TsStatementBlock;
import ast.html.*;
import ast.html.attribute.*;
import ast.html.element.ElementNode;
import ast.html.element.InterpolationNode;
import ast.html.element.TextNode;
import ast.importStatement.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import ast.state.*;
import ast.ts.expressions.*;
import ast.ts.stateManagement.*;
import ast.ts.statements.*;
import ast.ts.stmt.*;
import ast.ts.types.*;

import java.util.ArrayList;
import java.util.List;

import symbolTable.SymbolTable;
import symbolTable.RouterSymbolTable;

public class AngularVisitor extends AngularParserBaseVisitor<Object> {

	private final SymbolTable tsSymbolTable = new SymbolTable();
	private final SymbolTable templateSymbolTable = new SymbolTable();
	private int templateBindingCounter = 0;
	private final RouterSymbolTable routerSymbolTable = new RouterSymbolTable();

	private final CharStream input;

	public AngularVisitor(CharStream input) {
		this.input = input;
	}

	public AngularVisitor() {
		this.input = null;
	}

	public SymbolTable getTsSymbolTable() {
		return tsSymbolTable;
	}

	public SymbolTable getTemplateSymbolTable() { return templateSymbolTable; }

	public RouterSymbolTable getRouterSymbolTable() { return routerSymbolTable; }

	private String getOriginalText(org.antlr.v4.runtime.ParserRuleContext ctx) {
		if (ctx == null) return "";
		if (input == null) return ctx.getText();
		int start = ctx.getStart().getStartIndex();
		int stop = ctx.getStop().getStopIndex();
		return input.getText(new org.antlr.v4.runtime.misc.Interval(start, stop));
	}

	@Override
	public AngularApp visitAngularApp(AngularParser.AngularAppContext ctx) {
		AngularApp app = new AngularApp();

		// Global TS scope
		tsSymbolTable.enterScope("<ast.program>");
		// Global Template scope root
		templateSymbolTable.enterScope("<templates>");

		for (AngularParser.AngularFileContext fileCtx : ctx.angularFile()) {
			AngularFile file = visitAngularFile(fileCtx); //    ComponentFile or StateFile
			app.addFile(file);
		}

		// keep ast.program/template root scopes as current
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

        if (ctx.routeFile() != null) {
            return visitRouteFile(ctx.routeFile()); // RouteFile
        }

        return null;
    }

    @Override
    public RouteFile visitRouteFile(AngularParser.RouteFileContext ctx) {
        RouteFile routeFile = new RouteFile();

        tsSymbolTable.enterScope("routeFile");

        // imports
        for (AngularParser.ImportStatementContext impCtx : ctx.importStatement()) {
            String importStmt = String.valueOf(visitImportStatement(impCtx));
            routeFile.addImport(importStmt);
        }

        // routes
        List<AngularParser.RouteObjectContext> objs = ctx.routeObject();
        for (AngularParser.RouteObjectContext objCtx : objs) {
            RouteElement elem = visitRouteObject(objCtx);
            if (elem != null) {
                routeFile.addRoute(elem);


                routerSymbolTable.addRoute(elem.getPath(), elem.getComponent());
            }
        }

        tsSymbolTable.exitScope();
        return routeFile;
    }


    public RouteElement visitRouteObject(AngularParser.RouteObjectContext ctx) {
        String path = null;
        String component = null;

        for (AngularParser.RoutePropertyContext propCtx : ctx.routeProperty()) {
            String key = propCtx.ID().getText();
            String rawValue = propCtx.tsExpr().getText();

            if ("path".equals(key)) {
                if (rawValue.startsWith("\"") || rawValue.startsWith("'")) {
                    path = rawValue.substring(1, rawValue.length() - 1);
                } else {
                    path = rawValue;
                }
            } else if ("component".equals(key)) {
                component = rawValue;
            }
        }

        if (path != null && component != null) {
            return new RouteElement(path, component);
        }
        return null;
    }


    @Override
    public StateFile visitStateFile(AngularParser.StateFileContext ctx) {
        StateFile stateFile = new StateFile();

		// file scope
		tsSymbolTable.enterScope("stateFile");

		// ==== import statements ====

		for (AngularParser.ImportStatementContext impCtx : ctx.importStatement()) {
			String importStmt = String.valueOf(visitImportStatement(impCtx)); //   String
			stateFile.addImport(importStmt);
		}

		// ====   interfaces, variables, actions, reducers, services ====

		for (AngularParser.StateInterfaceContext ifaceCtx : ctx.stateInterface()) {
			StateInterface iface = (StateInterface) visitStateInterface(ifaceCtx);
			stateFile.addInterface(iface);
			if (iface != null) {
				tsSymbolTable.define(iface.getName(), "interface");
			}
		}

		for (AngularParser.StateVariableContext varCtx : ctx.stateVariable()) {
			StateVariable var = (StateVariable) visitStateVariable(varCtx);
			stateFile.addVariable(var);
			if (var != null) {
				tsSymbolTable.define(var.getName(), "variable");
			}
		}

		for (AngularParser.StateActionContext actionCtx : ctx.stateAction()) {
			StateAction action = (StateAction) visitStateAction(actionCtx);
			stateFile.addAction(action);
			if (action != null) {
				tsSymbolTable.define(action.getName(), "action");
			}
		}

		for (AngularParser.StateReducerContext reducerCtx : ctx.stateReducer()) {
			StateReducer reducer = (StateReducer) visitStateReducer(reducerCtx);
			stateFile.addReducer(reducer);
			if (reducer != null) {
				tsSymbolTable.define(reducer.getName(), "reducer");
			}
		}

		for (AngularParser.StateServiceClassContext svcCtx : ctx.stateServiceClass()) {
			StateServiceClass service = (StateServiceClass) visitStateServiceClass(svcCtx);
			stateFile.addServiceClass(service);
			if (service != null) {
				tsSymbolTable.define(service.getClassName(), "class");
			}
		}

		tsSymbolTable.exitScope();
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

		// class scope
		tsSymbolTable.enterScope(className);

		TsBlock tsBlock = visitTs(ctx.ts());

		boolean isExported = ctx.EXPORT() != null;

		tsSymbolTable.exitScope();
		return new StateServiceClass(injectableDecorator, className, tsBlock, isExported);
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
		return new InjectableOptions(unquote(providedIn));
	}

	@Override
	public Object visitStateInterface(AngularParser.StateInterfaceContext ctx) {
		String interfaceName = ctx.ID().getText();
		boolean isExported = ctx.EXPORT() != null;

		StateInterface stateInterface = new StateInterface(interfaceName, isExported);

		for (AngularParser.StateInterfacePropertyContext propCtx : ctx.stateInterfaceProperty()) {
			StateInterfaceProperty property = (StateInterfaceProperty) visitStateInterfaceProperty(propCtx);
			stateInterface.addProperty(property);
			if (property != null) {
				tsSymbolTable.define(interfaceName + "." + property.getName(), "property");
			}
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
		String actionString = unquote(ctx.STRING().getText());

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
	public ComponentFile visitComponentFile(AngularParser.ComponentFileContext ctx) {
		if (ctx == null) {
			return new ComponentFile("", "", false, new ArrayList<>(),
					new HtmlDocument(), null, null, new TsBlock(new ArrayList<>()));
		}

		// selector
		String selector = "";
		if (ctx.STRING() != null) {
			selector = ctx.STRING().getText().replace("\"", "").replace("'", "");
		}

		boolean standalone = false;
		if (ctx.STANDALONE() != null) {
			standalone = ctx.TRUE() != null;
		}

		List<String> componentImports = new ArrayList<>();
		if (ctx.componentList() != null) {
			for (TerminalNode idNode : ctx.componentList().ID()) {
				componentImports.add(idNode.getText());
			}
		}

		String className = "";
		if (!ctx.ID().isEmpty()) {
			className = ctx.ID(0).getText();
		}

		HtmlDocument template = new HtmlDocument();
		String styles = getOriginalText(ctx.cssOption().css());

		// providers option
		ProvidersOption providersOption = null;
		if (ctx.providersOption() != null) {
			providersOption = visitProvidersOption(ctx.providersOption());
		}

		// class scope for ast.component
		tsSymbolTable.enterScope(className);

		TsBlock tsBlock = new TsBlock(new ArrayList<>());
		if (ctx.ts() != null) {
			tsBlock = visitTs(ctx.ts());
		}

		// template scope for this ast.component
		templateSymbolTable.enterScope(className);
		templateBindingCounter = 0;


		if (ctx.htmlOption() != null) {
			template = processHtmlOption(ctx.htmlOption());
		}

		templateSymbolTable.exitScope();
		tsSymbolTable.exitScope();
		return new ComponentFile(className, selector, standalone, componentImports,
				template, styles, providersOption, tsBlock);
	}

	private HtmlDocument processHtmlOption(AngularParser.HtmlOptionContext ctx) {
		if (ctx instanceof AngularParser.InlineTemplateContext) {
			return visitInlineTemplate((AngularParser.InlineTemplateContext) ctx);
		} else if (ctx instanceof AngularParser.ExternalTemplateContext) {
			return visitExternalTemplate((AngularParser.ExternalTemplateContext) ctx);
		}
		return new HtmlDocument();
	}

	@Override
	public HtmlDocument visitInlineTemplate(AngularParser.InlineTemplateContext ctx) {
		if (ctx.html() != null) {
			return (HtmlDocument) visitHtml(ctx.html());
		}
		return new HtmlDocument();
	}

	@Override
	public HtmlDocument visitExternalTemplate(AngularParser.ExternalTemplateContext ctx) {

		return new HtmlDocument();
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
			String cssContent = ctx.css() != null ? getOriginalText(ctx.css()) : "";
			return new InlineStyles(cssContent);
		} else if (ctx.STYLES_URL() != null) {
			// External styles
			String stylesUrl = ctx.STRING().getText();
			return new ExternalStyle(stylesUrl);
		}

		return null;
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
		List<ImportSpecifier> specifiers = new ArrayList<>();
		if (ctx.importSpecList() != null) {
			for (AngularParser.ImportSpecifierContext specCtx : ctx.importSpecList().importSpecifier()) {
				ImportSpecifier spec = (ImportSpecifier) visitImportSpecifier(specCtx);
				if (spec != null) specifiers.add(spec);
			}
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
	public TsBlock visitTs(AngularParser.TsContext ctx) {
		if (ctx == null) {
			return new TsBlock(new ArrayList<>());
		}

		TsStatement statement = (TsStatement) visitTsStatement(ctx.tsStatement());
		List<TsStatement> statements = new ArrayList<>();

		if (statement != null) {
			statements.add(statement);
		}

		return new TsBlock(statements);
	}

	@Override
	public TsStatement visitTsStatement(AngularParser.TsStatementContext ctx) {
		if (ctx == null) {
			return null;
		}

		List<TsStatement> statements = new ArrayList<>();

		// Iterate children in source order to avoid duplicating before/after constructor lists
		for (var child : ctx.children) {
			TsStatement statement = null;

			if (child instanceof AngularParser.TsAttributeContext attrCtx) {
				statement = (TsStatement) visit(attrCtx);
				if (statement instanceof DeclareAttribute da) {
					tsSymbolTable.define(da.getName(), "field");
				} else if (statement instanceof DeclareAndAssignAttribute daa) {
					tsSymbolTable.define(daa.getName(), "field");
				}
			} else if (child instanceof AngularParser.StateDeclContext stateDeclCtx) {
				statement = (TsStatement) visitStateDecl(stateDeclCtx);
			} else if (child instanceof AngularParser.MethodContext methodCtx) {
				statement = (TsStatement) visitMethod(methodCtx);
				if (statement instanceof Method m) {
					tsSymbolTable.define(m.getName(), "method");
				}
			} else if (child instanceof AngularParser.ConstructorContext ctorCtx) {
				statement = (TsStatement) visitConstructor(ctorCtx);
				if (statement instanceof Constructor) {
					tsSymbolTable.define("constructor", "constructor");
				}
			}

			if (statement != null) {
				statements.add(statement);
			}
		}

		if (statements.isEmpty()) {
			return null;
		} else if (statements.size() == 1) {
			return statements.get(0);
		} else {
			return new TsStatementBlock(statements);
		}
	}

	@Override
	public TsAttribute visitDeclareAttribute(AngularParser.DeclareAttributeContext ctx) {
		if (ctx == null) {
			return null;
		}

		String primitiveDataType = extractPrimitiveDataType(ctx.primitiveDataType());
		boolean isReadonly = isReadonly(ctx.primitiveDataType());
		String name = ctx.ID().getText();
		TsType type = (TsType) visitTsType(ctx.tsType());

		return new DeclareAttribute(name, primitiveDataType, type, isReadonly);
	}

	@Override
	public TsAttribute visitDeclareAndAssignAttribute(AngularParser.DeclareAndAssignAttributeContext ctx) {
		if (ctx == null) {
			return null;
		}

		String primitiveDataType = extractPrimitiveDataType(ctx.primitiveDataType());
		boolean isReadonly = isReadonly(ctx.primitiveDataType());
		String name = ctx.ID().getText();
		TsType type = ctx.tsType() != null ? (TsType) visitTsType(ctx.tsType()) : null;
		TsExpression expression = ctx.tsExpr() != null ? (TsExpression) visitTsExpr(ctx.tsExpr()) : null;

		return new DeclareAndAssignAttribute(name, primitiveDataType, type, isReadonly, expression);
	}

	@Override
	public StateDeclaration visitStateDecl(AngularParser.StateDeclContext ctx) {
		if (ctx == null) {
			return null;
		}

		List<StateProperty> properties = new ArrayList<>();

		if (ctx.stateProperty() != null) {
			for (AngularParser.StatePropertyContext propCtx : ctx.stateProperty()) {
				StateProperty property = (StateProperty) visitStateProperty(propCtx);
				if (property != null) {
					properties.add(property);
				}
			}
		}

		return new StateDeclaration(properties);
	}

	@Override
	public StateProperty visitStateProperty(AngularParser.StatePropertyContext ctx) {
		if (ctx == null) {
			return null;
		}

		String name = ctx.ID().getText();
		StateValue value = (StateValue) visitStateValue(ctx.stateValue());

		return new StateProperty(name, value);
	}

	@Override
	public StateValue visitStateValue(AngularParser.StateValueContext ctx) {
		if (ctx == null) {
			return null;
		}

		if (ctx.arrayValue() != null) {
			return (StateValue) visitArrayValue(ctx.arrayValue());
		} else if (ctx.objectValue() != null) {
			return (StateValue) visitObjectValue(ctx.objectValue());
		} else if (ctx.STRING() != null) {
			return new PrimitiveStateValue(ctx.STRING().getText(), ValueType.STRING);
		} else if (ctx.NUMERIC_VALUE() != null) {
			return new PrimitiveStateValue(ctx.NUMERIC_VALUE().getText(), ValueType.NUMBER);
		} else if (ctx.NULL() != null) {
			return new PrimitiveStateValue("null", ValueType.NULL);
		} else if (ctx.ID() != null) {
			return new PrimitiveStateValue(ctx.ID().getText(), ValueType.IDENTIFIER);
		}

		return null;
	}

	@Override
	public ArrayStateValue visitArrayValue(AngularParser.ArrayValueContext ctx) {
		if (ctx == null) {
			return null;
		}

		List<StateValue> values = new ArrayList<>();

		if (ctx.stateValue() != null) {
			for (AngularParser.StateValueContext valueCtx : ctx.stateValue()) {
				StateValue value = (StateValue) visitStateValue(valueCtx);
				if (value != null) {
					values.add(value);
				}
			}
		}

		return new ArrayStateValue(values);
	}

	@Override
	public ObjectStateValue visitObjectValue(AngularParser.ObjectValueContext ctx) {
		if (ctx == null) {
			return null;
		}

		List<StateProperty> properties = new ArrayList<>();

		if (ctx.stateProperty() != null) {
			for (AngularParser.StatePropertyContext propCtx : ctx.stateProperty()) {
				StateProperty property = (StateProperty) visitStateProperty(propCtx);
				if (property != null) {
					properties.add(property);
				}
			}
		}

		return new ObjectStateValue(properties);
	}

	@Override
	public Constructor visitConstructor(AngularParser.ConstructorContext ctx) {
		if (ctx == null) {
			return null;
		}

		String primitiveDataType = extractPrimitiveDataType(ctx.primitiveDataType());
		List<ConstructorParam> parameters = new ArrayList<>();
		TsBlock body = null;

		if (ctx.constructorParams() != null) {
			parameters = (List<ConstructorParam>) visitConstructorParams(ctx.constructorParams());
		}

		if (ctx.tsStmt() != null) {
			List<TsStatement> statements = new ArrayList<>();
			for (AngularParser.TsStmtContext stmtCtx : ctx.tsStmt()) {
				TsStatement statement = (TsStatement) visitTsStmt(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
			body = new TsBlock(statements);
		}

		return new Constructor(parameters, body, primitiveDataType);
	}

	@Override
	public List<ConstructorParam> visitConstructorParams(AngularParser.ConstructorParamsContext ctx) {
		List<ConstructorParam> parameters = new ArrayList<>();

		if (ctx == null) {
			return parameters;
		}

		for (AngularParser.ConstructorParamContext paramCtx : ctx.constructorParam()) {
			ConstructorParam param = (ConstructorParam) visitConstructorParam(paramCtx);
			if (param != null) {
				parameters.add(param);
				tsSymbolTable.define(param.getName(), "param");
			}
		}

		return parameters;
	}

	@Override
	public ConstructorParam visitConstructorParam(AngularParser.ConstructorParamContext ctx) {
		if (ctx == null) {
			return null;
		}

		String primitiveDataType = extractPrimitiveDataType(ctx.primitiveDataType());
		String name = ctx.ID().getText();
		TsType type = (TsType) visitTsType(ctx.tsType());

		return new ConstructorParam(name, primitiveDataType, type);
	}

	@Override
	public Method visitMethod(AngularParser.MethodContext ctx) {
		if (ctx == null) {
			return null;
		}

		String primitiveDataType = extractPrimitiveDataType(ctx.primitiveDataType());
		String name = ctx.ID().getText();
		List<MethodParam> parameters = new ArrayList<>();
		TsType returnType = null;
		TsBlock body = null;

		// method scope
		tsSymbolTable.enterScope(name);

		if (ctx.methodParams() != null) {
			parameters = (List<MethodParam>) visitMethodParams(ctx.methodParams());
		}

		if (ctx.tsType() != null) {
			returnType = (TsType) visitTsType(ctx.tsType());
		}

		if (ctx.tsStmt() != null) {
			List<TsStatement> statements = new ArrayList<>();
			for (AngularParser.TsStmtContext stmtCtx : ctx.tsStmt()) {
				TsStatement statement = (TsStatement) visitTsStmt(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
			body = new TsBlock(statements);
		}

		tsSymbolTable.exitScope();
		return new Method(name, primitiveDataType, parameters, returnType, body);
	}

	@Override
	public List<MethodParam> visitMethodParams(AngularParser.MethodParamsContext ctx) {
		List<MethodParam> parameters = new ArrayList<>();

		if (ctx == null) {
			return parameters;
		}

		for (AngularParser.MethodParamContext paramCtx : ctx.methodParam()) {
			MethodParam param = (MethodParam) visitMethodParam(paramCtx);
			if (param != null) {
				parameters.add(param);
				tsSymbolTable.define(param.getName(), "param");
			}
		}

		return parameters;
	}

	@Override
	public MethodParam visitMethodParam(AngularParser.MethodParamContext ctx) {
		if (ctx == null) {
			return null;
		}

		String name = ctx.ID().getText();
		boolean isOptional = ctx.QUESTION() != null;
		ParamType paramType = (ParamType) visitParamType(ctx.paramType());

		return new MethodParam(name, paramType, isOptional);
	}

	@Override
	public ParamType visitParamType(AngularParser.ParamTypeContext ctx) {
		if (ctx == null) {
			return null;
		}

		if (ctx.EVENT() != null) {
			return new ParamType(null, true);
		} else if (ctx.tsType() != null) {
			TsType type = (TsType) visitTsType(ctx.tsType());
			return new ParamType(type, false);
		}

		return new ParamType(null, false);
	}

	@Override
	public TsType visitTsType(AngularParser.TsTypeContext ctx) {
		List<GenericOrBasicType> types = new ArrayList<>();

		for (AngularParser.GenericOrBasicTypeContext typeCtx : ctx.genericOrBasicType()) {
			GenericOrBasicType type = (GenericOrBasicType) visitGenericOrBasicType(typeCtx);
			if (type != null) {
				types.add(type);
			}
		}

		return new TsType(types);
	}

	@Override
	public GenericOrBasicType visitGenericOrBasicType(AngularParser.GenericOrBasicTypeContext ctx) {
		if (ctx.genericType() != null) {
			return (GenericOrBasicType) visitGenericType(ctx.genericType());
		} else if (ctx.arrayType() != null) {
			return (GenericOrBasicType) visitArrayType(ctx.arrayType());
		} else if (ctx.type() != null) {
			return (GenericOrBasicType) visitType(ctx.type());
		} else if (ctx.ID() != null) {
			return new BasicType(ctx.ID().getText()); // Custom type
		} else if (ctx.UNDEFINED() != null) {
			return new BasicType(BasicType.Primitive.UNDEFINED);
		}

		return new BasicType(BasicType.Primitive.ANY); // Default fallback
	}

	@Override
	public GenericType visitGenericType(AngularParser.GenericTypeContext ctx) {
		String typeName = ctx.ID().getText();
		List<GenericTypeParam> typeParameters = new ArrayList<>();

		for (AngularParser.GenericTypeParamContext paramCtx : ctx.genericTypeParam()) {
			GenericTypeParam param = (GenericTypeParam) visitGenericTypeParam(paramCtx);
			if (param != null) {
				typeParameters.add(param);
			}
		}

		return new GenericType(typeName, typeParameters);
	}

	@Override
	public GenericTypeParam visitGenericTypeParam(AngularParser.GenericTypeParamContext ctx) {
		if (ctx.genericOrBasicType() != null) {
			GenericOrBasicType type = (GenericOrBasicType) visitGenericOrBasicType(ctx.genericOrBasicType());
			return new TypeGenericParam(type);
		} else if (ctx.STRING() != null) {
			return new StringGenericParam(ctx.STRING().getText());
		}

		return null;
	}

	@Override
	public ArrayType visitArrayType(AngularParser.ArrayTypeContext ctx) {
		GenericOrBasicType elementType;

		if (ctx.type() != null) {
			elementType = (GenericOrBasicType) visitType(ctx.type());
		} else if (ctx.ID() != null) {
			elementType = new BasicType(ctx.ID().getText()); // Custom type
		} else {
			elementType = new BasicType(BasicType.Primitive.ANY); // Default fallback
		}

		return new ArrayType(elementType);
	}

	@Override
	public BasicType visitType(AngularParser.TypeContext ctx) {
		if (ctx.NUMBER() != null) {
			return new BasicType(BasicType.Primitive.NUMBER);
		} else if (ctx.STRINGDL() != null) {
			return new BasicType(BasicType.Primitive.STRING);
		} else if (ctx.BOOLEAN() != null) {
			return new BasicType(BasicType.Primitive.BOOLEAN);
		} else if (ctx.ANY() != null) {
			return new BasicType(BasicType.Primitive.ANY);
		} else if (ctx.NULL() != null) {
			return new BasicType(BasicType.Primitive.NULL);
		}

		return new BasicType(BasicType.Primitive.ANY); // Default fallback
	}

    // Statement visitor methods

	@Override
	public TsStatement visitDeclareVariable(AngularParser.DeclareVariableContext ctx) {
		String keyword = ctx.LET() != null ? "let" : "const";
		String name = ctx.ID().getText();
		TsType type = ctx.tsType() != null ? (TsType) visitTsType(ctx.tsType()) : null;

		tsSymbolTable.define(name, "variable");
		return new DeclareVariable(keyword, name, type);
	}

	@Override
	public TsStatement visitDeclareAndAssign(AngularParser.DeclareAndAssignContext ctx) {
		String keyword = ctx.LET() != null ? "let" : "const";
		String name = ctx.ID().getText();
		TsType type = ctx.tsType() != null ? (TsType) visitTsType(ctx.tsType()) : null;
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());

		tsSymbolTable.define(name, "variable");
		return new DeclareAndAssign(keyword, name, type, expression);
	}

	@Override
	public TsStatement visitAssign(AngularParser.AssignContext ctx) {
		LeftHandSide lhs = (LeftHandSide) visitLeftHandSide(ctx.leftHandSide());
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());

		return new Assign(lhs, expression);
	}

	@Override
	public TsStatement visitIf(AngularParser.IfContext ctx) {
		TsExpression condition = ctx.tsExpr() != null ? (TsExpression) visitTsExpr(ctx.tsExpr()) : null;

		List<TsStatement> statements = new ArrayList<>();
		if (ctx.tsStmt() != null) {
			for (AngularParser.TsStmtContext stmtCtx : ctx.tsStmt()) {
				TsStatement statement = (TsStatement) visitTsStmt(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
		}
		TsBlock body = new TsBlock(statements);

		return new IfStatement(condition, body);
	}

	@Override
	public TsStatement visitFor(AngularParser.ForContext ctx) {
		String initializer = ctx.STRING() != null ? ctx.STRING().getText() : null;

		List<TsStatement> statements = new ArrayList<>();
		if (ctx.tsStmt() != null) {
			for (AngularParser.TsStmtContext stmtCtx : ctx.tsStmt()) {
				TsStatement statement = (TsStatement) visitTsStmt(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
		}
		TsBlock body = new TsBlock(statements);

		return new ForStatement(initializer, body);
	}

	@Override
	public TsStatement visitReturnStatement(AngularParser.ReturnStatementContext ctx) {
		TsExpression expression = ctx.tsExpr() != null ? (TsExpression) visitTsExpr(ctx.tsExpr()) : null;
		return new ReturnStatement(expression);
	}

	@Override
	public TsStatement visitExprStatement(AngularParser.ExprStatementContext ctx) {
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());
		return new ExprStatement(expression);
	}

	// Expression visitor methods

	@Override
	public TsExpression visitOrExpr(AngularParser.OrExprContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsExpr());
		TsExpression right = (TsExpression) visit(ctx.tsExpr());
		return new BinaryExpression(left, "||", right);
	}

	@Override
	public TsExpression visitToAnd(AngularParser.ToAndContext ctx) {
		return (TsExpression) visit(ctx.tsAndExpr());
	}

	@Override
	public TsExpression visitTernaryExpr(AngularParser.TernaryExprContext ctx) {
		TsExpression condition = (TsExpression) visit(ctx.tsExpr(0));
		TsExpression trueExpr = (TsExpression) visit(ctx.tsExpr(1));
		TsExpression falseExpr = (TsExpression) visit(ctx.tsExpr(2));
		return new TernaryExpression(condition, trueExpr, falseExpr);
	}

	@Override
	public LeftHandSide visitLeftHandSide(AngularParser.LeftHandSideContext ctx) {
		boolean hasThis = ctx.THIS() != null;
		String baseName = ctx.ID(0).getText();

		List<LeftHandSide.Access> accesses = new ArrayList<>();
		for (int i = 1; i < ctx.ID().size(); i++) {
			accesses.add(new LeftHandSide.DotAccess(ctx.ID(i).getText()));
		}

		for (AngularParser.TsExprContext exprCtx : ctx.tsExpr()) {
			TsExpression expr = (TsExpression) visit(exprCtx);
			accesses.add(new LeftHandSide.BracketAccess(expr));
		}

		return new LeftHandSide(hasThis, baseName, accesses);
	}

	@Override
	public TsExpression visitAndExpr(AngularParser.AndExprContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsAndExpr());
		TsExpression right = (TsExpression) visit(ctx.tsEqExpr());
		return new BinaryExpression(left, "&&", right);
	}

	@Override
	public TsExpression visitToEq(AngularParser.ToEqContext ctx) {
		return (TsExpression) visit(ctx.tsEqExpr());
	}

	@Override
	public TsExpression visitEqNeq(AngularParser.EqNeqContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsEqExpr());
		String operator = ctx.EQEQ() != null ? "==" :
				ctx.EQEQEQ() != null ? "===" :
						ctx.NEQ() != null ? "!=" : "!==";
		TsExpression right = (TsExpression) visit(ctx.tsRelExpr());
		return new BinaryExpression(left, operator, right);
	}

	@Override
	public TsExpression visitToRel(AngularParser.ToRelContext ctx) {
		return (TsExpression) visit(ctx.tsRelExpr());
	}

	@Override
	public TsExpression visitRelational(AngularParser.RelationalContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsRelExpr());
		String operator = ctx.TAG_OPEN() != null ? "<" :
				ctx.TAG_CLOSE() != null ? ">" :
						ctx.LTE() != null ? "<=" : ">=";
		TsExpression right = (TsExpression) visit(ctx.tsAddExpr());
		return new BinaryExpression(left, operator, right);
	}

	@Override
	public TsExpression visitAddSub(AngularParser.AddSubContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsAddExpr());
		String operator = ctx.PLUS() != null ? "+" : "-";
		TsExpression right = (TsExpression) visit(ctx.tsMulExpr());
		return new BinaryExpression(left, operator, right);
	}

	@Override
	public TsExpression visitToMul(AngularParser.ToMulContext ctx) {
		return (TsExpression) visit(ctx.tsMulExpr());
	}

	@Override
	public TsExpression visitMulDiv(AngularParser.MulDivContext ctx) {
		TsExpression left = (TsExpression) visit(ctx.tsMulExpr());
		String operator = ctx.STAR() != null ? "*" : "/";
		TsExpression right = (TsExpression) visit(ctx.tsUnaryExpr());
		return new BinaryExpression(left, operator, right);
	}

	@Override
	public TsExpression visitUnaryOp(AngularParser.UnaryOpContext ctx) {
		String operator = ctx.NOT_OP() != null ? "!" :
				ctx.PLUS() != null ? "+" : "-";
		TsExpression expression = (TsExpression) visit(ctx.tsUnaryExpr());
		return new UnaryExpression(operator, expression, true);
	}

	@Override
	public TsExpression visitToUnary(AngularParser.ToUnaryContext ctx) {
		return (TsExpression) visit(ctx.tsUnaryExpr());
	}

	@Override
	public TsExpression visitToPrimary(AngularParser.ToPrimaryContext ctx) {
		return (TsExpression) visit(ctx.tsPrimary());
	}

	// ============  Primary Expressions ============
	@Override
	public PrimaryExpression visitTsPrimary(AngularParser.TsPrimaryContext ctx) {
		TsAtom atom = (TsAtom) visit(ctx.tsAtom());
		List<TsPostfix> postfixes = new ArrayList<>();

		for (AngularParser.TsPostfixContext postfixCtx : ctx.tsPostfix()) {
			TsPostfix postfix = (TsPostfix) visit(postfixCtx);
			if (postfix != null) {
				postfixes.add(postfix);
			}
		}

		return new PrimaryExpression(atom, postfixes);
	}

	@Override
	public TsAtom visitThisRef(AngularParser.ThisRefContext ctx) {
		return new ThisRef();
	}

	@Override
	public TsAtom visitStoredID(AngularParser.StoredIDContext ctx) {
		return new StoredID(ctx.ID().getText());
	}

	@Override
	public TsAtom visitString(AngularParser.StringContext ctx) {
		return new StringLiteral(unquote(ctx.STRING().getText()));
	}

	@Override
	public TsAtom visitNumber(AngularParser.NumberContext ctx) {
		return new NumberLiteral(ctx.NUMERIC_VALUE().getText());
	}

	@Override
	public TsAtom visitBooleanTrue(AngularParser.BooleanTrueContext ctx) {
		return new BooleanLiteral(true);
	}

	@Override
	public TsAtom visitBooleanFalse(AngularParser.BooleanFalseContext ctx) {
		return new BooleanLiteral(false);
	}

	@Override
	public TsAtom visitKeyValue(AngularParser.KeyValueContext ctx) {
		List<KeyValuePair> properties = new ArrayList<>();
		if (ctx.keyValuePair() != null) {
			for (AngularParser.KeyValuePairContext kvCtx : ctx.keyValuePair()) {
				KeyValuePair kv = (KeyValuePair) visitKeyValuePair(kvCtx);
				if (kv != null) {
					properties.add(kv);
				}
			}
		}
		return new ObjectLiteral(properties);
	}

	@Override
	public TsAtom visitArray(AngularParser.ArrayContext ctx) {
		List<SpreadOrExpr> elements = new ArrayList<>();
		if (ctx.spreadOrExpr() != null) {
			for (AngularParser.SpreadOrExprContext soeCtx : ctx.spreadOrExpr()) {
				SpreadOrExpr soe = (SpreadOrExpr) visitSpreadOrExpr(soeCtx);
				if (soe != null) {
					elements.add(soe);
				}
			}
		}
		return new ArrayLiteral(elements);
	}

	@Override
	public TsAtom visitParen(AngularParser.ParenContext ctx) {
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());
		return new ParenExpression(expression);
	}

	@Override
	public TsAtom visitArrowFn(AngularParser.ArrowFnContext ctx) {
		return (TsAtom) visitArrowFunction(ctx.arrowFunction());
	}

	@Override
	public TsAtom visitNull(AngularParser.NullContext ctx) {
		return new NullLiteral();
	}

	@Override
	public TsAtom visitNewExpression(AngularParser.NewExpressionContext ctx) {
		String constructor = ctx.ID().getText();

		List<GenericTypeParam> typeArguments = new ArrayList<>();
		if (ctx.genericTypeArguments() != null) {
			typeArguments = (List<GenericTypeParam>) visitGenericTypeArguments(ctx.genericTypeArguments());
		}

		List<TsExpression> arguments = new ArrayList<>();
		if (ctx.tsExpr() != null) {
			for (AngularParser.TsExprContext exprCtx : ctx.tsExpr()) {
				TsExpression expr = (TsExpression) visitTsExpr(exprCtx);
				if (expr != null) {
					arguments.add(expr);
				}
			}
		}

		return new NewExpression(constructor, typeArguments, arguments);
	}

	@Override
	public TsPostfix visitDotCall(AngularParser.DotCallContext ctx) {
		String methodName = ctx.ID().getText();

		List<TsExpression> arguments = new ArrayList<>();
		if (ctx.tsExpr() != null) {
			for (AngularParser.TsExprContext exprCtx : ctx.tsExpr()) {
				TsExpression expr = (TsExpression) visitTsExpr(exprCtx);
				if (expr != null) {
					arguments.add(expr);
				}
			}
		}

		return new DotCall(methodName, arguments);
	}

	@Override
	public TsPostfix visitDotAccess(AngularParser.DotAccessContext ctx) {
		return new DotAccessPostfix(ctx.ID().getText());
	}

	@Override
	public TsPostfix visitBracketAccess(AngularParser.BracketAccessContext ctx) {
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());
		return new BracketAccessPostfix(expression);
	}

	@Override
	public TsPostfix visitCall(AngularParser.CallContext ctx) {
		boolean hasSpread = ctx.ELLIPSIS() != null;

		List<TsExpression> arguments = new ArrayList<>();
		if (ctx.tsExpr() != null) {
			for (AngularParser.TsExprContext exprCtx : ctx.tsExpr()) {
				TsExpression expr = (TsExpression) visitTsExpr(exprCtx);
				if (expr != null) {
					arguments.add(expr);
				}
			}
		}

		return new CallPostfix(hasSpread, arguments);
	}

	@Override
	public List<GenericTypeParam> visitGenericTypeArguments(AngularParser.GenericTypeArgumentsContext ctx) {
		List<GenericTypeParam> typeParams = new ArrayList<>();
		if (ctx.genericTypeParam() != null) {
			for (AngularParser.GenericTypeParamContext paramCtx : ctx.genericTypeParam()) {
				GenericTypeParam param = (GenericTypeParam) visitGenericTypeParam(paramCtx);
				if (param != null) {
					typeParams.add(param);
				}
			}
		}
		return typeParams;
	}

	@Override
	public SpreadOrExpr visitSpreadOrExpr(AngularParser.SpreadOrExprContext ctx) {
		boolean isSpread = ctx.ELLIPSIS() != null;
		TsExpression expression = (TsExpression) visitTsExpr(ctx.tsExpr());
		return new SpreadOrExpr(isSpread, expression);
	}

	@Override
	public ArrowFunction visitArrowFunction(AngularParser.ArrowFunctionContext ctx) {
		List<String> parameters = new ArrayList<>();
		if (ctx.ID() != null) {
			for (int i = 0; i < ctx.ID().size(); i++) {
				parameters.add(ctx.ID(i).getText());
			}
		}

		TsExpression bodyExpr = null;
		TsBlock bodyBlock = null;

		if (ctx.tsExpr() != null) {
			bodyExpr = (TsExpression) visitTsExpr(ctx.tsExpr());
		} else if (ctx.tsStmt() != null) {
			List<TsStatement> statements = new ArrayList<>();
			for (AngularParser.TsStmtContext stmtCtx : ctx.tsStmt()) {
				TsStatement statement = (TsStatement) visitTsStmt(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
			bodyBlock = new TsBlock(statements);
		}

		return new ArrowFunction(parameters, bodyExpr, bodyBlock);
	}

	@Override
	public KeyValuePair visitKeyValuePair(AngularParser.KeyValuePairContext ctx) {
		String key;
		if (ctx.ID() != null) {
			key = ctx.ID().getText();
		} else if (ctx.STRING() != null) {
			key = ctx.STRING().getText();
		} else {
			// Handle the case where both are null
			key = ""; // or throw a more descriptive exception
		}

		boolean isSpread = ctx.ELLIPSIS() != null;
		TsExpression value = (TsExpression) visitTsExpr(ctx.tsExpr());

		return new KeyValuePair(key, value, isSpread);
	}

	@Override
	public String visitPrimitiveDataType(AngularParser.PrimitiveDataTypeContext ctx) {
		if (ctx.PUBLIC() != null) return "public";
		if (ctx.PRIVATE() != null) return "private";
		if (ctx.PROTECTED() != null) return "protected";
		return null;
	}

//=========================  HTML  =========================

	@Override
	public HtmlDocument visitHtml(AngularParser.HtmlContext ctx) {
		List<Node> nodes = new ArrayList<>();
		if (ctx.element() != null) {
			for (AngularParser.ElementContext elementCtx : ctx.element()) {
				Node element = (Node) visit(elementCtx);
				if (element != null) {
					nodes.add(element);
				}
			}
		}
		return new HtmlDocument(nodes);
	}

	@Override
	public Node visitNode(AngularParser.NodeContext ctx) {
		if (ctx.element() != null) {
			return (Node) visit(ctx.element());
		} else if (ctx.interpolation() != null) {
			return visitInterpolation(ctx.interpolation());
		} else if (ctx.textNode() != null) {
			return visitTextNode(ctx.textNode());
		}
		return null;
	}



//    @Override
//    public ElementNode visitElement(AngularParser.ElementContext ctx) {
//        if (ctx == null || ctx.ID().isEmpty()) {
//            return new ElementNode("div");
//        }
//
//        String tagName = ctx.ID(0).getText();
//        ElementNode element = new ElementNode(tagName);
//
//        if (ctx.htmlAttribute() != null) {
//            for (AngularParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
//                HtmlAttribute attribute = (HtmlAttribute) visitHtmlAttribute(attrCtx);
//                if (attribute != null) {
//                    element.addAttribute(attribute);
//                }
//            }
//        }
//
//        // With the new grammar, self-closing token is not used. Derive by void element name.
//        boolean isVoidByName = VOID_ELEMENTS.contains(tagName.toLowerCase());
//        element.setSelfClosing(isVoidByName);
//
//        if (ctx.node() != null) {
//            for (AngularParser.NodeContext nodeCtx : ctx.node()) {
//                Node node = visitNode(nodeCtx);
//                if (node != null) {
//                    element.addChild(node);
//                }
//            }
//        }
//
//        return element;
//    }


	@Override
	public Object visitTerminalElement(AngularParser.TerminalElementContext ctx) {
		if (ctx == null) {
			return new ElementNode("div");
		}
		String tagName;
		if (ctx.IMG() != null) {
			tagName = ctx.IMG().getText();
		} else if (ctx.INPUT() != null) {
			tagName = ctx.INPUT().getText();
		} else {
			tagName = "div";
		}
		ElementNode element = new ElementNode(tagName);
		if (ctx.htmlAttribute() != null) {
			for (AngularParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
				HtmlAttribute attribute = (HtmlAttribute) visitHtmlAttribute(attrCtx);
				if (attribute != null) {
					element.addAttribute(attribute);
					recordTemplateAttribute(tagName, attribute);
				}
			}
		}
		boolean isVoidByName = VOID_ELEMENTS.contains(tagName.toLowerCase());
		element.setSelfClosing(isVoidByName);
		return element;
	}

	@Override
	public Object visitNonTerminalElement(AngularParser.NonTerminalElementContext ctx) {
		if (ctx == null || ctx.ID() == null || ctx.ID().isEmpty()) {
			return new ElementNode("div");
		}
		String tagName = ctx.ID(0).getText();
		ElementNode element = new ElementNode(tagName);
		if (ctx.htmlAttribute() != null) {
			for (AngularParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
				HtmlAttribute attribute = (HtmlAttribute) visitHtmlAttribute(attrCtx);
				if (attribute != null) {
					element.addAttribute(attribute);
					recordTemplateAttribute(tagName, attribute);
				}
			}
		}
		boolean isVoidByName = VOID_ELEMENTS.contains(tagName.toLowerCase());
		element.setSelfClosing(isVoidByName);
		if (ctx.node() != null) {
			for (AngularParser.NodeContext nodeCtx : ctx.node()) {
				Node child = visitNode(nodeCtx);
				if (child != null) {
					element.addChild(child);
				}
			}
		}
		return element;
	}

	@Override
	public TextNode visitTextNode(AngularParser.TextNodeContext ctx) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (i > 0) {
				sb.append(" ");
			}
			sb.append(ctx.getChild(i).getText());
		}

		return new TextNode(sb.toString());
	}

	@Override
	public InterpolationNode visitInterpolation(AngularParser.InterpolationContext ctx) {
		if (ctx == null) return new InterpolationNode("");
		if (ctx.ANGULAR_BINDING() == null) return new InterpolationNode("");

		String content = ctx.ANGULAR_BINDING().getText()
				.replaceAll("\\{\\{|\\}\\}", "")
				.trim();
		// record interpolation
		String name = "{{" + content + "}}#" + (++templateBindingCounter);
		templateSymbolTable.define(name, "interpolation");
		return new InterpolationNode(content);
	}

	@Override
	public HtmlAttribute visitHtmlAttribute(AngularParser.HtmlAttributeContext ctx) {
		if (ctx == null) {
			return null;
		}

		try {
			if (ctx.ngForDirective() != null) {
				return (HtmlAttribute) visitNgForDirective(ctx.ngForDirective());
			} else if (ctx.ngIfDirective() != null) {
				return (HtmlAttribute) visitNgIfDirective(ctx.ngIfDirective());
			} else if (ctx.ANGULAR_ATTRIBUTE_PROPERTY() != null) {
				return parseAngularProperty(ctx.ANGULAR_ATTRIBUTE_PROPERTY().getText());
			} else if (ctx.ANGULAR_ATTRIBUTE_EVENT() != null) {
				return parseAngularEvent(ctx.ANGULAR_ATTRIBUTE_EVENT().getText());
			} else if (ctx.ANGULAR_ATTRIBUTE_TWO_WAY() != null) {
				return parseAngularTwoWay(ctx.ANGULAR_ATTRIBUTE_TWO_WAY().getText());
			} else if (ctx.ATTRIBUTE() != null) {
				return parseStandardAttribute(ctx.ATTRIBUTE().getText());
			} else if (ctx.ID() != null) {
				return new BooleanAttribute(ctx.ID().getText());
			}
		} catch (Exception e) {

			System.err.println("Error processing attribute: " + e.getMessage());
		}

		return null;
	}

	@Override
	public NgForAttribute visitNgForDirective(AngularParser.NgForDirectiveContext ctx) {
		if (ctx == null || ctx.STRING() == null) {
			return new NgForAttribute("");
		}

		String expression = ctx.STRING().getText().replaceAll("['\"]", "");
		return new NgForAttribute(expression);
	}

	@Override
	public NgIfAttribute visitNgIfDirective(AngularParser.NgIfDirectiveContext ctx) {
		if (ctx == null || ctx.STRING() == null) {
			return new NgIfAttribute("");
		}

		String expression = ctx.STRING().getText().replaceAll("['\"]", "");
		return new NgIfAttribute(expression);
	}
	@Override
	public Object visitCss(AngularParser.CssContext ctx) {
		return super.visitCss(ctx);
	}

	@Override
	public Object visitCssDeclaration(AngularParser.CssDeclarationContext ctx) {
		return super.visitCssDeclaration(ctx);
	}

// ==================== Methods helper ====================

	private String extractPrimitiveDataType(AngularParser.PrimitiveDataTypeContext ctx) {
		if (ctx == null) {
			return null;
		}

		if (ctx.PUBLIC() != null) return "public";
		if (ctx.PRIVATE() != null) return "private";
		if (ctx.PROTECTED() != null) return "protected";

		return null;
	}

	private boolean isReadonly(AngularParser.PrimitiveDataTypeContext ctx) {
		return ctx != null && ctx.READONLY() != null;

	}

	private List<TsStatement> visitStmtList(List<AngularParser.TsStmtContext> stmts) {
		List<TsStatement> statements = new ArrayList<>();
		if (stmts != null) {
			for (AngularParser.TsStmtContext stmtCtx : stmts) {
				TsStatement statement = (TsStatement) visit(stmtCtx);
				if (statement != null) {
					statements.add(statement);
				}
			}
		}
		return statements;
	}

	private TsStatement visitTsStmt(AngularParser.TsStmtContext stmtCtx) {
		return stmtCtx != null ? (TsStatement) visit(stmtCtx) : null;
	}

	private List<TsExpression> visitExprList(List<AngularParser.TsExprContext> exprs) {
		List<TsExpression> expressions = new ArrayList<>();
		if (exprs != null) {
			for (AngularParser.TsExprContext exprCtx : exprs) {
				TsExpression expression = (TsExpression) visit(exprCtx);
				if (expression != null) {
					expressions.add(expression);
				}
			}
		}
		return expressions;
	}

	private TsExpression visitTsExpr(AngularParser.TsExprContext exprCtx) {
		return exprCtx != null ? (TsExpression) visit(exprCtx) : null;
	}


	private AngularPropertyBinding parseAngularProperty(String text) {
		if (text == null || text.trim().isEmpty()) {
			return new AngularPropertyBinding("", "");
		}

		try {
			String[] parts = text.split("=", 2);
			String property = parts[0].replaceAll("[\\[\\]]", "");
			String expression = parts.length > 1 ? parts[1].replaceAll("['\"]", "") : "";
			return new AngularPropertyBinding(property, expression);
		} catch (Exception e) {
			return new AngularPropertyBinding("", "");
		}
	}

	private AngularEventBinding parseAngularEvent(String text) {
		if (text == null || text.trim().isEmpty()) {
			return new AngularEventBinding("", "");
		}

		try {
			String[] parts = text.split("=", 2);
			String event = parts[0].replaceAll("[\\(\\)]", "");
			String handler = parts.length > 1 ? parts[1].replaceAll("['\"]", "") : "";
			return new AngularEventBinding(event, handler);
		} catch (Exception e) {
			return new AngularEventBinding("", "");
		}
	}

	private AngularTwoWayBinding parseAngularTwoWay(String text) {
		if (text == null || text.trim().isEmpty()) {
			return new AngularTwoWayBinding("", "");
		}

		try {
			String[] parts = text.split("=", 2);
			String property = parts[0].replaceAll("[\\[\\(\\]\\)]", "");
			String expression = parts.length > 1 ? parts[1].replaceAll("['\"]", "") : "";
			return new AngularTwoWayBinding(property, expression);
		} catch (Exception e) {
			return new AngularTwoWayBinding("", "");
		}
	}

	private StandardAttribute parseStandardAttribute(String text) {
		if (text == null || text.trim().isEmpty()) {
			return new StandardAttribute("", "");
		}

		try {
			String[] parts = text.split("=", 2);
			String name = parts[0];
			String value = parts.length > 1 ? parts[1].replaceAll("['\"]", "") : "";
			return new StandardAttribute(name, value);
		} catch (Exception e) {
			return new StandardAttribute("", "");
		}
	}
	private static final java.util.Set<String> VOID_ELEMENTS = java.util.Set.of(
			"area", "base", "br", "col", "embed", "hr", "img", "input",
			"link", "meta", "param", "source", "track", "wbr"
	);

	private HtmlDocument parseHtmlFromString(String content) {
		try {

			CharStream cs = CharStreams.fromString(content);
			AngularLexer lexer = new AngularLexer(cs);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			AngularParser parser = new AngularParser(tokens);

			// نستخدم rule الـ ast.html مباشرة (تأكد أن اسم القاعدة صحيح في الـ parser)
			AngularParser.HtmlContext htmlCtx = parser.html();

			// نعيد زيارة هذا السياق بواسطة نفس الـ visitor (this)
			HtmlDocument doc = (HtmlDocument) visitHtml(htmlCtx);
			return doc;
		} catch (Exception e) {
			System.err.println("parseHtmlFromString error: " + e.getMessage());
			return new HtmlDocument();
		}
	}

	private String unquote(String text) {
		if (text == null || text.length() < 2) return text;
		char first = text.charAt(0);
		char last = text.charAt(text.length() - 1);
		if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
			return text.substring(1, text.length() - 1);
		}
		return text;
	}

	private void recordTemplateAttribute(String tagName, HtmlAttribute attribute) {
		if (attribute == null) return;
		String name = null;
		String type = null;
		if (attribute instanceof AngularPropertyBinding apb) {
			name = tagName + ".[" + apb.getProperty() + "]#" + (++templateBindingCounter);
			type = apb.getExpression();
		} else if (attribute instanceof AngularEventBinding aeb) {
			name = tagName + ".(" + aeb.getEvent() + ")#" + (++templateBindingCounter);
			type = aeb.getHandler();
		} else if (attribute instanceof AngularTwoWayBinding atb) {
			name = tagName + ".[[(" + atb.getProperty() + ")]]#" + (++templateBindingCounter);
			type = atb.getExpression();
		} else if (attribute instanceof NgIfAttribute nif) {
			name = tagName + ".*ngIf#" + (++templateBindingCounter);
			type = nif.toString();
		} else if (attribute instanceof NgForAttribute nfor) {
			name = tagName + ".*ngFor#" + (++templateBindingCounter);
			type = nfor.toString();
			// attempt to capture loop variable: let x of y
			String expr = nfor.toString();
			java.util.regex.Matcher m = java.util.regex.Pattern.compile("let\\s+(\\w+)\\s+of\\s+(.+)").matcher(expr);
			if (m.find()) {
				String loopVar = m.group(1);
				templateSymbolTable.define(loopVar, "ngForVar");
			}
		} else if (attribute instanceof StandardAttribute sa) {
			name = tagName + "." + sa.getName() + "#" + (++templateBindingCounter);
			type = sa.getValue();

		} else if (attribute instanceof BooleanAttribute ba) {
			name = tagName + "." + ba.getName() + "#" + (++templateBindingCounter);
			type = "boolean-attr";
		}
		if (name != null) {
			templateSymbolTable.define(name, type != null ? type : "");
		}
	}
}
