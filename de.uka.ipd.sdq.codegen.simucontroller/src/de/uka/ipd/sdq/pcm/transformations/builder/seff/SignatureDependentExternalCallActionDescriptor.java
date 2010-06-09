package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Signature;

public abstract class SignatureDependentExternalCallActionDescriptor extends
		ExternalCallActionDescriptor implements ISignatureDependentAction {

	/** The signature that is current in the surrounding SEFF (not the called signature!)*/
	private OperationSignature currentSignature;


	public SignatureDependentExternalCallActionDescriptor(OperationSignature sig,
			OperationRequiredRole role) {
		super(sig, role, null, null);
	}

	@Override
	protected Collection<VariableSetter> getInputParameter() {
		return getSignatureDependentInputParameter(this.currentSignature);
	}

	@Override
	protected Collection<VariableSetter> getOutputParameter() {
		return getSignatureDependentOutputParameter(currentSignature);
	}
	
	protected abstract Collection<VariableSetter> getSignatureDependentInputParameter(
			OperationSignature currentSignature);
	protected abstract Collection<VariableSetter> getSignatureDependentOutputParameter(
			OperationSignature currentSignature);

	public void setCurrentSignature(OperationSignature sig) {
		this.currentSignature = sig;
	}
}
