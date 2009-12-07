package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.Enumeration;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

public abstract class AbstractTaskExecuter extends Thread implements TaskExecuter {

	/**
	 * The default constructor is private and therefore must not be used.
	 */
	private AbstractTaskExecuter() {
	}

	
	private long[] startTimes;
	private long[] endTimes;
	private long startSystemTime = 0L;
	private long startSystemNanoTime = 0L;
	private boolean performAllIterations = true;
	private int numberOfExecutedTasks = 0;
	protected boolean finishSignal = false;
	protected FinishIndicator finishIndicator;
	private boolean doMeasuring = false;
	
	protected AbstractTaskExecuter(RmiAbstractTask task, int numberOfIterations, FinishIndicator finishIndicator) {
		this();
		this.task = task;
		doMeasuring = task.getSensor();
		this.finishIndicator = finishIndicator;
		this.numberOfIterations = numberOfIterations;
		if (doMeasuring) {
			startTimes = new long[numberOfIterations];
			endTimes = new long[numberOfIterations];
		}
	}

	protected RmiAbstractTask task = null;
	protected int numberOfIterations = 1;
	//protected int numberOfExecutedIterations = 0;

	public RmiAbstractTask getTask() {
		return task;
	}
	
	private synchronized void work(int numberOfIterationsToRun) {
		if (doMeasuring) {
			startSystemTime = System.currentTimeMillis();
			startSystemNanoTime = System.nanoTime();
		}
		if (performAllIterations == true) {
			for (int numberOfExecutedIterations=0; numberOfExecutedIterations<numberOfIterations; numberOfExecutedIterations++) {
				if (doMeasuring) {
					startTimes[numberOfExecutedIterations] = System.nanoTime();
				}
				doWork(numberOfExecutedIterations);
				if (doMeasuring) {
					endTimes[numberOfExecutedIterations] = System.nanoTime();
				}
				numberOfExecutedTasks++;
				if ((finishIndicator != null) && (finishIndicator.getFinishSignal())) {
				//if (finishSignal == true) {
					signalizeFinish();
					break;
				}
			}
		} else {
			int numberOfExecutedIterations=0;
			for (int i=numberOfExecutedTasks; i<(numberOfExecutedTasks+numberOfIterationsToRun); i++) {
				if (doMeasuring) {
					startTimes[i] = System.nanoTime();
				}
				doWork(i);
				if (doMeasuring) {
					endTimes[i] = System.nanoTime();
				}
				numberOfExecutedIterations++;
				//if (finishSignal == true) {
				if ((finishIndicator != null) && (finishIndicator.getFinishSignal())) {
					signalizeFinish();
					break;
				}
			}
			numberOfExecutedTasks += numberOfExecutedIterations;
		}
	}
	
	public boolean prepare() {
		for (int i=0; i<numberOfIterations; i++) {
			if (!prepare(i)) {
				return false;
			}
		}
		return true;
	}
	
	protected abstract boolean prepare(int iteration);
	
	protected abstract void doWork(int iteration);
		
	public int runSynchronously(int numberOfIterationsToRun, boolean fireUponFinish) {
		work(numberOfIterationsToRun);
		if (fireUponFinish) {
			fireTaskCompleted(task.getId(), numberOfExecutedTasks);
		}
		return numberOfExecutedTasks;
	}
	
	public void run() {
		this.work(numberOfIterations);
		fireTaskCompleted(task.getId(), numberOfExecutedTasks);
	}
	
	public abstract void storeResults();
	
	public void cleanup() {
		if (DriverLogger.DEBUG) {
			DriverLogger.logDebug("Cleaning up...");
		}
		doCleanup();
		startTimes = null;
		endTimes = null;
		task = null;
	}
	
	protected abstract void doCleanup();
		
	public RmiResult getTaskResult() {
		if (task.getSensor() == false) {
			return null;
		}
		RmiResult result = new RmiResult(task);
		long[] results = new long[numberOfExecutedTasks];
		for (int i=0; i<numberOfExecutedTasks; i++) {
			results[i] = endTimes[i] - startTimes[i];
		}
		result.setResults(results);
		return result;
	}
	
	protected abstract void signalizeFinish();/* {
		finishSignal = true;
		return true;
	}*/

	public void setPerformAllIterations(boolean allIterations) {
		performAllIterations = allIterations;
		
	}
	

	//
	// Event handling
	//

	private transient Vector<TaskListener> taskListeners;

	/** Register a listener for MasterModel events */
	synchronized public void addTaskListener(TaskListener listener) {
		if (taskListeners == null) {
			taskListeners = new Vector<TaskListener>();
		}
		taskListeners.addElement(listener);
	}

	synchronized public void removeTaskListener(TaskListener listener) {
		if (taskListeners == null) {
			taskListeners = new Vector<TaskListener>();
		}
		taskListeners.removeElement(listener);
	}

	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	protected void fireTaskCompleted(int taskId, int completedIterations) {
		// If we have no listeners, do nothing.
		if ((taskListeners != null) && !taskListeners.isEmpty()) {

			// Make a copy of the listener list in case anyone adds or removes
			// listeners.
			Vector<TaskListener> targets;
			synchronized (taskListeners) {
				targets = (Vector<TaskListener>) taskListeners.clone();
			}

			// Walk through the listener list and call the listener method in
			// each.
			Enumeration<TaskListener> e = targets.elements();
			while (e.hasMoreElements()) {
				TaskListener l = (TaskListener) e.nextElement();
				l.taskCompleted(taskId, completedIterations);
			}
		}
	}

}
