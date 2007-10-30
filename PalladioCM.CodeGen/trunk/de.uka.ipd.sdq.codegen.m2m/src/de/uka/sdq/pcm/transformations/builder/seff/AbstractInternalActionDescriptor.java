package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * @author  Snowball
 */
public abstract class AbstractInternalActionDescriptor {

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
}
