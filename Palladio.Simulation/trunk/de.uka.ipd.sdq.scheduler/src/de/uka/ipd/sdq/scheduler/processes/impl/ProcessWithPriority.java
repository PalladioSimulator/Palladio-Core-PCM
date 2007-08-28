package de.uka.ipd.sdq.scheduler.processes.impl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;

public class ProcessWithPriority extends PreemptiveProcess {

	private IPriority staticPriority;
	private IPriority dynamicPriority;
	private IPriorityUpdateStrategy priorityUpdateStrategy;
	private static boolean in_front_if_priority_changed = false;

	public ProcessWithPriority(ISchedulableProcess process, String name, String id,
			IPriority staticPriority) {
		super(process, name, id);
		this.staticPriority = staticPriority;
		this.dynamicPriority = staticPriority;
		this.priorityUpdateStrategy = null;
	}

	public IPriority getStaticPriority() {
		return staticPriority;
	}

	public IPriority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setPriorityUpdateStrategy(
			IPriorityUpdateStrategy priorityUpdateStrategy) {
		this.priorityUpdateStrategy = priorityUpdateStrategy;
	}
	
	public void updatePriority(){
		if (this.priorityUpdateStrategy != null)
			this.priorityUpdateStrategy.update(this);
	}

	public boolean hasBonus() {
		return dynamicPriority.greaterThan(staticPriority);
	}

	/**
	 * Sets the dynamic priority back to the original, static priority.
	 */
	public void resetDynamicPriority() {
		changePriority(staticPriority);
	}

	public void decreasePriority() {
		changePriority(dynamicPriority.decrease());
	}

	public void setToStaticPriorityWithBonus(int bonus) {
		changePriority(dynamicPriority.addBonus(staticPriority, bonus));
	}

	private void changePriority(IPriority new_priority) {
		if (!dynamicPriority.equals(new_priority)){
			dynamicPriority = new_priority;
			if (isReady()){
				getRunQueue().removeProcess(this);
				getRunQueue().addProcess(this,in_front_if_priority_changed);
			}
		}
	}
}
