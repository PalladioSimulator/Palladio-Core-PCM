package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.strategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IInstanceSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.ILoadBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.active.SimResourceInstance;

public class MultipleQueuesStrategy implements IQueueingStrategy {

	private ILoadBalancer loadBalancer;
	private IInstanceSelector instanceSelector;
	private Hashtable<IResourceInstance, IRunQueue> runQueueTable;
	private boolean in_front_when_balancing;

	public MultipleQueuesStrategy(Collection<IResourceInstance> allInstances,
			IRunQueue prototypeRunQueue,
			IInstanceSelector initialInstanceSelector,
			ILoadBalancer loadBalancer,
			boolean in_front_when_balancing) {
		runQueueTable = new Hashtable<IResourceInstance, IRunQueue>();
		this.instanceSelector = initialInstanceSelector;
		this.loadBalancer = loadBalancer;
		this.in_front_when_balancing = in_front_when_balancing;
		for (IResourceInstance resourceInstance : allInstances) {
			runQueueTable.put(resourceInstance, prototypeRunQueue
					.createNewInstance());
		}
	}

	/**
	 * Returns the RunQueue for a resource instance.
	 */
	public IRunQueue getRunQueueFor(IResourceInstance instance) {
		return runQueueTable.get(instance);
	}

	/**
	 * Returns the next runnable process for the resource instance.
	 */
	
	public IActiveProcess getNextProcessFor(IResourceInstance instance) {
		return getRunQueueFor(instance).getNextRunnableProcess();
	}

	/**
	 * Adds a process to the runqueue. The process is added using the strategy
	 * of the runqueue.
	 * 
	 * A process is added after its creation or after waiting.
	 */
	
	public void addProcess(IActiveProcess process, IResourceInstance current, boolean inFront) {
		registerProcess(process, current);
		getRunQueueFor(process.getLastInstance()).addProcess(process, inFront);
	}

	/**
	 * Moves the given process from the runqueue of the src instance to the
	 * runqueue of the dest instance.
	 * 
	 * @param process
	 *            Process to be moved.
	 * @param src
	 *            Source resource instance.
	 * @param dest
	 *            Destination resource instance.
	 */
	public void move(IActiveProcess process, IResourceInstance src,
			IResourceInstance dest) {
		assert process.getLastInstance().equals(src);
		assert getRunQueueFor(src).contains(process) : "Process '" + process
				+ "' is not in the runqueue of '" + src + "'";
		assert process.getRunQueue() == getRunQueueFor(src) : "Invalid state of runqueues!";
		
		LoggingWrapper.log("Moving " + process + " from " + src + " to " + dest);

		double waiting = getRunQueueFor(src).getWaitingTime(process);
		getRunQueueFor(src).removeProcess(process);
		getRunQueueFor(dest).addProcess(process, in_front_when_balancing);
		getRunQueueFor(dest).setWaitingTime(process, waiting);
		process.wasMovedTo(dest);
	}

	
	public void activelyBalance(IResourceInstance instance) {
		loadBalancer.activelyBalance(instance);
	}

	public Collection<IResourceInstance> getResourceInstances() {
		return this.runQueueTable.keySet();
	}

	public boolean isIdle(IResourceInstance instance) {
		return getRunQueueFor(instance).isEmpty();
	}

	/**
	 * Returns all queues without jobs.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	public List<IResourceInstance> getIdleInstances() {
		List<IResourceInstance> idleInstances = new ArrayList<IResourceInstance>();
		for (IResourceInstance instance : getResourceInstances()) {
			if (isIdle(instance))
				idleInstances.add(instance);
		}
		return idleInstances;
	}

	
	public boolean removePendingProcess(IActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).removePendingProcess(
				process);
	}

	
	public boolean containsPending(IActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).containsPending(
				process);
	}

	
	public void removeRunning(IActiveProcess process) {
		getRunQueueFor(process.getLastInstance()).removeRunning(process);
	}

	
	public IResourceInstance runningOn(IActiveProcess process) {
		for (IResourceInstance instance : runQueueTable.keySet()) {
			if (runQueueTable.get(instance).containsRunning(process)) {
				return instance;
			}
		}
		return null;
	}

	
	public void setRunningOn(IActiveProcess process, IResourceInstance instance) {
		getRunQueueFor(instance).setRunningOn(process, instance);
	}

	public void forkProcess(IActiveProcess process, IResourceInstance current,
			boolean inFront) {
		addProcess(process, current, inFront);
		loadBalancer.onFork(current);
	}
	
	public void registerProcess(IActiveProcess process, IResourceInstance current) {
		IResourceInstance instance = process.getLastInstance();
		if (instance == null) {
			instance = instanceSelector.selectInstanceFor(process,current);
			process.setLastInstance(instance);
			process.setIdealInstance(instance);
		}
	}

	public void fromRunningToWaiting(IActiveProcess process) {
		removeRunning(process);
	}
	
	public void onSleep(IResourceInstance lastInstance) {
		loadBalancer.onSleep(lastInstance);
	}

	public void terminateProcess(IActiveProcess process) {
		removePendingProcess(process);
		loadBalancer.onTerminate(process.getLastInstance());
	}
	
	public void fromWaitingToReady(IActiveProcess process,
			IResourceInstance current, boolean in_front_after_waiting) {
		addProcess(process, current, in_front_after_waiting);

		loadBalancer.onWake(current);
	}

	public List<IActiveProcess> getStarvingProcesses(
			IResourceInstance instance, double starvationLimit){ 
		IRunQueue runQ = getRunQueueFor(instance);
		return runQ.getStarvingProcesses(starvationLimit);
	}

	public void resetStarvationInfo() {
		for(IRunQueue q :  this.runQueueTable.values()){
			q.resetStarvationInfo();
		}
	}

	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return getRunQueueFor(simResourceInstance).getCurrentLoad();
	}


}