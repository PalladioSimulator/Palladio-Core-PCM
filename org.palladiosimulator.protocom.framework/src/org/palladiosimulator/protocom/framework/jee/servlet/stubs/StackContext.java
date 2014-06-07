package org.palladiosimulator.protocom.framework.jee.servlet.stubs;

public class StackContext {
	private SimulatedStack stack;
	
	public StackContext() {
		stack = new SimulatedStack();
	}
	
	public SimulatedStack getStack() {
		return stack;
	}
	
	public double evaluate(String string, Class<?> expectedType) {
		return 0.5;
	}
}
