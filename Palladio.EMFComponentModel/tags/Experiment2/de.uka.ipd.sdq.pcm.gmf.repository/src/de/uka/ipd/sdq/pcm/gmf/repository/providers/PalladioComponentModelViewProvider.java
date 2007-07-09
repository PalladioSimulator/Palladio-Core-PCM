/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteParentStereotypeLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteParentStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesParentStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiresStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentSEFFCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteComponentTypeEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteComponentTypeParentProvidesComponentTypesViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteComponentTypeViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteParentStereotypeLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteParentStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompositeComponentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ImplementationComponentTypeParentCompleteComponentTypesViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceSignatureListViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidedRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesComponentTypeEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesComponentTypeViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesParentStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RepositoryViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RequiredRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RequiresStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.SignatureViewFactory;

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
		if (RepositoryEditPart.MODEL_ID.equals(diagramKind)
				&& PalladioComponentModelVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return RepositoryViewFactory.class;
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
				if (!PalladioComponentModelElementTypes
						.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
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
				if (!RepositoryEditPart.MODEL_ID
						.equals(PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case InterfaceEditPart.VISUAL_ID:
				case BasicComponentEditPart.VISUAL_ID:
				case CompleteComponentTypeEditPart.VISUAL_ID:
				case ProvidesComponentTypeEditPart.VISUAL_ID:
				case CompositeComponentEditPart.VISUAL_ID:
				case SignatureEditPart.VISUAL_ID:
				case ResourceDemandingSEFFEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != PalladioComponentModelVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case InterfaceEntityNameEditPart.VISUAL_ID:
				case InterfaceSignatureListEditPart.VISUAL_ID:
					if (InterfaceEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case BasicComponentEntityNameEditPart.VISUAL_ID:
				case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
					if (BasicComponentEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
					if (CompleteComponentTypeEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
					if (ProvidesComponentTypeEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ProvidesStereotypeLabelEditPart.VISUAL_ID:
					if (ProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RequiresStereotypeLabelEditPart.VISUAL_ID:
					if (RequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CompleteParentStereotypeLabelEditPart.VISUAL_ID:
					if (ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ProvidesParentStereotypeLabelEditPart.VISUAL_ID:
					if (CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
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
				|| !PalladioComponentModelVisualIDRegistry.canCreateNode(
						containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case InterfaceEditPart.VISUAL_ID:
			return InterfaceViewFactory.class;
		case InterfaceEntityNameEditPart.VISUAL_ID:
			return InterfaceEntityNameViewFactory.class;
		case BasicComponentEditPart.VISUAL_ID:
			return BasicComponentViewFactory.class;
		case BasicComponentEntityNameEditPart.VISUAL_ID:
			return BasicComponentEntityNameViewFactory.class;
		case CompleteComponentTypeEditPart.VISUAL_ID:
			return CompleteComponentTypeViewFactory.class;
		case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
			return CompleteComponentTypeEntityNameViewFactory.class;
		case ProvidesComponentTypeEditPart.VISUAL_ID:
			return ProvidesComponentTypeViewFactory.class;
		case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
			return ProvidesComponentTypeEntityNameViewFactory.class;
		case CompositeComponentEditPart.VISUAL_ID:
			return CompositeComponentViewFactory.class;
		case SignatureEditPart.VISUAL_ID:
			return SignatureViewFactory.class;
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			return ResourceDemandingSEFFViewFactory.class;
		case InterfaceSignatureListEditPart.VISUAL_ID:
			return InterfaceSignatureListViewFactory.class;
		case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
			return BasicComponentSEFFCompartmentViewFactory.class;
		case ProvidesStereotypeLabelEditPart.VISUAL_ID:
			return ProvidesStereotypeLabelViewFactory.class;
		case RequiresStereotypeLabelEditPart.VISUAL_ID:
			return RequiresStereotypeLabelViewFactory.class;
		case CompleteParentStereotypeLabelEditPart.VISUAL_ID:
			return CompleteParentStereotypeLabelViewFactory.class;
		case ProvidesParentStereotypeLabelEditPart.VISUAL_ID:
			return ProvidesParentStereotypeLabelViewFactory.class;
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
		case ProvidedRoleEditPart.VISUAL_ID:
			return ProvidedRoleViewFactory.class;
		case RequiredRoleEditPart.VISUAL_ID:
			return RequiredRoleViewFactory.class;
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return ImplementationComponentTypeParentCompleteComponentTypesViewFactory.class;
		case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
			return CompleteComponentTypeParentProvidesComponentTypesViewFactory.class;
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
