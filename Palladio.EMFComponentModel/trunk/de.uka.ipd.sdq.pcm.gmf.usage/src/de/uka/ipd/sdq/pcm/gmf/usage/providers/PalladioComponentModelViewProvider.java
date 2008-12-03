/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadSpecLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourId3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourIdEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageBranchStereotypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrapLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.AbstractUserActionSuccessorViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.AbstractUserActionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.BranchTransitionBranchProbabilityViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.BranchTransitionViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.BranchUsageBranchTransitionsCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.BranchViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ClosedWorkloadPopulationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ClosedWorkloadThinkTimeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ClosedWorkloadTitleLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ClosedWorkloadViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ComponentExternalCallNameLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.EntryLevelSystemCallParameterUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.EntryLevelSystemCallViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.LoopViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.OpenWorkloadSpecLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.OpenWorkloadViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviour2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviour3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourId2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourId3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourIdViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourScenarioBehaviourStepsCompartment2ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourScenarioBehaviourStepsCompartment3ViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourScenarioBehaviourStepsCompartmentViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.ScenarioBehaviourViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.StartViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.StopViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.UsageBranchStereotypeLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.UsageLoopIterationsLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.UsageScenarioViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.VariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.VariableUsageReferenceLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.VariableUsageVariableCharacterisationViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.VariableUsageViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.WrapLabelViewFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.view.factories.WrappingLabelViewFactory;

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
		if (UsageScenarioEditPart.MODEL_ID.equals(diagramKind)
				&& PalladioComponentModelVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return UsageScenarioViewFactory.class;
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
				if (!UsageScenarioEditPart.MODEL_ID
						.equals(PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ScenarioBehaviourEditPart.VISUAL_ID:
				case ClosedWorkloadEditPart.VISUAL_ID:
				case OpenWorkloadEditPart.VISUAL_ID:
				case StartEditPart.VISUAL_ID:
				case StopEditPart.VISUAL_ID:
				case EntryLevelSystemCallEditPart.VISUAL_ID:
				case VariableUsageEditPart.VISUAL_ID:
				case VariableCharacterisationEditPart.VISUAL_ID:
				case LoopEditPart.VISUAL_ID:
				case BranchEditPart.VISUAL_ID:
				case BranchTransitionEditPart.VISUAL_ID:
				case ScenarioBehaviour2EditPart.VISUAL_ID:
				case ScenarioBehaviour3EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != PalladioComponentModelVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
					if (ScenarioBehaviourEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
				case ClosedWorkloadPopulationEditPart.VISUAL_ID:
				case ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID:
					if (ClosedWorkloadEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OpenWorkloadSpecLabelEditPart.VISUAL_ID:
					if (OpenWorkloadEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ComponentExternalCallNameLabelEditPart.VISUAL_ID:
				case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
					if (EntryLevelSystemCallEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
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
				case UsageLoopIterationsLabelEditPart.VISUAL_ID:
					if (LoopEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
					if (ScenarioBehaviour2EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UsageBranchStereotypeLabelEditPart.VISUAL_ID:
				case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
					if (BranchEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
					if (BranchTransitionEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
					if (ScenarioBehaviour3EditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
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
		case ScenarioBehaviourEditPart.VISUAL_ID:
			return ScenarioBehaviourViewFactory.class;
		case ClosedWorkloadEditPart.VISUAL_ID:
			return ClosedWorkloadViewFactory.class;
		case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
			return ClosedWorkloadTitleLabelViewFactory.class;
		case ClosedWorkloadPopulationEditPart.VISUAL_ID:
			return ClosedWorkloadPopulationViewFactory.class;
		case ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID:
			return ClosedWorkloadThinkTimeLabelViewFactory.class;
		case OpenWorkloadEditPart.VISUAL_ID:
			return OpenWorkloadViewFactory.class;
		case OpenWorkloadSpecLabelEditPart.VISUAL_ID:
			return OpenWorkloadSpecLabelViewFactory.class;
		case StartEditPart.VISUAL_ID:
			return StartViewFactory.class;
		case StopEditPart.VISUAL_ID:
			return StopViewFactory.class;
		case EntryLevelSystemCallEditPart.VISUAL_ID:
			return EntryLevelSystemCallViewFactory.class;
		case ComponentExternalCallNameLabelEditPart.VISUAL_ID:
			return ComponentExternalCallNameLabelViewFactory.class;
		case VariableUsageEditPart.VISUAL_ID:
			return VariableUsageViewFactory.class;
		case WrappingLabelEditPart.VISUAL_ID:
			return WrappingLabelViewFactory.class;
		case VariableCharacterisationEditPart.VISUAL_ID:
			return VariableCharacterisationViewFactory.class;
		case LoopEditPart.VISUAL_ID:
			return LoopViewFactory.class;
		case UsageLoopIterationsLabelEditPart.VISUAL_ID:
			return UsageLoopIterationsLabelViewFactory.class;
		case ScenarioBehaviour2EditPart.VISUAL_ID:
			return ScenarioBehaviour2ViewFactory.class;
		case BranchEditPart.VISUAL_ID:
			return BranchViewFactory.class;
		case UsageBranchStereotypeLabelEditPart.VISUAL_ID:
			return UsageBranchStereotypeLabelViewFactory.class;
		case BranchTransitionEditPart.VISUAL_ID:
			return BranchTransitionViewFactory.class;
		case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
			return BranchTransitionBranchProbabilityViewFactory.class;
		case ScenarioBehaviour3EditPart.VISUAL_ID:
			return ScenarioBehaviour3ViewFactory.class;
		case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
			return ScenarioBehaviourScenarioBehaviourStepsCompartmentViewFactory.class;
		case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
			return EntryLevelSystemCallParameterUsageViewFactory.class;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			return VariableUsageVariableCharacterisationViewFactory.class;
		case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
			return ScenarioBehaviourScenarioBehaviourStepsCompartment2ViewFactory.class;
		case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
			return BranchUsageBranchTransitionsCompartmentViewFactory.class;
		case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
			return ScenarioBehaviourScenarioBehaviourStepsCompartment3ViewFactory.class;
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
		case AbstractUserActionSuccessorEditPart.VISUAL_ID:
			return AbstractUserActionSuccessorViewFactory.class;
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
