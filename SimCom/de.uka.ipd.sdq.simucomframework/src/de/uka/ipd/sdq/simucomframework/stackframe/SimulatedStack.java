package de.uka.ipd.sdq.simucomframework.stackframe;

import java.util.Stack;

public class SimulatedStack<T> {

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
}
