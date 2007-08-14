package de.uka.ipd.sdq.capra.simulator.resources_new;

public interface IPriorityBoost {

	/**
	 */
	public abstract void boost(ProcessWithPriority process);

	public IPriorityUpdateStrategy getPriorityDecayStrategy();

}
