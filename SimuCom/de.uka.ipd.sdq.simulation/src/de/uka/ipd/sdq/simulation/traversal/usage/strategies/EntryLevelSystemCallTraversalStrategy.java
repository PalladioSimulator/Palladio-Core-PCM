package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.usage.FindAssemblyContextForSystemCall;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.BeginSeffTraversalEvent;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

/**
 * This traversal strategy is responsible for {@link EntryLevelSystemCall} actions.
 * 
 * @author Philipp Merkle
 *
 */
public class EntryLevelSystemCallTraversalStrategy implements IUsageTraversalStrategy<EntryLevelSystemCall> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final EntryLevelSystemCall call, final User user,
            final TraversalState<AbstractUserAction> state) {
        final EventSimModel model = user.getModel();

        // find the component which provides the call
        final AssemblyContext assemblyCtx = model.execute(new FindAssemblyContextForSystemCall(call));
        final ComponentInstance component = model.getComponent(assemblyCtx);
        final OperationSignature signature = call.getOperationSignature__EntryLevelSystemCall();

        // spawn a new request
        final Request request = new Request(model, call, user);
        new BeginSeffTraversalEvent(model, component, signature, state).schedule(request, 0);

        return new InterruptTraversal<AbstractUserAction>(call.getSuccessor());
    }

}
