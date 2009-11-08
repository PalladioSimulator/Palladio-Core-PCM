package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;

public class RmiLoopTask extends RmiAbstractTask implements Serializable {

	private static final long serialVersionUID = 5216299752349415872L;

	private RmiAbstractTask task = null;
	private int numberOfIterations = 0;
	
	public RmiLoopTask(int id, RmiAbstractTask task) {
		super(id);
		this.task = task;
	}
	
	public RmiLoopTask(int id) {
		super(id);
	}
	
	public RmiAbstractTask getNestedTask() {
		return task;
	}
	
	public void setNestedTask(RmiAbstractTask task) {
		this.task = task;
	}
	
	public void setNumberOfIterations(int numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}
	
	public int getNumberOfIterations() {
		return numberOfIterations;
	}

}
