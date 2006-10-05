header{  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
}

{@SuppressWarnings({"unused"})}
class StochasticExpressionsParser extends Parser;
options { buildAST=false; defaultErrorHandler=false; }

expression returns [Expression exp] 
	{exp = null;} : 
		{Comparison c;} 
			EQUAL c=compareExpr
		{exp = c;};

compareExpr returns [Comparison comp]
	{comp = null;} :
		{Term t1 = null, t2 = null;}
			t1 = sumExpr {comp = t1;} (
				{CompareExpression compExp = StochasticsFactory.eINSTANCE.createCompareExpression();}
				(GREATER {compExp.setOperation(CompareOperations.GREATER_LITERAL);}|
				 LESS {compExp.setOperation(CompareOperations.LESS_LITERAL);}|
				 EQUAL {compExp.setOperation(CompareOperations.EQUALS_LITERAL);}|
				 NOTEQUAL {compExp.setOperation(CompareOperations.NOTEQUAL_LITERAL);}|
				 GREATEREQUAL {compExp.setOperation(CompareOperations.GREATEREQUAL_LITERAL);}|
				 LESSEQUAL {compExp.setOperation(CompareOperations.LESSEQUAL_LITERAL);}) 
				 t2 = sumExpr 
				 	{compExp.setLeft(t1); compExp.setRight(t2); comp=compExp;})? ;

sumExpr returns [Term t]
	{t = null;} : 
		{Product p1 = null, p2 = null;}
		p1 = prodExpr {t = p1;} (
			{TermExpression termExp = StochasticsFactory.eINSTANCE.createTermExpression();}			
			(PLUS {termExp.setOperation(TermOperations.ADD_LITERAL);}|
			MINUS  {termExp.setOperation(TermOperations.SUB_LITERAL);}) 
			p2 = prodExpr
				{termExp.setLeft(t); termExp.setRight(p2); t = termExp;}
			)* 
;
		
prodExpr returns [Product p] 
	{p = null;} : 
		{Power pw1 = null, pw2 = null;}
		pw1 = powExpr {p = pw1;} 
			(
			{ProductExpression prodExp = StochasticsFactory.eINSTANCE.createProductExpression();}
			 (MUL {prodExp.setOperation(ProductOperations.MULT_LITERAL);} |
			  DIV {prodExp.setOperation(ProductOperations.DIV_LITERAL);} |
			  MOD {prodExp.setOperation(ProductOperations.MOD_LITERAL);} ) 
			  pw2 = powExpr 
			  	{prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;}
			  )*
;

powExpr returns [Power pw]  
	{pw = null;} : 
		{Atom a1 = null, a2 = null;}
		a1 = atom {pw = a1;} (POW a2 = atom |) ;

atom returns [Atom a]
	{a = null;} :
		(
		  number:NUMBER 
			{
				String value = number.getText();
				if (value.indexOf('.') < 0)
				{
					IntLiteral il = StochasticsFactory.eINSTANCE.createIntLiteral();
					il.setValue(Integer.parseInt(value));
					a = il;
				}
				else
				{
					DoubleLiteral dl = StochasticsFactory.eINSTANCE.createDoubleLiteral();
					dl.setValue(Double.parseDouble(value));
					a = dl;
				}
			}
		  |
		  id : ID
		  { a = StochasticsFactory.eINSTANCE.createVariable();
		  	((Variable)a).setId(id.getText());
		  }
	    )
;

definition : (INT_DEF^|REAL_DEF^) SQUARE_PAREN_L! (numericsample)+ SQUARE_PAREN_R! |
			(ENUM_DEF^) SQUARE_PAREN_L! (stringsample)+ SQUARE_PAREN_R!;
numericsample : LPAREN! NUMBER SEMI^ NUMBER RPAREN!;
stringsample : LPAREN! NUMBER SEMI^ STRING_LITERAL RPAREN!;
parameter_id : STRING_LITERAL | INNER^ LESS! STRING_LITERAL GREATER!;
 
{@SuppressWarnings({"unused"})}
class StochasticExpressionsLexer extends Lexer;
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
NUMBER : (DIGIT)+ ('.' (DIGIT)+)?;
protected ALPHA : 'a'..'z' | 'A'..'Z' ;
// PARAM : "prim_param" | "coll_param" ;
NOTEQUAL : "<>" ;
GREATER : ">" ;
LESS : "<" ;
GREATEREQUAL : ">=" ;
LESSEQUAL : "<=" ;
STRING_LITERAL : "\"" (ALPHA|'_')+ "\"" ;
INNER : "inner";
ID: (ALPHA|'_')+ ('.' (ALPHA|'_')+ )*;

protected MEAN : "mean" ;
protected PROB : "prob" ;
FUNCTION_DEF : MEAN | PROB ;


WS    : (' ' | '\t' | '\r' | '\n') {$setType(Token.SKIP);} ;