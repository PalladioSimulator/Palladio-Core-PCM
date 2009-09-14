package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;

public abstract class SignatureDependentExternalCallActionDescriptor extends
		ExternalCallActionDescriptor implements ISignatureDependentAction {

	private Signature currentSignature;

	public SignatureDependentExternalCallActionDescriptor(Signature sig,
			RequiredRole role) {
		super(sig, role, null, null);
	}

	@Override
	protected Collection<VariableUsage> getInputParameter() {
		return getSignatureDependentInputParameter(this.currentSignature);
	}

	@Override
	protected Collection<VariableUsage> getOutputParameter() {
		return getSignatureDependentOutputParameter(currentSignature);
	}
	
	protected abstract Collection<VariableUsage> getSignatureDependentInputParameter(
			Signature currentSignature);
	protected abstract Collection<VariableUsage> getSignatureDependentOutputParameter(
			Signature currentSignature);

	public void setCurrentSignature(Signature sig) {
		this.currentSignature = sig;
	}
}
