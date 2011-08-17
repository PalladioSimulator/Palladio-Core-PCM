package de.uka.ipd.sdq.tcfmoop.tcmanager;

public interface ITerminationCriteriaManagerInitializedListener {
	
	/**
	 * Logic witch should be executed when a TerminationCriteriaManagerInitialized is fired.
	 */
	public void handleTerminationCriteriaManagerInitializedEvent(ITerminationCriteriaManager instance);
}