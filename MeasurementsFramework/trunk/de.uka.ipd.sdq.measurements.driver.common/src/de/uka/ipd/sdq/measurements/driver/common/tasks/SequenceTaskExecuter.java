package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiSequenceTask;

public class SequenceTaskExecuter extends AbstractTaskExecuter {

	private List<AbstractTaskExecuter> taskExecuters = null;
	private List<TaskFinishIndicator> finishIndicators = null;

	public SequenceTaskExecuter(RmiSequenceTask task, int numberOfIterations, TaskFinishIndicator finishIndicator) {
		super(task, numberOfIterations, finishIndicator);
		//MidisHost.logDebug("Preparing sequential task (ID: " + task.getId() + ") ...");
		//MidisHost.logDebug("Sequential task (ID: " + task.getId() + ") prepared.");
	}
	
	@Override
	public boolean prepare() {
		if (taskExecuters == null) {
			taskExecuters = new ArrayList<AbstractTaskExecuter>();
		}
		if (finishIndicators == null) {
			finishIndicators = new ArrayList<TaskFinishIndicator>();
		}
		Iterator<RmiAbstractTask> taskIterator = ((RmiSequenceTask)task).getTasks().iterator();
		while (taskIterator.hasNext()) {
			RmiAbstractTask rmiTask = taskIterator.next();
			TaskFinishIndicator finishIndicator = new TaskFinishIndicator();
			AbstractTaskExecuter taskExecuter = TaskExecuterFactory.getInstance().convertTask(rmiTask, numberOfIterations, finishIndicator);
			finishIndicators.add(finishIndicator);
			if (DriverLogger.DEBUG) {
				DriverLogger.logDebug("SequenceTaskExecuter Preparing " + taskExecuter.getTask().getClass().getSimpleName());
			}
			if (taskExecuter.prepare() == false) {
				preparationFailed();
				return false;
			}
			taskExecuters.add(taskExecuter);
		}

		return true;
	}
	
	@Override
	protected void doWork(int iteration) {
		//Iterator<AbstractTaskExecuter> taskIterator = taskExecuters[iteration].iterator();
		//Iterator<AbstractTaskExecuter> taskIterator = taskExecuters.iterator();
		for (int i = 0; i<taskExecuters.size(); i++) {
			synchronized (taskExecuters.get(i)) {
				taskExecuters.get(i).runSynchronously(1, false);
			}
			if (finishSignal == true) {
				break;
			}
			/*executer.start();
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		//MidisHost.logDebug("Sequence task " + task.getId() + " completed.");
	}
	
	@Override
	protected void signalizeFinish() {
		for (TaskFinishIndicator finishIndicator : finishIndicators) {
			finishIndicator.setFinishSignal(true);
		}
		finishSignal = true;
		/*if (currentRunningNestedExecuter != null) {
			currentRunningNestedExecuter.signalizeFinish();
		}*/
	}

	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
		for (int i=0; i<((RmiSequenceTask)task).getTasks().size(); i++) {
			taskExecuters.get(i).storeResults();
		}
	}
	
	@Override
	protected void doCleanup() {
		if (taskExecuters != null) {
			//for (int i = 0; i < taskExecuters.length; i++) {
				//for (AbstractTaskExecuter executer : taskExecuters[i]) {
				for (AbstractTaskExecuter executer : taskExecuters) {
					executer.cleanup();
				}
			//}
			taskExecuters = null;
		}
	}

}
