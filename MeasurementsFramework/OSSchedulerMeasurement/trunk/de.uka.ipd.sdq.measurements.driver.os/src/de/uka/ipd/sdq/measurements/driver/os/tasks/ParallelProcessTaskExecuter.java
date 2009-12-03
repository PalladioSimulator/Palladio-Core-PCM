package de.uka.ipd.sdq.measurements.driver.os.tasks;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactory;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskListener;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskResultStorage;
import de.uka.ipd.sdq.measurements.driver.os.ChildProcessManager;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelProcessTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

public class ParallelProcessTaskExecuter extends AbstractTaskExecuter {
		
	private AbstractTaskExecuter[] myOwnTaskExecuters = null;
	private int[] childProcessTaskIds = null;
	private List<Integer> completedNestedTasks = new ArrayList<Integer>();
	
	private int numberOfCompletedTasks = 0;
	
	public ParallelProcessTaskExecuter(RmiParallelProcessTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		//MidisHost.logDebug("Preparing parallel task (ID: " + task.getId() + ") ...");
		//stopUponFirstTaskCompleted = task.getStopUponFirstTaskCompleted();
		//MidisHost.logDebug("Parallel task (ID: " + task.getId() + ") prepared.");	
		
	}
	
	private boolean isAlreadyPrepared = false;
	private int numberOfChildTasks = 0;
	
	protected boolean prepare(int iteration) {
		// Do preparation only once.
		if (isAlreadyPrepared == false) {
			if (myOwnTaskExecuters == null) {
				myOwnTaskExecuters = new AbstractTaskExecuter[numberOfIterations];
			}
			if (((RmiParallelProcessTask)task).getTasks().size() > 1) {
				// also start further subprocesses to run parallel tasks.
				childProcessTaskIds = new int[((RmiParallelProcessTask)task).getTasks().size()-1];
			}
			for(int i=0; i<((RmiParallelTask)task).getTasks().size(); i++) {
				RmiAbstractTask rmiTask  = ((RmiParallelProcessTask)task).getTasks().get(i);
				if (i==0) {
					// the first parallel task is not executed on a child process.
					final AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(rmiTask, 1);
					taskExecuter.addTaskListener(new TaskListener() {
						public void taskCompleted(int taskId, int completedIterations) {
							synchronized (ParallelProcessTaskExecuter.this) {
								numberOfCompletedTasks++;
								completedNestedTasks.add(taskId);
								ParallelProcessTaskExecuter.this.notify();
								taskExecuter.removeTaskListener(this);
							}
						}
					});
				} else {
					ChildProcessManager.getInstance().prepareTask(i-1, rmiTask, numberOfIterations);
					childProcessTaskIds[i-1] = rmiTask.getId();
					final int childProcNumber = i-1;
					ChildProcessManager.getInstance().addTaskListener(new TaskListener() {

						final int childProcessNumber = childProcNumber;
						public void taskCompleted(int taskId, int completedIterations) {
							synchronized (ParallelProcessTaskExecuter.this) {
								numberOfCompletedTasks++;
								completedNestedTasks.add(taskId);
								ParallelProcessTaskExecuter.this.notify();
								ChildProcessManager.getInstance().removeTaskListener(this, childProcessNumber);
							}
						}
						
					}, childProcNumber);
					numberOfChildTasks++;
				}
			}
			isAlreadyPrepared = true;
		}
		return true;
	}
	
	protected void doWork(int iteration) {
		numberOfCompletedTasks = 0;
		int totalNumberOfTasks = numberOfChildTasks + 1;
		completedNestedTasks.clear();
		new Thread(myOwnTaskExecuters[iteration]).start();
		for (int i=0; i<numberOfChildTasks; i++) {
			ChildProcessManager.getInstance().executeTask(childProcessTaskIds[i], i, iteration);
		}
		
		while (numberOfCompletedTasks < totalNumberOfTasks) {
			try {
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
		for (int i=0; i<myOwnTaskExecuters.length; i++) {
			myOwnTaskExecuters[i].storeResults();
		}
		for (int i=0; i<((RmiParallelProcessTask)task).getTasks().size(); i++) {
			if (i==0) {
				// The first task has not been executed in a different process, but in the own process.
				// Its executer is available in the myOwnTaskExecuters array 
				continue;
			}
			int taskId = ((RmiParallelProcessTask)task).getTasks().get(i).getId();
			try {
				HashMap<Integer, ArrayList<RmiResult>> childResults = ChildProcessManager.getInstance().getTaskResultsFromChildProcess(taskId);
				TaskResultStorage.getInstance().storeResults(childResults);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
	}
	
	@Override
	public void cleanup() {
		for (int i=0; i<myOwnTaskExecuters.length; i++) {
			myOwnTaskExecuters[i].cleanup();
		}
	}

}
