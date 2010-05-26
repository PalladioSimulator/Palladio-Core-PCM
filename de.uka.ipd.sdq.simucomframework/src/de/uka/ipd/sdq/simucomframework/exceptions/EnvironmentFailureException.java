package de.uka.ipd.sdq.simucomframework.exceptions;

/**
 * Represents environment failures
 */
public class EnvironmentFailureException extends FailureException {
	private static final long serialVersionUID = 7083393435451720189L;

	public EnvironmentFailureException(String failureType) {
		super(failureType);
	}
	
	public static void raise(String failureType) {
		FailureStatistics.getInstance().increaseLocalFailureCounter(failureType);
		throw new EnvironmentFailureException(failureType);
	}
}
