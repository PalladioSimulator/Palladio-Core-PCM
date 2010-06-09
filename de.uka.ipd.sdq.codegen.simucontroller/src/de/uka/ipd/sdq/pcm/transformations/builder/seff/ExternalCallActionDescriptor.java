package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;


import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

public class ExternalCallActionDescriptor extends AbstractActionDescriptor {

	private OperationSignature signature;
	private OperationRequiredRole requiredRole;
	private Collection<VariableSetter> parameter;
	private Collection<VariableSetter> outParameter;


	public ExternalCallActionDescriptor(OperationSignature sig, OperationRequiredRole role, Collection<VariableSetter> inParameter) {
		this(sig,role,inParameter,null);
		this.outParameter = new ArrayList<VariableSetter>();
	}
	
	public ExternalCallActionDescriptor(OperationSignature sig, OperationRequiredRole role, Collection<VariableSetter> inParameter, Collection<VariableSetter> outParameter) {
		this.signature = sig;
		this.requiredRole = role;
		this.parameter = inParameter;
		this.outParameter = outParameter;
	}

	@Override
	public AbstractAction createAction() {
		ExternalCallAction call = SeffFactory.eINSTANCE.createExternalCallAction();
		call.setCalledService_ExternalService(this.signature);
		call.setRole_ExternalService(this.requiredRole);
		call.setEntityName("ExternalCall");
		call.getVariableSetterInputs__CallAction().addAll(getInputParameter());
		call.getVariableSetterReturns__CallReturnAction().addAll(getOutputParameter());
		
		return call;
	}
	
	protected Collection<VariableSetter> getInputParameter(){
		return parameter;
	}

	protected Collection<VariableSetter> getOutputParameter(){
		return outParameter;
	}
}
