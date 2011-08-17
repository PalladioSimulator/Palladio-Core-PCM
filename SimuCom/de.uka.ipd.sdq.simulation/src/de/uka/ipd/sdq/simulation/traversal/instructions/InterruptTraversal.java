package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.events.ResumeSeffTraversalEvent;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Use this instruction to interrupt the traversal. An interrupted traversal can be resumed again.
 * By interrupting the traversal, the simulation time can be advanced by scheduling the resumption
 * at a later time instant.
 * <p>
 * If the traversal is supposed to end, use an {@link EndTraversal} instruction instead.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 * 
 * @see ResumeSeffTraversalEvent
 * @see SeffTraversal#resumeTraversal()
 */
public class InterruptTraversal<A extends Entity> implements ITraversalInstruction<A> {

    private final A resumeAction;

    /**
     * Constructs a new interrupt instruction.
     * 
     * @param resumeAction
     *            the action that is to be traversed when the traversal is resumed
     */
    public InterruptTraversal(final A resumeAction) {
        this.resumeAction = resumeAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public A process(final TraversalState<A> state) {
        final TraversalStackFrame<A> scope = state.getStack().currentScope();
        scope.setPreviousPosition(scope.getCurrentPosition());
        scope.enqueueFinishedAction(scope.getCurrentPosition());
        scope.setCurrentPosition(this.resumeAction);
        return null;
    }

}
