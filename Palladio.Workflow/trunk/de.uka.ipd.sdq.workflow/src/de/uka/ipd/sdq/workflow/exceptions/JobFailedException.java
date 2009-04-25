package de.uka.ipd.sdq.workflow.exceptions;

import org.eclipse.core.runtime.CoreException;

@SuppressWarnings("serial")
public class JobFailedException extends Exception {

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
