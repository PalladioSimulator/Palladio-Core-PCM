/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadTitleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.PalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * A factory for creating CustomPalladioComponentModelEditPart objects.
 */
public class CustomPalladioComponentModelEditPartFactory extends PalladioComponentModelEditPartFactory {

    /**
     * Creates a new CustomPalladioComponentModelEditPart object.
     * 
     * @param context
     *            the context
     * @param model
     *            the model
     * @return the edits the part
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.PalladioComponentModelEditPartFactory#createEditPart(org.eclipse.gef.EditPart,
     *      java.lang.Object)
     */
    @Override
    public EditPart createEditPart(final EditPart context, final Object model) {
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

            case CustomComponentExternalCallNameLabelEditPart.VISUAL_ID:
                return new CustomComponentExternalCallNameLabelEditPart(view);

            case CustomVariableUsageEditPart.VISUAL_ID:
                return new CustomVariableUsageEditPart(view);

            case WrappingLabelEditPart.VISUAL_ID:
                return new WrappingLabelEditPart(view);

            case CustomVariableCharacterisationEditPart.VISUAL_ID:
                return new CustomVariableCharacterisationEditPart(view);

            case LoopEditPart.VISUAL_ID:
                return new LoopEditPart(view);

            case CustomUsageLoopIterationsLabelEditPart.VISUAL_ID:
                return new CustomUsageLoopIterationsLabelEditPart(view);

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

            case CustomDelayLabelSpecEditPart.VISUAL_ID:
                return new CustomDelayLabelSpecEditPart(view);

            case ClosedWorkloadEditPart.VISUAL_ID:
                return new ClosedWorkloadEditPart(view);

            case ClosedWorkloadPopulationEditPart.VISUAL_ID:
                return new ClosedWorkloadPopulationEditPart(view);

            case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
                return new ClosedWorkloadTitleLabelEditPart(view);

            case CustomClosedWorkloadThinkTimeLabelEditPart.VISUAL_ID:
                return new CustomClosedWorkloadThinkTimeLabelEditPart(view);

            case OpenWorkloadEditPart.VISUAL_ID:
                return new OpenWorkloadEditPart(view);

            case CustomOpenWorkloadSpecLabelEditPart.VISUAL_ID:
                return new CustomOpenWorkloadSpecLabelEditPart(view);

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

            default:
                break;

            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * Creates a new CustomPalladioComponentModelEditPart object.
     * 
     * @param context
     *            the context
     * @param model
     *            the model
     * @return the edits the part
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }
}
