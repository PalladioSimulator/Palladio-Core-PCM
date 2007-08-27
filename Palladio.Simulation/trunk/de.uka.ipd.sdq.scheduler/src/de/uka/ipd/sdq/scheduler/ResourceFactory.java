package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

/**
 * Creates instances of active and passive resources with different scheduling
 * strategies.
 * 
 * @author jens
 * 
 */
public class ResourceFactory {
	public IResourceInstance createResourceInstance(int index, String name,
			String id, IScheduler scheduler) {
		return new SimResourceInstance(index, name + "_" + id, scheduler);
	}
}
