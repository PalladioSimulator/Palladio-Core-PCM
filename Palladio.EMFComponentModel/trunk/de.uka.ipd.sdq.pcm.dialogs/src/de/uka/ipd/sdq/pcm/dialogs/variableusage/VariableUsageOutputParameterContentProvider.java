package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;

public class VariableUsageOutputParameterContentProvider extends
		VariableUsageContentProvider {

	@Override
	public Object[] getChildren(Object parent) {
		/**
		 * Signatur
		 */
		if (parent instanceof Signature) {
			Signature signature = (Signature) parent;
			ArrayList<Parameter> outputParameter = new ArrayList<Parameter>();
			for (Parameter p : signature.getParameters__Signature()) {
				if (p.getModifier__Parameter() == ParameterModifier.OUT || 
					p.getModifier__Parameter() == ParameterModifier.INOUT){
					outputParameter.add(p);
				}
			}
			if (signature.getReturntype__Signature() != null){
				Parameter ret = RepositoryFactory.eINSTANCE.createParameter();
				ret.setDatatype__Parameter(signature.getReturntype__Signature());
				ret.setParameterName("RETURN");
				outputParameter.add(ret);
			}
			return outputParameter.toArray();
		} else 
			return super.getChildren(parent);
	}

}
