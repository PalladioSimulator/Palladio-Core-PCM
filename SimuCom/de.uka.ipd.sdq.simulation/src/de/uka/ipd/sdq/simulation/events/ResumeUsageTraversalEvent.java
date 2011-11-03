package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;

/**
 * Schedule this event to resume the traversal of a {@link UsageScenario}.
 * <p>
 * The {@link User} that is supposed to traverse the scenario, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class ResumeUsageTraversalEvent extends AbstractSimEvent<EventSimModel, User> {

    private final TraversalState<AbstractUserAction> state;

    /**
     * Use this constructor to resume the traversal of a {@link UsageScenario}. All information
     * required to resume the traversal are contained in the specified traversal {@code state}.
     * 
     * @param model
     *            the model
     * @param state
     *            the traversal state
     */
    public ResumeUsageTraversalEvent(final EventSimModel model, final TraversalState<AbstractUserAction> state) {
        super(model, "ResumeUsageTraversalEvent");
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final User who) {
        new UsageBehaviorTraversal(who).resumeTraversal(this.state);
    }

}
