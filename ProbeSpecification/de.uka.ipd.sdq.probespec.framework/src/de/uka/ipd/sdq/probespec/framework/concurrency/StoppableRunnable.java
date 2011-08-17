package de.uka.ipd.sdq.probespec.framework.concurrency;

public interface StoppableRunnable extends Runnable {

	/**
	 * Try to stop the {@link StoppableRunnable}. Must
	 * not throw any exceptions, be silent if the {@link StoppableRunnable}
	 * is already stopped. 
	 */
	public void stop();

}
