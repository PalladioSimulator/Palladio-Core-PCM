package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.instructions.UsageTraversalInstructionFactory;

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
