/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.FailureOccurrenceDescriptionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrences2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrencesEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel6EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel7EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel8EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.seff/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(view.getType())) {
				return ResourceDemandingSEFFEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(domainElement.eClass()) && isDiagram((ResourceDemandingSEFF) domainElement)) {
			return ResourceDemandingSEFFEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getModelID(containerView);
		if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ResourceDemandingSEFFEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case LoopActionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			break;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
			}
			break;
		case LoopAction2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			break;
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour2EditPart.VISUAL_ID;
			}
			break;
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
			}
			break;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsage2EditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisationEditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisation2EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return SetVariableAction2EditPart.VISUAL_ID;
			}
			break;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			if (PerformancePackage.eINSTANCE.getParametricResourceDemand().isSuperTypeOf(domainElement.eClass())) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			break;
		case InternalActionFailureOccurrencesEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getFailureOccurrenceDescription().isSuperTypeOf(domainElement.eClass())) {
				return FailureOccurrenceDescriptionEditPart.VISUAL_ID;
			}
			break;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition().isSuperTypeOf(domainElement.eClass())) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getGuardedBranchTransition().isSuperTypeOf(domainElement.eClass())) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return SetVariableAction2EditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsage2EditPart.VISUAL_ID;
			}
			break;
		case ForkActionForkedBehavioursEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getForkedBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ForkedBehaviourEditPart.VISUAL_ID;
			}
			break;
		case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			break;
		case SetVariableActionVariableSetterEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsage3EditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisation3EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return SetVariableAction2EditPart.VISUAL_ID;
			}
			break;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition().isSuperTypeOf(domainElement.eClass())) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getGuardedBranchTransition().isSuperTypeOf(domainElement.eClass())) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			break;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			if (PerformancePackage.eINSTANCE.getParametricResourceDemand().isSuperTypeOf(domainElement.eClass())) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			break;
		case InternalActionFailureOccurrences2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getFailureOccurrenceDescription().isSuperTypeOf(domainElement.eClass())) {
				return FailureOccurrenceDescriptionEditPart.VISUAL_ID;
			}
			break;
		case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
				return VariableUsage3EditPart.VISUAL_ID;
			}
			break;
		case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getForkedBehaviour().isSuperTypeOf(domainElement.eClass())) {
				return ForkedBehaviourEditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
				return StartActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
				return StopActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
				return ExternalCallActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
				return LoopActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return SetVariableActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
				return AcquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getModelID(containerView);
		if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ResourceDemandingSEFFEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ExternalCallActionEditPart.VISUAL_ID:
			if (ExternalCallActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallActionInputVariableUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopActionEditPart.VISUAL_ID:
			if (LoopActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchActionEditPart.VISUAL_ID:
			if (BranchActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionEditPart.VISUAL_ID:
			if (InternalActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionResourceDemand2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionFailureOccurrences2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableActionEditPart.VISUAL_ID:
			if (SetVariableActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionVariableSetter2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcquireActionEditPart.VISUAL_ID:
			if (AcquireActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReleaseActionEditPart.VISUAL_ID:
			if (ReleaseActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkActionEditPart.VISUAL_ID:
			if (ForkActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionForkedBehaviours2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsageEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsage2EditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopAction2EditPart.VISUAL_ID:
			if (LoopActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalAction2EditPart.VISUAL_ID:
			if (InternalActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionFailureOccurrencesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchAction2EditPart.VISUAL_ID:
			if (BranchActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			if (ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExternalCallAction2EditPart.VISUAL_ID:
			if (ExternalCallActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcquireAction2EditPart.VISUAL_ID:
			if (AcquireActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReleaseAction2EditPart.VISUAL_ID:
			if (ReleaseActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkAction2EditPart.VISUAL_ID:
			if (ForkActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionForkedBehavioursEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkedBehaviourEditPart.VISUAL_ID:
			if (ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableAction2EditPart.VISUAL_ID:
			if (SetVariableActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionVariableSetterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsage3EditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			if (GuardedBranchTransitionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
			if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
			if (VariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			if (VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			if (VariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			if (ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionFailureOccurrencesEditPart.VISUAL_ID:
			if (FailureOccurrenceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			if (ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
			if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
			if (VariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkActionForkedBehavioursEditPart.VISUAL_ID:
			if (ForkedBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableActionVariableSetterEditPart.VISUAL_ID:
			if (VariableUsage3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
			if (VariableCharacterisation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			if (ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			if (ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionFailureOccurrences2EditPart.VISUAL_ID:
			if (FailureOccurrenceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
			if (VariableUsage3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
			if (ForkedBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			if (StartActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ResourceDemandingSEFF element) {
		return true;
	}
}
