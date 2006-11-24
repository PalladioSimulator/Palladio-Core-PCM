header{  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
}

{@SuppressWarnings({"unused"})}
class StochasticExpressionsParser extends Parser;
options { buildAST=false; defaultErrorHandler=false; k=2; }

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
		  {AbstractNamedReference id = null; VariableCharacterisationType type;}
		  id = scoped_id DOT type = characterisation
		  { a = StochasticsFactory.eINSTANCE.createVariable();
		  	((Variable)a).setId_Variable(id);
		  	((Variable)a).setCharacterisationType(type);
		  }
		  | 
		  a = definition
	    )
;

definition returns [ProbabilityFunctionLiteral pfl] 
	{pfl = StochasticsFactory.eINSTANCE.createProbabilityFunctionLiteral();
	 ProbabilityFunction probFunction = null; } : 
		
		// Numeric PMF
			
			INT_DEF
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
		 	REAL_DEF 
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
			ENUM_DEF 
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
			REAL_PDF
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
;	 		
			

unit returns [Unit u]
	{u = null;}:
		UNIT_DEF
			{ u = ProbfunctionFactory.eINSTANCE.createUnit(); }
			EQUAL
			str:STRING_LITERAL 
			{u.setUnitName(str.getText().replace("\"",""));} ;

numeric_int_sample returns [Sample s]
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
			n:NUMBER
			{s.setProbability(Double.parseDouble(n.getText()));} 
			SEMI 
			n2:NUMBER 
			{s.setValue(Integer.parseInt(n2.getText()));} 
			RPAREN;
		
numeric_real_sample returns [Sample s]
	{s = null;} : 
		LPAREN
			{s = ProbfunctionFactory.eINSTANCE.createSample();} 
			n:NUMBER
			{s.setProbability(Double.parseDouble(n.getText()));} 
			SEMI 
			n2:NUMBER 
			{s.setValue(Double.parseDouble(n2.getText()));} 
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
		n:NUMBER 
			{s.setProbability(Double.parseDouble(n.getText()));} 
		SEMI
		str:STRING_LITERAL 
			{s.setValue(str.getText().replace("\"",""));} 
		RPAREN;

characterisation returns [VariableCharacterisationType ct]
{ct = null;} :
	type : CHARACTERISATIONS
	{if(type.getText().equals("TYPE"))
		ct = VariableCharacterisationType.DATATYPE_LITERAL;
	 else if(type.getText().equals("BYTESIZE"))
		ct = VariableCharacterisationType.BYTESIZE_LITERAL;
	 else if(type.getText().equals("NUMBER_OF_ELEMENTS"))
		ct = VariableCharacterisationType.NUMBER_OF_ELEMENTS_LITERAL;
	 else if(type.getText().equals("VALUE"))
		ct = VariableCharacterisationType.VALUE_LITERAL;
	 else if(type.getText().equals("STRUCTURE"))
		ct = VariableCharacterisationType.STRUCTURE_LITERAL;
	}
;
	
scoped_id returns [AbstractNamedReference ref]
{ref = null;
ArrayList<String> nameParts = new ArrayList<String>();} :
	id1:ID {nameParts.add(id1.getText());} 
	    (DOT (id2:ID {nameParts.add(id2.getText());} | id3:INNER {nameParts.add("INNER");}) )*
	{
	AbstractNamedReference firstNsRef=null;
	NamespaceReference lastNsRef = null;
	for (int i=0; i < nameParts.size()-1; i++)
	{
		NamespaceReference nsRef = ParameterFactory.eINSTANCE.createNamespaceReference();
		nsRef.setReferenceName(nameParts.get(i));
		if (lastNsRef != null)
			lastNsRef.setInnerReference_NamespaceReference(lastNsRef);
		if (i == 0)
		   	firstNsRef = nsRef;
		lastNsRef = nsRef;
	}
	VariableReference varRef = ParameterFactory.eINSTANCE.createVariableReference();
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
options { k = 9; }

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
INT_DEF : "IntPMF" ;
REAL_DEF: "DoublePMF" ;
ENUM_DEF: "EnumPMF" ;
REAL_PDF: "DoublePDF" ;
SQUARE_PAREN_L : '[' ;
SQUARE_PAREN_R : ']' ;
UNIT_DEF : "unit" ;
ORDERED_DEF : "ordered" ;
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
INNER : "INNER";
DOT: '.';
ID: (ALPHA|'_')+;
CHARACTERISATIONS: "BYTESIZE" | "STRUCTURE" | "NUMBER_OF_ELEMENTS" | "TYPE" | "VALUE";

protected MEAN : "mean" ;
protected PROB : "prob" ;
FUNCTION_DEF : MEAN | PROB ;


WS    : (' ' | '\t' | '\r' | '\n') {$setType(Token.SKIP);} ;