package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class ReleaseActionTraversalStrategy implements ISeffTraversalStrategy<ReleaseAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(ReleaseAction action, Request request,
            TraversalState<AbstractAction> state) {
        final PassiveResource passiveResouce = action.getPassiveResource_ReleaseAction();

        final SimulatedPassiveResource res = request.getContext().getPassiveResource(passiveResouce);
        res.release(request.getProcess(), 1);

        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
