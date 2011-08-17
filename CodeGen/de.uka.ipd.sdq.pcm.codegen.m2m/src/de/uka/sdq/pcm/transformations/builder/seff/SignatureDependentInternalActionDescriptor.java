package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;

public abstract class SignatureDependentInternalActionDescriptor extends
		AbstractInternalActionDescriptor implements ISignatureDependentAction {

	protected Signature currentSignature;

	// Hauck 2008.11.19: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	public SignatureDependentInternalActionDescriptor(
			ResourceRequiredRole role, ResourceService service) {
		super(role, service);
	}

	/* (non-Javadoc)
	 * @see de.uka.sdq.pcm.transformations.builder.seff.ISignatureDependentAction#setCurrentSignature(de.uka.ipd.sdq.pcm.repository.Signature)
	 */
	public void setCurrentSignature(Signature sig){
		this.currentSignature = sig;
	}
	
	@Override
	public String getResourceDemand() {
		return getDemand(currentSignature);
	}

	protected abstract String getDemand(Signature signature);
}
