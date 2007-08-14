package de.uka.ipd.sdq.capra.simulator.resources_new;


public class DoublePriorityArrayRunQueue implements IRunQueue {

	/** 
	 * @uml.property name="activePriorityArray"
	 * @uml.associationEnd aggregation="composite" inverse="doublePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityArray"
	 */
	private PriorityArray activePriorityArray;

	/** 
	 * Getter of the property <tt>activePriorityArray</tt>
	 * @return  Returns the activePriorityArray.
	 * @uml.property  name="activePriorityArray"
	 */
	public PriorityArray getActivePriorityArray() {
		return activePriorityArray;
	}

	/** 
	 * Setter of the property <tt>activePriorityArray</tt>
	 * @param activePriorityArray  The activePriorityArray to set.
	 * @uml.property  name="activePriorityArray"
	 */
	public void setActivePriorityArray(PriorityArray activePriorityArray) {
		this.activePriorityArray = activePriorityArray;
	}

	/** 
	 * @uml.property name="expiredPriorityArray"
	 * @uml.associationEnd aggregation="composite" inverse="doublePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityArray"
	 */
	private PriorityArray expiredPriorityArray;

	/** 
	 * Getter of the property <tt>expiredPriorityArray</tt>
	 * @return  Returns the expiredPriorityArray.
	 * @uml.property  name="expiredPriorityArray"
	 */
	public PriorityArray getExpiredPriorityArray() {
		return expiredPriorityArray;
	}

	/** 
	 * Setter of the property <tt>expiredPriorityArray</tt>
	 * @param expiredPriorityArray  The expiredPriorityArray to set.
	 * @uml.property  name="expiredPriorityArray"
	 */
	public void setExpiredPriorityArray(PriorityArray expiredPriorityArray) {
		this.expiredPriorityArray = expiredPriorityArray;
	}

}
