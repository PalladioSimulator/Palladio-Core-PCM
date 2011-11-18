package de.uka.ipd.sdq.simulation.interpreter.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.interpreter.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.state.AbstractInterpreterState;

/**
 * Use this instruction to leave the current scope of the traversal state's stack. Leaving the
 * current scope means to remove the stack frame from the top of the stack. The stack frame below
 * becomes visible and is used for subsequent traversal procedure.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public abstract class TraverseAfterLeavingScope<A extends Entity, F extends AbstractInterpreterState<A>> implements
        ITraversalInstruction<A, F> {

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final F scope) {
        final A currentPositionInLeftScope = scope.getCurrentPosition();
        scope.popStackFrame();

        if (scope.isEmpty()) {
            scope.enqueueFinishedAction(currentPositionInLeftScope);
            scope.enqueueFinishedAction(scope.getPreviousPosition());
            return scope.getCurrentPosition();
        } else {
            throw new RuntimeException("Tried to continue the traversal after leaving the current scope, but there "
                    + "is no outer scope. Consider to return a " + EndTraversal.class.getName()
                    + " instruction within the traversal strategy when the traversal is to be finished.");
        }
    }

}
