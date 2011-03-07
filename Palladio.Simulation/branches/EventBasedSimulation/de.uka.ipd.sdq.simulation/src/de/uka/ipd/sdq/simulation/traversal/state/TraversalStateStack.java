package de.uka.ipd.sdq.simulation.traversal.state;

import java.util.Stack;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

public class TraversalStateStack<T extends Entity> {

    private static final Logger logger = Logger.getLogger(TraversalStateStack.class);
    
    private final Stack<TraversalStackFrame<T>> stack;

    public TraversalStateStack() {
        this.stack = new Stack<TraversalStackFrame<T>>();
    }

    public TraversalStackFrame<T> currentScope() {
        return this.stack.empty() ? null : this.stack.peek();
    }

    /**
     * @return whether the stack is empty.
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * @return the size of the stack. That is, the current number of stack frames.
     */
    public int getSize() {
        return this.stack.size();
    }

    public void enterScope(final TraversalStackFrame<T> frame) {
        logger.debug("Entering Scope");
        this.stack.push(frame);
    }

    public void leaveScope() {
        logger.debug("Leaving Scope");
        this.stack.pop();
    }

}
