/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;

/**
 * @generated
 */
public class BasicComponentSEFFCompartmentCanonicalEditPolicy extends
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
		for (Iterator values = ((BasicComponent) modelObject)
				.getServiceEffectSpecifications__BasicComponent().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
					viewObject, nextValue);
			if (ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
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
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
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
