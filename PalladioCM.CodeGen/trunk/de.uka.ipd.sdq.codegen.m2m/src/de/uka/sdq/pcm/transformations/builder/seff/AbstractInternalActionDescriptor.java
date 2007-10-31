package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

/**
 * @author  Snowball
 */
public abstract class AbstractInternalActionDescriptor extends AbstractActionDescriptor {

	private ProcessingResourceType resourceType;
	
	public AbstractInternalActionDescriptor(
			ProcessingResourceType resourceType) {
		super();
		this.resourceType = resourceType;
	}

	public abstract String getResourceDemand();

	/**
	 * @return
	 */
	public ProcessingResourceType getResourceType() {
		return resourceType;
	}

	@Override
	public AbstractAction createAction() {
		return createInternalAction(getResourceType(), getResourceDemand());
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
}
