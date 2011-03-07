package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.events.TraverseScenarioBehaviourEvent;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class StopActionTraversalStrategy implements ISeffTraversalStrategy<StopAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final StopAction stop, final Request request,
            final TraversalState<AbstractAction> state) {
        // pop stack frame
//        request.getContext().getStack().removeStackFrame();

        // copy results to current stack frame, if there are any
//        if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isInstance(stop.eContainer())) {
//            if (state.getStack().currentScope().getResultStackFrame() != null) {
//                request.getContext().getStack().currentStackFrame().addVariables(
//                        state.getStack().currentScope().getResultStackFrame());
//                state.getStack().currentScope().setResultStackFrame(null);
//            }
//        }

        if (state.getStack().getSize() > 1) {
            return new TraverseAfterLeavingScope<AbstractAction>();
        } else {
            new TraverseScenarioBehaviourEvent(request.getModel(), request.getUser().getTraversalState()).schedule(
                    request.getUser(), 0);
            return new EndTraversal<AbstractAction>();
        }
    }

}
