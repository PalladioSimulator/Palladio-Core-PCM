package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.events.ResumeSeffTraversalEvent;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * This traversal strategy is responsible for {@link AcquireAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class AcquireActionTraversalStrategy implements ISeffTraversalStrategy<AcquireAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction> traverse(final AcquireAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        if(!action.getResourceDemand_Action().isEmpty()) {
            throw new EventSimException("Parametric resource demands are not yet supported for AcquireActions.");
        }
        
        final PassiveResource passiveResouce = action.getPassiveresource_AcquireAction();

        final SimPassiveResource res = state.getStack().currentScope().getComponent()
                .getPassiveResource(passiveResouce); 
        final boolean acquired = res.acquire(request.getSimulatedProcess(), 1, false, action.getTimeoutValue());

        if (acquired) {
            return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
        } else {
            request.passivate(new ResumeSeffTraversalEvent(request.getModel(), state));

            // here, it is assumed that the passive resource grants access to waiting processes as
            // soon as the requested capacity becomes available. Thus, we do not need to acquire the
            // passive resource again as this will be done within the release method. Accordingly
            // the traversal resumes with the successor of this action.
            return new InterruptTraversal<AbstractAction>(action.getSuccessor_AbstractAction());
        }
    }

}
