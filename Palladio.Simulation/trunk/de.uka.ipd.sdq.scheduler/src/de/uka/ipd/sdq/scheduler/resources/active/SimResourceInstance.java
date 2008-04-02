package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.PostSchedulingEvent;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.events.SchedulingInterruptEvent;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;

public class SimResourceInstance implements IResourceInstance {

	private int number;
	private IActiveResource containing_resource;
	private IRunningProcess running_process;
	private SchedulingEvent scheduling_event;
	private Simulator simulator;
	private boolean isScheduling;
	private PostSchedulingEvent postSchedulingEvent;
	private List<IActiveResourceStateSensor> resourceObserverList = new ArrayList<IActiveResourceStateSensor>();

	
	public SimResourceInstance(int number, IActiveResource containing_resource) {
		super();
		this.number = number;
		this.containing_resource = containing_resource;
		// Initialise this at start instead of container for multiple Simulation runs with different simulator instances...
		// this.scheduling_event = new SchedulingEvent((SimActiveResource)containing_resource,this);
		this.running_process = null;
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.isScheduling = false;
	}

	public IRunningProcess getRunningProcess() {
		return running_process;
	}
	
	public void release() {
		this.running_process = null;
		updateObservers();
	}

	private void updateObservers() {
		for(IActiveResourceStateSensor observer : resourceObserverList){
			observer.update(this);
		}
	}
	
	public void addObserver(IActiveResourceStateSensor observer){
		resourceObserverList.add(observer);
	}
	
	public void removeObserver(IActiveResourceStateSensor observer){
		resourceObserverList.remove(observer);
	}

	public boolean processAssigned() {
		return running_process != null;
	}

	public void assign(IRunningProcess process) {
		assert !this.processAssigned() : "There is already a process executing on resource instance "
				+ this;
		running_process = process;
		updateObservers();
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
