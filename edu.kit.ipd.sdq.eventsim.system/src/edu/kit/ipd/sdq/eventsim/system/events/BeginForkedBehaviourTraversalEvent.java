package edu.kit.ipd.sdq.eventsim.system.events;

import org.palladiosimulator.pcm.seff.ForkedBehaviour;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.ForkedRequest;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

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
	private EventSimSystemModel model;

    /**
     * Use this constructor to begin the traversal of the specified forked bheaviour.
     * 
     * @param model
     *            the model
     * 
     * @param parentState
     *            the state of the usage traversal
     */
    public BeginForkedBehaviourTraversalEvent(final EventSimSystemModel model, final ForkedBehaviour behaviour, RequestState parentState) {
        super(model.getSimulationMiddleware().getSimulationModel(), "BeginUsageTraversalEvent");
        this.model = model;
        this.behaviour = behaviour;
        this.parentState = parentState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final ForkedRequest who) {
        SeffBehaviourInterpreter interpreter = this.model.getSeffInterpreter();
        interpreter.beginTraversal(who, this.behaviour, this.parentState);
    }

}
