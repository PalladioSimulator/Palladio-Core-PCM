package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;

import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions.UsageTraversalInstructionFactory;

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
    	AbstractEventSimModel model = user.getEventSimModel();
        ScenarioBehaviour behaviour = null;
        double sum = 0;
        final double rand = model.getSimulationMiddleware().getRandomGenerator().random();
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

        return UsageTraversalInstructionFactory.traverseScenarioBehaviour(model, behaviour, branch.getSuccessor());
    }

}
