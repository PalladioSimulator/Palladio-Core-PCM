package edu.kit.ipd.sdq.eventsim.interpreter.state;

import org.palladiosimulator.pcm.core.entity.Entity;

import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;

/**
 * This abstract class specifies methods for a stack-like data structure that captures the
 * interpretation progress (state) of an {@link BehaviourInterpreter}. The organisation as a stack
 * takes into account the potentially hierarchical nesting of actions such as Loops and Branches.
 * <p>
 * For each level of hierarchy, there is a stack frame, which holds the state information for the
 * respective level of hierarchy. Only state information contained in the topmost frame are
 * accessible.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 */
public abstract class AbstractInterpreterState<A extends Entity> implements IInterpreterState<A> {

    /**
     * Pushes an emtpy stack frame onto the stack.
     */
    public abstract void pushStackFrame();

    /**
     * Removes the topmost frame from the stack.
     */
    public abstract void popStackFrame();

    public abstract boolean hasOpenScope();

    /**
     * Returns whether the stack is empty.
     * 
     * @return true, if the stack is empty; false else
     */
    public abstract boolean isEmpty();

}
