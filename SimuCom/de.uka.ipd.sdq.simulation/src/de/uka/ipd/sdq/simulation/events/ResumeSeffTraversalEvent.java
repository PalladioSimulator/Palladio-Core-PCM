package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.traversal.state.RequestState;

/**
 * Schedule this event to resume the traversal of a {@link ResourceDemandingSEFF} (RD-SEFF).
 * <p>
 * The {@link Request} that is supposed to traverse the SEFF, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class ResumeSeffTraversalEvent extends AbstractSimEvent<EventSimModel, Request> {

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
        SeffBehaviourInterpreter.instance().resumeTraversal(who, this.state);
    }

}
