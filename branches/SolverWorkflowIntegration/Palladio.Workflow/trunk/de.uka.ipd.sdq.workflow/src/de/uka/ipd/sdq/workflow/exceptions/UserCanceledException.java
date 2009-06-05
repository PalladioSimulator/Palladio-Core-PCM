package de.uka.ipd.sdq.workflow.exceptions;

public class UserCanceledException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1628079109828905830L;

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