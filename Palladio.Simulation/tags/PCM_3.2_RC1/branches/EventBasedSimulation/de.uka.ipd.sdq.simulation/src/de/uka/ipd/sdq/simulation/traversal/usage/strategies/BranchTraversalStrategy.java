package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseUsageBehaviour;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

public class BranchTraversalStrategy implements IUsageTraversalStrategy<Branch> {

    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Branch branch, final User user,
            final TraversalState<AbstractUserAction> state) {
        ScenarioBehaviour behaviour = null;
        double sum = 0;
        // TODO Use random number generator
        final double rand = Math.random();
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
        // TODO log warn
        assert (enteredTransition) : "No branch transition has been entered.";

        return new TraverseUsageBehaviour(user.getModel(), behaviour, branch.getSuccessor());
    }

}
