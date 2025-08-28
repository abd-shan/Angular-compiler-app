parser grammar AngularParser;

@header{
package gen;
}

options { tokenVocab = AngularLexer; }

// ===== Program:  state / Component =====

angularApp
  : angularFile+ EOF
  ;



  angularFile
    : componentFile
    | stateFile
    | routeFile
    ;

  // ======================= route file rules =======================
  routeFile
    : importStatement*                                    // optional imports
      EXPORT? CONST ID COLON ID EQUAL_SIGN                // e.g. export const routes: Routes =
      LBRACKET (routeObject (COMMA routeObject)*)? RBRACKET SEMICOLON?
    ;

  routeObject
    : LBRACE (routeProperty (COMMA routeProperty)*)? RBRACE
    ;

  routeProperty
    : ID COLON tsExpr
    ;

// ==================== state file ====================
//done
stateFile
  : importStatement*
    (stateInterface | stateVariable | stateAction | stateReducer | stateServiceClass)+
  ;

stateServiceClass
  : injectableDecorator? EXPORT CLASS ID LBRACE ts RBRACE
  ;

injectableDecorator
  : AT_INJECTABLE LPARENTHESIS LBRACE injectableOptions? RBRACE RPARENTHESIS
  ;

injectableOptions
  : PROVIDED_IN COLON STRING
  ;


stateInterface
  : EXPORT? INTERFACE ID LBRACE stateInterfaceProperty* RBRACE
  ;

stateInterfaceProperty
  : ID COLON tsType SEMICOLON
  ;

stateVariable
  : EXPORT? CONST ID COLON ID EQUAL_SIGN objectValue SEMICOLON
  ;

stateAction
  : EXPORT? CONST ID EQUAL_SIGN CREATE_ACTION LPARENTHESIS STRING (COMMA tsExpr)? RPARENTHESIS SEMICOLON
  ;


stateReducer
  : EXPORT? CONST ID EQUAL_SIGN CREATE_REDUCER LPARENTHESIS ID COMMA reducerOnList RPARENTHESIS SEMICOLON
  ;

reducerOnList
  : (COMMA? ON LPARENTHESIS ID COMMA arrowFunction RPARENTHESIS)+
  ;

// ===================   component file  ===================
componentFile
  : importStatement*
    AT_COMPONENT LPARENTHESIS LBRACE
        SELECTOR COLON STRING COMMA
        (STANDALONE COLON (TRUE | FALSE) COMMA)?
        (IMPORTS COLON LBRACKET SPACE* componentList SPACE* RBRACKET COMMA)?
        (cssOption COMMA)?
        (htmlOption COMMA)?
        (providersOption COMMA?)?
    RBRACE RPARENTHESIS
    EXPORT CLASS ID (IMPLEMENTS ID)?
    LBRACE ts RBRACE
  ;
//provider done
providersOption
  : PROVIDERS COLON LBRACKET SPACE* providerList SPACE* RBRACKET
  ;

  providerList
    : providerExpression (COMMA providerExpression)*
    ;

    providerExpression
      : ID LPARENTHESIS LBRACE ID COLON ID RBRACE RPARENTHESIS  #provideStoreExpression
      | ID                                                      #simpleProvider
      ;


cssOption   : STYLES   COLON LBRACKET BACKTICK css  BACKTICK RBRACKET
            | STYLES_URL COLON STRING;

htmlOption
  : TEMPLATE COLON BACKTICK html BACKTICK        #inlineTemplate
  | TEMPLATE_URL COLON STRING                    #externalTemplate
  ;

//done inport
importStatement
  : IMPORT importClause FROM STRING SEMICOLON?
  ;

importClause
  : defaultImport (COMMA namespaceImport)?
  | defaultImport (COMMA namedImports)?
  | namespaceImport
  | namedImports
  ;

defaultImport
  : ID
  |ON
  |CREATE_REDUCER
  |CREATE_ACTION
  |MAP
  ;

namespaceImport
  : STAR AS ID
  ;

namedImports
  : LBRACE importSpecList? RBRACE
  ;

importSpecList
  : importSpecifier (COMMA importSpecifier)*
  ;

importSpecifier
  : defaultImport (AS defaultImport)?
  ;


componentList
  : ID (COMMA ID)*
  ;

// ===== TypeScript (Statements + Expressions) =====

ts
  : tsStatement
  ;

tsStatement:(tsAttribute | stateDecl | method)* constructor? (tsAttribute | stateDecl | method)*;

// >>> TypeScript Attributes

tsAttribute
  : primitiveDataType? ID COLON tsType SEMICOLON                                  #DeclareAttribute
  | primitiveDataType? ID (COLON tsType)? EQUAL_SIGN tsExpr SEMICOLON             #DeclareAndAssignAttribute
  ;


