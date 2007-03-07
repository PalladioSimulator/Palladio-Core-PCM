header{  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
	import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;
} 
     
{@SuppressWarnings({"unused"})}
class PCMStoExParser extends StochasticExpressionsParser;
options { buildAST=false; defaultErrorHandler=false; k=2; }
  
atom returns [Atom a]
	{a = null;} :
		(
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
		  {AbstractNamedReference id = null; VariableCharacterisationType type;}
		  id = scoped_id DOT type = characterisation
		  { a = ParameterFactory.eINSTANCE.createCharacterisedVariable();
		  	((CharacterisedVariable)a).setId_Variable(id);
		  	((CharacterisedVariable)a).setCharacterisationType(type);
		  }
		  | 
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
  
characterisation returns [VariableCharacterisationType ct]
{ct = null; String type="";} :
	type = characterisation_keywords
	{if(type.equals("TYPE"))
		ct = VariableCharacterisationType.DATATYPE_LITERAL;
	 else if(type.equals("BYTESIZE"))
		ct = VariableCharacterisationType.BYTESIZE_LITERAL;
	 else if(type.equals("NUMBER_OF_ELEMENTS"))
		ct = VariableCharacterisationType.NUMBER_OF_ELEMENTS_LITERAL;
	 else if(type.equals("VALUE"))
		ct = VariableCharacterisationType.VALUE_LITERAL;
	 else if(type.equals("STRUCTURE"))
		ct = VariableCharacterisationType.STRUCTURE_LITERAL;
	}
;