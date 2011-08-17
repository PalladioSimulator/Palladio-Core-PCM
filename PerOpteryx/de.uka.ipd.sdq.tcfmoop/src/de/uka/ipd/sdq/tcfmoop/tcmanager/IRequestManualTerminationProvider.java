package de.uka.ipd.sdq.tcfmoop.tcmanager;

public interface IRequestManualTerminationProvider {
	
	/**
	 * Adds a new listener for the RequestManualTermination event.
	 * @param listener IRequestManualTerminationListener listener
	 */
	public void addRequestManualTerminationListener(IRequestManualTerminationListener listener);
	
	/**
	 * Removes a listener from the RequestManualTermination event.
	 * @param listener IRequestManualTerminationListener listener
	 */
	public void removeRequestManualTerminationListener(IRequestManualTerminationListener listener);
}
