package de.uka.ipd.sdq.simulation.interpreter.usage.instructions;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.usage.FindActionInUsageBehaviour;
import de.uka.ipd.sdq.simulation.interpreter.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;
import de.uka.ipd.sdq.simulation.interpreter.usage.IUsageTraversalInstruction;

/**
 * Use this instruction to continue the traversal with a specified {@link ScenarioBehaviour}. This
 * opens a new scope on the {@link TraversalStateStack}. As soon as the specified behaviour has been
 * traversed completely, the previous scope is restored.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraverseUsageBehaviourInstruction implements ITraversalInstruction<AbstractUserAction, UserState>,
        IUsageTraversalInstruction {

    private final EventSimModel model;
    private final ScenarioBehaviour behaviour;
    private final AbstractUserAction actionAfterCompletion;

    /**
     * Constructs a new instruction.
     * 
     * @param model
     *            the simulation model
     * @param behaviour
     *            the behaviour that is to be traversed in a new scope
     * @param actionAfterCompletion
     *            the action that is to be traversed after leaving the scope
     */
    public TraverseUsageBehaviourInstruction(final EventSimModel model, final ScenarioBehaviour behaviour,
            final AbstractUserAction actionAfterCompletion) {
        this.model = model;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractUserAction process(final UserState scope) {
        scope.setPreviousPosition(scope.getCurrentPosition());
        scope.setCurrentPosition(this.actionAfterCompletion);

        scope.pushStackFrame();

        final Start start = this.model.execute(new FindActionInUsageBehaviour<Start>(this.behaviour, Start.class));
        scope.setCurrentPosition(start);
        return start;
    }

}
