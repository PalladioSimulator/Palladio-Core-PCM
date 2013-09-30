package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * A canceled command.
 */
public class CanceledCommand extends AbstractCommand {

    /**
     * Initializes the command.
     */
    public CanceledCommand() {
        super("Canceled Command");
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    @Override
    protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    @Override
    protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

}
