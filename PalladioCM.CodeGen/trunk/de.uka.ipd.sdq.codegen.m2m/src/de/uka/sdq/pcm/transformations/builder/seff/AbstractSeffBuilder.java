package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

public class AbstractSeffBuilder {

	public AbstractSeffBuilder() {
		super();
	}

	protected ResourceDemandingSEFF buildSeff(Signature signature) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(signature);
		
		return seff;
	}

	protected AbstractAction createAction(AbstractInternalActionDescriptor descriptor, Signature signature) {
		if (descriptor instanceof SignatureDependentInternalActionDescriptor)
			((SignatureDependentInternalActionDescriptor)descriptor).setCurrentSignature(signature);
		return createInternalAction(descriptor.getResourceType(), descriptor.getResourceDemand());
	}

	private InternalAction createInternalAction(ProcessingResourceType type, String resourceDemandSpec) {
		InternalAction action = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = SeffFactory.eINSTANCE.createParametricResourceDemand();
		d.setRequiredResource_ParametricResourceDemand(type);
		PCMRandomVariable specification = CoreFactory.eINSTANCE.createPCMRandomVariable();
		specification.setSpecification(getSaveResourceDemand(resourceDemandSpec));
		d.setSpecification_ParametericResourceDemand(specification);
		action.getResourceDemand_Action().add(d);
		
		return action;
	}

	private String getSaveResourceDemand(String resourceDemandSpec) {
		if (resourceDemandSpec == null)
			return "0";
		if (resourceDemandSpec.equals(""))
			return "0";
		return resourceDemandSpec;
	}

	protected AbstractAction createControlFlow(AbstractAction a, AbstractAction b) {
		a.setSuccessor_AbstractAction(b);
		return b;
	}

}