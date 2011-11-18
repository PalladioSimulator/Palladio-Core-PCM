package de.uka.ipd.sdq.simulation.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.interpreter.seff.IRequestTraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.instructions.TraverseComponentBehaviourInstruction;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;

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
    public IRequestTraversalInstruction traverse(final ExternalCallAction action,
            final Request request, final RequestState state) {
        // find the component which provides the required call
        final ComponentInstance currentComponent = state.getComponent();
        final ComponentInstance providingComponent = currentComponent.getProvidingComponent(action
                .getCalledService_ExternalService());
        final ResourceDemandingSEFF seff = providingComponent.getServiceEffectSpecification(action
                .getCalledService_ExternalService());

        return new TraverseComponentBehaviourInstruction(request.getModel(), seff, providingComponent, action
                .getSuccessor_AbstractAction());
    }

}
