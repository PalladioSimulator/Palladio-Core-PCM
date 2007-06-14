lexer grammar PCMStoExParser;

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

// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 382
PLUS  : '+' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 383
MINUS : '-' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 384
MUL   : '*' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 385
DIV   : '/' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 386
MOD   : '%' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 387
POW   : '^' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 388
LPAREN: '(' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 389
RPAREN: ')' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 390
SEMI  : ';' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 391
DEFINITION : '=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 392
ORDERED_DEF
	:	'ordered';
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 394
EQUAL : '==' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 395
SQUARE_PAREN_L : '[' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 396
SQUARE_PAREN_R : ']' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 397
fragment DIGIT : '0'..'9' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 398
NUMBER : (DIGIT)+ ('.' (DIGIT)+)? Exponent?;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 399
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 401
fragment ALPHA : 'a'..'z' | 'A'..'Z' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 402
NOTEQUAL : '<>' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 403
GREATER : '>' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 404
LESS : '<' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 405
GREATEREQUAL : '>=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 406
LESSEQUAL : '<=' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 407
STRING_LITERAL : '\"' (ALPHA|'_')+ '\"' ;
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 408
DOT: '.';
// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 409
ID /*options {testLiterals=true;}*/: (ALPHA|'_')+;


// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 412
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 415
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "C:\coding\gmf2\Palladio.EMFComponentModel\trunk\de.uka.ipd.sdq.pcm.stochasticexpressions\src\de\uka\ipd\sdq\pcm\stochasticexpressions\parser\PCMStoExParser.g" 419
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
