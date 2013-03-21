	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

/**
 * @generated
 */
public class ResourceContainerItemSemanticEditPolicy extends de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy {

		/**
 * @generated
 */
	public ResourceContainerItemSemanticEditPolicy() {
				super(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.ResourceContainer_2003);
	}

	
	/**
 * @generated
 */
protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
	org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
	org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);
	cmd.setTransactionNestingEnabled(false);
		org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
	if (annotation == null) {
		// there are indirectly referenced children, need extra commands: true
		addDestroyChildNodesCommand(cmd);
		addDestroyShortcutsCommand(cmd, view);
		// delete host element
		cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
	} else {
		cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), view));
	}
	return getGEFWrapper(cmd.reduce());
}
			
	/**
 * @generated
 */
	private void addDestroyChildNodesCommand(org.eclipse.gmf.runtime.common.core.command.ICompositeCommand cmd) {
		org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
		for (java.util.Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			org.eclipse.gmf.runtime.notation.Node node = (org.eclipse.gmf.runtime.notation.Node) nit.next();
			switch (de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(node)) {
									case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
				for (java.util.Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					org.eclipse.gmf.runtime.notation.Node cnode = (org.eclipse.gmf.runtime.notation.Node) cit.next();
					switch (de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(cnode)) {
					case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:
		cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
	// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
	// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
	break;
					}
				}
				break;
						}
		}
	}
					
	}
