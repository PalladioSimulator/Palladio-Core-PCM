package de.uka.ipd.sdq.capra.simulator.resources_new;


public interface ILoadBalancer {

	/**
	 * @return  Returns the scheduler.
	 * @uml.property  name="scheduler"
	 * @uml.associationEnd  inverse="loadBalancer:de.uka.ipd.sdq.capra.simulator.resources_new.MultipleRunQueueScheduler"
	 */
	public MultipleRunQueueScheduler getScheduler();

	/**
	 * Setter of the property <tt>scheduler</tt>
	 * @param scheduler  The scheduler to set.
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(MultipleRunQueueScheduler scheduler);

		
		/**
		 */
		public abstract void balance();
		

}
