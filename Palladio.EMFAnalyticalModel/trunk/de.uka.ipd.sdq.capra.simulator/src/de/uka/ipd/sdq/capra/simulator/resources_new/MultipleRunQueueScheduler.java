package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.List;


public class MultipleRunQueueScheduler implements IScheduler {

	/** 
	 * @uml.property name="runQueueList"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="multipleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.IRunQueue"
	 */
	private List<IRunQueue> runQueue;

	/** 
	 * Getter of the property <tt>runQueueList</tt>
	 * @return  Returns the runQueue.
	 * @uml.property  name="runQueueList"
	 */
	public List<IRunQueue> getRunQueueList() {
		return runQueue;
	}

	/** 
	 * Setter of the property <tt>runQueueList</tt>
	 * @param runQueueList  The runQueue to set.
	 * @uml.property  name="runQueueList"
	 */
	public void setRunQueueList(List<IRunQueue> runQueueList) {
		runQueue = runQueueList;
	}

	/** 
	 * @uml.property name="loadBalancer"
	 * @uml.associationEnd aggregation="composite" inverse="scheduler:de.uka.ipd.sdq.capra.simulator.resources_new.ILoadBalancer"
	 */
	private ILoadBalancer loadBalancer;

	/** 
	 * Getter of the property <tt>loadBalancer</tt>
	 * @return  Returns the loadBalancer.
	 * @uml.property  name="loadBalancer"
	 */
	public ILoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	/** 
	 * Setter of the property <tt>loadBalancer</tt>
	 * @param loadBalancer  The loadBalancer to set.
	 * @uml.property  name="loadBalancer"
	 */
	public void setLoadBalancer(ILoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		
	}

}
