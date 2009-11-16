package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;

public interface TaskExecuter {
	
	public RmiAbstractTask getTask();
	
	public void work();
	
	/**
	 * Ask the task to cancel its ongoing work.
	 * @return true if the task received the signal.
	 */
	public boolean signalizeFinish();

}
