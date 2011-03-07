/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.exceptions;

/**
 * Represents an application failure
 *
 */
public class SoftwareInducedFailureException extends FailureException {
	private static final long serialVersionUID = 8596352009557499770L;
	
	public SoftwareInducedFailureException(String failureType) {
		super(failureType);
	}
	
	public static void raise(String failureType) {
		FailureStatistics.getInstance().increaseTotalFailureCounter(failureType);
		throw new SoftwareInducedFailureException(failureType);
	}

}
