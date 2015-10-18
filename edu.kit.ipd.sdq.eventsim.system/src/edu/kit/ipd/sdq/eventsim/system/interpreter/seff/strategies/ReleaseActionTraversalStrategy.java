package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ReleaseAction;

import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseNextAction;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

/**
 * This traversal strategy is responsible for {@link ReleaseAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class ReleaseActionTraversalStrategy
		implements ITraversalStrategy<AbstractAction, ReleaseAction, Request, RequestState> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversalInstruction<AbstractAction, RequestState> traverse(ReleaseAction action, Request request,
			RequestState state) {
		if (!action.getResourceDemand_Action().isEmpty()) {
			throw new EventSimException("Parametric resource demands are not yet supported for ReleaseActions.");
		}

		// store EventSim specific state to the request
		request.setRequestState(state);

		// fetch passive resource simulation component
		// EventSimSystem system = (EventSimSystem) Activator.getDefault().getSystemComponent();
		// List<IPassiveResource> passiveResourceComponents = system.getPassiveResourceComponents();
		// ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
		// // TODO (SimComp): provide passive resource context
		// IPassiveResource passiveResource = (IPassiveResource)
		// middleware.getSimulationComponent(EventSimSystem.class,IPassiveResource.class, passiveResourceComponents,
		// null);

		final PassiveResource passiveResouce = action.getPassiveResource_ReleaseAction();
		AssemblyContext ctx = state.getComponent().getAssemblyCtx();
		// TODO get rid of cast
		((EventSimSystemModel) request.getEventSimModel()).getReleaseCallback().release(request, ctx, passiveResouce,
				1);

		return new TraverseNextAction<>(action.getSuccessor_AbstractAction());
	}

}
