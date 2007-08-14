package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.Deque;



public class ProcessQueue implements IProcessQueue {

	@Override
	public void addLast(RunningProcess process) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RunningProcess peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RunningProcess poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(RunningProcess process) {
		// TODO Auto-generated method stub
		
	}

	
	/** 
	 * @uml.property name="processQueue"
	 * @uml.associationEnd multiplicity="(0 -1)" aggregation="shared" inverse="abstractFCFSQueue:de.uka.ipd.sdq.capra.simulator.resources_new.RunningProcess"
	 */
	private Deque<RunningProcess> processQueue;

	/**
	 * Getter of the property <tt>processQueue</tt>
	 * @return  Returns the runningProcess.
	 * @uml.property  name="processQueue"
	 */
	public Deque<RunningProcess> getProcessQueue() {
		return processQueue;
	}

	/**
	 * Setter of the property <tt>processQueue</tt>
	 * @param processQueue  The runningProcess to set.
	 * @uml.property  name="processQueue"
	 */
	public void setProcessQueue(Deque<RunningProcess> processQueue) {
		this.processQueue = processQueue;
	}



}
