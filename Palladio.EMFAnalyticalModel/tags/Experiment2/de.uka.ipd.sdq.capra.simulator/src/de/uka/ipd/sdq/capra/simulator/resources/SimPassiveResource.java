package de.uka.ipd.sdq.capra.simulator.resources;

import java.util.ArrayDeque;
import java.util.Queue;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;

public class SimPassiveResource extends AbstractSimResource{
	
	private class WaitingFor {
		public SimCapraProcess process;
		public int num;
		
		public WaitingFor(SimCapraProcess process, int num) {
			super();
			this.process = process;
			this.num = num;
		}
	}
	
	private Queue<WaitingFor> waitingQueue = new ArrayDeque<WaitingFor>();
	
	public SimPassiveResource(String name, int capacity) {
		super(name, capacity);
	}

	public void init(){
	}
	
	public void acquire(SimCapraProcess capraProcess, int num){
		if (num <= capacity) {
			capacity -= num;
			capraProcess.proceed();
		} else {
			waitingQueue.add(new WaitingFor( capraProcess, num) );
		}
	}
	
	public void release(SimCapraProcess capraProcess, int num){
		capacity += num;
		ProceedEvent predecessor = null;
		while( (waitingQueue.size()>0) && (waitingQueue.peek().num <= capacity)){
			WaitingFor waitingProcess = waitingQueue.poll();
			capacity -= waitingProcess.num;
			ProceedEvent proceedEvent = new ProceedEvent(waitingProcess.process);
			saveScheduleAfter(proceedEvent, predecessor);
			predecessor = proceedEvent;
		}
		ProceedEvent proceedEvent = new ProceedEvent(capraProcess);
		saveScheduleAfter(proceedEvent, predecessor);
	}

	private void saveScheduleAfter(ProceedEvent proceedEvent, ProceedEvent predecessor) {
		if (predecessor == null){
			proceedEvent.scheduleNext();
		} else {
			proceedEvent.scheduleAfter(predecessor);
		}
	}
}
