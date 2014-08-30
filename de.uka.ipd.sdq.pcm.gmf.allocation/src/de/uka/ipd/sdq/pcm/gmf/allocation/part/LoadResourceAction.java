/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class LoadResourceAction extends org.eclipse.core.commands.AbstractHandler {
	/**
 * @generated
 */
	public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
		org.eclipse.ui.IEditorPart diagramEditor = org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked(event);
		org.eclipse.swt.widgets.Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
		org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = ((org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor) diagramEditor).getEditingDomain();
		org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog loadResourceDialog = new org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog(shell, editingDomain);
		loadResourceDialog.open();
		return null;
	}

}
