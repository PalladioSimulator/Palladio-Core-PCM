package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.Start;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseNextAction;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions.TraverseUsageBehaviourInstruction;

/**
 * This traversal strategy is responsible for {@link Start} actions.
 * 
 * @author Philipp Merkle
 * 
 */
public class StartTraversalStrategy implements ITraversalStrategy<AbstractUserAction, Start, User, UserState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction, UserState> traverse(final Start start, final User user, final UserState state) {
    	return new TraverseNextAction<>(start.getSuccessor());
    }

}
