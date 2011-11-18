package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviourInterpreter;

/**
 * Schedule this event to begin the traversal of a {@link UsageScenario}.
 * <p>
 * The {@link User} that is supposed to traverse the scenario, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginUsageTraversalEvent extends AbstractSimEvent<EventSimModel, User> {

    private final UsageScenario scenario;

    /**
     * Use this constructor to begin the traversal of the specified {@link UsageScenario}.
     * 
     * @param model
     *            the model
     * @param scenario
     *            the usage scenario that is to be traversed
     */
    public BeginUsageTraversalEvent(final EventSimModel model, final UsageScenario scenario) {
        super(model, "BeginUsageTraversalEvent");
        this.scenario = scenario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final User who) {
        ScenarioBehaviour behaviour = this.scenario.getScenarioBehaviour_UsageScenario();
        UsageBehaviourInterpreter.instance().beginTraversal(who, behaviour);
    }

}
