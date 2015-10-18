package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.StopAction;

import edu.kit.ipd.sdq.eventsim.api.events.SystemRequestProcessed;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.EndTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseAfterLeavingScope;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

/**
 * This traversal strategy is responsible for {@link StopAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class StopActionTraversalStrategy implements ITraversalStrategy<AbstractAction, StopAction, Request, RequestState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction, RequestState> traverse(final StopAction stop, final Request request, final RequestState state) {
        if (state.hasOpenScope()) {
        	return new TraverseAfterLeavingScope<>();
        } else {
            if (state.isForkedRequestState()) {            	
                return new EndTraversal<>();
            } else {
            	
            	// fire seff traversal completed event
            	ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
            	middleware.triggerEvent(new SystemRequestProcessed(request));

                return new EndTraversal<>();
            }

        }
    }

}
