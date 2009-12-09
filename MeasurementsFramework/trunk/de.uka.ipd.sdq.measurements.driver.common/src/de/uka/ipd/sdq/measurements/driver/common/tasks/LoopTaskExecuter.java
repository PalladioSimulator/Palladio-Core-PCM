package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;

public class LoopTaskExecuter extends AbstractTaskExecuter {

	private AbstractTaskExecuter taskExecuter = null;
	private TaskFinishIndicator nestedFinishIndicator = null;

	public LoopTaskExecuter(RmiLoopTask task, int numberOfIterations, TaskFinishIndicator finishIndicator) {
		super(task, numberOfIterations, finishIndicator);
		nestedFinishIndicator = finishIndicator;
		//MidisHost.logDebug("Preparing loop task (ID: " + task.getId() + ") ...");
			
		//MidisHost.logDebug("Loop task (ID: " + task.getId() + ") prepared.");
	}
	
	private int numberOfNestedTaskIterations = 0;

	@Override
	public boolean prepare() {

		numberOfNestedTaskIterations = ((RmiLoopTask)task).getNumberOfIterations();
		//System.out.println("LOOP preparing " + numberOfNestedTaskIterations*numberOfIterations + " iterations");
		taskExecuter = TaskExecuterFactory.getInstance().convertTask(((RmiLoopTask)task).getNestedTask(), numberOfNestedTaskIterations*numberOfIterations, nestedFinishIndicator);
		if (taskExecuter.prepare() == false) {
			taskExecuter = null;
			preparationFailed();
			return false;
		}
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
		return true;
	}
	
	//private Thread currentThread = null;
		
	@Override
	protected void doWork(int iteration) {
		taskExecuter.runSynchronously(numberOfNestedTaskIterations, false);
		
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
	}
	
	@Override
	protected void doCleanup() {
		if (taskExecuter != null) {
			taskExecuter.cleanup();
			taskExecuter = null;
		}
		nestedFinishIndicator = null;
	}
	
}
