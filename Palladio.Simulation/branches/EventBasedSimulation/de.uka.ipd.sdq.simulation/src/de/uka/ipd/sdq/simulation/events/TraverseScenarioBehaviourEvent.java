package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;

/**
 * This event can be used to start or resume the traversal of an usage scenario. The user which is
 * supposed to traverse the scenario, is passed to the {@link #schedule(User, double)} method.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraverseScenarioBehaviourEvent extends AbstractSimEvent<EventSimModel, User> {

    private TraversalState<AbstractUserAction> context;
    private ScenarioBehaviour behaviour;

    /**
     * Use this constructor to start the traversal of the specified usage scenario.
     * 
     * @param model
     * @param behaviour
     */
    public TraverseScenarioBehaviourEvent(EventSimModel model, ScenarioBehaviour behaviour) {
        super(model, "Traverse scenario event");
        this.behaviour = behaviour;
    }

    /**
     * Use this constructor to resume the traversal of an usage scenario. The state of the traversal
     * 
     * @param model
     * @param context
     */
    public TraverseScenarioBehaviourEvent(EventSimModel model, TraversalState<AbstractUserAction> context) {
        super(model, "Traverse scenario event");
        this.context = context;
    }

    @Override
    public void eventRoutine(User who) {
        if (this.behaviour != null) {
            new UsageBehaviorTraversal(who, who.getTraversalState(), behaviour).beginTraversal();
        } else {
            new UsageBehaviorTraversal(who, context).resumeTraversal();
        }

    }

}
