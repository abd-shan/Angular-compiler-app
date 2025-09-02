// Generated from C:/Users/Abdulkader/Desktop/Angular-compiler-app/Angular-compiler-app/antlr/AngularParser.g4 by ANTLR 4.13.2

package gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AngularParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AT_COMPONENT=1, STANDALONE=2, IMPORTS=3, IMPORT=4, STYLES=5, TEMPLATE=6, 
		TEMPLATE_URL=7, TRUE=8, FALSE=9, FROM=10, AS=11, CLASS=12, EXPORT=13, 
		SELECTOR=14, STYLES_URL=15, PROVIDERS=16, IMPLEMENTS=17, OF=18, LBRACE=19, 
		RBRACE=20, LPARENTHESIS=21, RPARENTHESIS=22, LBRACKET=23, RBRACKET=24, 
		COLON=25, COMMA=26, STRING=27, BACKTICK=28, SEMICOLON=29, QUESTION=30, 
		ARROW=31, STATE=32, AT_INJECTABLE=33, PROVIDED_IN=34, INTERFACE=35, OBSERVABLE=36, 
		SUBJECT=37, ASYNC=38, PIPE=39, MAP=40, CREATE_ACTION=41, CREATE_REDUCER=42, 
		ON=43, EQUAL_SIGN=44, NUMBER=45, STRINGDL=46, BOOLEAN=47, ANY=48, VOID=49, 
		NULL=50, LET=51, IF=52, FOR=53, CONSTRUCTOR=54, CONST=55, RETURN=56, SWITCH=57, 
		CASE=58, DEFAULT=59, BREAK=60, EVENT=61, NEW=62, PUBLIC=63, PRIVATE=64, 
		PROTECTED=65, READONLY=66, THIS=67, DOT=68, ELLIPSIS=69, PLUS=70, MINUS=71, 
		STAR=72, SLASH=73, AND_OP=74, OR_OP=75, NOT_OP=76, EQEQ=77, EQEQEQ=78, 
		NEQ=79, NEQEQ=80, LTE=81, GTE=82, PLUS_EQUAL=83, MINUS_EQUAL=84, STAR_EQUAL=85, 
		SLASH_EQUAL=86, PERCENT=87, TILDE=88, UNDEFINED=89, VAR=90, ANGULAR_EVENT=91, 
		ANGULAR_PROPERTY=92, ANGULAR_TWO_WAY=93, ANGULAR_BINDING=94, TAG_OPEN=95, 
		TAG_CLOSE=96, TAG_OPEN_SELF=97, INPUT=98, IMG=99, NG_IF=100, NG_FOR=101, 
		ATTRIBUTE=102, ANGULAR_ATTRIBUTE_PROPERTY=103, ANGULAR_ATTRIBUTE_EVENT=104, 
		ANGULAR_ATTRIBUTE_TWO_WAY=105, DISPLAY=106, MARGIN=107, FONT_FAMILY=108, 
		PADDING=109, WIDTH=110, BORDER_RIGHT=111, OVERFLOW_Y=112, BORDER=113, 
		CURSOR=114, TRANSITION=115, HEIGHT=116, MARGIN_RIGHT=117, BORDER_SOLID=118, 
		COLOR=119, BACKGROUND=120, BACKGROUND_COLOR=121, BORDER_RADIUS=122, GAP=123, 
		BORDER_BOTTOM_COLOR=124, MARGIN_BOTTOM=125, TOP=126, LEFT=127, POSITION=128, 
		JUSTIFY_CONTENT=129, ALIGN_ITEMS=130, MAX_WIDTH=131, BOX_SIZING=132, MAGIN_TOP=133, 
		OBJECT_FIT=134, Z_INDEX=135, TEXT_DECORATION=136, FONT_WEIGHT=137, RESIZE=138, 
		TSXT_ALIGN=139, FONT_SIZE=140, GRID_TEMPLATE_COLUMNS=141, BOX_SHADOW=142, 
		FLEX_DIRECTION=143, OVERFLOW=144, NUMERIC_VALUE=145, COLOR_VALUE=146, 
		CSS_SELECTOR=147, ID=148, WS=149, COMMENT=150, SPACE=151;
	public static final int
		RULE_angularApp = 0, RULE_angularFile = 1, RULE_routeFile = 2, RULE_routeObject = 3, 
		RULE_routeProperty = 4, RULE_stateFile = 5, RULE_stateServiceClass = 6, 
		RULE_injectableDecorator = 7, RULE_injectableOptions = 8, RULE_stateInterface = 9, 
		RULE_stateInterfaceProperty = 10, RULE_stateVariable = 11, RULE_stateAction = 12, 
		RULE_stateReducer = 13, RULE_reducerOnList = 14, RULE_componentFile = 15, 
		RULE_providersOption = 16, RULE_providerList = 17, RULE_providerExpression = 18, 
		RULE_cssOption = 19, RULE_htmlOption = 20, RULE_importStatement = 21, 
		RULE_importClause = 22, RULE_defaultImport = 23, RULE_namespaceImport = 24, 
		RULE_namedImports = 25, RULE_importSpecList = 26, RULE_importSpecifier = 27, 
		RULE_componentList = 28, RULE_ts = 29, RULE_tsStatement = 30, RULE_tsAttribute = 31, 
		RULE_stateDecl = 32, RULE_stateProperty = 33, RULE_stateValue = 34, RULE_arrayValue = 35, 
		RULE_objectValue = 36, RULE_constructor = 37, RULE_constructorParams = 38, 
		RULE_constructorParam = 39, RULE_method = 40, RULE_methodParams = 41, 
		RULE_methodParam = 42, RULE_paramType = 43, RULE_tsType = 44, RULE_genericOrBasicType = 45, 
		RULE_genericType = 46, RULE_genericTypeParam = 47, RULE_arrayType = 48, 
		RULE_type = 49, RULE_tsStmt = 50, RULE_tsExpr = 51, RULE_leftHandSide = 52, 
		RULE_tsAndExpr = 53, RULE_tsEqExpr = 54, RULE_tsRelExpr = 55, RULE_tsAddExpr = 56, 
		RULE_tsMulExpr = 57, RULE_tsUnaryExpr = 58, RULE_tsPrimary = 59, RULE_tsAtom = 60, 
		RULE_tsPostfix = 61, RULE_genericTypeArguments = 62, RULE_spreadOrExpr = 63, 
		RULE_arrowFunction = 64, RULE_keyValuePair = 65, RULE_primitiveDataType = 66, 
		RULE_html = 67, RULE_element = 68, RULE_node = 69, RULE_interpolation = 70, 
		RULE_textNode = 71, RULE_htmlAttribute = 72, RULE_ngForDirective = 73, 
		RULE_ngIfDirective = 74, RULE_css = 75, RULE_cssDeclaration = 76, RULE_cssProperty = 77, 
		RULE_property = 78, RULE_cssValue = 79, RULE_cssToken = 80;
	private static String[] makeRuleNames() {
		return new String[] {
			"angularApp", "angularFile", "routeFile", "routeObject", "routeProperty", 
			"stateFile", "stateServiceClass", "injectableDecorator", "injectableOptions", 
			"stateInterface", "stateInterfaceProperty", "stateVariable", "stateAction", 
			"stateReducer", "reducerOnList", "componentFile", "providersOption", 
			"providerList", "providerExpression", "cssOption", "htmlOption", "importStatement", 
			"importClause", "defaultImport", "namespaceImport", "namedImports", "importSpecList", 
			"importSpecifier", "componentList", "ts", "tsStatement", "tsAttribute", 
			"stateDecl", "stateProperty", "stateValue", "arrayValue", "objectValue", 
			"constructor", "constructorParams", "constructorParam", "method", "methodParams", 
			"methodParam", "paramType", "tsType", "genericOrBasicType", "genericType", 
			"genericTypeParam", "arrayType", "type", "tsStmt", "tsExpr", "leftHandSide", 
			"tsAndExpr", "tsEqExpr", "tsRelExpr", "tsAddExpr", "tsMulExpr", "tsUnaryExpr", 
			"tsPrimary", "tsAtom", "tsPostfix", "genericTypeArguments", "spreadOrExpr", 
			"arrowFunction", "keyValuePair", "primitiveDataType", "html", "element", 
			"node", "interpolation", "textNode", "htmlAttribute", "ngForDirective", 
			"ngIfDirective", "css", "cssDeclaration", "cssProperty", "property", 
			"cssValue", "cssToken"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@Component'", "'standalone'", "'imports'", "'import'", "'styles'", 
			"'template'", "'templateUrl'", "'true'", "'false'", "'from'", "'as'", 
			"'class'", "'export'", "'selector'", "'styleUrl'", "'providers'", "'implements'", 
			"'of'", "'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "','", null, 
			"'`'", "';'", "'?'", "'=>'", "'ast.state'", "'@Injectable'", "'providedIn'", 
			"'interface'", "'Observable'", "'Subject'", "'async'", "'|'", "'map'", 
			"'createAction'", "'createReducer'", "'on'", "'='", "'number'", "'string'", 
			"'boolean'", "'any'", "'void'", "'null'", "'let'", "'if'", "'for'", "'constructor'", 
			"'const'", "'return'", "'switch'", "'case'", "'default'", "'break'", 
			"'Event'", "'new'", "'public'", "'private'", "'protected'", "'readonly'", 
			"'this'", "'.'", "'...'", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
			"'!'", "'=='", "'==='", "'!='", "'!=='", "'<='", "'>='", "'+='", "'-='", 
			"'*='", "'/='", "'%'", "'~'", "'undefined'", "'var'", null, null, null, 
			null, "'<'", "'>'", "'</'", "'input'", "'img'", "'*ngIf'", "'*ngFor'", 
			null, null, null, null, "'display'", "'margin'", "'font-family'", "'padding'", 
			"'width'", "'border-right'", "'overflow-y'", "'border'", "'cursor'", 
			"'transition'", "'height'", "'margin-right'", "'border-solid'", "'color'", 
			"'background'", "'background-color'", "'border-radius'", "'gap'", "'border-bottom-color'", 
			"'margin-bottom'", "'top'", "'left'", "'position'", "'justify-content'", 
			"'align-items'", "'max-width'", "'box-sizing'", "'margin-top'", "'object-fit'", 
			"'z-index'", "'text-decoration'", "'font-weight'", "'resize'", "'text-align'", 
			"'font-size'", "'grid-template-columns'", "'box-shadow'", "'flex-direction'", 
			"'overflow'", null, null, null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AT_COMPONENT", "STANDALONE", "IMPORTS", "IMPORT", "STYLES", "TEMPLATE", 
			"TEMPLATE_URL", "TRUE", "FALSE", "FROM", "AS", "CLASS", "EXPORT", "SELECTOR", 
			"STYLES_URL", "PROVIDERS", "IMPLEMENTS", "OF", "LBRACE", "RBRACE", "LPARENTHESIS", 
			"RPARENTHESIS", "LBRACKET", "RBRACKET", "COLON", "COMMA", "STRING", "BACKTICK", 
			"SEMICOLON", "QUESTION", "ARROW", "STATE", "AT_INJECTABLE", "PROVIDED_IN", 
			"INTERFACE", "OBSERVABLE", "SUBJECT", "ASYNC", "PIPE", "MAP", "CREATE_ACTION", 
			"CREATE_REDUCER", "ON", "EQUAL_SIGN", "NUMBER", "STRINGDL", "BOOLEAN", 
			"ANY", "VOID", "NULL", "LET", "IF", "FOR", "CONSTRUCTOR", "CONST", "RETURN", 
			"SWITCH", "CASE", "DEFAULT", "BREAK", "EVENT", "NEW", "PUBLIC", "PRIVATE", 
			"PROTECTED", "READONLY", "THIS", "DOT", "ELLIPSIS", "PLUS", "MINUS", 
			"STAR", "SLASH", "AND_OP", "OR_OP", "NOT_OP", "EQEQ", "EQEQEQ", "NEQ", 
			"NEQEQ", "LTE", "GTE", "PLUS_EQUAL", "MINUS_EQUAL", "STAR_EQUAL", "SLASH_EQUAL", 
			"PERCENT", "TILDE", "UNDEFINED", "VAR", "ANGULAR_EVENT", "ANGULAR_PROPERTY", 
			"ANGULAR_TWO_WAY", "ANGULAR_BINDING", "TAG_OPEN", "TAG_CLOSE", "TAG_OPEN_SELF", 
			"INPUT", "IMG", "NG_IF", "NG_FOR", "ATTRIBUTE", "ANGULAR_ATTRIBUTE_PROPERTY", 
			"ANGULAR_ATTRIBUTE_EVENT", "ANGULAR_ATTRIBUTE_TWO_WAY", "DISPLAY", "MARGIN", 
			"FONT_FAMILY", "PADDING", "WIDTH", "BORDER_RIGHT", "OVERFLOW_Y", "BORDER", 
			"CURSOR", "TRANSITION", "HEIGHT", "MARGIN_RIGHT", "BORDER_SOLID", "COLOR", 
			"BACKGROUND", "BACKGROUND_COLOR", "BORDER_RADIUS", "GAP", "BORDER_BOTTOM_COLOR", 
			"MARGIN_BOTTOM", "TOP", "LEFT", "POSITION", "JUSTIFY_CONTENT", "ALIGN_ITEMS", 
			"MAX_WIDTH", "BOX_SIZING", "MAGIN_TOP", "OBJECT_FIT", "Z_INDEX", "TEXT_DECORATION", 
			"FONT_WEIGHT", "RESIZE", "TSXT_ALIGN", "FONT_SIZE", "GRID_TEMPLATE_COLUMNS", 
			"BOX_SHADOW", "FLEX_DIRECTION", "OVERFLOW", "NUMERIC_VALUE", "COLOR_VALUE", 
			"CSS_SELECTOR", "ID", "WS", "COMMENT", "SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AngularParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AngularParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AngularAppContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AngularParser.EOF, 0); }
		public List<AngularFileContext> angularFile() {
			return getRuleContexts(AngularFileContext.class);
		}
		public AngularFileContext angularFile(int i) {
			return getRuleContext(AngularFileContext.class,i);
		}
		public AngularAppContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angularApp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterAngularApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitAngularApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitAngularApp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngularAppContext angularApp() throws RecognitionException {
		AngularAppContext _localctx = new AngularAppContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_angularApp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				angularFile();
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36028839968645138L) != 0) );
			setState(167);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AngularFileContext extends ParserRuleContext {
		public ComponentFileContext componentFile() {
			return getRuleContext(ComponentFileContext.class,0);
		}
		public StateFileContext stateFile() {
			return getRuleContext(StateFileContext.class,0);
		}
		public RouteFileContext routeFile() {
			return getRuleContext(RouteFileContext.class,0);
		}
		public AngularFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angularFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterAngularFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitAngularFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitAngularFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngularFileContext angularFile() throws RecognitionException {
		AngularFileContext _localctx = new AngularFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_angularFile);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				componentFile();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				stateFile();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				routeFile();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteFileContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public List<RouteObjectContext> routeObject() {
			return getRuleContexts(RouteObjectContext.class);
		}
		public RouteObjectContext routeObject(int i) {
			return getRuleContext(RouteObjectContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public RouteFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterRouteFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitRouteFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitRouteFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteFileContext routeFile() throws RecognitionException {
		RouteFileContext _localctx = new RouteFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_routeFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(174);
				importStatement();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(180);
				match(EXPORT);
				}
			}

			setState(183);
			match(CONST);
			setState(184);
			match(ID);
			setState(185);
			match(COLON);
			setState(186);
			match(ID);
			setState(187);
			match(EQUAL_SIGN);
			setState(188);
			match(LBRACKET);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(189);
				routeObject();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					routeObject();
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(199);
			match(RBRACKET);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(200);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteObjectContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<RoutePropertyContext> routeProperty() {
			return getRuleContexts(RoutePropertyContext.class);
		}
		public RoutePropertyContext routeProperty(int i) {
			return getRuleContext(RoutePropertyContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public RouteObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterRouteObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitRouteObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitRouteObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteObjectContext routeObject() throws RecognitionException {
		RouteObjectContext _localctx = new RouteObjectContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_routeObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(LBRACE);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(204);
				routeProperty();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(205);
					match(COMMA);
					setState(206);
					routeProperty();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(214);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoutePropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public RoutePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterRouteProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitRouteProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitRouteProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutePropertyContext routeProperty() throws RecognitionException {
		RoutePropertyContext _localctx = new RoutePropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_routeProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ID);
			setState(217);
			match(COLON);
			setState(218);
			tsExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateFileContext extends ParserRuleContext {
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<StateInterfaceContext> stateInterface() {
			return getRuleContexts(StateInterfaceContext.class);
		}
		public StateInterfaceContext stateInterface(int i) {
			return getRuleContext(StateInterfaceContext.class,i);
		}
		public List<StateVariableContext> stateVariable() {
			return getRuleContexts(StateVariableContext.class);
		}
		public StateVariableContext stateVariable(int i) {
			return getRuleContext(StateVariableContext.class,i);
		}
		public List<StateActionContext> stateAction() {
			return getRuleContexts(StateActionContext.class);
		}
		public StateActionContext stateAction(int i) {
			return getRuleContext(StateActionContext.class,i);
		}
		public List<StateReducerContext> stateReducer() {
			return getRuleContexts(StateReducerContext.class);
		}
		public StateReducerContext stateReducer(int i) {
			return getRuleContext(StateReducerContext.class,i);
		}
		public List<StateServiceClassContext> stateServiceClass() {
			return getRuleContexts(StateServiceClassContext.class);
		}
		public StateServiceClassContext stateServiceClass(int i) {
			return getRuleContext(StateServiceClassContext.class,i);
		}
		public StateFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateFileContext stateFile() throws RecognitionException {
		StateFileContext _localctx = new StateFileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stateFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(220);
				importStatement();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(226);
						stateInterface();
						}
						break;
					case 2:
						{
						setState(227);
						stateVariable();
						}
						break;
					case 3:
						{
						setState(228);
						stateAction();
						}
						break;
					case 4:
						{
						setState(229);
						stateReducer();
						}
						break;
					case 5:
						{
						setState(230);
						stateServiceClass();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateServiceClassContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public TerminalNode CLASS() { return getToken(AngularParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TsContext ts() {
			return getRuleContext(TsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public InjectableDecoratorContext injectableDecorator() {
			return getRuleContext(InjectableDecoratorContext.class,0);
		}
		public StateServiceClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateServiceClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateServiceClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateServiceClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateServiceClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateServiceClassContext stateServiceClass() throws RecognitionException {
		StateServiceClassContext _localctx = new StateServiceClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stateServiceClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_INJECTABLE) {
				{
				setState(235);
				injectableDecorator();
				}
			}

			setState(238);
			match(EXPORT);
			setState(239);
			match(CLASS);
			setState(240);
			match(ID);
			setState(241);
			match(LBRACE);
			setState(242);
			ts();
			setState(243);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InjectableDecoratorContext extends ParserRuleContext {
		public TerminalNode AT_INJECTABLE() { return getToken(AngularParser.AT_INJECTABLE, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public InjectableOptionsContext injectableOptions() {
			return getRuleContext(InjectableOptionsContext.class,0);
		}
		public InjectableDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_injectableDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterInjectableDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitInjectableDecorator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitInjectableDecorator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InjectableDecoratorContext injectableDecorator() throws RecognitionException {
		InjectableDecoratorContext _localctx = new InjectableDecoratorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_injectableDecorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(AT_INJECTABLE);
			setState(246);
			match(LPARENTHESIS);
			setState(247);
			match(LBRACE);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROVIDED_IN) {
				{
				setState(248);
				injectableOptions();
				}
			}

			setState(251);
			match(RBRACE);
			setState(252);
			match(RPARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InjectableOptionsContext extends ParserRuleContext {
		public TerminalNode PROVIDED_IN() { return getToken(AngularParser.PROVIDED_IN, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public InjectableOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_injectableOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterInjectableOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitInjectableOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitInjectableOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InjectableOptionsContext injectableOptions() throws RecognitionException {
		InjectableOptionsContext _localctx = new InjectableOptionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_injectableOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(PROVIDED_IN);
			setState(255);
			match(COLON);
			setState(256);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateInterfaceContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(AngularParser.INTERFACE, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public List<StateInterfacePropertyContext> stateInterfaceProperty() {
			return getRuleContexts(StateInterfacePropertyContext.class);
		}
		public StateInterfacePropertyContext stateInterfaceProperty(int i) {
			return getRuleContext(StateInterfacePropertyContext.class,i);
		}
		public StateInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateInterface(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateInterface(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateInterfaceContext stateInterface() throws RecognitionException {
		StateInterfaceContext _localctx = new StateInterfaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stateInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(258);
				match(EXPORT);
				}
			}

			setState(261);
			match(INTERFACE);
			setState(262);
			match(ID);
			setState(263);
			match(LBRACE);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(264);
				stateInterfaceProperty();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateInterfacePropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public StateInterfacePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateInterfaceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateInterfaceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateInterfaceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateInterfaceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateInterfacePropertyContext stateInterfaceProperty() throws RecognitionException {
		StateInterfacePropertyContext _localctx = new StateInterfacePropertyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stateInterfaceProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(ID);
			setState(273);
			match(COLON);
			setState(274);
			tsType();
			setState(275);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateVariableContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public ObjectValueContext objectValue() {
			return getRuleContext(ObjectValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public StateVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateVariableContext stateVariable() throws RecognitionException {
		StateVariableContext _localctx = new StateVariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stateVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(277);
				match(EXPORT);
				}
			}

			setState(280);
			match(CONST);
			setState(281);
			match(ID);
			setState(282);
			match(COLON);
			setState(283);
			match(ID);
			setState(284);
			match(EQUAL_SIGN);
			setState(285);
			objectValue();
			setState(286);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateActionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode CREATE_ACTION() { return getToken(AngularParser.CREATE_ACTION, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public TerminalNode COMMA() { return getToken(AngularParser.COMMA, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public StateActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateActionContext stateAction() throws RecognitionException {
		StateActionContext _localctx = new StateActionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stateAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(288);
				match(EXPORT);
				}
			}

			setState(291);
			match(CONST);
			setState(292);
			match(ID);
			setState(293);
			match(EQUAL_SIGN);
			setState(294);
			match(CREATE_ACTION);
			setState(295);
			match(LPARENTHESIS);
			setState(296);
			match(STRING);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(297);
				match(COMMA);
				setState(298);
				tsExpr(0);
				}
			}

			setState(301);
			match(RPARENTHESIS);
			setState(302);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateReducerContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode CREATE_REDUCER() { return getToken(AngularParser.CREATE_REDUCER, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode COMMA() { return getToken(AngularParser.COMMA, 0); }
		public ReducerOnListContext reducerOnList() {
			return getRuleContext(ReducerOnListContext.class,0);
		}
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public StateReducerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateReducer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateReducer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateReducer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateReducer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateReducerContext stateReducer() throws RecognitionException {
		StateReducerContext _localctx = new StateReducerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stateReducer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(304);
				match(EXPORT);
				}
			}

			setState(307);
			match(CONST);
			setState(308);
			match(ID);
			setState(309);
			match(EQUAL_SIGN);
			setState(310);
			match(CREATE_REDUCER);
			setState(311);
			match(LPARENTHESIS);
			setState(312);
			match(ID);
			setState(313);
			match(COMMA);
			setState(314);
			reducerOnList();
			setState(315);
			match(RPARENTHESIS);
			setState(316);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReducerOnListContext extends ParserRuleContext {
		public List<TerminalNode> ON() { return getTokens(AngularParser.ON); }
		public TerminalNode ON(int i) {
			return getToken(AngularParser.ON, i);
		}
		public List<TerminalNode> LPARENTHESIS() { return getTokens(AngularParser.LPARENTHESIS); }
		public TerminalNode LPARENTHESIS(int i) {
			return getToken(AngularParser.LPARENTHESIS, i);
		}
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public List<ArrowFunctionContext> arrowFunction() {
			return getRuleContexts(ArrowFunctionContext.class);
		}
		public ArrowFunctionContext arrowFunction(int i) {
			return getRuleContext(ArrowFunctionContext.class,i);
		}
		public List<TerminalNode> RPARENTHESIS() { return getTokens(AngularParser.RPARENTHESIS); }
		public TerminalNode RPARENTHESIS(int i) {
			return getToken(AngularParser.RPARENTHESIS, i);
		}
		public ReducerOnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reducerOnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterReducerOnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitReducerOnList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitReducerOnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReducerOnListContext reducerOnList() throws RecognitionException {
		ReducerOnListContext _localctx = new ReducerOnListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_reducerOnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(318);
					match(COMMA);
					}
				}

				setState(321);
				match(ON);
				setState(322);
				match(LPARENTHESIS);
				setState(323);
				match(ID);
				setState(324);
				match(COMMA);
				setState(325);
				arrowFunction();
				setState(326);
				match(RPARENTHESIS);
				}
				}
				setState(330); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA || _la==ON );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentFileContext extends ParserRuleContext {
		public TerminalNode AT_COMPONENT() { return getToken(AngularParser.AT_COMPONENT, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(AngularParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(AngularParser.LBRACE, i);
		}
		public TerminalNode SELECTOR() { return getToken(AngularParser.SELECTOR, 0); }
		public List<TerminalNode> COLON() { return getTokens(AngularParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(AngularParser.COLON, i);
		}
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(AngularParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(AngularParser.RBRACE, i);
		}
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode EXPORT() { return getToken(AngularParser.EXPORT, 0); }
		public TerminalNode CLASS() { return getToken(AngularParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TsContext ts() {
			return getRuleContext(TsContext.class,0);
		}
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public TerminalNode STANDALONE() { return getToken(AngularParser.STANDALONE, 0); }
		public TerminalNode IMPORTS() { return getToken(AngularParser.IMPORTS, 0); }
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public ComponentListContext componentList() {
			return getRuleContext(ComponentListContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public CssOptionContext cssOption() {
			return getRuleContext(CssOptionContext.class,0);
		}
		public HtmlOptionContext htmlOption() {
			return getRuleContext(HtmlOptionContext.class,0);
		}
		public ProvidersOptionContext providersOption() {
			return getRuleContext(ProvidersOptionContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(AngularParser.IMPLEMENTS, 0); }
		public TerminalNode TRUE() { return getToken(AngularParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(AngularParser.FALSE, 0); }
		public List<TerminalNode> SPACE() { return getTokens(AngularParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AngularParser.SPACE, i);
		}
		public ComponentFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterComponentFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitComponentFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitComponentFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentFileContext componentFile() throws RecognitionException {
		ComponentFileContext _localctx = new ComponentFileContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_componentFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(332);
				importStatement();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			match(AT_COMPONENT);
			setState(339);
			match(LPARENTHESIS);
			setState(340);
			match(LBRACE);
			setState(341);
			match(SELECTOR);
			setState(342);
			match(COLON);
			setState(343);
			match(STRING);
			setState(344);
			match(COMMA);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STANDALONE) {
				{
				setState(345);
				match(STANDALONE);
				setState(346);
				match(COLON);
				setState(347);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(348);
				match(COMMA);
				}
			}

			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(351);
				match(IMPORTS);
				setState(352);
				match(COLON);
				setState(353);
				match(LBRACKET);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(354);
					match(SPACE);
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(360);
				componentList();
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(361);
					match(SPACE);
					}
					}
					setState(366);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(367);
				match(RBRACKET);
				setState(368);
				match(COMMA);
				}
			}

			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STYLES || _la==STYLES_URL) {
				{
				setState(372);
				cssOption();
				setState(373);
				match(COMMA);
				}
			}

			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPLATE || _la==TEMPLATE_URL) {
				{
				setState(377);
				htmlOption();
				setState(378);
				match(COMMA);
				}
			}

			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROVIDERS) {
				{
				setState(382);
				providersOption();
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(383);
					match(COMMA);
					}
				}

				}
			}

			setState(388);
			match(RBRACE);
			setState(389);
			match(RPARENTHESIS);
			setState(390);
			match(EXPORT);
			setState(391);
			match(CLASS);
			setState(392);
			match(ID);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(393);
				match(IMPLEMENTS);
				setState(394);
				match(ID);
				}
			}

			setState(397);
			match(LBRACE);
			setState(398);
			ts();
			setState(399);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProvidersOptionContext extends ParserRuleContext {
		public TerminalNode PROVIDERS() { return getToken(AngularParser.PROVIDERS, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public ProviderListContext providerList() {
			return getRuleContext(ProviderListContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public List<TerminalNode> SPACE() { return getTokens(AngularParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AngularParser.SPACE, i);
		}
		public ProvidersOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_providersOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterProvidersOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitProvidersOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitProvidersOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProvidersOptionContext providersOption() throws RecognitionException {
		ProvidersOptionContext _localctx = new ProvidersOptionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_providersOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(PROVIDERS);
			setState(402);
			match(COLON);
			setState(403);
			match(LBRACKET);
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(404);
				match(SPACE);
				}
				}
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(410);
			providerList();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(411);
				match(SPACE);
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(417);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProviderListContext extends ParserRuleContext {
		public List<ProviderExpressionContext> providerExpression() {
			return getRuleContexts(ProviderExpressionContext.class);
		}
		public ProviderExpressionContext providerExpression(int i) {
			return getRuleContext(ProviderExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ProviderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_providerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterProviderList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitProviderList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitProviderList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProviderListContext providerList() throws RecognitionException {
		ProviderListContext _localctx = new ProviderListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_providerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			providerExpression();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(420);
				match(COMMA);
				setState(421);
				providerExpression();
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProviderExpressionContext extends ParserRuleContext {
		public ProviderExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_providerExpression; }
	 
		public ProviderExpressionContext() { }
		public void copyFrom(ProviderExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleProviderContext extends ProviderExpressionContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public SimpleProviderContext(ProviderExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterSimpleProvider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitSimpleProvider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitSimpleProvider(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProvideStoreExpressionContext extends ProviderExpressionContext {
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public ProvideStoreExpressionContext(ProviderExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterProvideStoreExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitProvideStoreExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitProvideStoreExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProviderExpressionContext providerExpression() throws RecognitionException {
		ProviderExpressionContext _localctx = new ProviderExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_providerExpression);
		try {
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new ProvideStoreExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				match(ID);
				setState(428);
				match(LPARENTHESIS);
				setState(429);
				match(LBRACE);
				setState(430);
				match(ID);
				setState(431);
				match(COLON);
				setState(432);
				match(ID);
				setState(433);
				match(RBRACE);
				setState(434);
				match(RPARENTHESIS);
				}
				break;
			case 2:
				_localctx = new SimpleProviderContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssOptionContext extends ParserRuleContext {
		public TerminalNode STYLES() { return getToken(AngularParser.STYLES, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public List<TerminalNode> BACKTICK() { return getTokens(AngularParser.BACKTICK); }
		public TerminalNode BACKTICK(int i) {
			return getToken(AngularParser.BACKTICK, i);
		}
		public CssContext css() {
			return getRuleContext(CssContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public TerminalNode STYLES_URL() { return getToken(AngularParser.STYLES_URL, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public CssOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCssOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCssOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCssOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssOptionContext cssOption() throws RecognitionException {
		CssOptionContext _localctx = new CssOptionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cssOption);
		try {
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STYLES:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(STYLES);
				setState(439);
				match(COLON);
				setState(440);
				match(LBRACKET);
				setState(441);
				match(BACKTICK);
				setState(442);
				css();
				setState(443);
				match(BACKTICK);
				setState(444);
				match(RBRACKET);
				}
				break;
			case STYLES_URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
				match(STYLES_URL);
				setState(447);
				match(COLON);
				setState(448);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlOptionContext extends ParserRuleContext {
		public HtmlOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlOption; }
	 
		public HtmlOptionContext() { }
		public void copyFrom(HtmlOptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineTemplateContext extends HtmlOptionContext {
		public TerminalNode TEMPLATE() { return getToken(AngularParser.TEMPLATE, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public List<TerminalNode> BACKTICK() { return getTokens(AngularParser.BACKTICK); }
		public TerminalNode BACKTICK(int i) {
			return getToken(AngularParser.BACKTICK, i);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public InlineTemplateContext(HtmlOptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterInlineTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitInlineTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitInlineTemplate(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExternalTemplateContext extends HtmlOptionContext {
		public TerminalNode TEMPLATE_URL() { return getToken(AngularParser.TEMPLATE_URL, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public ExternalTemplateContext(HtmlOptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterExternalTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitExternalTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitExternalTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlOptionContext htmlOption() throws RecognitionException {
		HtmlOptionContext _localctx = new HtmlOptionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_htmlOption);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATE:
				_localctx = new InlineTemplateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				match(TEMPLATE);
				setState(452);
				match(COLON);
				setState(453);
				match(BACKTICK);
				setState(454);
				html();
				setState(455);
				match(BACKTICK);
				}
				break;
			case TEMPLATE_URL:
				_localctx = new ExternalTemplateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				match(TEMPLATE_URL);
				setState(458);
				match(COLON);
				setState(459);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(AngularParser.IMPORT, 0); }
		public ImportClauseContext importClause() {
			return getRuleContext(ImportClauseContext.class,0);
		}
		public TerminalNode FROM() { return getToken(AngularParser.FROM, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(IMPORT);
			setState(463);
			importClause();
			setState(464);
			match(FROM);
			setState(465);
			match(STRING);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(466);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportClauseContext extends ParserRuleContext {
		public DefaultImportContext defaultImport() {
			return getRuleContext(DefaultImportContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(AngularParser.COMMA, 0); }
		public NamespaceImportContext namespaceImport() {
			return getRuleContext(NamespaceImportContext.class,0);
		}
		public NamedImportsContext namedImports() {
			return getRuleContext(NamedImportsContext.class,0);
		}
		public ImportClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterImportClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitImportClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitImportClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportClauseContext importClause() throws RecognitionException {
		ImportClauseContext _localctx = new ImportClauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_importClause);
		int _la;
		try {
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				defaultImport();
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(470);
					match(COMMA);
					setState(471);
					namespaceImport();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				defaultImport();
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(475);
					match(COMMA);
					setState(476);
					namedImports();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(479);
				namespaceImport();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(480);
				namedImports();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultImportContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode ON() { return getToken(AngularParser.ON, 0); }
		public TerminalNode CREATE_REDUCER() { return getToken(AngularParser.CREATE_REDUCER, 0); }
		public TerminalNode CREATE_ACTION() { return getToken(AngularParser.CREATE_ACTION, 0); }
		public TerminalNode MAP() { return getToken(AngularParser.MAP, 0); }
		public DefaultImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDefaultImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDefaultImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDefaultImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultImportContext defaultImport() throws RecognitionException {
		DefaultImportContext _localctx = new DefaultImportContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_defaultImport);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0) || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceImportContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(AngularParser.STAR, 0); }
		public TerminalNode AS() { return getToken(AngularParser.AS, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public NamespaceImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNamespaceImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNamespaceImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNamespaceImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceImportContext namespaceImport() throws RecognitionException {
		NamespaceImportContext _localctx = new NamespaceImportContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_namespaceImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(STAR);
			setState(486);
			match(AS);
			setState(487);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedImportsContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public ImportSpecListContext importSpecList() {
			return getRuleContext(ImportSpecListContext.class,0);
		}
		public NamedImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedImports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNamedImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNamedImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNamedImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedImportsContext namedImports() throws RecognitionException {
		NamedImportsContext _localctx = new NamedImportsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_namedImports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(LBRACE);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0) || _la==ID) {
				{
				setState(490);
				importSpecList();
				}
			}

			setState(493);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSpecListContext extends ParserRuleContext {
		public List<ImportSpecifierContext> importSpecifier() {
			return getRuleContexts(ImportSpecifierContext.class);
		}
		public ImportSpecifierContext importSpecifier(int i) {
			return getRuleContext(ImportSpecifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ImportSpecListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpecList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterImportSpecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitImportSpecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitImportSpecList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportSpecListContext importSpecList() throws RecognitionException {
		ImportSpecListContext _localctx = new ImportSpecListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_importSpecList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			importSpecifier();
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(496);
				match(COMMA);
				setState(497);
				importSpecifier();
				}
				}
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSpecifierContext extends ParserRuleContext {
		public List<DefaultImportContext> defaultImport() {
			return getRuleContexts(DefaultImportContext.class);
		}
		public DefaultImportContext defaultImport(int i) {
			return getRuleContext(DefaultImportContext.class,i);
		}
		public TerminalNode AS() { return getToken(AngularParser.AS, 0); }
		public ImportSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterImportSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitImportSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitImportSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportSpecifierContext importSpecifier() throws RecognitionException {
		ImportSpecifierContext _localctx = new ImportSpecifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_importSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			defaultImport();
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(504);
				match(AS);
				setState(505);
				defaultImport();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ComponentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterComponentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitComponentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitComponentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentListContext componentList() throws RecognitionException {
		ComponentListContext _localctx = new ComponentListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_componentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(ID);
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(509);
				match(COMMA);
				setState(510);
				match(ID);
				}
				}
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsContext extends ParserRuleContext {
		public List<TsStatementContext> tsStatement() {
			return getRuleContexts(TsStatementContext.class);
		}
		public TsStatementContext tsStatement(int i) {
			return getRuleContext(TsStatementContext.class,i);
		}
		public TsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsContext ts() throws RecognitionException {
		TsContext _localctx = new TsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & 15036579841L) != 0) || _la==ID) {
				{
				{
				setState(516);
				tsStatement();
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsStatementContext extends ParserRuleContext {
		public TsAttributeContext tsAttribute() {
			return getRuleContext(TsAttributeContext.class,0);
		}
		public StateDeclContext stateDecl() {
			return getRuleContext(StateDeclContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public TsStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTsStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTsStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTsStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsStatementContext tsStatement() throws RecognitionException {
		TsStatementContext _localctx = new TsStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tsStatement);
		try {
			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				tsAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				stateDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(524);
				method();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(525);
				constructor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsAttributeContext extends ParserRuleContext {
		public TsAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsAttribute; }
	 
		public TsAttributeContext() { }
		public void copyFrom(TsAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareAttributeContext extends TsAttributeContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public DeclareAttributeContext(TsAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDeclareAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDeclareAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDeclareAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareAndAssignAttributeContext extends TsAttributeContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public DeclareAndAssignAttributeContext(TsAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDeclareAndAssignAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDeclareAndAssignAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDeclareAndAssignAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsAttributeContext tsAttribute() throws RecognitionException {
		TsAttributeContext _localctx = new TsAttributeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tsAttribute);
		int _la;
		try {
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new DeclareAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
					{
					setState(528);
					primitiveDataType();
					}
				}

				setState(531);
				match(ID);
				setState(532);
				match(COLON);
				setState(533);
				tsType();
				setState(534);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new DeclareAndAssignAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
					{
					setState(536);
					primitiveDataType();
					}
				}

				setState(539);
				match(ID);
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(540);
					match(COLON);
					setState(541);
					tsType();
					}
				}

				setState(544);
				match(EQUAL_SIGN);
				setState(545);
				tsExpr(0);
				setState(546);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateDeclContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(AngularParser.STATE, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public List<StatePropertyContext> stateProperty() {
			return getRuleContexts(StatePropertyContext.class);
		}
		public StatePropertyContext stateProperty(int i) {
			return getRuleContext(StatePropertyContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public StateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateDeclContext stateDecl() throws RecognitionException {
		StateDeclContext _localctx = new StateDeclContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stateDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(STATE);
			setState(551);
			match(COLON);
			setState(552);
			match(LBRACE);
			setState(553);
			stateProperty();
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(554);
				match(COMMA);
				setState(555);
				stateProperty();
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(561);
			match(RBRACE);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(562);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatePropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public StateValueContext stateValue() {
			return getRuleContext(StateValueContext.class,0);
		}
		public StatePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatePropertyContext stateProperty() throws RecognitionException {
		StatePropertyContext _localctx = new StatePropertyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_stateProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(ID);
			setState(566);
			match(COLON);
			setState(567);
			stateValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateValueContext extends ParserRuleContext {
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public ObjectValueContext objectValue() {
			return getRuleContext(ObjectValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public TerminalNode NUMERIC_VALUE() { return getToken(AngularParser.NUMERIC_VALUE, 0); }
		public TerminalNode NULL() { return getToken(AngularParser.NULL, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public StateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStateValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStateValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStateValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateValueContext stateValue() throws RecognitionException {
		StateValueContext _localctx = new StateValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_stateValue);
		try {
			setState(575);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				arrayValue();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				objectValue();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(571);
				match(STRING);
				}
				break;
			case NUMERIC_VALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(572);
				match(NUMERIC_VALUE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(573);
				match(NULL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(574);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public List<StateValueContext> stateValue() {
			return getRuleContexts(StateValueContext.class);
		}
		public StateValueContext stateValue(int i) {
			return getRuleContext(StateValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ArrayValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueContext arrayValue() throws RecognitionException {
		ArrayValueContext _localctx = new ArrayValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arrayValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(LBRACKET);
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125900049973248L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
				{
				setState(578);
				stateValue();
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(579);
					match(COMMA);
					setState(580);
					stateValue();
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(588);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectValueContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<StatePropertyContext> stateProperty() {
			return getRuleContexts(StatePropertyContext.class);
		}
		public StatePropertyContext stateProperty(int i) {
			return getRuleContext(StatePropertyContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ObjectValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitObjectValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitObjectValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectValueContext objectValue() throws RecognitionException {
		ObjectValueContext _localctx = new ObjectValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_objectValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(LBRACE);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(591);
				stateProperty();
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(592);
					match(COMMA);
					setState(593);
					stateProperty();
					}
					}
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(601);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode CONSTRUCTOR() { return getToken(AngularParser.CONSTRUCTOR, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public ConstructorParamsContext constructorParams() {
			return getRuleContext(ConstructorParamsContext.class,0);
		}
		public List<TsStmtContext> tsStmt() {
			return getRuleContexts(TsStmtContext.class);
		}
		public TsStmtContext tsStmt(int i) {
			return getRuleContext(TsStmtContext.class,i);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
				{
				setState(603);
				primitiveDataType();
				}
			}

			setState(606);
			match(CONSTRUCTOR);
			setState(607);
			match(LPARENTHESIS);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0) || _la==ID) {
				{
				setState(608);
				constructorParams();
				}
			}

			setState(611);
			match(RPARENTHESIS);
			setState(612);
			match(LBRACE);
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
				{
				{
				setState(613);
				tsStmt();
				}
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(619);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorParamsContext extends ParserRuleContext {
		public List<ConstructorParamContext> constructorParam() {
			return getRuleContexts(ConstructorParamContext.class);
		}
		public ConstructorParamContext constructorParam(int i) {
			return getRuleContext(ConstructorParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ConstructorParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterConstructorParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitConstructorParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitConstructorParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorParamsContext constructorParams() throws RecognitionException {
		ConstructorParamsContext _localctx = new ConstructorParamsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_constructorParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			constructorParam();
			setState(626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(622);
				match(COMMA);
				setState(623);
				constructorParam();
				}
				}
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public ConstructorParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterConstructorParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitConstructorParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitConstructorParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorParamContext constructorParam() throws RecognitionException {
		ConstructorParamContext _localctx = new ConstructorParamContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_constructorParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
				{
				setState(629);
				primitiveDataType();
				}
			}

			setState(632);
			match(ID);
			setState(633);
			match(COLON);
			setState(634);
			tsType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public MethodParamsContext methodParams() {
			return getRuleContext(MethodParamsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public List<TsStmtContext> tsStmt() {
			return getRuleContexts(TsStmtContext.class);
		}
		public TsStmtContext tsStmt(int i) {
			return getRuleContext(TsStmtContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
				{
				setState(636);
				primitiveDataType();
				}
			}

			setState(639);
			match(ID);
			setState(640);
			match(LPARENTHESIS);
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(641);
				methodParams();
				}
			}

			setState(644);
			match(RPARENTHESIS);
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(645);
				match(COLON);
				setState(646);
				tsType();
				}
			}

			setState(649);
			match(LBRACE);
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
				{
				{
				setState(650);
				tsStmt();
				}
				}
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(656);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodParamsContext extends ParserRuleContext {
		public List<MethodParamContext> methodParam() {
			return getRuleContexts(MethodParamContext.class);
		}
		public MethodParamContext methodParam(int i) {
			return getRuleContext(MethodParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public MethodParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterMethodParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitMethodParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitMethodParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodParamsContext methodParams() throws RecognitionException {
		MethodParamsContext _localctx = new MethodParamsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_methodParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			methodParam();
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(659);
				match(COMMA);
				setState(660);
				methodParam();
				}
				}
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(AngularParser.QUESTION, 0); }
		public MethodParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterMethodParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitMethodParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitMethodParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodParamContext methodParam() throws RecognitionException {
		MethodParamContext _localctx = new MethodParamContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_methodParam);
		try {
			setState(673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				match(ID);
				setState(667);
				match(COLON);
				setState(668);
				paramType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(669);
				match(ID);
				setState(670);
				match(QUESTION);
				setState(671);
				match(COLON);
				setState(672);
				paramType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamTypeContext extends ParserRuleContext {
		public TerminalNode EVENT() { return getToken(AngularParser.EVENT, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterParamType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitParamType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitParamType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_paramType);
		try {
			setState(677);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EVENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				match(EVENT);
				}
				break;
			case NUMBER:
			case STRINGDL:
			case BOOLEAN:
			case ANY:
			case NULL:
			case UNDEFINED:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				tsType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsTypeContext extends ParserRuleContext {
		public List<GenericOrBasicTypeContext> genericOrBasicType() {
			return getRuleContexts(GenericOrBasicTypeContext.class);
		}
		public GenericOrBasicTypeContext genericOrBasicType(int i) {
			return getRuleContext(GenericOrBasicTypeContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(AngularParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(AngularParser.PIPE, i);
		}
		public TsTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTsType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTsType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTsType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsTypeContext tsType() throws RecognitionException {
		TsTypeContext _localctx = new TsTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tsType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			genericOrBasicType();
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(680);
				match(PIPE);
				setState(681);
				genericOrBasicType();
				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericOrBasicTypeContext extends ParserRuleContext {
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode UNDEFINED() { return getToken(AngularParser.UNDEFINED, 0); }
		public GenericOrBasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericOrBasicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterGenericOrBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitGenericOrBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitGenericOrBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericOrBasicTypeContext genericOrBasicType() throws RecognitionException {
		GenericOrBasicTypeContext _localctx = new GenericOrBasicTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_genericOrBasicType);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				genericType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(688);
				arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(689);
				type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(690);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(691);
				match(UNDEFINED);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode TAG_OPEN() { return getToken(AngularParser.TAG_OPEN, 0); }
		public List<GenericTypeParamContext> genericTypeParam() {
			return getRuleContexts(GenericTypeParamContext.class);
		}
		public GenericTypeParamContext genericTypeParam(int i) {
			return getRuleContext(GenericTypeParamContext.class,i);
		}
		public TerminalNode TAG_CLOSE() { return getToken(AngularParser.TAG_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public GenericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterGenericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitGenericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitGenericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeContext genericType() throws RecognitionException {
		GenericTypeContext _localctx = new GenericTypeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_genericType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(ID);
			setState(695);
			match(TAG_OPEN);
			setState(696);
			genericTypeParam();
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(697);
				match(COMMA);
				setState(698);
				genericTypeParam();
				}
				}
				setState(703);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(704);
			match(TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericTypeParamContext extends ParserRuleContext {
		public GenericOrBasicTypeContext genericOrBasicType() {
			return getRuleContext(GenericOrBasicTypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public GenericTypeParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterGenericTypeParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitGenericTypeParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitGenericTypeParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeParamContext genericTypeParam() throws RecognitionException {
		GenericTypeParamContext _localctx = new GenericTypeParamContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_genericTypeParam);
		try {
			setState(708);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case STRINGDL:
			case BOOLEAN:
			case ANY:
			case NULL:
			case UNDEFINED:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(706);
				genericOrBasicType();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(712);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case STRINGDL:
			case BOOLEAN:
			case ANY:
			case NULL:
				{
				setState(710);
				type();
				}
				break;
			case ID:
				{
				setState(711);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(714);
			match(LBRACKET);
			setState(715);
			match(RBRACKET);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(AngularParser.NUMBER, 0); }
		public TerminalNode STRINGDL() { return getToken(AngularParser.STRINGDL, 0); }
		public TerminalNode BOOLEAN() { return getToken(AngularParser.BOOLEAN, 0); }
		public TerminalNode ANY() { return getToken(AngularParser.ANY, 0); }
		public TerminalNode NULL() { return getToken(AngularParser.NULL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1653665488175104L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsStmtContext extends ParserRuleContext {
		public TsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsStmt; }
	 
		public TsStmtContext() { }
		public void copyFrom(TsStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareVariableContext extends TsStmtContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public TerminalNode LET() { return getToken(AngularParser.LET, 0); }
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public DeclareVariableContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDeclareVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDeclareVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDeclareVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends TsStmtContext {
		public TerminalNode FOR() { return getToken(AngularParser.FOR, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public List<TsStmtContext> tsStmt() {
			return getRuleContexts(TsStmtContext.class);
		}
		public TsStmtContext tsStmt(int i) {
			return getRuleContext(TsStmtContext.class,i);
		}
		public ForContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends TsStmtContext {
		public TerminalNode RETURN() { return getToken(AngularParser.RETURN, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public ReturnStatementContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStatementContext extends TsStmtContext {
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public ExprStatementContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitExprStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends TsStmtContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public AssignContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends TsStmtContext {
		public TerminalNode IF() { return getToken(AngularParser.IF, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public List<TsStmtContext> tsStmt() {
			return getRuleContexts(TsStmtContext.class);
		}
		public TsStmtContext tsStmt(int i) {
			return getRuleContext(TsStmtContext.class,i);
		}
		public IfContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareAndAssignContext extends TsStmtContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AngularParser.SEMICOLON, 0); }
		public TerminalNode LET() { return getToken(AngularParser.LET, 0); }
		public TerminalNode CONST() { return getToken(AngularParser.CONST, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsTypeContext tsType() {
			return getRuleContext(TsTypeContext.class,0);
		}
		public DeclareAndAssignContext(TsStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDeclareAndAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDeclareAndAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDeclareAndAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsStmtContext tsStmt() throws RecognitionException {
		TsStmtContext _localctx = new TsStmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_tsStmt);
		int _la;
		try {
			setState(776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				_localctx = new DeclareVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(719);
				_la = _input.LA(1);
				if ( !(_la==LET || _la==CONST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(720);
				match(ID);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(721);
					match(COLON);
					setState(722);
					tsType();
					}
				}

				setState(725);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new DeclareAndAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				_la = _input.LA(1);
				if ( !(_la==LET || _la==CONST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(727);
				match(ID);
				setState(730);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(728);
					match(COLON);
					setState(729);
					tsType();
					}
				}

				setState(732);
				match(EQUAL_SIGN);
				setState(733);
				tsExpr(0);
				setState(734);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(736);
				leftHandSide();
				setState(737);
				match(EQUAL_SIGN);
				setState(738);
				tsExpr(0);
				setState(739);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(741);
				match(IF);
				setState(742);
				match(LPARENTHESIS);
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612811918479459072L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					setState(743);
					tsExpr(0);
					}
				}

				setState(746);
				match(RPARENTHESIS);
				setState(747);
				match(LBRACE);
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					{
					setState(748);
					tsStmt();
					}
					}
					setState(753);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(754);
				match(RBRACE);
				}
				break;
			case 5:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(755);
				match(FOR);
				setState(756);
				match(LPARENTHESIS);
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(757);
					match(STRING);
					}
				}

				setState(760);
				match(RPARENTHESIS);
				setState(761);
				match(LBRACE);
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					{
					setState(762);
					tsStmt();
					}
					}
					setState(767);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(768);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(769);
				match(RETURN);
				setState(770);
				tsExpr(0);
				setState(771);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(773);
				tsExpr(0);
				setState(774);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsExprContext extends ParserRuleContext {
		public TsExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsExpr; }
	 
		public TsExprContext() { }
		public void copyFrom(TsExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends TsExprContext {
		public List<TsExprContext> tsExpr() {
			return getRuleContexts(TsExprContext.class);
		}
		public TsExprContext tsExpr(int i) {
			return getRuleContext(TsExprContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(AngularParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TernaryExprContext(TsExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTernaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends TsExprContext {
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode OR_OP() { return getToken(AngularParser.OR_OP, 0); }
		public TsAndExprContext tsAndExpr() {
			return getRuleContext(TsAndExprContext.class,0);
		}
		public OrExprContext(TsExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToAndContext extends TsExprContext {
		public TsAndExprContext tsAndExpr() {
			return getRuleContext(TsAndExprContext.class,0);
		}
		public ToAndContext(TsExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsExprContext tsExpr() throws RecognitionException {
		return tsExpr(0);
	}

	private TsExprContext tsExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsExprContext _localctx = new TsExprContext(_ctx, _parentState);
		TsExprContext _prevctx = _localctx;
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_tsExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAndContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(779);
			tsAndExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(792);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(790);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						_localctx = new TernaryExprContext(new TsExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_tsExpr);
						setState(781);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(782);
						match(QUESTION);
						setState(783);
						tsExpr(0);
						setState(784);
						match(COLON);
						setState(785);
						tsExpr(2);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new TsExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_tsExpr);
						setState(787);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(788);
						match(OR_OP);
						setState(789);
						tsAndExpr(0);
						}
						break;
					}
					} 
				}
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftHandSideContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public TerminalNode THIS() { return getToken(AngularParser.THIS, 0); }
		public List<TerminalNode> DOT() { return getTokens(AngularParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(AngularParser.DOT, i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(AngularParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(AngularParser.LBRACKET, i);
		}
		public List<TsExprContext> tsExpr() {
			return getRuleContexts(TsExprContext.class);
		}
		public TsExprContext tsExpr(int i) {
			return getRuleContext(TsExprContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(AngularParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(AngularParser.RBRACKET, i);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitLeftHandSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitLeftHandSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_leftHandSide);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THIS) {
				{
				setState(795);
				match(THIS);
				setState(796);
				match(DOT);
				}
			}

			setState(799);
			match(ID);
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET || _la==DOT) {
				{
				setState(806);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					{
					setState(800);
					match(DOT);
					setState(801);
					match(ID);
					}
					}
					break;
				case LBRACKET:
					{
					{
					setState(802);
					match(LBRACKET);
					setState(803);
					tsExpr(0);
					setState(804);
					match(RBRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(810);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsAndExprContext extends ParserRuleContext {
		public TsAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsAndExpr; }
	 
		public TsAndExprContext() { }
		public void copyFrom(TsAndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToEqContext extends TsAndExprContext {
		public TsEqExprContext tsEqExpr() {
			return getRuleContext(TsEqExprContext.class,0);
		}
		public ToEqContext(TsAndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends TsAndExprContext {
		public TsAndExprContext tsAndExpr() {
			return getRuleContext(TsAndExprContext.class,0);
		}
		public TerminalNode AND_OP() { return getToken(AngularParser.AND_OP, 0); }
		public TsEqExprContext tsEqExpr() {
			return getRuleContext(TsEqExprContext.class,0);
		}
		public AndExprContext(TsAndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsAndExprContext tsAndExpr() throws RecognitionException {
		return tsAndExpr(0);
	}

	private TsAndExprContext tsAndExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsAndExprContext _localctx = new TsAndExprContext(_ctx, _parentState);
		TsAndExprContext _prevctx = _localctx;
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_tsAndExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToEqContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(812);
			tsEqExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(819);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(new TsAndExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_tsAndExpr);
					setState(814);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(815);
					match(AND_OP);
					setState(816);
					tsEqExpr(0);
					}
					} 
				}
				setState(821);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsEqExprContext extends ParserRuleContext {
		public TsEqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsEqExpr; }
	 
		public TsEqExprContext() { }
		public void copyFrom(TsEqExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToRelContext extends TsEqExprContext {
		public TsRelExprContext tsRelExpr() {
			return getRuleContext(TsRelExprContext.class,0);
		}
		public ToRelContext(TsEqExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToRel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqNeqContext extends TsEqExprContext {
		public TsEqExprContext tsEqExpr() {
			return getRuleContext(TsEqExprContext.class,0);
		}
		public TsRelExprContext tsRelExpr() {
			return getRuleContext(TsRelExprContext.class,0);
		}
		public TerminalNode EQEQ() { return getToken(AngularParser.EQEQ, 0); }
		public TerminalNode EQEQEQ() { return getToken(AngularParser.EQEQEQ, 0); }
		public TerminalNode NEQ() { return getToken(AngularParser.NEQ, 0); }
		public TerminalNode NEQEQ() { return getToken(AngularParser.NEQEQ, 0); }
		public EqNeqContext(TsEqExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterEqNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitEqNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitEqNeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsEqExprContext tsEqExpr() throws RecognitionException {
		return tsEqExpr(0);
	}

	private TsEqExprContext tsEqExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsEqExprContext _localctx = new TsEqExprContext(_ctx, _parentState);
		TsEqExprContext _prevctx = _localctx;
		int _startState = 108;
		enterRecursionRule(_localctx, 108, RULE_tsEqExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToRelContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(823);
			tsRelExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(830);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqNeqContext(new TsEqExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_tsEqExpr);
					setState(825);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(826);
					_la = _input.LA(1);
					if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 15L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(827);
					tsRelExpr(0);
					}
					} 
				}
				setState(832);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsRelExprContext extends ParserRuleContext {
		public TsRelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsRelExpr; }
	 
		public TsRelExprContext() { }
		public void copyFrom(TsRelExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToAddContext extends TsRelExprContext {
		public TsAddExprContext tsAddExpr() {
			return getRuleContext(TsAddExprContext.class,0);
		}
		public ToAddContext(TsRelExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends TsRelExprContext {
		public TsRelExprContext tsRelExpr() {
			return getRuleContext(TsRelExprContext.class,0);
		}
		public TsAddExprContext tsAddExpr() {
			return getRuleContext(TsAddExprContext.class,0);
		}
		public TerminalNode TAG_OPEN() { return getToken(AngularParser.TAG_OPEN, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(AngularParser.TAG_CLOSE, 0); }
		public TerminalNode LTE() { return getToken(AngularParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(AngularParser.GTE, 0); }
		public RelationalContext(TsRelExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsRelExprContext tsRelExpr() throws RecognitionException {
		return tsRelExpr(0);
	}

	private TsRelExprContext tsRelExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsRelExprContext _localctx = new TsRelExprContext(_ctx, _parentState);
		TsRelExprContext _prevctx = _localctx;
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_tsRelExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAddContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(834);
			tsAddExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(841);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationalContext(new TsRelExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_tsRelExpr);
					setState(836);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(837);
					_la = _input.LA(1);
					if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 49155L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(838);
					tsAddExpr(0);
					}
					} 
				}
				setState(843);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsAddExprContext extends ParserRuleContext {
		public TsAddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsAddExpr; }
	 
		public TsAddExprContext() { }
		public void copyFrom(TsAddExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends TsAddExprContext {
		public TsAddExprContext tsAddExpr() {
			return getRuleContext(TsAddExprContext.class,0);
		}
		public TsMulExprContext tsMulExpr() {
			return getRuleContext(TsMulExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(AngularParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AngularParser.MINUS, 0); }
		public AddSubContext(TsAddExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToMulContext extends TsAddExprContext {
		public TsMulExprContext tsMulExpr() {
			return getRuleContext(TsMulExprContext.class,0);
		}
		public ToMulContext(TsAddExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsAddExprContext tsAddExpr() throws RecognitionException {
		return tsAddExpr(0);
	}

	private TsAddExprContext tsAddExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsAddExprContext _localctx = new TsAddExprContext(_ctx, _parentState);
		TsAddExprContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_tsAddExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMulContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(845);
			tsMulExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(852);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddSubContext(new TsAddExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_tsAddExpr);
					setState(847);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(848);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(849);
					tsMulExpr(0);
					}
					} 
				}
				setState(854);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsMulExprContext extends ParserRuleContext {
		public TsMulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsMulExpr; }
	 
		public TsMulExprContext() { }
		public void copyFrom(TsMulExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToUnaryContext extends TsMulExprContext {
		public TsUnaryExprContext tsUnaryExpr() {
			return getRuleContext(TsUnaryExprContext.class,0);
		}
		public ToUnaryContext(TsMulExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends TsMulExprContext {
		public TsMulExprContext tsMulExpr() {
			return getRuleContext(TsMulExprContext.class,0);
		}
		public TsUnaryExprContext tsUnaryExpr() {
			return getRuleContext(TsUnaryExprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(AngularParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(AngularParser.SLASH, 0); }
		public MulDivContext(TsMulExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsMulExprContext tsMulExpr() throws RecognitionException {
		return tsMulExpr(0);
	}

	private TsMulExprContext tsMulExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TsMulExprContext _localctx = new TsMulExprContext(_ctx, _parentState);
		TsMulExprContext _prevctx = _localctx;
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_tsMulExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToUnaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(856);
			tsUnaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(863);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulDivContext(new TsMulExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_tsMulExpr);
					setState(858);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(859);
					_la = _input.LA(1);
					if ( !(_la==STAR || _la==SLASH) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(860);
					tsUnaryExpr();
					}
					} 
				}
				setState(865);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsUnaryExprContext extends ParserRuleContext {
		public TsUnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsUnaryExpr; }
	 
		public TsUnaryExprContext() { }
		public void copyFrom(TsUnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends TsUnaryExprContext {
		public TsUnaryExprContext tsUnaryExpr() {
			return getRuleContext(TsUnaryExprContext.class,0);
		}
		public TerminalNode NOT_OP() { return getToken(AngularParser.NOT_OP, 0); }
		public TerminalNode PLUS() { return getToken(AngularParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AngularParser.MINUS, 0); }
		public UnaryOpContext(TsUnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToPrimaryContext extends TsUnaryExprContext {
		public TsPrimaryContext tsPrimary() {
			return getRuleContext(TsPrimaryContext.class,0);
		}
		public ToPrimaryContext(TsUnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterToPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitToPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitToPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsUnaryExprContext tsUnaryExpr() throws RecognitionException {
		TsUnaryExprContext _localctx = new TsUnaryExprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_tsUnaryExpr);
		int _la;
		try {
			setState(869);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT_OP:
				_localctx = new UnaryOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(866);
				_la = _input.LA(1);
				if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 67L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(867);
				tsUnaryExpr();
				}
				break;
			case TRUE:
			case FALSE:
			case LBRACE:
			case LPARENTHESIS:
			case LBRACKET:
			case STRING:
			case NULL:
			case NEW:
			case THIS:
			case NUMERIC_VALUE:
			case ID:
				_localctx = new ToPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				tsPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsPrimaryContext extends ParserRuleContext {
		public TsAtomContext tsAtom() {
			return getRuleContext(TsAtomContext.class,0);
		}
		public List<TsPostfixContext> tsPostfix() {
			return getRuleContexts(TsPostfixContext.class);
		}
		public TsPostfixContext tsPostfix(int i) {
			return getRuleContext(TsPostfixContext.class,i);
		}
		public TsPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTsPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTsPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTsPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsPrimaryContext tsPrimary() throws RecognitionException {
		TsPrimaryContext _localctx = new TsPrimaryContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_tsPrimary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			tsAtom();
			setState(875);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(872);
					tsPostfix();
					}
					} 
				}
				setState(877);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsAtomContext extends ParserRuleContext {
		public TsAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsAtom; }
	 
		public TsAtomContext() { }
		public void copyFrom(TsAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends TsAtomContext {
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public List<SpreadOrExprContext> spreadOrExpr() {
			return getRuleContexts(SpreadOrExprContext.class);
		}
		public SpreadOrExprContext spreadOrExpr(int i) {
			return getRuleContext(SpreadOrExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ArrayContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullContext extends TsAtomContext {
		public TerminalNode NULL() { return getToken(AngularParser.NULL, 0); }
		public NullContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KeyValueContext extends TsAtomContext {
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public KeyValueContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends TsAtomContext {
		public TerminalNode NUMERIC_VALUE() { return getToken(AngularParser.NUMERIC_VALUE, 0); }
		public NumberContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisRefContext extends TsAtomContext {
		public TerminalNode THIS() { return getToken(AngularParser.THIS, 0); }
		public ThisRefContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterThisRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitThisRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitThisRef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanFalseContext extends TsAtomContext {
		public TerminalNode FALSE() { return getToken(AngularParser.FALSE, 0); }
		public BooleanFalseContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterBooleanFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitBooleanFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitBooleanFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends TsAtomContext {
		public TerminalNode NEW() { return getToken(AngularParser.NEW, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public GenericTypeArgumentsContext genericTypeArguments() {
			return getRuleContext(GenericTypeArgumentsContext.class,0);
		}
		public List<TsExprContext> tsExpr() {
			return getRuleContexts(TsExprContext.class);
		}
		public TsExprContext tsExpr(int i) {
			return getRuleContext(TsExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public NewExpressionContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrowFnContext extends TsAtomContext {
		public ArrowFunctionContext arrowFunction() {
			return getRuleContext(ArrowFunctionContext.class,0);
		}
		public ArrowFnContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterArrowFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitArrowFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitArrowFn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StoredIDContext extends TsAtomContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public StoredIDContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterStoredID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitStoredID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitStoredID(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends TsAtomContext {
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public StringContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTrueContext extends TsAtomContext {
		public TerminalNode TRUE() { return getToken(AngularParser.TRUE, 0); }
		public BooleanTrueContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterBooleanTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitBooleanTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitBooleanTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends TsAtomContext {
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public ParenContext(TsAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsAtomContext tsAtom() throws RecognitionException {
		TsAtomContext _localctx = new TsAtomContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_tsAtom);
		int _la;
		try {
			setState(931);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				_localctx = new ThisRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(878);
				match(THIS);
				}
				break;
			case 2:
				_localctx = new StoredIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(879);
				match(ID);
				}
				break;
			case 3:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(880);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(881);
				match(NUMERIC_VALUE);
				}
				break;
			case 5:
				_localctx = new BooleanTrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(882);
				match(TRUE);
				}
				break;
			case 6:
				_localctx = new BooleanFalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(883);
				match(FALSE);
				}
				break;
			case 7:
				_localctx = new KeyValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(884);
				match(LBRACE);
				{
				setState(893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING || _la==ELLIPSIS || _la==ID) {
					{
					setState(885);
					keyValuePair();
					setState(890);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(886);
						match(COMMA);
						setState(887);
						keyValuePair();
						}
						}
						setState(892);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				setState(895);
				match(RBRACE);
				}
				break;
			case 8:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(896);
				match(LBRACKET);
				{
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612811918479459072L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 541L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					setState(897);
					spreadOrExpr();
					setState(902);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(898);
						match(COMMA);
						setState(899);
						spreadOrExpr();
						}
						}
						setState(904);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				setState(907);
				match(RBRACKET);
				}
				break;
			case 9:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(908);
				match(LPARENTHESIS);
				setState(909);
				tsExpr(0);
				setState(910);
				match(RPARENTHESIS);
				}
				break;
			case 10:
				_localctx = new ArrowFnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(912);
				arrowFunction();
				}
				break;
			case 11:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(913);
				match(NULL);
				}
				break;
			case 12:
				_localctx = new NewExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(914);
				match(NEW);
				setState(915);
				match(ID);
				setState(917);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TAG_OPEN) {
					{
					setState(916);
					genericTypeArguments();
					}
				}

				setState(919);
				match(LPARENTHESIS);
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612811918479459072L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					setState(920);
					tsExpr(0);
					setState(925);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(921);
						match(COMMA);
						setState(922);
						tsExpr(0);
						}
						}
						setState(927);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(930);
				match(RPARENTHESIS);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TsPostfixContext extends ParserRuleContext {
		public TsPostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsPostfix; }
	 
		public TsPostfixContext() { }
		public void copyFrom(TsPostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends TsPostfixContext {
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode ELLIPSIS() { return getToken(AngularParser.ELLIPSIS, 0); }
		public List<TsExprContext> tsExpr() {
			return getRuleContexts(TsExprContext.class);
		}
		public TsExprContext tsExpr(int i) {
			return getRuleContext(TsExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public CallContext(TsPostfixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotAccessContext extends TsPostfixContext {
		public TerminalNode DOT() { return getToken(AngularParser.DOT, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public DotAccessContext(TsPostfixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDotAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDotAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDotAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotCallContext extends TsPostfixContext {
		public TerminalNode DOT() { return getToken(AngularParser.DOT, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public List<TsExprContext> tsExpr() {
			return getRuleContexts(TsExprContext.class);
		}
		public TsExprContext tsExpr(int i) {
			return getRuleContext(TsExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public DotCallContext(TsPostfixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterDotCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitDotCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitDotCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketAccessContext extends TsPostfixContext {
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public BracketAccessContext(TsPostfixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterBracketAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitBracketAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitBracketAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsPostfixContext tsPostfix() throws RecognitionException {
		TsPostfixContext _localctx = new TsPostfixContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_tsPostfix);
		int _la;
		try {
			setState(968);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				_localctx = new DotCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(933);
				match(DOT);
				setState(934);
				match(ID);
				setState(935);
				match(LPARENTHESIS);
				setState(944);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612811918479459072L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					setState(936);
					tsExpr(0);
					setState(941);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(937);
						match(COMMA);
						setState(938);
						tsExpr(0);
						}
						}
						setState(943);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(946);
				match(RPARENTHESIS);
				}
				break;
			case 2:
				_localctx = new DotAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(947);
				match(DOT);
				setState(948);
				match(ID);
				}
				break;
			case 3:
				_localctx = new BracketAccessContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(949);
				match(LBRACKET);
				setState(950);
				tsExpr(0);
				setState(951);
				match(RBRACKET);
				}
				break;
			case 4:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(953);
				match(LPARENTHESIS);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELLIPSIS) {
					{
					setState(954);
					match(ELLIPSIS);
					}
				}

				setState(965);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612811918479459072L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
					{
					setState(957);
					tsExpr(0);
					setState(962);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(958);
						match(COMMA);
						setState(959);
						tsExpr(0);
						}
						}
						setState(964);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(967);
				match(RPARENTHESIS);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericTypeArgumentsContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(AngularParser.TAG_OPEN, 0); }
		public List<GenericTypeParamContext> genericTypeParam() {
			return getRuleContexts(GenericTypeParamContext.class);
		}
		public GenericTypeParamContext genericTypeParam(int i) {
			return getRuleContext(GenericTypeParamContext.class,i);
		}
		public TerminalNode TAG_CLOSE() { return getToken(AngularParser.TAG_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public GenericTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterGenericTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitGenericTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitGenericTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeArgumentsContext genericTypeArguments() throws RecognitionException {
		GenericTypeArgumentsContext _localctx = new GenericTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_genericTypeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			match(TAG_OPEN);
			setState(971);
			genericTypeParam();
			setState(976);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(972);
				match(COMMA);
				setState(973);
				genericTypeParam();
				}
				}
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(979);
			match(TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpreadOrExprContext extends ParserRuleContext {
		public SpreadOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spreadOrExpr; }
	 
		public SpreadOrExprContext() { }
		public void copyFrom(SpreadOrExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SpreadContext extends SpreadOrExprContext {
		public TerminalNode ELLIPSIS() { return getToken(AngularParser.ELLIPSIS, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public SpreadContext(SpreadOrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterSpread(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitSpread(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitSpread(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoSpreadContext extends SpreadOrExprContext {
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public NoSpreadContext(SpreadOrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNoSpread(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNoSpread(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNoSpread(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpreadOrExprContext spreadOrExpr() throws RecognitionException {
		SpreadOrExprContext _localctx = new SpreadOrExprContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_spreadOrExpr);
		try {
			setState(984);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELLIPSIS:
				_localctx = new SpreadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(981);
				match(ELLIPSIS);
				setState(982);
				tsExpr(0);
				}
				break;
			case TRUE:
			case FALSE:
			case LBRACE:
			case LPARENTHESIS:
			case LBRACKET:
			case STRING:
			case NULL:
			case NEW:
			case THIS:
			case PLUS:
			case MINUS:
			case NOT_OP:
			case NUMERIC_VALUE:
			case ID:
				_localctx = new NoSpreadContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(983);
				tsExpr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrowFunctionContext extends ParserRuleContext {
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode ARROW() { return getToken(AngularParser.ARROW, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public List<TsStmtContext> tsStmt() {
			return getRuleContexts(TsStmtContext.class);
		}
		public TsStmtContext tsStmt(int i) {
			return getRuleContext(TsStmtContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AngularParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AngularParser.COMMA, i);
		}
		public ArrowFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterArrowFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitArrowFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitArrowFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowFunctionContext arrowFunction() throws RecognitionException {
		ArrowFunctionContext _localctx = new ArrowFunctionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_arrowFunction);
		int _la;
		try {
			setState(1023);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPARENTHESIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(986);
				match(LPARENTHESIS);
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(987);
					match(ID);
					setState(992);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(988);
						match(COMMA);
						setState(989);
						match(ID);
						}
						}
						setState(994);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(997);
				match(RPARENTHESIS);
				setState(998);
				match(ARROW);
				setState(1008);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(999);
					tsExpr(0);
					}
					break;
				case 2:
					{
					setState(1000);
					match(LBRACE);
					setState(1004);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
						{
						{
						setState(1001);
						tsStmt();
						}
						}
						setState(1006);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1007);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1010);
				match(ID);
				setState(1011);
				match(ARROW);
				setState(1021);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(1012);
					tsExpr(0);
					}
					break;
				case 2:
					{
					setState(1013);
					match(LBRACE);
					setState(1017);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4736660908232147712L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 537L) != 0) || _la==NUMERIC_VALUE || _la==ID) {
						{
						{
						setState(1014);
						tsStmt();
						}
						}
						setState(1019);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1020);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyValuePairContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TsExprContext tsExpr() {
			return getRuleContext(TsExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public TerminalNode ELLIPSIS() { return getToken(AngularParser.ELLIPSIS, 0); }
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_keyValuePair);
		int _la;
		try {
			setState(1030);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1025);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1026);
				match(COLON);
				setState(1027);
				tsExpr(0);
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1028);
				match(ELLIPSIS);
				setState(1029);
				tsExpr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveDataTypeContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(AngularParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(AngularParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(AngularParser.PROTECTED, 0); }
		public TerminalNode READONLY() { return getToken(AngularParser.READONLY, 0); }
		public PrimitiveDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterPrimitiveDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitPrimitiveDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitPrimitiveDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveDataTypeContext primitiveDataType() throws RecognitionException {
		PrimitiveDataTypeContext _localctx = new PrimitiveDataTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_primitiveDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1032);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==READONLY) {
				{
				setState(1033);
				match(READONLY);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitHtml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_html);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1036);
				element();
				}
				}
				setState(1039); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TAG_OPEN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	 
		public ElementContext() { }
		public void copyFrom(ElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TerminalElementContext extends ElementContext {
		public TerminalNode TAG_OPEN() { return getToken(AngularParser.TAG_OPEN, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(AngularParser.TAG_CLOSE, 0); }
		public TerminalNode IMG() { return getToken(AngularParser.IMG, 0); }
		public TerminalNode INPUT() { return getToken(AngularParser.INPUT, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public TerminalElementContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTerminalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTerminalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTerminalElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonTerminalElementContext extends ElementContext {
		public TerminalNode TAG_OPEN() { return getToken(AngularParser.TAG_OPEN, 0); }
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(AngularParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(AngularParser.TAG_CLOSE, i);
		}
		public TerminalNode TAG_OPEN_SELF() { return getToken(AngularParser.TAG_OPEN_SELF, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public NonTerminalElementContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNonTerminalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNonTerminalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNonTerminalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_element);
		int _la;
		try {
			setState(1068);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				_localctx = new TerminalElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1041);
				match(TAG_OPEN);
				setState(1042);
				_la = _input.LA(1);
				if ( !(_la==INPUT || _la==IMG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1046);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & 281474976710719L) != 0)) {
					{
					{
					setState(1043);
					htmlAttribute();
					}
					}
					setState(1048);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1049);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				_localctx = new NonTerminalElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1050);
				match(TAG_OPEN);
				setState(1051);
				match(ID);
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & 281474976710719L) != 0)) {
					{
					{
					setState(1052);
					htmlAttribute();
					}
					}
					setState(1057);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1058);
				match(TAG_CLOSE);
				setState(1062);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COLON || _la==STRING || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 20266198323167235L) != 0)) {
					{
					{
					setState(1059);
					node();
					}
					}
					setState(1064);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1065);
				match(TAG_OPEN_SELF);
				setState(1066);
				match(ID);
				setState(1067);
				match(TAG_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NodeContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public InterpolationContext interpolation() {
			return getRuleContext(InterpolationContext.class,0);
		}
		public TextNodeContext textNode() {
			return getRuleContext(TextNodeContext.class,0);
		}
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_node);
		try {
			setState(1073);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1070);
				element();
				}
				break;
			case ANGULAR_BINDING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1071);
				interpolation();
				}
				break;
			case COLON:
			case STRING:
			case NUMERIC_VALUE:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(1072);
				textNode();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterpolationContext extends ParserRuleContext {
		public TerminalNode ANGULAR_BINDING() { return getToken(AngularParser.ANGULAR_BINDING, 0); }
		public InterpolationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterInterpolation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitInterpolation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitInterpolation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterpolationContext interpolation() throws RecognitionException {
		InterpolationContext _localctx = new InterpolationContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_interpolation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			match(ANGULAR_BINDING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextNodeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AngularParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AngularParser.ID, i);
		}
		public List<TerminalNode> STRING() { return getTokens(AngularParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(AngularParser.STRING, i);
		}
		public List<TerminalNode> NUMERIC_VALUE() { return getTokens(AngularParser.NUMERIC_VALUE); }
		public TerminalNode NUMERIC_VALUE(int i) {
			return getToken(AngularParser.NUMERIC_VALUE, i);
		}
		public List<TerminalNode> COLON() { return getTokens(AngularParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(AngularParser.COLON, i);
		}
		public TextNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterTextNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitTextNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitTextNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextNodeContext textNode() throws RecognitionException {
		TextNodeContext _localctx = new TextNodeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_textNode);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1078); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1077);
					_la = _input.LA(1);
					if ( !(_la==COLON || _la==STRING || _la==NUMERIC_VALUE || _la==ID) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1080); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends ParserRuleContext {
		public NgForDirectiveContext ngForDirective() {
			return getRuleContext(NgForDirectiveContext.class,0);
		}
		public NgIfDirectiveContext ngIfDirective() {
			return getRuleContext(NgIfDirectiveContext.class,0);
		}
		public TerminalNode ANGULAR_ATTRIBUTE_PROPERTY() { return getToken(AngularParser.ANGULAR_ATTRIBUTE_PROPERTY, 0); }
		public TerminalNode ANGULAR_ATTRIBUTE_EVENT() { return getToken(AngularParser.ANGULAR_ATTRIBUTE_EVENT, 0); }
		public TerminalNode ANGULAR_ATTRIBUTE_TWO_WAY() { return getToken(AngularParser.ANGULAR_ATTRIBUTE_TWO_WAY, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(AngularParser.ATTRIBUTE, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterHtmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitHtmlAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitHtmlAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_htmlAttribute);
		try {
			setState(1089);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NG_FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1082);
				ngForDirective();
				}
				break;
			case NG_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(1083);
				ngIfDirective();
				}
				break;
			case ANGULAR_ATTRIBUTE_PROPERTY:
				enterOuterAlt(_localctx, 3);
				{
				setState(1084);
				match(ANGULAR_ATTRIBUTE_PROPERTY);
				}
				break;
			case ANGULAR_ATTRIBUTE_EVENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1085);
				match(ANGULAR_ATTRIBUTE_EVENT);
				}
				break;
			case ANGULAR_ATTRIBUTE_TWO_WAY:
				enterOuterAlt(_localctx, 5);
				{
				setState(1086);
				match(ANGULAR_ATTRIBUTE_TWO_WAY);
				}
				break;
			case ATTRIBUTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1087);
				match(ATTRIBUTE);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(1088);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NgForDirectiveContext extends ParserRuleContext {
		public TerminalNode NG_FOR() { return getToken(AngularParser.NG_FOR, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public NgForDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ngForDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNgForDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNgForDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNgForDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NgForDirectiveContext ngForDirective() throws RecognitionException {
		NgForDirectiveContext _localctx = new NgForDirectiveContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_ngForDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			match(NG_FOR);
			setState(1092);
			match(EQUAL_SIGN);
			setState(1093);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NgIfDirectiveContext extends ParserRuleContext {
		public TerminalNode NG_IF() { return getToken(AngularParser.NG_IF, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public NgIfDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ngIfDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterNgIfDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitNgIfDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitNgIfDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NgIfDirectiveContext ngIfDirective() throws RecognitionException {
		NgIfDirectiveContext _localctx = new NgIfDirectiveContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_ngIfDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1095);
			match(NG_IF);
			setState(1096);
			match(EQUAL_SIGN);
			setState(1097);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssContext extends ParserRuleContext {
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_css; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCss(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssContext css() throws RecognitionException {
		CssContext _localctx = new CssContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_css);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_SELECTOR) {
				{
				{
				setState(1099);
				cssDeclaration();
				}
				}
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AngularParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AngularParser.RBRACE, 0); }
		public List<TerminalNode> CSS_SELECTOR() { return getTokens(AngularParser.CSS_SELECTOR); }
		public TerminalNode CSS_SELECTOR(int i) {
			return getToken(AngularParser.CSS_SELECTOR, i);
		}
		public List<CssPropertyContext> cssProperty() {
			return getRuleContexts(CssPropertyContext.class);
		}
		public CssPropertyContext cssProperty(int i) {
			return getRuleContext(CssPropertyContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AngularParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AngularParser.SEMICOLON, i);
		}
		public TerminalNode IMG() { return getToken(AngularParser.IMG, 0); }
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_cssDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1105);
				match(CSS_SELECTOR);
				}
				}
				setState(1108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CSS_SELECTOR );
			setState(1111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMG || _la==ID) {
				{
				setState(1110);
				_la = _input.LA(1);
				if ( !(_la==IMG || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1113);
			match(LBRACE);
			setState(1122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 549755813887L) != 0)) {
				{
				setState(1114);
				cssProperty();
				setState(1119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1115);
						match(SEMICOLON);
						setState(1116);
						cssProperty();
						}
						} 
					}
					setState(1121);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				}
				}
			}

			setState(1125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(1124);
				match(SEMICOLON);
				}
			}

			setState(1127);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssPropertyContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public List<CssTokenContext> cssToken() {
			return getRuleContexts(CssTokenContext.class);
		}
		public CssTokenContext cssToken(int i) {
			return getRuleContext(CssTokenContext.class,i);
		}
		public CssPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCssProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCssProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCssProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssPropertyContext cssProperty() throws RecognitionException {
		CssPropertyContext _localctx = new CssPropertyContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_cssProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			property();
			setState(1130);
			match(COLON);
			setState(1132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1131);
				cssToken();
				}
				}
				setState(1134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & 8584986798063743L) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & 75L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode DISPLAY() { return getToken(AngularParser.DISPLAY, 0); }
		public TerminalNode MARGIN() { return getToken(AngularParser.MARGIN, 0); }
		public TerminalNode FONT_FAMILY() { return getToken(AngularParser.FONT_FAMILY, 0); }
		public TerminalNode PADDING() { return getToken(AngularParser.PADDING, 0); }
		public TerminalNode WIDTH() { return getToken(AngularParser.WIDTH, 0); }
		public TerminalNode BORDER_RIGHT() { return getToken(AngularParser.BORDER_RIGHT, 0); }
		public TerminalNode OVERFLOW_Y() { return getToken(AngularParser.OVERFLOW_Y, 0); }
		public TerminalNode BORDER() { return getToken(AngularParser.BORDER, 0); }
		public TerminalNode CURSOR() { return getToken(AngularParser.CURSOR, 0); }
		public TerminalNode TRANSITION() { return getToken(AngularParser.TRANSITION, 0); }
		public TerminalNode HEIGHT() { return getToken(AngularParser.HEIGHT, 0); }
		public TerminalNode MARGIN_RIGHT() { return getToken(AngularParser.MARGIN_RIGHT, 0); }
		public TerminalNode BORDER_SOLID() { return getToken(AngularParser.BORDER_SOLID, 0); }
		public TerminalNode COLOR() { return getToken(AngularParser.COLOR, 0); }
		public TerminalNode BACKGROUND_COLOR() { return getToken(AngularParser.BACKGROUND_COLOR, 0); }
		public TerminalNode BACKGROUND() { return getToken(AngularParser.BACKGROUND, 0); }
		public TerminalNode BORDER_RADIUS() { return getToken(AngularParser.BORDER_RADIUS, 0); }
		public TerminalNode GAP() { return getToken(AngularParser.GAP, 0); }
		public TerminalNode BORDER_BOTTOM_COLOR() { return getToken(AngularParser.BORDER_BOTTOM_COLOR, 0); }
		public TerminalNode MARGIN_BOTTOM() { return getToken(AngularParser.MARGIN_BOTTOM, 0); }
		public TerminalNode POSITION() { return getToken(AngularParser.POSITION, 0); }
		public TerminalNode TOP() { return getToken(AngularParser.TOP, 0); }
		public TerminalNode LEFT() { return getToken(AngularParser.LEFT, 0); }
		public TerminalNode JUSTIFY_CONTENT() { return getToken(AngularParser.JUSTIFY_CONTENT, 0); }
		public TerminalNode ALIGN_ITEMS() { return getToken(AngularParser.ALIGN_ITEMS, 0); }
		public TerminalNode MAX_WIDTH() { return getToken(AngularParser.MAX_WIDTH, 0); }
		public TerminalNode BOX_SIZING() { return getToken(AngularParser.BOX_SIZING, 0); }
		public TerminalNode MAGIN_TOP() { return getToken(AngularParser.MAGIN_TOP, 0); }
		public TerminalNode OBJECT_FIT() { return getToken(AngularParser.OBJECT_FIT, 0); }
		public TerminalNode Z_INDEX() { return getToken(AngularParser.Z_INDEX, 0); }
		public TerminalNode TEXT_DECORATION() { return getToken(AngularParser.TEXT_DECORATION, 0); }
		public TerminalNode FONT_WEIGHT() { return getToken(AngularParser.FONT_WEIGHT, 0); }
		public TerminalNode RESIZE() { return getToken(AngularParser.RESIZE, 0); }
		public TerminalNode TSXT_ALIGN() { return getToken(AngularParser.TSXT_ALIGN, 0); }
		public TerminalNode FONT_SIZE() { return getToken(AngularParser.FONT_SIZE, 0); }
		public TerminalNode GRID_TEMPLATE_COLUMNS() { return getToken(AngularParser.GRID_TEMPLATE_COLUMNS, 0); }
		public TerminalNode BOX_SHADOW() { return getToken(AngularParser.BOX_SHADOW, 0); }
		public TerminalNode FLEX_DIRECTION() { return getToken(AngularParser.FLEX_DIRECTION, 0); }
		public TerminalNode OVERFLOW() { return getToken(AngularParser.OVERFLOW, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1136);
			_la = _input.LA(1);
			if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 549755813887L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public List<CssTokenContext> cssToken() {
			return getRuleContexts(CssTokenContext.class);
		}
		public CssTokenContext cssToken(int i) {
			return getRuleContext(CssTokenContext.class,i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1138);
				cssToken();
				}
				}
				setState(1141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & 8584986798063743L) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & 75L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssTokenContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AngularParser.ID, 0); }
		public TerminalNode STRING() { return getToken(AngularParser.STRING, 0); }
		public TerminalNode NUMERIC_VALUE() { return getToken(AngularParser.NUMERIC_VALUE, 0); }
		public TerminalNode COLOR_VALUE() { return getToken(AngularParser.COLOR_VALUE, 0); }
		public TerminalNode COMMA() { return getToken(AngularParser.COMMA, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(AngularParser.LPARENTHESIS, 0); }
		public TerminalNode RPARENTHESIS() { return getToken(AngularParser.RPARENTHESIS, 0); }
		public TerminalNode LBRACKET() { return getToken(AngularParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AngularParser.RBRACKET, 0); }
		public TerminalNode DOT() { return getToken(AngularParser.DOT, 0); }
		public TerminalNode SLASH() { return getToken(AngularParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(AngularParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(AngularParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AngularParser.MINUS, 0); }
		public TerminalNode EQUAL_SIGN() { return getToken(AngularParser.EQUAL_SIGN, 0); }
		public TerminalNode COLON() { return getToken(AngularParser.COLON, 0); }
		public TerminalNode SPACE() { return getToken(AngularParser.SPACE, 0); }
		public CssTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).enterCssToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AngularParserListener ) ((AngularParserListener)listener).exitCssToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AngularParserVisitor ) return ((AngularParserVisitor<? extends T>)visitor).visitCssToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssTokenContext cssToken() throws RecognitionException {
		CssTokenContext _localctx = new CssTokenContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_cssToken);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			_la = _input.LA(1);
			if ( !(((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & 8584986798063743L) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & 75L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 51:
			return tsExpr_sempred((TsExprContext)_localctx, predIndex);
		case 53:
			return tsAndExpr_sempred((TsAndExprContext)_localctx, predIndex);
		case 54:
			return tsEqExpr_sempred((TsEqExprContext)_localctx, predIndex);
		case 55:
			return tsRelExpr_sempred((TsRelExprContext)_localctx, predIndex);
		case 56:
			return tsAddExpr_sempred((TsAddExprContext)_localctx, predIndex);
		case 57:
			return tsMulExpr_sempred((TsMulExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean tsExpr_sempred(TsExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean tsAndExpr_sempred(TsAndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean tsEqExpr_sempred(TsEqExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean tsRelExpr_sempred(TsRelExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean tsAddExpr_sempred(TsAddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean tsMulExpr_sempred(TsMulExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0097\u047a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0001\u0000\u0004\u0000\u00a4\b\u0000\u000b\u0000\f\u0000"+
		"\u00a5\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u00ad\b\u0001\u0001\u0002\u0005\u0002\u00b0\b\u0002\n\u0002\f\u0002"+
		"\u00b3\t\u0002\u0001\u0002\u0003\u0002\u00b6\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002\u00c1\b\u0002\n\u0002\f\u0002\u00c4\t\u0002"+
		"\u0003\u0002\u00c6\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00ca\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00d0"+
		"\b\u0003\n\u0003\f\u0003\u00d3\t\u0003\u0003\u0003\u00d5\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0005\u0005\u00de\b\u0005\n\u0005\f\u0005\u00e1\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00e8\b\u0005"+
		"\u000b\u0005\f\u0005\u00e9\u0001\u0006\u0003\u0006\u00ed\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00fa"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0003\t\u0104\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u010a"+
		"\b\t\n\t\f\t\u010d\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\u000b\u0003\u000b\u0117\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0003\f\u0122\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u012c\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0003"+
		"\r\u0132\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0003\u000e\u0140\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0004\u000e\u0149\b\u000e\u000b\u000e\f\u000e\u014a\u0001\u000f"+
		"\u0005\u000f\u014e\b\u000f\n\u000f\f\u000f\u0151\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u015e\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0164\b\u000f\n"+
		"\u000f\f\u000f\u0167\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u016b"+
		"\b\u000f\n\u000f\f\u000f\u016e\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0173\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0178\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u017d\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0181\b\u000f\u0003\u000f\u0183"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u018c\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0196\b\u0010\n\u0010\f\u0010\u0199\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u019d\b\u0010\n\u0010\f\u0010\u01a0\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01a7\b\u0011\n"+
		"\u0011\f\u0011\u01aa\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u01b5\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u01c2\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u01cd\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u01d4\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u01d9\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01de"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01e2\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u01ec\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u01f3\b\u001a\n\u001a\f\u001a\u01f6"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01fb\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0200\b\u001c\n\u001c"+
		"\f\u001c\u0203\t\u001c\u0001\u001d\u0005\u001d\u0206\b\u001d\n\u001d\f"+
		"\u001d\u0209\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u020f\b\u001e\u0001\u001f\u0003\u001f\u0212\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u021a\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u021f\b"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0225"+
		"\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u022d\b \n "+
		"\f \u0230\t \u0001 \u0001 \u0003 \u0234\b \u0001!\u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0240\b\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0005#\u0246\b#\n#\f#\u0249\t#\u0003#\u024b\b#"+
		"\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0005$\u0253\b$\n$\f$\u0256"+
		"\t$\u0003$\u0258\b$\u0001$\u0001$\u0001%\u0003%\u025d\b%\u0001%\u0001"+
		"%\u0001%\u0003%\u0262\b%\u0001%\u0001%\u0001%\u0005%\u0267\b%\n%\f%\u026a"+
		"\t%\u0001%\u0001%\u0001&\u0001&\u0001&\u0005&\u0271\b&\n&\f&\u0274\t&"+
		"\u0001\'\u0003\'\u0277\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0003"+
		"(\u027e\b(\u0001(\u0001(\u0001(\u0003(\u0283\b(\u0001(\u0001(\u0001(\u0003"+
		"(\u0288\b(\u0001(\u0001(\u0005(\u028c\b(\n(\f(\u028f\t(\u0001(\u0001("+
		"\u0001)\u0001)\u0001)\u0005)\u0296\b)\n)\f)\u0299\t)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0003*\u02a2\b*\u0001+\u0001+\u0003+\u02a6"+
		"\b+\u0001,\u0001,\u0001,\u0005,\u02ab\b,\n,\f,\u02ae\t,\u0001-\u0001-"+
		"\u0001-\u0001-\u0001-\u0003-\u02b5\b-\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0005.\u02bc\b.\n.\f.\u02bf\t.\u0001.\u0001.\u0001/\u0001/\u0003/\u02c5"+
		"\b/\u00010\u00010\u00030\u02c9\b0\u00010\u00010\u00010\u00011\u00011\u0001"+
		"2\u00012\u00012\u00012\u00032\u02d4\b2\u00012\u00012\u00012\u00012\u0001"+
		"2\u00032\u02db\b2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00032\u02e9\b2\u00012\u00012\u00012\u0005"+
		"2\u02ee\b2\n2\f2\u02f1\t2\u00012\u00012\u00012\u00012\u00032\u02f7\b2"+
		"\u00012\u00012\u00012\u00052\u02fc\b2\n2\f2\u02ff\t2\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00032\u0309\b2\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u0005"+
		"3\u0317\b3\n3\f3\u031a\t3\u00014\u00014\u00034\u031e\b4\u00014\u00014"+
		"\u00014\u00014\u00014\u00014\u00014\u00054\u0327\b4\n4\f4\u032a\t4\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00055\u0332\b5\n5\f5\u0335\t5\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00056\u033d\b6\n6\f6\u0340\t6\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00057\u0348\b7\n7\f7\u034b\t7\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00058\u0353\b8\n8\f8\u0356\t8\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00059\u035e\b9\n9\f9\u0361\t9\u0001"+
		":\u0001:\u0001:\u0003:\u0366\b:\u0001;\u0001;\u0005;\u036a\b;\n;\f;\u036d"+
		"\t;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0005<\u0379\b<\n<\f<\u037c\t<\u0003<\u037e\b<\u0001<\u0001<\u0001<"+
		"\u0001<\u0001<\u0005<\u0385\b<\n<\f<\u0388\t<\u0003<\u038a\b<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u0396"+
		"\b<\u0001<\u0001<\u0001<\u0001<\u0005<\u039c\b<\n<\f<\u039f\t<\u0003<"+
		"\u03a1\b<\u0001<\u0003<\u03a4\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0005=\u03ac\b=\n=\f=\u03af\t=\u0003=\u03b1\b=\u0001=\u0001=\u0001="+
		"\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u03bc\b=\u0001=\u0001"+
		"=\u0001=\u0005=\u03c1\b=\n=\f=\u03c4\t=\u0003=\u03c6\b=\u0001=\u0003="+
		"\u03c9\b=\u0001>\u0001>\u0001>\u0001>\u0005>\u03cf\b>\n>\f>\u03d2\t>\u0001"+
		">\u0001>\u0001?\u0001?\u0001?\u0003?\u03d9\b?\u0001@\u0001@\u0001@\u0001"+
		"@\u0005@\u03df\b@\n@\f@\u03e2\t@\u0003@\u03e4\b@\u0001@\u0001@\u0001@"+
		"\u0001@\u0001@\u0005@\u03eb\b@\n@\f@\u03ee\t@\u0001@\u0003@\u03f1\b@\u0001"+
		"@\u0001@\u0001@\u0001@\u0001@\u0005@\u03f8\b@\n@\f@\u03fb\t@\u0001@\u0003"+
		"@\u03fe\b@\u0003@\u0400\b@\u0001A\u0001A\u0001A\u0001A\u0001A\u0003A\u0407"+
		"\bA\u0001B\u0001B\u0003B\u040b\bB\u0001C\u0004C\u040e\bC\u000bC\fC\u040f"+
		"\u0001D\u0001D\u0001D\u0005D\u0415\bD\nD\fD\u0418\tD\u0001D\u0001D\u0001"+
		"D\u0001D\u0005D\u041e\bD\nD\fD\u0421\tD\u0001D\u0001D\u0005D\u0425\bD"+
		"\nD\fD\u0428\tD\u0001D\u0001D\u0001D\u0003D\u042d\bD\u0001E\u0001E\u0001"+
		"E\u0003E\u0432\bE\u0001F\u0001F\u0001G\u0004G\u0437\bG\u000bG\fG\u0438"+
		"\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003H\u0442\bH\u0001"+
		"I\u0001I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001K\u0005K\u044d"+
		"\bK\nK\fK\u0450\tK\u0001L\u0004L\u0453\bL\u000bL\fL\u0454\u0001L\u0003"+
		"L\u0458\bL\u0001L\u0001L\u0001L\u0001L\u0005L\u045e\bL\nL\fL\u0461\tL"+
		"\u0003L\u0463\bL\u0001L\u0003L\u0466\bL\u0001L\u0001L\u0001M\u0001M\u0001"+
		"M\u0004M\u046d\bM\u000bM\fM\u046e\u0001N\u0001N\u0001O\u0004O\u0474\b"+
		"O\u000bO\fO\u0475\u0001P\u0001P\u0001P\u0000\u0006fjlnprQ\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u0000\u0010\u0001\u0000\b\t\u0002\u0000(+\u0094\u0094\u0002\u0000"+
		"-022\u0002\u00003377\u0001\u0000MP\u0002\u0000QR_`\u0001\u0000FG\u0001"+
		"\u0000HI\u0002\u0000FGLL\u0002\u0000\u001b\u001b\u0094\u0094\u0001\u0000"+
		"?A\u0001\u0000bc\u0004\u0000\u0019\u0019\u001b\u001b\u0091\u0091\u0094"+
		"\u0094\u0002\u0000cc\u0094\u0094\u0001\u0000j\u0090\u0007\u0000\u0015"+
		"\u001b,,DDFI\u0091\u0092\u0094\u0094\u0097\u0097\u04d6\u0000\u00a3\u0001"+
		"\u0000\u0000\u0000\u0002\u00ac\u0001\u0000\u0000\u0000\u0004\u00b1\u0001"+
		"\u0000\u0000\u0000\u0006\u00cb\u0001\u0000\u0000\u0000\b\u00d8\u0001\u0000"+
		"\u0000\u0000\n\u00df\u0001\u0000\u0000\u0000\f\u00ec\u0001\u0000\u0000"+
		"\u0000\u000e\u00f5\u0001\u0000\u0000\u0000\u0010\u00fe\u0001\u0000\u0000"+
		"\u0000\u0012\u0103\u0001\u0000\u0000\u0000\u0014\u0110\u0001\u0000\u0000"+
		"\u0000\u0016\u0116\u0001\u0000\u0000\u0000\u0018\u0121\u0001\u0000\u0000"+
		"\u0000\u001a\u0131\u0001\u0000\u0000\u0000\u001c\u0148\u0001\u0000\u0000"+
		"\u0000\u001e\u014f\u0001\u0000\u0000\u0000 \u0191\u0001\u0000\u0000\u0000"+
		"\"\u01a3\u0001\u0000\u0000\u0000$\u01b4\u0001\u0000\u0000\u0000&\u01c1"+
		"\u0001\u0000\u0000\u0000(\u01cc\u0001\u0000\u0000\u0000*\u01ce\u0001\u0000"+
		"\u0000\u0000,\u01e1\u0001\u0000\u0000\u0000.\u01e3\u0001\u0000\u0000\u0000"+
		"0\u01e5\u0001\u0000\u0000\u00002\u01e9\u0001\u0000\u0000\u00004\u01ef"+
		"\u0001\u0000\u0000\u00006\u01f7\u0001\u0000\u0000\u00008\u01fc\u0001\u0000"+
		"\u0000\u0000:\u0207\u0001\u0000\u0000\u0000<\u020e\u0001\u0000\u0000\u0000"+
		">\u0224\u0001\u0000\u0000\u0000@\u0226\u0001\u0000\u0000\u0000B\u0235"+
		"\u0001\u0000\u0000\u0000D\u023f\u0001\u0000\u0000\u0000F\u0241\u0001\u0000"+
		"\u0000\u0000H\u024e\u0001\u0000\u0000\u0000J\u025c\u0001\u0000\u0000\u0000"+
		"L\u026d\u0001\u0000\u0000\u0000N\u0276\u0001\u0000\u0000\u0000P\u027d"+
		"\u0001\u0000\u0000\u0000R\u0292\u0001\u0000\u0000\u0000T\u02a1\u0001\u0000"+
		"\u0000\u0000V\u02a5\u0001\u0000\u0000\u0000X\u02a7\u0001\u0000\u0000\u0000"+
		"Z\u02b4\u0001\u0000\u0000\u0000\\\u02b6\u0001\u0000\u0000\u0000^\u02c4"+
		"\u0001\u0000\u0000\u0000`\u02c8\u0001\u0000\u0000\u0000b\u02cd\u0001\u0000"+
		"\u0000\u0000d\u0308\u0001\u0000\u0000\u0000f\u030a\u0001\u0000\u0000\u0000"+
		"h\u031d\u0001\u0000\u0000\u0000j\u032b\u0001\u0000\u0000\u0000l\u0336"+
		"\u0001\u0000\u0000\u0000n\u0341\u0001\u0000\u0000\u0000p\u034c\u0001\u0000"+
		"\u0000\u0000r\u0357\u0001\u0000\u0000\u0000t\u0365\u0001\u0000\u0000\u0000"+
		"v\u0367\u0001\u0000\u0000\u0000x\u03a3\u0001\u0000\u0000\u0000z\u03c8"+
		"\u0001\u0000\u0000\u0000|\u03ca\u0001\u0000\u0000\u0000~\u03d8\u0001\u0000"+
		"\u0000\u0000\u0080\u03ff\u0001\u0000\u0000\u0000\u0082\u0406\u0001\u0000"+
		"\u0000\u0000\u0084\u0408\u0001\u0000\u0000\u0000\u0086\u040d\u0001\u0000"+
		"\u0000\u0000\u0088\u042c\u0001\u0000\u0000\u0000\u008a\u0431\u0001\u0000"+
		"\u0000\u0000\u008c\u0433\u0001\u0000\u0000\u0000\u008e\u0436\u0001\u0000"+
		"\u0000\u0000\u0090\u0441\u0001\u0000\u0000\u0000\u0092\u0443\u0001\u0000"+
		"\u0000\u0000\u0094\u0447\u0001\u0000\u0000\u0000\u0096\u044e\u0001\u0000"+
		"\u0000\u0000\u0098\u0452\u0001\u0000\u0000\u0000\u009a\u0469\u0001\u0000"+
		"\u0000\u0000\u009c\u0470\u0001\u0000\u0000\u0000\u009e\u0473\u0001\u0000"+
		"\u0000\u0000\u00a0\u0477\u0001\u0000\u0000\u0000\u00a2\u00a4\u0003\u0002"+
		"\u0001\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0000"+
		"\u0000\u0001\u00a8\u0001\u0001\u0000\u0000\u0000\u00a9\u00ad\u0003\u001e"+
		"\u000f\u0000\u00aa\u00ad\u0003\n\u0005\u0000\u00ab\u00ad\u0003\u0004\u0002"+
		"\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u0003\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0003*\u0015\u0000\u00af\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b6\u0005\r\u0000\u0000\u00b5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u00057\u0000\u0000\u00b8\u00b9"+
		"\u0005\u0094\u0000\u0000\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bb"+
		"\u0005\u0094\u0000\u0000\u00bb\u00bc\u0005,\u0000\u0000\u00bc\u00c5\u0005"+
		"\u0017\u0000\u0000\u00bd\u00c2\u0003\u0006\u0003\u0000\u00be\u00bf\u0005"+
		"\u001a\u0000\u0000\u00bf\u00c1\u0003\u0006\u0003\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c9\u0005\u0018\u0000\u0000\u00c8\u00ca\u0005"+
		"\u001d\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ca\u0005\u0001\u0000\u0000\u0000\u00cb\u00d4\u0005"+
		"\u0013\u0000\u0000\u00cc\u00d1\u0003\b\u0004\u0000\u00cd\u00ce\u0005\u001a"+
		"\u0000\u0000\u00ce\u00d0\u0003\b\u0004\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0005\u0014\u0000\u0000\u00d7\u0007\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005\u0094\u0000\u0000\u00d9\u00da\u0005\u0019\u0000"+
		"\u0000\u00da\u00db\u0003f3\u0000\u00db\t\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0003*\u0015\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00e1"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e7\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e8\u0003\u0012\t\u0000\u00e3\u00e8\u0003"+
		"\u0016\u000b\u0000\u00e4\u00e8\u0003\u0018\f\u0000\u00e5\u00e8\u0003\u001a"+
		"\r\u0000\u00e6\u00e8\u0003\f\u0006\u0000\u00e7\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e3\u0001\u0000\u0000\u0000\u00e7\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u000b\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ed\u0003\u000e\u0007\u0000\u00ec\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005\r\u0000\u0000\u00ef\u00f0\u0005\f\u0000\u0000"+
		"\u00f0\u00f1\u0005\u0094\u0000\u0000\u00f1\u00f2\u0005\u0013\u0000\u0000"+
		"\u00f2\u00f3\u0003:\u001d\u0000\u00f3\u00f4\u0005\u0014\u0000\u0000\u00f4"+
		"\r\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005!\u0000\u0000\u00f6\u00f7"+
		"\u0005\u0015\u0000\u0000\u00f7\u00f9\u0005\u0013\u0000\u0000\u00f8\u00fa"+
		"\u0003\u0010\b\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005"+
		"\u0014\u0000\u0000\u00fc\u00fd\u0005\u0016\u0000\u0000\u00fd\u000f\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0005\"\u0000\u0000\u00ff\u0100\u0005\u0019"+
		"\u0000\u0000\u0100\u0101\u0005\u001b\u0000\u0000\u0101\u0011\u0001\u0000"+
		"\u0000\u0000\u0102\u0104\u0005\r\u0000\u0000\u0103\u0102\u0001\u0000\u0000"+
		"\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0005#\u0000\u0000\u0106\u0107\u0005\u0094\u0000\u0000"+
		"\u0107\u010b\u0005\u0013\u0000\u0000\u0108\u010a\u0003\u0014\n\u0000\u0109"+
		"\u0108\u0001\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b"+
		"\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010e\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0005\u0014\u0000\u0000\u010f\u0013\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0005\u0094\u0000\u0000\u0111\u0112\u0005\u0019\u0000\u0000\u0112"+
		"\u0113\u0003X,\u0000\u0113\u0114\u0005\u001d\u0000\u0000\u0114\u0015\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0005\r\u0000\u0000\u0116\u0115\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\u00057\u0000\u0000\u0119\u011a\u0005\u0094\u0000"+
		"\u0000\u011a\u011b\u0005\u0019\u0000\u0000\u011b\u011c\u0005\u0094\u0000"+
		"\u0000\u011c\u011d\u0005,\u0000\u0000\u011d\u011e\u0003H$\u0000\u011e"+
		"\u011f\u0005\u001d\u0000\u0000\u011f\u0017\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u0005\r\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u00057\u0000\u0000\u0124\u0125\u0005\u0094\u0000\u0000\u0125\u0126\u0005"+
		",\u0000\u0000\u0126\u0127\u0005)\u0000\u0000\u0127\u0128\u0005\u0015\u0000"+
		"\u0000\u0128\u012b\u0005\u001b\u0000\u0000\u0129\u012a\u0005\u001a\u0000"+
		"\u0000\u012a\u012c\u0003f3\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0005\u0016\u0000\u0000\u012e\u012f\u0005\u001d\u0000\u0000\u012f"+
		"\u0019\u0001\u0000\u0000\u0000\u0130\u0132\u0005\r\u0000\u0000\u0131\u0130"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133"+
		"\u0001\u0000\u0000\u0000\u0133\u0134\u00057\u0000\u0000\u0134\u0135\u0005"+
		"\u0094\u0000\u0000\u0135\u0136\u0005,\u0000\u0000\u0136\u0137\u0005*\u0000"+
		"\u0000\u0137\u0138\u0005\u0015\u0000\u0000\u0138\u0139\u0005\u0094\u0000"+
		"\u0000\u0139\u013a\u0005\u001a\u0000\u0000\u013a\u013b\u0003\u001c\u000e"+
		"\u0000\u013b\u013c\u0005\u0016\u0000\u0000\u013c\u013d\u0005\u001d\u0000"+
		"\u0000\u013d\u001b\u0001\u0000\u0000\u0000\u013e\u0140\u0005\u001a\u0000"+
		"\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0005+\u0000\u0000"+
		"\u0142\u0143\u0005\u0015\u0000\u0000\u0143\u0144\u0005\u0094\u0000\u0000"+
		"\u0144\u0145\u0005\u001a\u0000\u0000\u0145\u0146\u0003\u0080@\u0000\u0146"+
		"\u0147\u0005\u0016\u0000\u0000\u0147\u0149\u0001\u0000\u0000\u0000\u0148"+
		"\u013f\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a"+
		"\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b"+
		"\u001d\u0001\u0000\u0000\u0000\u014c\u014e\u0003*\u0015\u0000\u014d\u014c"+
		"\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000\u014f\u014d"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0152"+
		"\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0005\u0001\u0000\u0000\u0153\u0154\u0005\u0015\u0000\u0000\u0154\u0155"+
		"\u0005\u0013\u0000\u0000\u0155\u0156\u0005\u000e\u0000\u0000\u0156\u0157"+
		"\u0005\u0019\u0000\u0000\u0157\u0158\u0005\u001b\u0000\u0000\u0158\u015d"+
		"\u0005\u001a\u0000\u0000\u0159\u015a\u0005\u0002\u0000\u0000\u015a\u015b"+
		"\u0005\u0019\u0000\u0000\u015b\u015c\u0007\u0000\u0000\u0000\u015c\u015e"+
		"\u0005\u001a\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000\u015d\u015e"+
		"\u0001\u0000\u0000\u0000\u015e\u0172\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0005\u0003\u0000\u0000\u0160\u0161\u0005\u0019\u0000\u0000\u0161\u0165"+
		"\u0005\u0017\u0000\u0000\u0162\u0164\u0005\u0097\u0000\u0000\u0163\u0162"+
		"\u0001\u0000\u0000\u0000\u0164\u0167\u0001\u0000\u0000\u0000\u0165\u0163"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0168"+
		"\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168\u016c"+
		"\u00038\u001c\u0000\u0169\u016b\u0005\u0097\u0000\u0000\u016a\u0169\u0001"+
		"\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c\u016a\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0001"+
		"\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f\u0170\u0005"+
		"\u0018\u0000\u0000\u0170\u0171\u0005\u001a\u0000\u0000\u0171\u0173\u0001"+
		"\u0000\u0000\u0000\u0172\u015f\u0001\u0000\u0000\u0000\u0172\u0173\u0001"+
		"\u0000\u0000\u0000\u0173\u0177\u0001\u0000\u0000\u0000\u0174\u0175\u0003"+
		"&\u0013\u0000\u0175\u0176\u0005\u001a\u0000\u0000\u0176\u0178\u0001\u0000"+
		"\u0000\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000"+
		"\u0000\u0000\u0178\u017c\u0001\u0000\u0000\u0000\u0179\u017a\u0003(\u0014"+
		"\u0000\u017a\u017b\u0005\u001a\u0000\u0000\u017b\u017d\u0001\u0000\u0000"+
		"\u0000\u017c\u0179\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000"+
		"\u0000\u017d\u0182\u0001\u0000\u0000\u0000\u017e\u0180\u0003 \u0010\u0000"+
		"\u017f\u0181\u0005\u001a\u0000\u0000\u0180\u017f\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0183\u0001\u0000\u0000\u0000"+
		"\u0182\u017e\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000"+
		"\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0185\u0005\u0014\u0000\u0000"+
		"\u0185\u0186\u0005\u0016\u0000\u0000\u0186\u0187\u0005\r\u0000\u0000\u0187"+
		"\u0188\u0005\f\u0000\u0000\u0188\u018b\u0005\u0094\u0000\u0000\u0189\u018a"+
		"\u0005\u0011\u0000\u0000\u018a\u018c\u0005\u0094\u0000\u0000\u018b\u0189"+
		"\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018d"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0005\u0013\u0000\u0000\u018e\u018f"+
		"\u0003:\u001d\u0000\u018f\u0190\u0005\u0014\u0000\u0000\u0190\u001f\u0001"+
		"\u0000\u0000\u0000\u0191\u0192\u0005\u0010\u0000\u0000\u0192\u0193\u0005"+
		"\u0019\u0000\u0000\u0193\u0197\u0005\u0017\u0000\u0000\u0194\u0196\u0005"+
		"\u0097\u0000\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196\u0199\u0001"+
		"\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001"+
		"\u0000\u0000\u0000\u0198\u019a\u0001\u0000\u0000\u0000\u0199\u0197\u0001"+
		"\u0000\u0000\u0000\u019a\u019e\u0003\"\u0011\u0000\u019b\u019d\u0005\u0097"+
		"\u0000\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000"+
		"\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000"+
		"\u0000\u0000\u019f\u01a1\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a2\u0005\u0018\u0000\u0000\u01a2!\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a8\u0003$\u0012\u0000\u01a4\u01a5\u0005\u001a\u0000\u0000"+
		"\u01a5\u01a7\u0003$\u0012\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a7"+
		"\u01aa\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0001\u0000\u0000\u0000\u01a9#\u0001\u0000\u0000\u0000\u01aa\u01a8"+
		"\u0001\u0000\u0000\u0000\u01ab\u01ac\u0005\u0094\u0000\u0000\u01ac\u01ad"+
		"\u0005\u0015\u0000\u0000\u01ad\u01ae\u0005\u0013\u0000\u0000\u01ae\u01af"+
		"\u0005\u0094\u0000\u0000\u01af\u01b0\u0005\u0019\u0000\u0000\u01b0\u01b1"+
		"\u0005\u0094\u0000\u0000\u01b1\u01b2\u0005\u0014\u0000\u0000\u01b2\u01b5"+
		"\u0005\u0016\u0000\u0000\u01b3\u01b5\u0005\u0094\u0000\u0000\u01b4\u01ab"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5%\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b7\u0005\u0005\u0000\u0000\u01b7\u01b8\u0005"+
		"\u0019\u0000\u0000\u01b8\u01b9\u0005\u0017\u0000\u0000\u01b9\u01ba\u0005"+
		"\u001c\u0000\u0000\u01ba\u01bb\u0003\u0096K\u0000\u01bb\u01bc\u0005\u001c"+
		"\u0000\u0000\u01bc\u01bd\u0005\u0018\u0000\u0000\u01bd\u01c2\u0001\u0000"+
		"\u0000\u0000\u01be\u01bf\u0005\u000f\u0000\u0000\u01bf\u01c0\u0005\u0019"+
		"\u0000\u0000\u01c0\u01c2\u0005\u001b\u0000\u0000\u01c1\u01b6\u0001\u0000"+
		"\u0000\u0000\u01c1\u01be\u0001\u0000\u0000\u0000\u01c2\'\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0005\u0006\u0000\u0000\u01c4\u01c5\u0005\u0019\u0000"+
		"\u0000\u01c5\u01c6\u0005\u001c\u0000\u0000\u01c6\u01c7\u0003\u0086C\u0000"+
		"\u01c7\u01c8\u0005\u001c\u0000\u0000\u01c8\u01cd\u0001\u0000\u0000\u0000"+
		"\u01c9\u01ca\u0005\u0007\u0000\u0000\u01ca\u01cb\u0005\u0019\u0000\u0000"+
		"\u01cb\u01cd\u0005\u001b\u0000\u0000\u01cc\u01c3\u0001\u0000\u0000\u0000"+
		"\u01cc\u01c9\u0001\u0000\u0000\u0000\u01cd)\u0001\u0000\u0000\u0000\u01ce"+
		"\u01cf\u0005\u0004\u0000\u0000\u01cf\u01d0\u0003,\u0016\u0000\u01d0\u01d1"+
		"\u0005\n\u0000\u0000\u01d1\u01d3\u0005\u001b\u0000\u0000\u01d2\u01d4\u0005"+
		"\u001d\u0000\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d4+\u0001\u0000\u0000\u0000\u01d5\u01d8\u0003.\u0017"+
		"\u0000\u01d6\u01d7\u0005\u001a\u0000\u0000\u01d7\u01d9\u00030\u0018\u0000"+
		"\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000"+
		"\u01d9\u01e2\u0001\u0000\u0000\u0000\u01da\u01dd\u0003.\u0017\u0000\u01db"+
		"\u01dc\u0005\u001a\u0000\u0000\u01dc\u01de\u00032\u0019\u0000\u01dd\u01db"+
		"\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01e2"+
		"\u0001\u0000\u0000\u0000\u01df\u01e2\u00030\u0018\u0000\u01e0\u01e2\u0003"+
		"2\u0019\u0000\u01e1\u01d5\u0001\u0000\u0000\u0000\u01e1\u01da\u0001\u0000"+
		"\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e2-\u0001\u0000\u0000\u0000\u01e3\u01e4\u0007\u0001\u0000"+
		"\u0000\u01e4/\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005H\u0000\u0000\u01e6"+
		"\u01e7\u0005\u000b\u0000\u0000\u01e7\u01e8\u0005\u0094\u0000\u0000\u01e8"+
		"1\u0001\u0000\u0000\u0000\u01e9\u01eb\u0005\u0013\u0000\u0000\u01ea\u01ec"+
		"\u00034\u001a\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0005"+
		"\u0014\u0000\u0000\u01ee3\u0001\u0000\u0000\u0000\u01ef\u01f4\u00036\u001b"+
		"\u0000\u01f0\u01f1\u0005\u001a\u0000\u0000\u01f1\u01f3\u00036\u001b\u0000"+
		"\u01f2\u01f0\u0001\u0000\u0000\u0000\u01f3\u01f6\u0001\u0000\u0000\u0000"+
		"\u01f4\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000"+
		"\u01f55\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f7"+
		"\u01fa\u0003.\u0017\u0000\u01f8\u01f9\u0005\u000b\u0000\u0000\u01f9\u01fb"+
		"\u0003.\u0017\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fb7\u0001\u0000\u0000\u0000\u01fc\u0201\u0005\u0094"+
		"\u0000\u0000\u01fd\u01fe\u0005\u001a\u0000\u0000\u01fe\u0200\u0005\u0094"+
		"\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000\u0000\u0200\u0203\u0001\u0000"+
		"\u0000\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000"+
		"\u0000\u0000\u02029\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000"+
		"\u0000\u0204\u0206\u0003<\u001e\u0000\u0205\u0204\u0001\u0000\u0000\u0000"+
		"\u0206\u0209\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000\u0000\u0000"+
		"\u0207\u0208\u0001\u0000\u0000\u0000\u0208;\u0001\u0000\u0000\u0000\u0209"+
		"\u0207\u0001\u0000\u0000\u0000\u020a\u020f\u0003>\u001f\u0000\u020b\u020f"+
		"\u0003@ \u0000\u020c\u020f\u0003P(\u0000\u020d\u020f\u0003J%\u0000\u020e"+
		"\u020a\u0001\u0000\u0000\u0000\u020e\u020b\u0001\u0000\u0000\u0000\u020e"+
		"\u020c\u0001\u0000\u0000\u0000\u020e\u020d\u0001\u0000\u0000\u0000\u020f"+
		"=\u0001\u0000\u0000\u0000\u0210\u0212\u0003\u0084B\u0000\u0211\u0210\u0001"+
		"\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0213\u0001"+
		"\u0000\u0000\u0000\u0213\u0214\u0005\u0094\u0000\u0000\u0214\u0215\u0005"+
		"\u0019\u0000\u0000\u0215\u0216\u0003X,\u0000\u0216\u0217\u0005\u001d\u0000"+
		"\u0000\u0217\u0225\u0001\u0000\u0000\u0000\u0218\u021a\u0003\u0084B\u0000"+
		"\u0219\u0218\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000"+
		"\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u021e\u0005\u0094\u0000\u0000"+
		"\u021c\u021d\u0005\u0019\u0000\u0000\u021d\u021f\u0003X,\u0000\u021e\u021c"+
		"\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0220"+
		"\u0001\u0000\u0000\u0000\u0220\u0221\u0005,\u0000\u0000\u0221\u0222\u0003"+
		"f3\u0000\u0222\u0223\u0005\u001d\u0000\u0000\u0223\u0225\u0001\u0000\u0000"+
		"\u0000\u0224\u0211\u0001\u0000\u0000\u0000\u0224\u0219\u0001\u0000\u0000"+
		"\u0000\u0225?\u0001\u0000\u0000\u0000\u0226\u0227\u0005 \u0000\u0000\u0227"+
		"\u0228\u0005\u0019\u0000\u0000\u0228\u0229\u0005\u0013\u0000\u0000\u0229"+
		"\u022e\u0003B!\u0000\u022a\u022b\u0005\u001a\u0000\u0000\u022b\u022d\u0003"+
		"B!\u0000\u022c\u022a\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000"+
		"\u0000\u022e\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000"+
		"\u0000\u022f\u0231\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000"+
		"\u0000\u0231\u0233\u0005\u0014\u0000\u0000\u0232\u0234\u0005\u001d\u0000"+
		"\u0000\u0233\u0232\u0001\u0000\u0000\u0000\u0233\u0234\u0001\u0000\u0000"+
		"\u0000\u0234A\u0001\u0000\u0000\u0000\u0235\u0236\u0005\u0094\u0000\u0000"+
		"\u0236\u0237\u0005\u0019\u0000\u0000\u0237\u0238\u0003D\"\u0000\u0238"+
		"C\u0001\u0000\u0000\u0000\u0239\u0240\u0003F#\u0000\u023a\u0240\u0003"+
		"H$\u0000\u023b\u0240\u0005\u001b\u0000\u0000\u023c\u0240\u0005\u0091\u0000"+
		"\u0000\u023d\u0240\u00052\u0000\u0000\u023e\u0240\u0005\u0094\u0000\u0000"+
		"\u023f\u0239\u0001\u0000\u0000\u0000\u023f\u023a\u0001\u0000\u0000\u0000"+
		"\u023f\u023b\u0001\u0000\u0000\u0000\u023f\u023c\u0001\u0000\u0000\u0000"+
		"\u023f\u023d\u0001\u0000\u0000\u0000\u023f\u023e\u0001\u0000\u0000\u0000"+
		"\u0240E\u0001\u0000\u0000\u0000\u0241\u024a\u0005\u0017\u0000\u0000\u0242"+
		"\u0247\u0003D\"\u0000\u0243\u0244\u0005\u001a\u0000\u0000\u0244\u0246"+
		"\u0003D\"\u0000\u0245\u0243\u0001\u0000\u0000\u0000\u0246\u0249\u0001"+
		"\u0000\u0000\u0000\u0247\u0245\u0001\u0000\u0000\u0000\u0247\u0248\u0001"+
		"\u0000\u0000\u0000\u0248\u024b\u0001\u0000\u0000\u0000\u0249\u0247\u0001"+
		"\u0000\u0000\u0000\u024a\u0242\u0001\u0000\u0000\u0000\u024a\u024b\u0001"+
		"\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024d\u0005"+
		"\u0018\u0000\u0000\u024dG\u0001\u0000\u0000\u0000\u024e\u0257\u0005\u0013"+
		"\u0000\u0000\u024f\u0254\u0003B!\u0000\u0250\u0251\u0005\u001a\u0000\u0000"+
		"\u0251\u0253\u0003B!\u0000\u0252\u0250\u0001\u0000\u0000\u0000\u0253\u0256"+
		"\u0001\u0000\u0000\u0000\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0255"+
		"\u0001\u0000\u0000\u0000\u0255\u0258\u0001\u0000\u0000\u0000\u0256\u0254"+
		"\u0001\u0000\u0000\u0000\u0257\u024f\u0001\u0000\u0000\u0000\u0257\u0258"+
		"\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a"+
		"\u0005\u0014\u0000\u0000\u025aI\u0001\u0000\u0000\u0000\u025b\u025d\u0003"+
		"\u0084B\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000"+
		"\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e\u025f\u00056\u0000"+
		"\u0000\u025f\u0261\u0005\u0015\u0000\u0000\u0260\u0262\u0003L&\u0000\u0261"+
		"\u0260\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262"+
		"\u0263\u0001\u0000\u0000\u0000\u0263\u0264\u0005\u0016\u0000\u0000\u0264"+
		"\u0268\u0005\u0013\u0000\u0000\u0265\u0267\u0003d2\u0000\u0266\u0265\u0001"+
		"\u0000\u0000\u0000\u0267\u026a\u0001\u0000\u0000\u0000\u0268\u0266\u0001"+
		"\u0000\u0000\u0000\u0268\u0269\u0001\u0000\u0000\u0000\u0269\u026b\u0001"+
		"\u0000\u0000\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026b\u026c\u0005"+
		"\u0014\u0000\u0000\u026cK\u0001\u0000\u0000\u0000\u026d\u0272\u0003N\'"+
		"\u0000\u026e\u026f\u0005\u001a\u0000\u0000\u026f\u0271\u0003N\'\u0000"+
		"\u0270\u026e\u0001\u0000\u0000\u0000\u0271\u0274\u0001\u0000\u0000\u0000"+
		"\u0272\u0270\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000\u0000"+
		"\u0273M\u0001\u0000\u0000\u0000\u0274\u0272\u0001\u0000\u0000\u0000\u0275"+
		"\u0277\u0003\u0084B\u0000\u0276\u0275\u0001\u0000\u0000\u0000\u0276\u0277"+
		"\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u0279"+
		"\u0005\u0094\u0000\u0000\u0279\u027a\u0005\u0019\u0000\u0000\u027a\u027b"+
		"\u0003X,\u0000\u027bO\u0001\u0000\u0000\u0000\u027c\u027e\u0003\u0084"+
		"B\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027d\u027e\u0001\u0000\u0000"+
		"\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0280\u0005\u0094\u0000"+
		"\u0000\u0280\u0282\u0005\u0015\u0000\u0000\u0281\u0283\u0003R)\u0000\u0282"+
		"\u0281\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u0283"+
		"\u0284\u0001\u0000\u0000\u0000\u0284\u0287\u0005\u0016\u0000\u0000\u0285"+
		"\u0286\u0005\u0019\u0000\u0000\u0286\u0288\u0003X,\u0000\u0287\u0285\u0001"+
		"\u0000\u0000\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0001"+
		"\u0000\u0000\u0000\u0289\u028d\u0005\u0013\u0000\u0000\u028a\u028c\u0003"+
		"d2\u0000\u028b\u028a\u0001\u0000\u0000\u0000\u028c\u028f\u0001\u0000\u0000"+
		"\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000"+
		"\u0000\u028e\u0290\u0001\u0000\u0000\u0000\u028f\u028d\u0001\u0000\u0000"+
		"\u0000\u0290\u0291\u0005\u0014\u0000\u0000\u0291Q\u0001\u0000\u0000\u0000"+
		"\u0292\u0297\u0003T*\u0000\u0293\u0294\u0005\u001a\u0000\u0000\u0294\u0296"+
		"\u0003T*\u0000\u0295\u0293\u0001\u0000\u0000\u0000\u0296\u0299\u0001\u0000"+
		"\u0000\u0000\u0297\u0295\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000"+
		"\u0000\u0000\u0298S\u0001\u0000\u0000\u0000\u0299\u0297\u0001\u0000\u0000"+
		"\u0000\u029a\u029b\u0005\u0094\u0000\u0000\u029b\u029c\u0005\u0019\u0000"+
		"\u0000\u029c\u02a2\u0003V+\u0000\u029d\u029e\u0005\u0094\u0000\u0000\u029e"+
		"\u029f\u0005\u001e\u0000\u0000\u029f\u02a0\u0005\u0019\u0000\u0000\u02a0"+
		"\u02a2\u0003V+\u0000\u02a1\u029a\u0001\u0000\u0000\u0000\u02a1\u029d\u0001"+
		"\u0000\u0000\u0000\u02a2U\u0001\u0000\u0000\u0000\u02a3\u02a6\u0005=\u0000"+
		"\u0000\u02a4\u02a6\u0003X,\u0000\u02a5\u02a3\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a4\u0001\u0000\u0000\u0000\u02a6W\u0001\u0000\u0000\u0000\u02a7\u02ac"+
		"\u0003Z-\u0000\u02a8\u02a9\u0005\'\u0000\u0000\u02a9\u02ab\u0003Z-\u0000"+
		"\u02aa\u02a8\u0001\u0000\u0000\u0000\u02ab\u02ae\u0001\u0000\u0000\u0000"+
		"\u02ac\u02aa\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000"+
		"\u02adY\u0001\u0000\u0000\u0000\u02ae\u02ac\u0001\u0000\u0000\u0000\u02af"+
		"\u02b5\u0003\\.\u0000\u02b0\u02b5\u0003`0\u0000\u02b1\u02b5\u0003b1\u0000"+
		"\u02b2\u02b5\u0005\u0094\u0000\u0000\u02b3\u02b5\u0005Y\u0000\u0000\u02b4"+
		"\u02af\u0001\u0000\u0000\u0000\u02b4\u02b0\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b1\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b3\u0001\u0000\u0000\u0000\u02b5[\u0001\u0000\u0000\u0000\u02b6\u02b7"+
		"\u0005\u0094\u0000\u0000\u02b7\u02b8\u0005_\u0000\u0000\u02b8\u02bd\u0003"+
		"^/\u0000\u02b9\u02ba\u0005\u001a\u0000\u0000\u02ba\u02bc\u0003^/\u0000"+
		"\u02bb\u02b9\u0001\u0000\u0000\u0000\u02bc\u02bf\u0001\u0000\u0000\u0000"+
		"\u02bd\u02bb\u0001\u0000\u0000\u0000\u02bd\u02be\u0001\u0000\u0000\u0000"+
		"\u02be\u02c0\u0001\u0000\u0000\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c1\u0005`\u0000\u0000\u02c1]\u0001\u0000\u0000\u0000\u02c2\u02c5"+
		"\u0003Z-\u0000\u02c3\u02c5\u0005\u001b\u0000\u0000\u02c4\u02c2\u0001\u0000"+
		"\u0000\u0000\u02c4\u02c3\u0001\u0000\u0000\u0000\u02c5_\u0001\u0000\u0000"+
		"\u0000\u02c6\u02c9\u0003b1\u0000\u02c7\u02c9\u0005\u0094\u0000\u0000\u02c8"+
		"\u02c6\u0001\u0000\u0000\u0000\u02c8\u02c7\u0001\u0000\u0000\u0000\u02c9"+
		"\u02ca\u0001\u0000\u0000\u0000\u02ca\u02cb\u0005\u0017\u0000\u0000\u02cb"+
		"\u02cc\u0005\u0018\u0000\u0000\u02cca\u0001\u0000\u0000\u0000\u02cd\u02ce"+
		"\u0007\u0002\u0000\u0000\u02cec\u0001\u0000\u0000\u0000\u02cf\u02d0\u0007"+
		"\u0003\u0000\u0000\u02d0\u02d3\u0005\u0094\u0000\u0000\u02d1\u02d2\u0005"+
		"\u0019\u0000\u0000\u02d2\u02d4\u0003X,\u0000\u02d3\u02d1\u0001\u0000\u0000"+
		"\u0000\u02d3\u02d4\u0001\u0000\u0000\u0000\u02d4\u02d5\u0001\u0000\u0000"+
		"\u0000\u02d5\u0309\u0005\u001d\u0000\u0000\u02d6\u02d7\u0007\u0003\u0000"+
		"\u0000\u02d7\u02da\u0005\u0094\u0000\u0000\u02d8\u02d9\u0005\u0019\u0000"+
		"\u0000\u02d9\u02db\u0003X,\u0000\u02da\u02d8\u0001\u0000\u0000\u0000\u02da"+
		"\u02db\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc"+
		"\u02dd\u0005,\u0000\u0000\u02dd\u02de\u0003f3\u0000\u02de\u02df\u0005"+
		"\u001d\u0000\u0000\u02df\u0309\u0001\u0000\u0000\u0000\u02e0\u02e1\u0003"+
		"h4\u0000\u02e1\u02e2\u0005,\u0000\u0000\u02e2\u02e3\u0003f3\u0000\u02e3"+
		"\u02e4\u0005\u001d\u0000\u0000\u02e4\u0309\u0001\u0000\u0000\u0000\u02e5"+
		"\u02e6\u00054\u0000\u0000\u02e6\u02e8\u0005\u0015\u0000\u0000\u02e7\u02e9"+
		"\u0003f3\u0000\u02e8\u02e7\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000"+
		"\u0000\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000\u02ea\u02eb\u0005\u0016"+
		"\u0000\u0000\u02eb\u02ef\u0005\u0013\u0000\u0000\u02ec\u02ee\u0003d2\u0000"+
		"\u02ed\u02ec\u0001\u0000\u0000\u0000\u02ee\u02f1\u0001\u0000\u0000\u0000"+
		"\u02ef\u02ed\u0001\u0000\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000"+
		"\u02f0\u02f2\u0001\u0000\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000"+
		"\u02f2\u0309\u0005\u0014\u0000\u0000\u02f3\u02f4\u00055\u0000\u0000\u02f4"+
		"\u02f6\u0005\u0015\u0000\u0000\u02f5\u02f7\u0005\u001b\u0000\u0000\u02f6"+
		"\u02f5\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001\u0000\u0000\u0000\u02f7"+
		"\u02f8\u0001\u0000\u0000\u0000\u02f8\u02f9\u0005\u0016\u0000\u0000\u02f9"+
		"\u02fd\u0005\u0013\u0000\u0000\u02fa\u02fc\u0003d2\u0000\u02fb\u02fa\u0001"+
		"\u0000\u0000\u0000\u02fc\u02ff\u0001\u0000\u0000\u0000\u02fd\u02fb\u0001"+
		"\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000\u0000\u0000\u02fe\u0300\u0001"+
		"\u0000\u0000\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000\u0300\u0309\u0005"+
		"\u0014\u0000\u0000\u0301\u0302\u00058\u0000\u0000\u0302\u0303\u0003f3"+
		"\u0000\u0303\u0304\u0005\u001d\u0000\u0000\u0304\u0309\u0001\u0000\u0000"+
		"\u0000\u0305\u0306\u0003f3\u0000\u0306\u0307\u0005\u001d\u0000\u0000\u0307"+
		"\u0309\u0001\u0000\u0000\u0000\u0308\u02cf\u0001\u0000\u0000\u0000\u0308"+
		"\u02d6\u0001\u0000\u0000\u0000\u0308\u02e0\u0001\u0000\u0000\u0000\u0308"+
		"\u02e5\u0001\u0000\u0000\u0000\u0308\u02f3\u0001\u0000\u0000\u0000\u0308"+
		"\u0301\u0001\u0000\u0000\u0000\u0308\u0305\u0001\u0000\u0000\u0000\u0309"+
		"e\u0001\u0000\u0000\u0000\u030a\u030b\u00063\uffff\uffff\u0000\u030b\u030c"+
		"\u0003j5\u0000\u030c\u0318\u0001\u0000\u0000\u0000\u030d\u030e\n\u0001"+
		"\u0000\u0000\u030e\u030f\u0005\u001e\u0000\u0000\u030f\u0310\u0003f3\u0000"+
		"\u0310\u0311\u0005\u0019\u0000\u0000\u0311\u0312\u0003f3\u0002\u0312\u0317"+
		"\u0001\u0000\u0000\u0000\u0313\u0314\n\u0003\u0000\u0000\u0314\u0315\u0005"+
		"K\u0000\u0000\u0315\u0317\u0003j5\u0000\u0316\u030d\u0001\u0000\u0000"+
		"\u0000\u0316\u0313\u0001\u0000\u0000\u0000\u0317\u031a\u0001\u0000\u0000"+
		"\u0000\u0318\u0316\u0001\u0000\u0000\u0000\u0318\u0319\u0001\u0000\u0000"+
		"\u0000\u0319g\u0001\u0000\u0000\u0000\u031a\u0318\u0001\u0000\u0000\u0000"+
		"\u031b\u031c\u0005C\u0000\u0000\u031c\u031e\u0005D\u0000\u0000\u031d\u031b"+
		"\u0001\u0000\u0000\u0000\u031d\u031e\u0001\u0000\u0000\u0000\u031e\u031f"+
		"\u0001\u0000\u0000\u0000\u031f\u0328\u0005\u0094\u0000\u0000\u0320\u0321"+
		"\u0005D\u0000\u0000\u0321\u0327\u0005\u0094\u0000\u0000\u0322\u0323\u0005"+
		"\u0017\u0000\u0000\u0323\u0324\u0003f3\u0000\u0324\u0325\u0005\u0018\u0000"+
		"\u0000\u0325\u0327\u0001\u0000\u0000\u0000\u0326\u0320\u0001\u0000\u0000"+
		"\u0000\u0326\u0322\u0001\u0000\u0000\u0000\u0327\u032a\u0001\u0000\u0000"+
		"\u0000\u0328\u0326\u0001\u0000\u0000\u0000\u0328\u0329\u0001\u0000\u0000"+
		"\u0000\u0329i\u0001\u0000\u0000\u0000\u032a\u0328\u0001\u0000\u0000\u0000"+
		"\u032b\u032c\u00065\uffff\uffff\u0000\u032c\u032d\u0003l6\u0000\u032d"+
		"\u0333\u0001\u0000\u0000\u0000\u032e\u032f\n\u0002\u0000\u0000\u032f\u0330"+
		"\u0005J\u0000\u0000\u0330\u0332\u0003l6\u0000\u0331\u032e\u0001\u0000"+
		"\u0000\u0000\u0332\u0335\u0001\u0000\u0000\u0000\u0333\u0331\u0001\u0000"+
		"\u0000\u0000\u0333\u0334\u0001\u0000\u0000\u0000\u0334k\u0001\u0000\u0000"+
		"\u0000\u0335\u0333\u0001\u0000\u0000\u0000\u0336\u0337\u00066\uffff\uffff"+
		"\u0000\u0337\u0338\u0003n7\u0000\u0338\u033e\u0001\u0000\u0000\u0000\u0339"+
		"\u033a\n\u0002\u0000\u0000\u033a\u033b\u0007\u0004\u0000\u0000\u033b\u033d"+
		"\u0003n7\u0000\u033c\u0339\u0001\u0000\u0000\u0000\u033d\u0340\u0001\u0000"+
		"\u0000\u0000\u033e\u033c\u0001\u0000\u0000\u0000\u033e\u033f\u0001\u0000"+
		"\u0000\u0000\u033fm\u0001\u0000\u0000\u0000\u0340\u033e\u0001\u0000\u0000"+
		"\u0000\u0341\u0342\u00067\uffff\uffff\u0000\u0342\u0343\u0003p8\u0000"+
		"\u0343\u0349\u0001\u0000\u0000\u0000\u0344\u0345\n\u0002\u0000\u0000\u0345"+
		"\u0346\u0007\u0005\u0000\u0000\u0346\u0348\u0003p8\u0000\u0347\u0344\u0001"+
		"\u0000\u0000\u0000\u0348\u034b\u0001\u0000\u0000\u0000\u0349\u0347\u0001"+
		"\u0000\u0000\u0000\u0349\u034a\u0001\u0000\u0000\u0000\u034ao\u0001\u0000"+
		"\u0000\u0000\u034b\u0349\u0001\u0000\u0000\u0000\u034c\u034d\u00068\uffff"+
		"\uffff\u0000\u034d\u034e\u0003r9\u0000\u034e\u0354\u0001\u0000\u0000\u0000"+
		"\u034f\u0350\n\u0002\u0000\u0000\u0350\u0351\u0007\u0006\u0000\u0000\u0351"+
		"\u0353\u0003r9\u0000\u0352\u034f\u0001\u0000\u0000\u0000\u0353\u0356\u0001"+
		"\u0000\u0000\u0000\u0354\u0352\u0001\u0000\u0000\u0000\u0354\u0355\u0001"+
		"\u0000\u0000\u0000\u0355q\u0001\u0000\u0000\u0000\u0356\u0354\u0001\u0000"+
		"\u0000\u0000\u0357\u0358\u00069\uffff\uffff\u0000\u0358\u0359\u0003t:"+
		"\u0000\u0359\u035f\u0001\u0000\u0000\u0000\u035a\u035b\n\u0002\u0000\u0000"+
		"\u035b\u035c\u0007\u0007\u0000\u0000\u035c\u035e\u0003t:\u0000\u035d\u035a"+
		"\u0001\u0000\u0000\u0000\u035e\u0361\u0001\u0000\u0000\u0000\u035f\u035d"+
		"\u0001\u0000\u0000\u0000\u035f\u0360\u0001\u0000\u0000\u0000\u0360s\u0001"+
		"\u0000\u0000\u0000\u0361\u035f\u0001\u0000\u0000\u0000\u0362\u0363\u0007"+
		"\b\u0000\u0000\u0363\u0366\u0003t:\u0000\u0364\u0366\u0003v;\u0000\u0365"+
		"\u0362\u0001\u0000\u0000\u0000\u0365\u0364\u0001\u0000\u0000\u0000\u0366"+
		"u\u0001\u0000\u0000\u0000\u0367\u036b\u0003x<\u0000\u0368\u036a\u0003"+
		"z=\u0000\u0369\u0368\u0001\u0000\u0000\u0000\u036a\u036d\u0001\u0000\u0000"+
		"\u0000\u036b\u0369\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000"+
		"\u0000\u036cw\u0001\u0000\u0000\u0000\u036d\u036b\u0001\u0000\u0000\u0000"+
		"\u036e\u03a4\u0005C\u0000\u0000\u036f\u03a4\u0005\u0094\u0000\u0000\u0370"+
		"\u03a4\u0005\u001b\u0000\u0000\u0371\u03a4\u0005\u0091\u0000\u0000\u0372"+
		"\u03a4\u0005\b\u0000\u0000\u0373\u03a4\u0005\t\u0000\u0000\u0374\u037d"+
		"\u0005\u0013\u0000\u0000\u0375\u037a\u0003\u0082A\u0000\u0376\u0377\u0005"+
		"\u001a\u0000\u0000\u0377\u0379\u0003\u0082A\u0000\u0378\u0376\u0001\u0000"+
		"\u0000\u0000\u0379\u037c\u0001\u0000\u0000\u0000\u037a\u0378\u0001\u0000"+
		"\u0000\u0000\u037a\u037b\u0001\u0000\u0000\u0000\u037b\u037e\u0001\u0000"+
		"\u0000\u0000\u037c\u037a\u0001\u0000\u0000\u0000\u037d\u0375\u0001\u0000"+
		"\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037e\u037f\u0001\u0000"+
		"\u0000\u0000\u037f\u03a4\u0005\u0014\u0000\u0000\u0380\u0389\u0005\u0017"+
		"\u0000\u0000\u0381\u0386\u0003~?\u0000\u0382\u0383\u0005\u001a\u0000\u0000"+
		"\u0383\u0385\u0003~?\u0000\u0384\u0382\u0001\u0000\u0000\u0000\u0385\u0388"+
		"\u0001\u0000\u0000\u0000\u0386\u0384\u0001\u0000\u0000\u0000\u0386\u0387"+
		"\u0001\u0000\u0000\u0000\u0387\u038a\u0001\u0000\u0000\u0000\u0388\u0386"+
		"\u0001\u0000\u0000\u0000\u0389\u0381\u0001\u0000\u0000\u0000\u0389\u038a"+
		"\u0001\u0000\u0000\u0000\u038a\u038b\u0001\u0000\u0000\u0000\u038b\u03a4"+
		"\u0005\u0018\u0000\u0000\u038c\u038d\u0005\u0015\u0000\u0000\u038d\u038e"+
		"\u0003f3\u0000\u038e\u038f\u0005\u0016\u0000\u0000\u038f\u03a4\u0001\u0000"+
		"\u0000\u0000\u0390\u03a4\u0003\u0080@\u0000\u0391\u03a4\u00052\u0000\u0000"+
		"\u0392\u0393\u0005>\u0000\u0000\u0393\u0395\u0005\u0094\u0000\u0000\u0394"+
		"\u0396\u0003|>\u0000\u0395\u0394\u0001\u0000\u0000\u0000\u0395\u0396\u0001"+
		"\u0000\u0000\u0000\u0396\u0397\u0001\u0000\u0000\u0000\u0397\u03a0\u0005"+
		"\u0015\u0000\u0000\u0398\u039d\u0003f3\u0000\u0399\u039a\u0005\u001a\u0000"+
		"\u0000\u039a\u039c\u0003f3\u0000\u039b\u0399\u0001\u0000\u0000\u0000\u039c"+
		"\u039f\u0001\u0000\u0000\u0000\u039d\u039b\u0001\u0000\u0000\u0000\u039d"+
		"\u039e\u0001\u0000\u0000\u0000\u039e\u03a1\u0001\u0000\u0000\u0000\u039f"+
		"\u039d\u0001\u0000\u0000\u0000\u03a0\u0398\u0001\u0000\u0000\u0000\u03a0"+
		"\u03a1\u0001\u0000\u0000\u0000\u03a1\u03a2\u0001\u0000\u0000\u0000\u03a2"+
		"\u03a4\u0005\u0016\u0000\u0000\u03a3\u036e\u0001\u0000\u0000\u0000\u03a3"+
		"\u036f\u0001\u0000\u0000\u0000\u03a3\u0370\u0001\u0000\u0000\u0000\u03a3"+
		"\u0371\u0001\u0000\u0000\u0000\u03a3\u0372\u0001\u0000\u0000\u0000\u03a3"+
		"\u0373\u0001\u0000\u0000\u0000\u03a3\u0374\u0001\u0000\u0000\u0000\u03a3"+
		"\u0380\u0001\u0000\u0000\u0000\u03a3\u038c\u0001\u0000\u0000\u0000\u03a3"+
		"\u0390\u0001\u0000\u0000\u0000\u03a3\u0391\u0001\u0000\u0000\u0000\u03a3"+
		"\u0392\u0001\u0000\u0000\u0000\u03a4y\u0001\u0000\u0000\u0000\u03a5\u03a6"+
		"\u0005D\u0000\u0000\u03a6\u03a7\u0005\u0094\u0000\u0000\u03a7\u03b0\u0005"+
		"\u0015\u0000\u0000\u03a8\u03ad\u0003f3\u0000\u03a9\u03aa\u0005\u001a\u0000"+
		"\u0000\u03aa\u03ac\u0003f3\u0000\u03ab\u03a9\u0001\u0000\u0000\u0000\u03ac"+
		"\u03af\u0001\u0000\u0000\u0000\u03ad\u03ab\u0001\u0000\u0000\u0000\u03ad"+
		"\u03ae\u0001\u0000\u0000\u0000\u03ae\u03b1\u0001\u0000\u0000\u0000\u03af"+
		"\u03ad\u0001\u0000\u0000\u0000\u03b0\u03a8\u0001\u0000\u0000\u0000\u03b0"+
		"\u03b1\u0001\u0000\u0000\u0000\u03b1\u03b2\u0001\u0000\u0000\u0000\u03b2"+
		"\u03c9\u0005\u0016\u0000\u0000\u03b3\u03b4\u0005D\u0000\u0000\u03b4\u03c9"+
		"\u0005\u0094\u0000\u0000\u03b5\u03b6\u0005\u0017\u0000\u0000\u03b6\u03b7"+
		"\u0003f3\u0000\u03b7\u03b8\u0005\u0018\u0000\u0000\u03b8\u03c9\u0001\u0000"+
		"\u0000\u0000\u03b9\u03bb\u0005\u0015\u0000\u0000\u03ba\u03bc\u0005E\u0000"+
		"\u0000\u03bb\u03ba\u0001\u0000\u0000\u0000\u03bb\u03bc\u0001\u0000\u0000"+
		"\u0000\u03bc\u03c5\u0001\u0000\u0000\u0000\u03bd\u03c2\u0003f3\u0000\u03be"+
		"\u03bf\u0005\u001a\u0000\u0000\u03bf\u03c1\u0003f3\u0000\u03c0\u03be\u0001"+
		"\u0000\u0000\u0000\u03c1\u03c4\u0001\u0000\u0000\u0000\u03c2\u03c0\u0001"+
		"\u0000\u0000\u0000\u03c2\u03c3\u0001\u0000\u0000\u0000\u03c3\u03c6\u0001"+
		"\u0000\u0000\u0000\u03c4\u03c2\u0001\u0000\u0000\u0000\u03c5\u03bd\u0001"+
		"\u0000\u0000\u0000\u03c5\u03c6\u0001\u0000\u0000\u0000\u03c6\u03c7\u0001"+
		"\u0000\u0000\u0000\u03c7\u03c9\u0005\u0016\u0000\u0000\u03c8\u03a5\u0001"+
		"\u0000\u0000\u0000\u03c8\u03b3\u0001\u0000\u0000\u0000\u03c8\u03b5\u0001"+
		"\u0000\u0000\u0000\u03c8\u03b9\u0001\u0000\u0000\u0000\u03c9{\u0001\u0000"+
		"\u0000\u0000\u03ca\u03cb\u0005_\u0000\u0000\u03cb\u03d0\u0003^/\u0000"+
		"\u03cc\u03cd\u0005\u001a\u0000\u0000\u03cd\u03cf\u0003^/\u0000\u03ce\u03cc"+
		"\u0001\u0000\u0000\u0000\u03cf\u03d2\u0001\u0000\u0000\u0000\u03d0\u03ce"+
		"\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1\u03d3"+
		"\u0001\u0000\u0000\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d3\u03d4"+
		"\u0005`\u0000\u0000\u03d4}\u0001\u0000\u0000\u0000\u03d5\u03d6\u0005E"+
		"\u0000\u0000\u03d6\u03d9\u0003f3\u0000\u03d7\u03d9\u0003f3\u0000\u03d8"+
		"\u03d5\u0001\u0000\u0000\u0000\u03d8\u03d7\u0001\u0000\u0000\u0000\u03d9"+
		"\u007f\u0001\u0000\u0000\u0000\u03da\u03e3\u0005\u0015\u0000\u0000\u03db"+
		"\u03e0\u0005\u0094\u0000\u0000\u03dc\u03dd\u0005\u001a\u0000\u0000\u03dd"+
		"\u03df\u0005\u0094\u0000\u0000\u03de\u03dc\u0001\u0000\u0000\u0000\u03df"+
		"\u03e2\u0001\u0000\u0000\u0000\u03e0\u03de\u0001\u0000\u0000\u0000\u03e0"+
		"\u03e1\u0001\u0000\u0000\u0000\u03e1\u03e4\u0001\u0000\u0000\u0000\u03e2"+
		"\u03e0\u0001\u0000\u0000\u0000\u03e3\u03db\u0001\u0000\u0000\u0000\u03e3"+
		"\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e5\u0001\u0000\u0000\u0000\u03e5"+
		"\u03e6\u0005\u0016\u0000\u0000\u03e6\u03f0\u0005\u001f\u0000\u0000\u03e7"+
		"\u03f1\u0003f3\u0000\u03e8\u03ec\u0005\u0013\u0000\u0000\u03e9\u03eb\u0003"+
		"d2\u0000\u03ea\u03e9\u0001\u0000\u0000\u0000\u03eb\u03ee\u0001\u0000\u0000"+
		"\u0000\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ec\u03ed\u0001\u0000\u0000"+
		"\u0000\u03ed\u03ef\u0001\u0000\u0000\u0000\u03ee\u03ec\u0001\u0000\u0000"+
		"\u0000\u03ef\u03f1\u0005\u0014\u0000\u0000\u03f0\u03e7\u0001\u0000\u0000"+
		"\u0000\u03f0\u03e8\u0001\u0000\u0000\u0000\u03f1\u0400\u0001\u0000\u0000"+
		"\u0000\u03f2\u03f3\u0005\u0094\u0000\u0000\u03f3\u03fd\u0005\u001f\u0000"+
		"\u0000\u03f4\u03fe\u0003f3\u0000\u03f5\u03f9\u0005\u0013\u0000\u0000\u03f6"+
		"\u03f8\u0003d2\u0000\u03f7\u03f6\u0001\u0000\u0000\u0000\u03f8\u03fb\u0001"+
		"\u0000\u0000\u0000\u03f9\u03f7\u0001\u0000\u0000\u0000\u03f9\u03fa\u0001"+
		"\u0000\u0000\u0000\u03fa\u03fc\u0001\u0000\u0000\u0000\u03fb\u03f9\u0001"+
		"\u0000\u0000\u0000\u03fc\u03fe\u0005\u0014\u0000\u0000\u03fd\u03f4\u0001"+
		"\u0000\u0000\u0000\u03fd\u03f5\u0001\u0000\u0000\u0000\u03fe\u0400\u0001"+
		"\u0000\u0000\u0000\u03ff\u03da\u0001\u0000\u0000\u0000\u03ff\u03f2\u0001"+
		"\u0000\u0000\u0000\u0400\u0081\u0001\u0000\u0000\u0000\u0401\u0402\u0007"+
		"\t\u0000\u0000\u0402\u0403\u0005\u0019\u0000\u0000\u0403\u0407\u0003f"+
		"3\u0000\u0404\u0405\u0005E\u0000\u0000\u0405\u0407\u0003f3\u0000\u0406"+
		"\u0401\u0001\u0000\u0000\u0000\u0406\u0404\u0001\u0000\u0000\u0000\u0407"+
		"\u0083\u0001\u0000\u0000\u0000\u0408\u040a\u0007\n\u0000\u0000\u0409\u040b"+
		"\u0005B\u0000\u0000\u040a\u0409\u0001\u0000\u0000\u0000\u040a\u040b\u0001"+
		"\u0000\u0000\u0000\u040b\u0085\u0001\u0000\u0000\u0000\u040c\u040e\u0003"+
		"\u0088D\u0000\u040d\u040c\u0001\u0000\u0000\u0000\u040e\u040f\u0001\u0000"+
		"\u0000\u0000\u040f\u040d\u0001\u0000\u0000\u0000\u040f\u0410\u0001\u0000"+
		"\u0000\u0000\u0410\u0087\u0001\u0000\u0000\u0000\u0411\u0412\u0005_\u0000"+
		"\u0000\u0412\u0416\u0007\u000b\u0000\u0000\u0413\u0415\u0003\u0090H\u0000"+
		"\u0414\u0413\u0001\u0000\u0000\u0000\u0415\u0418\u0001\u0000\u0000\u0000"+
		"\u0416\u0414\u0001\u0000\u0000\u0000\u0416\u0417\u0001\u0000\u0000\u0000"+
		"\u0417\u0419\u0001\u0000\u0000\u0000\u0418\u0416\u0001\u0000\u0000\u0000"+
		"\u0419\u042d\u0005`\u0000\u0000\u041a\u041b\u0005_\u0000\u0000\u041b\u041f"+
		"\u0005\u0094\u0000\u0000\u041c\u041e\u0003\u0090H\u0000\u041d\u041c\u0001"+
		"\u0000\u0000\u0000\u041e\u0421\u0001\u0000\u0000\u0000\u041f\u041d\u0001"+
		"\u0000\u0000\u0000\u041f\u0420\u0001\u0000\u0000\u0000\u0420\u0422\u0001"+
		"\u0000\u0000\u0000\u0421\u041f\u0001\u0000\u0000\u0000\u0422\u0426\u0005"+
		"`\u0000\u0000\u0423\u0425\u0003\u008aE\u0000\u0424\u0423\u0001\u0000\u0000"+
		"\u0000\u0425\u0428\u0001\u0000\u0000\u0000\u0426\u0424\u0001\u0000\u0000"+
		"\u0000\u0426\u0427\u0001\u0000\u0000\u0000\u0427\u0429\u0001\u0000\u0000"+
		"\u0000\u0428\u0426\u0001\u0000\u0000\u0000\u0429\u042a\u0005a\u0000\u0000"+
		"\u042a\u042b\u0005\u0094\u0000\u0000\u042b\u042d\u0005`\u0000\u0000\u042c"+
		"\u0411\u0001\u0000\u0000\u0000\u042c\u041a\u0001\u0000\u0000\u0000\u042d"+
		"\u0089\u0001\u0000\u0000\u0000\u042e\u0432\u0003\u0088D\u0000\u042f\u0432"+
		"\u0003\u008cF\u0000\u0430\u0432\u0003\u008eG\u0000\u0431\u042e\u0001\u0000"+
		"\u0000\u0000\u0431\u042f\u0001\u0000\u0000\u0000\u0431\u0430\u0001\u0000"+
		"\u0000\u0000\u0432\u008b\u0001\u0000\u0000\u0000\u0433\u0434\u0005^\u0000"+
		"\u0000\u0434\u008d\u0001\u0000\u0000\u0000\u0435\u0437\u0007\f\u0000\u0000"+
		"\u0436\u0435\u0001\u0000\u0000\u0000\u0437\u0438\u0001\u0000\u0000\u0000"+
		"\u0438\u0436\u0001\u0000\u0000\u0000\u0438\u0439\u0001\u0000\u0000\u0000"+
		"\u0439\u008f\u0001\u0000\u0000\u0000\u043a\u0442\u0003\u0092I\u0000\u043b"+
		"\u0442\u0003\u0094J\u0000\u043c\u0442\u0005g\u0000\u0000\u043d\u0442\u0005"+
		"h\u0000\u0000\u043e\u0442\u0005i\u0000\u0000\u043f\u0442\u0005f\u0000"+
		"\u0000\u0440\u0442\u0005\u0094\u0000\u0000\u0441\u043a\u0001\u0000\u0000"+
		"\u0000\u0441\u043b\u0001\u0000\u0000\u0000\u0441\u043c\u0001\u0000\u0000"+
		"\u0000\u0441\u043d\u0001\u0000\u0000\u0000\u0441\u043e\u0001\u0000\u0000"+
		"\u0000\u0441\u043f\u0001\u0000\u0000\u0000\u0441\u0440\u0001\u0000\u0000"+
		"\u0000\u0442\u0091\u0001\u0000\u0000\u0000\u0443\u0444\u0005e\u0000\u0000"+
		"\u0444\u0445\u0005,\u0000\u0000\u0445\u0446\u0005\u001b\u0000\u0000\u0446"+
		"\u0093\u0001\u0000\u0000\u0000\u0447\u0448\u0005d\u0000\u0000\u0448\u0449"+
		"\u0005,\u0000\u0000\u0449\u044a\u0005\u001b\u0000\u0000\u044a\u0095\u0001"+
		"\u0000\u0000\u0000\u044b\u044d\u0003\u0098L\u0000\u044c\u044b\u0001\u0000"+
		"\u0000\u0000\u044d\u0450\u0001\u0000\u0000\u0000\u044e\u044c\u0001\u0000"+
		"\u0000\u0000\u044e\u044f\u0001\u0000\u0000\u0000\u044f\u0097\u0001\u0000"+
		"\u0000\u0000\u0450\u044e\u0001\u0000\u0000\u0000\u0451\u0453\u0005\u0093"+
		"\u0000\u0000\u0452\u0451\u0001\u0000\u0000\u0000\u0453\u0454\u0001\u0000"+
		"\u0000\u0000\u0454\u0452\u0001\u0000\u0000\u0000\u0454\u0455\u0001\u0000"+
		"\u0000\u0000\u0455\u0457\u0001\u0000\u0000\u0000\u0456\u0458\u0007\r\u0000"+
		"\u0000\u0457\u0456\u0001\u0000\u0000\u0000\u0457\u0458\u0001\u0000\u0000"+
		"\u0000\u0458\u0459\u0001\u0000\u0000\u0000\u0459\u0462\u0005\u0013\u0000"+
		"\u0000\u045a\u045f\u0003\u009aM\u0000\u045b\u045c\u0005\u001d\u0000\u0000"+
		"\u045c\u045e\u0003\u009aM\u0000\u045d\u045b\u0001\u0000\u0000\u0000\u045e"+
		"\u0461\u0001\u0000\u0000\u0000\u045f\u045d\u0001\u0000\u0000\u0000\u045f"+
		"\u0460\u0001\u0000\u0000\u0000\u0460\u0463\u0001\u0000\u0000\u0000\u0461"+
		"\u045f\u0001\u0000\u0000\u0000\u0462\u045a\u0001\u0000\u0000\u0000\u0462"+
		"\u0463\u0001\u0000\u0000\u0000\u0463\u0465\u0001\u0000\u0000\u0000\u0464"+
		"\u0466\u0005\u001d\u0000\u0000\u0465\u0464\u0001\u0000\u0000\u0000\u0465"+
		"\u0466\u0001\u0000\u0000\u0000\u0466\u0467\u0001\u0000\u0000\u0000\u0467"+
		"\u0468\u0005\u0014\u0000\u0000\u0468\u0099\u0001\u0000\u0000\u0000\u0469"+
		"\u046a\u0003\u009cN\u0000\u046a\u046c\u0005\u0019\u0000\u0000\u046b\u046d"+
		"\u0003\u00a0P\u0000\u046c\u046b\u0001\u0000\u0000\u0000\u046d\u046e\u0001"+
		"\u0000\u0000\u0000\u046e\u046c\u0001\u0000\u0000\u0000\u046e\u046f\u0001"+
		"\u0000\u0000\u0000\u046f\u009b\u0001\u0000\u0000\u0000\u0470\u0471\u0007"+
		"\u000e\u0000\u0000\u0471\u009d\u0001\u0000\u0000\u0000\u0472\u0474\u0003"+
		"\u00a0P\u0000\u0473\u0472\u0001\u0000\u0000\u0000\u0474\u0475\u0001\u0000"+
		"\u0000\u0000\u0475\u0473\u0001\u0000\u0000\u0000\u0475\u0476\u0001\u0000"+
		"\u0000\u0000\u0476\u009f\u0001\u0000\u0000\u0000\u0477\u0478\u0007\u000f"+
		"\u0000\u0000\u0478\u00a1\u0001\u0000\u0000\u0000\u0088\u00a5\u00ac\u00b1"+
		"\u00b5\u00c2\u00c5\u00c9\u00d1\u00d4\u00df\u00e7\u00e9\u00ec\u00f9\u0103"+
		"\u010b\u0116\u0121\u012b\u0131\u013f\u014a\u014f\u015d\u0165\u016c\u0172"+
		"\u0177\u017c\u0180\u0182\u018b\u0197\u019e\u01a8\u01b4\u01c1\u01cc\u01d3"+
		"\u01d8\u01dd\u01e1\u01eb\u01f4\u01fa\u0201\u0207\u020e\u0211\u0219\u021e"+
		"\u0224\u022e\u0233\u023f\u0247\u024a\u0254\u0257\u025c\u0261\u0268\u0272"+
		"\u0276\u027d\u0282\u0287\u028d\u0297\u02a1\u02a5\u02ac\u02b4\u02bd\u02c4"+
		"\u02c8\u02d3\u02da\u02e8\u02ef\u02f6\u02fd\u0308\u0316\u0318\u031d\u0326"+
		"\u0328\u0333\u033e\u0349\u0354\u035f\u0365\u036b\u037a\u037d\u0386\u0389"+
		"\u0395\u039d\u03a0\u03a3\u03ad\u03b0\u03bb\u03c2\u03c5\u03c8\u03d0\u03d8"+
		"\u03e0\u03e3\u03ec\u03f0\u03f9\u03fd\u03ff\u0406\u040a\u040f\u0416\u041f"+
		"\u0426\u042c\u0431\u0438\u0441\u044e\u0454\u0457\u045f\u0462\u0465\u046e"+
		"\u0475";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}