package de.uka.ipd.sdq.workflow.exceptions;

/**
 * Exception to be thrown if the rollback method of a job terminates unrecoverable.
 * @author Steffen Becker
 *
 */
public class RollbackFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5121021317089764991L;

	public RollbackFailedException() {
		super();
	}
	
	public RollbackFailedException(String string) {
		super(string);
	}	
	
	public RollbackFailedException(String string, Throwable e) {
		super(string, e);
	}
}
