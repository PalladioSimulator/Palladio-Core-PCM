package de.uka.ipd.sdq.codegen.workflow;

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
}
