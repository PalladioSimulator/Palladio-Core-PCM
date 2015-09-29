package edu.kit.ipd.sdq.eventsim.interpreter;

import org.palladiosimulator.pcm.core.entity.Entity;

import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

/**
 * Traversal instructions are used by {@link ITraversalStrategy}s to encapsulate their knowledge of
 * how the traversal is supposed to continue.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public interface ITraversalInstruction<A extends Entity, S extends AbstractInterpreterState<A>> {

    /**
     * Processes the traversal instruction and returns the action that is to be traversed next.
     * Processing means to prepare the traversal state for traversing the next action.
     * 
     * TODO adjust documentation
     * 
     * @param state
     *            the traversal state that may be changed
     * @return the next action that is to be processed
     */
    public A process(S state);

}
