package edu.kit.ipd.sdq.eventsim.system.events;

import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

/**
 * Schedule this event to resume the traversal of a {@link ResourceDemandingSEFF} (RD-SEFF).
 * <p>
 * The {@link Request} that is supposed to traverse the SEFF, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class ResumeSeffTraversalEvent extends AbstractSimEventDelegator<Request> {

    private final RequestState state;
	private EventSimSystemModel model;

    /**
     * Use this constructor to resume the traversal of a RD-SEFF. All information required to resume
     * the traversal are contained in the specified traversal {@code state}.
     * 
     * @param model
     *            the model
     * @param state
     *            the traversal state
     */
    public ResumeSeffTraversalEvent(final EventSimSystemModel model, final RequestState state) {
        super(model.getSimulationMiddleware().getSimulationModel(), "ResumeSeffTraversalEvent");
        this.model = model;
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final Request who) {
        SeffBehaviourInterpreter interpreter = this.model.getSeffInterpreter();
        interpreter.resumeTraversal(who, this.state);
    }

}
