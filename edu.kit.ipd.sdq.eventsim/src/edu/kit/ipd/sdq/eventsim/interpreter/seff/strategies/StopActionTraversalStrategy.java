package edu.kit.ipd.sdq.eventsim.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.StopAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;

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
    public IRequestTraversalInstruction traverse(final StopAction stop, final Request request, final RequestState state) {
        if (state.hasOpenScope()) {
            return RequestTraversalInstructionFactory.traverseAfterLeavingScope();
        } else {
            if (state.isForkedRequestState()) {
                return RequestTraversalInstructionFactory.endTraversal();
            } else {
                UserState parentState = state.getUsageState();
                new ResumeUsageTraversalEvent(request.getModel(), parentState).schedule(request.getUser(), 0);
                return RequestTraversalInstructionFactory.endTraversal();
            }

        }
    }

}
