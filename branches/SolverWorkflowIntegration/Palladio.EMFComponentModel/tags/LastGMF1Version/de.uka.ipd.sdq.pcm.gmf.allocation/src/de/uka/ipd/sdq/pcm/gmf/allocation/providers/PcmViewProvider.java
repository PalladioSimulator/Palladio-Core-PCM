package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContext2EditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContext2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContextEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContextEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContextViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerAllocationCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerViewFactory;

/**
 * @generated
 */
public class PcmViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (AllocationEditPart.MODEL_ID.equals(diagramKind)
				&& PcmVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return AllocationViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !PcmElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = PcmVisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case ResourceContainerEditPart.VISUAL_ID:
			return ResourceContainerViewFactory.class;
		case ResourceContainerEntityNameEditPart.VISUAL_ID:
			return ResourceContainerEntityNameViewFactory.class;
		case AllocationContext2EditPart.VISUAL_ID:
			return AllocationContext2ViewFactory.class;
		case AllocationContextEntityName2EditPart.VISUAL_ID:
			return AllocationContextEntityName2ViewFactory.class;
		case AllocationContextEditPart.VISUAL_ID:
			return AllocationContextViewFactory.class;
		case AllocationContextEntityNameEditPart.VISUAL_ID:
			return AllocationContextEntityNameViewFactory.class;
		case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
			return ResourceContainerAllocationCompartmentViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !PcmElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = PcmVisualIDRegistry.getLinkWithClassVisualID(
				semanticElement, semanticType);
		switch (linkVID) {
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
