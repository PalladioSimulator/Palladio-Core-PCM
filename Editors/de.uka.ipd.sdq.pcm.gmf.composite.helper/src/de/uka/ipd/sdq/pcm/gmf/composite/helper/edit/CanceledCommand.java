package de.uka.ipd.sdq.pcm.gmf.composite.helper.edit;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * The Class CanceledCommand.
 */
public class CanceledCommand extends AbstractCommand {

    /**
     * Instantiates a new canceled command.
     */
    public CanceledCommand() {
        super("Canceled Command");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse
     * .core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.
     * core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.
     * core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        return CommandResult.newCancelledCommandResult();
    }

}
