	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

	/**
 * @generated
 */
public class PalladioComponentModelAllocationDiagramEditor  extends org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor implements org.eclipse.ui.ide.IGotoMarker {

		/**
 * @generated
 */
public static final String ID = "de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorID";  //$NON-NLS-1$
	
	/**
 * @generated
 */
public static final String CONTEXT_ID = "de.uka.ipd.sdq.pcm.gmf.allocation.ui.diagramContext";  //$NON-NLS-1$
	
		/**
 * @generated
 */
public PalladioComponentModelAllocationDiagramEditor() {
	super(true);
}
	
		/**
 * @generated
 */
protected String getContextID() {
	return CONTEXT_ID;
}
	
	/**
 * @generated
 */
protected org.eclipse.gef.palette.PaletteRoot createPaletteRoot(org.eclipse.gef.palette.PaletteRoot existingPaletteRoot) {
	org.eclipse.gef.palette.PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
	new de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelPaletteFactory().fillPalette(root);
	return root;
}
	
		/**
 * @generated
 */
protected org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint getPreferencesHint() {
	return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
}
	
		/**
 * @generated
 */
public String getContributorId() {
	return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID;
}
		
		/**
 * @generated
 */
protected org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider getDocumentProvider(org.eclipse.ui.IEditorInput input) {
	if (input instanceof org.eclipse.ui.IFileEditorInput || input instanceof org.eclipse.emf.common.ui.URIEditorInput) {
		return de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getDocumentProvider();
	}
	return super.getDocumentProvider(input);
}
	
		/**
 * @generated
 */
public org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
	if (document instanceof org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) {
		return ((org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document).getEditingDomain();
	}
	return super.getEditingDomain();
}
	
		/**
 * @generated
 */
protected void setDocumentProvider(org.eclipse.ui.IEditorInput input) {
	if (input instanceof org.eclipse.ui.IFileEditorInput || input instanceof org.eclipse.emf.common.ui.URIEditorInput) {
		setDocumentProvider(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().getDocumentProvider());
	} else {
		super.setDocumentProvider(input);
	}
}
		
			/**
 * @generated
 */
public void gotoMarker(org.eclipse.core.resources.IMarker marker) {
	org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService.getInstance().gotoMarker(this, marker);
}
		
			/**
 * @generated
 */
public boolean isSaveAsAllowed() {
	return true;
}
		
			/**
 * @generated
 */
public void doSaveAs() {
	performSaveAs(new org.eclipse.core.runtime.NullProgressMonitor());
}
		
			/**
 * @generated
 */
protected void performSaveAs(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {
	org.eclipse.swt.widgets.Shell shell = getSite().getShell();
	org.eclipse.ui.IEditorInput input = getEditorInput();
	org.eclipse.ui.dialogs.SaveAsDialog dialog = new org.eclipse.ui.dialogs.SaveAsDialog(shell);
	org.eclipse.core.resources.IFile original = input instanceof org.eclipse.ui.IFileEditorInput ? ((org.eclipse.ui.IFileEditorInput) input).getFile() : null;
	if (original != null) {
		dialog.setOriginalFile(original);
	}
	dialog.create();
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider provider = getDocumentProvider();
	if (provider == null) {
		// editor has been programmatically closed while the dialog was open
		return;
	}
	if (provider.isDeleted(input) && original != null) {
		String message = org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelAllocationDiagramEditor_SavingDeletedFile, original.getName());
		dialog.setErrorMessage(null);
		dialog.setMessage(message, org.eclipse.jface.dialogs.IMessageProvider.WARNING);
	}
	if (dialog.open() == org.eclipse.jface.window.Window.CANCEL) {
		if (progressMonitor != null) {
			progressMonitor.setCanceled(true);
		}
		return;
	}
	org.eclipse.core.runtime.IPath filePath = dialog.getResult();
	if (filePath == null) {
		if (progressMonitor != null) {
			progressMonitor.setCanceled(true);
		}
		return;
	}
	org.eclipse.core.resources.IWorkspaceRoot workspaceRoot = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	org.eclipse.core.resources.IFile file = workspaceRoot.getFile(filePath);
	final org.eclipse.ui.IEditorInput newInput = new org.eclipse.ui.part.FileEditorInput(file);
	// Check if the editor is already open
	org.eclipse.ui.IEditorMatchingStrategy matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();
	org.eclipse.ui.IEditorReference[] editorRefs = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
	for (int i = 0; i < editorRefs.length; i++) {
		if (matchingStrategy.matches(editorRefs[i], newInput)) {
			org.eclipse.jface.dialogs.MessageDialog.openWarning(shell, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelAllocationDiagramEditor_SaveAsErrorTitle, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelAllocationDiagramEditor_SaveAsErrorMessage);
			return;
		}
	}
	boolean success = false;
	try {
		provider.aboutToChange(newInput);
		getDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);
		success = true;
	} catch (org.eclipse.core.runtime.CoreException x) {
		org.eclipse.core.runtime.IStatus status = x.getStatus();
		if (status == null || status.getSeverity() != org.eclipse.core.runtime.IStatus.CANCEL) {
			org.eclipse.jface.dialogs.ErrorDialog.openError(shell, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelAllocationDiagramEditor_SaveErrorTitle, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelAllocationDiagramEditor_SaveErrorMessage, x.getStatus());
		}
	} finally {
		provider.changed(newInput);
		if (success) {
			setInput(newInput);
		}
	}
	if (progressMonitor != null) {
		progressMonitor.setCanceled(!success);
	}
}
		
			/**
 * @generated
 */
public org.eclipse.ui.part.ShowInContext getShowInContext() {
	return new org.eclipse.ui.part.ShowInContext(getEditorInput(), getGraphicalViewer().getSelection());
}
			
		/**
 * @generated
 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		de.uka.ipd.sdq.pcm.gmf.allocation.part.DiagramEditorContextMenuProvider provider =
				new de.uka.ipd.sdq.pcm.gmf.allocation.part.DiagramEditorContextMenuProvider(this, getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
	}

	
	}
