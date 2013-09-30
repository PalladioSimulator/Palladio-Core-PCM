package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class PCMStoExSwitch extends StoexSwitch<Object> {

	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass == ParameterPackage.eINSTANCE.getCharacterisedVariable()) {
			return caseCharacterisedVariable((CharacterisedVariable)theEObject);
		}
		else {
			return super.doSwitch(theEClass,theEObject);
		}
	}

	public Object caseCharacterisedVariable(CharacterisedVariable object) {
		return null;
	}
}