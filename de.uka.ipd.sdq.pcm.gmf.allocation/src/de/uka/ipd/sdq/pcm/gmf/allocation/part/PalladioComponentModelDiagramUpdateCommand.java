	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

	/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdateCommand implements org.eclipse.core.commands.IHandler {

		/**
 * @generated
 */
public void addHandlerListener(org.eclipse.core.commands.IHandlerListener handlerListener) {
}

		/**
 * @generated
 */
public void dispose() {
}

		/**
 * @generated
 */
public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
	org.eclipse.jface.viewers.ISelection selection = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
	if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
		org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) selection;
		if (structuredSelection.size() != 1) {
			return null;
		}
		if (structuredSelection.getFirstElement() instanceof org.eclipse.gef.EditPart && ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel() instanceof org.eclipse.gmf.runtime.notation.View) {
			org.eclipse.emf.ecore.EObject modelElement = ((org.eclipse.gmf.runtime.notation.View) ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel()).getElement();
			java.util.List editPolicies = org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);
			for (java.util.Iterator it = editPolicies.iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy nextEditPolicy = (org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy) it.next();
				nextEditPolicy.refresh();
			}

		}
	}
	return null;
}

		/**
 * @generated
 */
public boolean isEnabled() {
	return true;
}

		/**
 * @generated
 */
public boolean isHandled() {
	return true;
}

		/**
 * @generated
 */
public void removeHandlerListener(org.eclipse.core.commands.IHandlerListener handlerListener) {
}

	}
