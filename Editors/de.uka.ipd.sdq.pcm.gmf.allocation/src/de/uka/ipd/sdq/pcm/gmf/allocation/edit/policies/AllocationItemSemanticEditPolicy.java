	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

	/**
 * @generated
 */
public class AllocationItemSemanticEditPolicy extends de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy {

		/**
 * @generated
 */
	public AllocationItemSemanticEditPolicy() {
				super(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.Allocation_1000);
	}

	
	/**
 * @generated
 */
	protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
		if (de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.ResourceContainer_2003 == req.getElementType()) {
	return getGEFWrapper(new de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.ResourceContainerCreateCommand(req));
}
		return super.getCreateCommand(req);
	}
	
		/**
 * @generated
 */
protected org.eclipse.gef.commands.Command getDuplicateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest req) {
	org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = ((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) getHost()).getEditingDomain();
	return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
}
	
		/**
 * @generated
 */
private static class DuplicateAnythingCommand extends org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand {

		/**
 * @generated
 */
public DuplicateAnythingCommand(org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest req) {
	super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
}

	}
	
	}
