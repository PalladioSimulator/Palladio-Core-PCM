package edu.kit.ipd.sdq.eventsim.events;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

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

    /**
     * Use this constructor to resume the traversal of a RD-SEFF. All information required to resume
     * the traversal are contained in the specified traversal {@code state}.
     * 
     * @param model
     *            the model
     * @param state
     *            the traversal state
     */
    public ResumeSeffTraversalEvent(final EventSimModel model, final RequestState state) {
        super(model, "ResumeSeffTraversalEvent");
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final Request who) {
        SeffBehaviourInterpreter interpreter = who.getModel().getSeffInterpreter();
        interpreter.resumeTraversal(who, this.state);
    }

}
