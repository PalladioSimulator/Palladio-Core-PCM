package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import java.util.LinkedList;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.ITraversalStrategyState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class InternalActionTraversalStrategy implements ISeffTraversalStrategy<InternalAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final InternalAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        final EventSimModel model = request.getModel();

        // restore or create state
        InternalActionTraversalState internalState = (InternalActionTraversalState) state.getStack().currentScope()
                .getState(action);
        if (internalState == null) {
            internalState = this.initialiseState(request, action, state);
        }

        final ParametricResourceDemand d = internalState.dequeueDemand();
        final ProcessingResourceType resourceType = d.getRequiredResource_ParametricResourceDemand();
        final PCMRandomVariable demandSpecification = d.getSpecification_ParametericResourceDemand();

        final double demand = NumberConverter.toDouble(request.getContext().evaluate(
                demandSpecification.getSpecification()));

        final SimulatedResourceContainer resourceContainer = request.getContext().getResourceContainer(); 
        final SimulatedActiveResource resource = resourceContainer.getResourceByType(resourceType);
        if (resource == null) {
            throw new RuntimeException("Could not find a resource of type " + resourceType.getEntityName());
        }

        // TODO this can be done more elegant
//        request.setServedEvent(new TraverseResourceDemandingBehaviourEvent(model, state));

        resource.consumeResource(request.getProcess(), demand);

        if (internalState.hasPendingDemands()) {
            return new InterruptTraversal<AbstractAction>(action);
        } else {
            return new InterruptTraversal<AbstractAction>(action.getSuccessor_AbstractAction());
        }

    }

    private InternalActionTraversalState initialiseState(final Request request, final InternalAction action,
            final TraversalState<AbstractAction> context) {
        // create and set state
        final InternalActionTraversalState state = new InternalActionTraversalState();
        for (final ParametricResourceDemand d : action.getResourceDemand_Action()) {
            state.enqueueDemand(d);
        }

        context.getStack().currentScope().addState(action, state);

        return state;
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
