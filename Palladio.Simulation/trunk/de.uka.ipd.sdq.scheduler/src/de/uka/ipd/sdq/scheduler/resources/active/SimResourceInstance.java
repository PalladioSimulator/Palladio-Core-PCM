package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimResourceInstance {

	private String name;
	private ActiveProcess runningProcess;
	private SchedulingEvent schedulingEvent;

	public SimResourceInstance(int id, String unique_name, IScheduler scheduler) {
		super();
		this.name = unique_name;
		this.schedulingEvent = new SchedulingEvent(scheduler, this);
	}

	public ActiveProcess getRunningProcess() {
		return runningProcess;
	}
	
	public void release() {
		this.runningProcess = null;
	}

	/**
	 * True, if there is no process executing on this resource instance, false
	 * otherwise.
	 */
	public boolean noProcessAssigned() {
		return runningProcess == null;
	}

	/**
	 * Assigns a new process to this instance. Note that the resource has to be
	 * idle to do so.
	 * 
	 * @param process
	 */
	public void assign(ActiveProcess process) {
		assert this.noProcessAssigned() : "There is already a process executing on resource instance "
				+ this;
		runningProcess = process;
	}

	public String getName() {
		return name;
	}

	public void scheduleSchedulingEvent(double time) {
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
			SimResourceInstance instance = (SimResourceInstance) obj;
			return this.getName().equals(instance.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}
