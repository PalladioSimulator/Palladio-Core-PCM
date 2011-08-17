package de.uka.ipd.sdq.simucomframework.exceptions;

/**
 * Represents a failure inside the simulated system. 
 */
public abstract class FailureException extends RuntimeException {
	private static final long serialVersionUID = -6074335938145682592L;
	
	private String failureType;
	public FailureException(String failureType) {
		this.failureType=failureType;
	}
	
	public String getFailureType() {
		return failureType;
	}
}
