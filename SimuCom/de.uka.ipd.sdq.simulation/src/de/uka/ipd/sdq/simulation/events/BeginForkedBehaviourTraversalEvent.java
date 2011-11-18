package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.ForkedRequest;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.interpreter.seff.SeffBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;

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
    private final RequestState parentState;

    /**
     * Use this constructor to begin the traversal of the specified forked bheaviour.
     * 
     * @param model
     *            the model
     * 
     * @param parentState
     *            the state of the usage traversal
     */
    public BeginForkedBehaviourTraversalEvent(final EventSimModel model, final ForkedBehaviour behaviour,
            RequestState parentState) {
        super(model, "BeginUsageTraversalEvent");
        this.behaviour = behaviour;
        try {
            StackContext stoExContext = new StackContext();
            stoExContext.getStack().pushStackFrame(
                    parentState.getStoExContext().getStack().currentStackFrame().copyFrame());
            // this.parentState = new RequestTraversalStackFrame(parentState, stoExContext);
            this.parentState = (RequestState) this.parentState.clone();
            this.parentState.pushStackFrame();
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
        SeffBehaviourInterpreter.instance().beginTraversal(who, this.behaviour, this.parentState);
    }

}
