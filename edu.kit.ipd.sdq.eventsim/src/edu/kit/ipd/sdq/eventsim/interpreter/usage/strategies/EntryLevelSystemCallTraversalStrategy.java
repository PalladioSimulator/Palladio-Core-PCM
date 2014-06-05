package edu.kit.ipd.sdq.eventsim.interpreter.usage.strategies;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.command.usage.FindAssemblyContextForSystemCall;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.events.BeginSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;

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
    public IUsageTraversalInstruction traverse(final EntryLevelSystemCall call, final User user,
            final UserState state) {
        final EventSimModel model = user.getModel();

        // find the component which provides the call
        final AssemblyContext assemblyCtx = model.execute(new FindAssemblyContextForSystemCall(call));
        final ComponentInstance component = model.getComponent(assemblyCtx);
        final OperationSignature signature = call.getOperationSignature__EntryLevelSystemCall();

        // spawn a new request
        final Request request = new Request(model, call, user);
        new BeginSeffTraversalEvent(model, component, signature, state).schedule(request, 0);

        return UsageTraversalInstructionFactory.interruptTraversal(call.getSuccessor());
    }

}
