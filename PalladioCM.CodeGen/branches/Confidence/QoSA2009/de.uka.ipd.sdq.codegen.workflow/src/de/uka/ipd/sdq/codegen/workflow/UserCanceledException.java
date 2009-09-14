package de.uka.ipd.sdq.codegen.workflow;

@SuppressWarnings("serial")
public class UserCanceledException extends Exception {

	public UserCanceledException() {
		super();
	}
	
	public UserCanceledException(String string) {
		super(string);
	}	
	
	public UserCanceledException(String string, Throwable e) {
		super(string, e);
	}
}