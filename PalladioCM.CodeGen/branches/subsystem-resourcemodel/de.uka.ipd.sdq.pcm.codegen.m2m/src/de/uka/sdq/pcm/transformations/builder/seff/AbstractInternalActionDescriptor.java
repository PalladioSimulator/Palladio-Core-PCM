package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformanceFactory;

/**
 * @author  Snowball
 */
public abstract class AbstractInternalActionDescriptor extends AbstractActionDescriptor {

	// Hauck 2008.11.19: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	// TODO communicationLinkResourceType only is used if needed
	private CommunicationLinkResourceType communicationLinkResourceType = null;
	private ResourceService resourceService;
	private ResourceRequiredRole resourceRequiredRole;
	
	// Hauck 2008.11.19: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	public AbstractInternalActionDescriptor(
			ResourceRequiredRole role, ResourceService service) {
		super();
		this.resourceRequiredRole = role;
		this.resourceService = service;
	}
	
	// Constructor for InternalActions that use CommunicationLinkResourceTypes
	public AbstractInternalActionDescriptor(
			CommunicationLinkResourceType type) {
		super();
		this.communicationLinkResourceType = type;
	}

	public abstract String getResourceDemand();

	/**
	 * @return
	 */
	public ResourceRequiredRole getResourceRequiredRole() {
		return resourceRequiredRole;
	}
	
	/**
	 * @return
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	@Override
	public AbstractAction createAction() {
		return createInternalAction(getResourceRequiredRole(), getResourceService(), getResourceDemand());
	}

	// Hauck 2008.11.19: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	private InternalAction createInternalAction(ResourceRequiredRole role, ResourceService service, String resourceDemandSpec) {
		// TODO CommunicationLinkResourceTypes do not have ResourceInterfaceProvidingRoles!
		// Specify resource demand in a different way!
		if (communicationLinkResourceType != null) {
			InternalAction action = SeffFactory.eINSTANCE.createInternalAction();
			// TODO Specify resource demand here!
			return action;
		}
		InternalAction action = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = PerformanceFactory.eINSTANCE.createParametricResourceDemand();
		d.setResourceRequiredRole_ParametricResourceDemand(role);
		d.setCalledResourceService_ParametricResourceDemand(service);
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
