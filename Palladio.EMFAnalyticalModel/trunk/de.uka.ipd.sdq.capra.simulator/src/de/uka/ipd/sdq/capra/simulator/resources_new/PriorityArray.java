package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.List;


public class PriorityArray {

	/**
	 * @uml.property  name="maxPriority"
	 */
	private int maxPriority = 15;

	/**
	 * Getter of the property <tt>maxPriority</tt>
	 * @return  Returns the maxPriority.
	 * @uml.property  name="maxPriority"
	 */
	public int getMaxPriority() {
		return maxPriority;
	}

	/**
	 * Setter of the property <tt>maxPriority</tt>
	 * @param maxPriority  The maxPriority to set.
	 * @uml.property  name="maxPriority"
	 */
	public void setMaxPriority(int maxPriority) {
		this.maxPriority = maxPriority;
	}

	/**
	 * @uml.property  name="minPriority"
	 */
	private int minPriority = 0;

	/**
	 * Getter of the property <tt>minPriority</tt>
	 * @return  Returns the minPriority.
	 * @uml.property  name="minPriority"
	 */
	public int getMinPriority() {
		return minPriority;
	}

	/**
	 * Setter of the property <tt>minPriority</tt>
	 * @param minPriority  The minPriority to set.
	 * @uml.property  name="minPriority"
	 */
	public void setMinPriority(int minPriority) {
		this.minPriority = minPriority;
	}

	/**
	 * @uml.property  name="priorityHandler"
	 * @uml.associationEnd  inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityHandler"
	 */
	private IPriorityManager priorityManager;

	/**
	 * Getter of the property <tt>priorityHandler</tt>
	 * @return  Returns the priorityHandler.
	 * @uml.property  name="priorityHandler"
	 */
	public IPriorityManager getPriorityHandler() {
		return priorityManager;
	}

	/**
	 * Setter of the property <tt>priorityHandler</tt>
	 * @param priorityHandler  The priorityHandler to set.
	 * @uml.property  name="priorityHandler"
	 */
	public void setPriorityHandler(IPriorityManager priorityHandler) {
		this.priorityManager = priorityHandler;
	}

	/**
	 * @uml.property   name="processArray"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessQueue"
	 */
	private List<IProcessQueue> processArray;

	/** 
	 * Getter of the property <tt>processArray</tt>
	 * @return  Returns the processArray.
	 * @uml.property  name="processArray"
	 */
	public List<IProcessQueue> getProcessArray() {
		return processArray;
	}

	/** 
	 * Setter of the property <tt>processArray</tt>
	 * @param processArray  The processArray to set.
	 * @uml.property  name="processArray"
	 */
	public void setProcessArray(List<IProcessQueue> processArray) {
		this.processArray = processArray;
	}

	/**
	 * @uml.property   name="priorityManager"
	 * @uml.associationEnd   aggregation="shared" inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityManager"
	 */
	private IPriorityManager manager;

	/** 
	 * Getter of the property <tt>priorityManager</tt>
	 * @return  Returns the manager.
	 * @uml.property  name="priorityManager"
	 */
	public IPriorityManager getPriorityManager() {
		return manager;
	}

	/** 
	 * Setter of the property <tt>priorityManager</tt>
	 * @param priorityManager  The manager to set.
	 * @uml.property  name="priorityManager"
	 */
	public void setPriorityManager(IPriorityManager priorityManager) {
		manager = priorityManager;
	}

}
