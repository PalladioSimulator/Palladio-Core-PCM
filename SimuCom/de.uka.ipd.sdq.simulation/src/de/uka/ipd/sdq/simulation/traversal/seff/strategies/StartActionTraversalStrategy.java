package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

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
    public ITraversalInstruction<AbstractAction> traverse(final StartAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
