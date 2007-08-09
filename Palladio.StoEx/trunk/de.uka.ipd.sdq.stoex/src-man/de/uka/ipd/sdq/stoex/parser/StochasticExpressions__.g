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

// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 362
PLUS  : '+' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 363
MINUS : '-' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 364
MUL   : '*' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 365
DIV   : '/' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 366
MOD   : '%' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 367
POW   : '^' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 368
LPAREN: '(' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 369
RPAREN: ')' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 370
SEMI  : ';' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 371
DEFINITION : '=' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 372
ORDERED_DEF
	:	'ordered';
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 374
EQUAL : '==' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 375
SQUARE_PAREN_L : '[' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 376
SQUARE_PAREN_R : ']' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 377
fragment DIGIT : '0'..'9' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 378
NUMBER : (DIGIT)+ ('.' (DIGIT)+)? Exponent?;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 379
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 381
fragment ALPHA : 'a'..'z' | 'A'..'Z' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 382
NOTEQUAL : '<>' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 383
GREATER : '>' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 384
LESS : '<' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 385
GREATEREQUAL : '>=' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 386
LESSEQUAL : '<=' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 387
STRING_LITERAL : '\"' (ALPHA|'_')+ '\"' ;
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 388
DOT: '.';
// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 389
ID /*options {testLiterals=true;}*/: (ALPHA|'_')+;


// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 392
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 395
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\Dokumente und Einstellungen\jens.happe\Desktop\dev\code\Palladio.StoEx\trunk\de.uka.ipd.sdq.stoex\src-man\de\uka\ipd\sdq\stoex\parser\StochasticExpressions.g" 399
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
