package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

/**
 * This traversal strategy is responsible for {@link Start} actions.
 * 
 * @author Philipp Merkle
 *
 */
public class StartTraversalStrategy implements IUsageTraversalStrategy<Start> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Start start, final User user,
            final TraversalState<AbstractUserAction> state) {
        return new TraverseNextAction<AbstractUserAction>(start.getSuccessor());
    }

}
