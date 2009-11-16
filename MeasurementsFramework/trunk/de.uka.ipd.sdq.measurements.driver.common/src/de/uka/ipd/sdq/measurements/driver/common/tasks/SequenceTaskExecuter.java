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
	protected void prepare(int iteration) {
		if (taskExecuters == null) {
			taskExecuters = new List[numberOfIterations];
		}
		ArrayList<AbstractTaskExecuter> tasks = new ArrayList<AbstractTaskExecuter>();
		Iterator<RmiAbstractTask> taskIterator = ((RmiSequenceTask)task).getTasks().iterator();
		while (taskIterator.hasNext()) {
			RmiAbstractTask rmiTask = taskIterator.next();
			AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(rmiTask, 1);
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
	}
	
	@Override
	protected void doWork(int iteration) {
		//MidisHost.logDebug("Running sequence task " + task.getId() + " ...");
		Iterator<AbstractTaskExecuter> taskIterator = taskExecuters[iteration].iterator();
		while (taskIterator.hasNext()) {
			new Thread(taskIterator.next()).start();
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//MidisHost.logDebug("Sequence task " + task.getId() + " completed.");
	}

}
