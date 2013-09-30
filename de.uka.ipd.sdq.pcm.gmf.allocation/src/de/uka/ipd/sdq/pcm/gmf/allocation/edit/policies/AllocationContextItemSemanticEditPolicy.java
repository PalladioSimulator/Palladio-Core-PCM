	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

/**
 * @generated
 */
public class AllocationContextItemSemanticEditPolicy extends de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy {

		/**
 * @generated
 */
	public AllocationContextItemSemanticEditPolicy() {
				super(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.AllocationContext_3002);
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
		// there are indirectly referenced children, need extra commands: false
		addDestroyShortcutsCommand(cmd, view);
		// delete host element
		cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
	} else {
		cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), view));
	}
	return getGEFWrapper(cmd.reduce());
}
					
	}
