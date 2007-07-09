/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class ResourceContainerAllocationCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated not
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		EObject allocation = ((View) getHost().getParent().getParent()
				.getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Allocation) allocation)
				.getAllocationContexts_Allocation().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			AllocationContext ac = (AllocationContext) nextValue;
			if (ac.getResourceContainer_AllocationContext() == modelObject) {
				nodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, nextValue);
				if (AllocationContextEditPart.VISUAL_ID == nodeVID) {
					result.add(nextValue);
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return view.isSetElement()
					&& (view.getElement() == null || view.getElement()
							.eIsProxy());
		}
		int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (nodeVID) {
		case AllocationContextEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
