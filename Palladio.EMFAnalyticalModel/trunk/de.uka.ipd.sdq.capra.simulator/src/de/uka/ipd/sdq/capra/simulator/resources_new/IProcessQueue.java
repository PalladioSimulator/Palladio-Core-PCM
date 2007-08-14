package de.uka.ipd.sdq.capra.simulator.resources_new;

public interface IProcessQueue {

	public void addFirst(RunningProcess process);

	/**
	 */
	public void addLast(RunningProcess process);

	public RunningProcess poll();

	/**
	 */
	public RunningProcess peek();

}
