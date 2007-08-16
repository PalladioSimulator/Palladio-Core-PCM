package de.uka.ipd.sdq.capra.simulator.resources;

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
