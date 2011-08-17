package de.uka.ipd.sdq.simulation.traversal.state;

import java.util.Stack;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * A stack of {@link TraversalStackFrame}s. The current stack frame is denoted as the current scope
 * of the stack and can be returned by the {@code currentScope} method. Only state information
 * contained in this scope are accessible.
 * <p>
 * Use the {@code enterScope} and {@code leaveScope} methods to push a new frame on the stack or to
 * pop the current frame, respectively.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 */
public class TraversalStateStack<A extends Entity> implements Cloneable {

    private static final Logger logger = Logger.getLogger(TraversalStateStack.class);

    private final Stack<TraversalStackFrame<A>> stack;

    /**
     * Constructs an empty stack.
     */
    public TraversalStateStack() {
        this.stack = new Stack<TraversalStackFrame<A>>();
    }

    /**
     * Returns the stack frame from the top of the stack, which constitutes the current scope. The
     * current scope contains all state information that are currently accessible.
     * 
     * @return the current scope
     */
    public TraversalStackFrame<A> currentScope() {
        return this.stack.empty() ? null : this.stack.peek();
    }

    /**
     * Enters a new scope by pushing the passed stack frame onto the stack. This scope becomes the
     * current scope.
     * 
     * @param frame
     *            the stack frame
     */
    public void enterScope(final TraversalStackFrame<A> frame) {
        logger.debug("Entering Scope");
        this.stack.push(frame);
    }

    /**
     * Leaves the current scope by removing the stack frame from the top of the stack. The frame
     * beneath becomes the current scope.
     */
    public void leaveScope() {
        logger.debug("Leaving Scope");
        this.stack.pop();
    }

    /**
     * Returns the number of frames on the stack.
     * 
     * @return the size of the stack.
     */
    public int getSize() {
        return this.stack.size();
    }

    /**
     * Returns whether the stack is empty.
     * 
     * @return true, if the stack is empty; false else
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() throws CloneNotSupportedException {
        TraversalStateStack<A> stackCopy = new TraversalStateStack<A>();
        for(int i = 0; i<this.stack.size(); i++) {
            TraversalStackFrame<A> frameCopy = (TraversalStackFrame<A>) this.stack.get(i).clone();
            stackCopy.stack.add(i, frameCopy);
        }
        return stackCopy;
    }

}
