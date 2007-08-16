package de.uka.ipd.sdq.scheduler.resources.balancing;

import java.util.Collection;

import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;

public interface ILoadBalancer {

	/**
	 * @param collection
	 */
	public abstract void balance();

}
