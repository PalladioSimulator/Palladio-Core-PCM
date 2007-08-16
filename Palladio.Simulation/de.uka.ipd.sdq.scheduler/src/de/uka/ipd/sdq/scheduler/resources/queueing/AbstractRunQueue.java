package de.uka.ipd.sdq.scheduler.resources.queueing;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;


public abstract class AbstractRunQueue implements IRunQueue {
	
	protected List<ActiveProcess> runningList;
	
	protected AbstractRunQueue(){
		runningList = new ArrayList<ActiveProcess>();
	}

	public int getCurrentLoad(){
		return runningList.size() + numWaitingProcesses();
	}

	/**
	 * Template Method.
	 * @return
	 */
	protected abstract int numWaitingProcesses();

	/**
	 * Template method.
	 * @return
	 */
	public abstract ActiveProcess getNextRunnableProcess();
	
	public void notifyRunning(ActiveProcess process){
		removePendingProcess(process);
		runningList.add(process);
		process.setRunning();
	}

	public boolean isEmpty(){
		return getCurrentLoad() == 0;
	}

	public void removeProcess(ActiveProcess process){
		switch (process.getState()) {
		case RUNNING: runningList.remove(process);
			break;
		default: removePendingProcess(process);
			break;
		}
	}

	/**
	 * Template method.
	 * @param process
	 */
	protected abstract void removePendingProcess(ActiveProcess process);

	public abstract void returnActiveProcess(ActiveProcess process, boolean inFront);

	public abstract void returnExpiredProcess(ActiveProcess process, boolean inFront);

	public abstract void addProcess(ActiveProcess process);
}
