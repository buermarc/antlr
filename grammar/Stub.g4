// TODO split grammar file into multiple files
grammar Stub ;

file
    : 
    (functionDecl | varDecl)+ ;

arrayDecl
    : varType=type identifier=ID '[' count=INT ']' ';'  #ArrayDeclaration
    ;

varDecl
    : varType=type identifier=ID ('=' expression=expr)? ';' #VarDeclaration
    ;

type: type '['']' | 'float' | 'int' | 'void' ; //TODO get rid of void type

functionDecl
    :
    fnType=type id=ID '(' params=formalParameters? ')' bl=block 
    ;

formalParameters
    : formalParameter (',' formalParameter)*
    ;

formalParameter
    : paramType=type id=ID
    ;

block: '{' stat* '}' ;

stat: block                              #ExprBlock
    | varDecl                            #ExprVarDecl
    | arrayDecl                          #ExprArrayDecl
    | 'if' expression=expr 'then' thenBlock=stat ('else' elseBlock=stat)? #IfElse
    | ret='return' returnE=expr? ';'                #Return
    | left=expr '=' right=expr ';'                 #AssignExpr// assignment on expr
    | expr ';'                          #Expression// call a funtion
    ;

// expr should always return a value for llvm
//PRINTLN'(' expressions=exprList? ')'   #PrintNewline
expr: id=ID'(' expressions=exprList? ')' #FunctionCall 
    | array=expr '[' index=expr ']'                 #IndexE
    | '-' expr                          #NegativeE
    | '!' expr                          #FlipE
    | left=expr mathChar=('*'|'/') right=expr       #MultDiv
    | left=expr mathChar=('+'|'-') right=expr       #AddSub 
    | left=expr '==' right=expr         #Compare
    | id=ID                                #Identifier
    | number=INT                        #Number
    | number=FLOAT                      #Float
    | chars=STRING                      #String 
    | '(' expr ')'                      #Cover
    ;

exprList: expr (',' expr)* ; // arg list

ID: LETTER (LETTER | [0-9] | '_')* ;

STRING: '"' (ESC|.)*? '"' ;            

fragment
LETTER: [a-zA-Z]+ ;
ESC: '\\"' | '\\\\' ;

INT: [0-9]+ ;
FLOAT: [0-9]+.[0-9];

WS: [ \n\t\r] -> skip ;

SL_COMMENT
    : '//' .*? '\n' -> skip
    ;
