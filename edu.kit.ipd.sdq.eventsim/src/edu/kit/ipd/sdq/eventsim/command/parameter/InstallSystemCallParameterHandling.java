package edu.kit.ipd.sdq.eventsim.command.parameter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.command.usage.FindAssemblyContextForSystemCall;
import edu.kit.ipd.sdq.eventsim.command.usage.FindSystemCallsOfScenario;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.UsageInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;

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

    private static final Logger logger = Logger.getLogger(InstallSystemCallParameterHandling.class);

    private UsageInterpreterConfiguration interpreterConfiguration;

    public InstallSystemCallParameterHandling(UsageInterpreterConfiguration interpreterConfiguration) {
        this.interpreterConfiguration = interpreterConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(final PCMModel pcm, final ICommandExecutor<PCMModel> executor) {
        // find all system calls
        final Set<EntryLevelSystemCall> systemCalls = new LinkedHashSet<EntryLevelSystemCall>();
        final List<UsageScenario> scenarios = pcm.getUsageModel().getUsageScenario_UsageModel();
        for (final UsageScenario s : scenarios) {
            systemCalls.addAll(executor.execute(new FindSystemCallsOfScenario(s)));
        }
        if (systemCalls != null) {
            for (final EntryLevelSystemCall c : systemCalls) {
                // install a listener which handles the parameter passing
                this.interpreterConfiguration.addTraversalListener(c, new SystemCallTraversalListener());
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

    private static final class SystemCallTraversalListener implements IUsageTraversalListener {

        @Override
        public void before(final AbstractUserAction action, final User who, UserState state) {
//            if (logger.isDebugEnabled()) {
//                logger.debug("Begin handling system call input parameters");
//            }
//
//            final EventSimModel model = who.getModel();
//            final EntryLevelSystemCall call = (EntryLevelSystemCall) action;
//            final StackContext ctx = state.getStoExContext();
//
//            // get a reference on the current stack frame which is being covered soon
//            final SimulatedStackframe<Object> outerFrame = ctx.getStack().currentStackFrame();
//
//            // enter a new scope in which the call is being executed
//            final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().createAndPushNewStackFrame();
//
//            // add component parameters
//            final AssemblyContext assemblyCtx = model.execute(new FindAssemblyContextForSystemCall(call));
//            final ComponentInstance component = model.getComponent(assemblyCtx);
//            serviceBodyFrame.addVariables(component.getComponentParameters());
//
//            // evaluate the input parameters and add them to the call's scope
//            final List<VariableUsage> parameters = call.getInputParameterUsages_EntryLevelSystemCall();
//            ParameterHelper.evaluateParametersAndCopyToFrame(parameters, outerFrame, serviceBodyFrame);
//
//            if (logger.isDebugEnabled()) {
//                logger.debug("Finished handling system call input parameters");
//            }
        }

        @Override
        public void after(final AbstractUserAction action, final User who, UserState state) {
            if (logger.isDebugEnabled()) {
                logger.debug("Begin handling system call output parameters");
            }

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

            if (logger.isDebugEnabled()) {
                logger.debug("Finished handling system call output parameters");
            }
        }

    }

}
