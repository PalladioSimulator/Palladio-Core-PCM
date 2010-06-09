package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

public class VariableUsageOutputParameterContentProvider extends
		VariableUsageContentProvider {

	@Override
	public Object[] getChildren(Object parent) {
		/**
		 * Signatur
		 */
		if (parent instanceof OperationSignature) {
			OperationSignature signature = (OperationSignature) parent;
			ArrayList<Variable> outputParameter = new ArrayList<Variable>();
			for (Variable p : signature.getParameters__OperationSignature()) {
				/* FIXME: re-enable
				if (p.getModifier__Parameter() == ParameterModifier.OUT || 
					p.getModifier__Parameter() == ParameterModifier.INOUT){
					outputParameter.add(p);
				}*/
			}
			if (signature.getReturntype__OperationSignature() != null){
				Variable ret = ParameterFactory.eINSTANCE.createVariable();
				ret.setDataType__Variable(signature.getReturntype__OperationSignature().getCompositeDataType__Variable());
				ret.setEntityName("RETURN");
				outputParameter.add(ret);
			}
			return outputParameter.toArray();
		} else 
			return super.getChildren(parent);
	}

}