// >>> State Management
stateDecl
  : STATE COLON LBRACE stateProperty (COMMA stateProperty)* RBRACE SEMICOLON?
  ;

stateProperty
  : ID COLON stateValue
  ;

stateValue
  : arrayValue
  | objectValue
  | STRING
  | NUMERIC_VALUE
  | NULL
  | ID
  ;

// Array
arrayValue
  : LBRACKET (stateValue (COMMA stateValue)*)? RBRACKET
  ;


// Object
objectValue
  : LBRACE (stateProperty (COMMA stateProperty)*)? RBRACE
  ;
//-----------------------------

constructor
  : primitiveDataType? CONSTRUCTOR LPARENTHESIS constructorParams? RPARENTHESIS LBRACE tsStmt* RBRACE
  ;

constructorParams
  : constructorParam (COMMA constructorParam)*
  ;

constructorParam
  : primitiveDataType? ID COLON tsType
  ;


method
  : primitiveDataType?  ID LPARENTHESIS methodParams? RPARENTHESIS (COLON tsType)? LBRACE tsStmt* RBRACE
  ;

methodParams
  : methodParam (COMMA methodParam)*
  ;

methodParam
  : ID COLON paramType
  | ID QUESTION COLON paramType
  ;

paramType
  : EVENT
  | tsType
  ;


//done type
tsType:  genericOrBasicType (PIPE genericOrBasicType)*;

genericOrBasicType
  : genericType
  | arrayType
  | type
  | ID
  | UNDEFINED
  ;

genericType
  : ID TAG_OPEN genericTypeParam (COMMA genericTypeParam)* TAG_CLOSE
  ;

genericTypeParam
  : genericOrBasicType
  | STRING
  ;

arrayType: ((type|ID) LBRACKET RBRACKET);



type
  : NUMBER | STRINGDL | BOOLEAN | ANY | NULL
  ;


// >>> Statements
tsStmt
  : (LET | CONST) ID (COLON tsType)? SEMICOLON                                        #DeclareVariable
  | (LET | CONST) ID (COLON tsType)? EQUAL_SIGN tsExpr SEMICOLON                      #DeclareAndAssign
  | leftHandSide EQUAL_SIGN tsExpr SEMICOLON                                          #Assign
  | IF LPARENTHESIS tsExpr? RPARENTHESIS LBRACE tsStmt* RBRACE                        #If
  | FOR LPARENTHESIS STRING? RPARENTHESIS LBRACE tsStmt* RBRACE                       #For
  | RETURN tsExpr SEMICOLON                                                           #ReturnStatement
  | tsExpr SEMICOLON                                                                  #ExprStatement
  ;

// >>> Expressions
tsExpr
  : tsExpr OR_OP tsAndExpr                #OrExpr
  | tsAndExpr                             #ToAnd
  | tsExpr QUESTION tsExpr COLON tsExpr  #TernaryExpr
  ;


  leftHandSide
    : (THIS DOT)? ID ( (DOT ID) | (LBRACKET tsExpr RBRACKET) )*
    ;

tsAndExpr
  : tsAndExpr AND_OP tsEqExpr             #AndExpr
  | tsEqExpr                              #ToEq
  ;

tsEqExpr
  : tsEqExpr (EQEQ | EQEQEQ | NEQ | NEQEQ) tsRelExpr   #EqNeq
  | tsRelExpr                                          #ToRel
  ;

tsRelExpr
  : tsRelExpr (TAG_OPEN | TAG_CLOSE | LTE | GTE) tsAddExpr          #Relational
  | tsAddExpr                                          #ToAdd
  ;


tsAddExpr
  : tsAddExpr (PLUS | MINUS) tsMulExpr    #AddSub
  | tsMulExpr                             #ToMul
  ;

tsMulExpr
  : tsMulExpr (STAR | SLASH) tsUnaryExpr  #MulDiv
  | tsUnaryExpr                           #ToUnary
  ;

tsUnaryExpr
  : (NOT_OP | PLUS | MINUS) tsUnaryExpr                    #UnaryOp
  | tsPrimary                                              #ToPrimary
  ;


