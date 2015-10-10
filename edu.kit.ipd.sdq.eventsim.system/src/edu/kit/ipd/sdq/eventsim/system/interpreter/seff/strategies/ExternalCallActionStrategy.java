package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;

import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.TraverseComponentBehaviourInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;

/**
 * This traversal strategy is responsible for {@link ExternalCallAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class ExternalCallActionStrategy implements ITraversalStrategy<AbstractAction, ExternalCallAction, Request, RequestState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction, RequestState> traverse(final ExternalCallAction action,
            final Request request, final RequestState state) {
        // find the component which provides the required call
        final ComponentInstance currentComponent = state.getComponent();
        final ComponentInstance providingComponent = currentComponent.getProvidingComponent(action
                .getCalledService_ExternalService());
        final ResourceDemandingSEFF seff = providingComponent.getServiceEffectSpecification(action
                .getCalledService_ExternalService());

        return new TraverseComponentBehaviourInstruction(request.getEventSimModel(), seff, providingComponent, action.getSuccessor_AbstractAction());
    }

}
