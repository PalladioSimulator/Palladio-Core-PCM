package de.uka.ipd.sdq.simucomframework.usage;

/**
 * Interface for all workload drivers. A workload driver controls the simulated
 * workload by controlling simulated users of the system
 * @author Steffen Becker
 *
 */
public interface IWorkloadDriver {
	
	/**
	 * Starts the workload 
	 */
	void run();
}
