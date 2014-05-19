package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.StopAction;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.system.events.SystemRequestProcessed;

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
            	
            	// fire seff traversal completed event
            	ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
            	middleware.triggerEvent(new SystemRequestProcessed(request));

                return RequestTraversalInstructionFactory.endTraversal();
            }

        }
    }

}
