/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityNameEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBranchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourLoopCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetter2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetterEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AbstractActionSuccessor_AbstractActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AcquireAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AcquireActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AcquireActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.AcquireActionViewFactory;
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
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionInputVariableUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionInputVariableUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionOutputVariableUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionOutputVariableUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ExternalCallActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkActionForkedBehaviours2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkActionForkedBehavioursViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkedBehaviourBehaviourCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ForkedBehaviourViewFactory;
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
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour4ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviour5ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourBranchCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourLoopCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingBehaviourViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.ResourceDemandingSEFFViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionEntityName2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionEntityNameViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionVariableSetter2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionVariableSetterViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.SetVariableActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StartActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopAction2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.StopActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisation2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisation3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsage2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsage3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisation2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisation3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageVariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.VariableUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.WrappingLabel2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.WrappingLabel3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.view.factories.WrappingLabelViewFactory;

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
				if (!ResourceDemandingSEFFEditPart.MODEL_ID
						.equals(PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case StartActionEditPart.VISUAL_ID:
				case StopActionEditPart.VISUAL_ID:
				case ExternalCallActionEditPart.VISUAL_ID:
				case LoopActionEditPart.VISUAL_ID:
				case VariableUsageEditPart.VISUAL_ID:
				case VariableCharacterisationEditPart.VISUAL_ID:
				case ResourceDemandingBehaviourEditPart.VISUAL_ID:
				case InternalActionEditPart.VISUAL_ID:
				case ParametricResourceDemandEditPart.VISUAL_ID:
				case BranchActionEditPart.VISUAL_ID:
				case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
				case AcquireAction2EditPart.VISUAL_ID:
				case ReleaseActionEditPart.VISUAL_ID:
				case ForkActionEditPart.VISUAL_ID:
				case ForkedBehaviourEditPart.VISUAL_ID:
				case CollectionIteratorActionEditPart.VISUAL_ID:
				case SetVariableActionEditPart.VISUAL_ID:
				case GuardedBranchTransitionEditPart.VISUAL_ID:
				case BranchAction2EditPart.VISUAL_ID:
				case InternalAction2EditPart.VISUAL_ID:
				case CollectionIteratorAction2EditPart.VISUAL_ID:
				case SetVariableAction2EditPart.VISUAL_ID:
				case AcquireActionEditPart.VISUAL_ID:
				case ReleaseAction2EditPart.VISUAL_ID:
				case ForkAction2EditPart.VISUAL_ID:
				case VariableUsage2EditPart.VISUAL_ID:
				case VariableCharacterisation2EditPart.VISUAL_ID:
				case StartAction2EditPart.VISUAL_ID:
				case StopAction2EditPart.VISUAL_ID:
				case LoopAction2EditPart.VISUAL_ID:
				case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
				case ExternalCallAction2EditPart.VISUAL_ID:
				case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
				case VariableUsage3EditPart.VISUAL_ID:
				case VariableCharacterisation3EditPart.VISUAL_ID:
				case ResourceDemandingBehaviour5EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != PalladioComponentModelVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ExternalCallActionEntityNameEditPart.VISUAL_ID:
				case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
				case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
					if (ExternalCallActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case LoopActionEntityName2EditPart.VISUAL_ID:
				case LoopIterationsLabel2EditPart.VISUAL_ID:
					if (LoopActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case BranchActionEntityName2EditPart.VISUAL_ID:
				case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
					if (BranchAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InternalActionEntityName2EditPart.VISUAL_ID:
				case InternalActionResourceDemand2EditPart.VISUAL_ID:
					if (InternalAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
				case CollectionIteratorParameterLabel2EditPart.VISUAL_ID:
					if (CollectionIteratorAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SetVariableActionEntityName2EditPart.VISUAL_ID:
				case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
					if (SetVariableAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AcquireActionEntityNameEditPart.VISUAL_ID:
					if (AcquireActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ReleaseActionEntityName2EditPart.VISUAL_ID:
					if (ReleaseAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ForkActionEntityName2EditPart.VISUAL_ID:
				case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
					if (ForkAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabelEditPart.VISUAL_ID:
				case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
					if (VariableUsageEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabel2EditPart.VISUAL_ID:
				case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
					if (VariableUsage2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
					if (ResourceDemandingBehaviourEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case LoopActionEntityNameEditPart.VISUAL_ID:
				case LoopIterationsLabelEditPart.VISUAL_ID:
					if (LoopAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InternalActionEntityNameEditPart.VISUAL_ID:
				case InternalActionResourceDemandEditPart.VISUAL_ID:
					if (InternalActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case BranchActionEntityNameEditPart.VISUAL_ID:
				case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
					if (BranchActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
					if (ProbabilisticBranchTransitionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
					if (ResourceDemandingBehaviour2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ExternalCallActionEntityName2EditPart.VISUAL_ID:
				case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
				case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
					if (ExternalCallAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AcquireActionEntityName2EditPart.VISUAL_ID:
					if (AcquireAction2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ReleaseActionEntityNameEditPart.VISUAL_ID:
					if (ReleaseActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ForkActionEntityNameEditPart.VISUAL_ID:
				case ForkActionForkedBehavioursEditPart.VISUAL_ID:
					if (ForkActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
					if (ForkedBehaviourEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
				case CollectionIteratorParameterLabelEditPart.VISUAL_ID:
					if (CollectionIteratorActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
					if (ResourceDemandingBehaviour4EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SetVariableActionEntityNameEditPart.VISUAL_ID:
				case SetVariableActionVariableSetterEditPart.VISUAL_ID:
					if (SetVariableActionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabel3EditPart.VISUAL_ID:
				case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
					if (VariableUsage3EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case GuardedBranchTransitionIdEditPart.VISUAL_ID:
					if (GuardedBranchTransitionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
					if (ResourceDemandingBehaviour5EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
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
		case SetVariableAction2EditPart.VISUAL_ID:
			return SetVariableAction2ViewFactory.class;
		case SetVariableActionEntityName2EditPart.VISUAL_ID:
			return SetVariableActionEntityName2ViewFactory.class;
		case AcquireActionEditPart.VISUAL_ID:
			return AcquireActionViewFactory.class;
		case AcquireActionEntityNameEditPart.VISUAL_ID:
			return AcquireActionEntityNameViewFactory.class;
		case ReleaseAction2EditPart.VISUAL_ID:
			return ReleaseAction2ViewFactory.class;
		case ReleaseActionEntityName2EditPart.VISUAL_ID:
			return ReleaseActionEntityName2ViewFactory.class;
		case ForkAction2EditPart.VISUAL_ID:
			return ForkAction2ViewFactory.class;
		case ForkActionEntityName2EditPart.VISUAL_ID:
			return ForkActionEntityName2ViewFactory.class;
		case VariableUsageEditPart.VISUAL_ID:
			return VariableUsageViewFactory.class;
		case WrappingLabelEditPart.VISUAL_ID:
			return WrappingLabelViewFactory.class;
		case VariableCharacterisationEditPart.VISUAL_ID:
			return VariableCharacterisationViewFactory.class;
		case VariableUsage2EditPart.VISUAL_ID:
			return VariableUsage2ViewFactory.class;
		case WrappingLabel2EditPart.VISUAL_ID:
			return WrappingLabel2ViewFactory.class;
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return VariableCharacterisation2ViewFactory.class;
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
		case AcquireAction2EditPart.VISUAL_ID:
			return AcquireAction2ViewFactory.class;
		case AcquireActionEntityName2EditPart.VISUAL_ID:
			return AcquireActionEntityName2ViewFactory.class;
		case ReleaseActionEditPart.VISUAL_ID:
			return ReleaseActionViewFactory.class;
		case ReleaseActionEntityNameEditPart.VISUAL_ID:
			return ReleaseActionEntityNameViewFactory.class;
		case ForkActionEditPart.VISUAL_ID:
			return ForkActionViewFactory.class;
		case ForkActionEntityNameEditPart.VISUAL_ID:
			return ForkActionEntityNameViewFactory.class;
		case ForkedBehaviourEditPart.VISUAL_ID:
			return ForkedBehaviourViewFactory.class;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			return CollectionIteratorActionViewFactory.class;
		case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
			return CollectionIteratorActionEntityNameViewFactory.class;
		case CollectionIteratorParameterLabelEditPart.VISUAL_ID:
			return CollectionIteratorParameterLabelViewFactory.class;
		case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour4ViewFactory.class;
		case SetVariableActionEditPart.VISUAL_ID:
			return SetVariableActionViewFactory.class;
		case SetVariableActionEntityNameEditPart.VISUAL_ID:
			return SetVariableActionEntityNameViewFactory.class;
		case VariableUsage3EditPart.VISUAL_ID:
			return VariableUsage3ViewFactory.class;
		case WrappingLabel3EditPart.VISUAL_ID:
			return WrappingLabel3ViewFactory.class;
		case VariableCharacterisation3EditPart.VISUAL_ID:
			return VariableCharacterisation3ViewFactory.class;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			return GuardedBranchTransitionViewFactory.class;
		case GuardedBranchTransitionIdEditPart.VISUAL_ID:
			return GuardedBranchTransitionIdViewFactory.class;
		case ResourceDemandingBehaviour5EditPart.VISUAL_ID:
			return ResourceDemandingBehaviour5ViewFactory.class;
		case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
			return ExternalCallActionInputVariableUsageViewFactory.class;
		case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
			return ExternalCallActionOutputVariableUsageViewFactory.class;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisationViewFactory.class;
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisation2ViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartmentViewFactory.class;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			return InternalActionResourceDemandViewFactory.class;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartmentViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartmentViewFactory.class;
		case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
			return ExternalCallActionInputVariableUsage2ViewFactory.class;
		case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
			return ExternalCallActionOutputVariableUsage2ViewFactory.class;
		case ForkActionForkedBehavioursEditPart.VISUAL_ID:
			return ForkActionForkedBehavioursViewFactory.class;
		case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			return ForkedBehaviourBehaviourCompartmentViewFactory.class;
		case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviourLoopCompartment2ViewFactory.class;
		case SetVariableActionVariableSetterEditPart.VISUAL_ID:
			return SetVariableActionVariableSetterViewFactory.class;
		case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisation3ViewFactory.class;
		case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
			return ResourceDemandingBehaviourBranchCompartment2ViewFactory.class;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			return BranchActionBranchTransitionCompartment2ViewFactory.class;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			return InternalActionResourceDemand2ViewFactory.class;
		case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
			return SetVariableActionVariableSetter2ViewFactory.class;
		case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
			return ForkActionForkedBehaviours2ViewFactory.class;
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
		case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
			return AbstractActionSuccessor_AbstractActionViewFactory.class;
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
