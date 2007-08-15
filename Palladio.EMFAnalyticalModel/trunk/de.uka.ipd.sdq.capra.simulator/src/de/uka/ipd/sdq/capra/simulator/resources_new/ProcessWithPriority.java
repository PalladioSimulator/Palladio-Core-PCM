package de.uka.ipd.sdq.capra.simulator.resources_new;

public class ProcessWithPriority extends PreemptiveProcess {

	/**
	 * @uml.property name="staticPriority"
	 */
	private int staticPriority;

	/**
	 * Getter of the property <tt>priority</tt>
	 * 
	 * @return Returns the priority.
	 * @uml.property name="staticPriority"
	 */
	public int getStaticPriority() {
		return staticPriority;
	}

	/**
	 * Setter of the property <tt>priority</tt>
	 * 
	 * @param priority
	 *            The priority to set.
	 * @uml.property name="staticPriority"
	 */
	public void setStaticPriority(int staticPriority) {
		this.staticPriority = staticPriority;
	}

	/**
	 * @uml.property name="dynamicPriority"
	 */
	private int dynamicPriority;

	/**
	 * Getter of the property <tt>dynamic_priority</tt>
	 * 
	 * @return Returns the dynamic_priority.
	 * @uml.property name="dynamicPriority"
	 */
	public int getDynamicPriority() {
		return dynamicPriority;
	}

	/**
	 * Setter of the property <tt>dynamic_priority</tt>
	 * 
	 * @param dynamic_priority
	 *            The dynamic_priority to set.
	 * @uml.property name="dynamicPriority"
	 */
	public void setDynamicPriority(int dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	/**
	 * @uml.property name="priorityUpdateStrategy"
	 * @uml.associationEnd aggregation="shared"
	 *                     inverse="processWithPriority:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityUpdateStrategy"
	 */
	private IPriorityUpdateStrategy priorityUpdateStrategy;

	/**
	 * Getter of the property <tt>priorityUpdateStrategy</tt>
	 * 
	 * @return Returns the priorityUpdateStrategy.
	 * @uml.property name="priorityUpdateStrategy"
	 */
	public IPriorityUpdateStrategy getPriorityUpdateStrategy() {
		return priorityUpdateStrategy;
	}

	/**
	 * Setter of the property <tt>priorityUpdateStrategy</tt>
	 * 
	 * @param priorityUpdateStrategy
	 *            The priorityUpdateStrategy to set.
	 * @uml.property name="priorityUpdateStrategy"
	 */
	public void setPriorityUpdateStrategy(
			IPriorityUpdateStrategy priorityUpdateStrategy) {
		this.priorityUpdateStrategy = priorityUpdateStrategy;
	}

	/**
	 * @uml.property name="currentPriorityArray"
	 * @uml.associationEnd aggregation="shared"
	 *                     inverse="processWithPriority:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityArray"
	 */
	private PriorityArray currentPriorityArray;

	/**
	 * Getter of the property <tt>currentPriorityArray</tt>
	 * 
	 * @return Returns the currentPriorityArray.
	 * @uml.property name="currentPriorityArray"
	 */
	public PriorityArray getCurrentPriorityArray() {
		return currentPriorityArray;
	}

	/**
	 * Setter of the property <tt>currentPriorityArray</tt>
	 * 
	 * @param currentPriorityArray
	 *            The currentPriorityArray to set.
	 * @uml.property name="currentPriorityArray"
	 */
	public void setCurrentPriorityArray(PriorityArray currentPriorityArray) {
		this.currentPriorityArray = currentPriorityArray;
	}

	/**
	 */
	protected void changePriority(int new_prio) {
	}
	
	public int getCurrentPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/**
	 */
	public void updatePriority() {
	}

}
