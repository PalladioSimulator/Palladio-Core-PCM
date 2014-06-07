package org.palladiosimulator.protocom.framework.jee.servlet.stubs;

public class StackContext {
	private SimulatedStack stack;
	
	public StackContext() {
		stack = new SimulatedStack();
	}
	
	public SimulatedStack getStack() {
		return stack;
	}
	
//	public double evaluate(String string, Class<Double> expectedType) {
//		return 0.5;
//	}
//	
//	public int evaluate(String string, Class<Integer> expectedType) {
//		return 1;
//	}
	
	@SuppressWarnings("unchecked")
	public <T> T evaluate(String string, Class<T> expectedType) {
		if (expectedType == Double.class) {
			return (T) Double.valueOf(0.5);
		}
		
		if (expectedType == Integer.class) {
			return (T) Integer.valueOf(1);
		}
		
		return null;
	}
}
