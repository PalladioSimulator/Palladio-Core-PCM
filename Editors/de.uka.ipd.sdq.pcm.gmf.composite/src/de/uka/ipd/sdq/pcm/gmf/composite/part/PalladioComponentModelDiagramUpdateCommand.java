/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * The Class PalladioComponentModelDiagramUpdateCommand.
 * 
 * @generated
 */
public class PalladioComponentModelDiagramUpdateCommand implements IHandler {

    /**
     * Adds the handler listener.
     * 
     * @param handlerListener
     *            the handler listener
     * @generated
     */
    public void addHandlerListener(IHandlerListener handlerListener) {
    }

    /**
     * Dispose.
     * 
     * @generated
     */
    public void dispose() {
    }

    /**
     * Execute.
     * 
     * @param event
     *            the event
     * @return the object
     * @throws ExecutionException
     *             the execution exception
     * @generated
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
                .getSelection();
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.size() != 1) {
                return null;
            }
            if (structuredSelection.getFirstElement() instanceof EditPart
                    && ((EditPart) structuredSelection.getFirstElement()).getModel() instanceof View) {
                EObject modelElement = ((View) ((EditPart) structuredSelection.getFirstElement()).getModel())
                        .getElement();
                List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);
                for (Iterator it = editPolicies.iterator(); it.hasNext();) {
                    CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
                    nextEditPolicy.refresh();
                }

            }
        }
        return null;
    }

    /**
     * Checks if is enabled.
     * 
     * @return true, if is enabled
     * @generated
     */
    public boolean isEnabled() {
        return true;
    }

    /**
     * Checks if is handled.
     * 
     * @return true, if is handled
     * @generated
     */
    public boolean isHandled() {
        return true;
    }

    /**
     * Removes the handler listener.
     * 
     * @param handlerListener
     *            the handler listener
     * @generated
     */
    public void removeHandlerListener(IHandlerListener handlerListener) {
    }

}
