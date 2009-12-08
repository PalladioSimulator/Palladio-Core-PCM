package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

public class TaskManager {
	
	private static TaskManager instance = null;

	public static synchronized TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}
	
	private TaskManager() {
		rootTasks = new ArrayList<AbstractTaskExecuter>();
		rootTaskFinishIndicators = new ArrayList<TaskFinishIndicator>(); 
	}
	
	private ArrayList<AbstractTaskExecuter> rootTasks = null;
	private ArrayList<TaskFinishIndicator> rootTaskFinishIndicators = null;

	public boolean prepareTasks(RmiAbstractTask rootTask,int numberOfIterations) {
		TaskFinishIndicator finishIndicator = new TaskFinishIndicator(); 
		rootTasks.add(TaskExecuterFactory.getInstance().convertTask(rootTask, numberOfIterations, finishIndicator));
		rootTaskFinishIndicators.add(finishIndicator);
		return true;	
	}

	public boolean executeTasks(int taskId, int numberOfIterationsToRun) {
		AbstractTaskExecuter rootTaskExecuter = null;
		for (AbstractTaskExecuter task : rootTasks) {
			if (task.getTask().getId() == taskId) {
				rootTaskExecuter = task;
				break;
			}
		}
		if (rootTaskExecuter == null) {
			if (DriverLogger.DEBUG) {
				DriverLogger.logDebugError("Root task executer null!");
			}
			fireTaskExecutionFailed(taskId, 0);
			return false;
		}
		
		rootTaskExecuter.addTaskListener(new TaskListener() {
			public void taskCompleted(int taskId, int completedIterations) {
				fireTaskCompleted(taskId, completedIterations);
			}

			public void taskExecutionFailed(int taskId, int completedIterations) {
				fireTaskExecutionFailed(taskId, completedIterations);
			}
		});
		rootTaskExecuter.setNumberOfIterationsToRun(numberOfIterationsToRun);
		new Thread(rootTaskExecuter).start();
		return true;
	}
	
	public AbstractTaskExecuter getRootTask(int rootTaskId) {
		for (AbstractTaskExecuter rootTaskExecuter : rootTasks) {
			if (rootTaskExecuter.getTask().getId() == rootTaskId) {
				return rootTaskExecuter;
			}
		}
		return null;
	}
	
	/**
	 * Clear all data structures of the prepared task. This also involves deleting all results stored
	 * in the task data structures.
	 */
	public void clearPreparedTasks() {
		for (AbstractTaskExecuter rootTask : rootTasks) {
			rootTask.cleanup();
		}
		rootTasks.clear();
		rootTaskFinishIndicators.clear();
		TaskResultStorage.getInstance().cleanup();
	}
	
	public void storeAllResults() {
		
		for (AbstractTaskExecuter rootTaskExecuter : rootTasks) {
			rootTaskExecuter.storeResults();
		}
	}
	
	public void finishTask(int taskId) {
		AbstractTaskExecuter rootTaskExecuter = null;
		TaskFinishIndicator rootTaskFinishIndicator = null;
		for (int i=0; i<rootTasks.size(); i++) {
			if (rootTasks.get(i).getTask().getId() == taskId) {
				rootTaskExecuter = rootTasks.get(i);
				rootTaskFinishIndicator = rootTaskFinishIndicators.get(i);
				break;
			}
		}
		if (rootTaskExecuter == null) {
			return;
		}
		rootTaskFinishIndicator.setFinishSignal(true);
	}
	
	//
	// Event handling
	//

	private transient Vector<TaskListener> taskListeners;

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
	
	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	protected void fireTaskExecutionFailed(int taskId, int completedIterations) {
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
				l.taskExecutionFailed(taskId, completedIterations);
			}
		}
	}
	
}
