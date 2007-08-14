package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.List;

public class PriorityArray {

	/**
	 * @uml.property name="priorityHandler"
	 * @uml.associationEnd inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.PriorityHandler"
	 */
	private IPriorityManager priorityManager;

	/**
	 * Getter of the property <tt>priorityHandler</tt>
	 * 
	 * @return Returns the priorityHandler.
	 * @uml.property name="priorityHandler"
	 */
	public IPriorityManager getPriorityHandler() {
		return priorityManager;
	}

	/**
	 * Setter of the property <tt>priorityHandler</tt>
	 * 
	 * @param priorityHandler
	 *            The priorityHandler to set.
	 * @uml.property name="priorityHandler"
	 */
	public void setPriorityHandler(IPriorityManager priorityHandler) {
		this.priorityManager = priorityHandler;
	}

	/**
	 * @uml.property name="processArray"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     aggregation="composite"
	 *                     inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessQueue"
	 */
	private List<ProcessQueue<ProcessWithPriority>> processQueue;

	/**
	 * Getter of the property <tt>processArray</tt>
	 * 
	 * @return Returns the processArray.
	 * @uml.property name="processArray"
	 */
	public List<ProcessQueue<ProcessWithPriority>> getProcessArray() {
		return processQueue;
	}

	/**
	 * Setter of the property <tt>processArray</tt>
	 * 
	 * @param processArray
	 *            The processArray to set.
	 * @uml.property name="processArray"
	 */
	public void setProcessArray(List<ProcessQueue<ProcessWithPriority>> processArray) {
		this.processQueue = processArray;
	}

	/**
	 * @uml.property name="priorityManager"
	 * @uml.associationEnd aggregation="shared"
	 *                     inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityManager"
	 */
	private IPriorityManager manager;

	/**
	 * Getter of the property <tt>priorityManager</tt>
	 * 
	 * @return Returns the manager.
	 * @uml.property name="priorityManager"
	 */
	public IPriorityManager getPriorityManager() {
		return manager;
	}

	/**
	 * Setter of the property <tt>priorityManager</tt>
	 * 
	 * @param priorityManager
	 *            The manager to set.
	 * @uml.property name="priorityManager"
	 */
	public void setPriorityManager(IPriorityManager priorityManager) {
		manager = priorityManager;
	}

	/**
	 */
	public void notifyPriorityChanged(ProcessWithPriority process, int from_prio, int to_prio) {
	}

		
		/**
		 */
		public int getNumberOfProcesses(){
			return 0;
		}

}
