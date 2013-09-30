/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider {

	/**
 * @generated
 */
	private org.eclipse.ui.IWorkbenchPart part;

	/**
 * @generated
 */
	private de.uka.ipd.sdq.pcm.gmf.allocation.part.DeleteElementAction deleteAction;

	/**
 * @generated
 */
	public DiagramEditorContextMenuProvider(org.eclipse.ui.IWorkbenchPart part, org.eclipse.gef.EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new de.uka.ipd.sdq.pcm.gmf.allocation.part.DeleteElementAction(part);
		deleteAction.init();
	}

	/**
 * @generated
 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}
		super.dispose();
	}

	/**
 * @generated
 */
	public void buildContextMenu(final org.eclipse.jface.action.IMenuManager menu) {
		getViewer().flush();
		try {
			org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(
					(org.eclipse.emf.ecore.EObject) getViewer().getContents().getModel()).runExclusive(new Runnable() {

				public void run() {
					org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService.getInstance().contributeToPopupMenu(
							DiagramEditorContextMenuProvider.this, part);
					menu.remove(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_DELETE_FROM_MODEL);
					menu.appendToGroup("editGroup", deleteAction);
				}
			});
		} catch (Exception e) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError("Error building context menu", e);
		}
	}
	}
