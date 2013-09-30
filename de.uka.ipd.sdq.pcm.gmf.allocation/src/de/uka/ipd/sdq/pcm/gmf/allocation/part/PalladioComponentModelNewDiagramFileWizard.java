/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelNewDiagramFileWizard extends org.eclipse.jface.wizard.Wizard {

	/**
 * @generated
 */
	private 
org.eclipse.ui.dialogs.WizardNewFileCreationPage myFileCreationPage;

	/**
 * @generated
 */
	private de.uka.ipd.sdq.pcm.gmf.allocation.part.ModelElementSelectionPage diagramRootElementSelectionPage;

	/**
 * @generated
 */
	private org.eclipse.emf.transaction.TransactionalEditingDomain myEditingDomain;

	/**
 * @generated
 */
	public PalladioComponentModelNewDiagramFileWizard(org.eclipse.emf.common.util.URI domainModelURI,
			org.eclipse.emf.ecore.EObject diagramRoot,
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain) {
		assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
	    assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
	    assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

		myFileCreationPage = new 
org.eclipse.ui.dialogs.WizardNewFileCreationPage(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageName, org.eclipse.jface.viewers.StructuredSelection.EMPTY);
		myFileCreationPage.setTitle(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageTitle);
		myFileCreationPage.setDescription(org.eclipse.osgi.util.NLS.bind(
				de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_CreationPageDescription, 
				de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID));
		org.eclipse.core.runtime.IPath filePath;
		String fileName = org.eclipse.emf.common.util.URI.decode(domainModelURI.trimFileExtension().lastSegment());
		if (domainModelURI.isPlatformResource()) {
			filePath = new org.eclipse.core.runtime.Path(domainModelURI.trimSegments(1).toPlatformString(true));
		} else if (domainModelURI.isFile()) {
			filePath = new org.eclipse.core.runtime.Path(domainModelURI.trimSegments(1).toFileString());
		} else {
			// TODO : use some default path
			throw new IllegalArgumentException("Unsupported URI: " + domainModelURI);  //$NON-NLS-1$
		}
		myFileCreationPage.setContainerFullPath(filePath);
		myFileCreationPage.setFileName(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.getUniqueFileName(
				filePath, fileName, "allocation_diagram"));  //$NON-NLS-1$

		diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageName);
		diagramRootElementSelectionPage.setTitle(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageTitle);
		diagramRootElementSelectionPage.setDescription(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageDescription);
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
		java.util.LinkedList<org.eclipse.core.resources.IFile> affectedFiles = new java.util.LinkedList<org.eclipse.core.resources.IFile>();
				org.eclipse.core.resources.IFile diagramFile = myFileCreationPage.createNewFile();
		de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.setCharset(diagramFile);
		affectedFiles.add(diagramFile);
		org.eclipse.emf.common.util.URI diagramModelURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
				org.eclipse.emf.ecore.resource.ResourceSet resourceSet = myEditingDomain.getResourceSet();
		final org.eclipse.emf.ecore.resource.Resource diagramResource = resourceSet.createResource(diagramModelURI);
		org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand command =
			new org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand(
				myEditingDomain, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_InitDiagramCommand, affectedFiles) {

			protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(
					org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info)
						throws org.eclipse.core.commands.ExecutionException {
				int diagramVID = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getDiagramVisualID(diagramRootElementSelectionPage.getModelElement());
				if (diagramVID != de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID) {
					return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult(
						de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_IncorrectRootError);
				}
				org.eclipse.gmf.runtime.notation.Diagram diagram =
					org.eclipse.gmf.runtime.diagram.core.services.ViewService.createDiagram(
						diagramRootElementSelectionPage.getModelElement(), de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID,
						de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
												return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult();
			}
		};
		try {
			org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory().execute(
				command, new org.eclipse.core.runtime.NullProgressMonitor(), null);
			diagramResource.save(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.getSaveOptions());
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.openDiagram(diagramResource);
		} catch (org.eclipse.core.commands.ExecutionException e) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
				"Unable to create model and diagram", e);  //$NON-NLS-1$
		} catch (java.io.IOException ex) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
				"Save operation failed for: " + diagramModelURI, ex);  //$NON-NLS-1$
		} catch (org.eclipse.ui.PartInitException ex) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
				"Unable to open editor", ex);  //$NON-NLS-1$
		}			
		return true;
	}

	/**
 * @generated
 */
	private static class DiagramRootElementSelectionPage extends de.uka.ipd.sdq.pcm.gmf.allocation.part.ModelElementSelectionPage {

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
			return de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageSelectionTitle;
		}

		/**
 * @generated
 */
		protected boolean validatePage() {
			if (selectedModelElement == null) {
				setErrorMessage(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
				return false;
			}
			boolean result = org.eclipse.gmf.runtime.diagram.core.services.ViewService.getInstance().provides(
				new org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation(
					new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(selectedModelElement),
					de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
			setErrorMessage(result ? null : de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
			return result;
		}
	}
}
