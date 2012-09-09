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

    private IWorkbenchWindow myWindow = null;

    public void init(final IWorkbenchWindow window) {
        assert (myWindow != null);
        myWindow = window;
    }

    /**
     * @return the window which was active when the action was activated
     */
    protected IWorkbenchWindow getWindow() {
        return myWindow;
    }

    public void selectionChanged(final IAction action, final ISelection selection) {
        // do nothing
    }

    public void dispose() {
        // do nothing
    }
}
