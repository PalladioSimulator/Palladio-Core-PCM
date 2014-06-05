package edu.kit.ipd.sdq.eventsim.events;

import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.ForkedRequest;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

/**
 * Schedule this event to begin the traversal of a {@link ForkedBehaviour}.
 * <p>
 * The {@link ForkedRequest} that is supposed to traverse the behaviour, is passed to the {@code
 * schedule()} method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginForkedBehaviourTraversalEvent extends AbstractSimEventDelegator<ForkedRequest> {

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
        this.parentState = parentState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final ForkedRequest who) {
        SeffBehaviourInterpreter interpreter = who.getModel().getSeffInterpreter();
        interpreter.beginTraversal(who, this.behaviour, this.parentState);
    }

}
