package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import java.util.List;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.TraverseComponentBehaviourInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This traversal strategy is responsible for {@link BranchAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class BranchActionTraversalStrategy implements ITraversalStrategy<AbstractAction, BranchAction, Request, RequestState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction, RequestState> traverse(final BranchAction action, final Request request, final RequestState state) {
        AbstractEventSimModel model = request.getEventSimModel();
        ResourceDemandingBehaviour behaviour = null;

        final List<AbstractBranchTransition> branches = action.getBranches_Branch();
        if (branches.isEmpty()) {
            throw new UnexpectedModelStructureException("No branch transitions could be found for branch "
                    + PCMEntityHelper.toString(action));
        }

        final AbstractBranchTransition firstTransition = branches.get(0);
        boolean enteredTransition = false;
        if (firstTransition instanceof ProbabilisticBranchTransition) {
            // handle probabilistic branch transition
            double sum = 0;
            final double rand = model.getSimulationMiddleware().getRandomGenerator().random();

            for (final AbstractBranchTransition t : action.getBranches_Branch()) {
                final ProbabilisticBranchTransition transition = (ProbabilisticBranchTransition) t;
                assert (sum >= 0 && sum <= 1) : "Expected sum to be in the interval [0, 1], but was " + sum;
                final double p = transition.getBranchProbability();
                if (rand >= sum && rand < sum + p) {
                    enteredTransition = true;
                    behaviour = transition.getBranchBehaviour_BranchTransition();
                }
                sum += p;
            }
        } else if (firstTransition instanceof GuardedBranchTransition) {
            // handle guarded branch transition
            for (final AbstractBranchTransition t : action.getBranches_Branch()) {
                final GuardedBranchTransition transition = (GuardedBranchTransition) t;
                String conditionSpec = transition.getBranchCondition_GuardedBranchTransition().getSpecification();
                Boolean condition = state.getStoExContext().evaluate(conditionSpec, Boolean.class);
                if (condition.booleanValue() == true) {
                    enteredTransition = true;
                    behaviour = transition.getBranchBehaviour_BranchTransition();
                }
            }
        } else {
            throw new UnexpectedModelStructureException(
                    "The branch transition is expected to be either a ProbabilisticBranchTransition or a GuardedBranchTransition, but found a "
                            + firstTransition.eClass().getName());
        }
        assert (enteredTransition) : "No branch transition has been entered.";

        return new TraverseComponentBehaviourInstruction(request.getEventSimModel(), behaviour, state.getComponent(), action.getSuccessor_AbstractAction());
    }

}
