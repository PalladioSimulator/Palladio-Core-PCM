header{
	package stoex.parser;
}


class ExpressionParser extends Parser;
options { buildAST=true; }

formular : EQUAL^ expr;
definition : (INT_DEF^|REAL_DEF^) SQUARE_PAREN_L! (numericsample)+ SQUARE_PAREN_R! |
			(ENUM_DEF^) SQUARE_PAREN_L! (stringsample)+ SQUARE_PAREN_R!;
numericsample : LPAREN! NUMBER SEMI^ NUMBER RPAREN!;
stringsample : LPAREN! NUMBER SEMI^ STRING_LITERAL RPAREN!;
expr     : compareExpr ;
compareExpr  : sumExpr ((GREATER^|LESS^|EQUAL^|NOTEQUAL^|GREATEREQUAL^|LESSEQUAL^) sumExpr|) ;
sumExpr  : prodExpr ((PLUS^|MINUS^) prodExpr)* ;
prodExpr : powExpr ((MUL^|DIV^|MOD^) powExpr)* ;
powExpr  : atom (POW^ atom)? ;
parameter_id : STRING_LITERAL | INNER^ LESS! STRING_LITERAL GREATER!;
atom     : definition | PARAM^ LESS! parameter_id SEMI! STRING_LITERAL GREATER! | NUMBER | LPAREN^ expr RPAREN! | FUNCTION_DEF^ LPAREN! expr RPAREN!;
 
class ExpressionLexer extends Lexer;
options { k = 2; }

PLUS  : '+' ;
MINUS : '-' ;
MUL   : '*' ;
DIV   : '/' ;
MOD   : '%' ;
POW   : '^' ;
LPAREN: '(' ;
RPAREN: ')' ;
SEMI  : ';' ;
EQUAL : '=' ;
INT_DEF : "IntRandomVar" ;
REAL_DEF: "RealRandomVar" ;
ENUM_DEF: "EnumRandomVar" ;
SQUARE_PAREN_L : '[' ;
SQUARE_PAREN_R : ']' ;
protected DIGIT : '0'..'9' ;
NUMBER : (DIGIT)+ (|'.' (DIGIT)+);
protected ALPHA : 'a'..'z' | 'A'..'Z' ;
PARAM : "prim_param" | "coll_param" ;
NOTEQUAL : "<>" ;
GREATER : ">" ;
LESS : "<" ;
GREATEREQUAL : ">=" ;
LESSEQUAL : "<=" ;
STRING_LITERAL : (ALPHA|'_')+ ;
INNER : "inner";

protected MEAN : "mean" ;
protected PROB : "prob" ;
FUNCTION_DEF : MEAN | PROB ;


WS    : (' ' | '\t' | '\r' | '\n') {$setType(Token.SKIP);} ;