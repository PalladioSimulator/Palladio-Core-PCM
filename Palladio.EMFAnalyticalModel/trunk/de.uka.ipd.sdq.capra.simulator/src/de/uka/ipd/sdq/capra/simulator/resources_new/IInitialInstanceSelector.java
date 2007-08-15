package de.uka.ipd.sdq.capra.simulator.resources_new;

public interface IInitialInstanceSelector {

	/**
	 * Selects the initial instance to execute on for a process.
	 */
	public abstract SimResourceInstance selectInstanceFor(ActiveProcess process);

}
