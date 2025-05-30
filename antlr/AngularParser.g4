parser grammar AngularParser;

@header{
package gen;
}

options { tokenVocab = AngularLexer; }

//   <<<<<< Angular parser

program
    : AT_COMPONENT LPARENTHESIS LBRACE (SELECTOR COLON STRING COMMA  STANDALONE COLON (TRUE | FALSE) COMMA)
      (cssOption COMMA)?
      (htmlOption COMMA)?
      RBRACE RPARENTHESIS EXPORT CLASS ID LBRACE ts RBRACE
    ;

cssOption: STYLES COLON LBRACKET BACKTICK css BACKTICK RBRACKET;
htmlOption: TEMPLATE COLON BACKTICK html BACKTICK;

  // <<<<<<< ts parser


  ts: (attribute | method)* constructor? (attribute | method)* ;


  attribute :
             ID COLON type SEMICOLON                        #DeclareAttribute
            |ID COLON type EQUAL_SIGN literal SEMICOLON     #DeclareAndAssignAttribute
  ;


  expression:
           LET ID COLON type SEMICOLON                                          #DeclareVariable
          |LET ID COLON type EQUAL_SIGN literal SEMICOLON                       #DeclareAndAssign
          |ID EQUAL_SIGN literal SEMICOLON                                      #AssignVariable
          |(THIS)? ID EQUAL_SIGN literal SEMICOLON                              #AssignAttribute
          |IF LPARENTHESIS STRING? RPARENTHESIS  LBRACE expression* RBRACE      #If
          |FOR LPARENTHESIS STRING? RPARENTHESIS  LBRACE expression* RBRACE     #For
  ;


  constructor:CONSTRUCTOR LPARENTHESIS RPARENTHESIS  LBRACE expression* RBRACE ;


  type: NUMBER | STRINGDL | BOOLEAN | ANY  ;

  literal
      :ID                                                           #StoredID
      | STRING                                                      #String
      | NUMERIC_VALUE                                               #Number
      | (TRUE | FALSE)                                              #Boolean
      | LBRACE (ID COLON STRING (COMMA ID COLON STRING)*)? RBRACE   #KeyValue
      | LBRACKET ((literal COMMA)* literal)? RBRACKET                  #Array
      ;


  method
      : ID LPARENTHESIS methodParams? RPARENTHESIS (COLON VOID)? LBRACE expression* RBRACE
      ;


  methodParams
      : ID COLON type (COMMA ID COLON type)*
      ;

// <<<<<    html parser

html
    : div;

div
    : TAG_OPEN ID divAttribute* TAG_CLOSE
      divChild*
      TAG_OPEN_SELF ID TAG_CLOSE        #DivElement
    ;

divAttribute
    :ng                                 #NgDirective
    | event                              #EventBinding
    | ATTRIBUTE                          #ClassId
    ;

divChild
    : img                                #Image
    | div                                #NestedDiv
    | br                                 #BrTag
    | paragragh                          #Paragraph
    ;

paragragh
    : hElement                           #H_Element
    | pElement                           #P_Element
    ;

hElement
    : TAG_OPEN ID TAG_CLOSE ANGULAR_BINDING TAG_OPEN_SELF ID TAG_CLOSE;

pElement
    : TAG_OPEN P TAG_CLOSE ANGULAR_BINDING TAG_OPEN_SELF P TAG_CLOSE;

img
    : TAG_OPEN ID ANGULAR_ATTRIBUTE_PROPERTY TAG_CLOSE;

br
    : TAG_OPEN ID TAG_CLOSE ANGULAR_BINDING;

/*classID
    : ATTRIBUTE;*/

ng
    : ANGULAR_ATTRIBUTE_DIRECTIVE;

event
    : ANGULAR_ATTRIBUTE_EVENT;

// <<<<<<<<<<<<< css parser


css:cssDeclaration*;

cssDeclaration: CSS_SELECTOR (ID)? LBRACE (cssProperty (SEMICOLON cssProperty)*)? SEMICOLON?  RBRACE;

cssProperty: property  COLON propertyValue+;

property: DISPLAY
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
        ;

propertyValue: STRING
             | ID
             | NUMERIC_VALUE
             | COLOR_VALUE
//             | LBRACKET cssDeclaration RBRACKET
             ;


