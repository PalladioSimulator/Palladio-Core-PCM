/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;

/**
 * The Class PalladioComponentModelLoadResourceAction.
 * 
 * @generated
 */
public class PalladioComponentModelLoadResourceAction implements IObjectActionDelegate {

    /** The my selected element. @generated */
    private ComposedProvidingRequiringEntityEditPart mySelectedElement;

    /** The my shell. @generated */
    private Shell myShell;

    /**
     * Sets the active part.
     * 
     * @param action
     *            the action
     * @param targetPart
     *            the target part
     * @generated
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        myShell = targetPart.getSite().getShell();
    }

    /**
     * Run.
     * 
     * @param action
     *            the action
     * @generated
     */
    public void run(IAction action) {
        LoadResourceDialog loadResourceDialog = new LoadResourceDialog(myShell, mySelectedElement.getEditingDomain());
        loadResourceDialog.open();
    }

    /**
     * Selection changed.
     * 
     * @param action
     *            the action
     * @param selection
     *            the selection
     * @generated
     */
    public void selectionChanged(IAction action, ISelection selection) {
        mySelectedElement = null;
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.size() == 1
                    && structuredSelection.getFirstElement() instanceof ComposedProvidingRequiringEntityEditPart) {
                mySelectedElement = (ComposedProvidingRequiringEntityEditPart) structuredSelection.getFirstElement();
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
