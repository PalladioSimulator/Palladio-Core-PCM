/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.repository.Interface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class InterfaceSignatureListCanonicalEditPolicy extends
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
		for (Iterator values = ((Interface) modelObject)
				.getSignatures__Interface().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
					viewObject, nextValue);
			if (SignatureEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated not
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null;
		// && view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
