/**
 * 
 */
package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.parameter.util.ParameterSwitch;

/**
 * Pretty Print Paramters in a StoEx
 * @author Steffen Becker
 *
 */
public class ParameterPrettyPrint extends ParameterSwitch<String> {

	/**
	 * 
	 */
	public ParameterPrettyPrint() {
	}


	/* (non-Javadoc)
	 * @see org.palladiosimulator.pcm.parameter.util.ParameterSwitch#caseVariableUsage(org.palladiosimulator.pcm.parameter.VariableUsage)
	 */
	@Override
	public String caseVariableUsage(VariableUsage object) {
		String result = "";
		if (object.getNamedReference__VariableUsage() != null)
			result += doSwitch(object.getNamedReference__VariableUsage());
		else
			result += "<not set yet>";
		if (object.getVariableCharacterisation_VariableUsage().size() > 0)
			result += "." + doSwitch((VariableCharacterisation)object.getVariableCharacterisation_VariableUsage().get(0));
		else
			result += ".<missing characterisation> = <missing expression>";
		return result;
	}

	/* (non-Javadoc)
	 * @see org.palladiosimulator.pcm.parameter.util.ParameterSwitch#caseVariableCharacterisation(org.palladiosimulator.pcm.parameter.VariableCharacterisation)
	 */
	@Override
	public String caseVariableCharacterisation(VariableCharacterisation object) {
		String result = "";
		result += object.getType().getLiteral();
		result += " = " + object.getSpecification_VariableCharacterisation().getSpecification();
		return result;
	}
}
