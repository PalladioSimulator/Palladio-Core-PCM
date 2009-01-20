package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;

public class StaticInternalActionDescriptor 
extends AbstractInternalActionDescriptor {

	private String demand;
	
	// Hauck 2008.11.19: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	public StaticInternalActionDescriptor(String demand, ResourceRequiredRole role, ResourceService service) {
		super(role, service);
		this.demand = demand;
	}
	
	public StaticInternalActionDescriptor(String demand, CommunicationLinkResourceType type) {
		super(type);
		this.demand = demand;
	}

	@Override
	public String getResourceDemand() {
		return demand;
	}

}
