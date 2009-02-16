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
	 * Creates the initial events for the resource.
	 */
	public abstract void start();

	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	public abstract String getId();

	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	public abstract String getName();

	public abstract void stop();

	public abstract void registerProcess(IRunningProcess runningProcess);

}
