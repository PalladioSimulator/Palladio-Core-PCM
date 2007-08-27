package de.uka.ipd.sdq.scheduler.queueing.runqueues.priorityarrays;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;

public class PriorityArray {

	private Hashtable<IPriority, ProcessQueue<ProcessWithPriority>> priorityTable;
	private IPriorityManager priorityManager;

	public PriorityArray(IPriorityManager priorityManager) {
		this.priorityManager = priorityManager;
		this.priorityTable = new Hashtable<IPriority, ProcessQueue<ProcessWithPriority>>();
		for (IPriority prio : priorityManager.decreasing()) {
			priorityTable.put(prio, new ProcessQueue<ProcessWithPriority>());
		}
	}

	/**
	 * Returns the number of processes in the priority array.
	 */
	@SuppressWarnings("unchecked")
	public int getNumberOfProcesses() {
		int num = 0;
		for (ProcessQueue queue : priorityTable.values()) {
			num += queue.size();
		}
		return num;
	}

	/**
	 * @return True, if the priority array is empty. False, otherwise.
	 */
	@SuppressWarnings("unchecked")
	public boolean isEmpty() {
		for (ProcessQueue queue : priorityTable.values()) {
			if (!queue.isEmpty())
				return false;
		}
		return true;
	}

	/**
	 * Removes the given process from the priorityarray.
	 * 
	 * @param process
	 * @return True, if the process has been successfully removed. False,
	 *         otherwise.
	 */
	public boolean removeProcess(ActiveProcess process) {
		assert process instanceof ProcessWithPriority : "Only 'ProcessWithPriority' instances are allowed for PriorityArrays!";
		return getQueueFor((ProcessWithPriority) process).remove(
				(ProcessWithPriority) process);
	}

	/**
	 * Adds a new process at the END of the process' priority's queue.
	 * 
	 * @param process
	 */
	public void addLast(ActiveProcess process) {
		add(process,false);
	}

	/**
	 * Adds a new process at the BEGINNING of the process' priority's queue.
	 * 
	 * @param process
	 */
	public void addFirst(ActiveProcess process) {
		add(process,true);
	}

	public void add(ActiveProcess process, boolean inFront) {
		assert process instanceof ProcessWithPriority : "Only 'ProcessWithPriority' instances are allowed for PriorityArrays!";
		ProcessWithPriority prio_process = (ProcessWithPriority) process;
		getQueueFor(prio_process).add(prio_process,inFront);
	}

	/**
	 * Returns the queue of the process' priority.
	 * 
	 * @param process
	 * @return Queue for the given process.
	 */
	public ProcessQueue<ProcessWithPriority> getQueueFor(
			ProcessWithPriority process) {
		return getQueue(process.getDynamicPriority());
	}

	/**
	 * @return Returns the queue with the highest priority which is not empty.
	 *         Null if all queues are empty.
	 */
	public ProcessQueue<ProcessWithPriority> getNonEmptyQueueWithHighestPriority() {
		for (IPriority prio : priorityManager.decreasing()) {
			if (!getQueue(prio).isEmpty())
				return getQueue(prio);
		}
		return null;
	}

	public IPriority getLowestPriorityWithNonEmptyQueue() {
		return getFirstNonEmptyPriority(priorityManager.increasing());
	}

	public IPriority getHighestPriorityWithNonEmptyQueue() {
		return getFirstNonEmptyPriority(priorityManager.decreasing());
	}

	private IPriority getFirstNonEmptyPriority(Iterable<IPriority> direction) {
		for (IPriority prio : direction) {
			if (!getQueue(prio).isEmpty())
				return prio;
		}
		return null;
	}

	public ProcessQueue<ProcessWithPriority> getQueue(IPriority prio) {
		return priorityTable.get(prio);
	}

	/**
	 * Returns the queue with the highest priority of which at least one process
	 * can be executed on instance.
	 * 
	 * @param instance
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ProcessQueue<ActiveProcess> getBestRunnableQueue(
			IResourceInstance instance) {
		for (IPriority prio : priorityManager.decreasing()) {
			for (ActiveProcess process : getQueue(prio).ascending()) {
				if (process.checkAffinity(instance))
					return (ProcessQueue) getQueue(prio);
			}
		}
		return null;
	}

	/**
	 * Returns the process with the highest priority runnable on the given instance.
	 * @param instance
	 * @return
	 */
	public ActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		for (IPriority prio : priorityManager.decreasing()) {
			for (ActiveProcess process : getQueue(prio).ascending()) {
				if (process.checkAffinity(instance))
					return process;
			}
		}
		return null;
	}

	public boolean contains(ActiveProcess process) {
		for (ProcessQueue<ProcessWithPriority> queue : priorityTable.values()) {
			if (queue.contains(process))
				return true;
		}
		return false;
	}

	public ActiveProcess getNextRunnableProcess() {
		return getNonEmptyQueueWithHighestPriority().peek();
	}

	/**
	 * Adds processes that do not violate the affinity constraint to the list
	 * in the specified direction.
	 * 
	 * @param targetInstance
	 */
	public List<ActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<ActiveProcess> processList = new ArrayList<ActiveProcess>(); 
		Iterable<IPriority> prio_direction = prio_increasing ? priorityManager.increasing() : priorityManager.decreasing(); 
		for (IPriority prio : prio_direction) {
			Iterable<ProcessWithPriority> queue_direction = queue_ascending ? getQueue(prio).ascending() : getQueue(prio).descending();
			for (ActiveProcess process : queue_direction) {
				if (process.checkAffinity(targetInstance)) {
					processList.add(process);
					if (processList.size() >= processes_needed)
						break;
				}
			}
		}
		return processList;
	}
}
