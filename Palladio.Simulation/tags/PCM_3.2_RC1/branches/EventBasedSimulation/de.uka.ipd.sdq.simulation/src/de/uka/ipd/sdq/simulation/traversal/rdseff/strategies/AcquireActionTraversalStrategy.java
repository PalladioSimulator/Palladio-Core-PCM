package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.resources.SimulatedPassiveResource;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class AcquireActionTraversalStrategy implements ISeffTraversalStrategy<AcquireAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(final AcquireAction action, final Request request,
            final TraversalState<AbstractAction> state) {
        final PassiveResource passiveResouce = action.getPassiveresource_AcquireAction();

        final SimulatedPassiveResource res = request.getContext().getPassiveResource(passiveResouce);
        final boolean acquired = res.acquire(request.getProcess(), 1);

        if (acquired) {
            return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
        } else {
//            entity.setServedEvent(new TraverseResourceDemandingBehaviourEvent(entity.getModel(), state));

            // here, it is assumed that the passive resource grants access to waiting processes as
            // soon as the requested capacity becomes available. Thus, we do not need to acquire the
            // passive resource again as this will be done within the release method. Accordingly
            // the traversal resumes with the successor of this action.
            return new InterruptTraversal<AbstractAction>(action.getSuccessor_AbstractAction());
        }
    }

}
