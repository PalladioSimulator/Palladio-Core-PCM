package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public interface IResourceInstanceConstraint {

	/**
	 * Checks whether the condition is fulfilled for the given instance.
	 */
	public abstract boolean check(IResourceInstance instance);

}
