package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

public interface TaskExecuter {
	
	public RmiAbstractTask getTask();
	
	public void storeResults();
	
	public void cleanup();
	
	/**
	 * Ask the task to cancel its ongoing work.
	 * Its up to the task implementation how it handles the signal.
	 */
	//protected void signalizeFinish();

}
