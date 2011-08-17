package de.uka.ipd.sdq.tcfmoop.tcmanager;

public interface IRequestManualTerminationListener {
	
	/**
	 * Logic witch should be executed when a ManualTerminationRequest event is fired.
	 */
	public void handleManualTerminationRequest();
}
