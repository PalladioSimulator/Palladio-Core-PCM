package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.simcomp.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

/**
 * This traversal strategy is responsible for {@link AcquireAction}s.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class AcquireActionTraversalStrategy implements ISeffTraversalStrategy<AcquireAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final AcquireAction action, final Request request, final RequestState state) {
        if (!action.getResourceDemand_Action().isEmpty()) {
            throw new EventSimException("Parametric resource demands are not yet supported for AcquireActions.");
        }

		// store EventSim specific state to the request
        request.setRequestState(state);

        // fetch passive resource simulation component
        // TODO (SimComp): provide passive resource context
        ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
        IPassiveResource passiveResourceSimulation = (IPassiveResource) middleware.getSimulationComponent(IPassiveResource.class, null);

        final PassiveResource passiveResouce = action.getPassiveresource_AcquireAction();
        final boolean acquired = passiveResourceSimulation.acquire(request, passiveResouce, 1, false, action.getTimeoutValue());
        
        if (acquired) {
            return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
        } else {
        	EventSimSystemModel model = (EventSimSystemModel) request.getEventSimModel();
            request.passivate(new ResumeSeffTraversalEvent(model, state));

            // here, it is assumed that the passive resource grants access to waiting processes as
            // soon as the requested capacity becomes available. Thus, we do not need to acquire the
            // passive resource again as this will be done within the release method. Accordingly
            // the traversal resumes with the successor of this action.
            return RequestTraversalInstructionFactory.interruptTraversal(action.getSuccessor_AbstractAction());
        }
    }

}
