package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;

public class LoopTaskExecuter extends AbstractTaskExecuter {

	private List<AbstractTaskExecuter> tasks = new ArrayList<AbstractTaskExecuter>();
	private Thread[] taskThreads = null;

	public LoopTaskExecuter(RmiLoopTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		//MidisHost.logDebug("Preparing loop task (ID: " + task.getId() + ") ...");
			
		//MidisHost.logDebug("Loop task (ID: " + task.getId() + ") prepared.");
	}

	@Override
	protected void prepare(int iteration) {
		if (taskThreads == null) {
			taskThreads = new Thread[numberOfIterations];
		}
		AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(((RmiLoopTask)task).getNestedTask(), ((RmiLoopTask)task).getNumberOfIterations());
		taskExecuter.addTaskListener(new TaskListener() {
			public void taskCompleted(int taskId, int completedIterations) {
				synchronized (LoopTaskExecuter.this) {
					LoopTaskExecuter.this.notify();
				}
			}
		});
		tasks.add(taskExecuter);
		taskThreads[iteration] = new Thread(taskExecuter);
	}
	
	@Override
	protected void doWork(int iteration) {
		//MidisHost.logDebug("Running loop task " + task.getId() + " ...");
		try {
			taskThreads[iteration].start();
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//MidisHost.logDebug("Loop task " + task.getId() + " completed.");
	}
	
}
