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

public class ConfigureMinimalSeffCommand  extends ConfigureElementCommand {

	private ConfigureRequest myRequest = null;
	
	public ConfigureMinimalSeffCommand(ConfigureRequest request) {
		super(request);
		myRequest = request;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		StartAction startAction = null;
		StopAction stopAction = null;
		
		CommandResult commandResult = createSEFFAction(PalladioComponentModelElementTypes.StartAction_2001,monitor);
        if (!isOK(commandResult))
        {
        	return CommandResult.newErrorCommandResult("Create StartAction for the new SEFF failed!");
        }
        startAction = (StartAction) commandResult.getReturnValue();
		commandResult = createSEFFAction(PalladioComponentModelElementTypes.StopAction_2002,monitor);
        if (!isOK(commandResult))
        {
        	return CommandResult.newErrorCommandResult("Create StopAction for the new SEFF failed!");
        }
        stopAction = (StopAction) commandResult.getReturnValue();
        // Removed due to recent CanonicalEditPolicy Bug in GMF
        //commandResult = createControlFlow(startAction, stopAction, monitor);
        //if (!isOK(commandResult))
        //{
        //	return CommandResult.newErrorCommandResult("Create ControlFlow for the new SEFF failed!");
        //}
		return CommandResult.newOKCommandResult();
	}

	private CommandResult createControlFlow(StartAction startAction,
			StopAction stopAction, IProgressMonitor monitor) {
		SetRequest setReq = new SetRequest(startAction, SeffPackage.eINSTANCE
				.getAbstractAction_Successor_AbstractAction(), stopAction);
        SetValueCommand createControlFlowCommand = new SetValueCommand(setReq);
        try {
			createControlFlowCommand.execute(monitor, null);
		} catch (ExecutionException e) {
            Log.error(SEFFHelperPlugin.getDefault(),
                    	-1, e
                        .getLocalizedMessage());
            return CommandResult.newErrorCommandResult(e.getLocalizedMessage());
		}
        CommandResult commandResult = createControlFlowCommand.getCommandResult();
        return commandResult;
	}

	private CommandResult createSEFFAction(IElementType typeId, IProgressMonitor monitor)
			throws ExecutionException {
		CreateElementRequest startRequest = new CreateElementRequest(
				myRequest.getElementToConfigure(), 
				typeId, 
				SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour()
				);
		startRequest.setLabel("Create Action");
		CreateElementCommand createStartCommand = new CreateElementCommand(startRequest);
        createStartCommand.execute(monitor, null);
        CommandResult commandResult = createStartCommand.getCommandResult();
		return commandResult;
	}
}
