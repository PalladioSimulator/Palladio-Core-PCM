package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import de.uka.ipd.sdq.measurements.rmi.ExperimentResult;



public interface ExperimentCompletedListener {
	
	//public void experimentCompleted(HashMap<Integer, ArrayList<RmiResult>> allResults);
	public void experimentCompleted(ExperimentResult experimentResult, int rootTaskId);

}
