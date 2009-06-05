header{  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;
}
   
{@SuppressWarnings({"unused"})}
class StochasticExpressionsParser extends Parser;
options { buildAST=false; defaultErrorHandler=false; k=2; }

expression returns [Expression exp] 
	{exp = null;} : 
		{Comparison c;} 
			c=compareExpr
		{exp = c;}; 

compareExpr returns [Comparison comp]
	{comp = null;} :
		{Term t1 = null, t2 = null;}
			t1 = sumExpr {comp = t1;} (
				{CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();}
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
			{TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();}			
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
			{ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();}
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
		a1 = atom {pw = a1;} 
			(POW a2 = atom
				{PowerExpression pwExp = StoexFactory.eINSTANCE.createPowerExpression();
					pwExp.setBase(a1); pwExp.setExponent(a2); pw = pwExp;
				}
			)? 		
;

atom returns [Atom a]
	{a = null;} :
		(
		  // numeric literals (int, double)
		  number:NUMBER 
			{
				String value = number.getText();
				if (value.indexOf('.') < 0)
				{
					IntLiteral il = StoexFactory.eINSTANCE.createIntLiteral();
					il.setValue(Integer.parseInt(value));
					a = il;
				}
				else
				{
					DoubleLiteral dl = StoexFactory.eINSTANCE.createDoubleLiteral();
					dl.setValue(Double.parseDouble(value));
					a = dl;
				}
			}
		  |
		  // variables
		  {AbstractNamedReference id = null;} 
		  id = scoped_id 
		  { a = StoexFactory.eINSTANCE.createVariable();
		  	((Variable)a).setId_Variable(id);
		  }
		  | 
		  // probability function literals
		  a = definition
		  |
		  // string literal
		  sl:STRING_LITERAL
		  {
		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
		  	stringLiteral.setValue(sl.getText().replace("\"",""));
		  	a = stringLiteral;
		  }
		  |
		  // boolean literal
		  {String bl = null;}
		  bl = boolean_keywords
		  {
		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
	   		boolLiteral.setValue(bl.equals("true"));
		  	a = boolLiteral;
		  } 
		  |
		  // parenthesis expression
		  {Expression inner = null;}
		  LPAREN
		  inner = compareExpr
		  RPAREN
		  {
			Parenthesis paren = StoexFactory.eINSTANCE.createParenthesis();
			paren.setInnerExpression(inner);
			a = paren;
		  }
	    ) 
;
 
definition returns [ProbabilityFunctionLiteral pfl] 
	{pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
	 ProbabilityFunction probFunction = null; } : 
		
		// Numeric PMF
			
			"IntPMF"
				{probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);}
			LPAREN
			  ({Unit uunit = null;}
			  uunit = unit 
			  {probFunction.setUnit(uunit);})
			RPAREN
			SQUARE_PAREN_L 
				( {Sample isample=null;}
				  isample = numeric_int_sample
				  {((ProbabilityMassFunction)probFunction).getSamples().add(isample);})+ 
	 		SQUARE_PAREN_R 
	 		|
		 	"DoublePMF" 
				{probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);}
			LPAREN
			  ({Unit uunit = null;}
			  uunit = unit 
			  {probFunction.setUnit(uunit);})
			RPAREN
		 	SQUARE_PAREN_L 
				( {Sample rsample=null;} 
				rsample = numeric_real_sample
			   	{((ProbabilityMassFunction)probFunction).getSamples().add(rsample);})+ 
			SQUARE_PAREN_R
			| 
		// Enum PMF
			"EnumPMF" 
				{probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
				   }
			LPAREN
			  ({Unit uunit = null;}
			  uunit = unit 
			  {probFunction.setUnit(uunit);})
			  (SEMI
			  ORDERED_DEF
			  {((ProbabilityMassFunction)probFunction).setOrderedDomain(true);}
			  )?
			RPAREN
			SQUARE_PAREN_L 
				( {Sample ssample=null;} 
				ssample = stringsample
			   	{((ProbabilityMassFunction)probFunction).getSamples().add(ssample);})+ 
			SQUARE_PAREN_R
			|
			"DoublePDF"
				{probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);}
			LPAREN
			  ({Unit uunit = null;}
			  uunit = unit 
			  {probFunction.setUnit(uunit);})
			RPAREN
			SQUARE_PAREN_L 
				( {ContinuousSample pdf_sample=null;}
				  pdf_sample = real_pdf_sample
				  {((BoxedPDF)probFunction).getSamples().add(pdf_sample);})+ 
	 		SQUARE_PAREN_R 
			|
			"BoolPMF" 
				{probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
				   }
			LPAREN
			  ({Unit uunit = null;}
			  uunit = bool_unit 
			  {probFunction.setUnit(uunit);})
			  (SEMI
			  ORDERED_DEF
			  {((ProbabilityMassFunction)probFunction).setOrderedDomain(true);}
			  )?
			RPAREN
			SQUARE_PAREN_L 
				( {Sample ssample=null;} 
				ssample = boolsample
			   	{((ProbabilityMassFunction)probFunction).getSamples().add(ssample);})+ 
			SQUARE_PAREN_R
