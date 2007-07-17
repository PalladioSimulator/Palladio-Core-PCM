package de.uka.ipd.sdq.codegen.simucontroller.workflow;

@SuppressWarnings("serial")
public class RollbackFailedException extends Exception {

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
