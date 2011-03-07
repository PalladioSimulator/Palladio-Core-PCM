package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;

public class EndTraversal<T extends Entity> implements ITraversalInstruction<T> {

    @Override
    public T process(final TraversalState<T> context) {
        final TraversalStackFrame<T> scope = context.getStack().currentScope();
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setCurrentPosition(null);
        return null;
    }

}
