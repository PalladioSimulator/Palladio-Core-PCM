/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

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
        setDefaultPageImageDescriptor(PalladioComponentModelUsageDiagramEditorPlugin
                .getBundledImageDescriptor("icons/wizban/NewUsagemodelWizard.gif")); //$NON-NLS-1$
        setNeedsProgressMonitor(true);
    }

    /**
     * @generated
     */
    public void addPages() {
        diagramModelFilePage = new PalladioComponentModelCreationWizardPage(
                "DiagramModelFile", getSelection(), "usagemodel_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
        diagramModelFilePage.setTitle(Messages.PalladioComponentModelCreationWizard_DiagramModelFilePageTitle);
        diagramModelFilePage
                .setDescription(Messages.PalladioComponentModelCreationWizard_DiagramModelFilePageDescription);
        addPage(diagramModelFilePage);

        domainModelFilePage = new PalladioComponentModelCreationWizardPage(
                "DomainModelFile", getSelection(), "usagemodel") { //$NON-NLS-1$ //$NON-NLS-2$

            public void setVisible(boolean visible) {
                if (visible) {
                    String fileName = diagramModelFilePage.getFileName();
                    fileName = fileName.substring(0, fileName.length() - ".usagemodel_diagram".length()); //$NON-NLS-1$
                    setFileName(PalladioComponentModelDiagramEditorUtil.getUniqueFileName(getContainerFullPath(),
                            fileName, "usagemodel")); //$NON-NLS-1$
                }
                super.setVisible(visible);
            }
        };
        domainModelFilePage.setTitle(Messages.PalladioComponentModelCreationWizard_DomainModelFilePageTitle);
        domainModelFilePage
                .setDescription(Messages.PalladioComponentModelCreationWizard_DomainModelFilePageDescription);
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
                PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                        "Error creating diagram", e.getTargetException()); //$NON-NLS-1$
            }
            return false;
        }
        return diagram != null;
    }
}
