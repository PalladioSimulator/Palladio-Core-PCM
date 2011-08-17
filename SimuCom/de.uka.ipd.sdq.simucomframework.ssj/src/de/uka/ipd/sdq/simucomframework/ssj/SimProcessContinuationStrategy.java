package de.uka.ipd.sdq.simucomframework.ssj;

import org.apache.commons.javaflow.Continuation;

public class SimProcessContinuationStrategy implements ISimProcessStrategy {

	private Continuation thisThreadsContinuation = null;

	public void startProcess(Runnable myRunnable) {
		// This lets the thread run until it suspends or terminates and stores
		// its state in thisThreadsContinuation
		thisThreadsContinuation = Continuation.startWith(myRunnable);
	}

	public void resumeProcess() {
		thisThreadsContinuation = Continuation
				.continueWith(thisThreadsContinuation);
	}

	public void finishProcess() {
	}

	public void suspendProcess() {
		Continuation.suspend();
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.ssj.ISimProcessStrategy#setTimeoutFailure(java.lang.String)
	 */
	public void setTimeoutFailure(String timeoutFailureName) {
		// Implementation for this type of strategy unclear:
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.ssj.ISimProcessStrategy#resetTimeoutFailure()
	 */
	public void resetTimeoutFailure() {
		// Implementation for this type of strategy unclear:
		throw new UnsupportedOperationException();
	}
}
