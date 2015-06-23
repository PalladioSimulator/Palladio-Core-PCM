/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.PcmFactory;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.PCMRandomVariableCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * Configures a given {@link InfrastructureCall} instance to use given a given signature and role.
 * 
 * @author groenda
 */
public class InfrastructureCallConfigureCommand extends ConfigureElementCommand {

    /** Configuration request. */
    private ConfigureRequest request = null;
    /** Infrastructure signature. */
    private InfrastructureSignature signature = null;
    /** Infrastructure required role. */
    private InfrastructureRequiredRole requiredRole = null;
    /** The specification string for the number of calls. */
    private final String numberOfCalls;

    /**
     * Creates a new configuration command for an {@link InfrastructureCall}.
     * 
     * @param request
     *            Configuration request.
     * @param signature
     *            The target signature.
     * @param requiredRole
     *            The target required role.
     * @param numberOfCalls
     *            The number of calls to the target.
     */
    public InfrastructureCallConfigureCommand(final ConfigureRequest request, final InfrastructureSignature signature,
            final InfrastructureRequiredRole requiredRole, final String numberOfCalls) {
        super(request);
        this.request = request;
        this.signature = signature;
        this.requiredRole = requiredRole;
        this.numberOfCalls = numberOfCalls;
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
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        CommandResult commandResult = this.setInfrastructureSignatureInfrastructureCall(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult
                    .newErrorCommandResult("Set InfrastructureSignature for the InfrastructureCall failed!");
        }
        commandResult = this.setInfrastructureRequiredRoleInfrastructureCall(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult
                    .newErrorCommandResult("Set InfrastructureRequiredRole for the InfrastructureCall failed!");
        }
        commandResult = this.setNumberOfCallsInfrastructureCall(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set NumberOfCalls for the InfrastructureCall failed.");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Create the command to modify the infrastructure signature for an infrastructure call.
     * 
     * @param monitor
     *            Progress monitor.
     * @param info
     *            Adaptation information.
     * @return Command.
     * @throws ExecutionException
     *             On error.
     */
    private CommandResult setInfrastructureSignatureInfrastructureCall(final IProgressMonitor monitor,
            final IAdaptable info) throws ExecutionException {

        if (!(this.request.getElementToConfigure() instanceof InfrastructureCall)) {
            throw new ExecutionException(
                    "The provided element which should be configured was not of type InfrastructureCall.");
        }

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPerformancePackage.eINSTANCE.getInfrastructureCall_Signature__InfrastructureCall(), this.signature));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    /**
     * Create the command to modify the required role for an infrastructure call.
     * 
     * @param monitor
     *            Progress monitor.
     * @param info
     *            Adaptation information.
     * @return Command.
     * @throws ExecutionException
     *             On error.
     */
    private CommandResult setInfrastructureRequiredRoleInfrastructureCall(final IProgressMonitor monitor,
            final IAdaptable info) throws ExecutionException {

        if (!(this.request.getElementToConfigure() instanceof InfrastructureCall)) {
            throw new ExecutionException(
                    "The provided element which should be configured was not of type InfrastructureCall.");
        }
        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPerformancePackage.eINSTANCE.getInfrastructureCall_RequiredRole__InfrastructureCall(),
                this.requiredRole));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    /**
     * Create the command to modify the number of calls for an infrastructure call.
     * 
     * @param monitor
     *            Progress monitor.
     * @param info
     *            Adaptation information.
     * @return Command.
     * @throws ExecutionException
     *             On error.
     */
    private CommandResult setNumberOfCallsInfrastructureCall(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {

        if (!(this.request.getElementToConfigure() instanceof InfrastructureCall)) {
            throw new ExecutionException(
                    "The provided element which should be configured was not of type InfrastructureCall.");
        }
        final InfrastructureCall call = (InfrastructureCall) this.request.getElementToConfigure();
        
        if(call.getNumberOfCalls__InfrastructureCall() == null)
        {
           call.setNumberOfCalls__InfrastructureCall(CoreFactory.eINSTANCE.createPCMRandomVariable());
        }
            
        
        final ICommand cmd = new SetValueCommand(new SetRequest(call.getNumberOfCalls__InfrastructureCall(),
                StoexPackage.eINSTANCE.getRandomVariable_Specification(), this.numberOfCalls));
        cmd.execute(monitor, info);
        return cmd.getCommandResult();
    }

}
