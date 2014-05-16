package edu.kit.ipd.sdq.eventsim.system.handler;

import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.command.FindAssemblyContextForSystemCall;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.system.SystemRequestStart;

public class BeforeSystemCallParameterHandler implements IEventHandler<SystemRequestStart> {

    private static final Logger logger = Logger.getLogger(BeforeSystemCallParameterHandler.class);
    
	private EventSimSystemModel model;

	public BeforeSystemCallParameterHandler(EventSimSystemModel model) {
		this.model = model;
	}

	@Override
	public void handle(SystemRequestStart simulationEvent) {
		if (logger.isDebugEnabled()) {
            logger.debug("Begin handling system call input parameters");
        }

		Request request = (Request) simulationEvent.getRequest();
		RequestState state = request.getRequestState();

        final EntryLevelSystemCall call = request.getSystemCall();
        final StackContext ctx = state.getStoExContext();

        // get a reference on the current stack frame which is being covered soon
        final SimulatedStackframe<Object> outerFrame = ctx.getStack().currentStackFrame();

        // enter a new scope in which the call is being executed
        final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().createAndPushNewStackFrame();

        // add component parameters
        final AssemblyContext assemblyCtx = model.execute(new FindAssemblyContextForSystemCall(call));
        final ComponentInstance component = model.getComponent(assemblyCtx);
        serviceBodyFrame.addVariables(component.getComponentParameters());

        // evaluate the input parameters and add them to the call's scope
        final List<VariableUsage> parameters = call.getInputParameterUsages_EntryLevelSystemCall();
        ParameterHelper.evaluateParametersAndCopyToFrame(parameters, outerFrame, serviceBodyFrame);

        if (logger.isDebugEnabled()) {
            logger.debug("Finished handling system call input parameters");
        }
	}

}
