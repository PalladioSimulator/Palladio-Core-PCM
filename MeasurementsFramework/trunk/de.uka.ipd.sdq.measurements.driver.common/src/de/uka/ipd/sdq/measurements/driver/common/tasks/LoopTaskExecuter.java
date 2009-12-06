package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;

public class LoopTaskExecuter extends AbstractTaskExecuter {

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
					LoopTaskExecuter.this.nestedTaskFinished = true;
					LoopTaskExecuter.this.notify();
				}
			}
		});
		taskExecuters[iteration] = taskExecuter;
		//taskThreads[iteration] = new Thread(taskExecuter);
		return true;
	}
	
	private boolean nestedTaskFinished = false;
	//private Thread currentThread = null;
		
	@Override
	protected void doWork(int iteration) {
		System.out.println("Running loop task " + task.getId() + " ...");
		synchronized (LoopTaskExecuter.this) {
			nestedTaskFinished = false;
		}
		
		//currentThread = new Thread(taskExecuters[iteration]);
		//currentThread.start();
		taskExecuters[iteration].start();
		try {
			//taskThreads[iteration].start();
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nestedTaskFinished == false) {
			if ((taskExecuters[iteration] != null) && (taskExecuters[iteration].isAlive())) {
				try {
					taskExecuters[iteration].signalizeFinish();
					synchronized (taskExecuters[iteration]) {
						taskExecuters[iteration].notify();
					}
				} catch (IllegalMonitorStateException e) {
				}
			}
		}
		System.out.println("Loop task " + task.getId() + " completed.");
	}
	
	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		System.out.println("Storing for loop task " + task.getId());
		for (int i=0; i<taskExecuters.length; i++) {
			taskExecuters[i].storeResults();
		}
	}
	
	@Override
	protected void doCleanup() {
		if (taskExecuters != null) {
			for (int i = 0; i < taskExecuters.length; i++) {
				taskExecuters[i].cleanup();
			}
			taskExecuters = null;
		}
	}
	
}
