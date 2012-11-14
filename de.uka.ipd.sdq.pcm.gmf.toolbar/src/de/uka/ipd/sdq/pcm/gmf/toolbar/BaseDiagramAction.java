package de.uka.ipd.sdq.pcm.gmf.toolbar;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Baseclass for action delegates that require the window passed to the init method.
 * 
 * @author Philipp Meier
 */
abstract class BaseDiagramAction implements IWorkbenchWindowActionDelegate {

    /** The my window. */
    private IWorkbenchWindow myWindow = null;

    /**
     * Inits the.
     *
     * @param window the window
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
     */
    @Override
    public void init(final IWorkbenchWindow window) {
        assert (myWindow != null);
        myWindow = window;
    }

    /**
     * Gets the window.
     *
     * @return the window which was active when the action was activated
     */
    protected IWorkbenchWindow getWindow() {
        return myWindow;
    }

    /**
     * Selection changed.
     *
     * @param action the action
     * @param selection the selection
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
     */
    @Override
    public void selectionChanged(final IAction action, final ISelection selection) {
        // do nothing
    }

    /**
     * Dispose.
     *
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
     */
    @Override
    public void dispose() {
        // do nothing
    }
}
