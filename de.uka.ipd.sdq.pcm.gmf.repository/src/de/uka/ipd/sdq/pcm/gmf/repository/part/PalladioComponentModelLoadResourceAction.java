/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;

/**
 * @generated
 */
public class PalladioComponentModelLoadResourceAction implements IObjectActionDelegate {

    /**
     * @generated
     */
    private RepositoryEditPart mySelectedElement;

    /**
     * @generated
     */
    private Shell myShell;

    /**
     * @generated
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        myShell = targetPart.getSite().getShell();
    }

    /**
     * @generated
     */
    public void run(IAction action) {
        LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(myShell,
                mySelectedElement.getEditingDomain());
        loadResourceDialog.open();
    }

    /**
     * @generated
     */
    public void selectionChanged(IAction action, ISelection selection) {
        mySelectedElement = null;
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof RepositoryEditPart) {
                mySelectedElement = (RepositoryEditPart) structuredSelection.getFirstElement();
            }
        }
        action.setEnabled(isEnabled());
    }

    /**
     * @generated
     */
    private boolean isEnabled() {
        return mySelectedElement != null;
    }

}
