package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.Signature;

public class VariableUsageInputParameterContentProvider extends
		VariableUsageContentProvider {

	@Override
	public Object[] getChildren(Object parent) {
		/**
		 * Signatur
		 */
		if (parent instanceof Signature) {
			Signature signature = (Signature) parent;
			ArrayList<Parameter> inputParameter = new ArrayList<Parameter>();
			for (Parameter p : signature.getParameters__Signature()) {
				if (p.getModifier__Parameter() == ParameterModifier.NONE || 
					p.getModifier__Parameter() == ParameterModifier.IN || 
					p.getModifier__Parameter() == ParameterModifier.INOUT){
					inputParameter.add(p);
				}
			}
			return inputParameter.toArray();
		} else 
			return super.getChildren(parent);
	}

}
