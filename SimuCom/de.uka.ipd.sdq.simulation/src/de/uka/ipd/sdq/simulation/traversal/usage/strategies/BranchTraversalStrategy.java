package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseScenarioBehaviour;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

/**
 * This traversal strategy is responsible for {@link Branch} actions.
 * 
 * @author Philipp Merkle
 * 
 */
public class BranchTraversalStrategy implements IUsageTraversalStrategy<Branch> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Branch branch, final User user,
            final TraversalState<AbstractUserAction> state) {
        EventSimModel model = user.getModel();
        ScenarioBehaviour behaviour = null;
        double sum = 0;
        final double rand = model.getConfiguration().getRandomGenerator().random();
        boolean enteredTransition = false;
        for (final BranchTransition t : branch.getBranchTransitions_Branch()) {
            assert (sum >= 0 && sum <= 1) : "Expected sum to be in the interval [0, 1], but was " + sum;
            final double p = t.getBranchProbability();
            if (rand >= sum && rand < sum + p) {
                enteredTransition = true;
                behaviour = t.getBranchedBehaviour_BranchTransition();
            }
            sum += p;
        }
        // TODO log a warn message
        assert (enteredTransition) : "No branch transition has been entered.";

        return new TraverseScenarioBehaviour(user.getModel(), behaviour, branch.getSuccessor());
    }

}
