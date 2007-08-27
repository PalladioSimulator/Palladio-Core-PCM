package de.uka.ipd.sdq.scheduler;


public interface IActiveResource {

	/**
	 * Processes the specified demand of the process.
	 */
	public abstract void process(ISchedulableProcess process, double demand);

}
