package de.uka.ipd.sdq.scheduler;

/**
 * An active resource can execute demands of schedulable processes. Active
 * resources are shared by multiple processes so that they need to use
 * scheduling strategies to assign processing time of the resources to
 * processes.
 * 
 * @author jens
 * 
 */
public interface IActiveResource {

	/**
	 * Processes the specified demand of the process.
	 */
	public abstract void process(ISchedulableProcess process, double demand);

	/**
	 * Before a process can issue demands to the resource it needs to be
	 * registered. After registration the process is blocked.
	 * 
	 * @param process
	 *            Process to execute on the resource.
	 */
	public abstract void registerNewProcess(IRunningProcess process);

	/**
	 * Creates the initial events for the resource.
	 */
	public abstract void start();

}