;	 		
			

unit returns [Unit u]
	{u = null;}:
		"unit"
			{ u = ProbfunctionFactory.eINSTANCE.createUnit(); }
			DEFINITION
			str:STRING_LITERAL 
			{u.setUnitName(str.getText().replace("\"",""));} ;

bool_unit returns [Unit u]
	{u = null;}:
		"unit"
			{ u = ProbfunctionFactory.eINSTANCE.createUnit(); }
			EQUAL
			"\"bool\""
			{u.setUnitName("bool");} ;


numeric_int_sample returns [Sample s]
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
			n:NUMBER
			{s.setValue(Integer.parseInt(n.getText()));} 
			SEMI 
			n2:NUMBER 
			{s.setProbability(Double.parseDouble(n2.getText()));} 
			RPAREN;
		
numeric_real_sample returns [Sample s]
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
			n:NUMBER
			{s.setValue(Double.parseDouble(n.getText()));} 
			SEMI 
			n2:NUMBER 
			{s.setProbability(Double.parseDouble(n2.getText()));} 
			RPAREN;
			
real_pdf_sample returns [ContinuousSample s]
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createContinuousSample();} 
			n:NUMBER
			{s.setValue(Double.parseDouble(n.getText()));} 
			SEMI 
			n2:NUMBER 
			{s.setProbability(Double.parseDouble(n2.getText()));} 
			RPAREN;
			
stringsample returns [Sample s] 
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
		str:STRING_LITERAL 
			{s.setValue(str.getText().replace("\"",""));} 
		SEMI
		n:NUMBER 
			{s.setProbability(Double.parseDouble(n.getText()));} 
		RPAREN;

boolsample returns [Sample s] 
	{s = null;String str = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
		str = boolean_keywords
		{s.setValue(str);}
		SEMI
		n:NUMBER 
			{s.setProbability(Double.parseDouble(n.getText()));} 
		RPAREN;

boolean_keywords returns [String keyword]
{keyword = null;}:
		(
		"false"
			{keyword = "false";} 
		|
		"true"
			{keyword = "true";} 
		);

characterisation_keywords returns [String keyword] 
{keyword = null;}:
 ("BYTESIZE" {keyword="BYTESIZE";}
 | "STRUCTURE" {keyword="STRUCTURE";}
 | "NUMBER_OF_ELEMENTS" {keyword="NUMBER_OF_ELEMENTS";}
 | "TYPE" {keyword="TYPE";}
 | "VALUE" {keyword="VALUE";}
);
 	
scoped_id returns [AbstractNamedReference ref]
{ref = null;
ArrayList<String> nameParts = new ArrayList<String>();} :
	id1:ID {nameParts.add(id1.getText());} 
	    (DOT (id2:ID {nameParts.add(id2.getText());} | "INNER" {nameParts.add("INNER");}) )*
	{
	AbstractNamedReference firstNsRef=null;
	NamespaceReference lastNsRef = null;
	for (int i=0; i < nameParts.size()-1; i++)
	{
		NamespaceReference nsRef = StoexFactory.eINSTANCE.createNamespaceReference();
		nsRef.setReferenceName(nameParts.get(i));
		if (lastNsRef != null)
			lastNsRef.setInnerReference_NamespaceReference(nsRef);
		if (i == 0)
		   	firstNsRef = nsRef;
		lastNsRef = nsRef;
	}
	VariableReference varRef = StoexFactory.eINSTANCE.createVariableReference();
	varRef.setReferenceName(nameParts.get(nameParts.size()-1));
		if (lastNsRef != null) {
			lastNsRef.setInnerReference_NamespaceReference(varRef);
			ref = firstNsRef;
		}
		else
			ref = varRef;
	}
;
	
{@SuppressWarnings({"unused"})}
class StochasticExpressionsLexer extends Lexer;
options { 
	k = 2;  
}

PLUS  : '+' ;
MINUS : '-' ;
MUL   : '*' ;
DIV   : '/' ;
MOD   : '%' ;
POW   : '^' ;
LPAREN: '(' ;
RPAREN: ')' ;
SEMI  : ';' ;
DEFINITION : '=' ;
EQUAL : "==" ;
SQUARE_PAREN_L : '[' ;
SQUARE_PAREN_R : ']' ;
protected DIGIT : '0'..'9' ;
NUMBER : (DIGIT)+ ('.' (DIGIT)+)?;
protected ALPHA : 'a'..'z' | 'A'..'Z' ;
NOTEQUAL : "<>" ;
GREATER : ">" ;
LESS : "<" ;
GREATEREQUAL : ">=" ;
LESSEQUAL : "<=" ;
STRING_LITERAL : "\"" (ALPHA|'_')+ "\"" ;
DOT: '.';
ID options {testLiterals=true;}: (ALPHA|'_')+;


WS    : (' ' | '\t' | '\r' | '\n') {$setType(Token.SKIP);} ;