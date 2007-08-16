package de.uka.ipd.sdq.capra.simulator.resources;

public interface IPriorityManager {

	/**
	 * @return Returns the getMin.
	 * @uml.property name="min"
	 */
	public int getMin();

	/**
	 * Setter of the property <tt>getMin</tt>
	 * 
	 * @param getMin
	 *            The getMin to set.
	 * @uml.property name="min"
	 */
	public void setMin(int min);

	/**
	 * @return Returns the max.
	 * @uml.property name="max"
	 */
	public int getHighestPriority();

	/**
	 * Setter of the property <tt>max</tt>
	 * 
	 * @param max
	 *            The max to set.
	 * @uml.property name="max"
	 */
	public void setMax(int max);

	public abstract boolean isHigher(int prio_a, int prio_b);

	public abstract boolean isLower(int prio_a, int prio_b);

	/**
	 */
	public abstract boolean isSame(int prio_a, int prio_b);

	public abstract int nextHigher(int prio, int by);

	/**
	 */
	public abstract int nextLower(int prio);

	/**
	 */
	public abstract boolean outOfBounds(int prio);

	public abstract int getNumPriorities();

	/**
	 */
	public abstract int getPosition(int prio);

	/**
	 * Returns a new increased priority. The value is increased by 'by'. The
	 * Handler ensures that the priority does not exceed its boundaries.
	 */
	public abstract int increase(int prio, int by);

	/**
	 * Returns the new value of the priority decreased by the value of 'by'. The
	 * method ensures that the priority does not exceed its boundaries.
	 */
	public abstract int decrease(int prio, int by);
	
}
