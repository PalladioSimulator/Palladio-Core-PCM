package de.uka.ipd.sdq.simulation.command.parameter;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindSystemCallsOfScenario;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;
import de.uka.ipd.sdq.simulation.util.ParameterHelper;

/**
 * This command sets up the handling of PCM parameter characterisations for
 * {@link EntryLevelSystemCall}s. EntryLevelSystemCalls accept input parameters and can return
 * output parameters, both of which are realised by modifying the current stack frame (see:
 * {@link StackContext}). These modifications are performed by this command, once installed.
 * 
 * @author Philipp Merkle
 * 
 */
public class InstallSystemCallParameterHandling implements IPCMCommand<Void> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(final PCMModel pcm, final ICommandExecutor<PCMModel> executor) {
        // find all system calls
        final List<EntryLevelSystemCall> systemCalls = new ArrayList<EntryLevelSystemCall>();
        final List<UsageScenario> scenarios = pcm.getUsageModel().getUsageScenario_UsageModel();
        for (final UsageScenario s : scenarios) {
            systemCalls.addAll(executor.execute(new FindSystemCallsOfScenario(s)));
        }
        if (systemCalls != null) {
            for (final EntryLevelSystemCall c : systemCalls) {
                // install a listener which handles the parameter passing
                UsageBehaviorTraversal.addTraversalListener(c, new SystemCallTraversalListener());
            }
        }
        // the listeners are mounted; we don't need to return anything.
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    private class SystemCallTraversalListener implements IUsageTraversalListener {

        @Override
        public void before(final AbstractUserAction action, final User who, TraversalState<AbstractUserAction> state) {
            final EntryLevelSystemCall call = (EntryLevelSystemCall) action;
            final StackContext ctx = state.getStoExContext();

            // get a reference on the current stack frame which is being covered soon
            final SimulatedStackframe<Object> outerFrame = ctx.getStack().currentStackFrame();

            // enter a new scope in which the call is being executed
            final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().createAndPushNewStackFrame();

            // evaluate the input parameters and add them to the call's scope
            final List<VariableUsage> parameters = call.getInputParameterUsages_EntryLevelSystemCall();
            ParameterHelper.evaluateParametersAndCopyToFrame(parameters, outerFrame, serviceBodyFrame);
        }

        @Override
        public void after(final AbstractUserAction action, final User who, TraversalState<AbstractUserAction> state) {
            final EntryLevelSystemCall call = (EntryLevelSystemCall) action;
            final StackContext ctx = state.getStoExContext();

            // get a reference on the current stack frame which is being removed soon
            final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().currentStackFrame();

            // remove the current stack frame. This restores the pre-call scope.
            ctx.getStack().removeStackFrame();

            // evaluate the return parameters of the call and add them to the current scope
            final List<VariableUsage> parameters = call.getOutputParameterUsages_EntryLevelSystemCall();
            final SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
            ParameterHelper.evaluateParametersAndCopyToFrame(parameters, serviceBodyFrame, currentFrame);
        }

    }

}
