package de.uka.ipd.sdq.simucomframework.exceptions;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;

/**
 * Represents a failure-on-demand occurrence during the simulation.
 * 
 * This mechanism is used in the simulation to indicate that a failure-on-demand
 * has occurred during service execution. The executing SimProcess (an
 * OpenWorkloadUser, ClosedWorkloadUser or ForkedBehaviourProcess) cancels its
 * associated control and data flow. The central FailureStatistics object is
 * updated to log the failure-on-demand occurrence.
 * 
 * @author brosch
 * 
 */
public class FailureException extends RuntimeException {
	private static final long serialVersionUID = -6074335938145682592L;

	/**
	 * Indicates a failure-on-demand occurrence of the given failure type.
	 * 
	 * @param failureType
	 *            the failure type identification.
	 */
	public static void raise(final MarkovFailureType failureType) {
		FailureStatistics.getInstance()
				.increaseTotalFailureCounter(failureType);
		throw new FailureException(failureType);
	}

	/**
	 * The failure type.
	 */
	private MarkovFailureType failureType;

	/**
	 * A private constructor prevents the direct creation of an exception and
	 * enforces using the raise()-method instead.
	 * 
	 * @param failureType
	 *            the failure type identification
	 */
	private FailureException(final MarkovFailureType failureType) {
		this.failureType = failureType;
	}

	/**
	 * Retrieves the failure type identification.
	 * 
	 * @return the failure type identification
	 */
	public MarkovFailureType getFailureType() {
		return failureType;
	}
}
