package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public interface ILoadBalancer {

	/**
	 * Balances the load. Two scenarios are possible. Either the load is
	 * balanced between all instances, or the specified instances pulls
	 * processes from the busiest one.
	 * 
	 * @param instance
	 */
	public abstract void balance(IResourceInstance instance);

}
