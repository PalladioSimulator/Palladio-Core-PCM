package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events;

/**
 * Delayed actions are activities that are executed by the scheduler (e.g. some
 * housekeeping or asking for access to a passive resource) but require the
 * process to be running. DelayedActions have priority of the proceeding of the
 * process as they have to be finished in oder to continue process execution.
 * 
 * @author jens
 * 
 */
public interface IDelayedAction {

	/**
	 * Executes the delayed action; If the result is true the action has been
	 * successfully executed.
	 */
	boolean perform();

}
