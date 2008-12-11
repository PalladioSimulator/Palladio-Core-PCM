package de.uka.ipd.sdq.simucomframework.exportedexceptions;

/**
 * This exception indicates that a failure has occurred during execution of an
 * InternalAction within a simulation run.
 * 
 * @author brosch
 */
public class InternalActionFailedException extends RuntimeException {

	/**
	 * Creates a new InternalActionFailedException. No additional information is
	 * carried by the exception, so far.
	 */
	public InternalActionFailedException() {
		super();
	}
}
