package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;

public class StaticInternalActionDescriptor extends AbstractInternalActionDescriptor {

	private String demand;

	public StaticInternalActionDescriptor(String demand, ResourceType resourceType) {
		super(resourceType);
		this.demand = demand;
	}

	@Override
	public String getResourceDemand() {
		return demand;
	}

}
