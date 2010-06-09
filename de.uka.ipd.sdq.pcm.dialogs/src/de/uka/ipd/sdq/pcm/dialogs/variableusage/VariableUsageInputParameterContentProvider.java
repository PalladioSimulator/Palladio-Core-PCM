package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

public class VariableUsageInputParameterContentProvider extends
		VariableUsageContentProvider {

	@Override
	public Object[] getChildren(Object parent) {
		/**
		 * Signatur
		 */
		if (parent instanceof OperationSignature) {
			OperationSignature signature = (OperationSignature) parent;
			ArrayList<Variable> inputParameter = new ArrayList<Variable>();
			for (Variable p : signature.getParameters__OperationSignature()) {
				/* FIXME: re-enable modifiers
				if (p.getModifier__Parameter() == ParameterModifier.NONE || 
					p.getModifier__Parameter() == ParameterModifier.IN || 
					p.getModifier__Parameter() == ParameterModifier.INOUT){
					inputParameter.add(p);
				}*/
			}
			return inputParameter.toArray();
		} else 
			return super.getChildren(parent);
	}

}