tsPrimary
  : tsAtom tsPostfix*
  ;

  tsAtom
    : THIS                                                     #ThisRef
    | ID                                                       #StoredID
    | STRING                                                   #String
    | NUMERIC_VALUE                                            #Number
    | TRUE                                                     #BooleanTrue
    | FALSE                                                    #BooleanFalse
    | LBRACE ( (keyValuePair (COMMA keyValuePair)*)? ) RBRACE   #KeyValue
    | LBRACKET ((spreadOrExpr (COMMA spreadOrExpr)*)?) RBRACKET #Array
    | LPARENTHESIS tsExpr RPARENTHESIS                         #Paren
    | arrowFunction                                             #ArrowFn
    | NULL                                                     #Null
    | NEW ID (genericTypeArguments)? LPARENTHESIS (tsExpr (COMMA tsExpr)*)? RPARENTHESIS #NewExpression
    ;

    tsPostfix
      : DOT ID LPARENTHESIS (tsExpr (COMMA tsExpr)*)? RPARENTHESIS    #DotCall
      | DOT ID                                                        #DotAccess
      | LBRACKET tsExpr RBRACKET                                      #BracketAccess
      | LPARENTHESIS ELLIPSIS? (tsExpr (COMMA tsExpr)*)? RPARENTHESIS  #Call
      ;


genericTypeArguments
  : TAG_OPEN genericTypeParam (COMMA genericTypeParam)* TAG_CLOSE
  ;

  spreadOrExpr
    : ELLIPSIS tsExpr
    | tsExpr
    ;


arrowFunction
  : LPARENTHESIS (ID (COMMA ID)*)? RPARENTHESIS ARROW (tsExpr | LBRACE tsStmt* RBRACE)
  | ID ARROW (tsExpr | LBRACE tsStmt* RBRACE)
  ;



keyValuePair
  : (ID | STRING) COLON tsExpr
  | ELLIPSIS tsExpr
  ;

primitiveDataType:  (PUBLIC | PRIVATE | PROTECTED )  READONLY?;


// ===== HTML Template =====

html
  : element+
  ;


element
    :TAG_OPEN ( IMG | INPUT ) htmlAttribute* TAG_CLOSE                                     #TerminalElement
    |TAG_OPEN ID htmlAttribute* TAG_CLOSE node* TAG_OPEN_SELF ID TAG_CLOSE     #NonTerminalElement
  ;


node
  : element
  | interpolation
  | textNode
  ;


interpolation
  : ANGULAR_BINDING
  ;

textNode
  : (ID | STRING | NUMERIC_VALUE | COLON)+
  ;



htmlAttribute
  : ngForDirective                   // *ngFor="..."
  | ngIfDirective                    // *ngIf="..."
  | ANGULAR_ATTRIBUTE_PROPERTY       // [src]="..."
  | ANGULAR_ATTRIBUTE_EVENT          // (click)="..."
  | ANGULAR_ATTRIBUTE_TWO_WAY        // [(ngModel)]="..."
  | ATTRIBUTE                        // class="...", id="...", type="text", name="name", ...
  | ID                               // ← خصائص بدون قيمة: required, disabled, autofocus, ...
  ;

  ngForDirective
    : NG_FOR EQUAL_SIGN STRING
    ;

  ngIfDirective
    :  NG_IF EQUAL_SIGN STRING
    ;





// ===== CSS =====

css
  : cssDeclaration*
  ;

cssDeclaration
  : CSS_SELECTOR+ (IMG|ID)? LBRACE (cssProperty (SEMICOLON cssProperty)*)? SEMICOLON? RBRACE
  ;

cssProperty
  : property COLON cssToken+
  ;

property
  : DISPLAY
  | MARGIN
  | FONT_FAMILY
  | PADDING
  | WIDTH
  | BORDER_RIGHT
  | OVERFLOW_Y
  | BORDER
  | CURSOR
  | TRANSITION
  | HEIGHT
  | MARGIN_RIGHT
  | BORDER_SOLID
  | COLOR
  | BACKGROUND_COLOR
  | BACKGROUND
  | BORDER_RADIUS
  | GAP
  | BORDER_BOTTOM_COLOR
  | MARGIN_BOTTOM
  | POSITION
  | TOP
  | LEFT
  | JUSTIFY_CONTENT
  | ALIGN_ITEMS
  | MAX_WIDTH
  | BOX_SIZING
  | MAGIN_TOP
  | OBJECT_FIT
  | Z_INDEX
  | TEXT_DECORATION
  | FONT_WEIGHT
  | RESIZE
  | TSXT_ALIGN
  | FONT_SIZE
  | GRID_TEMPLATE_COLUMNS
  | BOX_SHADOW
  | FLEX_DIRECTION
  | OVERFLOW
  ;

cssValue
  : cssToken+
  ;

cssToken
  :ID
  | STRING
  | NUMERIC_VALUE
  | COLOR_VALUE
  | COMMA
  | LPARENTHESIS
  | RPARENTHESIS
  | LBRACKET
  | RBRACKET
  | DOT
  | SLASH
  | STAR
  | PLUS
  | MINUS
  | EQUAL_SIGN
  | COLON
  | SPACE
  ;


