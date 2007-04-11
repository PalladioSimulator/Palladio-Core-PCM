/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

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

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
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
		return getVisualID(view.getType());
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
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramResourceDemandingSEFF_1000((ResourceDemandingSEFF) domainElement)) {
			return ResourceDemandingSEFFEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ResourceDemandingSEFFEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case StartActionEditPart.VISUAL_ID:
			return getUnrecognizedStartAction_2001ChildNodeID(domainElement,
					semanticHint);
		case StopActionEditPart.VISUAL_ID:
			return getUnrecognizedStopAction_2002ChildNodeID(domainElement,
					semanticHint);
		case ExternalCallActionEditPart.VISUAL_ID:
			if (ExternalCallActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionEntityNameEditPart.VISUAL_ID;
			}
			if (ExternalCallActionParameterUsageEditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionParameterUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallAction_2003ChildNodeID(
					domainElement, semanticHint);
		case LoopActionEditPart.VISUAL_ID:
			if (LoopActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionEntityName2EditPart.VISUAL_ID;
			}
			if (LoopIterationsLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return LoopIterationsLabel2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3003((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopAction_2004ChildNodeID(domainElement,
					semanticHint);
		case BranchAction2EditPart.VISUAL_ID:
			if (BranchActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionEntityName2EditPart.VISUAL_ID;
			}
			if (BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchAction_2005ChildNodeID(domainElement,
					semanticHint);
		case InternalAction2EditPart.VISUAL_ID:
			if (InternalActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionEntityName2EditPart.VISUAL_ID;
			}
			if (InternalActionResourceDemand2EditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionResourceDemand2EditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalAction_2006ChildNodeID(domainElement,
					semanticHint);
		case CollectionIteratorAction2EditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return CollectionIteratorActionEntityName2EditPart.VISUAL_ID;
			}
			if (CollectionIteratorParameterLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return CollectionIteratorParameterLabel2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3014((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
			}
			return getUnrecognizedCollectionIteratorAction_2007ChildNodeID(
					domainElement, semanticHint);
		case SetVariableActionEditPart.VISUAL_ID:
			if (SetVariableActionParameterUsageEditPart.VISUAL_ID == nodeVisualID) {
				return SetVariableActionParameterUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedSetVariableAction_2008ChildNodeID(
					domainElement, semanticHint);
		case VariableUsageEditPart.VISUAL_ID:
			if (VariableUsageReferenceLabelEditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageReferenceLabelEditPart.VISUAL_ID;
			}
			if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageVariableCharacterisationEditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsage_3001ChildNodeID(domainElement,
					semanticHint);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getUnrecognizedVariableCharacterisation_3002ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_3003ChildNodeID(
					domainElement, semanticHint);
		case StartAction2EditPart.VISUAL_ID:
			return getUnrecognizedStartAction_3004ChildNodeID(domainElement,
					semanticHint);
		case StopAction2EditPart.VISUAL_ID:
			return getUnrecognizedStopAction_3005ChildNodeID(domainElement,
					semanticHint);
		case LoopAction2EditPart.VISUAL_ID:
			if (LoopActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionEntityNameEditPart.VISUAL_ID;
			}
			if (LoopIterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
				return LoopIterationsLabelEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3003((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopAction_3006ChildNodeID(domainElement,
					semanticHint);
		case InternalActionEditPart.VISUAL_ID:
			if (InternalActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionEntityNameEditPart.VISUAL_ID;
			}
			if (InternalActionResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionResourceDemandEditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalAction_3007ChildNodeID(domainElement,
					semanticHint);
		case ParametricResourceDemandEditPart.VISUAL_ID:
			return getUnrecognizedParametricResourceDemand_3008ChildNodeID(
					domainElement, semanticHint);
		case BranchActionEditPart.VISUAL_ID:
			if (BranchActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionEntityNameEditPart.VISUAL_ID;
			}
			if (BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchAction_3009ChildNodeID(domainElement,
					semanticHint);
		case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
			if (ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
				return ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3011((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviour2EditPart.VISUAL_ID;
			}
			return getUnrecognizedProbabilisticBranchTransition_3010ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_3011ChildNodeID(
					domainElement, semanticHint);
		case ExternalCallAction2EditPart.VISUAL_ID:
			if (ExternalCallActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionEntityName2EditPart.VISUAL_ID;
			}
			if (ExternalCallActionParameterUsage2EditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionParameterUsage2EditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallAction_3012ChildNodeID(
					domainElement, semanticHint);
		case GuardedBranchTransitionEditPart.VISUAL_ID:
			if (GuardedBranchTransitionIdEditPart.VISUAL_ID == nodeVisualID) {
				return GuardedBranchTransitionIdEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3018((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
			}
			return getUnrecognizedGuardedBranchTransition_3017ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_3018ChildNodeID(
					domainElement, semanticHint);
		case CollectionIteratorActionEditPart.VISUAL_ID:
			if (CollectionIteratorActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return CollectionIteratorActionEntityNameEditPart.VISUAL_ID;
			}
			if (CollectionIteratorParameterLabelEditPart.VISUAL_ID == nodeVisualID) {
				return CollectionIteratorParameterLabelEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_3014((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
			}
			return getUnrecognizedCollectionIteratorAction_3013ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_3014ChildNodeID(
					domainElement, semanticHint);
		case VariableUsage2EditPart.VISUAL_ID:
			if (VariableUsageReferenceLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageReferenceLabel2EditPart.VISUAL_ID;
			}
			if (VariableUsageVariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageVariableCharacterisation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsage_3015ChildNodeID(domainElement,
					semanticHint);
		case VariableCharacterisation2EditPart.VISUAL_ID:
			return getUnrecognizedVariableCharacterisation_3016ChildNodeID(
					domainElement, semanticHint);
		case ExternalCallActionParameterUsageEditPart.VISUAL_ID:
			if ((semanticHint == null || VariableUsageEditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableUsage_3001((VariableUsage) domainElement))) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallActionParameterUsage_7001ChildNodeID(
					domainElement, semanticHint);
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			if ((semanticHint == null || VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableCharacterisation()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableCharacterisation_3002((VariableCharacterisation) domainElement))) {
				return VariableCharacterisationEditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsageVariableCharacterisation_7002ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_3004((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_3005((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_3006((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_3007((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_3009((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_3012((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getCollectionIteratorAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCollectionIteratorAction_3013((CollectionIteratorAction) domainElement))) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourLoopCompartment_7004ChildNodeID(
					domainElement, semanticHint);
		case InternalActionResourceDemandEditPart.VISUAL_ID:
			if ((semanticHint == null || ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getParametricResourceDemand()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeParametricResourceDemand_3008((ParametricResourceDemand) domainElement))) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalActionResourceDemand_7006ChildNodeID(
					domainElement, semanticHint);
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getProbabilisticBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeProbabilisticBranchTransition_3010((ProbabilisticBranchTransition) domainElement))) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getGuardedBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeGuardedBranchTransition_3017((GuardedBranchTransition) domainElement))) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchActionBranchTransitionCompartment_7007ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_3004((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_3005((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_3006((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_3007((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_3009((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_3012((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourBranchCompartment_7009ChildNodeID(
					domainElement, semanticHint);
		case ExternalCallActionParameterUsage2EditPart.VISUAL_ID:
			if ((semanticHint == null || VariableUsageEditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableUsage_3001((VariableUsage) domainElement))) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallActionParameterUsage_7010ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourBranchCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_3004((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_3005((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_3006((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_3007((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_3009((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_3012((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourBranchCompartment_7018ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_3004((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_3005((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_3006((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_3007((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_3009((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_3012((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getCollectionIteratorAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCollectionIteratorAction_3013((CollectionIteratorAction) domainElement))) {
				return CollectionIteratorActionEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourLoopCompartment_7014ChildNodeID(
					domainElement, semanticHint);
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getProbabilisticBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeProbabilisticBranchTransition_3010((ProbabilisticBranchTransition) domainElement))) {
				return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getGuardedBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeGuardedBranchTransition_3017((GuardedBranchTransition) domainElement))) {
				return GuardedBranchTransitionEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchActionBranchTransitionCompartment_7011ChildNodeID(
					domainElement, semanticHint);
		case InternalActionResourceDemand2EditPart.VISUAL_ID:
			if ((semanticHint == null || ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getParametricResourceDemand()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeParametricResourceDemand_3008((ParametricResourceDemand) domainElement))) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalActionResourceDemand_7012ChildNodeID(
					domainElement, semanticHint);
		case SetVariableActionParameterUsageEditPart.VISUAL_ID:
			if ((semanticHint == null || VariableUsage2EditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableUsage_3015((VariableUsage) domainElement))) {
				return VariableUsage2EditPart.VISUAL_ID;
			}
			return getUnrecognizedSetVariableActionParameterUsage_7016ChildNodeID(
					domainElement, semanticHint);
		case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
			if ((semanticHint == null || VariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableCharacterisation()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableCharacterisation_3016((VariableCharacterisation) domainElement))) {
				return VariableCharacterisation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsageVariableCharacterisation_7017ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			if ((semanticHint == null || StartActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_2001((StartAction) domainElement))) {
				return StartActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_2002((StopAction) domainElement))) {
				return StopActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_2003((ExternalCallAction) domainElement))) {
				return ExternalCallActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_2004((LoopAction) domainElement))) {
				return LoopActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_2005((BranchAction) domainElement))) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_2006((InternalAction) domainElement))) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getCollectionIteratorAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCollectionIteratorAction_2007((CollectionIteratorAction) domainElement))) {
				return CollectionIteratorAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SetVariableActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getSetVariableAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSetVariableAction_2008((SetVariableAction) domainElement))) {
				return SetVariableActionEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingSEFF_1000ChildNodeID(
					domainElement, semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		{
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramResourceDemandingSEFF_1000(
			ResourceDemandingSEFF element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStartAction_2001(StartAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStopAction_2002(StopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeExternalCallAction_2003(
			ExternalCallAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLoopAction_2004(LoopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchAction_2005(BranchAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeInternalAction_2006(InternalAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeCollectionIteratorAction_2007(
			CollectionIteratorAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSetVariableAction_2008(
			SetVariableAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableUsage_3001(VariableUsage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableCharacterisation_3002(
			VariableCharacterisation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_3003(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStartAction_3004(StartAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStopAction_3005(StopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLoopAction_3006(LoopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeInternalAction_3007(InternalAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeParametricResourceDemand_3008(
			ParametricResourceDemand element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchAction_3009(BranchAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeProbabilisticBranchTransition_3010(
			ProbabilisticBranchTransition element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_3011(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeExternalCallAction_3012(
			ExternalCallAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeGuardedBranchTransition_3017(
			GuardedBranchTransition element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_3018(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeCollectionIteratorAction_3013(
			CollectionIteratorAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_3014(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableUsage_3015(VariableUsage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableCharacterisation_3016(
			VariableCharacterisation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStartAction_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStopAction_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallAction_2003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoopAction_2004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchAction_2005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInternalAction_2006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCollectionIteratorAction_2007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSetVariableAction_2008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsage_3001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableCharacterisation_3002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_3003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStartAction_3004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStopAction_3005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoopAction_3006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInternalAction_3007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedParametricResourceDemand_3008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchAction_3009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedProbabilisticBranchTransition_3010ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_3011ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallAction_3012ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedGuardedBranchTransition_3017ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_3018ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCollectionIteratorAction_3013ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_3014ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsage_3015ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableCharacterisation_3016ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallActionParameterUsage_7001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsageVariableCharacterisation_7002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourLoopCompartment_7004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInternalActionResourceDemand_7006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchActionBranchTransitionCompartment_7007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourBranchCompartment_7009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallActionParameterUsage_7010ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourBranchCompartment_7018ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourLoopCompartment_7014ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchActionBranchTransitionCompartment_7011ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInternalActionResourceDemand_7012ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSetVariableActionParameterUsage_7016ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsageVariableCharacterisation_7017ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingSEFF_1000ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}
}
