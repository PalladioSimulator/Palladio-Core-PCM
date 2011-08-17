package de.uka.ipd.sdq.simucomframework.ssj;


public interface ISimProcessStrategy {

	public abstract void startProcess(Runnable myRunnable);

	public abstract void resumeProcess();

	public abstract void finishProcess();

	public abstract void suspendProcess();

	/**
	 * Indicates the corresponding process to be in a timeout failure.
	 * 
	 * @param timeoutFailureType
	 *            the timeout failure type
	 */
	public abstract void setTimeoutFailure(String timeoutFailureTypeId);

	/**
	 * Unsets the timeout failure information for the corresponding process.
	 */
	public abstract void resetTimeoutFailure();
}