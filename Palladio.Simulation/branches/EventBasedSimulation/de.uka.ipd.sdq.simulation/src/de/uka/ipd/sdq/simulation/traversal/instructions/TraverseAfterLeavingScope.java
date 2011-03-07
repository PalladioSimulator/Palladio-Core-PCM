package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;

public class TraverseAfterLeavingScope<T extends Entity> implements ITraversalInstruction<T> {

    @Override
    public T process(final TraversalState<T> context) {
        final T currentPositionInLeftScope = context.getStack().currentScope().getCurrentPosition();
        context.getStack().leaveScope();

        if (!context.getStack().isEmpty()) {
            final TraversalStackFrame<T> scope = context.getStack().currentScope();
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
