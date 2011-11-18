package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.events.ResumeUsageTraversalEvent;
import de.uka.ipd.sdq.simulation.traversal.seff.IRequestTraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.instructions.RequestTraversalInstructionFactory;
import de.uka.ipd.sdq.simulation.traversal.state.RequestState;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;

/**
 * This traversal strategy is responsible for {@link StopAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class StopActionTraversalStrategy implements ISeffTraversalStrategy<StopAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final StopAction stop, final Request request,
            final RequestState state) {
        if (state.hasOpenScope()) {
            return RequestTraversalInstructionFactory.traverseAfterLeavingScope();
        } else {
            UserState parentState = state.getUsageState();
            // the parent state might be null, if the stop action is part of a fork
            if (parentState != null) {
                new ResumeUsageTraversalEvent(request.getModel(), parentState).schedule(request.getUser(), 0);
            }
            return RequestTraversalInstructionFactory.endTraversal();
        }
    }

}
