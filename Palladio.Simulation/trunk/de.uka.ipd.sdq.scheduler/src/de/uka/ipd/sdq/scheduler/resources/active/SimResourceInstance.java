package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.events.SchedulingEvent;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimResourceInstance implements IResourceInstance {

	private String name;
	private ActiveProcess runningProcess;
	private SchedulingEvent schedulingEvent;

	public SimResourceInstance(int id, String unique_name, IScheduler scheduler) {
		super();
		this.name = unique_name;
		this.schedulingEvent = new SchedulingEvent(scheduler, this);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#getRunningProcess()
	 */
	public ActiveProcess getRunningProcess() {
		return runningProcess;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#release()
	 */
	public void release() {
		this.runningProcess = null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#noProcessAssigned()
	 */
	public boolean noProcessAssigned() {
		return runningProcess == null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#assign(de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess)
	 */
	public void assign(ActiveProcess process) {
		assert this.noProcessAssigned() : "There is already a process executing on resource instance "
				+ this;
		runningProcess = process;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#scheduleSchedulingEvent(double)
	 */
	public void scheduleSchedulingEvent(double time) {
		schedulingEvent.schedule(time);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.scheduler.resources.active.IResourceInstance#cancelSchedulingEvent()
	 */
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
