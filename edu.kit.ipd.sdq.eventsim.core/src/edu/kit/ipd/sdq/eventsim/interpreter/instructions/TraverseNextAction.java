package edu.kit.ipd.sdq.eventsim.interpreter.instructions;

import org.palladiosimulator.pcm.core.entity.Entity;

import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

/**
 * Use this instruction to continue the traversal with a specified action.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are intended to be traversed
 */
public class TraverseNextAction<A extends Entity, S extends AbstractInterpreterState<A>> implements
        ITraversalInstruction<A, S> {

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
    public A process(final S state) {
        state.enqueueFinishedAction(state.getCurrentPosition());
        state.setPreviousPosition(state.getCurrentPosition());
        state.setCurrentPosition(this.nextAction);
        return this.nextAction;
    }

}
