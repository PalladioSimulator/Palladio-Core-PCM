package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

public abstract class SignatureDependentInternalActionDescriptor extends
		AbstractInternalActionDescriptor {

	protected Signature currentSignature;

	public SignatureDependentInternalActionDescriptor(
			ProcessingResourceType resourceType) {
		super(resourceType);
	}

	public void setCurrentSignature(Signature sig){
		this.currentSignature = sig;
	}
	
	@Override
	public String getResourceDemand() {
		return getDemand(currentSignature);
	}

	protected abstract String getDemand(Signature signature);
}
