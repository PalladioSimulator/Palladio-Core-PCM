package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimResourceInstance implements IResourceInstance {

	private String name;
	private IRunningProcess runningProcess;
	private SchedulingEvent schedulingEvent;

	public SimResourceInstance(int id, String unique_name, IScheduler scheduler) {
		super();
		this.name = unique_name;
		this.schedulingEvent = new SchedulingEvent(scheduler, this);
	}

	public IRunningProcess getRunningProcess() {
		return runningProcess;
	}
	
	public void release() {
		this.runningProcess = null;
	}

	public boolean processAssigned() {
		return runningProcess != null;
	}

	public void assign(IRunningProcess process) {
		assert !this.processAssigned() : "There is already a process executing on resource instance "
				+ this;
		runningProcess = process;
	}

	public String getName() {
		return name;
	}

	public void scheduleSchedulingEvent(double time) {
		cancelSchedulingEvent();
		schedulingEvent.schedule(time);
	}

	public void cancelSchedulingEvent() {
		schedulingEvent.cancel();
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimResourceInstance) {
			IResourceInstance instance = (IResourceInstance) obj;
			return this.getName().equals(instance.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}
