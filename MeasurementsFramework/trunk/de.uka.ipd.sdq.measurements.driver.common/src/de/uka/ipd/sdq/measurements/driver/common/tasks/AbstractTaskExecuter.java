package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.Enumeration;
import java.util.Vector;

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

	protected AbstractTaskExecuter(RmiAbstractTask task, int numberOfIterations) {
		this();
		this.task = task;
		this.numberOfIterations = numberOfIterations;
		startTimes = new long[numberOfIterations];
		endTimes = new long[numberOfIterations];
	}

	protected RmiAbstractTask task = null;
	protected int numberOfIterations = 1;
	protected int numberOfExecutedIterations = 0;

	public RmiAbstractTask getTask() {
		return task;
	}
	
	
	
	private synchronized void work() {
		startSystemTime = System.currentTimeMillis();
		startSystemNanoTime = System.nanoTime();
		if (performAllIterations == true) {
			for (numberOfExecutedIterations=0; numberOfExecutedIterations<numberOfIterations; numberOfExecutedIterations++) {
				startTimes[numberOfExecutedIterations] = System.nanoTime();
				doWork(numberOfExecutedIterations);
				endTimes[numberOfExecutedIterations] = System.nanoTime();
				numberOfExecutedTasks++;
				if (finishSignal == true) {
					break;
				}
			}
		} else {
			startTimes[numberOfExecutedIterations] = System.nanoTime();
			doWork(numberOfExecutedIterations);
			endTimes[numberOfExecutedIterations] = System.nanoTime();
			numberOfExecutedIterations++;
			numberOfExecutedTasks++;
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
	
	public void run() {
		this.work();
		fireTaskCompleted(task.getId(), numberOfExecutedTasks);
	}
	
	public abstract void storeResults();
	
	public void cleanup() {
		System.out.println("Clenaing up...");
		doCleanup();
		startTimes = new long[numberOfIterations];
		endTimes = new long[numberOfIterations];
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
	
	public boolean signalizeFinish() {
		finishSignal = true;
		return true;
	}

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
