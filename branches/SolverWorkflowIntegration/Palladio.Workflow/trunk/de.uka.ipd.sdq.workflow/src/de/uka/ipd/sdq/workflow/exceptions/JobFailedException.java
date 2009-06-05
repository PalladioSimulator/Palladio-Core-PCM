package de.uka.ipd.sdq.workflow.exceptions;

import org.eclipse.core.runtime.CoreException;

/**
 * Exception to be thrown if the execute method of a job terminates unrecoverable.
 * @author Steffen Becker
  */
public class JobFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2638800346598141354L;

	public JobFailedException() {
		super();
	}
	
	public JobFailedException(String string) {
		super(string);
	}	
	
	public JobFailedException(String string, Throwable e) {
		super(string, e);
	}

	public JobFailedException(CoreException e) {
		super(e);
	}
}
