package de.uka.ipd.sdq.simulation.interpreter.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;
import de.uka.ipd.sdq.simulation.interpreter.usage.IUsageTraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.usage.IUsageTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.usage.instructions.UsageTraversalInstructionFactory;

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
    public IUsageTraversalInstruction traverse(final Start start, final User user, final UserState state) {
        return UsageTraversalInstructionFactory.traverseNextAction(start.getSuccessor());
    }

}
