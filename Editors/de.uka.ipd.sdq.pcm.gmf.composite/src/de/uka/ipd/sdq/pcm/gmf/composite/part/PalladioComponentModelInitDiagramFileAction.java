/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;

/**
 * The Class PalladioComponentModelInitDiagramFileAction.
 * 
 * @generated
 */
public class PalladioComponentModelInitDiagramFileAction implements IObjectActionDelegate {

    /** The target part. @generated */
    private IWorkbenchPart targetPart;

    /** The domain model uri. @generated */
    private URI domainModelURI;

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
        this.targetPart = targetPart;
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
        domainModelURI = null;
        action.setEnabled(false);
        if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
            return;
        }
        IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
        domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        action.setEnabled(true);
    }

    /**
     * Gets the shell.
     * 
     * @return the shell
     * @generated
     */
    private Shell getShell() {
        return targetPart.getSite().getShell();
    }

    /**
     * Run.
     * 
     * @param action
     *            the action
     * @generated
     */
    public void run(IAction action) {
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
        ResourceSet resourceSet = editingDomain.getResourceSet();
        EObject diagramRoot = null;
        try {
            Resource resource = resourceSet.getResource(domainModelURI, true);
            diagramRoot = (EObject) resource.getContents().get(0);
        } catch (WrappedException ex) {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Unable to load resource: " + domainModelURI, ex); //$NON-NLS-1$
        }
        if (diagramRoot == null) {
            MessageDialog.openError(getShell(), Messages.InitDiagramFile_ResourceErrorDialogTitle,
                    Messages.InitDiagramFile_ResourceErrorDialogMessage);
            return;
        }
        Wizard wizard = new PalladioComponentModelNewDiagramFileWizard(domainModelURI, diagramRoot, editingDomain);
        wizard.setWindowTitle(NLS.bind(Messages.InitDiagramFile_WizardTitle,
                ComposedProvidingRequiringEntityEditPart.MODEL_ID));
        PalladioComponentModelDiagramEditorUtil.runWizard(getShell(), wizard, "InitDiagramFile"); //$NON-NLS-1$
    }
}
