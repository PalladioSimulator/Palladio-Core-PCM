package de.uka.ipd.sdq.pcm.gmf.allocation.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * This command is passed after a cancelled action.
 */
public class CanceledCommand extends AbstractCommand {

    /** Constructs a new CanceledCommand. */
    public CanceledCommand() {
        super("Canceled Command");
    }

    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    @Override
    protected CommandResult doRedoWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    @Override
    protected CommandResult doUndoWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

}
