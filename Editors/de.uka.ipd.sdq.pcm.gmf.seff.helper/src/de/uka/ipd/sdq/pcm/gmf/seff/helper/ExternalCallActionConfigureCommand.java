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
 * The Class ExternalCallActionConfigureCommand configures an external call action.
 * 
 * @author Roman Andrej
 */
public class ExternalCallActionConfigureCommand extends ConfigureElementCommand {

    /** The request. */
    private ConfigureRequest request = null;

    /** The signature. */
    private OperationSignature signature = null;

    /** The required role. */
    private OperationRequiredRole requiredRole = null;

    /**
     * Instantiates a new external call action configure command.
     * 
     * @param request
     *            the request
     * @param signature
     *            the signature
     * @param requiredRole
     *            the required role
     */
    public ExternalCallActionConfigureCommand(final ConfigureRequest request, final OperationSignature signature,
            final OperationRequiredRole requiredRole) {
        super(request);
        this.request = request;
        this.signature = signature;
        this.requiredRole = requiredRole;
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
        CommandResult commandResult = this.setOperationSignatureExternalCallAction(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set OperationSignature for the ExternalCallAction failed!");
        }
        commandResult = this.setRequiredRoleEntryLevelSystemCall(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set OperationProvidedRole for the ExternalCallAction failed!");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Sets the operation signature external call action.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setOperationSignatureExternalCallAction(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getExternalCallAction_CalledService_ExternalService(), this.signature));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    /**
     * Sets the required role entry level system call.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setRequiredRoleEntryLevelSystemCall(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getExternalCallAction_Role_ExternalService(), this.requiredRole));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }
}
