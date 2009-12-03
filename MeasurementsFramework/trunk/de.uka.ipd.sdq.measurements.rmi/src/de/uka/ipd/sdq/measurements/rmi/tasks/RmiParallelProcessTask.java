package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RmiParallelProcessTask extends RmiParallelTask implements Serializable {

	private static final long serialVersionUID = 8218123178323663578L;

	private List<RmiAbstractTask> tasks = new ArrayList<RmiAbstractTask>();
	
	//private boolean stopUponFirstTaskCompleted = false;
	
	public RmiParallelProcessTask(int id, List<RmiAbstractTask> tasks) {
		super(id);
		this.tasks = tasks;
	}
		
	public RmiParallelProcessTask(int id) {
		super(id);
	}
	
	public List<RmiAbstractTask> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<RmiAbstractTask> tasks) {
		this.tasks = tasks;
	}
	
	/*public void setStopUponFirstTaskCompleted(boolean stopUponFirstTaskCompleted) {
		this.stopUponFirstTaskCompleted = stopUponFirstTaskCompleted;
	}
	
	public boolean getStopUponFirstTaskCompleted() {
		return stopUponFirstTaskCompleted;
	}*/

}
