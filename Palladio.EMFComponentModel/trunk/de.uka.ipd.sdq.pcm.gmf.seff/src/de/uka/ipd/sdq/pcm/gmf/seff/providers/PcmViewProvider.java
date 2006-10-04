/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchTransitionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchTransitionBranchConditionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionParametricParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionParametricParameterUsageSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionIterations2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionIterationsEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.PrimitiveParametricParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.PrimitiveParametricParameterUsageSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AbstractActionSuccessor_AbstractActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AbstractResourceDemandingActionResourceDemand_ActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchTransitionBehaviourCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchTransitionBranchConditionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchTransitionBranchProbabilityViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchTransitionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionParametricParameterUsageSpecificationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionParametricParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionParametricParameterUsage_ParametricParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionBehaviourCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionBehaviourCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionIterations2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionIterationsViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ParametricResourceDemandDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ParametricResourceDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.PrimitiveParametricParameterUsageSpecificationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.PrimitiveParametricParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopActionViewFactory;

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
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(diagramKind)
				&& PcmVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return ResourceDemandingSEFFViewFactory.class;
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
		case StartActionEditPart.VISUAL_ID:
			return StartActionViewFactory.class;
		case StopActionEditPart.VISUAL_ID:
			return StopActionViewFactory.class;
		case ExternalCallActionEditPart.VISUAL_ID:
			return ExternalCallActionViewFactory.class;
		case ExternalCallActionEntityNameEditPart.VISUAL_ID:
			return ExternalCallActionEntityNameViewFactory.class;
		case LoopActionEditPart.VISUAL_ID:
			return LoopActionViewFactory.class;
		case LoopActionEntityName2EditPart.VISUAL_ID:
			return LoopActionEntityName2ViewFactory.class;
		case LoopActionIterations2EditPart.VISUAL_ID:
			return LoopActionIterations2ViewFactory.class;
		case BranchAction2EditPart.VISUAL_ID:
			return BranchAction2ViewFactory.class;
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return BranchActionEntityName2ViewFactory.class;
		case InternalAction2EditPart.VISUAL_ID:
			return InternalAction2ViewFactory.class;
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return InternalActionEntityName2ViewFactory.class;
		case PrimitiveParametricParameterUsageEditPart.VISUAL_ID:
			return PrimitiveParametricParameterUsageViewFactory.class;
		case PrimitiveParametricParameterUsageSpecificationEditPart.VISUAL_ID:
			return PrimitiveParametricParameterUsageSpecificationViewFactory.class;
		case CollectionParametricParameterUsageEditPart.VISUAL_ID:
			return CollectionParametricParameterUsageViewFactory.class;
		case CollectionParametricParameterUsageSpecificationEditPart.VISUAL_ID:
			return CollectionParametricParameterUsageSpecificationViewFactory.class;
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return ParametricResourceDemandViewFactory.class;
		case ParametricResourceDemandDemandEditPart.VISUAL_ID:
			return ParametricResourceDemandDemandViewFactory.class;
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourViewFactory.class;
		case StartAction2EditPart.VISUAL_ID:
			return StartAction2ViewFactory.class;
		case StopAction2EditPart.VISUAL_ID:
			return StopAction2ViewFactory.class;
		case LoopAction2EditPart.VISUAL_ID:
			return LoopAction2ViewFactory.class;
		case LoopActionEntityNameEditPart.VISUAL_ID:
			return LoopActionEntityNameViewFactory.class;
		case LoopActionIterationsEditPart.VISUAL_ID:
			return LoopActionIterationsViewFactory.class;
		case InternalActionEditPart.VISUAL_ID:
			return InternalActionViewFactory.class;
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return InternalActionEntityNameViewFactory.class;
		case BranchActionEditPart.VISUAL_ID:
			return BranchActionViewFactory.class;
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return BranchActionEntityNameViewFactory.class;
		case BranchTransitionEditPart.VISUAL_ID:
			return BranchTransitionViewFactory.class;
		case BranchTransitionBranchConditionEditPart.VISUAL_ID:
			return BranchTransitionBranchConditionViewFactory.class;
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour2ViewFactory.class;
		case ExternalCallAction2EditPart.VISUAL_ID:
			return ExternalCallAction2ViewFactory.class;
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return ExternalCallActionEntityName2ViewFactory.class;
		case LoopActionBehaviourCompartmentEditPart.VISUAL_ID:
			return LoopActionBehaviourCompartmentViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartmentViewFactory.class;
		case LoopActionBehaviourCompartment2EditPart.VISUAL_ID:
			return LoopActionBehaviourCompartment2ViewFactory.class;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartmentViewFactory.class;
		case BranchTransitionBehaviourCompartmentEditPart.VISUAL_ID:
			return BranchTransitionBehaviourCompartmentViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartmentViewFactory.class;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartment2ViewFactory.class;
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
		if (PcmElementTypes.AbstractActionSuccessor_AbstractAction_3001
				.equals(elementType)) {
			return AbstractActionSuccessor_AbstractActionViewFactory.class;
		}
		if (PcmElementTypes.ExternalCallActionParametricParameterUsage_ParametricParameterUsage_3002
				.equals(elementType)) {
			return ExternalCallActionParametricParameterUsage_ParametricParameterUsageViewFactory.class;
		}
		if (PcmElementTypes.AbstractResourceDemandingActionResourceDemand_Action_3003
				.equals(elementType)) {
			return AbstractResourceDemandingActionResourceDemand_ActionViewFactory.class;
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
