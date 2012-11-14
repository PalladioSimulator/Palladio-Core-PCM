/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadSpecLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * This registry is used to determine which type of visual object should be created for the
 * corresponding Diagram, Node, ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

    /** The Constant DEBUG_KEY. @generated */
    private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.usage/debug/visualID"; //$NON-NLS-1$

    /**
     * Gets the visual id.
     *
     * @param view the view
     * @return the visual id
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
        return de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry.getVisualID(view.getType());
    }

    /**
     * Gets the model id.
     *
     * @param view the view
     * @return the model id
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
     * Gets the visual id.
     *
     * @param type the type
     * @return the visual id
     * @generated
     */
    public static int getVisualID(String type) {
        try {
            return Integer.parseInt(type);
        } catch (NumberFormatException e) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
                PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: " + type);
            }
        }
        return -1;
    }

    /**
     * Gets the type.
     *
     * @param visualID the visual id
     * @return the type
     * @generated
     */
    public static String getType(int visualID) {
        return String.valueOf(visualID);
    }

    /**
     * Gets the diagram visual id.
     *
     * @param domainElement the domain element
     * @return the diagram visual id
     * @generated
     */
    public static int getDiagramVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (UsagemodelPackage.eINSTANCE.getUsageModel().isSuperTypeOf(domainElement.eClass())
                && isDiagram((UsageModel) domainElement)) {
            return UsageScenarioEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * Gets the node visual id.
     *
     * @param containerView the container view
     * @param domainElement the domain element
     * @return the node visual id
     * @generated
     */
    public static int getNodeVisualID(View containerView, EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = UsageScenarioEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
        case LoopEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getScenarioBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ScenarioBehaviour2EditPart.VISUAL_ID;
            }
            break;
        case BranchTransitionEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getScenarioBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ScenarioBehaviour3EditPart.VISUAL_ID;
            }
            break;
        case UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getScenarioBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ScenarioBehaviourEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getClosedWorkload().isSuperTypeOf(domainElement.eClass())) {
                return ClosedWorkloadEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getOpenWorkload().isSuperTypeOf(domainElement.eClass())) {
                return OpenWorkloadEditPart.VISUAL_ID;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(domainElement.eClass())) {
                return StartEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(domainElement.eClass())) {
                return StopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall().isSuperTypeOf(domainElement.eClass())) {
                return EntryLevelSystemCallEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(domainElement.eClass())) {
                return LoopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(domainElement.eClass())) {
                return BranchEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getDelay().isSuperTypeOf(domainElement.eClass())) {
                return DelayEditPart.VISUAL_ID;
            }
            break;
        case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsageEditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisationEditPart.VISUAL_ID;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(domainElement.eClass())) {
                return StartEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(domainElement.eClass())) {
                return StopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall().isSuperTypeOf(domainElement.eClass())) {
                return EntryLevelSystemCallEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(domainElement.eClass())) {
                return LoopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(domainElement.eClass())) {
                return BranchEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getDelay().isSuperTypeOf(domainElement.eClass())) {
                return DelayEditPart.VISUAL_ID;
            }
            break;
        case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getBranchTransition().isSuperTypeOf(domainElement.eClass())) {
                return BranchTransitionEditPart.VISUAL_ID;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getStart().isSuperTypeOf(domainElement.eClass())) {
                return StartEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getStop().isSuperTypeOf(domainElement.eClass())) {
                return StopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall().isSuperTypeOf(domainElement.eClass())) {
                return EntryLevelSystemCallEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getLoop().isSuperTypeOf(domainElement.eClass())) {
                return LoopEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getBranch().isSuperTypeOf(domainElement.eClass())) {
                return BranchEditPart.VISUAL_ID;
            }
            if (UsagemodelPackage.eINSTANCE.getDelay().isSuperTypeOf(domainElement.eClass())) {
                return DelayEditPart.VISUAL_ID;
            }
            break;
        case UsageScenarioEditPart.VISUAL_ID:
            if (UsagemodelPackage.eINSTANCE.getUsageScenario().isSuperTypeOf(domainElement.eClass())) {
                return UsageScenario2EditPart.VISUAL_ID;
            }
            break;
        }
        return -1;
    }

    /**
     * Can create node.
     *
     * @param containerView the container view
     * @param nodeVisualID the node visual id
     * @return true, if successful
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (UsageScenarioEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = UsageScenarioEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
        case UsageScenario2EditPart.VISUAL_ID:
            if (UsageScenarioLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviourEditPart.VISUAL_ID:
            if (ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            if (ComponentExternalCallNameLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageEditPart.VISUAL_ID:
            if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case LoopEditPart.VISUAL_ID:
            if (UsageLoopIterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ScenarioBehaviour2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            if (ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchEditPart.VISUAL_ID:
            if (BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchTransitionEditPart.VISUAL_ID:
            if (BranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ScenarioBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            if (ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case DelayEditPart.VISUAL_ID:
            if (DelayEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (DelayLabelSpecEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ClosedWorkloadEditPart.VISUAL_ID:
            if (ClosedWorkloadPopulationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ClosedWorkloadTitleLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case OpenWorkloadEditPart.VISUAL_ID:
            if (OpenWorkloadSpecLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID:
            if (ScenarioBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ClosedWorkloadEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (OpenWorkloadEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
            if (StartEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (DelayEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
            if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            if (VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
            if (StartEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (DelayEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
            if (BranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
            if (StartEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EntryLevelSystemCallEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (DelayEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case UsageScenarioEditPart.VISUAL_ID:
            if (UsageScenario2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        }
        return false;
    }

    /**
     * Gets the link with class visual id.
     *
     * @param domainElement the domain element
     * @return the link with class visual id
     * @generated
     */
    public static int getLinkWithClassVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        return -1;
    }

    /**
     * User can change implementation of this method to handle some specific situations not covered
     * by default logic.
     *
     * @param element the element
     * @return true, if is diagram
     * @generated
     */
    private static boolean isDiagram(UsageModel element) {
        return true;
    }
}
