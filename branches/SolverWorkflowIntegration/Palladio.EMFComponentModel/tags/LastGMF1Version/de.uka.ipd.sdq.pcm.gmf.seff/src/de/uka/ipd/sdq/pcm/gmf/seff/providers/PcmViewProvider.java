/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AbstractActionSuccessor_AbstractActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionBranchTransitionCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.BranchActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionParameterUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionResourceDemand2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionResourceDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.InternalActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionBehaviourCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionBehaviourCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopIterationsLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.LoopIterationsLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ParametricResourceDemandViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ProbabilisticBranchTransitionBehaviourCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ProbabilisticBranchTransitionBranchProbabilityViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ProbabilisticBranchTransitionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageReferenceLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageViewFactory;

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
		case ExternalCallActionParameterUsageEditPart.VISUAL_ID:
			return ExternalCallActionParameterUsageViewFactory.class;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisationViewFactory.class;
		case LoopActionBehaviourCompartmentEditPart.VISUAL_ID:
			return LoopActionBehaviourCompartmentViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartmentViewFactory.class;
		case LoopActionBehaviourCompartment2EditPart.VISUAL_ID:
			return LoopActionBehaviourCompartment2ViewFactory.class;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			return InternalActionResourceDemandViewFactory.class;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartmentViewFactory.class;
		case ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID:
			return ProbabilisticBranchTransitionBehaviourCompartmentViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartmentViewFactory.class;
		case ExternalCallActionParameterUsage2EditPart.VISUAL_ID:
			return ExternalCallActionParameterUsage2ViewFactory.class;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartment2ViewFactory.class;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			return InternalActionResourceDemand2ViewFactory.class;
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
