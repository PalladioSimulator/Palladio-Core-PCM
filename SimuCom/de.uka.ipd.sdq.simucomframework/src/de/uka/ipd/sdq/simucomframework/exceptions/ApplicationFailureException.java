/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.exceptions;

/**
 * Represents an application failure
 *
 */
public class ApplicationFailureException extends FailureException {
	private static final long serialVersionUID = 8596352009557499770L;
	
	public ApplicationFailureException(String failureType) {
		super(failureType);
	}
	
	public static void raise(String failureType) {
		FailureStatistics.getInstance().increaseLocalFailureCounter(failureType);
		throw new ApplicationFailureException(failureType);
	}

}
