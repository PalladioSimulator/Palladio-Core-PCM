package de.uka.ipd.sdq.simulation.abstractsimengine.processes;

public interface ISimProcessStrategy {

	public abstract void startProcess(Runnable myRunnable);

	public abstract void resumeProcess();

	public abstract void finishProcess();

	public abstract void suspendProcess();

}