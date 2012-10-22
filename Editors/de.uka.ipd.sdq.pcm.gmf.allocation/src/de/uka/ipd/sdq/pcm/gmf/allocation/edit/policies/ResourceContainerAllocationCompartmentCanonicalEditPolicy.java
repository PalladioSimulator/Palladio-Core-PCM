/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ResourceContainerAllocationCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated not
	 * 
	 * @return a List
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
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case AllocationContextEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
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
			myFeaturesToSynchronize.add(AllocationPackage.eINSTANCE
					.getAllocation_AllocationContexts_Allocation());
		}
		return myFeaturesToSynchronize;
	}

}
