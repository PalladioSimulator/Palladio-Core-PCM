/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.*;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * A factory for creating CustomPalladioComponentModelEditPart objects class.
 * 
 * @generated
 */
public class CustomPalladioComponentModelEditPartFactory implements EditPartFactory {

    /**
     * Creates a new customized palladio component model edit part object.
     * 
     * @param context
     *            the context
     * @param model
     *            the model
     * @return the edit part
     * @generated
     */
    @Override
    public EditPart createEditPart(final EditPart context, final Object model) {
        if (model instanceof View) {
            final View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case ResourceDemandingSEFFEditPart.VISUAL_ID:
                return new ResourceDemandingSEFFEditPart(view);

            case StartActionEditPart.VISUAL_ID:
                return new CustomStartActionEditPart(view);

            case StopActionEditPart.VISUAL_ID:
                return new CustomStopActionEditPart(view);

            case ExternalCallActionEditPart.VISUAL_ID:
                return new ExternalCallActionEditPart(view);

            case ExternalCallActionEntityNameEditPart.VISUAL_ID:
                return new CustomExternalCallActionEntityNameEditPart(view);

            case EmitEventActionEditPart.VISUAL_ID:
                return new EmitEventActionEditPart(view);

            case EmitEventActionEntityNameEditPart.VISUAL_ID:
                return new EmitEventActionEntityNameEditPart(view);

            case LoopActionEditPart.VISUAL_ID:
                return new LoopActionEditPart(view);

            case LoopActionEntityNameEditPart.VISUAL_ID:
                return new LoopActionEntityNameEditPart(view);

            case LoopIterationsLabelEditPart.VISUAL_ID:
                return new CustomLoopIterationsLabelEditPart(view);

            case BranchActionEditPart.VISUAL_ID:
                return new BranchActionEditPart(view);

            case BranchActionEntityNameEditPart.VISUAL_ID:
                return new BranchActionEntityNameEditPart(view);

            case InternalActionEditPart.VISUAL_ID:
                return new InternalActionEditPart(view);

            case InternalActionEntityNameEditPart.VISUAL_ID:
                return new InternalActionEntityNameEditPart(view);

            case CollectionIteratorActionEditPart.VISUAL_ID:
                return new CollectionIteratorActionEditPart(view);

            case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
                return new CollectionIteratorActionEntityNameEditPart(view);

            case CollectionIteratorParameterLabel2EditPart.VISUAL_ID:
                return new CustomCollectionIteratorParameterLabel2EditPart(view);

            case SetVariableActionEditPart.VISUAL_ID:
                return new SetVariableActionEditPart(view);

            case SetVariableActionEntityNameEditPart.VISUAL_ID:
                return new SetVariableActionEntityNameEditPart(view);

            case AcquireActionEditPart.VISUAL_ID:
                return new AcquireActionEditPart(view);

            case AcquireActionEntityNameEditPart.VISUAL_ID:
                return new CustomAcquireActionEntityNameEditPart(view);

            case ReleaseActionEditPart.VISUAL_ID:
                return new ReleaseActionEditPart(view);

            case ReleaseActionEntityNameEditPart.VISUAL_ID:
                return new CustomReleaseActionEntityNameEditPart(view);

            case ForkActionEditPart.VISUAL_ID:
                return new ForkActionEditPart(view);

            case ForkActionEntityNameEditPart.VISUAL_ID:
                return new ForkActionEntityNameEditPart(view);

            case RecoveryActionEditPart.VISUAL_ID:
                return new RecoveryActionEditPart(view);

            case RecoveryActionEntityNameEditPart.VISUAL_ID:
                return new RecoveryActionEntityNameEditPart(view);

            case VariableUsageEditPart.VISUAL_ID:
                return new CustomVariableUsageEditPart(view);

            case VariableUsageLabelEditPart.VISUAL_ID:
                return new VariableUsageLabelEditPart(view);

            case VariableCharacterisationEditPart.VISUAL_ID:
                return new CustomVariableCharacterisationEditPart(view);

            case VariableUsage2EditPart.VISUAL_ID:
                return new CustomVariableUsage2EditPart(view);

            case WrappingLabelEditPart.VISUAL_ID:
                return new WrappingLabelEditPart(view);

            case VariableCharacterisation2EditPart.VISUAL_ID:
                return new CustomVariableCharacterisation2EditPart(view);

            case VariableUsage4EditPart.VISUAL_ID:
                return new CustomVariableUsage4EditPart(view);

            case VariableUsage4LabelEditPart.VISUAL_ID:
                return new CustomVariableUsage4LabelEditPart(view);

            case VariableCharacterisation3EditPart.VISUAL_ID:
                return new CustomVariableCharacterisation3EditPart(view);

            case ResourceDemandingBehaviourEditPart.VISUAL_ID:
                return new ResourceDemandingBehaviourEditPart(view);

            case StartAction2EditPart.VISUAL_ID:
                return new CustomStartAction2EditPart(view);

            case StopAction2EditPart.VISUAL_ID:
                return new CustomStopAction2EditPart(view);

            case LoopAction2EditPart.VISUAL_ID:
                return new LoopAction2EditPart(view);

            case LoopActionEntityName2EditPart.VISUAL_ID:
                return new LoopActionEntityName2EditPart(view);

            case Loop2IterationsLabelEditPart.VISUAL_ID:
                return new CustomLoop2IterationsLabelEditPart(view);

            case InternalAction2EditPart.VISUAL_ID:
                return new InternalAction2EditPart(view);

            case InternalActionEntityName2EditPart.VISUAL_ID:
                return new InternalActionEntityName2EditPart(view);

            case ParametricResourceDemandEditPart.VISUAL_ID:
                return new CustomParametricResourceDemandEditPart(view);

            case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
                return new CustomInternalFailureOccurrenceDescriptionEditPart(view);

            case InfrastructureCallEditPart.VISUAL_ID:
                return new InfrastructureCallEditPart(view);

            case WrappingLabel2EditPart.VISUAL_ID /*InfrastructureCallNumberOfCallsLabelEditPart.VISUAL_ID*/:
                return new CustomInfrastructureCallNumberOfCallsLabelEditPart(view);

            case WrappingLabel3EditPart.VISUAL_ID /*InfrastructureCallTargetLabelEditPart.VISUAL_ID*/:
                return new CustomInfrastructureCallTargetLabelEditPart(view);

            case VariableUsage5EditPart.VISUAL_ID:
                return new CustomVariableUsage5EditPart(view);

            case VariableUsage5LabelEditPart.VISUAL_ID:
                return new CustomVariableUsage5LabelEditPart(view);

            case VariableCharacterisation4EditPart.VISUAL_ID:
                return new CustomVariableCharacterisation4EditPart(view);

            case BranchAction2EditPart.VISUAL_ID:
                return new BranchAction2EditPart(view);

            case BranchActionEntityName2EditPart.VISUAL_ID:
                return new BranchActionEntityName2EditPart(view);

            case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
                return new ProbabilisticBranchTransitionEditPart(view);

            case ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID:
                return new ProbabilisticBranchTransitionEntityNameEditPart(view);

            case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
                return new ProbabilisticBranchTransitionBranchProbabilityEditPart(view);

            case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviour2EditPart(view);

            case ExternalCallAction2EditPart.VISUAL_ID:
                return new ExternalCallAction2EditPart(view);

            case ExternalCallActionEntityName2EditPart.VISUAL_ID:
                return new CustomExternalCallActionEntityName2EditPart(view);

            case EmitEventAction2EditPart.VISUAL_ID:
                return new EmitEventAction2EditPart(view);

            case EmitEventActionEntityName2EditPart.VISUAL_ID:
                return new EmitEventActionEntityName2EditPart(view);

            case AcquireAction2EditPart.VISUAL_ID:
                return new AcquireAction2EditPart(view);

            case AcquireActionEntityName2EditPart.VISUAL_ID:
                return new CustomAcquireActionEntityName2EditPart(view);

            case ReleaseAction2EditPart.VISUAL_ID:
                return new ReleaseAction2EditPart(view);

            case ReleaseActionEntityName2EditPart.VISUAL_ID:
                return new CustomReleaseActionEntityName2EditPart(view);

            case ForkAction2EditPart.VISUAL_ID:
                return new ForkAction2EditPart(view);

            case ForkActionEntityName2EditPart.VISUAL_ID:
                return new ForkActionEntityName2EditPart(view);

            case ForkedBehaviourEditPart.VISUAL_ID:
                return new ForkedBehaviourEditPart(view);

            case CollectionIteratorAction2EditPart.VISUAL_ID:
                return new CollectionIteratorAction2EditPart(view);

            case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
                return new CollectionIteratorActionEntityName2EditPart(view);

            case CollectionIteratorParameterLabelEditPart.VISUAL_ID:
                return new CollectionIteratorParameterLabelEditPart(view);

            case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviour3EditPart(view);

            case RecoveryAction2EditPart.VISUAL_ID:
                return new RecoveryAction2EditPart(view);

            case RecoveryActionEntityName2EditPart.VISUAL_ID:
                return new RecoveryActionEntityName2EditPart(view);

            case RecoveryActionBehaviourEditPart.VISUAL_ID:
                return new RecoveryActionBehaviourEditPart(view);

            case RecoveryActionBehaviourEntityNameEditPart.VISUAL_ID:
                return new RecoveryActionBehaviourEntityNameEditPart(view);

            case SetVariableAction2EditPart.VISUAL_ID:
                return new SetVariableAction2EditPart(view);

            case SetVariableActionEntityName2EditPart.VISUAL_ID:
                return new SetVariableActionEntityName2EditPart(view);

            case VariableUsage3EditPart.VISUAL_ID:
                return new CustomVariableUsage3EditPart(view);

            case VariableUsage3LabelEditPart.VISUAL_ID:
                return new CustomVariableUsage3LabelEditPart(view);

            case VariableCharacterisation5EditPart.VISUAL_ID:
                return new CustomVariableCharacterisation5EditPart(view);

            case SynchronisationPointEditPart.VISUAL_ID:
                return new SynchronisationPointEditPart(view);

            case ForkedBehaviour2EditPart.VISUAL_ID:
                return new ForkedBehaviour2EditPart(view);

            case GuardedBranchTransitionEditPart.VISUAL_ID:
                return new GuardedBranchTransitionEditPart(view);

            case GuardedBranchTransitionEntityNameEditPart.VISUAL_ID:
                return new GuardedBranchTransitionEntityNameEditPart(view);

            case GuardedBranchTransitionIdEditPart.VISUAL_ID:
                return new CustomGuardedBranchTransitionIdEditPart(view);

            case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviour4EditPart(view);

            case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
                return new ExternalCallActionInputVariableUsageEditPart(view);

            case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
                return new ExternalCallActionOutputVariableUsageEditPart(view);

            case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisationEditPart(view);

            case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisation2EditPart(view);

            case EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID:
                return new EmitEventActionInputVariableUsageEventEditPart(view);

            case VariableUsageVariableCharacterisation4EditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisation4EditPart(view);

            case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
                return new ResourceDemandingBehaviourBehaviourCompartmentEditPart(view);

            case InternalActionResourceDemandEditPart.VISUAL_ID:
                return new InternalActionResourceDemandEditPart(view);

            case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
                return new InternalActionFailureOccurrenceDescriptionsEditPart(view);

            case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
                return new InternalActionInfrastructureCallsCompartmentEditPart(view);

            case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
                return new InfrastructureCallInfrastructureCallInputVariableUsagesEditPart(view);

            case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisation5EditPart(view);

            case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
                return new BranchActionBranchTransitionCompartmentEditPart(view);

            case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviourBehaviourCompartment2EditPart(view);

            case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
                return new ExternalCallActionInputVariableUsage2EditPart(view);

            case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
                return new ExternalCallActionOutputVariableUsage2EditPart(view);

            case EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID:
                return new EmitEventActionInputVariableUsageEvent2EditPart(view);

            case ForkActionForkedBehavioursEditPart.VISUAL_ID:
                return new ForkActionForkedBehavioursEditPart(view);

            case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
                return new ForkedBehaviourBehaviourCompartmentEditPart(view);

            case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviourBehaviourCompartment3EditPart(view);

            case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
                return new RecoveryActionRecoveryBlockCompartmentEditPart(view);

            case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
                return new RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart(view);

            case SetVariableActionVariableSetterEditPart.VISUAL_ID:
                return new SetVariableActionVariableSetterEditPart(view);

            case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
                return new VariableUsageVariableCharacterisation3EditPart(view);

            case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
                return new SynchronisationPointSynchronisationPointEditPart(view);

            case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
                return new ForkedBehaviourSynchronisationPointForkedBehavioursEditPart(view);

            case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
                return new ResourceDemandingBehaviourBehaviourCompartment4EditPart(view);

            case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
                return new BranchActionBranchTransitionCompartment2EditPart(view);

            case InternalActionResourceDemand2EditPart.VISUAL_ID:
                return new InternalActionResourceDemand2EditPart(view);

            case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
                return new InternalActionFailureOccurrenceDescriptions2EditPart(view);

            case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
                return new InternalActionInfrastructureCallsCompartment2EditPart(view);

            case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
                return new SetVariableActionVariableSetter2EditPart(view);

            case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
                return new ForkActionForkedBehaviours2EditPart(view);

            case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
                return new RecoveryActionRecoveryBlockCompartment2EditPart(view);

            case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
                return new AbstractActionSuccessor_AbstractActionEditPart(view);

            case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
                return new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart(view);

            }
        }
        return this.createUnrecognizedEditPart(context, model);
    }

    /**
     * Handles the creation of unrecognized child node edit parts.
     * 
     * @param context
     *            the context
     * @param model
     *            the model
     * @return the edits the part
     * @generated
     */
    private EditPart createUnrecognizedEditPart(final EditPart context, final Object model) {
        return null;
    }

    /**
     * Gets the text cell editor locator.
     * 
     * @param source
     *            the source
     * @return the text cell editor locator
     * @generated
     */
    public static CellEditorLocator getTextCellEditorLocator(final ITextAwareEditPart source) {
        if (source.getFigure() instanceof WrappingLabel) {
            return new TextCellEditorLocator((WrappingLabel) source.getFigure());
        } else {
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
        private final WrappingLabel wrapLabel;

        /**
         * Instantiates a new text cell editor locator.
         * 
         * @param wrapLabel
         *            the wrap label
         * @generated
         */
        public TextCellEditorLocator(final WrappingLabel wrapLabel) {
            this.wrapLabel = wrapLabel;
        }

        /**
         * Gets the wrap label.
         * 
         * @return the wrap label
         * @generated
         */
        public WrappingLabel getWrapLabel() {
            return this.wrapLabel;
        }

        /**
         * Relocate.
         * 
         * @param celleditor
         *            the celleditor
         * @generated
         */
        @Override
        public void relocate(final CellEditor celleditor) {
            final Text text = (Text) celleditor.getControl();
            final Rectangle rect = this.getWrapLabel().getTextBounds().getCopy();
            this.getWrapLabel().translateToAbsolute(rect);
            if (this.getWrapLabel().isTextWrapOn() && this.getWrapLabel().getText().length() > 0) {
                rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
            } else {
                final int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
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
        private final Label label;

        /**
         * Instantiates a new label cell editor locator.
         * 
         * @param label
         *            the label
         * @generated
         */
        public LabelCellEditorLocator(final Label label) {
            this.label = label;
        }

        /**
         * Gets the label.
         * 
         * @return the label
         * @generated
         */
        public Label getLabel() {
            return this.label;
        }

        /**
         * Relocate.
         * 
         * @param celleditor
         *            the celleditor
         * @generated
         */
        @Override
        public void relocate(final CellEditor celleditor) {
            final Text text = (Text) celleditor.getControl();
            final Rectangle rect = this.getLabel().getTextBounds().getCopy();
            this.getLabel().translateToAbsolute(rect);
            final int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
            rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
            if (!rect.equals(new Rectangle(text.getBounds()))) {
                text.setBounds(rect.x, rect.y, rect.width, rect.height);
            }
        }
    }
}
