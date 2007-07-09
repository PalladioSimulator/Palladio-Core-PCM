/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabel3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageReferenceLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;

import de.uka.ipd.sdq.pcm.gmf.seff.expressions.PalladioComponentModelAbstractExpression;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

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
	private static final String DEBUG_KEY = PalladioComponentModelSeffDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

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
		return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
				.getVisualID(view.getType());
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
						.logError(
								"Unable to parse view type as a visualID number: "
										+ type);
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
		if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((ResourceDemandingSEFF) domainElement)) {
			return ResourceDemandingSEFFEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null
				|| !ResourceDemandingSEFFEditPart.MODEL_ID
						.equals(de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
								.getModelID(containerView))) {
			return -1;
		}
		switch (de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
				.getVisualID(containerView)) {
		case LoopActionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			break;
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
			}
			break;
		case LoopAction2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			break;
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour2EditPart.VISUAL_ID;
			}
			break;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
			}
			break;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour5EditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsage2EditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation()
					.isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisationEditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation()
					.isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisation2EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(
					domainElement.eClass())) {
				return SetVariableActionEditPart.VISUAL_ID;
			}
			break;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getParametricResourceDemand()
					.isSuperTypeOf(domainElement.eClass())) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			break;
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition()
					.isSuperTypeOf(domainElement.eClass())) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getGuardedBranchTransition()
					.isSuperTypeOf(domainElement.eClass())) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(
					domainElement.eClass())) {
				return SetVariableActionEditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			break;
		case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsage2EditPart.VISUAL_ID;
			}
			break;
		case ForkActionForkedBehavioursEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			break;
		case SetVariableActionVariableSetterEditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsage3EditPart.VISUAL_ID;
			}
			break;
		case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableCharacterisation()
					.isSuperTypeOf(domainElement.eClass())) {
				return VariableCharacterisation3EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(
					domainElement.eClass())) {
				return SetVariableActionEditPart.VISUAL_ID;
			}
			break;
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition()
					.isSuperTypeOf(domainElement.eClass())) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getGuardedBranchTransition()
					.isSuperTypeOf(domainElement.eClass())) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			break;
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getParametricResourceDemand()
					.isSuperTypeOf(domainElement.eClass())) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			break;
		case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
			if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableUsage3EditPart.VISUAL_ID;
			}
			break;
		case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
			}
			break;
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StartActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StopActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ExternalCallActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
					domainElement.eClass())) {
				return LoopActionEditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
					domainElement.eClass())) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getCollectionIteratorAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(
					domainElement.eClass())) {
				return SetVariableAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getAquireAction().isSuperTypeOf(
					domainElement.eClass())) {
				return AquireAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ReleaseAction2EditPart.VISUAL_ID;
			}
			if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ForkAction2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
				.getModelID(containerView);
		if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
					.getVisualID(containerView);
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
			if (LoopActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopIterationsLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchAction2EditPart.VISUAL_ID:
			if (BranchActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalAction2EditPart.VISUAL_ID:
			if (InternalActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionResourceDemand2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorParameterLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableAction2EditPart.VISUAL_ID:
			if (SetVariableActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionVariableSetter2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AquireAction2EditPart.VISUAL_ID:
			if (AquireActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
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
			if (ForkActionForkedBehaviours2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsageEditPart.VISUAL_ID:
			if (VariableUsageReferenceLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsage2EditPart.VISUAL_ID:
			if (VariableUsageReferenceLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopAction2EditPart.VISUAL_ID:
			if (LoopActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopIterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionEditPart.VISUAL_ID:
			if (InternalActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BranchActionEditPart.VISUAL_ID:
			if (BranchActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			if (ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
		case AquireActionEditPart.VISUAL_ID:
			if (AquireActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
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
			if (ForkActionForkedBehavioursEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollectionIteratorActionEditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorParameterLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetVariableActionEditPart.VISUAL_ID:
			if (SetVariableActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionVariableSetterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableUsage3EditPart.VISUAL_ID:
			if (VariableUsageReferenceLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableUsageVariableCharacterisation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			if (GuardedBranchTransitionIdEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceDemandingBehaviour5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviour5EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID == nodeVisualID) {
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
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			if (ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
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
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
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
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
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
		case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
			if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableActionEditPart.VISUAL_ID == nodeVisualID) {
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
		case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
			if (VariableUsage3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
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
			if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AquireAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
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

	/**
	 * @generated
	 */
	private static boolean evaluate(
			PalladioComponentModelAbstractExpression expression, Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}
}
