package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import java.util.LinkedList;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.events.ResumeSeffTraversalEvent;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.traversal.seff.IRequestTraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.instructions.RequestTraversalInstructionFactory;
import de.uka.ipd.sdq.simulation.traversal.state.ITraversalStrategyState;
import de.uka.ipd.sdq.simulation.traversal.state.RequestState;

/**
 * This traversal strategy is responsible for {@link InternalAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class InternalActionTraversalStrategy implements ISeffTraversalStrategy<InternalAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final InternalAction action, final Request request,
            final RequestState state) {
        // restore or create state
        InternalActionTraversalState internalState = (InternalActionTraversalState) state.getInternalState(action);
        if (internalState == null) {
            internalState = this.initialiseState(request, action, state);
        }

        final ParametricResourceDemand d = internalState.dequeueDemand();
        final ProcessingResourceType resourceType = d.getRequiredResource_ParametricResourceDemand();
        final PCMRandomVariable demandSpecification = d.getSpecification_ParametericResourceDemand();

        final double demand = NumberConverter.toDouble(state.getStoExContext().evaluate(
                demandSpecification.getSpecification()));

        final SimulatedResourceContainer resourceContainer = state.getComponent().getResourceContainer();
        final SimActiveResource resource = resourceContainer.getResourceByType(resourceType);
        if (resource == null) {
            throw new RuntimeException("Could not find a resource of type " + resourceType.getEntityName());
        }

        resource.consumeResource(request.getSimulatedProcess(), demand);

        if (internalState.hasPendingDemands()) {
            request.passivate(new ResumeSeffTraversalEvent(request.getModel(), state));
            return RequestTraversalInstructionFactory.interruptTraversal(action);
        } else {
            request.passivate(new ResumeSeffTraversalEvent(request.getModel(), state));
            return RequestTraversalInstructionFactory.interruptTraversal(action.getSuccessor_AbstractAction());
        }

    }

    private InternalActionTraversalState initialiseState(final Request request, final InternalAction action,
            final RequestState state) {
        // create and set state
        final InternalActionTraversalState internalState = new InternalActionTraversalState();
        for (final ParametricResourceDemand d : action.getResourceDemand_Action()) {
            internalState.enqueueDemand(d);
        }

        state.addInternalState(action, internalState);

        return internalState;
    }

    private class InternalActionTraversalState implements ITraversalStrategyState {

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
