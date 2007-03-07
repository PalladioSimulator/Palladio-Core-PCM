/**
 * 
 */
package de.uka.ipd.sdq.pcm.stochasticexpressions;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

/**
 * @author Steffen Becker
 *
 */
public class ParameterPrettyPrint extends ParameterSwitch {

	/**
	 * 
	 */
	public ParameterPrettyPrint() {
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableUsage(de.uka.ipd.sdq.pcm.parameter.VariableUsage)
	 */
	@Override
	public Object caseVariableUsage(VariableUsage object) {
		String result = "";
		if (object.getNamedReference_VariableUsage() != null)
			result += (String)doSwitch(object.getNamedReference_VariableUsage());
		else
			result += "<?>";
		if (object.getVariableCharacterisation_VariableUsage().size() > 0)
			result += "." + (String)doSwitch((VariableCharacterisation)object.getVariableCharacterisation_VariableUsage().get(0));
		else
			result += ".<?> = <?>";
		return result;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableCharacterisation(de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation)
	 */
	@Override
	public Object caseVariableCharacterisation(VariableCharacterisation object) {
		String result = "";
		result += object.getType().getLiteral();
		result += " = " + object.getSpecification();
		return result;
	}
	

	
}
