package de.uka.ipd.sdq.scheduler.resources.active;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.events.SchedulingInterruptEvent;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class SimResourceInstance implements IResourceInstance {

	private int number;
	private IActiveResource containing_resource;
	private IRunningProcess running_process;
	private SchedulingEvent scheduling_event;
	private double time_running;
	private double time_idle;
	private double last_running;
	private double last_idle;
	private Simulator simulator;
	private boolean isScheduling;
	private PostSchedulingEvent postSchedulingEvent;

	
	public SimResourceInstance(int number, IActiveResource containing_resource) {
		super();
		this.number = number;
		this.containing_resource = containing_resource;
		// Initialise this at start instead of container for multiple Simulation runs with different simulator instances...
		// this.scheduling_event = new SchedulingEvent((SimActiveResource)containing_resource,this);
		this.running_process = null;
		this.time_idle = 0;
		this.time_running = 0;
		this.last_idle = 0;
		this.last_running = 0;
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.isScheduling = false;
	}

	public IRunningProcess getRunningProcess() {
		return running_process;
	}
	
	public void release() {
		double now = simulator.time();
		if (running_process == null){
			time_idle += now - last_idle;
		} else {
			time_running += now - last_running;
		}
		last_idle = now;
		this.running_process = null;
	}

	public boolean processAssigned() {
		return running_process != null;
	}

	public void assign(IRunningProcess process) {
		assert !this.processAssigned() : "There is already a process executing on resource instance "
				+ this;
		running_process = process;
		double now = simulator.time();
		time_idle += now - last_idle;
		if (process == null){
			last_idle = now;
		} else {
			last_running = now;
		}
	}

	public String getName() {
		return containing_resource.getName() + "_" + number;
	}

	public void scheduleSchedulingEvent(double time) {
		cancelSchedulingEvent();
		scheduling_event.schedule(time);
	}
	
	public void schedulingInterrupt(double time, boolean quantum_expired){
		new SchedulingInterruptEvent((SimActiveResource)containing_resource, this, quantum_expired).schedule(time);
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

	public double getNextSchedEventTime() {
		double time = scheduling_event.time() - simulator.time();
		return time;
	}

	public void start() {
		this.scheduling_event = new SchedulingEvent((SimActiveResource)containing_resource,this);
		this.postSchedulingEvent = new PostSchedulingEvent((SimActiveResource)containing_resource,this);
		scheduling_event.schedule(0);
	}
	
	public void stop(){
		System.out.println("Utilisation of " + getName() + ": " + (time_running / (time_idle + time_running)));
	}
	
	public void setIsScheduling(boolean b) {
		isScheduling = b;
	}

	public boolean isScheduling() {
		return isScheduling;
	}
	
	public void schedulePostSchedulingEvent(double overhead) {
		postSchedulingEvent.cancel();
		postSchedulingEvent.schedule(overhead);
	}

}
