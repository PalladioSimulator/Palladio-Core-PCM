package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

public class StopTraversalStrategy implements IUsageTraversalStrategy<Stop> {

    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Stop stop, final User user,
            final TraversalState<AbstractUserAction> state) {
//        // remove stack frame, if the action is the start of a usage scenario
//        if (UsagemodelPackage.eINSTANCE.getUsageScenario().isInstance(stop.eContainer())) {
//            user.getContext().getStack().removeStackFrame();
//        }
        
        if (state.getStack().getSize() > 1) {
            return new TraverseAfterLeavingScope<AbstractUserAction>();
        } else {
            return new EndTraversal<AbstractUserAction>();
        }
    }

}
