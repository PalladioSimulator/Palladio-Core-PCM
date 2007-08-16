package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.scheduler.AbstractScheduler;


public class AbstractSelector implements IInitialInstanceSelector {

	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		return null;
	}

	/**
	 * @uml.property   name="scheduler"
	 * @uml.associationEnd   aggregation="shared" inverse="abstractSelector:de.uka.ipd.sdq.capra.simulator.resources.AbstractScheduler"
	 */
	private AbstractScheduler scheduler;

	/**
	 * Getter of the property <tt>scheduler</tt>
	 * @return  Returns the scheduler.
	 * @uml.property  name="scheduler"
	 */
	public AbstractScheduler getScheduler() {
		return scheduler;
	}

	/**
	 * Setter of the property <tt>scheduler</tt>
	 * @param scheduler  The scheduler to set.
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(AbstractScheduler scheduler) {
		this.scheduler = scheduler;
	}

}
