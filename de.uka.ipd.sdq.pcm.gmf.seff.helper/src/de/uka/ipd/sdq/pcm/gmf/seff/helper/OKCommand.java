package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * This class handles the OKCommand used in EditHelpers.
 * 
 */
public class OKCommand extends AbstractCommand {

    /**
     * Constructor for an OKCommand.
     */
    public OKCommand() {
        super("OK Command");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse
     * .core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do execute with result.
     * 
     * @param progressMonitor
     *            the progress monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newOKCommandResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.
     * core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do redo with result.
     * 
     * @param progressMonitor
     *            the progress monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doRedoWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newOKCommandResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.
     * core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do undo with result.
     * 
     * @param progressMonitor
     *            the progress monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doUndoWithResult(final IProgressMonitor progressMonitor, final IAdaptable info)
            throws ExecutionException {
        return CommandResult.newOKCommandResult();
    }
}
