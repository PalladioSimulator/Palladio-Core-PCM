package de.uka.ipd.sdq.pcm.gmf.seff.helper;

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

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

/**
 * The Class ConfigureMinimalSeffCommand.
 */
public class ConfigureMinimalSeffCommand extends ConfigureElementCommand {

    /** The request. */
    private ConfigureRequest myRequest = null;

    /**
     * Instantiates a new configure minimal SEFF command.
     * 
     * @param request
     *            the request
     */
    public ConfigureMinimalSeffCommand(final ConfigureRequest request) {
        super(request);
        this.myRequest = request;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#
     * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     * org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do execute with result.
     *
     * @param monitor the monitor
     * @param info the info
     * @return the command result
     * @throws ExecutionException the execution exception
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        StartAction startAction = null;
        StopAction stopAction = null;

        CommandResult commandResult = this.createSEFFAction(PalladioComponentModelElementTypes.StartAction_2001,
                monitor);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Create StartAction for the new SEFF failed!");
        }
        startAction = (StartAction) commandResult.getReturnValue();
        commandResult = this.createSEFFAction(PalladioComponentModelElementTypes.StopAction_2002, monitor);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Create StopAction for the new SEFF failed!");
        }
        stopAction = (StopAction) commandResult.getReturnValue();
        // FIXME: The following lines have been commented out on 28.5.2007. Decide if fixed/needed.
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
     * @param startAction
     *            the start action
     * @param stopAction
     *            the stop action
     * @param monitor
     *            the monitor
     * @return the command result
     */
    private CommandResult createControlFlow(final StartAction startAction, final StopAction stopAction,
            final IProgressMonitor monitor) {
        final SetRequest setReq = new SetRequest(startAction,
                SeffPackage.eINSTANCE.getAbstractAction_Successor_AbstractAction(), stopAction);
        final SetValueCommand createControlFlowCommand = new SetValueCommand(setReq);
        try {
            createControlFlowCommand.execute(monitor, null);
        } catch (final ExecutionException e) {
            Log.error(SEFFHelperPlugin.getDefault(), -1, e.getLocalizedMessage());
            return CommandResult.newErrorCommandResult(e.getLocalizedMessage());
        }
        final CommandResult commandResult = createControlFlowCommand.getCommandResult();
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
    private CommandResult createSEFFAction(final IElementType typeId, final IProgressMonitor monitor)
            throws ExecutionException {
        final CreateElementRequest startRequest = new CreateElementRequest(this.myRequest.getElementToConfigure(),
                typeId, SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour());
        startRequest.setLabel("Create Action");
        final CreateElementCommand createStartCommand = new CreateElementCommand(startRequest);
        createStartCommand.execute(monitor, null);
        final CommandResult commandResult = createStartCommand.getCommandResult();
        return commandResult;
    }
}
