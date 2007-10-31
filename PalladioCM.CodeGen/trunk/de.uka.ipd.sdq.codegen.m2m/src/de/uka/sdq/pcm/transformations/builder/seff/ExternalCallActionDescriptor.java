package de.uka.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

public class ExternalCallActionDescriptor extends AbstractActionDescriptor {

	private Signature signature;
	private RequiredRole requiredRole;
	private Collection<VariableUsage> parameter;
	private Collection<VariableUsage> outParameter;

	public ExternalCallActionDescriptor(Signature sig, RequiredRole role, Collection<VariableUsage> inParameter) {
		this(sig,role,inParameter,null);
		this.outParameter = new ArrayList<VariableUsage>();
	}
	
	public ExternalCallActionDescriptor(Signature sig, RequiredRole role, Collection<VariableUsage> inParameter, Collection<VariableUsage> outParameter) {
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
		call.getInputParameterUsages_ExternalCallAction().addAll(getInputParameter());
		call.getOutputVariableUsages_ExternalCallAction().addAll(getOutputParameter());
		
		return call;
	}
	
	protected Collection<VariableUsage> getInputParameter(){
		return parameter;
	}

	protected Collection<VariableUsage> getOutputParameter(){
		return outParameter;
	}
}
