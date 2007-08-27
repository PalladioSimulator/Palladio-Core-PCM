package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SchedulerFactory {
	public SimResourceInstance createResourceInstance(int index, String name, String id, IScheduler scheduler){
		return new SimResourceInstance(index,name +"_" + id, scheduler);
	}
}
