/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class VariableUsageVariableCharacterisation2CanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = PalladioComponentModelDiagramUpdater
				.getVariableUsageVariableCharacterisation_7022SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result.add(((PalladioComponentModelNodeDescriptor) it.next())
					.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement())
					|| visualID != PalladioComponentModelVisualIDRegistry
							.getNodeVisualID((View) getHost().getModel(), view
									.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(ParameterPackage.eINSTANCE
					.getVariableUsage_VariableCharacterisation_VariableUsage());
		}
		return myFeaturesToSynchronize;
	}

}