package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.IResourceInstance;


public interface ILoadBalancer {

	public abstract void balance(IResourceInstance instance);
	
}
