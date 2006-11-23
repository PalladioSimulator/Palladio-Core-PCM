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
	{vu = null; AbstractNamedReference id; Expression ex; VariableCharacterisationType type;} :
		id = scoped_id type = characterisation ex = expression
		{vu = ParameterFactory.eINSTANCE.createVariableUsage();
		vu.setNamedReference_VariableUsage(id);
		VariableCharacterisation vc = ParameterFactory.eINSTANCE.createVariableCharacterisation();
		vc.setType(type);
		String result = "= " + new StoExPrettyPrintVisitor().prettyPrint(ex);
		vc.setSpecification(result);
		vu.getVariableCharacterisation_VariableUsage().add(vc);
		}
;