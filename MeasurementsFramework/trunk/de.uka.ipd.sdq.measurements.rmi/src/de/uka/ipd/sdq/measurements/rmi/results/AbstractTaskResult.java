package de.uka.ipd.sdq.measurements.rmi.results;

import java.io.Serializable;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

public abstract class AbstractTaskResult implements Serializable {

	private static final long serialVersionUID = 5834509774265325880L;

	/** The ID of the task **/
	private int taskId = 0;
	/** The ID of the executed task instance
	 * (e.g. a task nested in a LoopTask can be executed multiple times)
	 */
	private long taskExecuterId = 0L;
	private long totalTime = 0L;
	private RmiAbstractTask task = null;
	
	protected AbstractTaskResult(long executerId, int taskId) {
		this.taskId = taskId;
		this.taskExecuterId = executerId;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public long getExecuterId() {
		return taskExecuterId;
	}
	
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	
	public long getTotalTime() {
		return totalTime;
	}
	
	public void setTask(RmiAbstractTask task) {
		this.task = task;
	}
	
	public RmiAbstractTask getTask() {
		return task;
	}

}