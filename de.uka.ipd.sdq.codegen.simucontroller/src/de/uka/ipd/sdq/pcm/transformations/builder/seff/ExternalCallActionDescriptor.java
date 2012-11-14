package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

public class ExternalCallActionDescriptor extends AbstractActionDescriptor {

	private OperationSignature signature;
	private OperationRequiredRole requiredRole;
	private Collection<VariableUsage> parameter;
	private Collection<VariableUsage> outParameter;

	public ExternalCallActionDescriptor(OperationSignature sig, OperationRequiredRole role, Collection<VariableUsage> inParameter) {
		this(sig,role,inParameter,null);
		this.outParameter = new ArrayList<VariableUsage>();
	}
	
	public ExternalCallActionDescriptor(OperationSignature sig, OperationRequiredRole role, Collection<VariableUsage> inParameter, Collection<VariableUsage> outParameter) {
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
		call.getInputVariableUsages__CallAction().addAll(getInputParameter());
		call.getReturnVariableUsage__CallReturnAction().addAll(getOutputParameter());
		
		return call;
	}
	
	protected Collection<VariableUsage> getInputParameter(){
		return parameter;
	}

	protected Collection<VariableUsage> getOutputParameter(){
		return outParameter;
	}
}
