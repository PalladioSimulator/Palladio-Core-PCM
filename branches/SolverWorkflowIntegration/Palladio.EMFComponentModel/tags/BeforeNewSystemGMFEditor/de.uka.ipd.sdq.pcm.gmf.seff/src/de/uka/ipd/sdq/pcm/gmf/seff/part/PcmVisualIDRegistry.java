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

import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
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
public class PcmVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = PcmDiagramEditorPlugin
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
				PcmDiagramEditorPlugin.getInstance().logError(
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
				&& isDiagramResourceDemandingSEFF_79((ResourceDemandingSEFF) domainElement)) {
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
			return getUnrecognizedStartAction_1001ChildNodeID(domainElement,
					semanticHint);
		case StopActionEditPart.VISUAL_ID:
			return getUnrecognizedStopAction_1002ChildNodeID(domainElement,
					semanticHint);
		case ExternalCallActionEditPart.VISUAL_ID:
			if (ExternalCallActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallAction_1003ChildNodeID(
					domainElement, semanticHint);
		case LoopActionEditPart.VISUAL_ID:
			if (LoopActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionEntityName2EditPart.VISUAL_ID;
			}
			if (LoopActionIterations2EditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionIterations2EditPart.VISUAL_ID;
			}
			if (LoopActionBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionBehaviourCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopAction_1004ChildNodeID(domainElement,
					semanticHint);
		case BranchAction2EditPart.VISUAL_ID:
			if (BranchActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionEntityName2EditPart.VISUAL_ID;
			}
			if (BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchAction_1005ChildNodeID(domainElement,
					semanticHint);
		case InternalAction2EditPart.VISUAL_ID:
			if (InternalActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionEntityName2EditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalAction_1006ChildNodeID(domainElement,
					semanticHint);
		case PrimitiveParametricParameterUsageEditPart.VISUAL_ID:
			if (PrimitiveParametricParameterUsageSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return PrimitiveParametricParameterUsageSpecificationEditPart.VISUAL_ID;
			}
			return getUnrecognizedPrimitiveParametricParameterUsage_1007ChildNodeID(
					domainElement, semanticHint);
		case CollectionParametricParameterUsageEditPart.VISUAL_ID:
			if (CollectionParametricParameterUsageSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return CollectionParametricParameterUsageSpecificationEditPart.VISUAL_ID;
			}
			return getUnrecognizedCollectionParametricParameterUsage_1008ChildNodeID(
					domainElement, semanticHint);
		case ParametricResourceDemandEditPart.VISUAL_ID:
			if (ParametricResourceDemandDemandEditPart.VISUAL_ID == nodeVisualID) {
				return ParametricResourceDemandDemandEditPart.VISUAL_ID;
			}
			return getUnrecognizedParametricResourceDemand_1009ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourEditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_2001ChildNodeID(
					domainElement, semanticHint);
		case StartAction2EditPart.VISUAL_ID:
			return getUnrecognizedStartAction_2002ChildNodeID(domainElement,
					semanticHint);
		case StopAction2EditPart.VISUAL_ID:
			return getUnrecognizedStopAction_2003ChildNodeID(domainElement,
					semanticHint);
		case LoopAction2EditPart.VISUAL_ID:
			if (LoopActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionEntityNameEditPart.VISUAL_ID;
			}
			if (LoopActionIterationsEditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionIterationsEditPart.VISUAL_ID;
			}
			if (LoopActionBehaviourCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return LoopActionBehaviourCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopAction_2004ChildNodeID(domainElement,
					semanticHint);
		case InternalActionEditPart.VISUAL_ID:
			if (InternalActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return InternalActionEntityNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedInternalAction_2005ChildNodeID(domainElement,
					semanticHint);
		case BranchActionEditPart.VISUAL_ID:
			if (BranchActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionEntityNameEditPart.VISUAL_ID;
			}
			if (BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchAction_2006ChildNodeID(domainElement,
					semanticHint);
		case BranchTransitionEditPart.VISUAL_ID:
			if (BranchTransitionBranchConditionEditPart.VISUAL_ID == nodeVisualID) {
				return BranchTransitionBranchConditionEditPart.VISUAL_ID;
			}
			if (BranchTransitionBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BranchTransitionBehaviourCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchTransition_2007ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
			if (ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviour_2008ChildNodeID(
					domainElement, semanticHint);
		case ExternalCallAction2EditPart.VISUAL_ID:
			if (ExternalCallActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
				return ExternalCallActionEntityName2EditPart.VISUAL_ID;
			}
			return getUnrecognizedExternalCallAction_2009ChildNodeID(
					domainElement, semanticHint);
		case LoopActionBehaviourCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_2001((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopActionBehaviourCompartment_5001ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_2002((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_2003((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_2004((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_2005((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_2006((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_2009((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourLoopCompartment_5002ChildNodeID(
					domainElement, semanticHint);
		case LoopActionBehaviourCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_2001((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviourEditPart.VISUAL_ID;
			}
			return getUnrecognizedLoopActionBehaviourCompartment_5003ChildNodeID(
					domainElement, semanticHint);
		case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || BranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeBranchTransition_2007((BranchTransition) domainElement))) {
				return BranchTransitionEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchActionBranchTransitionCompartment_5004ChildNodeID(
					domainElement, semanticHint);
		case BranchTransitionBehaviourCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getResourceDemandingBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResourceDemandingBehaviour_2008((ResourceDemandingBehaviour) domainElement))) {
				return ResourceDemandingBehaviour2EditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchTransitionBehaviourCompartment_5005ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || StartAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_2002((StartAction) domainElement))) {
				return StartAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_2003((StopAction) domainElement))) {
				return StopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_2004((LoopAction) domainElement))) {
				return LoopAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_2005((InternalAction) domainElement))) {
				return InternalActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_2006((BranchAction) domainElement))) {
				return BranchActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_2009((ExternalCallAction) domainElement))) {
				return ExternalCallAction2EditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingBehaviourBranchCompartment_5006ChildNodeID(
					domainElement, semanticHint);
		case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || BranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeBranchTransition_2007((BranchTransition) domainElement))) {
				return BranchTransitionEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchActionBranchTransitionCompartment_5007ChildNodeID(
					domainElement, semanticHint);
		case ResourceDemandingSEFFEditPart.VISUAL_ID:
			if ((semanticHint == null || StartActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStartAction_1001((StartAction) domainElement))) {
				return StartActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStopAction_1002((StopAction) domainElement))) {
				return StopActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ExternalCallActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getExternalCallAction()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeExternalCallAction_1003((ExternalCallAction) domainElement))) {
				return ExternalCallActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopActionEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoopAction_1004((LoopAction) domainElement))) {
				return LoopActionEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranchAction_1005((BranchAction) domainElement))) {
				return BranchAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || InternalAction2EditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeInternalAction_1006((InternalAction) domainElement))) {
				return InternalAction2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || PrimitiveParametricParameterUsageEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE
							.getPrimitiveParametricParameterUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodePrimitiveParametricParameterUsage_1007((PrimitiveParametricParameterUsage) domainElement))) {
				return PrimitiveParametricParameterUsageEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || CollectionParametricParameterUsageEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE
							.getCollectionParametricParameterUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeCollectionParametricParameterUsage_1008((CollectionParametricParameterUsage) domainElement))) {
				return CollectionParametricParameterUsageEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID)
					&& SeffPackage.eINSTANCE.getParametricResourceDemand()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeParametricResourceDemand_1009((ParametricResourceDemand) domainElement))) {
				return ParametricResourceDemandEditPart.VISUAL_ID;
			}
			return getUnrecognizedResourceDemandingSEFF_79ChildNodeID(
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
	private static boolean isDiagramResourceDemandingSEFF_79(
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
	private static boolean isNodeStartAction_1001(StartAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStopAction_1002(StopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeExternalCallAction_1003(
			ExternalCallAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLoopAction_1004(LoopAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchAction_1005(BranchAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeInternalAction_1006(InternalAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodePrimitiveParametricParameterUsage_1007(
			PrimitiveParametricParameterUsage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeCollectionParametricParameterUsage_1008(
			CollectionParametricParameterUsage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeParametricResourceDemand_1009(
			ParametricResourceDemand element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_2001(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStartAction_2002(StartAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStopAction_2003(StopAction element) {
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
	private static boolean isNodeInternalAction_2005(InternalAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchAction_2006(BranchAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchTransition_2007(BranchTransition element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResourceDemandingBehaviour_2008(
			ResourceDemandingBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeExternalCallAction_2009(
			ExternalCallAction element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStartAction_1001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStopAction_1002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallAction_1003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoopAction_1004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchAction_1005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedInternalAction_1006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPrimitiveParametricParameterUsage_1007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedCollectionParametricParameterUsage_1008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedParametricResourceDemand_1009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStartAction_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStopAction_2003ChildNodeID(
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
	private static int getUnrecognizedInternalAction_2005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchAction_2006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchTransition_2007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviour_2008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedExternalCallAction_2009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoopActionBehaviourCompartment_5001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourLoopCompartment_5002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoopActionBehaviourCompartment_5003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchActionBranchTransitionCompartment_5004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchTransitionBehaviourCompartment_5005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingBehaviourBranchCompartment_5006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchActionBranchTransitionCompartment_5007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResourceDemandingSEFF_79ChildNodeID(
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
