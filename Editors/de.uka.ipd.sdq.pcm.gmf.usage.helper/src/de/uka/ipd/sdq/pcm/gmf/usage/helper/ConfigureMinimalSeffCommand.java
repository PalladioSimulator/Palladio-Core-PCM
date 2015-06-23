package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class ConfigureMinimalSeffCommand.
 */
public class ConfigureMinimalSeffCommand extends ConfigureElementCommand {

    /** The my request. */
    private ConfigureRequest myRequest = null;

    /**
     * Instantiates a new configure minimal seff command.
     * 
     * @param request
     *            the request
     */
    public ConfigureMinimalSeffCommand(ConfigureRequest request) {
        super(request);
        myRequest = request;
    }

    /**
     * Do execute with result.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        Start start = null;
        Stop stop = null;

        CommandResult commandResult = createSEFFAction(PalladioComponentModelElementTypes.Start_3001, monitor);
        if (!isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Create StartAction for the new SEFF failed!");
        }
        start = (Start) commandResult.getReturnValue();
        commandResult = createSEFFAction(PalladioComponentModelElementTypes.Stop_3002, monitor);
        if (!isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Create StopAction for the new SEFF failed!");
        }
        stop = (Stop) commandResult.getReturnValue();
        // Removed due to recent CanonicalEditPolicy Bug in GMF
        // commandResult = createControlFlow(startAction, stopAction, monitor);
        // if (!isOK(commandResult))
        // {
        // return
        // CommandResult.newErrorCommandResult("Create ControlFlow for the new SEFF failed!");
        // }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Creates the control flow.
     * 
     * @param start
     *            the start
     * @param stop
     *            the stop
     * @param monitor
     *            the monitor
     * @return the command result
     */
    private CommandResult createControlFlow(Start start, Stop stop, IProgressMonitor monitor) {
        SetRequest setReq = new SetRequest(start, UsagemodelPackage.eINSTANCE.getAbstractUserAction_Successor(), stop);
        SetValueCommand createControlFlowCommand = new SetValueCommand(setReq);
        try {
            createControlFlowCommand.execute(monitor, null);
        } catch (ExecutionException e) {
            Log.error(UsageHelperPlugin.getDefault(), -1, e.getLocalizedMessage());
            return CommandResult.newErrorCommandResult(e.getLocalizedMessage());
        }
        CommandResult commandResult = createControlFlowCommand.getCommandResult();
        return commandResult;
    }

    /**
     * Creates the seff action.
     * 
     * @param typeId
     *            the type id
     * @param monitor
     *            the monitor
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult createSEFFAction(IElementType typeId, IProgressMonitor monitor) throws ExecutionException {
        CreateElementRequest startRequest = new CreateElementRequest(myRequest.getElementToConfigure(), typeId,
                UsagemodelPackage.eINSTANCE.getScenarioBehaviour_Actions_ScenarioBehaviour());
        startRequest.setLabel("Create Action");
        CreateElementCommand createStartCommand = new CreateElementCommand(startRequest);
        createStartCommand.execute(monitor, null);
        CommandResult commandResult = createStartCommand.getCommandResult();
        return commandResult;
    }
}
