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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AquireActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorParameterLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorParameterLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionIdEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AbstractActionSuccessor_AbstractActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AquireAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AquireActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AquireActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AquireActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorParameterLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.CollectionIteratorParameterLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionParameterUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.GuardedBranchTransitionIdViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.GuardedBranchTransitionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionResourceDemand2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionResourceDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopIterationsLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopIterationsLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ParametricResourceDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ProbabilisticBranchTransitionBranchProbabilityViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ProbabilisticBranchTransitionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ReleaseAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ReleaseActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ReleaseActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ReleaseActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour4ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisation2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageReferenceLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageReferenceLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisation2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageViewFactory;

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
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(diagramKind)
				&& PalladioComponentModelVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
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
				&& !PalladioComponentModelElementTypes
						.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
				containerView, semanticElement, semanticType, semanticHint);
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
		case LoopIterationsLabel2EditPart.VISUAL_ID:
			return LoopIterationsLabel2ViewFactory.class;
		case BranchAction2EditPart.VISUAL_ID:
			return BranchAction2ViewFactory.class;
		case BranchActionEntityName2EditPart.VISUAL_ID:
			return BranchActionEntityName2ViewFactory.class;
		case InternalAction2EditPart.VISUAL_ID:
			return InternalAction2ViewFactory.class;
		case InternalActionEntityName2EditPart.VISUAL_ID:
			return InternalActionEntityName2ViewFactory.class;
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			return CollectionIteratorAction2ViewFactory.class;
		case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
			return CollectionIteratorActionEntityName2ViewFactory.class;
		case CollectionIteratorParameterLabel2EditPart.VISUAL_ID:
			return CollectionIteratorParameterLabel2ViewFactory.class;
		case SetVariableActionEditPart.VISUAL_ID:
			return SetVariableActionViewFactory.class;
		case AquireAction2EditPart.VISUAL_ID:
			return AquireAction2ViewFactory.class;
		case AquireActionEntityName2EditPart.VISUAL_ID:
			return AquireActionEntityName2ViewFactory.class;
		case ReleaseAction2EditPart.VISUAL_ID:
			return ReleaseAction2ViewFactory.class;
		case ReleaseActionEntityName2EditPart.VISUAL_ID:
			return ReleaseActionEntityName2ViewFactory.class;
		case VariableUsageEditPart.VISUAL_ID:
			return VariableUsageViewFactory.class;
		case VariableUsageReferenceLabelEditPart.VISUAL_ID:
			return VariableUsageReferenceLabelViewFactory.class;
		case VariableCharacterisationEditPart.VISUAL_ID:
			return VariableCharacterisationViewFactory.class;
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
		case LoopIterationsLabelEditPart.VISUAL_ID:
			return LoopIterationsLabelViewFactory.class;
		case InternalActionEditPart.VISUAL_ID:
			return InternalActionViewFactory.class;
		case InternalActionEntityNameEditPart.VISUAL_ID:
			return InternalActionEntityNameViewFactory.class;
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return ParametricResourceDemandViewFactory.class;
		case BranchActionEditPart.VISUAL_ID:
			return BranchActionViewFactory.class;
		case BranchActionEntityNameEditPart.VISUAL_ID:
			return BranchActionEntityNameViewFactory.class;
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			return ProbabilisticBranchTransitionViewFactory.class;
		case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return ProbabilisticBranchTransitionBranchProbabilityViewFactory.class;
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour2ViewFactory.class;
		case ExternalCallAction2EditPart.VISUAL_ID:
			return ExternalCallAction2ViewFactory.class;
		case ExternalCallActionEntityName2EditPart.VISUAL_ID:
			return ExternalCallActionEntityName2ViewFactory.class;
		case AquireActionEditPart.VISUAL_ID:
			return AquireActionViewFactory.class;
		case AquireActionEntityNameEditPart.VISUAL_ID:
			return AquireActionEntityNameViewFactory.class;
		case ReleaseActionEditPart.VISUAL_ID:
			return ReleaseActionViewFactory.class;
		case ReleaseActionEntityNameEditPart.VISUAL_ID:
			return ReleaseActionEntityNameViewFactory.class;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			return GuardedBranchTransitionViewFactory.class;
		case GuardedBranchTransitionIdEditPart.VISUAL_ID:
			return GuardedBranchTransitionIdViewFactory.class;
		case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour3ViewFactory.class;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			return CollectionIteratorActionViewFactory.class;
		case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
			return CollectionIteratorActionEntityNameViewFactory.class;
		case CollectionIteratorParameterLabelEditPart.VISUAL_ID:
			return CollectionIteratorParameterLabelViewFactory.class;
		case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour4ViewFactory.class;
		case VariableUsage2EditPart.VISUAL_ID:
			return VariableUsage2ViewFactory.class;
		case VariableUsageReferenceLabel2EditPart.VISUAL_ID:
			return VariableUsageReferenceLabel2ViewFactory.class;
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return VariableCharacterisation2ViewFactory.class;
		case ExternalCallActionParameterUsageEditPart.VISUAL_ID:
			return ExternalCallActionParameterUsageViewFactory.class;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisationViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartmentViewFactory.class;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			return InternalActionResourceDemandViewFactory.class;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartmentViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartmentViewFactory.class;
		case ExternalCallActionParameterUsage2EditPart.VISUAL_ID:
			return ExternalCallActionParameterUsage2ViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartment2ViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartment2ViewFactory.class;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartment2ViewFactory.class;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			return InternalActionResourceDemand2ViewFactory.class;
		case SetVariableActionParameterUsageEditPart.VISUAL_ID:
			return SetVariableActionParameterUsageViewFactory.class;
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisation2ViewFactory.class;
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
		if (PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001
				.equals(elementType)) {
			return AbstractActionSuccessor_AbstractActionViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = PalladioComponentModelVisualIDRegistry
				.getLinkWithClassVisualID(semanticElement, semanticType);
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
