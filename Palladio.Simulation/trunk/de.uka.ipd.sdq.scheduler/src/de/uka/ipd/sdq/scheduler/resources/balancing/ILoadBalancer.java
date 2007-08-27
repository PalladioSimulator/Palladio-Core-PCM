package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


public interface ILoadBalancer {

	public abstract void balance(SimResourceInstance instance);
	
}
