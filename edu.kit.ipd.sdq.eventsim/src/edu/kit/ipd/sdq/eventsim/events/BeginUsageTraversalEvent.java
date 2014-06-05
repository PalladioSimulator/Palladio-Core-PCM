package edu.kit.ipd.sdq.eventsim.events;

import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.UsageBehaviourInterpreter;

/**
 * Schedule this event to begin the traversal of a {@link UsageScenario}.
 * <p>
 * The {@link User} that is supposed to traverse the scenario, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginUsageTraversalEvent extends AbstractSimEventDelegator<User> {

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
        UsageBehaviourInterpreter interpreter = who.getModel().getUsageInterpreter();
        ScenarioBehaviour behaviour = this.scenario.getScenarioBehaviour_UsageScenario();
        interpreter.beginTraversal(who, behaviour);
    }

}
