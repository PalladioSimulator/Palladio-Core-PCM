package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

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
    public ITraversalInstruction<AbstractAction> traverse(ReleaseAction action, Request request,
            TraversalState<AbstractAction> state) {
        if(!action.getResourceDemand_Action().isEmpty()) {
            throw new EventSimException("Parametric resource demands are not yet supported for ReleaseActions.");
        }
        
        final PassiveResource passiveResouce = action.getPassiveResource_ReleaseAction();

        final SimPassiveResource res = state.getStack().currentScope().getComponent().getPassiveResource(passiveResouce);
        res.release(request.getSimulatedProcess(), 1);

        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
