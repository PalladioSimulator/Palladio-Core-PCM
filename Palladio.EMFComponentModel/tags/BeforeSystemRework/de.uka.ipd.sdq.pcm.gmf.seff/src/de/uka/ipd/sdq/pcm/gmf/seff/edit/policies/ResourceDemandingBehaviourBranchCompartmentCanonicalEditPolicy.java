/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class ResourceDemandingBehaviourBranchCompartmentCanonicalEditPolicy
		extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((ResourceDemandingBehaviour) modelObject)
				.getSteps_Behaviour().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case StartAction2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case StopAction2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case LoopAction2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case InternalActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case BranchActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case ExternalCallAction2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
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
