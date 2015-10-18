package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import java.util.LinkedList;
import java.util.Queue;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourcetype.ResourceType;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.InternalAction;
import org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand;

import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.api.IActiveResource;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.InterruptTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.state.ITraversalStrategyState;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

/**
 * This traversal strategy is responsible for {@link InternalAction}s.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class InternalActionTraversalStrategy implements ITraversalStrategy<AbstractAction, InternalAction, Request, RequestState> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversalInstruction<AbstractAction, RequestState> traverse(final InternalAction action, final Request request, final RequestState state) {
		// restore or create state
		InternalActionTraversalState internalState = (InternalActionTraversalState) state.getInternalState(action);
		if (internalState == null) {
			internalState = this.initialiseState(request, action, state);
		}
		request.setRequestState(state);

		final ParametricResourceDemand demand = internalState.dequeueDemand();

		// fetch active resource simulation component
		ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();

		double evaluatedDemand = NumberConverter.toDouble(state.getStoExContext().evaluate(demand.getSpecification_ParametericResourceDemand().getSpecification()));
		ResourceType type = demand.getRequiredResource_ParametricResourceDemand();

		ResourceContainer resourceContainer = state.getComponent().getResourceContainer().getSpecification();
		String containerDescriptor = resourceContainer.getEntityName() + "#" + resourceContainer.getId();
		String resourceTypeDescriptor = type.getEntityName() + "#" + type.getId();

		// fetch simulation component based on context
//		EventSimSystem system = (EventSimSystem) Activator.getDefault().getSystemComponent();
//		List<IActiveResource> activeResourceComponents = system.getActiveResourceComponents();
//		ActiveResourceSimulationContext context = new ActiveResourceSimulationContext(containerDescriptor, resourceTypeDescriptor);
//		IActiveResource activeResource = (IActiveResource) middleware.getSimulationComponent(EventSimSystem.class, IActiveResource.class, activeResourceComponents, context);
		
		// consume the resource demand
        // TODO get rid of cast
		((EventSimSystemModel) request.getEventSimModel()).getActiveResourceCallback().consume(request,
				state.getComponent().getResourceContainer().getSpecification(), type, evaluatedDemand);

		EventSimSystemModel systemModel = (EventSimSystemModel) request.getEventSimModel();
		if (internalState.hasPendingDemands()) {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return new InterruptTraversal<>(action);
		} else {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return new InterruptTraversal<>(action.getSuccessor_AbstractAction());
		}

	}

	private InternalActionTraversalState initialiseState(final Request request, final InternalAction action, final RequestState state) {
		// create and set state
		final InternalActionTraversalState internalState = new InternalActionTraversalState();
		for (final ParametricResourceDemand d : action.getResourceDemand_Action()) {
			internalState.enqueueDemand(d);
		}

		state.addInternalState(action, internalState);

		return internalState;
	}

	private static final class InternalActionTraversalState implements ITraversalStrategyState {

		private final Queue<ParametricResourceDemand> pendingDemands;

		public InternalActionTraversalState() {
			this.pendingDemands = new LinkedList<ParametricResourceDemand>();
		}

		public void enqueueDemand(final ParametricResourceDemand demand) {
			this.pendingDemands.add(demand);
		}

		public ParametricResourceDemand dequeueDemand() {
			return this.pendingDemands.poll();
		}

		public boolean hasPendingDemands() {
			return !this.pendingDemands.isEmpty();
		}

	}

}
