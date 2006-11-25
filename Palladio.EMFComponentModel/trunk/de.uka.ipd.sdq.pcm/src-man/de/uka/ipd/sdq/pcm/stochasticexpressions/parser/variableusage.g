header{  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
	import de.uka.ipd.sdq.pcm.stochasticexpressions.StoExPrettyPrintVisitor;
}
  
{@SuppressWarnings({"unused"})}
class VariableUsageParser extends StochasticExpressionsParser;

variable_usage returns [VariableUsage vu]
	{vu = null; AbstractNamedReference id; VariableCharacterisation vc;} :
		id = scoped_id DOT vc = variable_characterisation 
		{vu = ParameterFactory.eINSTANCE.createVariableUsage();
		vu.setNamedReference_VariableUsage(id);
		vu.getVariableCharacterisation_VariableUsage().add(vc);
		}
;
 
variable_characterisation returns [VariableCharacterisation vc]
	{vc = ParameterFactory.eINSTANCE.createVariableCharacterisation();
	Expression ex; VariableCharacterisationType type;} :
		type = characterisation ex = expression
		{	vc.setType(type);
			String result = "= " + new StoExPrettyPrintVisitor().prettyPrint(ex);
			vc.setSpecification(result);
		}
;