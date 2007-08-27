package de.uka.ipd.sdq.scheduler.resources.passive;

public interface IDelayedAction {

	/**
	 * Executes the delayed action; If the result is true the action has been
	 * successfully executed and is removed.
	 */
	boolean perform();

}
