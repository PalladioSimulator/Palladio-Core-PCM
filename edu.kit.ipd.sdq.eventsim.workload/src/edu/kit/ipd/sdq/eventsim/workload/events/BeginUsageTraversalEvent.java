package edu.kit.ipd.sdq.eventsim.workload.events;

import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.api.events.WorkloadUserSpawn;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageBehaviourInterpreter;

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
	private EventSimWorkloadModel model;

    /**
     * Use this constructor to begin the traversal of the specified {@link UsageScenario}.
     * 
     * @param model
     *            the model
     * @param scenario
     *            the usage scenario that is to be traversed
     */
    public BeginUsageTraversalEvent(final EventSimWorkloadModel model, final UsageScenario scenario) {
        super(model.getSimulationMiddleware().getSimulationModel(), "BeginUsageTraversalEvent");
        this.model = model;
        this.scenario = scenario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final User who) {
    	// trigger event that a user spawned
    	model.getSimulationMiddleware().triggerEvent(new WorkloadUserSpawn(who));

        UsageBehaviourInterpreter interpreter = this.model.getUsageInterpreter();
        ScenarioBehaviour behaviour = this.scenario.getScenarioBehaviour_UsageScenario();
        interpreter.beginTraversal(who, behaviour);
    }

}
