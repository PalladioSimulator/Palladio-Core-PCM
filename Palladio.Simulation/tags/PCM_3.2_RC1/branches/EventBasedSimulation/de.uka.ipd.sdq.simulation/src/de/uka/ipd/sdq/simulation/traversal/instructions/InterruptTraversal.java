package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;

public class InterruptTraversal<T extends Entity> implements ITraversalInstruction<T> {

    private final T actionAfterResume;

    /**
     * @param actionAfterResume
     *            the action that is to be traversed as soon as the traversal is being resumed
     */
    public InterruptTraversal(final T actionAfterResume) {
        this.actionAfterResume = actionAfterResume;
    }

    @Override
    public T process(final TraversalState<T> context) {
        final TraversalStackFrame<T> scope = context.getStack().currentScope();
        scope.setPreviousPosition(scope.getCurrentPosition());
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setCurrentPosition(this.actionAfterResume);
        return null;
    }

}
