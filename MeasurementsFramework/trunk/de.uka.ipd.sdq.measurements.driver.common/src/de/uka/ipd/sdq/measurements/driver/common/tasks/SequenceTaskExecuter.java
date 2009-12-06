package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiSequenceTask;

public class SequenceTaskExecuter extends AbstractTaskExecuter {

	private List<AbstractTaskExecuter>[] taskExecuters = null;

	public SequenceTaskExecuter(RmiSequenceTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		//MidisHost.logDebug("Preparing sequential task (ID: " + task.getId() + ") ...");
		//MidisHost.logDebug("Sequential task (ID: " + task.getId() + ") prepared.");
	}
	
	@Override
	protected boolean prepare(int iteration) {
		if (taskExecuters == null) {
			taskExecuters = new List[numberOfIterations];
		}
		ArrayList<AbstractTaskExecuter> tasks = new ArrayList<AbstractTaskExecuter>();
		Iterator<RmiAbstractTask> taskIterator = ((RmiSequenceTask)task).getTasks().iterator();
		while (taskIterator.hasNext()) {
			RmiAbstractTask rmiTask = taskIterator.next();
			AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(rmiTask, 1);
			System.out.println("Preparing " + taskExecuter.getTask().getClass().getSimpleName());
			taskExecuter.addTaskListener(new TaskListener() {
				public void taskCompleted(int taskId, int completedIterations) {
					synchronized (SequenceTaskExecuter.this) {
						SequenceTaskExecuter.this.notify();
					}
				}
			});
			tasks.add(taskExecuter);
		}
		taskExecuters[iteration] = tasks;
		return true;
	}
	
	@Override
	protected void doWork(int iteration) {
		Iterator<AbstractTaskExecuter> taskIterator = taskExecuters[iteration].iterator();
		while (taskIterator.hasNext()) {
			AbstractTaskExecuter executer = taskIterator.next();
			executer.start();
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//MidisHost.logDebug("Sequence task " + task.getId() + " completed.");
	}

	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		for (int i=0; i<((RmiSequenceTask)task).getTasks().size(); i++) {
			for (int j=0; j<numberOfIterations; j++) {
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
