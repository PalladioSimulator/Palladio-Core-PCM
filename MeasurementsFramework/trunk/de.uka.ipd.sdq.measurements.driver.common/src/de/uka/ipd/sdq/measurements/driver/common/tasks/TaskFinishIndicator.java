package de.uka.ipd.sdq.measurements.driver.common.tasks;

/**
 * A task can run either in a thread or synchronously.
 * In both cases, it can be the case the the task has to be notified
 * from externally that it has to be stopped. This can be the outer task,
 * but sometimes also the outer task just has to be stopped and has to
 * delegate this to its inner task.
 * 
 * For this, the TaskFinishIndicator class is used. A TaskFinishIndicator object is passed to every
 * object. It contains a finish signal which, if set to true, informs the running task that
 * it has to abort. Passing a reference of a TaskFinishIndicator to inner tasks allows outer 
 * tasks to not having to take care about stopping inner tasks if they are aborted.
 * Instead, if their TaskFinishIndicator is set to true from outside and they passed a 
 * reference of the TaskFinishIndicator to inside tasks, the inner tasks automatically get informed
 * about the abortion.
 * 
 * @author hauck
 *
 */
public class TaskFinishIndicator {
	private boolean finishSignal = false;

	public boolean getFinishSignal() {
		return finishSignal;
	}

	public void setFinishSignal(boolean finishSignal) {
		this.finishSignal = finishSignal;
	}
}