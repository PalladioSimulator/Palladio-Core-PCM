package de.uka.ipd.sdq.scheduler.balancing;

import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;


public interface ILoadBalancer {

	public abstract void balance(SimResourceInstance instance);
	
}
