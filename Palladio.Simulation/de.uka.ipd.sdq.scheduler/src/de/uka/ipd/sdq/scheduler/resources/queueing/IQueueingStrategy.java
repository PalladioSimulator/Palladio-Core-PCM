package de.uka.ipd.sdq.scheduler.resources.queueing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IQueueingStrategy {

	/**
	 */
	public abstract ActiveProcess getNextProcessFor(SimResourceInstance instance);

	/**
	 * @param process
	 *            TODO
	 */
	public abstract void addNewProcess(ActiveProcess process);

}
