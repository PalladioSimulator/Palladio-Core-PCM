package de.uka.ipd.sdq.scheduler.resources.queueing;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public class PriorityArray {
	
	private ProcessQueue<ProcessWithPriority>[] priorityArray;
	
	public PriorityArray(IPriorityManager priorityManager){
		this.priorityManager = priorityManager;
		this.priorityArray = new ProcessQueue[priorityManager.getNumPriorities()];
		for(int i=0; i<priorityArray.length; i++){
			priorityArray[i] = new ProcessQueue<ProcessWithPriority>();
		}
	}


	/**
	 * @uml.property   name="priorityManager"
	 * @uml.associationEnd   aggregation="shared" inverse="priorityArray:de.uka.ipd.sdq.capra.simulator.resources.IPriorityManager"
	 */
	private IPriorityManager priorityManager;

	/**
	 * Getter of the property <tt>priorityManager</tt>
	 * 
	 * @return Returns the manager.
	 * @uml.property name="priorityManager"
	 */
	public IPriorityManager getPriorityManager() {
		return priorityManager;
	}

	/**
	 * Setter of the property <tt>priorityManager</tt>
	 * 
	 * @param priorityManager
	 *            The manager to set.
	 * @uml.property name="priorityManager"
	 */
	public void setPriorityManager(IPriorityManager priorityManager) {
		this.priorityManager = priorityManager;
	}

	/**
	 * Moves the process to its new queue.
	 */
	public void notifyPriorityChanged(ProcessWithPriority process,
			int from_prio, int to_prio) {
		getQueue(from_prio).remove(process);
		addToQueueAfterPriorityChange(to_prio, process);

	}

	/**
	 * Inserts a process into a new queue after its priority changed. Currently
	 * the process is added to the end of the queue. If changes are necessary,
	 * this method can be extracted as a template or strategy.
	 * 
	 * @param to_prio
	 * @param process
	 */
	private void addToQueueAfterPriorityChange(int to_prio,
			ProcessWithPriority process) {
		getQueue(to_prio).addLast(process);
	}

	/**
	 * Returns the number of processes in the priority array.
	 */
	@SuppressWarnings("unchecked")
	public int getNumberOfProcesses() {
		int num = 0;
		for (ProcessQueue queue : this.priorityArray) {
			num += queue.getNumberOfProcesses();
		}
		return num;
	}

	/**
	 * @return True, if the priority array is empty. False, otherwise.
	 */
	@SuppressWarnings("unchecked")
	public boolean isEmpty() {
		for (ProcessQueue queue : this.priorityArray) {
			if (queue.isEmpty())
				return false;
		}
		return true;
	}

	/**
	 * @return Returns the queue with the highest priority which is not empty.
	 *         Null if all queues are empty.
	 */
	public ProcessQueue<ProcessWithPriority> getNonEmptyQueueWithHighestPriority() {
		for (int prio = priorityManager.getHighestPriority(); !this.priorityManager
				.outOfBounds(prio); prio = this.priorityManager.nextLower(prio)) {
			if (!getQueue(prio).isEmpty())
				return getQueue(prio);
		}
		return null;
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
	 * @param process
	 */
	public void addLast(ActiveProcess process) {
		assert process instanceof ProcessWithPriority : "Only 'ProcessWithPriority' instances are allowed for PriorityArrays!";
		getQueueFor((ProcessWithPriority)process).addLast((ProcessWithPriority)process);
	}
	
	/**
	 * Adds a new process at the BEGINNING of the process' priority's queue.
	 * @param process
	 */
	public void addFirst(ActiveProcess process) {
		assert process instanceof ProcessWithPriority : "Only 'ProcessWithPriority' instances are allowed for PriorityArrays!";
		getQueueFor((ProcessWithPriority)process).addFirst((ProcessWithPriority)process);
	}

	/**
	 * Returns the queue of the process' priority.
	 * 
	 * @param process
	 * @return Queue for the given process.
	 */
	public ProcessQueue<ProcessWithPriority> getQueueFor(
			ProcessWithPriority process) {
		return getQueue(process.getCurrentPriority());
	}

	private ProcessQueue<ProcessWithPriority> getQueue(int prio) {
		int pos = priorityManager.getPosition(prio);
		return priorityArray[pos];
	}
}
