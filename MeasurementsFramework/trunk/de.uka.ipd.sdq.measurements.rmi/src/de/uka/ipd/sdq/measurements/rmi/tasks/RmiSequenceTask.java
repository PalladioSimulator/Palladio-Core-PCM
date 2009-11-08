package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RmiSequenceTask extends RmiAbstractTask implements Serializable {

	private static final long serialVersionUID = -5414868093228127991L;
	
	private List<RmiAbstractTask> tasks = new ArrayList<RmiAbstractTask>();
	
	public RmiSequenceTask(int id, List<RmiAbstractTask> tasks) {
		super(id);
		this.tasks = tasks;
	}
	
	public RmiSequenceTask(int id) {
		super(id);
	}
	
	public List<RmiAbstractTask> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<RmiAbstractTask> tasks) {
		this.tasks = tasks;
	}

}
