package de.uka.ipd.sdq.measurements.rmi.results;

import java.util.ArrayList;

public class CompositeTaskResult extends AbstractTaskResult {
	
	private static final long serialVersionUID = 4668442665165298957L;

	private ArrayList<AbstractTaskResult> nestedTaskResults = null;
	
	public CompositeTaskResult(long executerId, int id) {
		super(executerId, id);
	}
			
	public void setResults(ArrayList<AbstractTaskResult> results) {
		this.nestedTaskResults = results;
	}
	
	public ArrayList<AbstractTaskResult> getResults() {
		return nestedTaskResults;
	}

}