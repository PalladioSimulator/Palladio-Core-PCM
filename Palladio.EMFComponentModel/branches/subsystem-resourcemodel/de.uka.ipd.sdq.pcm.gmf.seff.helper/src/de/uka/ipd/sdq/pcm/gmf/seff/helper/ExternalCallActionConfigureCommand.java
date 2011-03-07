/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @author Roman Andrej
 */
public class ExternalCallActionConfigureCommand extends ConfigureElementCommand {

	private ConfigureRequest request = null;
	private Signature signature = null;
	private RequiredRole requiredRole = null;
	
	public ExternalCallActionConfigureCommand(ConfigureRequest request,
			Signature signature, RequiredRole requiredRole) {
		super(request);
		this.request = request;
		this.signature = signature;
		this.requiredRole = requiredRole;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		CommandResult commandResult = setSignatureExternalCallAction(monitor,
				info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set Signature for the ExternalCallAction failed!");
		}
		commandResult = setRequiredRoleEntryLevelSystemCall(monitor, info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set ProvidedRole for the ExternalCallAction failed!");
		}
		return CommandResult.newOKCommandResult();
	}
	
	
	private CommandResult setSignatureExternalCallAction(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), SeffPackage.eINSTANCE
				.getExternalCallAction_CalledService_ExternalService(),
				signature));

		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}
	
	private CommandResult setRequiredRoleEntryLevelSystemCall(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), SeffPackage.eINSTANCE
				.getExternalCallAction_Role_ExternalService(), requiredRole));

		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}
}
