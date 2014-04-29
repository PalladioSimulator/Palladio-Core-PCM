package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

/**
 * This traversal strategy is responsible for {@link ReleaseAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class ReleaseActionTraversalStrategy implements ISeffTraversalStrategy<ReleaseAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(ReleaseAction action, Request request, RequestState state) {
        if (!action.getResourceDemand_Action().isEmpty()) {
            throw new EventSimException("Parametric resource demands are not yet supported for ReleaseActions.");
        }

        final PassiveResource passiveResouce = action.getPassiveResource_ReleaseAction();

        final SimPassiveResource res = state.getComponent().getPassiveResource(passiveResouce);
        res.release(request.getSimulatedProcess(), 1);

        return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
    }

}
