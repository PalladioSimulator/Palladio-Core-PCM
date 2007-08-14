package de.uka.ipd.sdq.capra.simulator.resources_new;

import de.uka.ipd.sdq.capra.simulator.schedinterface.ISchedulableProcess;


public class SimActiveResource extends AbstractSimResource implements IActiveResource {

	/**
	 * @uml.property  name="schedulingStrategy"
	 * @uml.associationEnd  aggregation="composite" inverse="simActiveResource:de.uka.ipd.sdq.capra.simulator.resources_new.ISchedulingStrategy"
	 */
	private IScheduler schedulingStrategy;

	/**
	 * Getter of the property <tt>schedulingStrategy</tt>
	 * @return  Returns the schedulingStrategy.
	 * @uml.property  name="schedulingStrategy"
	 */
	public IScheduler getSchedulingStrategy() {
		return schedulingStrategy;
	}

	/**
	 * Setter of the property <tt>schedulingStrategy</tt>
	 * @param schedulingStrategy  The schedulingStrategy to set.
	 * @uml.property  name="schedulingStrategy"
	 */
	public void setSchedulingStrategy(IScheduler schedulingStrategy) {
		this.schedulingStrategy = schedulingStrategy;
	}

	/**
	 * @uml.property  name="scheduler"
	 * @uml.associationEnd  aggregation="composite" inverse="simActiveResource:de.uka.ipd.sdq.capra.simulator.resources_new.IScheduler"
	 */
	private IScheduler scheduler;

	/**
	 * Getter of the property <tt>scheduler</tt>
	 * @return  Returns the scheduler.
	 * @uml.property  name="scheduler"
	 */
	public IScheduler getScheduler() {
		return scheduler;
	}

	/**
	 * Setter of the property <tt>scheduler</tt>
	 * @param scheduler  The scheduler to set.
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public void process(ISchedulableProcess process, boolean demand) {
	}

	/**
	 * @uml.property  name="priorityManager"
	 * @uml.associationEnd  aggregation="composite" inverse="simActiveResource:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityManager"
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
