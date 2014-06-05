package edu.kit.ipd.sdq.eventsim.interpreter.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import edu.kit.ipd.sdq.eventsim.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

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
 * @see SeffBehaviourInterpreter#resumeTraversal()
 */
public abstract class InterruptTraversal<A extends Entity, S extends AbstractInterpreterState<A>> implements
        ITraversalInstruction<A, S> {

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
    public A process(final S state) {
        state.setPreviousPosition(state.getCurrentPosition());
        state.enqueueFinishedAction(state.getCurrentPosition());
        state.setCurrentPosition(this.resumeAction);
        return null;
    }

}
