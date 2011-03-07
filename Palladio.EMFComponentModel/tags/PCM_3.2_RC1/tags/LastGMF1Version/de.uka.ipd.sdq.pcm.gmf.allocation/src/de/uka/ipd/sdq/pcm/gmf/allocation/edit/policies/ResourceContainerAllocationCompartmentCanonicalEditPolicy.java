/*
 *copyright 2006, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.allocation.Allocation;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PcmVisualIDRegistry;

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
	 * @generated NOT
	 * - Return the right model object
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getParent().getParent()
				.getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Allocation) modelObject)
				.getAllocationContexts_Allocation().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			if (AllocationContextEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null
				&& view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
