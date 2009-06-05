/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * @generated
 */
public class InterfaceSignatureListCanonicalEditPolicy extends
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
				.getInterfaceSignatureList_7101SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
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
		case SignatureEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(RepositoryPackage.eINSTANCE
					.getInterface_Signatures__Interface());
		}
		return myFeaturesToSynchronize;
	}

}
