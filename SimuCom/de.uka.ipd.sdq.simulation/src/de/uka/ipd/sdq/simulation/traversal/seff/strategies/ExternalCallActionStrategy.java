package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * This traversal strategy is responsible for {@link ExternalCallAction}s.
 * 
 * @author Philipp Merkle
 *
 */
public class ExternalCallActionStrategy implements ISeffTraversalStrategy<ExternalCallAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction> traverse(final ExternalCallAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        // find the component which provides the required call
        final ComponentInstance currentComponent = state.getStack().currentScope().getComponent();
        final ComponentInstance providingComponent = currentComponent.getProvidingComponent(action
                .getCalledService_ExternalService());
        final ResourceDemandingSEFF seff = providingComponent.getServiceEffectSpecification(action.getCalledService_ExternalService());

        return new TraverseResourceDemandingBehaviour(request.getModel(), seff, providingComponent, action
                .getSuccessor_AbstractAction());
    }

}
