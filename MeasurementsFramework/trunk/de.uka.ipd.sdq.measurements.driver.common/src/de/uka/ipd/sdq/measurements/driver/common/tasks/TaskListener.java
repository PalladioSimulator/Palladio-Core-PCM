package de.uka.ipd.sdq.measurements.driver.common.tasks;

public interface TaskListener {
	
	/**
	 * 
	 * @param taskId
	 * @param completedIteration the number of iterations that have been completed (0 to (#iterations-1)) 
	 */
	public void taskCompleted(int taskId, int completedIterations);

}
