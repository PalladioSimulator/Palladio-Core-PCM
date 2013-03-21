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
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case AllocationEditPart.VISUAL_ID:
			return getAllocation_1000SemanticChildren(view);
		case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
			return getResourceContainerAllocationCompartment_7003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated not
	 * 
     * @param view
     *            a view
     * @return the result
	 */
    public static List<PalladioComponentModelNodeDescriptor> getAllocation_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        Allocation modelElement = (Allocation) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();

        // manually introduced the following loop, adding ResourceContainers
        // from the actual ResourceEnvironment
        ResourceEnvironment re = modelElement.getTargetResourceEnvironment_Allocation();
        for (ResourceContainer c : re.getResourceContainer_ResourceEnvironment()) {
            result.add(new PalladioComponentModelNodeDescriptor(c, ResourceContainerEditPart.VISUAL_ID));
        }

        Resource resource = modelElement.eResource();
        for (Iterator<EObject> it = getPhantomNodesIterator(resource); it.hasNext();) {
            EObject childElement = it.next();
            if (childElement == modelElement) {
                continue;
            }
            if (PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement) == ResourceContainerEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, ResourceContainerEditPart.VISUAL_ID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated not
     * 
     * @param view
     *            a view
     * @return the result
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceContainerAllocationCompartment_7003SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }

        // We have to jump up twice the containment hierarchy to find Allocation.
        // But we still need to keep ResourceContainer to filter only those AllocationContexts that
        // belong into the given container.
        // ResourceContainer modelElement = (ResourceContainer) containerView.getElement();
        // LinkedList<PalladioComponentModelNodeDescriptor> result = new
        // LinkedList<PalladioComponentModelNodeDescriptor>();
        Allocation modelElement = (Allocation) ((View) containerView.eContainer()).getElement();
        ResourceContainer resourceContainer = (ResourceContainer) containerView.getElement();

        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getAllocationContexts_Allocation().iterator(); it.hasNext();) {
            AllocationContext childElement = (AllocationContext) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            // Added check to filter only those allocation contexts that belong into a given
            // resource container
            if (visualID == AllocationContextEditPart.VISUAL_ID /* > */
                    && childElement.getResourceContainer_AllocationContext() == resourceContainer /* < */) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }

        return result;
    }

	/**
	 * @generated
	 */
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case AllocationEditPart.VISUAL_ID:
			return getAllocation_1000ContainedLinks(view);
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003ContainedLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003IncomingLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ResourceContainerEditPart.VISUAL_ID:
			return getResourceContainer_2003OutgoingLinks(view);
		case AllocationContextEditPart.VISUAL_ID:
			return getAllocationContext_3002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getAllocation_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getAllocationContext_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getAllocationContext_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getResourceContainer_2003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PalladioComponentModelLinkDescriptor> getAllocationContext_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelNodeDescriptor> getSemanticChildren(
				View view) {
			return PalladioComponentModelDiagramUpdater
					.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getContainedLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getIncomingLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(
				View view) {
			return PalladioComponentModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
