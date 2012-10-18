package de.uka.ipd.sdq.pcm.gmf.toolbar;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;

/**
 * Baseclass for the new diagram actions. A factory method is used to retrieve the new wizard of the
 * appropriate package.
 * 
 * @author Philipp Meier
 */
public abstract class BaseNewDiagramAction extends BaseDiagramAction {

    /**
     * Run.
     *
     * @param action the action
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    @Override
    public void run(final IAction action) {
        INewWizard wizard = getNewWizard();
        assert (wizard != null);

        wizard.init(getWindow().getWorkbench(), new StructuredSelection());

        WizardDialog dialog = new WizardDialog(getWindow().getShell(), wizard);
        dialog.open();
    }

    /**
     * Template method for the new wizard to open.
     * 
     * @return the new wizard to open. must not be null
     */
    protected abstract INewWizard getNewWizard();
}
