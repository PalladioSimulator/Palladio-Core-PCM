package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import java.util.List;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.simulation.entities.ForkedRequest;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.events.BeginForkedBehaviourTraversalEvent;
import de.uka.ipd.sdq.simulation.events.ResumeSeffTraversalEvent;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class ForkActionTraversalStrategy implements ISeffTraversalStrategy<ForkAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(ForkAction fork, Request request,
            TraversalState<AbstractAction> state) {
        new ResumeSeffTraversalEvent(request.getModel(), state).schedule(request, 0);
        
        List<ForkedBehaviour> asynchronousBehaviours = fork.getAsynchronousForkedBehaviours_ForkAction();
        for (ForkedBehaviour b : asynchronousBehaviours) {
            ForkedRequest forkedRequest = new ForkedRequest(request.getModel(), b, true, request);
            new BeginForkedBehaviourTraversalEvent(request.getModel(), b, state).schedule(forkedRequest, 0);
        }
        
        if (fork.getSynchronisingBehaviours_ForkAction() != null) {
            throw new EventSimException("Synchronous forked behaviours are not yet supported.");
        }

        // TODO nur zulässig, falls keine synchronen Behaviours vorhanden. Ansonsten müsste hier
        // gewartet werden, bis alle forked behaviours abgearbeitet sind.
        return new InterruptTraversal<AbstractAction>(fork.getSuccessor_AbstractAction());
//        return new TraverseNextAction<AbstractAction>(fork.getSuccessor_AbstractAction());
    }

}
