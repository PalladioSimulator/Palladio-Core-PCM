package de.uka.ipd.sdq.simucomframework.ssj;

import java.util.concurrent.Semaphore;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;

public class SimProcessThreadingStrategy implements ISimProcessStrategy {

	private Thread myThread = null;
	private boolean isTimeoutFailure = false;
	private String timeoutFailureTypeId = null;

	Semaphore waitingSemaphore = new Semaphore(0);
	Semaphore waitingForSuspendSemaphore = new Semaphore(0);

	public void startProcess(Runnable myRunnable) {
		this.myThread = new Thread(myRunnable);
		this.myThread.start();
		waitingForSuspendSemaphore.acquireUninterruptibly();
	}

	public void resumeProcess() {
		waitingSemaphore.release();
		waitingForSuspendSemaphore.acquireUninterruptibly();
	}

	public void finishProcess() {
		// This process is done and will not suspend any more...
		// Hence, release its wait for suspend semaphore held by the main
		// control thread.
		this.waitingForSuspendSemaphore.release();
	}

	public void suspendProcess() {
		waitingForSuspendSemaphore.release();
		waitingSemaphore.acquireUninterruptibly();

		// Having passed the waitingSemaphore, the process
		// is about to resume again. Check for the timeout
		// failure condition:
		if (isTimeoutFailure) {
			resetTimeoutFailure();
			FailureException.raise(FailureStatistics.getInstance()
					.getFailureType(timeoutFailureTypeId));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.ssj.ISimProcessStrategy#setTimeoutFailure
	 * (java.lang.String)
	 */
	public void setTimeoutFailure(String timeoutFailureTypeId) {
		isTimeoutFailure = true;
		this.timeoutFailureTypeId = timeoutFailureTypeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.ssj.ISimProcessStrategy#resetTimeoutFailure
	 * ()
	 */
	public void resetTimeoutFailure() {
		isTimeoutFailure = false;
	}
}
