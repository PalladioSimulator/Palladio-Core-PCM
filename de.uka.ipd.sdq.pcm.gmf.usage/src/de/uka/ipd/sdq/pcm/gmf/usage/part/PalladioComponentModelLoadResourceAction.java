/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;

/**
 * The Class PalladioComponentModelLoadResourceAction.
 *
 * @generated
 */
public class PalladioComponentModelLoadResourceAction implements IObjectActionDelegate {

    /** The my selected element. @generated */
    private UsageScenarioEditPart mySelectedElement;

    /** The my shell. @generated */
    private Shell myShell;

    /**
     * Sets the active part.
     *
     * @param action the action
     * @param targetPart the target part
     * @generated
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        myShell = targetPart.getSite().getShell();
    }

    /**
     * Run.
     *
     * @param action the action
     * @generated
     */
    public void run(IAction action) {
        LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(myShell,
                mySelectedElement.getEditingDomain());
        loadResourceDialog.open();
    }

    /**
     * Selection changed.
     *
     * @param action the action
     * @param selection the selection
     * @generated
     */
    public void selectionChanged(IAction action, ISelection selection) {
        mySelectedElement = null;
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.size() == 1
                    && structuredSelection.getFirstElement() instanceof UsageScenarioEditPart) {
                mySelectedElement = (UsageScenarioEditPart) structuredSelection.getFirstElement();
            }
        }
        action.setEnabled(isEnabled());
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     * @generated
     */
    private boolean isEnabled() {
        return mySelectedElement != null;
    }

}
