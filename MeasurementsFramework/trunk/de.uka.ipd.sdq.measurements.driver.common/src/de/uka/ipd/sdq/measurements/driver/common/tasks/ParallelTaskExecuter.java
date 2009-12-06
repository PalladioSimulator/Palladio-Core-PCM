package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelTask;

public class ParallelTaskExecuter extends AbstractTaskExecuter {

	private List<AbstractTaskExecuter>[] taskExecuters = null;
	private List<Integer> completedNestedTasks = new ArrayList<Integer>();

	private int numberOfCompletedTasks = 0;
	private boolean stopUponFirstTaskCompleted = true;
	private boolean firstTaskCompleted = false;

	public ParallelTaskExecuter(RmiParallelTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		// MidisHost.logDebug("Preparing parallel task (ID: " + task.getId() +
		// ") ...");
		// stopUponFirstTaskCompleted = task.getStopUponFirstTaskCompleted();
		stopUponFirstTaskCompleted = true;
		// MidisHost.logDebug("Parallel task (ID: " + task.getId() +
		// ") prepared.");

	}

	protected boolean prepare(int iteration) {
		if (taskExecuters == null) {
			taskExecuters = new List[numberOfIterations];
		}
		ArrayList<AbstractTaskExecuter> tasks = new ArrayList<AbstractTaskExecuter>();
		Iterator<RmiAbstractTask> taskIterator = ((RmiParallelTask) task).getTasks().iterator();
		while (taskIterator.hasNext()) {
			RmiAbstractTask rmiTask = taskIterator.next();
			AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(rmiTask, 1);
			taskExecuter.addTaskListener(new TaskListener() {
				public void taskCompleted(int taskId, int completedIterations) {
					synchronized (ParallelTaskExecuter.this) {
						numberOfCompletedTasks++;
						if (stopUponFirstTaskCompleted == true) {
							firstTaskCompleted = true;
						}
						completedNestedTasks.add(taskId);
						ParallelTaskExecuter.this.notify();
					}
				}
			});
			tasks.add(taskExecuter);
		}
		taskExecuters[iteration] = tasks;
		return true;
	}

	protected void doWork(int iteration) {
		numberOfCompletedTasks = 0;
		completedNestedTasks.clear();
		Iterator<AbstractTaskExecuter> taskIterator = taskExecuters[iteration].iterator();
		while (taskIterator.hasNext()) {
			AbstractTaskExecuter taskExecuter = taskIterator.next();
			new Thread(taskExecuter).start();
		}
		while (numberOfCompletedTasks < taskExecuters[iteration].size()) {
			try {
				if (firstTaskCompleted == true) {
					Iterator<AbstractTaskExecuter> taskIterator2 = taskExecuters[iteration].iterator();
					while (taskIterator2.hasNext()) {
						AbstractTaskExecuter taskExecuter = taskIterator2.next();
						if (!completedNestedTasks.contains(taskExecuter.getTask().getId())) {
							try {
								synchronized (taskExecuter) {
									taskExecuter.signalizeFinish();
									taskExecuter.notify();
								}
							} catch (IllegalMonitorStateException e) {
							}
							break;
						}
					}
				}
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		for (int i = 0; i < ((RmiParallelTask) task).getTasks().size(); i++) {
			for (int j = 0; j < numberOfIterations; j++) {
				taskExecuters[j].get(i).storeResults();
			}
		}
	}

	@Override
	protected void doCleanup() {
		if (taskExecuters != null) {
			for (int i = 0; i < taskExecuters.length; i++) {
				for (AbstractTaskExecuter executer : taskExecuters[i]) {
					executer.cleanup();
				}
			}
			taskExecuters = null;
		}
	}

}
