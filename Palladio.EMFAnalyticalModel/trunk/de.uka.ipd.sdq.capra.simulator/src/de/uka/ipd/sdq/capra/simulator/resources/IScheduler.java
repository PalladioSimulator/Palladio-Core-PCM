package de.uka.ipd.sdq.capra.simulator.resources;


public interface IScheduler {

	/**
	 */
	public abstract void schedule();
	
	public abstract void registerNewProcess(ActiveProcess process);

}
