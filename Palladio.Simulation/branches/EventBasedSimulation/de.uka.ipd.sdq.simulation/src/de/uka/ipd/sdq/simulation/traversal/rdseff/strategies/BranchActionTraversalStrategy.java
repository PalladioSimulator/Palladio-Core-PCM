package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import java.util.List;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class BranchActionTraversalStrategy implements ISeffTraversalStrategy<BranchAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final BranchAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        ResourceDemandingBehaviour behaviour = null;

        final List<AbstractBranchTransition> branches = action.getBranches_Branch();
        if (branches.isEmpty()) {
            throw new UnexpectedModelStructureException("No branch transitions could be found for branch "
                    + PCMEntityHelper.toString(action));
        }

        final AbstractBranchTransition firstTransition = branches.get(0);
        if (firstTransition instanceof ProbabilisticBranchTransition) {
            double sum = 0;
            // TODO Use random number generator
            final double rand = Math.random();
            boolean enteredTransition = false;
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
            assert (enteredTransition) : "No branch transition has been entered.";
        } else if (firstTransition instanceof GuardedBranchTransition) {
            // TODO implement guarded branch transition
            throw new RuntimeException("Guarded branch transitions are not supported yet.");
        } else {
            throw new UnexpectedModelStructureException(
                    "The branch transiation is expected to be either a ProbabilisticBranchTransition or a GuardedBranchTransition, but found a "
                            + firstTransition.eClass().getName());
        }

        // push a new stack frame
//        request.getContext().getStack().createAndPushNewStackFrame(request.getContext().getStack().currentStackFrame());
        
        return new TraverseResourceDemandingBehaviour(request.getModel(), behaviour, state.getStack().currentScope()
                .getComponent(), action.getSuccessor_AbstractAction());
    }

}
