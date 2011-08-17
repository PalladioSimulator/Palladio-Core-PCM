package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Use this instruction to end the traversal.
 * <p>
 * If the traversal is merely to be interrupted, use an {@link InterruptTraversal} instruction
 * instead.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public class EndTraversal<A extends Entity> implements ITraversalInstruction<A> {

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final TraversalState<A> state) {
        final TraversalStackFrame<A> scope = state.getStack().currentScope();
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setCurrentPosition(null);
        return null;
    }

}
