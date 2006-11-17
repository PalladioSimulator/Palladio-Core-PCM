/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiresStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentSEFFCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.BasicComponentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteComponentTypeEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompleteComponentTypeViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.CompositeComponentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceSignatureListViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.InterfaceViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidedRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesComponentTypeEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesComponentTypeViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ProvidesStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RepositoryViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RequiredRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.RequiresStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.view.factories.SignatureViewFactory;

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
		if (RepositoryEditPart.MODEL_ID.equals(diagramKind)
				&& PcmVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
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
		if (elementType != null
				&& !PcmElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = PcmVisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
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
		case ProvidedRoleEditPart.VISUAL_ID:
			return ProvidedRoleViewFactory.class;
		case RequiredRoleEditPart.VISUAL_ID:
			return RequiredRoleViewFactory.class;
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
