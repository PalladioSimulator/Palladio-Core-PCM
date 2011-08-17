package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.ForkedRequest;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Schedule this event to begin the traversal of a {@link ForkedBehaviour}.
 * <p>
 * The {@link ForkedRequest} that is supposed to traverse the behaviour, is passed to the {@code
 * schedule()} method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginForkedBehaviourTraversalEvent extends AbstractSimEvent<EventSimModel, Request> {

    private final ForkedBehaviour behaviour;
    private final TraversalState<AbstractAction> parentState;

    /**
     * Use this constructor to begin the traversal of the specified forked bheaviour.
     * 
     * @param model
     *            the model
     * 
     * @param parentState
     *            the state of the usage traversal
     */
    @SuppressWarnings("unchecked")
    public BeginForkedBehaviourTraversalEvent(final EventSimModel model, final ForkedBehaviour behaviour,
            TraversalState<AbstractAction> parentState) {
        super(model, "BeginUsageTraversalEvent");
        this.behaviour = behaviour;
        try {
            StackContext stoExContext = new StackContext();
            stoExContext.getStack().pushStackFrame(
                    parentState.getStoExContext().getStack().currentStackFrame().copyFrame());
            this.parentState = new TraversalState<AbstractAction>(stoExContext);
            this.parentState.getStack().enterScope(
                    (TraversalStackFrame<AbstractAction>) parentState.getStack().currentScope().clone());
            // this.parentState = (TraversalState<AbstractAction>) parentState.clone();
        } catch (CloneNotSupportedException e) {
            throw new EventSimException("Could not clone parent traversal state");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final Request who) {
        new SeffTraversal(who).beginTraversal(this.behaviour, this.parentState);
    }

}
