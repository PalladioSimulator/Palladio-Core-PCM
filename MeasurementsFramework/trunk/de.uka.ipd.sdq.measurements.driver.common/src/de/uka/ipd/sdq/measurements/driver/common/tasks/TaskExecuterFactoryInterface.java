package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

/**
 * This interface is implemented by the TaskExecuterFactory and all subfactories.
 * @author hauck
 *
 */
public interface TaskExecuterFactoryInterface {
	
	/**
	 * Create a task executer for a task. Return null if the factory (or subfactory) does not know how
	 * to convert the task.
	 * 
	 * @param rmiTask the task to convert
	 * @param numberOfTaskIterations
	 * @return the created task executer
	 */
	public AbstractTaskExecuter convertTask(RmiAbstractTask rmiTask, int numberOfTaskIterations, TaskFinishIndicator finishIndicator);

}
