package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

public class TaskManager {
	
	private static TaskManager instance = null;

	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}
	
	private TaskManager() {
		rootTasks = new ArrayList<AbstractTaskExecuter>();
	}
	
	private ArrayList<AbstractTaskExecuter> rootTasks = null;

	public boolean prepareTasks(RmiAbstractTask rootTask, boolean autostartExecution, int numberOfIterations) {
		if (autostartExecution == false) {
			return prepareTask(rootTask, numberOfIterations);
		}
		boolean result = prepareTask(rootTask, numberOfIterations);
		if (result == false) {
			/*try {
				Host.logError("Task preparation failed.");
				Host.getInstance().getMaster().executionFailed("Task preparation failed.");
			} catch (RemoteException e) {
				Host.logError("Failed to call Master.");
			}*/
			return false;
		} else {
			/*try {
				Host.getInstance().getMaster().startingExecution();
			} catch (RemoteException e) {
				Host.logError("Failed to call Master.");
			}*/
			return executeTasks(rootTask.getId());
		}
	}

	private boolean prepareTask(RmiAbstractTask task, int numberOfIterations) {
		rootTasks.add(TaskExecuterFactory.getInstance().convertTask(task, numberOfIterations));
		return true;
	}
	
	public boolean executeTasksAsync(int taskId, boolean allIterations) {
		AbstractTaskExecuter rootTaskExecuter = null;
		for (AbstractTaskExecuter task : rootTasks) {
			if (task.getTask().getId() == taskId) {
				rootTaskExecuter = task;
				break;
			}
		}
		if (rootTaskExecuter == null) {
			/*Host.logError("Root task executer null!");
			try {
				Host.getInstance().getMaster().executionFailed("Root task executer null!");
			} catch (RemoteException e) {
				Host.logError("Failed to call Master.");
			}*/
			return false;
		}
		rootTaskExecuter.addTaskListener(new TaskListener() {
			public void taskCompleted(int taskId, int completedIterations) {
				//Host.getInstance().allTasksCompleted(rootTaskExecuter);
				fireTaskCompleted(taskId, completedIterations);
			}
		});
		rootTaskExecuter.setPerformAllIterations(allIterations);
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
		
	private boolean executeTasks(int taskId) {
		AbstractTaskExecuter rootTaskExecuter = null;
		for (AbstractTaskExecuter task : rootTasks) {
			if (task.getTask().getId() == taskId) {
				rootTaskExecuter = task;
				break;
			}
		}
		if (rootTaskExecuter == null) {
			return false;
		}
		rootTaskExecuter.run();
		System.out.println("All tasks executed.");

		return true;
	}
	
	/**
	 * Clear all data structures of the prepared task. This also involves deleting all results stored
	 * in the task data structures.
	 */
	public void clearPreparedTasks() {
		rootTasks.clear();
		/*preparedGuestTasks.clear();
		totalNumberOfTasks = 0L;
		currentTaskNumber = 0L;
		for (GuestInterface guest : MidisHost.getInstance().getGuests()) {
			try {
				guest.cleanup();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		executerId = 0L;*/
	}
	
	//private HashMap<Integer, AbstractTaskExecuter> taskExecuters = null;

	
	public HashMap<Integer, ArrayList<RmiResult>> getResults(int rootTaskId) {
		AbstractTaskExecuter taskExecuter = getRootTask(rootTaskId);
		taskExecuter.storeResults();
		return TaskResultStorage.getInstance().getAllResults();
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
	
}
