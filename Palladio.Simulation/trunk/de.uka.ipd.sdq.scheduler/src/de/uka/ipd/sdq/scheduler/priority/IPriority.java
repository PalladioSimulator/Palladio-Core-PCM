package de.uka.ipd.sdq.scheduler.priority;


public interface IPriority {

	IPriorityManager getManager();

	boolean greaterThan(IPriority default_prio);

	int minus(IPriority static_prio);

	/**
	 * Returns the priority value adjusted to a rage from 0..n.
	 * @return
	 */
	int absoluteValue();

	void increase();

	boolean lessOrEqual(IPriority highest_prio);

}
