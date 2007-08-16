package de.uka.ipd.sdq.capra.simulator.resources;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractRunQueue implements IRunQueue {
	
	protected List<ActiveProcess> runningList;
	
	protected List<ActiveProcess> standbyList;
	
	
	protected AbstractRunQueue(){
		runningList = new ArrayList<ActiveProcess>();
		standbyList = new ArrayList<ActiveProcess>();
	}

	public int getCurrentLoad(){
		return runningList.size() + standbyList.size() + numWaitingProcesses();
	}

	/**
	 * Template Method.
	 * @return
	 */
	protected abstract int numWaitingProcesses();

	public ActiveProcess getNextRunnableProcess(){
		ActiveProcess process = pollNextRunnableProcess();
		process.setStandby();
		standbyList.add(process);
		return process;
	}

	/**
	 * Template method.
	 * @return
	 */
	protected abstract ActiveProcess pollNextRunnableProcess();
	
	public void notifyRunning(ActiveProcess process){
		assert standbyList.contains(process) : "Process " + process.getName() + " not in standby list!";
		standbyList.remove(process);
		process.setRunning();
		runningList.add(process);
	}

	public boolean isEmpty(){
		return getCurrentLoad() == 0;
	}

	public void removeProcess(ActiveProcess process){
		switch (process.getState()) {
		case RUNNING: runningList.remove(process);
			break;
		case STANDBY: standbyList.remove(process);
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
