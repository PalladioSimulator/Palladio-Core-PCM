package de.uka.ipd.sdq.capra.simulator.resources_new;


public class SinglePriorityArrayRunQueue implements IRunQueue {

	/** 
	 * @uml.property name="priorityArray"
	 * @uml.associationEnd aggregation="composite" inverse="singlePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityArray"
	 */
	private PriorityArray priorityArray = new de.uka.ipd.sdq.capra.simulator.resources_new.PriorityArray();

	/** 
	 * Getter of the property <tt>priorityArray</tt>
	 * @return  Returns the priorityArray.
	 * @uml.property  name="priorityArray"
	 */
	public PriorityArray getPriorityArray() {
		return priorityArray;
	}

	/** 
	 * Setter of the property <tt>priorityArray</tt>
	 * @param priorityArray  The priorityArray to set.
	 * @uml.property  name="priorityArray"
	 */
	public void setPriorityArray(PriorityArray priorityArray) {
		this.priorityArray = priorityArray;
	}

}
