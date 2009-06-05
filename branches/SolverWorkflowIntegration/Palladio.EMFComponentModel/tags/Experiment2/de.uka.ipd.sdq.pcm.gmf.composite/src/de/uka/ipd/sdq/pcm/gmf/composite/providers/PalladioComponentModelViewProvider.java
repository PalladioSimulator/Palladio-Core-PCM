/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEntityNameEditPart;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.AssemblyConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.AssemblyContextEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.AssemblyContextViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ComposedProvidingRequiringEntity2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ComposedProvidingRequiringEntityEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ComposedProvidingRequiringEntityViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ProvidedDelegationConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ProvidedRole2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ProvidedRoleEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ProvidedRoleEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.ProvidedRoleViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.RequiredDelegationConnectorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.RequiredRole2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.RequiredRoleEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.RequiredRoleEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.view.factories.RequiredRoleViewFactory;

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
		if (ComposedProvidingRequiringEntityEditPart.MODEL_ID
				.equals(diagramKind)
				&& PalladioComponentModelVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return ComposedProvidingRequiringEntityViewFactory.class;
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
				&& !PalladioComponentModelElementTypes
						.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
				containerView, semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			return ComposedProvidingRequiringEntity2ViewFactory.class;
		case ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID:
			return ComposedProvidingRequiringEntityEntityNameViewFactory.class;
		case AssemblyContextEditPart.VISUAL_ID:
			return AssemblyContextViewFactory.class;
		case AssemblyContextEntityNameEditPart.VISUAL_ID:
			return AssemblyContextEntityNameViewFactory.class;
		case ProvidedRoleEditPart.VISUAL_ID:
			return ProvidedRoleViewFactory.class;
		case ProvidedRoleEntityNameEditPart.VISUAL_ID:
			return ProvidedRoleEntityNameViewFactory.class;
		case RequiredRoleEditPart.VISUAL_ID:
			return RequiredRoleViewFactory.class;
		case RequiredRoleEntityNameEditPart.VISUAL_ID:
			return RequiredRoleEntityNameViewFactory.class;
		case ProvidedRole2EditPart.VISUAL_ID:
			return ProvidedRole2ViewFactory.class;
		case ProvidedRoleEntityName2EditPart.VISUAL_ID:
			return ProvidedRoleEntityName2ViewFactory.class;
		case RequiredRole2EditPart.VISUAL_ID:
			return RequiredRole2ViewFactory.class;
		case RequiredRoleEntityName2EditPart.VISUAL_ID:
			return RequiredRoleEntityName2ViewFactory.class;
		case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
			return ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentViewFactory.class;
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
				&& !PalladioComponentModelElementTypes
						.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = PalladioComponentModelVisualIDRegistry
				.getLinkWithClassVisualID(semanticElement, semanticType);
		switch (linkVID) {
		case AssemblyConnectorEditPart.VISUAL_ID:
			return AssemblyConnectorViewFactory.class;
		case RequiredDelegationConnectorEditPart.VISUAL_ID:
			return RequiredDelegationConnectorViewFactory.class;
		case ProvidedDelegationConnectorEditPart.VISUAL_ID:
			return ProvidedDelegationConnectorViewFactory.class;
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
