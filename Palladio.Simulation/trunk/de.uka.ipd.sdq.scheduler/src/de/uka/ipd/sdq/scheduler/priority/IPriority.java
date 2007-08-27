package de.uka.ipd.sdq.scheduler.priority;

public interface IPriority extends Cloneable {

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

	int getValue();

	void setValue(int value);


	/**
	 * Returns the current priority increased by 1.
	 */
	IPriority increase();

	/**
	 * Returns the current priority decreased by 1.
	 */
	IPriority decrease();

	boolean lessOrEqual(IPriority prio);

	boolean greaterThan(IPriority prio);


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
	 * @param priority
	 * @param bonus
	 */
	IPriority addBonus(IPriority priority, int bonus);
}
