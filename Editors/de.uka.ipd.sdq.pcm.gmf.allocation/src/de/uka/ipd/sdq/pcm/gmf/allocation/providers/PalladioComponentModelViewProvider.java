/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationComponentLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContextEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationContextViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.AllocationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerAllocationCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.view.factories.ResourceContainerViewFactory;

/**
 * @generated
 */
public class PalladioComponentModelViewProvider extends AbstractViewProvider {

    /**
     * @generated
     */
    protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
        EObject semanticElement = getSemanticElement(semanticAdapter);
        if (AllocationEditPart.MODEL_ID.equals(diagramKind)
                && PalladioComponentModelVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
            return AllocationViewFactory.class;
        }
        return null;
    }

    /**
     * @generated
     */
    protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
        if (containerView == null) {
            return null;
        }
        IElementType elementType = getSemanticElementType(semanticAdapter);
        EObject domainElement = getSemanticElement(semanticAdapter);
        int visualID;
        if (semanticHint == null) {
            // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
            // In this situation there should be NO elementType, visualID will be determined
            // by VisualIDRegistry.getNodeVisualID() for domainElement.
            if (elementType != null || domainElement == null) {
                return null;
            }
            visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView, domainElement);
        } else {
            visualID = PalladioComponentModelVisualIDRegistry.getVisualID(semanticHint);
            if (elementType != null) {
                // Semantic hint is specified together with element type.
                // Both parameters should describe exactly the same diagram element.
                // In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID()
                // for
                // domainElement (if specified) is the same as in element type.
                if (!PalladioComponentModelElementTypes.isKnownElementType(elementType)
                        || (!(elementType instanceof IHintedType))) {
                    return null; // foreign element type
                }
                String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
                if (!semanticHint.equals(elementTypeHint)) {
                    return null; // if semantic hint is specified it should be the same as in
                                 // element type
                }
                if (domainElement != null
                        && visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView,
                                domainElement)) {
                    return null; // visual id for node EClass should match visual id from element
                                 // type
                }
            } else {
                // Element type is not specified. Domain element should be present (except pure
                // design elements).
                // This method is called with EObjectAdapter as parameter from:
                // - ViewService.createNode(View container, EObject eObject, String type,
                // PreferencesHint preferencesHint)
                // - generated ViewFactory.decorateView() for parent element
                if (!AllocationEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                        .getModelID(containerView))) {
                    return null; // foreign diagram
                }
                switch (visualID) {
                case ResourceContainerEditPart.VISUAL_ID:
                case AllocationContextEditPart.VISUAL_ID:
                    if (domainElement == null
                            || visualID != PalladioComponentModelVisualIDRegistry.getNodeVisualID(containerView,
                                    domainElement)) {
                        return null; // visual id in semantic hint should match visual id for domain
                                     // element
                    }
                    break;
                case ResourceContainerEntityNameEditPart.VISUAL_ID:
                case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
                    if (ResourceContainerEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                            .getVisualID(containerView) || containerView.getElement() != domainElement) {
                        return null; // wrong container
                    }
                    break;
                case AllocationContextEntityNameEditPart.VISUAL_ID:
                case AllocationComponentLabelEditPart.VISUAL_ID:
                    if (AllocationContextEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                            .getVisualID(containerView) || containerView.getElement() != domainElement) {
                        return null; // wrong container
                    }
                    break;
                default:
                    return null;
                }
            }
        }
        return getNodeViewClass(containerView, visualID);
    }

    /**
     * @generated
     */
    protected Class getNodeViewClass(View containerView, int visualID) {
        if (containerView == null || !PalladioComponentModelVisualIDRegistry.canCreateNode(containerView, visualID)) {
            return null;
        }
        switch (visualID) {
        case ResourceContainerEditPart.VISUAL_ID:
            return ResourceContainerViewFactory.class;
        case ResourceContainerEntityNameEditPart.VISUAL_ID:
            return ResourceContainerEntityNameViewFactory.class;
        case AllocationContextEditPart.VISUAL_ID:
            return AllocationContextViewFactory.class;
        case AllocationContextEntityNameEditPart.VISUAL_ID:
            return AllocationContextEntityNameViewFactory.class;
        case AllocationComponentLabelEditPart.VISUAL_ID:
            return AllocationComponentLabelViewFactory.class;
        case ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
            return ResourceContainerAllocationCompartmentViewFactory.class;
        }
        return null;
    }

    /**
     * @generated
     */
    protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
        IElementType elementType = getSemanticElementType(semanticAdapter);
        if (!PalladioComponentModelElementTypes.isKnownElementType(elementType)
                || (!(elementType instanceof IHintedType))) {
            return null; // foreign element type
        }
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        if (elementTypeHint == null) {
            return null; // our hint is visual id and must be specified
        }
        if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
            return null; // if semantic hint is specified it should be the same as in element type
        }
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(elementTypeHint);
        EObject domainElement = getSemanticElement(semanticAdapter);
        if (domainElement != null
                && visualID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
            return null; // visual id for link EClass should match visual id from element type
        }
        return getEdgeViewClass(visualID);
    }

    /**
     * @generated
     */
    protected Class getEdgeViewClass(int visualID) {
        switch (visualID) {
        }
        return null;
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

}
