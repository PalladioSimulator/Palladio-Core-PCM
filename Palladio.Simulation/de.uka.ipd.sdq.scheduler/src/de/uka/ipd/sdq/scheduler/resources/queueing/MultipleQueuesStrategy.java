package de.uka.ipd.sdq.scheduler.resources.queueing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.resources.balancing.ILoadBalancer;


public class MultipleQueuesStrategy implements IQueueingStrategy {

	/**
	 * @uml.property   name="loadBalancer"
	 * @uml.associationEnd   aggregation="composite" inverse="scheduler:de.uka.ipd.sdq.capra.simulator.resources.ILoadBalancer"
	 */
	private ILoadBalancer loadBalancer;

	/**
	 * @uml.property   name="initialInstanceSelector"
	 * @uml.associationEnd   aggregation="composite" inverse="multipleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources.IInitialInstanceSelector"
	 */
	private IInstanceSelector instanceSelector;

	private Hashtable<SimResourceInstance, IRunQueue> runQueueTable;
	
	public MultipleQueuesStrategy(Collection<SimResourceInstance> allInstances, IRunQueue prototypeRunQueue, IInstanceSelector initialInstanceSelector, ILoadBalancer loadBalancer){
		runQueueTable = new Hashtable<SimResourceInstance, IRunQueue>();
		this.instanceSelector = initialInstanceSelector;
		this.loadBalancer = loadBalancer;
		for (SimResourceInstance resourceInstance : allInstances) {
			runQueueTable.put(resourceInstance, prototypeRunQueue.createNewInstance());
		}
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
	 * Adds a process to the runqueue. The process is added using the strategy of the runqueue.
	 * 
	 * A process is added after its creation or after waiting.
	 * 
	 * TODO: Evaluate the influence of different adding strategies.
	 */
	@Override
	public void addProcess(ActiveProcess process) {
		SimResourceInstance instance = instanceSelector.selectInstanceFor(process);
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

	@Override
	public void balance() {
		loadBalancer.balance();
	}


	public Collection<SimResourceInstance> getResourceInstances() {
		return this.runQueueTable.keySet();
	}


	public boolean isIdle(SimResourceInstance instance) {
		return getRunQueueFor(instance).isEmpty();
	}
	
	/**
	 * Returns all queues without jobs.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	public List<SimResourceInstance> getIdleInstances() {
		List<SimResourceInstance> idleInstances = new ArrayList<SimResourceInstance>();
		for (SimResourceInstance instance : getResourceInstances()) {
			if (isIdle(instance))
				idleInstances.add(instance);
		}
		return idleInstances;
	}


	@Override
	public ActiveProcess getProcessRunningOn(SimResourceInstance instance) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void returnActive(ActiveProcess running, boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void returnExpired(ActiveProcess running, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
