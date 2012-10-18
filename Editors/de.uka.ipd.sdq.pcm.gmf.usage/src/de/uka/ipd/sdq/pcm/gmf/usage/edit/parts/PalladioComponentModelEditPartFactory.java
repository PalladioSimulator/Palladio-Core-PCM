/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * A factory for creating PalladioComponentModelEditPart objects.
 *
 * @generated
 */
public class PalladioComponentModelEditPartFactory implements EditPartFactory {

    /**
     * Creates a new PalladioComponentModelEditPart object.
     *
     * @param context the context
     * @param model the model
     * @return the edits the part
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
     * Creates a new PalladioComponentModelEditPart object.
     *
     * @param context the context
     * @param model the model
     * @return the edits the part
     * @generated
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

    /**
     * Gets the text cell editor locator.
     *
     * @param source the source
     * @return the text cell editor locator
     * @generated
     */
    public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
        if (source.getFigure() instanceof WrappingLabel)
            return new TextCellEditorLocator((WrappingLabel) source.getFigure());
        else {
            return new LabelCellEditorLocator((Label) source.getFigure());
        }
    }

    /**
     * The Class TextCellEditorLocator.
     *
     * @generated
     */
    static private class TextCellEditorLocator implements CellEditorLocator {

        /** The wrap label. @generated */
        private WrappingLabel wrapLabel;

        /**
         * Instantiates a new text cell editor locator.
         *
         * @param wrapLabel the wrap label
         * @generated
         */
        public TextCellEditorLocator(WrappingLabel wrapLabel) {
            this.wrapLabel = wrapLabel;
        }

        /**
         * Gets the wrap label.
         *
         * @return the wrap label
         * @generated
         */
        public WrappingLabel getWrapLabel() {
            return wrapLabel;
        }

        /**
         * Relocate.
         *
         * @param celleditor the celleditor
         * @generated
         */
        public void relocate(CellEditor celleditor) {
            Text text = (Text) celleditor.getControl();
            Rectangle rect = getWrapLabel().getTextBounds().getCopy();
            getWrapLabel().translateToAbsolute(rect);
            if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
                rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
            } else {
                int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
                rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
            }
            if (!rect.equals(new Rectangle(text.getBounds()))) {
                text.setBounds(rect.x, rect.y, rect.width, rect.height);
            }
        }

    }

    /**
     * The Class LabelCellEditorLocator.
     *
     * @generated
     */
    private static class LabelCellEditorLocator implements CellEditorLocator {

        /** The label. @generated */
        private Label label;

        /**
         * Instantiates a new label cell editor locator.
         *
         * @param label the label
         * @generated
         */
        public LabelCellEditorLocator(Label label) {
            this.label = label;
        }

        /**
         * Gets the label.
         *
         * @return the label
         * @generated
         */
        public Label getLabel() {
            return label;
        }

        /**
         * Relocate.
         *
         * @param celleditor the celleditor
         * @generated
         */
        public void relocate(CellEditor celleditor) {
            Text text = (Text) celleditor.getControl();
            Rectangle rect = getLabel().getTextBounds().getCopy();
            getLabel().translateToAbsolute(rect);
            int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
            rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
            if (!rect.equals(new Rectangle(text.getBounds()))) {
                text.setBounds(rect.x, rect.y, rect.width, rect.height);
            }
        }
    }
}
