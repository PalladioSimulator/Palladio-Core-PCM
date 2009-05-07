package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

public class PCMStoExPrettyPrintVisitor extends StoExPrettyPrintVisitor {

	protected String doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass == ParameterPackage.eINSTANCE.getCharacterisedVariable()) {
			return caseCharacterisedVariable((CharacterisedVariable)theEObject);
		}
		else {
			return super.doSwitch(theEClass,theEObject);
		}
	}
	
	public String caseCharacterisedVariable(CharacterisedVariable object) {
		String result = (String)doSwitch(object.getId_Variable());
		result += "." + object.getCharacterisationType().getLiteral();
		return result;
	}
}
