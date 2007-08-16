package de.uka.ipd.sdq.scheduler.resources.queueing.priorityarray;

import java.util.List;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.AbstractRunQueue;

public abstract class AbstractPriorityArrayRunQueue extends AbstractRunQueue {

	protected IPriorityManager priorityManager;

	public AbstractPriorityArrayRunQueue(IPriorityManager priorityManager) {
		super();
		this.priorityManager = priorityManager;
	}

	/**
	 * Adds processes that do not violate the affinity constraint to the list
	 * starting with the lower priority tasks up to the higher ones.
	 * 
	 * @param priorityArray
	 * @param targetInstance
	 * @param processList
	 */
	protected void addMovableProcesses(PriorityArray priorityArray, SimResourceInstance targetInstance, List<ActiveProcess> processList) {
		IPriority prio = priorityArray.getLowestPriorityWithNonEmptyQueue();
		IPriority highest_prio = priorityArray
				.getHighestPriorityWithNonEmptyQueue();
		while (prio.lessOrEqual(highest_prio)) {
			for (ActiveProcess process : priorityArray.getQueueFor(prio)) {
				if (process.checkAffinity(targetInstance)) {
					processList.add(process);
				}
			}
			prio.increase();
		}
	}

}