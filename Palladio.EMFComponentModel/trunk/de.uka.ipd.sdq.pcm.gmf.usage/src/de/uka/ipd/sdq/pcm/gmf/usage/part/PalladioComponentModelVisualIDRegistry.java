/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageReferenceLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
	private static final String DEBUG_KEY = PalladioComponentModelUsageDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (UsageScenarioEditPart.MODEL_ID.equals(view.getType())) {
				return UsageScenarioEditPart.VISUAL_ID;
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
				PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
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
		if (UsagemodelPackage.eINSTANCE.getUsageScenario().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramUsageScenario_1000((UsageScenario) domainElement)) {
			return UsageScenarioEditPart.VISUAL_ID;
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
		if (!UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = UsageScenarioEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case ScenarioBehaviourEditPart.VISUAL_ID:
			if (ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviour_2001ChildNodeID(
					domainElement, semanticHint);
		case ClosedWorkloadEditPart.VISUAL_ID:
			if (ClosedWorkloadTitleLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ClosedWorkloadTitleLabelEditPart.VISUAL_ID;
			}
			if (ClosedWorkloadPopulationEditPart.VISUAL_ID == nodeVisualID) {
				return ClosedWorkloadPopulationEditPart.VISUAL_ID;
			}
			if (ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedClosedWorkload_2002ChildNodeID(domainElement,
					semanticHint);
		case OpenWorkloadEditPart.VISUAL_ID:
			if (OpenWorkloadSpecLabelEditPart.VISUAL_ID == nodeVisualID) {
				return OpenWorkloadSpecLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedOpenWorkload_2003ChildNodeID(domainElement,
					semanticHint);
		case StartEditPart.VISUAL_ID:
			return getUnrecognizedStart_3001ChildNodeID(domainElement,
					semanticHint);
		case StopEditPart.VISUAL_ID:
			return getUnrecognizedStop_3002ChildNodeID(domainElement,
					semanticHint);
		case EntryLevelSystemCallEditPart.VISUAL_ID:
			if (ComponentExternalCallNameLabelEditPart.VISUAL_ID == nodeVisualID) {
				return ComponentExternalCallNameLabelEditPart.VISUAL_ID;
			}
			if (EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID == nodeVisualID) {
				return EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedEntryLevelSystemCall_3003ChildNodeID(
					domainElement, semanticHint);
		case VariableUsageEditPart.VISUAL_ID:
			if (VariableUsageReferenceLabelEditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageReferenceLabelEditPart.VISUAL_ID;
			}
			if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
				return VariableUsageVariableCharacterisationEditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsage_3004ChildNodeID(domainElement,
					semanticHint);
		case VariableCharacterisationEditPart.VISUAL_ID:
			return getUnrecognizedVariableCharacterisation_3006ChildNodeID(
					domainElement, semanticHint);
		case LoopEditPart.VISUAL_ID:
			if (UsageLoopIterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
				return UsageLoopIterationsLabelEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ScenarioBehaviour2EditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getScenarioBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeScenarioBehaviour_3007((ScenarioBehaviour) domainElement))) {
				return ScenarioBehaviour2EditPart.VISUAL_ID;
			}
			return getUnrecognizedLoop_3005ChildNodeID(domainElement,
					semanticHint);
		case ScenarioBehaviour2EditPart.VISUAL_ID:
			if (ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviour_3007ChildNodeID(
					domainElement, semanticHint);
		case BranchEditPart.VISUAL_ID:
			if (UsageBranchStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return UsageBranchStereotypeLabelEditPart.VISUAL_ID;
			}
			if (BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranch_3008ChildNodeID(domainElement,
					semanticHint);
		case BranchTransitionEditPart.VISUAL_ID:
			if (BranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
				return BranchTransitionBranchProbabilityEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ScenarioBehaviour3EditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getScenarioBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeScenarioBehaviour_3010((ScenarioBehaviour) domainElement))) {
				return ScenarioBehaviour3EditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchTransition_3009ChildNodeID(
					domainElement, semanticHint);
		case ScenarioBehaviour3EditPart.VISUAL_ID:
			if (ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
				return ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviour_3010ChildNodeID(
					domainElement, semanticHint);
		case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || StartEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStart_3001((Start) domainElement))) {
				return StartEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStop_3002((Stop) domainElement))) {
				return StopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEntryLevelSystemCall_3003((EntryLevelSystemCall) domainElement))) {
				return EntryLevelSystemCallEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoop_3005((Loop) domainElement))) {
				return LoopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranch_3008((Branch) domainElement))) {
				return BranchEditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7001ChildNodeID(
					domainElement, semanticHint);
		case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
			if ((semanticHint == null || VariableUsageEditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableUsage()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableUsage_3004((VariableUsage) domainElement))) {
				return VariableUsageEditPart.VISUAL_ID;
			}
			return getUnrecognizedEntryLevelSystemCallParameterUsage_7002ChildNodeID(
					domainElement, semanticHint);
		case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
			if ((semanticHint == null || VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID)
					&& ParameterPackage.eINSTANCE.getVariableCharacterisation()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeVariableCharacterisation_3006((VariableCharacterisation) domainElement))) {
				return VariableCharacterisationEditPart.VISUAL_ID;
			}
			return getUnrecognizedVariableUsageVariableCharacterisation_7003ChildNodeID(
					domainElement, semanticHint);
		case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
			if ((semanticHint == null || StartEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStart_3001((Start) domainElement))) {
				return StartEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStop_3002((Stop) domainElement))) {
				return StopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEntryLevelSystemCall_3003((EntryLevelSystemCall) domainElement))) {
				return EntryLevelSystemCallEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoop_3005((Loop) domainElement))) {
				return LoopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranch_3008((Branch) domainElement))) {
				return BranchEditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7005ChildNodeID(
					domainElement, semanticHint);
		case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || BranchTransitionEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getBranchTransition()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeBranchTransition_3009((BranchTransition) domainElement))) {
				return BranchTransitionEditPart.VISUAL_ID;
			}
			return getUnrecognizedBranchUsageBranchTransitionsCompartment_7009ChildNodeID(
					domainElement, semanticHint);
		case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
			if ((semanticHint == null || StartEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStart_3001((Start) domainElement))) {
				return StartEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || StopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeStop_3002((Stop) domainElement))) {
				return StopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEntryLevelSystemCall_3003((EntryLevelSystemCall) domainElement))) {
				return EntryLevelSystemCallEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || LoopEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeLoop_3005((Loop) domainElement))) {
				return LoopEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || BranchEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBranch_3008((Branch) domainElement))) {
				return BranchEditPart.VISUAL_ID;
			}
			return getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7008ChildNodeID(
					domainElement, semanticHint);
		case UsageScenarioEditPart.VISUAL_ID:
			if ((semanticHint == null || ScenarioBehaviourEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getScenarioBehaviour()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeScenarioBehaviour_2001((ScenarioBehaviour) domainElement))) {
				return ScenarioBehaviourEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ClosedWorkloadEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getClosedWorkload()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeClosedWorkload_2002((ClosedWorkload) domainElement))) {
				return ClosedWorkloadEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || OpenWorkloadEditPart.VISUAL_ID == nodeVisualID)
					&& UsagemodelPackage.eINSTANCE.getOpenWorkload()
							.isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeOpenWorkload_2003((OpenWorkload) domainElement))) {
				return OpenWorkloadEditPart.VISUAL_ID;
			}
			return getUnrecognizedUsageScenario_1000ChildNodeID(domainElement,
					semanticHint);
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
	private static boolean isDiagramUsageScenario_1000(UsageScenario element) {
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
	private static boolean isNodeScenarioBehaviour_2001(
			ScenarioBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeClosedWorkload_2002(ClosedWorkload element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeOpenWorkload_2003(OpenWorkload element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStart_3001(Start element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeStop_3002(Stop element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEntryLevelSystemCall_3003(
			EntryLevelSystemCall element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableUsage_3004(VariableUsage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeVariableCharacterisation_3006(
			VariableCharacterisation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLoop_3005(Loop element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeScenarioBehaviour_3007(
			ScenarioBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranch_3008(Branch element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBranchTransition_3009(BranchTransition element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeScenarioBehaviour_3010(
			ScenarioBehaviour element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviour_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedClosedWorkload_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedOpenWorkload_2003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStart_3001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedStop_3002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEntryLevelSystemCall_3003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsage_3004ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableCharacterisation_3006ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLoop_3005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviour_3007ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranch_3008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchTransition_3009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviour_3010ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEntryLevelSystemCallParameterUsage_7002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedVariableUsageVariableCharacterisation_7003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7005ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBranchUsageBranchTransitionsCompartment_7009ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedScenarioBehaviourScenarioBehaviourStepsCompartment_7008ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedUsageScenario_1000ChildNodeID(
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
