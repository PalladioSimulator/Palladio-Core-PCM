package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class ExternalCallActionStrategy implements ISeffTraversalStrategy<ExternalCallAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final ExternalCallAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        // find the component which provides the required call
        final SimulatedComponentInstance currentComponent = state.getStack().currentScope().getComponent();
        final SimulatedComponentInstance providingComponent = currentComponent.findProvidingComponent(action
                .getCalledService_ExternalService());
        final ResourceDemandingSEFF seff = providingComponent.getSeff(action.getCalledService_ExternalService());

        // "When executing a call to another component a new stack frame is pushed on the stack
        // without a parent frame. This prevents the access to variables defined in the stack frame
        // of the calling service." [Dissertation Steffen Becker, p. 131]
        // The newly opened scope is being closed in the StopActionTraversalStrategy. 
//        request.getContext().getStack().createAndPushNewStackFrame();

        return new TraverseResourceDemandingBehaviour(request.getModel(), seff, providingComponent, action
                .getSuccessor_AbstractAction());
    }

}
