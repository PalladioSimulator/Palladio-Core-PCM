package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class StartActionTraversalStrategy implements ISeffTraversalStrategy<StartAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final StartAction action, final Request request,
            final TraversalState<AbstractAction> state) {
//        if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isInstance(action.eContainer())) {
//            TraversalStackFrame<AbstractAction> scope = state.getStack().currentScope();
//            scope.setResultStackFrame(new SimulatedStackframe<Object>());
//            scope.setMethodBodyStackFrame(request.getContext().getStack().currentStackFrame());
            // TODO
            // if (this.myDefaultComponentStackFrame.getContents().size() > 0) {
            // methodBodyStackFrame.addVariables(this.myDefaultComponentStackFrame);
            // }
            // if (this.myComponentStackFrame.getContents().size() > 0) {
            // methodBodyStackFrame.addVariables(this.myComponentStackFrame);
            // }
//        }
        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
