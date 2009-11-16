package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

public class TaskManager {
	
	private static TaskManager instance = null;

	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}

	private TaskManager() {
	}
	
	private AbstractTaskExecuter rootTaskExecuter = null;
	
	public boolean prepareTasks(RmiAbstractTask rootTask, boolean autostartExecution) {
		//clearPreparedTasks();
		if (autostartExecution == false) {
			return prepareTask(rootTask);
		}
		boolean result = prepareTask(rootTask);
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
			return executeTasks();
		}
	}

	private boolean prepareTask(RmiAbstractTask task) {
		rootTaskExecuter = TaskExecuterFactory.getInstance().convertTask(task, 1);
		return true;
	}
	
	public boolean executeTasks() {
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
			}
		});
		new Thread(rootTaskExecuter).start();
		return true;
	}

}
