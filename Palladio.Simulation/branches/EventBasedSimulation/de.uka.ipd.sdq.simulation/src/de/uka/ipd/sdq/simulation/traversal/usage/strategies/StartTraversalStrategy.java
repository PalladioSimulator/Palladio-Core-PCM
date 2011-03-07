package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

public class StartTraversalStrategy implements IUsageTraversalStrategy<Start> {

    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Start start, final User user,
            final TraversalState<AbstractUserAction> state) {
//        // create new stack frame, if the action is the start of a usage scenario
//        if (UsagemodelPackage.eINSTANCE.getUsageScenario().isInstance(start.eContainer())) {
//            user.getContext().getStack().createAndPushNewStackFrame();
//        }

        return new TraverseNextAction<AbstractUserAction>(start.getSuccessor());
    }

}
