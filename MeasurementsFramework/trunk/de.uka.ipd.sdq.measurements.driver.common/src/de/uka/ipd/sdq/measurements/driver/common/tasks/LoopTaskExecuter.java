package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;

public class LoopTaskExecuter extends AbstractTaskExecuter {

	private AbstractTaskExecuter taskExecuter = null;
	private FinishIndicator nestedFinishIndicator = null;

	public LoopTaskExecuter(RmiLoopTask task, int numberOfIterations, FinishIndicator finishIndicator) {
		super(task, numberOfIterations, finishIndicator);
		nestedFinishIndicator = finishIndicator;
		//MidisHost.logDebug("Preparing loop task (ID: " + task.getId() + ") ...");
			
		//MidisHost.logDebug("Loop task (ID: " + task.getId() + ") prepared.");
	}
	
	private int numberOfNestedTaskIterations = 0;
	private boolean prepared = false;

	@Override
	protected boolean prepare(int iteration) {
		if (prepared) {
			return true;
		}
		/*if (taskThreads == null) {
			taskThreads = new Thread[numberOfIterations];
		}*/
		/*if (taskExecuters == null) {
			taskExecuters = new AbstractTaskExecuter[numberOfIterations];
		}*/
		numberOfNestedTaskIterations = ((RmiLoopTask)task).getNumberOfIterations();
		//System.out.println("LOOP preparing " + numberOfNestedTaskIterations*numberOfIterations + " iterations");
		taskExecuter = TaskExecuterFactory.getInstance().convertTask(((RmiLoopTask)task).getNestedTask(), numberOfNestedTaskIterations*numberOfIterations, nestedFinishIndicator);
		taskExecuter.setPerformAllIterations(false);
		/*taskExecuter.addTaskListener(new TaskListener() {
			public void taskCompleted(int taskId, int completedIterations) {
				synchronized (LoopTaskExecuter.this) {
					LoopTaskExecuter.this.nestedTaskFinished = true;
					LoopTaskExecuter.this.notify();
				}
			}
		});*/
		//taskExecuters[iteration] = taskExecuter;
		//taskThreads[iteration] = new Thread(taskExecuter);
		prepared = true;
		return true;
	}
	
	//private Thread currentThread = null;
		
	@Override
	protected void doWork(int iteration) {
		//System.out.println("Running loop task " + task.getId() + " ...");
		//System.out.println("Loop in it " + iteration + " running nested task with " + numberOfNestedTaskIterations + " iterations");
		taskExecuter.runSynchronously(numberOfNestedTaskIterations, false);
		
		//currentThread = new Thread(taskExecuters[iteration]);
		//currentThread.start();
		/*taskExecuters[iteration].start();
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
		}*/
	}
	
	protected void signalizeFinish() {
		nestedFinishIndicator.setFinishSignal(true);
		
		//finishSignal = true;
		//taskExecuter.signalizeFinish();
		//return true;
	}
	
	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		if (DriverLogger.DEBUG) {
			DriverLogger.logDebug("Storing for loop task " + task.getId());
		}
		taskExecuter.storeResults();
		/*for (int i=0; i<taskExecuters.length; i++) {
			taskExecuters[i].storeResults();
		}*/
	}
	
	@Override
	protected void doCleanup() {
		taskExecuter.cleanup();
		taskExecuter = null;
		/*if (taskExecuters != null) {
			for (int i = 0; i < taskExecuters.length; i++) {
				taskExecuters[i].cleanup();
			}
			taskExecuters = null;
		}*/
	}
	
}
