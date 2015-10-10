package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.Stop;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.EndTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseAfterLeavingScope;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;

/**
 * This traversal strategy is responsible for {@link Stop} actions.
 * 
 * @author Philipp Merkle
 *
 */
public class StopTraversalStrategy implements ITraversalStrategy<AbstractUserAction, Stop, User, UserState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction, UserState> traverse(final Stop stop, final User user,
            final UserState state) {
        if (state.hasOpenScope()) {
        	return new TraverseAfterLeavingScope<>();
        } else {
        	return new EndTraversal<>();
        }
    }

}
