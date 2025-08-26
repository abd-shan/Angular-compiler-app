// Generated from D:/useful/practice/Java/Angular-compiler-app/antlr/AngularParser.g4 by ANTLR 4.13.2

package gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AngularParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AngularParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AngularParser#angularApp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngularApp(AngularParser.AngularAppContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#angularFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngularFile(AngularParser.AngularFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateFile(AngularParser.StateFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateServiceClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateServiceClass(AngularParser.StateServiceClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#injectableDecorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInjectableDecorator(AngularParser.InjectableDecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#injectableOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInjectableOptions(AngularParser.InjectableOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateInterface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateInterface(AngularParser.StateInterfaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateInterfaceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateInterfaceProperty(AngularParser.StateInterfacePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateVariable(AngularParser.StateVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateAction(AngularParser.StateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateReducer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateReducer(AngularParser.StateReducerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#reducerOnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReducerOnList(AngularParser.ReducerOnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#componentFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentFile(AngularParser.ComponentFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#providersOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProvidersOption(AngularParser.ProvidersOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#providerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProviderList(AngularParser.ProviderListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code provideStoreExpression}
	 * labeled alternative in {@link AngularParser#providerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProvideStoreExpression(AngularParser.ProvideStoreExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleProvider}
	 * labeled alternative in {@link AngularParser#providerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleProvider(AngularParser.SimpleProviderContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#cssOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssOption(AngularParser.CssOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inlineTemplate}
	 * labeled alternative in {@link AngularParser#htmlOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineTemplate(AngularParser.InlineTemplateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalTemplate}
	 * labeled alternative in {@link AngularParser#htmlOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTemplate(AngularParser.ExternalTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(AngularParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#importClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportClause(AngularParser.ImportClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#defaultImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultImport(AngularParser.DefaultImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#namespaceImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceImport(AngularParser.NamespaceImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#namedImports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedImports(AngularParser.NamedImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#importSpecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpecList(AngularParser.ImportSpecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpecifier(AngularParser.ImportSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#componentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentList(AngularParser.ComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#ts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTs(AngularParser.TsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#tsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsStatement(AngularParser.TsStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareAttribute}
	 * labeled alternative in {@link AngularParser#tsAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareAttribute(AngularParser.DeclareAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareAndAssignAttribute}
	 * labeled alternative in {@link AngularParser#tsAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareAndAssignAttribute(AngularParser.DeclareAndAssignAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDecl(AngularParser.StateDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateProperty(AngularParser.StatePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#stateValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateValue(AngularParser.StateValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#arrayValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(AngularParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#objectValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectValue(AngularParser.ObjectValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(AngularParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#constructorParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorParams(AngularParser.ConstructorParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#constructorParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorParam(AngularParser.ConstructorParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(AngularParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#methodParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParams(AngularParser.MethodParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#methodParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParam(AngularParser.MethodParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(AngularParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#tsType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsType(AngularParser.TsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#genericOrBasicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericOrBasicType(AngularParser.GenericOrBasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#genericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericType(AngularParser.GenericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#genericTypeParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeParam(AngularParser.GenericTypeParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(AngularParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AngularParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareVariable}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVariable(AngularParser.DeclareVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareAndAssign}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareAndAssign(AngularParser.DeclareAndAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(AngularParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(AngularParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(AngularParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(AngularParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link AngularParser#tsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(AngularParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link AngularParser#tsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(AngularParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link AngularParser#tsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(AngularParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAnd}
	 * labeled alternative in {@link AngularParser#tsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAnd(AngularParser.ToAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(AngularParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToEq}
	 * labeled alternative in {@link AngularParser#tsAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToEq(AngularParser.ToEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link AngularParser#tsAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(AngularParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToRel}
	 * labeled alternative in {@link AngularParser#tsEqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToRel(AngularParser.ToRelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqNeq}
	 * labeled alternative in {@link AngularParser#tsEqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNeq(AngularParser.EqNeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAdd}
	 * labeled alternative in {@link AngularParser#tsRelExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAdd(AngularParser.ToAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link AngularParser#tsRelExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(AngularParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link AngularParser#tsAddExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(AngularParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToMul}
	 * labeled alternative in {@link AngularParser#tsAddExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToMul(AngularParser.ToMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToUnary}
	 * labeled alternative in {@link AngularParser#tsMulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToUnary(AngularParser.ToUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link AngularParser#tsMulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(AngularParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link AngularParser#tsUnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(AngularParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPrimary}
	 * labeled alternative in {@link AngularParser#tsUnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPrimary(AngularParser.ToPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#tsPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsPrimary(AngularParser.TsPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisRef}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisRef(AngularParser.ThisRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StoredID}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoredID(AngularParser.StoredIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(AngularParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(AngularParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanTrue}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTrue(AngularParser.BooleanTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanFalse}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFalse(AngularParser.BooleanFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValue(AngularParser.KeyValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(AngularParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(AngularParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrowFn}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFn(AngularParser.ArrowFnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(AngularParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link AngularParser#tsAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(AngularParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotCall}
	 * labeled alternative in {@link AngularParser#tsPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotCall(AngularParser.DotCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotAccess}
	 * labeled alternative in {@link AngularParser#tsPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotAccess(AngularParser.DotAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketAccess}
	 * labeled alternative in {@link AngularParser#tsPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketAccess(AngularParser.BracketAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link AngularParser#tsPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(AngularParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#genericTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeArguments(AngularParser.GenericTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#spreadOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadOrExpr(AngularParser.SpreadOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#arrowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction(AngularParser.ArrowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(AngularParser.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#primitiveDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveDataType(AngularParser.PrimitiveDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml(AngularParser.HtmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(AngularParser.NodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#interpolation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolation(AngularParser.InterpolationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#textNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextNode(AngularParser.TextNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(AngularParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(AngularParser.HtmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#ngForDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNgForDirective(AngularParser.NgForDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#ngIfDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNgIfDirective(AngularParser.NgIfDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#css}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCss(AngularParser.CssContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(AngularParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#cssProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProperty(AngularParser.CssPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(AngularParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(AngularParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AngularParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssToken(AngularParser.CssTokenContext ctx);
}