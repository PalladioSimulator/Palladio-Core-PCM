/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;

/**
 * @generated
 */
public class PalladioComponentModelNewDiagramFileWizard extends Wizard {

    /**
     * @generated
     */
    private WizardNewFileCreationPage myFileCreationPage;

    /**
     * @generated
     */
    private ModelElementSelectionPage diagramRootElementSelectionPage;

    /**
     * @generated
     */
    private TransactionalEditingDomain myEditingDomain;

    /**
     * @generated
     */
    public PalladioComponentModelNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot,
            TransactionalEditingDomain editingDomain) {
        assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
        assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
        assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

        myFileCreationPage = new WizardNewFileCreationPage(
                Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageName, StructuredSelection.EMPTY);
        myFileCreationPage.setTitle(Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageTitle);
        myFileCreationPage.setDescription(NLS.bind(
                Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageDescription,
                AllocationEditPart.MODEL_ID));
        IPath filePath;
        String fileName = URI.decode(domainModelURI.trimFileExtension().lastSegment());
        if (domainModelURI.isPlatformResource()) {
            filePath = new Path(domainModelURI.trimSegments(1).toPlatformString(true));
        } else if (domainModelURI.isFile()) {
            filePath = new Path(domainModelURI.trimSegments(1).toFileString());
        } else {
            // TODO : use some default path
            throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); //$NON-NLS-1$
        }
        myFileCreationPage.setContainerFullPath(filePath);
        myFileCreationPage.setFileName(PalladioComponentModelDiagramEditorUtil.getUniqueFileName(filePath, fileName,
                "allocation_diagram")); //$NON-NLS-1$

        diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(
                Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageName);
        diagramRootElementSelectionPage
                .setTitle(Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageTitle);
        diagramRootElementSelectionPage
                .setDescription(Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageDescription);
        diagramRootElementSelectionPage.setModelElement(diagramRoot);

        myEditingDomain = editingDomain;
    }

    /**
     * @generated
     */
    public void addPages() {
        addPage(myFileCreationPage);
        addPage(diagramRootElementSelectionPage);
    }

    /**
     * @generated
     */
    public boolean performFinish() {
        List affectedFiles = new LinkedList();
        IFile diagramFile = myFileCreationPage.createNewFile();
        PalladioComponentModelDiagramEditorUtil.setCharset(diagramFile);
        affectedFiles.add(diagramFile);
        URI diagramModelURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
        ResourceSet resourceSet = myEditingDomain.getResourceSet();
        final Resource diagramResource = resourceSet.createResource(diagramModelURI);
        AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
                Messages.PalladioComponentModelNewDiagramFileWizard_InitDiagramCommand, affectedFiles) {

            protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                int diagramVID = PalladioComponentModelVisualIDRegistry
                        .getDiagramVisualID(diagramRootElementSelectionPage.getModelElement());
                if (diagramVID != AllocationEditPart.VISUAL_ID) {
                    return CommandResult
                            .newErrorCommandResult(Messages.PalladioComponentModelNewDiagramFileWizard_IncorrectRootError);
                }
                Diagram diagram = ViewService.createDiagram(diagramRootElementSelectionPage.getModelElement(),
                        AllocationEditPart.MODEL_ID,
                        PalladioComponentModelAllocationDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
                diagramResource.getContents().add(diagram);
                return CommandResult.newOKCommandResult();
            }
        };
        try {
            OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
            diagramResource.save(PalladioComponentModelDiagramEditorUtil.getSaveOptions());
            PalladioComponentModelDiagramEditorUtil.openDiagram(diagramResource);
        } catch (ExecutionException e) {
            PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
                    "Unable to create model and diagram", e); //$NON-NLS-1$
        } catch (IOException ex) {
            PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
                    "Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
        } catch (PartInitException ex) {
            PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * @generated
     */
    private static class DiagramRootElementSelectionPage extends ModelElementSelectionPage {

        /**
         * @generated
         */
        protected DiagramRootElementSelectionPage(String pageName) {
            super(pageName);
        }

        /**
         * @generated
         */
        protected String getSelectionTitle() {
            return Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageSelectionTitle;
        }

        /**
         * @generated
         */
        protected boolean validatePage() {
            if (selectedModelElement == null) {
                setErrorMessage(Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
                return false;
            }
            boolean result = ViewService.getInstance().provides(
                    new CreateDiagramViewOperation(new EObjectAdapter(selectedModelElement),
                            AllocationEditPart.MODEL_ID,
                            PalladioComponentModelAllocationDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
            setErrorMessage(result ? null
                    : Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
            return result;
        }
    }
}
