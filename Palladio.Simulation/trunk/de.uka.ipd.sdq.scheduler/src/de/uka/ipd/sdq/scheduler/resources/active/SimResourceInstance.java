package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class SimResourceInstance implements IResourceInstance {

	private String id;
	private IActiveResource containing_resource;
	private IRunningProcess running_process;
	private SchedulingEvent scheduling_event;
	
	public SimResourceInstance(String id, IActiveResource containing_resource) {
		super();
		this.id = id;
		this.containing_resource = containing_resource;
		this.scheduling_event = new SchedulingEvent(((SimActiveResource)containing_resource).getScheduler(),this);
		this.running_process = null;
	}

	public IRunningProcess getRunningProcess() {
		return running_process;
	}
	
	public void release() {
		this.running_process = null;
	}

	public boolean processAssigned() {
		return running_process != null;
	}

	public void assign(IRunningProcess process) {
		assert !this.processAssigned() : "There is already a process executing on resource instance "
				+ this;
		running_process = process;
	}

	public String getName() {
		return containing_resource.getName() + "_" + id;
	}

	public void scheduleSchedulingEvent(double time) {
		cancelSchedulingEvent();
		scheduling_event.schedule(time);
	}

	public void cancelSchedulingEvent() {
		scheduling_event.cancel();
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimResourceInstance) {
			SimResourceInstance instance = (SimResourceInstance) obj;
			return this.id.equals(instance.id);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
