package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

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
    public ITraversalInstruction<AbstractUserAction> traverse(final Stop stop, final User user,
            final TraversalState<AbstractUserAction> state) {
        if (state.getStack().getSize() > 1) {
            return new TraverseAfterLeavingScope<AbstractUserAction>();
        } else {
            return new EndTraversal<AbstractUserAction>();
        }
    }

}
