package de.uka.ipd.sdq.capra.simulator.resources_new;


public abstract class AbstractPriorityBoost implements IPriorityBoost {

	/**
	 * @uml.property  name="priorityManager"
	 * @uml.associationEnd  aggregation="shared" inverse="abstractPriorityBoost:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityManager"
	 */
	private IPriorityManager priorityManager;

	/**
	 * Getter of the property <tt>priorityManager</tt>
	 * @return  Returns the priorityManager.
	 * @uml.property  name="priorityManager"
	 */
	public IPriorityManager getPriorityManager() {
		return priorityManager;
	}

	/**
	 * Setter of the property <tt>priorityManager</tt>
	 * @param priorityManager  The priorityManager to set.
	 * @uml.property  name="priorityManager"
	 */
	public void setPriorityManager(IPriorityManager priorityManager) {
		this.priorityManager = priorityManager;
	}

}
