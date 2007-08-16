package de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.priorityarrays;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.queueing.ProcessQueue;


public class SinglePriorityArrayRunQueue extends AbstractPriorityArrayRunQueue  {
	
	/**
	 * @uml.property   name="priorityArray"
	 * @uml.associationEnd   aggregation="composite" inverse="singlePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources.PriorityArray"
	 */
	private PriorityArray priorityArray;

	public SinglePriorityArrayRunQueue(IPriorityManager priorityManager) {
		super(priorityManager);
		this.priorityArray = new PriorityArray(priorityManager);
	}

	/** 
	 * Getter of the property <tt>priorityArray</tt>
	 * @return  Returns the priorityArray.
	 * @uml.property  name="priorityArray"
	 */
	public PriorityArray getPriorityArray() {
		return priorityArray;
	}

	/** 
	 * Setter of the property <tt>priorityArray</tt>
	 * @param priorityArray  The priorityArray to set.
	 * @uml.property  name="priorityArray"
	 */
	public void setPriorityArray(PriorityArray priorityArray) {
		this.priorityArray = priorityArray;
	}

	/**
	 * Adds the process to the end of the priority array's queue.
	 */
	@Override
	public void addProcess(ActiveProcess process) {
		priorityArray.addLast(process);
	}

	@Override
	protected int numWaitingProcesses() {
		return priorityArray.getNumberOfProcesses();
	}

	@Override
	public ActiveProcess getNextRunnableProcess() {
		if(priorityArray.isEmpty())
			return null;
		return priorityArray.getNonEmptyQueueWithHighestPriority().peek();
	}

	@Override
	protected void removePendingProcess(ActiveProcess process) {
		priorityArray.removeProcess(process);
	}

	@Override
	public void returnExpiredProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process,inFront);
	}

	@Override
	public void returnActiveProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process, inFront);
		
	}
	private void returnProcess(ActiveProcess process, boolean inFront) {
		if(inFront){
			priorityArray.addFirst(process);
		} else {
			priorityArray.addLast(process);
		}
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SinglePriorityArrayRunQueue(this.priorityManager);
	}

	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance targetInstance) {
		List<ActiveProcess> processList = new ArrayList<ActiveProcess>();
		addMovableProcesses(priorityArray, targetInstance, processList);
		return processList;
	}

	@Override
	public ProcessQueue<ActiveProcess> getUrgentQueue(
			SimResourceInstance instance) {
		return this.priorityArray.getUrgentQueue(instance);
	}
}
