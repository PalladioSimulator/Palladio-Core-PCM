/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class AssemblyContextCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated not
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		AssemblyContext ctx = (AssemblyContext) modelObject;
		modelObject = ctx.getEncapsulatedComponent_AssemblyContext();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		if (modelObject != null) {
			for (Iterator values = ((InterfaceProvidingEntity) modelObject)
					.getProvidedRoles_InterfaceProvidingEntity().iterator(); values
					.hasNext();) {
				nextValue = (EObject) values.next();
				nodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, nextValue);
				if (ProvidedRoleEditPart.VISUAL_ID == nodeVID) {
					result.add(nextValue);
				}
			}
			for (Iterator values = ((InterfaceRequiringEntity) modelObject)
					.getRequiredRoles_InterfaceRequiringEntity().iterator(); values
					.hasNext();) {
				nextValue = (EObject) values.next();
				nodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, nextValue);
				if (RequiredRoleEditPart.VISUAL_ID == nodeVID) {
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
		case ProvidedRoleEditPart.VISUAL_ID:
		case RequiredRoleEditPart.VISUAL_ID:
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
