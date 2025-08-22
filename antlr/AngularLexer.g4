lexer grammar AngularLexer;

@header{
package gen;
}

AT_COMPONENT: '@Component';
STANDALONE: 'standalone';
IMPORTS: 'imports';
IMPORT:'import';
STYLES: 'styles';
TEMPLATE:'template';
TEMPLATE_URL:'templateUrl';
TRUE: 'true';
FALSE: 'false';
FROM: 'from';
AS: 'as';
CLASS:'class';
EXPORT:'export';
SELECTOR:'selector';
STYLES_URL:'styleUrl';




ROUTER: 'router';

LBRACE: '{'; RBRACE: '}';
LPARENTHESIS: '('; RPARENTHESIS: ')';
LBRACKET: '['; RBRACKET: ']';
COLON: ':'; COMMA: ',';
STRING: ('\'' .*? '\''|'"' .*? '"' );
BACKTICK: '`';
SEMICOLON: ';';
QUESTION:'?';
ARROW: '=>';

// ===== State Management =====
STATE: 'state';

// ===== TypeScript =====
EQUAL_SIGN: '=';
NUMBER: 'number'; STRINGDL: 'string'; BOOLEAN: 'boolean'; ANY: 'any'; VOID: 'void'; NULL: 'null';
LET: 'let'; IF: 'if'; FOR: 'for'; CONSTRUCTOR: 'constructor'; CONST:'const';
RETURN: 'return'; SWITCH: 'switch'; CASE: 'case'; DEFAULT: 'default'; BREAK: 'break';
EVENT:'Event';
// primitive data type
PUBLIC:'public';
PRIVATE:'private';
PROTECTED:'protected';
READONLY: 'readonly';


// ===== This and Spread =====
THIS: 'this';
DOT: '.';
ELLIPSIS: '...';

// ===== TS Operations =====
PLUS: '+'; MINUS: '-'; STAR: '*'; SLASH: '/';
AND_OP: '&&'; OR_OP: '||'; NOT_OP: '!';
EQEQ: '=='; EQEQEQ: '==='; NEQ: '!='; NEQEQ: '!==';
LTE : '<=';
GTE : '>=';

// ===== Angular Template tokens =====
ANGULAR_DIRECTIVE : '*' ID;                 // *ngIf, *ngFor
ANGULAR_EVENT     : '(' ID ')';             // (click)
ANGULAR_PROPERTY  : '[' ID ']';             // [src], [class.active]
ANGULAR_TWO_WAY   : '[(' ID ')]';           // [(ngModel)]
ANGULAR_BINDING   : '{{' .*? '}}';          // {{ expr }}

// HTML
TAG_OPEN : '<';
TAG_CLOSE : '>';
TAG_OPEN_SELF : '</';
TAG_CLOSE_SELF:'/>';

ATTRIBUTE : ID EQUAL_SIGN STRING;
ANGULAR_ATTRIBUTE_DIRECTIVE : ANGULAR_DIRECTIVE EQUAL_SIGN STRING ;
ANGULAR_ATTRIBUTE_PROPERTY  : ANGULAR_PROPERTY  EQUAL_SIGN STRING ;
ANGULAR_ATTRIBUTE_EVENT     : ANGULAR_EVENT     EQUAL_SIGN STRING ;
ANGULAR_ATTRIBUTE_TWO_WAY   : ANGULAR_TWO_WAY   EQUAL_SIGN STRING ;






// ===== CSS   =====
// Properties
DISPLAY: 'display';
MARGIN: 'margin';
FONT_FAMILY: 'font-family';
PADDING: 'padding';
WIDTH: 'width';
BORDER_RIGHT: 'border-right';
OVERFLOW_Y: 'overflow-y';
BORDER: 'border';
CURSOR: 'cursor';
TRANSITION: 'transition';
HEIGHT: 'height';
MARGIN_RIGHT: 'margin-right';
BORDER_SOLID: 'border-solid';
COLOR: 'color';
BACKGROUND: 'background';
BACKGROUND_COLOR: 'background-color';
BORDER_RADIUS: 'border-radius';
GAP: 'gap';
BORDER_BOTTOM_COLOR: 'border-bottom-color';
MARGIN_BOTTOM: 'margin-bottom';
TOP: 'top';
LEFT: 'left';
POSITION: 'position';
JUSTIFY_CONTENT: 'justify-content';
ALIGN_ITEMS: 'align-items';
MAX_WIDTH: 'max-width';
BOX_SIZING:'box-sizing';
MAGIN_TOP:'margin-top';
OBJECT_FIT:'object-fit';
Z_INDEX:'z-index';


// Property values
NUMERIC_VALUE: [0-9]+ ('.' [0-9]+)? (('px' | 'em' | 'rem' | '%')?);
COLOR_VALUE: '#' [0-9a-fA-F]+
           | 'rgb(' [0-9]+ ',' [0-9]+ ',' [0-9]+ ')'
           | 'rgba(' [0-9]+ ',' [0-9]+ ',' [0-9]+ ',' [0-9]+ ')';

// CSS selector
CSS_SELECTOR: ('.'|'#') [a-zA-Z_-][a-zA-Z_0-9-.]*  ([a-zA-Z_0-9]*)?;







// ===== Identifiers & misc =====

ID: [a-zA-Z][a-zA-Z_0-9-.]*;

WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
SPACE: ' ';


