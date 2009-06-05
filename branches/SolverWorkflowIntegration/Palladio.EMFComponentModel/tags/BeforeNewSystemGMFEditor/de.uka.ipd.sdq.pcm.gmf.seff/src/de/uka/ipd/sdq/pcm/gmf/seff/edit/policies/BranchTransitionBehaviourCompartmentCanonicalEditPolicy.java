/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.seff.BranchTransition;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class BranchTransitionBehaviourCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		nextValue = ((BranchTransition) modelObject)
				.getBranchBehaviour_BranchTransition();
		nodeVID = PcmVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVID) {
			result.add(nextValue);
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
