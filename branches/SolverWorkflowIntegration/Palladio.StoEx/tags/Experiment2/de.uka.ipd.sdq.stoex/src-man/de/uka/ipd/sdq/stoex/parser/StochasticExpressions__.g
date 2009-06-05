lexer grammar StochasticExpressions;

T33 : 'OR' ;
T34 : 'XOR' ;
T35 : 'AND' ;
T36 : 'NOT' ;
T37 : 'IntPMF' ;
T38 : 'DoublePMF' ;
T39 : 'EnumPMF' ;
T40 : 'DoublePDF' ;
T41 : 'BoolPMF' ;
T42 : 'unit' ;
T43 : '"bool"' ;
T44 : 'false' ;
T45 : 'true' ;
T46 : 'BYTESIZE' ;
T47 : 'STRUCTURE' ;
T48 : 'NUMBER_OF_ELEMENTS' ;
T49 : 'TYPE' ;
T50 : 'VALUE' ;
T51 : 'INNER' ;

// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 364
PLUS  : '+' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 365
MINUS : '-' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 366
MUL   : '*' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 367
DIV   : '/' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 368
MOD   : '%' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 369
POW   : '^' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 370
LPAREN: '(' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 371
RPAREN: ')' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 372
SEMI  : ';' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 373
DEFINITION : '=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 374
ORDERED_DEF
	:	'ordered';
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 376
EQUAL : '==' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 377
SQUARE_PAREN_L : '[' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 378
SQUARE_PAREN_R : ']' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 379
fragment DIGIT : '0'..'9' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 380
NUMBER : (DIGIT)+ ('.' (DIGIT)+)? Exponent?;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 381
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 383
fragment ALPHA : 'a'..'z' | 'A'..'Z' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 384
NOTEQUAL : '<>' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 385
GREATER : '>' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 386
LESS : '<' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 387
GREATEREQUAL : '>=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 388
LESSEQUAL : '<=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 389
STRING_LITERAL : '\"' (ALPHA|'_')+ '\"' ;
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 390
DOT: '.';
// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 391
ID /*options {testLiterals=true;}*/: (ALPHA|'_')+;


// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 394
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 397
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\coding\gmf2\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 401
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
