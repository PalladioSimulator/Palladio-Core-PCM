/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class PalladioComponentModelCreationWizard extends Wizard implements INewWizard {

    /**
     * @generated
     */
    private IWorkbench workbench;

    /**
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * @generated
     */
    protected PalladioComponentModelCreationWizardPage diagramModelFilePage;

    /**
     * @generated
     */
    protected PalladioComponentModelCreationWizardPage domainModelFilePage;

    /**
     * @generated
     */
    protected Resource diagram;

    /**
     * @generated
     */
    private boolean openNewlyCreatedDiagramEditor = true;

    /**
     * @generated
     */
    public IWorkbench getWorkbench() {
        return workbench;
    }

    /**
     * @generated
     */
    public IStructuredSelection getSelection() {
        return selection;
    }

    /**
     * @generated
     */
    public final Resource getDiagram() {
        return diagram;
    }

    /**
     * @generated
     */
    public final boolean isOpenNewlyCreatedDiagramEditor() {
        return openNewlyCreatedDiagramEditor;
    }

    /**
     * @generated
     */
    public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
        this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
    }

    /**
     * @generated
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(Messages.PalladioComponentModelCreationWizardTitle);
        setDefaultPageImageDescriptor(PalladioComponentModelComposedStructureDiagramEditorPlugin
                .getBundledImageDescriptor("icons/wizban/NewEntityWizard.gif")); //$NON-NLS-1$
        setNeedsProgressMonitor(true);
    }

    /**
     * Adds the pages.
     * 
     * @generated not
     */
    public void addPages() {
        diagramModelFilePage = new PalladioComponentModelCreationWizardPage(
                "DiagramModelFile", getSelection(), "system_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
        diagramModelFilePage.setTitle("Create CompositeModel Diagram");
        diagramModelFilePage.setDescription("Select file that will contain composite diagram model.");
        addPage(diagramModelFilePage);

        domainModelFilePage = new PalladioComponentModelCreationWizardPage("DomainModelFile", getSelection(), "system"); //$NON-NLS-1$ //$NON-NLS-2$
        domainModelFilePage.setTitle("Create CompositeModel");
        domainModelFilePage.setDescription("Select file that will contain composite domain model.");
        addPage(domainModelFilePage);
    }

    /**
     * @generated
     */
    public boolean performFinish() {
        IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

            protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
                diagram = PalladioComponentModelDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(),
                        domainModelFilePage.getURI(), monitor);
                if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
                    try {
                        PalladioComponentModelDiagramEditorUtil.openDiagram(diagram);
                    } catch (PartInitException e) {
                        ErrorDialog.openError(getContainer().getShell(),
                                Messages.PalladioComponentModelCreationWizardOpenEditorError, null, e.getStatus());
                    }
                }
            }
        };
        try {
            getContainer().run(false, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof CoreException) {
                ErrorDialog.openError(getContainer().getShell(),
                        Messages.PalladioComponentModelCreationWizardCreationError, null,
                        ((CoreException) e.getTargetException()).getStatus());
            } else {
                PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                        "Error creating diagram", e.getTargetException()); //$NON-NLS-1$
            }
            return false;
        }
        return diagram != null;
    }
}
