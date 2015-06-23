/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelEditPartFactory implements EditPartFactory {

    /**
     * @generated
     */
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case UsageScenarioEditPart.VISUAL_ID:
                return new UsageScenarioEditPart(view);

            case UsageScenario2EditPart.VISUAL_ID:
                return new UsageScenario2EditPart(view);

            case UsageScenarioLabelEditPart.VISUAL_ID:
                return new UsageScenarioLabelEditPart(view);

            case ScenarioBehaviourEditPart.VISUAL_ID:
                return new ScenarioBehaviourEditPart(view);

            case StartEditPart.VISUAL_ID:
                return new StartEditPart(view);

            case StopEditPart.VISUAL_ID:
                return new StopEditPart(view);

            case EntryLevelSystemCallEditPart.VISUAL_ID:
                return new EntryLevelSystemCallEditPart(view);

            case ComponentExternalCallNameLabelEditPart.VISUAL_ID:
                return new ComponentExternalCallNameLabelEditPart(view);

            case VariableUsageEditPart.VISUAL_ID:
                return new VariableUsageEditPart(view);

            case WrappingLabelEditPart.VISUAL_ID:
                return new WrappingLabelEditPart(view);

            case VariableCharacterisationEditPart.VISUAL_ID:
                return new VariableCharacterisationEditPart(view);

            case LoopEditPart.VISUAL_ID:
                return new LoopEditPart(view);

            case UsageLoopIterationsLabelEditPart.VISUAL_ID:
                return new UsageLoopIterationsLabelEditPart(view);

            case ScenarioBehaviour2EditPart.VISUAL_ID:
                return new ScenarioBehaviour2EditPart(view);

            case BranchEditPart.VISUAL_ID:
                return new BranchEditPart(view);

            case BranchTransitionEditPart.VISUAL_ID:
                return new BranchTransitionEditPart(view);

            case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
                return new BranchTransitionBranchProbabilityEditPart(view);

            case ScenarioBehaviour3EditPart.VISUAL_ID:
                return new ScenarioBehaviour3EditPart(view);

            case DelayEditPart.VISUAL_ID:
                return new DelayEditPart(view);

            case DelayEntityNameEditPart.VISUAL_ID:
                return new DelayEntityNameEditPart(view);

            case DelayLabelSpecEditPart.VISUAL_ID:
                return new DelayLabelSpecEditPart(view);

            case ClosedWorkloadEditPart.VISUAL_ID:
                return new ClosedWorkloadEditPart(view);

            case ClosedWorkloadPopulationEditPart.VISUAL_ID:
                return new ClosedWorkloadPopulationEditPart(view);

            case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
                return new ClosedWorkloadTitleLabelEditPart(view);

            case ClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID:
                return new ClosedWorkloadThinkTimeLabelEditPart(view);

            case OpenWorkloadEditPart.VISUAL_ID:
                return new OpenWorkloadEditPart(view);

            case OpenWorkloadSpecLabelEditPart.VISUAL_ID:
                return new OpenWorkloadSpecLabelEditPart(view);

            case UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID:
                return new UsageScenarioUsageScenarioCompartmentEditPart(view);

            case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
                return new ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart(view);

            case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
                return new EntryLevelSystemCallParameterUsageEditPart(view);

            case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisationEditPart(view);

            case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
                return new ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart(view);

            case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
                return new BranchUsageBranchTransitionsCompartmentEditPart(view);

            case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
                return new ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart(view);

            case AbstractUserActionSuccessorEditPart.VISUAL_ID:
                return new AbstractUserActionSuccessorEditPart(view);

            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * @generated
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

    /**
     * @generated
     */
    public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
        return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
    }
}
