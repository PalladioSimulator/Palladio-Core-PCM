package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

public class StaticInternalActionDescriptor 
extends AbstractInternalActionDescriptor {

	private String demand;

	public StaticInternalActionDescriptor(String demand, ProcessingResourceType resourceType) {
		super(resourceType);
		this.demand = demand;
	}

	@Override
	public String getResourceDemand() {
		return demand;
	}

}
