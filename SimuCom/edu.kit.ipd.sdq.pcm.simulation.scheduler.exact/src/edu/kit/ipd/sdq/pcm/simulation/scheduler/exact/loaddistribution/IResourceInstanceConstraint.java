package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;



public interface IResourceInstanceConstraint {

	/**
	 * Checks whether the condition is fulfilled for the given instance.
	 */
	public abstract boolean check(IResourceInstance instance);

}
