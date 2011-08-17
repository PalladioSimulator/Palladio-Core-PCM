package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Use this instruction to continue the traversal with a specified action.
 * <p>
 * If the action is contained in a new 
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public class TraverseNextAction<A extends Entity> implements ITraversalInstruction<A> {

    private final A nextAction;

    /**
     * Constructs a new instruction.
     * 
     * @param nextAction
     *            the action with which the traversal is to be continued
     */
    public TraverseNextAction(final A nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final TraversalState<A> state) {
        final TraversalStackFrame<A> scope = state.getStack().currentScope();
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setPreviousPosition(scope.getCurrentPosition());
        scope.setCurrentPosition(this.nextAction);
        return this.nextAction;
    }

}
