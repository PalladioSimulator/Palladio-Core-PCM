package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;

import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.command.usage.FindActionInUsageBehaviour;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalInstruction;

/**
 * TODO: adjust javadoc since the term scope is slightly outdated and should be better denoted by
 * the level of traversal hierarchy.
 * 
 * Use this instruction to continue the traversal with a specified {@link ScenarioBehaviour}. This
 * opens a new scope on the {@link TraversalStateStack}. As soon as the specified behaviour has been
 * traversed completely, the previous scope is restored.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraverseUsageBehaviourInstruction implements ITraversalInstruction<AbstractUserAction, UserState>, IUsageTraversalInstruction {

    private final AbstractEventSimModel model;
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
    public TraverseUsageBehaviourInstruction(final AbstractEventSimModel model, final ScenarioBehaviour behaviour,
            final AbstractUserAction actionAfterCompletion) {
        this.model = model;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

	/**
     * {@inheritDoc}
     */
    @Override
    public AbstractUserAction process(final UserState state) {
        state.setPreviousPosition(state.getCurrentPosition());
        state.setCurrentPosition(this.actionAfterCompletion);

        state.pushStackFrame();

        final Start start = this.model.execute(new FindActionInUsageBehaviour<Start>(this.behaviour, Start.class));
        state.setCurrentPosition(start);
        return start;
    }

}
