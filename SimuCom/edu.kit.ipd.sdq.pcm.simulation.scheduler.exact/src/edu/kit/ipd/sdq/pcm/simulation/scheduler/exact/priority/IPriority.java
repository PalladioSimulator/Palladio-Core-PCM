package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority;


public interface IPriority extends Cloneable {

	/**
	 * PriorityManager this priority instance belongs to.
	 * @return
	 */
	IPriorityManager getManager();

	/**
	 * Absolute distance between this priority and prio.
	 * 
	 * @param prio
	 * @return
	 */
	int distance(IPriority prio);

	/**
	 * Returns the priority value adjusted to a rage from 0..n. Whereby 0
	 * represents the lowest and n the highest priority values.
	 * 
	 * @return
	 */
	int absoluteValue();

	/**
	 * Returns the priority as an integer. Depends on the original specification.
	 * 
	 * @return
	 */
	int getValue();

	
	/**
	 * Sets the value of the priority according to its original specification.
	 * @param value
	 */
	void setValue(int value);


	/**
	 * Returns the current priority increased by 1.
	 */
	IPriority increase();

	/**
	 * Returns the current priority decreased by 1.
	 */
	IPriority decrease();

	/**
	 * True, if this priority is lower or equal to prio, otherwise false.
	 * 
	 * @param prio
	 * @return
	 */
	boolean lessOrEqual(IPriority prio);

	/**
	 * True, if this priority is higher than prio, otherwise false.
	 * 
	 * @param prio
	 * @return
	 */
	boolean greaterThan(IPriority prio);


	/**
	 * Creates a copy of this priority instance.
	 * @return
	 */
	IPriority clone();

	/**
	 * Sets this priority to the same value as priority.
	 * 
	 * @param priority
	 */
	void setTo(IPriority priority);

	/**
	 * Returns the value of this priority plus the given
	 * bonus. This method ensures that the new priority lies in the given
	 * borders (lowest and highest priority).
	 * 
	 * @param bonus
	 */
	IPriority addBonus(int bonus);
}
