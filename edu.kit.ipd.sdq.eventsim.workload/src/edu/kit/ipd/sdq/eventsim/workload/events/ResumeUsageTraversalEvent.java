package edu.kit.ipd.sdq.eventsim.workload.events;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageBehaviourInterpreter;

/**
 * Schedule this event to resume the traversal of a {@link UsageScenario}.
 * <p>
 * The {@link User} that is supposed to traverse the scenario, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class ResumeUsageTraversalEvent extends AbstractSimEventDelegator<User> {

    private final UserState state;
	private EventSimWorkloadModel model;

    /**
     * Use this constructor to resume the traversal of a {@link UsageScenario}. All information
     * required to resume the traversal are contained in the specified traversal {@code state}.
     * 
     * @param model
     *            the model
     * @param state
     *            the traversal state
     */
    public ResumeUsageTraversalEvent(final EventSimWorkloadModel model, final UserState state) {
        super(model.getSimulationMiddleware().getSimulationModel(), "ResumeUsageTraversalEvent");
        this.model = model;
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final User who) {
        UsageBehaviourInterpreter interpreter = this.model.getUsageInterpreter();
        interpreter.resumeTraversal(who, this.state);
    }

}
