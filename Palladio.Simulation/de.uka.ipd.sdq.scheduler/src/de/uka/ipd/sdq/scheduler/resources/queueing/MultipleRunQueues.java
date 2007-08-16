package de.uka.ipd.sdq.scheduler.resources.queueing;

import java.util.Collection;
import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IInitialInstanceSelector;
import de.uka.ipd.sdq.scheduler.resources.balancing.ILoadBalancer;


public class MultipleRunQueues implements IQueueingStrategy {

	private Hashtable<SimResourceInstance, IRunQueue> runQueueTable;
	
	public MultipleRunQueues(Collection<SimResourceInstance> allInstances, IRunQueue prototypeRunQueue, IInitialInstanceSelector initialInstanceSelector, ILoadBalancer loadBalancer){
		runQueueTable = new Hashtable<SimResourceInstance, IRunQueue>();
		this.initialInstanceSelector = initialInstanceSelector;
		this.loadBalancer = loadBalancer;
		for (SimResourceInstance resourceInstance : allInstances) {
			runQueueTable.put(resourceInstance, prototypeRunQueue.createNewInstance());
		}
	}


	/**
	 * @uml.property   name="loadBalancer"
	 * @uml.associationEnd   aggregation="composite" inverse="scheduler:de.uka.ipd.sdq.capra.simulator.resources.ILoadBalancer"
	 */
	private ILoadBalancer loadBalancer;

	/**
	 * Getter of the property <tt>loadBalancer</tt>
	 * 
	 * @return Returns the loadBalancer.
	 * @uml.property name="loadBalancer"
	 */
	public ILoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	/**
	 * Setter of the property <tt>loadBalancer</tt>
	 * 
	 * @param loadBalancer
	 *            The loadBalancer to set.
	 * @uml.property name="loadBalancer"
	 */
	public void setLoadBalancer(ILoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

	/**
	 * @uml.property   name="initialInstanceSelector"
	 * @uml.associationEnd   aggregation="composite" inverse="multipleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources.IInitialInstanceSelector"
	 */
	private IInitialInstanceSelector initialInstanceSelector;

	/**
	 * Getter of the property <tt>initialInstanceSelector</tt>
	 * 
	 * @return Returns the initialInstanceSelector.
	 * @uml.property name="initialInstanceSelector"
	 */
	public IInitialInstanceSelector getInitialInstanceSelector() {
		return initialInstanceSelector;
	}

	/**
	 * Setter of the property <tt>initialInstanceSelector</tt>
	 * 
	 * @param initialInstanceSelector
	 *            The initialInstanceSelector to set.
	 * @uml.property name="initialInstanceSelector"
	 */
	public void setInitialInstanceSelector(
			IInitialInstanceSelector initialInstanceSelector) {
				this.initialInstanceSelector = initialInstanceSelector;
			}

	/**
	 * Returns the RunQueue for a resource instance.
	 */
	public IRunQueue getRunQueueFor(SimResourceInstance instance) {
		return runQueueTable.get(instance);
	}

	/**
	 * Returns the next runnable process for the resource instance.
	 */
	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return getRunQueueFor(instance).getNextRunnableProcess();
	}

	/**
	 * Adds a new process to the runqueue. The process is added using the strategy of the runqueue.
	 * 
	 * TODO: Evaluate the influence of different adding strategies.
	 */
	@Override
	public void addNewProcess(ActiveProcess process) {
		SimResourceInstance instance = initialInstanceSelector.selectInstanceFor(process);
		getRunQueueFor(instance).addProcess(process);
	}


	/**
	 * Moves the given process from the runqueue of the src instance to the runqueue of the dest instance.
	 * 
	 * TODO: Check if the process has been in the src's runqueue.
	 * 
	 * @param process Process to be moved.
	 * @param src Source resource instance.
	 * @param dest Destination resource instance.
	 */
	public void move(ActiveProcess process, SimResourceInstance src, SimResourceInstance dest) {
		getRunQueueFor(src).removeProcess(process);
		getRunQueueFor(dest).addProcess(process);
	}

}
