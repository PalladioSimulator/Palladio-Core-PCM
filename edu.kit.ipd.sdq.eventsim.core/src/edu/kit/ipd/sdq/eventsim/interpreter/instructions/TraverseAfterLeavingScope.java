package edu.kit.ipd.sdq.eventsim.interpreter.instructions;

import org.palladiosimulator.pcm.core.entity.Entity;

import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

/**
 * TODO: adjust javadoc since the term scope is slightly outdated and should be better denoted by
 * the level of traversal hierarchy.
 * 
 * Use this instruction to leave the current scope of the traversal state's stack. Leaving the
 * current scope means to remove the stack frame from the top of the stack. The stack frame below
 * becomes visible and is used for subsequent traversal procedure.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public abstract class TraverseAfterLeavingScope<A extends Entity, S extends AbstractInterpreterState<A>> implements
        ITraversalInstruction<A, S> {

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final S state) {
        final A currentPositionInLeftScope = state.getCurrentPosition();
        state.popStackFrame();

        if (state.isEmpty()) {
            state.enqueueFinishedAction(currentPositionInLeftScope);
            state.enqueueFinishedAction(state.getPreviousPosition());
            return state.getCurrentPosition();
        } else {
            throw new RuntimeException("Tried to continue the traversal after leaving the current scope, but there "
                    + "is no outer scope. Consider to return a " + EndTraversal.class.getName()
                    + " instruction within the traversal strategy when the traversal is to be finished.");
        }
    }

}
