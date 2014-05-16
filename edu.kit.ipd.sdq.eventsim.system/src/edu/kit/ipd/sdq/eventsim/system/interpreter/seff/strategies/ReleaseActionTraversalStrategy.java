package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.simcomp.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

/**
 * This traversal strategy is responsible for {@link ReleaseAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class ReleaseActionTraversalStrategy implements ISeffTraversalStrategy<ReleaseAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(ReleaseAction action, Request request, RequestState state) {
        if (!action.getResourceDemand_Action().isEmpty()) {
            throw new EventSimException("Parametric resource demands are not yet supported for ReleaseActions.");
        }

		// store EventSim specific state to the request
        request.setRequestState(state);

        // fetch passive resource simulation component
        // TODO (SimComp): provide passive resource context
        ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
        IPassiveResource passiveResourceSimulation = (IPassiveResource) middleware.getSimulationComponent(IPassiveResource.class, null);

        final PassiveResource passiveResouce = action.getPassiveResource_ReleaseAction();
        AssemblyContext ctx = state.getComponent().getAssemblyCtx();
        passiveResourceSimulation.release(request, ctx, passiveResouce, 1);

        return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
    }

}
