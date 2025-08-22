parser grammar AngularParser;

@header{
package gen;
}

options { tokenVocab = AngularLexer; }

// ===== Program / Component =====

angularApp: program+ EOF;

program
  : importStatement*
    AT_COMPONENT LPARENTHESIS LBRACE
        SELECTOR COLON STRING COMMA
        (STANDALONE COLON (TRUE | FALSE) COMMA)?
        (IMPORTS COLON LBRACKET SPACE* componentList SPACE* RBRACKET COMMA)?
        (cssOption COMMA)?
        (htmlOption COMMA)?
    RBRACE RPARENTHESIS
    EXPORT CLASS ID
    LBRACE ts RBRACE
  ;

cssOption   : STYLES   COLON LBRACKET BACKTICK css  BACKTICK RBRACKET
            | STYLES_URL COLON STRING;

htmlOption
  : TEMPLATE COLON BACKTICK html BACKTICK       #inlineTemplate
  | TEMPLATE_URL COLON STRING                    #externalTemplate
  ;

importStatement
  : IMPORT (importClause) FROM STRING SEMICOLON?
  ;

importClause
  : defaultImport
  | namespaceImport
  | namedImports
  | defaultImport COMMA namespaceImport
  | defaultImport COMMA namedImports
  ;

defaultImport
  : ID
  ;

namespaceImport
  : STAR AS ID
  ;

namedImports
  : LBRACE (importSpecifier (COMMA importSpecifier)*)? RBRACE
  ;

importSpecifier
  : ID (AS ID)?
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
  : primitiveDataType? ID COLON type SEMICOLON                               #DeclareAttribute
  | primitiveDataType? ID (COLON type)? EQUAL_SIGN tsExpr SEMICOLON             #DeclareAndAssignAttribute
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

constructor
  : CONSTRUCTOR LPARENTHESIS RPARENTHESIS LBRACE tsStmt* RBRACE
  ;

method
  : primitiveDataType? ID LPARENTHESIS methodParams? RPARENTHESIS (COLON VOID)? LBRACE tsStmt* RBRACE
  ;


methodParams
  : ID COLON paramType (COMMA ID COLON paramType)*
  ;

paramType: EVENT | tsType;

tsType: arrayType | type;



arrayType: type LBRACKET RBRACKET;

type
  : NUMBER | STRINGDL | BOOLEAN | ANY
  ;

// >>> Statements
tsStmt
  : (LET | CONST) ID (COLON type)? SEMICOLON                                       #DeclareVariable
  | (LET | CONST) ID (COLON type)? EQUAL_SIGN tsExpr SEMICOLON                     #DeclareAndAssign
  | (THIS DOT)? ID (DOT ID)* EQUAL_SIGN tsExpr SEMICOLON                           #AssignAttribute
  | IF LPARENTHESIS tsExpr? RPARENTHESIS LBRACE tsStmt* RBRACE                     #If
  | FOR LPARENTHESIS STRING? RPARENTHESIS LBRACE tsStmt* RBRACE                    #For
  | tsExpr SEMICOLON                                                               #ExprStatement
  ;


// >>> Expressions
tsExpr
  : tsExpr OR_OP tsAndExpr                #OrExpr
  | tsAndExpr                             #ToAnd
  | tsExpr QUESTION tsExpr COLON tsExpr  #TernaryExpr
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
  : NOT_OP tsUnaryExpr                    #NotExpr
  | tsPrimary                             #ToPrimary
  ;

tsPrimary
  : ID                                                                                           #StoredID
  | STRING                                                                                       #String
  | NUMERIC_VALUE                                                                                #Number
  | TRUE                                                                                         #BooleanTrue
  | FALSE                                                                                        #BooleanFalse
  | LBRACE ( (keyValuePair (COMMA keyValuePair)*)? ) RBRACE                                      #KeyValue
  | LBRACKET ((spreadOrExpr (COMMA spreadOrExpr)*)?) RBRACKET                                    #Array
  | LPARENTHESIS tsExpr RPARENTHESIS                                                             #Paren
  | tsPrimary DOT ID LPARENTHESIS (tsExpr (COMMA tsExpr)*)? RPARENTHESIS                         #FunctionCall
  | ID LPARENTHESIS ELLIPSIS? (tsExpr (COMMA tsExpr)*)? RPARENTHESIS                             #SimpleCall
  | arrowFunction                                                                                #ArrowFn
  | (THIS DOT)? ID (DOT ID)*                                                                     #PropertyAccess
  | (THIS DOT)? ID (DOT ID)* (DOT ID LPARENTHESIS SPACE* (tsExpr (COMMA tsExpr)*)? SPACE* RPARENTHESIS)?       #PropertyAccessFunction
  | NULL                                                                                         #Null
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
  : node+
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


element
  : TAG_OPEN ID htmlAttribute* (TAG_CLOSE (node* TAG_OPEN_SELF ID TAG_CLOSE)? | TAG_CLOSE_SELF)
  ;


htmlAttribute
  : ANGULAR_ATTRIBUTE_DIRECTIVE      // *ngIf="..."
  | ANGULAR_ATTRIBUTE_PROPERTY       // [src]="..."
  | ANGULAR_ATTRIBUTE_EVENT          // (click)="..."
  | ANGULAR_ATTRIBUTE_TWO_WAY        // [(ngModel)]="..."
  | ATTRIBUTE                        // class="...", id="...", type="text", name="name", ...
  | ID                               // ← خصائص بدون قيمة: required, disabled, autofocus, ...
  ;

// ===== CSS =====

css
  : cssDeclaration*
  ;

cssDeclaration
  : CSS_SELECTOR+ (ID)? LBRACE (cssProperty (SEMICOLON cssProperty)*)? SEMICOLON? RBRACE
  ;

cssProperty
  : property COLON propertyValue+
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
  ;

propertyValue
  : STRING
  | ID
  | ID COMMA ID
  | NUMERIC_VALUE
  | COLOR_VALUE
  ;
