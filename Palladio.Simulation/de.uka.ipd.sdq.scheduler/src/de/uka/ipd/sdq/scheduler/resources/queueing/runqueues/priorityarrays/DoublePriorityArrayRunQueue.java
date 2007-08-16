package de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.priorityarrays;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.queueing.ProcessQueue;

public class DoublePriorityArrayRunQueue extends AbstractPriorityArrayRunQueue {

	public DoublePriorityArrayRunQueue(IPriorityManager priorityManager) {
		super(priorityManager);
		this.activePriorityArray = new PriorityArray(priorityManager);
		this.expiredPriorityArray = new PriorityArray(priorityManager);
	}

	/**
	 * @uml.property name="activePriorityArray"
	 * @uml.associationEnd aggregation="composite"
	 *                     inverse="doublePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources.PriorityArray"
	 */
	private PriorityArray activePriorityArray;

	/**
	 * Getter of the property <tt>activePriorityArray</tt>
	 * 
	 * @return Returns the activePriorityArray.
	 * @uml.property name="activePriorityArray"
	 */
	public PriorityArray getActivePriorityArray() {
		return activePriorityArray;
	}

	/**
	 * Setter of the property <tt>activePriorityArray</tt>
	 * 
	 * @param activePriorityArray
	 *            The activePriorityArray to set.
	 * @uml.property name="activePriorityArray"
	 */
	public void setActivePriorityArray(PriorityArray activePriorityArray) {
		this.activePriorityArray = activePriorityArray;
	}

	/**
	 * @uml.property name="expiredPriorityArray"
	 * @uml.associationEnd aggregation="composite"
	 *                     inverse="doublePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources.PriorityArray"
	 */
	private PriorityArray expiredPriorityArray;

	/**
	 * Getter of the property <tt>expiredPriorityArray</tt>
	 * 
	 * @return Returns the expiredPriorityArray.
	 * @uml.property name="expiredPriorityArray"
	 */
	public PriorityArray getExpiredPriorityArray() {
		return expiredPriorityArray;
	}

	/**
	 * Setter of the property <tt>expiredPriorityArray</tt>
	 * 
	 * @param expiredPriorityArray
	 *            The expiredPriorityArray to set.
	 * @uml.property name="expiredPriorityArray"
	 */
	public void setExpiredPriorityArray(PriorityArray expiredPriorityArray) {
		this.expiredPriorityArray = expiredPriorityArray;
	}

	/**
	 * Adds a new process to the end of the expired priority array.
	 */
	@Override
	public void addProcess(ActiveProcess process) {
		expiredPriorityArray.addLast(process);
	}

	@Override
	protected int numWaitingProcesses() {
		return activePriorityArray.getNumberOfProcesses()
				+ expiredPriorityArray.getNumberOfProcesses();
	}

	@Override
	public ActiveProcess getNextRunnableProcess() {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNonEmptyQueueWithHighestPriority().peek();
	}

	private void switchActiveAndExpired() {
		PriorityArray temp = activePriorityArray;
		activePriorityArray = expiredPriorityArray;
		expiredPriorityArray = temp;
	}

	@Override
	protected void removePendingProcess(ActiveProcess process) {
		if (!activePriorityArray.removeProcess(process))
			expiredPriorityArray.removeProcess(process);

	}

	/**
	 * A process whose timeslice expired is inserted to the expired queue.
	 */
	@Override
	public void returnExpiredProcess(ActiveProcess process, boolean inFront) {
		if (inFront) {
			expiredPriorityArray.addFirst(process);
		} else {
			expiredPriorityArray.addLast(process);
		}
	}

	/**
	 * An interrupted process is returned to the active queue.
	 */
	@Override
	public void returnActiveProcess(ActiveProcess process, boolean inFront) {
		if (inFront) {
			activePriorityArray.addFirst(process);
		} else {
			activePriorityArray.addLast(process);
		}

	}

	/**
	 * Determines whether the current active queue is empty including the
	 * running and standby processes.
	 */
	protected boolean activeQueueEmpty() {
		return runningList.isEmpty() && activePriorityArray.isEmpty();
	}

	@Override
	public IRunQueue createNewInstance() {
		return new DoublePriorityArrayRunQueue(priorityManager);
	}

	/**
	 * TODO: allow different strategies for process selection.
	 */
	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance targetInstance) {
		List<ActiveProcess> processList = new ArrayList<ActiveProcess>();
		addMovableProcesses(expiredPriorityArray, targetInstance, processList);
		addMovableProcesses(activePriorityArray, targetInstance, processList);
		return null;
	}

	@Override
	public ProcessQueue<ActiveProcess> getUrgentQueue(
			SimResourceInstance instance) {
		ProcessQueue<ActiveProcess> result = activePriorityArray
				.getUrgentQueue(instance);
		if (result == null) {
			result = expiredPriorityArray.getUrgentQueue(instance);
		}
		return result;
	}

}
