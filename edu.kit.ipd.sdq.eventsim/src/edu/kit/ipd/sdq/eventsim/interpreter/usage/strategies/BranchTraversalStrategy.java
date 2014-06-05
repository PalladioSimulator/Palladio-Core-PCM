package edu.kit.ipd.sdq.eventsim.interpreter.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

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
    public IUsageTraversalInstruction traverse(final Branch branch, final User user, final UserState state) {
        EventSimModel model = user.getModel();
        ScenarioBehaviour behaviour = null;
        double sum = 0;
        final double rand = model.getRandomGenerator().random();
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

        return UsageTraversalInstructionFactory.traverseScenarioBehaviour(user.getModel(), behaviour, branch
                .getSuccessor());
    }

}
