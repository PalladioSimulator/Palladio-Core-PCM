package de.uka.ipd.sdq.scheduler.resources.active;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.events.SchedulingInterruptEvent;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class SimResourceInstance implements IResourceInstance {

	private int number;
	private IActiveResource containing_resource;
	private IRunningProcess running_process;
	private SchedulingEvent scheduling_event;
	private boolean scheduling_event_scheduled;
	
	public SimResourceInstance(int number, IActiveResource containing_resource) {
		super();
		this.number = number;
		this.containing_resource = containing_resource;
		this.scheduling_event = new SchedulingEvent((SimActiveResource)containing_resource,this);
		this.running_process = null;
		this.scheduling_event_scheduled = false;
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
		return containing_resource.getName() + "_" + number;
	}

	public void scheduleSchedulingEvent(double time) {
		cancelSchedulingEvent();
		scheduling_event.schedule(time);
		scheduling_event_scheduled = true;
	}
	
	public void schedulingInterrupt(double time, boolean quantum_expired){
		new SchedulingInterruptEvent((SimActiveResource)containing_resource, this, quantum_expired).schedule(time);
	}

	public void cancelSchedulingEvent() {
		scheduling_event.cancel();
		scheduling_event_scheduled = false;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimResourceInstance) {
			SimResourceInstance instance = (SimResourceInstance) obj;
			return this.getId().equals(instance.getId());
		}
		return false;
	}
	
	public String getId(){
		return containing_resource.getId() + number;
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public boolean schedulingEventScheduled() {
		return scheduling_event_scheduled;
	}

	@Override
	public double getNextSchedEventTime() {
		double time = scheduling_event.time() - Sim.time();
		return time;
	}

	@Override
	public void start() {
		scheduling_event.schedule(0);
	}
}
