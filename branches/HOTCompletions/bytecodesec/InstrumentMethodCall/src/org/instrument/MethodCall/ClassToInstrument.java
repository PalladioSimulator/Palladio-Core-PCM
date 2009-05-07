package org.instrument.MethodCall;

public class ClassToInstrument implements IClassToInstrument{

	/**
	 * Method to instrument by replacing the call to {@link #x()}
	 * with other bytecode sequence
	 */
	public void m(){
		x();
	}

	private void x() {
		System.out.println("Method x is called");
	}

}
