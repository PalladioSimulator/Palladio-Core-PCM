package de.uka.ipd.sdq.simulation.interpreter.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.interpreter.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.state.AbstractInterpreterState;

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
public abstract class EndTraversal<A extends Entity, F extends AbstractInterpreterState<A>> implements
        ITraversalInstruction<A, F> {

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final F scope) {
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setCurrentPosition(null);
        return null;
    }

}
