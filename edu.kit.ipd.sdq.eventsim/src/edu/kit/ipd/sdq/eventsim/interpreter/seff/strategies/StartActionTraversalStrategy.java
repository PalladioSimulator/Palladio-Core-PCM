package edu.kit.ipd.sdq.eventsim.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.StartAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

/**
 * This traversal strategy is responsible for {@link StartAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class StartActionTraversalStrategy implements ISeffTraversalStrategy<StartAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final StartAction action, final Request request,
            final RequestState state) {
        return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
    }

}
