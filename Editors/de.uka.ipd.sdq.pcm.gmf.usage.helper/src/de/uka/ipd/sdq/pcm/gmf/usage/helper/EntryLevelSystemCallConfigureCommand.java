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

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * @author admin
 * 
 */
public class EntryLevelSystemCallConfigureCommand extends ConfigureElementCommand {

    private ConfigureRequest request = null;
    private Signature signature = null;
    private ProvidedRole providedRole = null;

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

    private CommandResult setSignatureEntryLevelSystemCall(IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall_OperationSignature__EntryLevelSystemCall(),
                signature));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    private CommandResult setProvidedRoleEntryLevelSystemCall(IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall_ProvidedRole_EntryLevelSystemCall(), providedRole));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

}
