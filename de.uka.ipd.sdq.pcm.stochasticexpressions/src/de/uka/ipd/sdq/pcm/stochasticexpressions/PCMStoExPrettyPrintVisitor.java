package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

public class PCMStoExPrettyPrintVisitor extends StoExPrettyPrintVisitor {

	protected String doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass == ParameterPackage.eINSTANCE.getCharacterisedVariable()) {
			return caseCharacterisedVariable((CharacterisedVariable) theEObject);
		} else if (theEClass == ParameterPackage.eINSTANCE.getVariableUsage()){
			return caseVariableUsage((VariableUsage) theEObject);
		} else if (theEClass == ParameterPackage.eINSTANCE.getVariableCharacterisation()){
			return caseVariableCharacterisation((VariableCharacterisation) theEObject);
		} else {
			return super.doSwitch(theEClass, theEObject);
		}
	}
	
	public String caseCharacterisedVariable(CharacterisedVariable object) {
		String result = (String)doSwitch(object.getId_Variable());
		result += "." + object.getCharacterisationType().getLiteral();
		return result;
	}
	
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
	
	public String caseVariableCharacterisation(VariableCharacterisation object) {
		String result = "";
		result += object.getType().getLiteral();
		//result += " = " + object.getSpecification_VariableCharacterisation().getSpecification();
		return result;
	}
}
