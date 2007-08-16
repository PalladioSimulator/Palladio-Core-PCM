package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.resources.queueing.MultipleRunQueues;


public interface ILoadBalancer {

	/**
	 * @return        Returns the scheduler.
	 * @uml.property   name="scheduler"
	 * @uml.associationEnd   inverse="loadBalancer:de.uka.ipd.sdq.capra.simulator.resources.MultipleRunQueues"
	 */
	public MultipleRunQueues getScheduler();

	/**
	 * Setter of the property <tt>scheduler</tt>
	 * @param scheduler  The scheduler to set.
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(MultipleRunQueues scheduler);

		
		/**
		 */
		public abstract void balance();
		

}
