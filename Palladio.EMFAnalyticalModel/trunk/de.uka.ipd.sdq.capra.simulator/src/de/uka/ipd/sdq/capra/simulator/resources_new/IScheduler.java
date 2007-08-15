package de.uka.ipd.sdq.capra.simulator.resources_new;


public interface IScheduler {

	/**
	 */
	public abstract void schedule();
	
	public abstract void registerNewProcess(ActiveProcess process);

}
