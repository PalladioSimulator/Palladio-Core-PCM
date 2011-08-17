package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.events.ResumeUsageTraversalEvent;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

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
    @SuppressWarnings("unchecked")
    @Override
    public ITraversalInstruction<AbstractAction> traverse(final StopAction stop, final Request request,
            final TraversalState<AbstractAction> state) {
        if (state.getStack().getSize() > 1) {
            return new TraverseAfterLeavingScope<AbstractAction>();
        } else {
            TraversalState<AbstractUserAction> parentState = (TraversalState<AbstractUserAction>) state
                    .getParentState();
            // the parent state might be null, if the stop action is part of a fork
            if (parentState != null) {
                new ResumeUsageTraversalEvent(request.getModel(), parentState).schedule(request.getUser(), 0);
            }
            return new EndTraversal<AbstractAction>();
        }
    }

}
