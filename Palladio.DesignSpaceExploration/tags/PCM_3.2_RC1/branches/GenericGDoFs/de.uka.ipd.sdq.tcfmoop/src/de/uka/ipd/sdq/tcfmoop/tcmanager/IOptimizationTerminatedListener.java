package de.uka.ipd.sdq.tcfmoop.tcmanager;

public interface IOptimizationTerminatedListener {
	
	/**
	 * Logic witch should be executed when the Optimization is terminated by the Termination Criteria Manager.
	 * @param instance instance of the current Termination Criteria Manager.
	 */
	public void handleOptimizationTerminatedListener(TerminationCriteriaManager instance);
}