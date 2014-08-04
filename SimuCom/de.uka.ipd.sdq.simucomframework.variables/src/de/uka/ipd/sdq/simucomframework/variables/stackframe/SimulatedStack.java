package de.uka.ipd.sdq.simucomframework.variables.stackframe;

import java.io.Serializable;
import java.util.Stack;

/**
 * A simulated stack used by simulation threads to store their local variables during their
 * execution
 * 
 * @author Steffen Becker
 *
 * @param <T>
 *            Content-type of the stacks contents
 */
public class SimulatedStack<T> implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 4131291044209793459L;

    /**
     * Use a Java Stack internally
     */
    Stack<SimulatedStackframe<T>> stack = new Stack<SimulatedStackframe<T>>();

    public SimulatedStack() {
    }

    /**
     * Add a stackframe to this stack. The frame has no parent frame.
     * 
     * @return The frame added by this method
     */
    public SimulatedStackframe<T> createAndPushNewStackFrame() {
        SimulatedStackframe<T> frame = new SimulatedStackframe<T>();
        stack.push(frame);
        return frame;
    }

    /**
     * Add a stackframe to this stack using the given frame as parent frame
     * 
     * @param parent
     *            The parent frame of the frame to create
     * @return The newly created frame
     */
    public SimulatedStackframe<T> createAndPushNewStackFrame(SimulatedStackframe<T> parent) {
        SimulatedStackframe<T> frame = new SimulatedStackframe<T>(parent);
        stack.push(frame);
        return frame;
    }

    /**
     * @return Topmost stackframe on this stack
     */
    public SimulatedStackframe<T> currentStackFrame() {
        return stack.peek();
    }

    /**
     * Pop the topmost stackframe. Called when exiting a scope
     */
    public void removeStackFrame() {
        stack.pop();
    }

    /**
     * @return Size of the stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * Add a stackframe on top of this stack. The frame already exists.
     * 
     * @param copyFrame
     *            The frame to push on the stack
     */
    public void pushStackFrame(SimulatedStackframe<T> copyFrame) {
        stack.push(copyFrame);
    }
}
