package de.uka.ipd.sdq.simucomframework.exceptions;

/**
 * Represents environment failures
 */
public class ResourceFailureException extends FailureException {
	private static final long serialVersionUID = 7083393435451720189L;

	public ResourceFailureException(String failureType) {
		super(failureType);
	}
	
	public static void raise(String failureType) {
		FailureStatistics.getInstance().increaseTotalFailureCounter(failureType);
		throw new ResourceFailureException(failureType);
	}
}
