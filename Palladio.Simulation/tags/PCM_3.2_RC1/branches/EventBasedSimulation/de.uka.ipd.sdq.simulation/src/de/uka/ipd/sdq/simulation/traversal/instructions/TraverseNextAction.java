package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;

public class TraverseNextAction<T extends Entity> implements ITraversalInstruction<T> {

    private final T nextAction;

    public TraverseNextAction(final T nextAction) {
        this.nextAction = nextAction;
    }

    @Override
    public T process(final TraversalState<T> context) {
        final TraversalStackFrame<T> scope = context.getStack().currentScope();
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setPreviousPosition(scope.getCurrentPosition());
        scope.setCurrentPosition(this.nextAction);
        return this.nextAction;
    }

}
