package de.uka.ipd.sdq.pcm.gmf.toolbar;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

/**
 * Baseclass for the inizialize diagram actions. A factory method is used to retrieve the init
 * diagram action of the appropriate package.
 * 
 * @author Philipp Meier
 */
public abstract class BaseInitializeDiagramAction extends BaseDiagramAction {

    /**
     * Run.
     *
     * @param action the action
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    @Override
    public void run(final IAction action) {

        IObjectActionDelegate initAction = getInitAction();
        assert (action != null);

        initAction.selectionChanged(action, getWindow().getSelectionService().getSelection());
        initAction.setActivePart(action, getWindow().getPartService().getActivePart());
        initAction.run(action);
    }

    /**
     * Template method for the init actin to run.
     * 
     * @return the init action to run. must not be null
     */
    protected abstract IObjectActionDelegate getInitAction();
}
