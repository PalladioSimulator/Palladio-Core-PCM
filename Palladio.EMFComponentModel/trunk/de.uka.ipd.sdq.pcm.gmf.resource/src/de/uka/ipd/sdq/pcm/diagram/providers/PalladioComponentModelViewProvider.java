package de.uka.ipd.sdq.pcm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.diagram.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationMTTFEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationMTTREditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ProcessingResourceSpecificationSchedulingPolicyEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceContainerResourceContainerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.diagram.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.diagram.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.diagram.view.factories.CommunicationLinkResourceSpecificationViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.LinkingResourceViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ProcessingResourceSpecificationMTTFViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ProcessingResourceSpecificationMTTRViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ProcessingResourceSpecificationSchedulingPolicyViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ProcessingResourceSpecificationViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ResourceContainerEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ResourceContainerResourceContainerCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ResourceContainerViewFactory;
import de.uka.ipd.sdq.pcm.diagram.view.factories.ResourceEnvironmentViewFactory;

/**
 * @generated
 */
public class PalladioComponentModelViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (ResourceEnvironmentEditPart.MODEL_ID.equals(diagramKind)
				&& PalladioComponentModelVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return ResourceEnvironmentViewFactory.class;
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
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
					containerView, domainElement);
		} else {
			visualID = PalladioComponentModelVisualIDRegistry
					.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!PalladioComponentModelElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != PalladioComponentModelVisualIDRegistry
								.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!ResourceEnvironmentEditPart.MODEL_ID
						.equals(PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ResourceContainerEditPart.VISUAL_ID:
				case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
				case ProcessingResourceSpecificationEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != PalladioComponentModelVisualIDRegistry
									.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ResourceContainerEntityNameEditPart.VISUAL_ID:
				case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
					if (ResourceContainerEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
				case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
				case ProcessingResourceSpecificationSchedulingPolicyEditPart.VISUAL_ID:
				case ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart.VISUAL_ID:
					if (ProcessingResourceSpecificationEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
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
		if (containerView == null
				|| !PalladioComponentModelVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case ResourceContainerEditPart.VISUAL_ID:
			return ResourceContainerViewFactory.class;
		case ResourceContainerEntityNameEditPart.VISUAL_ID:
			return ResourceContainerEntityNameViewFactory.class;
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			return CommunicationLinkResourceSpecificationViewFactory.class;
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			return ProcessingResourceSpecificationViewFactory.class;
		case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
			return ProcessingResourceSpecificationMTTFViewFactory.class;
		case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
			return ProcessingResourceSpecificationMTTRViewFactory.class;
		case ProcessingResourceSpecificationSchedulingPolicyEditPart.VISUAL_ID:
			return ProcessingResourceSpecificationSchedulingPolicyViewFactory.class;
		case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
			return ResourceContainerResourceContainerCompartmentViewFactory.class;
		case ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart.VISUAL_ID:
			return ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
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
		int visualID = PalladioComponentModelVisualIDRegistry
				.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != PalladioComponentModelVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case LinkingResourceEditPart.VISUAL_ID:
			return LinkingResourceViewFactory.class;
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
