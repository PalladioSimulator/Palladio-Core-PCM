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

import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @author Roman Andrej
 */
public class ExternalCallActionConfigureCommand extends ConfigureElementCommand {

	private ConfigureRequest request = null;
	private OperationSignature signature = null;
	private OperationRequiredRole requiredRole = null;
	
	public ExternalCallActionConfigureCommand(ConfigureRequest request,
			OperationSignature signature, OperationRequiredRole requiredRole) {
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
		CommandResult commandResult = setOperationSignatureExternalCallAction(monitor,
				info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set OperationSignature for the ExternalCallAction failed!");
		}
		commandResult = setRequiredRoleEntryLevelSystemCall(monitor, info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set OperationProvidedRole for the ExternalCallAction failed!");
		}
		return CommandResult.newOKCommandResult();
	}
	
	
	private CommandResult setOperationSignatureExternalCallAction(
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
