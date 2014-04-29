package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@link Stop} actions.
 * 
 * @author Philipp Merkle
 *
 */
public class StopTraversalStrategy implements IUsageTraversalStrategy<Stop> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IUsageTraversalInstruction traverse(final Stop stop, final User user,
            final UserState state) {
        if (state.hasOpenScope()) {
            return UsageTraversalInstructionFactory.traverseAfterLeavingScope();
        } else {
            return UsageTraversalInstructionFactory.endTraversal();
        }
    }

}
