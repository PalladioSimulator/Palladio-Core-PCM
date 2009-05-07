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
	public abstract void activelyBalance(IResourceInstance instance);

	public abstract void onSleep(IResourceInstance lastInstance);

	public abstract void onFork(IResourceInstance current);

	public abstract void onTerminate(IResourceInstance lastInstance);

	public abstract void onWake(IResourceInstance current);
}
