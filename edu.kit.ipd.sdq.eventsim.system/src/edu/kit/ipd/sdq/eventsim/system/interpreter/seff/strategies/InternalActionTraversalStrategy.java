package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.ITraversalStrategyState;
import edu.kit.ipd.sdq.eventsim.system.Activator;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystem;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.resource.active.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.resource.active.context.ActiveResourceSimulationContext;

/**
 * This traversal strategy is responsible for {@link InternalAction}s.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class InternalActionTraversalStrategy implements ISeffTraversalStrategy<InternalAction> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRequestTraversalInstruction traverse(final InternalAction action, final Request request, final RequestState state) {
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

		// fetch simulation component based on context TODO (SimComp): Fetch container information
        EventSimSystem system = (EventSimSystem) Activator.getDefault().getSystemComponent();
		List<IActiveResource> activeResourceComponents = system.getActiveResourceComponents();
		ActiveResourceSimulationContext context = new ActiveResourceSimulationContext(null, type.getEntityName());
		IActiveResource activeResource = (IActiveResource) middleware.getSimulationComponent(IActiveResource.class, activeResourceComponents, context);

        // consume the resource demand
		activeResource.consume(request, state.getComponent().getResourceContainer().getSpecification(),  type, evaluatedDemand);
		
		EventSimSystemModel systemModel = (EventSimSystemModel) request.getEventSimModel();
		if (internalState.hasPendingDemands()) {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return RequestTraversalInstructionFactory.interruptTraversal(action);
		} else {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return RequestTraversalInstructionFactory.interruptTraversal(action.getSuccessor_AbstractAction());
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
