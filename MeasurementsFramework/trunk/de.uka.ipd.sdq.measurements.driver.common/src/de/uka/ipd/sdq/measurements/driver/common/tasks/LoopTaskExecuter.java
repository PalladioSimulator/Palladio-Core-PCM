package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;

public class LoopTaskExecuter extends AbstractTaskExecuter {

	//private Thread[] taskThreads = null;
	private AbstractTaskExecuter[] taskExecuters = null;

	public LoopTaskExecuter(RmiLoopTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		//MidisHost.logDebug("Preparing loop task (ID: " + task.getId() + ") ...");
			
		//MidisHost.logDebug("Loop task (ID: " + task.getId() + ") prepared.");
	}

	@Override
	protected boolean prepare(int iteration) {
		/*if (taskThreads == null) {
			taskThreads = new Thread[numberOfIterations];
		}*/
		if (taskExecuters == null) {
			taskExecuters = new AbstractTaskExecuter[numberOfIterations];
		}
		AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(((RmiLoopTask)task).getNestedTask(), ((RmiLoopTask)task).getNumberOfIterations());
		taskExecuter.addTaskListener(new TaskListener() {
			public void taskCompleted(int taskId, int completedIterations) {
				synchronized (LoopTaskExecuter.this) {
					LoopTaskExecuter.this.notify();
				}
			}
		});
		taskExecuters[iteration] = taskExecuter;
		//taskThreads[iteration] = new Thread(taskExecuter);
		return true;
	}
	
	@Override
	protected void doWork(int iteration) {
		//MidisHost.logDebug("Running loop task " + task.getId() + " ...");
		try {
			new Thread(taskExecuters[iteration]).start();
			//taskThreads[iteration].start();
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//MidisHost.logDebug("Loop task " + task.getId() + " completed.");
	}
	
	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		for (int i=0; i<taskExecuters.length; i++) {
			taskExecuters[i].storeResults();
		}
	}
	
	@Override
	public void cleanup() {
		if (taskExecuters != null) {
			for (int i = 0; i < taskExecuters.length; i++) {
				taskExecuters[i].cleanup();
				// taskThreads[i].
			}
			taskExecuters = null;
		}
	}
	
}
