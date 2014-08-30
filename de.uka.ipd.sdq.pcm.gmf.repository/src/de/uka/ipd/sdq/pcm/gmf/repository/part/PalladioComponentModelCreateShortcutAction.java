/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.PalladioComponentModelCreateShortcutDecorationsCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;

/**
 * @generated
 */
public class PalladioComponentModelCreateShortcutAction implements IObjectActionDelegate {

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

    /**
     * @generated
     */
    public void run(IAction action) {
        final View view = (View) mySelectedElement.getModel();
        PalladioComponentModelElementChooserDialog elementChooser = new PalladioComponentModelElementChooserDialog(
                myShell, view);
        int result = elementChooser.open();
        if (result != Window.OK) {
            return;
        }
        URI selectedModelElementURI = elementChooser.getSelectedModelElementURI();
        final EObject selectedElement;
        try {
            selectedElement = mySelectedElement.getEditingDomain().getResourceSet()
                    .getEObject(selectedModelElementURI, true);
        } catch (WrappedException e) {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                    "Exception while loading object: " + selectedModelElementURI.toString(), e); //$NON-NLS-1$
            return;
        }

        if (selectedElement == null) {
            return;
        }
        CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(
                selectedElement), Node.class, null,
                PalladioComponentModelRepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
        ICommand command = new CreateCommand(mySelectedElement.getEditingDomain(), viewDescriptor, view);
        command = command.compose(new PalladioComponentModelCreateShortcutDecorationsCommand(mySelectedElement
                .getEditingDomain(), view, viewDescriptor));
        try {
            OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
        } catch (ExecutionException e) {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError("Unable to create shortcut", e); //$NON-NLS-1$
        }
    }
}
