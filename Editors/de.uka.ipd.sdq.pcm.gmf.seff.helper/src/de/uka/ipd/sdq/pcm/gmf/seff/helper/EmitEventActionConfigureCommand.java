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

import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.SourceRole;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * Command to Configure an emit event action with the appropriate event type and source role.
 * 
 * This configuration command takes use of the basic commands provided by the EMF environment like
 * setValueCommand() etc.
 * 
 * @author Benjamin Klatt
 */
public class EmitEventActionConfigureCommand extends ConfigureElementCommand {

    /** The request send for the configuration. */
    private ConfigureRequest request = null;

    /** The event type to be emitted by the EmitEventAction. */
    private EventType eventType = null;

    /** The source role to be triggered by the emit event action. */
    private SourceRole sourceRole = null;

    /**
     * Constructor to set the required configuration.
     * 
     * @param request
     *            The request calling this command.
     * @param eventType
     *            The EventType the action should be able to emit.
     * @param sourceRole
     *            The source role to be triggered by the action.
     */
    public EmitEventActionConfigureCommand(final ConfigureRequest request, final EventType eventType,
            final SourceRole sourceRole) {
        super(request);
        this.request = request;
        this.eventType = eventType;
        this.sourceRole = sourceRole;
    }

    /**
     * Execute the command and return the result of the configuration process.
     * 
     * @param monitor
     *            The monitor to report the progress to.
     * @param info
     *            The adaptable information object of the environment.
     * @return The result of the configuration process.
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        CommandResult commandResult = this.setEventTypeEmitEventAction(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set EventType for the EmitEventAction failed!");
        }
        commandResult = this.setSourceRoleEmitEventAction(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set SourceRole for the EmitEventAction failed!");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Set the EventType in the EmitEventAction.
     * 
     * @param monitor
     *            The monitor to report the progress to.
     * @param info
     *            The adaptable information object of the environment.
     * @return The result of this processing step.
     * 
     * @throws ExecutionException
     *             indicating any problems during the EmitEventAction configuration.
     */
    private CommandResult setEventTypeEmitEventAction(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getEmitEventAction_EventType__EmitEventAction(), this.eventType));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }

    /**
     * Set the SourceRole of the EmitEventAction.
     * 
     * @param monitor
     *            The monitor to report the progress to.
     * @param info
     *            The adaptable information object of the environment.
     * @return The result of this processing step.
     * 
     * @throws ExecutionException
     *             indicating any problems during the EmitEventAction configuration.
     */
    private CommandResult setSourceRoleEmitEventAction(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getEmitEventAction_SourceRole__EmitEventAction(), this.sourceRole));

        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }
}
