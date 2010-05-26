lexer grammar PCMStoEx;

T53 : '?' ;
T54 : ':' ;

// $ANTLR src "PCMStoEx.g" 374
OR
	:	'OR'
	;

// $ANTLR src "PCMStoEx.g" 378
XOR
	:	'XOR'
	;

// $ANTLR src "PCMStoEx.g" 382
AND
	:	'AND'
	;

// $ANTLR src "PCMStoEx.g" 386
NOT
	:	'NOT'
	;

// $ANTLR src "PCMStoEx.g" 390
INTPMF
	:	'IntPMF'
	;

// $ANTLR src "PCMStoEx.g" 394
DOUBLEPMF
	:	'DoublePMF'
	;

// $ANTLR src "PCMStoEx.g" 398
ENUMPMF
	:	'EnumPMF'
	;

// $ANTLR src "PCMStoEx.g" 402
DOUBLEPDF
	:	'DoublePDF'
	;

// $ANTLR src "PCMStoEx.g" 406
BOOLPMF
	:	'BoolPMF'
	;

// $ANTLR src "PCMStoEx.g" 410
UNIT
	:	'unit'
	;

// $ANTLR src "PCMStoEx.g" 414
BOOL
	:	'"bool"'
	;

// $ANTLR src "PCMStoEx.g" 418
FALSE
	:	'false'
	;

// $ANTLR src "PCMStoEx.g" 422
TRUE
	:	'true'
	;

// $ANTLR src "PCMStoEx.g" 426
BYTESIZE
	:	'BYTESIZE'
	;

// $ANTLR src "PCMStoEx.g" 430
STRUCTURE
	:	'STRUCTURE'
	;

// $ANTLR src "PCMStoEx.g" 434
NUMBER_OF_ELEMENTS
	:	'NUMBER_OF_ELEMENTS'
	;

// $ANTLR src "PCMStoEx.g" 438
TYPE
	:	'TYPE'
	;

// $ANTLR src "PCMStoEx.g" 442
VALUE
	:	'VALUE'
	;

// $ANTLR src "PCMStoEx.g" 446
INNER
	:	'INNER'
	;

// $ANTLR src "PCMStoEx.g" 450
PLUS  : '+' ;
// $ANTLR src "PCMStoEx.g" 451
MINUS : '-' ;
// $ANTLR src "PCMStoEx.g" 452
MUL   : '*' ;
// $ANTLR src "PCMStoEx.g" 453
DIV   : '/' ;
// $ANTLR src "PCMStoEx.g" 454
MOD   : '%' ;
// $ANTLR src "PCMStoEx.g" 455
POW   : '^' ;
// $ANTLR src "PCMStoEx.g" 456
LPAREN: '(' ;
// $ANTLR src "PCMStoEx.g" 457
RPAREN: ')' ;
// $ANTLR src "PCMStoEx.g" 458
SEMI  : ';' ;
// $ANTLR src "PCMStoEx.g" 459
COLON 	:	',';
// $ANTLR src "PCMStoEx.g" 460
DEFINITION : '=' ;
// $ANTLR src "PCMStoEx.g" 461
ORDERED_DEF
	:	'ordered';
// $ANTLR src "PCMStoEx.g" 463
EQUAL : '==' ;
// $ANTLR src "PCMStoEx.g" 464
SQUARE_PAREN_L : '[' ;
// $ANTLR src "PCMStoEx.g" 465
SQUARE_PAREN_R : ']' ;
// $ANTLR src "PCMStoEx.g" 466
fragment DIGIT : '0'..'9' ;
// $ANTLR src "PCMStoEx.g" 467
NUMBER : '-'? (DIGIT)+ ('.' (DIGIT)+)? Exponent?;
// $ANTLR src "PCMStoEx.g" 468
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
// $ANTLR src "PCMStoEx.g" 470
fragment ALPHA : 'a'..'z' | 'A'..'Z' ;
// $ANTLR src "PCMStoEx.g" 471
NOTEQUAL : '<>' ;
// $ANTLR src "PCMStoEx.g" 472
GREATER : '>' ;
// $ANTLR src "PCMStoEx.g" 473
LESS : '<' ;
// $ANTLR src "PCMStoEx.g" 474
GREATEREQUAL : '>=' ;
// $ANTLR src "PCMStoEx.g" 475
LESSEQUAL : '<=' ;
// $ANTLR src "PCMStoEx.g" 476
STRING_LITERAL : '\"' (ALPHA|'_')+ '\"' ;
// $ANTLR src "PCMStoEx.g" 477
DOT: '.';
// $ANTLR src "PCMStoEx.g" 478
ID:(ALPHA|'_')+;


// $ANTLR src "PCMStoEx.g" 481
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

// $ANTLR src "PCMStoEx.g" 484
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "PCMStoEx.g" 488
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? ('\n'|EOF) {$channel=HIDDEN;}
    ;


