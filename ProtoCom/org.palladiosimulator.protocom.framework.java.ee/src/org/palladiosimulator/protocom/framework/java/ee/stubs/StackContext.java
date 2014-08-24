package org.palladiosimulator.protocom.framework.java.ee.stubs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class StackContext {
	private SimulatedStack stack;
	
	public StackContext() {
		stack = new SimulatedStack();
	}
	
	public SimulatedStack getStack() {
		return stack;
	}
	
	public void setStack(SimulatedStack stack) {
		this.stack = stack;
	}
	
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
