package de.uka.ipd.sdq.simucomframework.variables.stackframe;

import java.io.Serializable;
import java.util.Stack;

public class SimulatedStack<T> implements Serializable {

	Stack<SimulatedStackframe<T>> stack = new Stack<SimulatedStackframe<T>>();
	
	public SimulatedStack()
	{
	}
	
	public SimulatedStackframe<T> createAndPushNewStackFrame()
	{
		SimulatedStackframe<T> frame = new SimulatedStackframe<T>();
		stack.push(frame);
		return frame;
	}

	public SimulatedStackframe<T> createAndPushNewStackFrame(SimulatedStackframe<T> parent)
	{
		SimulatedStackframe<T> frame = new SimulatedStackframe<T>(parent);
		stack.push(frame);
		return frame;
	}
	
	public SimulatedStackframe<T> currentStackFrame()
	{
		return stack.peek();
	}

	public void removeStackFrame()
	{
		stack.pop();
	}

	public int size() {
		return stack.size();
	}

	public void pushStackFrame(SimulatedStackframe<T> copyFrame) {
		stack.push(copyFrame);
	}
}
