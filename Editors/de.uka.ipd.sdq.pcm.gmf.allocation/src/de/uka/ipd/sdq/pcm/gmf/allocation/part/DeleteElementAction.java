/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class DeleteElementAction extends org.eclipse.gmf.runtime.diagram.ui.actions.AbstractDeleteFromAction {

	/**
 * @generated
 */
	public DeleteElementAction(org.eclipse.ui.IWorkbenchPart part) {
		super(part);
	}

	/**
 * @generated
 */
	public DeleteElementAction(org.eclipse.ui.IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
 * @generated
 */
	public void init() {
		super.init();
		setId(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_DELETE_FROM_MODEL);
		setText(org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages.DiagramEditor_Delete_from_Model);
		setToolTipText(org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages.DiagramEditor_Delete_from_ModelToolTip);
		org.eclipse.ui.ISharedImages workbenchImages = org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages();
		setHoverImageDescriptor(workbenchImages.getImageDescriptor(org.eclipse.ui.ISharedImages.IMG_TOOL_DELETE));
		setImageDescriptor(workbenchImages.getImageDescriptor(org.eclipse.ui.ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(workbenchImages.getImageDescriptor(org.eclipse.ui.ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}

	/**
 * @generated
 */
	protected String getCommandLabel() {
		return org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages.DiagramEditor_Delete_from_Model;
	}

	/**
 * @generated
 */
	protected org.eclipse.gef.commands.Command getCommand(org.eclipse.gef.Request request) {
		java.util.List operationSet = getOperationSet();
		if (operationSet.isEmpty()) {
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		}
		java.util.Iterator editParts = operationSet.iterator();
		org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand command =
				new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), getCommandLabel());
		while (editParts.hasNext()) {
			org.eclipse.gef.EditPart editPart = (org.eclipse.gef.EditPart) editParts.next();
			org.eclipse.gef.commands.Command curCommand = editPart.getCommand(request);
			if (curCommand != null) {
				command.compose(new org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy(curCommand));
			}
		}
		if (command.isEmpty() || command.size() != operationSet.size()) {
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		}
		return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(command);
	}
	}
