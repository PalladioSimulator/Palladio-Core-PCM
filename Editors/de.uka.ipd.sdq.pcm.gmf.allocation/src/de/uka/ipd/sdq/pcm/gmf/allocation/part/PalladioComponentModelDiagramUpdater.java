/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
			return getResourceContainerAllocationCompartment_7003SemanticChildren(view);
		case AllocationEditPart.VISUAL_ID:
			return getAllocation_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainerAllocationCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ResourceContainer modelElement = (ResourceContainer) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = ((Allocation) modelElement).getAllocationContexts_Allocation()
				.iterator(); it.hasNext();) {
			AllocationContext childElement = (AllocationContext) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == AllocationContextEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated not
	 * 
	 * @param view a View
	 * @return the result
	 */
	public static List getResourceContainerAllocationCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ResourceContainer modelElement = (ResourceContainer) containerView
				.getElement();
		List result = new LinkedList();
		// Removed because of patched generator model
		// for (Iterator it = modelElement.getAllocationContexts_Allocation()
		// .iterator(); it.hasNext();) {
		// AllocationContext childElement = (AllocationContext) it.next();
		// int visualID = PalladioComponentModelVisualIDRegistry
		// .getNodeVisualID(view, childElement);
		// if (visualID == AllocationContextEditPart.VISUAL_ID) {
		// result.add(new PalladioComponentModelNodeDescriptor(
		// childElement, visualID));
		// continue;
		// }
		// }
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAllocation_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Allocation modelElement = (Allocation) view.getElement();
		List result = new LinkedList();
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator
				.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (PalladioComponentModelVisualIDRegistry.getNodeVisualID(view,
					childElement) == ResourceContainerEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, ResourceContainerEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case AllocationEditPart.VISUAL_ID:
			return getAllocation_1000ContainedLinks(view);
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003ContainedLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003IncomingLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003OutgoingLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAllocation_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAllocationContext_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAllocationContext_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResourceContainer_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAllocationContext_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
