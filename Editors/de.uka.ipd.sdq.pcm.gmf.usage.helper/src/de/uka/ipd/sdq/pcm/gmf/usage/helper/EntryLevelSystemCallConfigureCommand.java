/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class EntryLevelSystemCallConfigureCommand.
 * 
 * @author admin
 */
public class EntryLevelSystemCallConfigureCommand extends ConfigureElementCommand {

    /** The request. */
    private ConfigureRequest request = null;

    /** The signature. */
    private Signature signature = null;

    /** The provided role. */
    private ProvidedRole providedRole = null;

    /**
     * Instantiates a new entry level system call configure command.
     * 
     * @param request
     *            the request
     * @param signature
     *            the signature
     * @param providedRole
     *            the provided role
     */
    public EntryLevelSystemCallConfigureCommand(ConfigureRequest request, Signature signature, ProvidedRole providedRole) {
        super(request);
        this.request = request;
        this.signature = signature;
        this.providedRole = providedRole;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand#doExecuteWithResult(org.eclipse
     * .core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
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

        CommandResult commandResult = setSignatureEntryLevelSystemCall(monitor, info);
        if (!isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set Signature for the EntryLevelSystemCall failed!");
        }
        commandResult = setProvidedRoleEntryLevelSystemCall(monitor, info);
        if (!isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set ProvidedRole for the EntryLevelSystemCall failed!");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Sets the signature entry level system call.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setSignatureEntryLevelSystemCall(IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall_OperationSignature__EntryLevelSystemCall(),
                signature));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    /**
     * Sets the provided role entry level system call.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setProvidedRoleEntryLevelSystemCall(IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall_ProvidedRole_EntryLevelSystemCall(), providedRole));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

}
