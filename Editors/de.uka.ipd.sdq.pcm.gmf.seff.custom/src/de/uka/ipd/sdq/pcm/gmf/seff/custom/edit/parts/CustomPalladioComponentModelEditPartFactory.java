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
 * @generated
 */
public class CustomPalladioComponentModelEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

			case ResourceDemandingSEFFEditPart.VISUAL_ID:
				return new ResourceDemandingSEFFEditPart(view);

			case CustomStartActionEditPart.VISUAL_ID:
				return new CustomStartActionEditPart(view);

			case CustomStopActionEditPart.VISUAL_ID:
				return new CustomStopActionEditPart(view);

			case ExternalCallActionEditPart.VISUAL_ID:
				return new ExternalCallActionEditPart(view);

			case CustomExternalCallActionEntityNameEditPart.VISUAL_ID:
				return new CustomExternalCallActionEntityNameEditPart(view);

			case EmitEventActionEditPart.VISUAL_ID:
				return new EmitEventActionEditPart(view);

			case EmitEventActionEntityNameEditPart.VISUAL_ID:
				return new EmitEventActionEntityNameEditPart(view);

			case LoopActionEditPart.VISUAL_ID:
				return new LoopActionEditPart(view);

			case LoopActionEntityNameEditPart.VISUAL_ID:
				return new LoopActionEntityNameEditPart(view);

			case CustomLoopIterationsLabelEditPart.VISUAL_ID:
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

			case CustomCollectionIteratorParameterLabel2EditPart.VISUAL_ID:
				return new CustomCollectionIteratorParameterLabel2EditPart(view);

			case SetVariableActionEditPart.VISUAL_ID:
				return new SetVariableActionEditPart(view);

			case SetVariableActionEntityNameEditPart.VISUAL_ID:
				return new SetVariableActionEntityNameEditPart(view);

			case AcquireActionEditPart.VISUAL_ID:
				return new AcquireActionEditPart(view);

			case CustomAcquireActionEntityNameEditPart.VISUAL_ID:
				return new CustomAcquireActionEntityNameEditPart(view);

			case ReleaseActionEditPart.VISUAL_ID:
				return new ReleaseActionEditPart(view);

			case CustomReleaseActionEntityNameEditPart.VISUAL_ID:
				return new CustomReleaseActionEntityNameEditPart(view);

			case ForkActionEditPart.VISUAL_ID:
				return new ForkActionEditPart(view);

			case ForkActionEntityNameEditPart.VISUAL_ID:
				return new ForkActionEntityNameEditPart(view);

			case RecoveryActionEditPart.VISUAL_ID:
				return new RecoveryActionEditPart(view);

			case RecoveryActionEntityNameEditPart.VISUAL_ID:
				return new RecoveryActionEntityNameEditPart(view);

			case CustomVariableUsageEditPart.VISUAL_ID:
				return new CustomVariableUsageEditPart(view);

			case VariableUsageLabelEditPart.VISUAL_ID:
				return new VariableUsageLabelEditPart(view);

			case CustomVariableCharacterisationEditPart.VISUAL_ID:
				return new CustomVariableCharacterisationEditPart(view);

			case CustomVariableUsage2EditPart.VISUAL_ID:
				return new CustomVariableUsage2EditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case CustomVariableCharacterisation2EditPart.VISUAL_ID:
				return new CustomVariableCharacterisation2EditPart(view);

			case CustomVariableUsage4EditPart.VISUAL_ID:
				return new CustomVariableUsage4EditPart(view);

			case CustomVariableUsage4LabelEditPart.VISUAL_ID:
				return new CustomVariableUsage4LabelEditPart(view);

			case CustomVariableCharacterisation3EditPart.VISUAL_ID:
				return new CustomVariableCharacterisation3EditPart(view);

			case ResourceDemandingBehaviourEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourEditPart(view);

			case CustomStartAction2EditPart.VISUAL_ID:
				return new CustomStartAction2EditPart(view);

			case CustomStopAction2EditPart.VISUAL_ID:
				return new CustomStopAction2EditPart(view);

			case LoopAction2EditPart.VISUAL_ID:
				return new LoopAction2EditPart(view);

			case LoopActionEntityName2EditPart.VISUAL_ID:
				return new LoopActionEntityName2EditPart(view);

			case CustomLoop2IterationsLabelEditPart.VISUAL_ID:
				return new CustomLoop2IterationsLabelEditPart(view);

			case InternalAction2EditPart.VISUAL_ID:
				return new InternalAction2EditPart(view);

			case InternalActionEntityName2EditPart.VISUAL_ID:
				return new InternalActionEntityName2EditPart(view);

			case CustomParametricResourceDemandEditPart.VISUAL_ID:
				return new CustomParametricResourceDemandEditPart(view);

			case CustomInternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
				return new CustomInternalFailureOccurrenceDescriptionEditPart(view);

			case InfrastructureCallEditPart.VISUAL_ID:
				return new InfrastructureCallEditPart(view);

			case CustomInfrastructureCallNumberOfCallsLabelEditPart.VISUAL_ID:
				return new CustomInfrastructureCallNumberOfCallsLabelEditPart(view);

			case CustomInfrastructureCallTargetLabelEditPart.VISUAL_ID:
				return new CustomInfrastructureCallTargetLabelEditPart(view);

			case CustomVariableUsage5EditPart.VISUAL_ID:
				return new CustomVariableUsage5EditPart(view);

			case CustomVariableUsage5LabelEditPart.VISUAL_ID:
				return new CustomVariableUsage5LabelEditPart(view);

			case CustomVariableCharacterisation4EditPart.VISUAL_ID:
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
				return new ProbabilisticBranchTransitionBranchProbabilityEditPart(
						view);

			case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviour2EditPart(view);

			case ExternalCallAction2EditPart.VISUAL_ID:
				return new ExternalCallAction2EditPart(view);

			case CustomExternalCallActionEntityName2EditPart.VISUAL_ID:
				return new CustomExternalCallActionEntityName2EditPart(view);

			case EmitEventAction2EditPart.VISUAL_ID:
				return new EmitEventAction2EditPart(view);

			case EmitEventActionEntityName2EditPart.VISUAL_ID:
				return new EmitEventActionEntityName2EditPart(view);

			case AcquireAction2EditPart.VISUAL_ID:
				return new AcquireAction2EditPart(view);

			case CustomAcquireActionEntityName2EditPart.VISUAL_ID:
				return new CustomAcquireActionEntityName2EditPart(view);

			case ReleaseAction2EditPart.VISUAL_ID:
				return new ReleaseAction2EditPart(view);

			case CustomReleaseActionEntityName2EditPart.VISUAL_ID:
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

			case CustomVariableUsage3EditPart.VISUAL_ID:
				return new CustomVariableUsage3EditPart(view);

			case CustomVariableUsage3LabelEditPart.VISUAL_ID:
				return new CustomVariableUsage3LabelEditPart(view);

			case CustomVariableCharacterisation5EditPart.VISUAL_ID:
				return new CustomVariableCharacterisation5EditPart(view);

			case SynchronisationPointEditPart.VISUAL_ID:
				return new SynchronisationPointEditPart(view);

			case ForkedBehaviour2EditPart.VISUAL_ID:
				return new ForkedBehaviour2EditPart(view);

			case GuardedBranchTransitionEditPart.VISUAL_ID:
				return new GuardedBranchTransitionEditPart(view);

			case GuardedBranchTransitionEntityNameEditPart.VISUAL_ID:
				return new GuardedBranchTransitionEntityNameEditPart(view);

			case CustomGuardedBranchTransitionIdEditPart.VISUAL_ID:
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
				return new ResourceDemandingBehaviourBehaviourCompartmentEditPart(
						view);

			case InternalActionResourceDemandEditPart.VISUAL_ID:
				return new InternalActionResourceDemandEditPart(view);

			case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
				return new InternalActionFailureOccurrenceDescriptionsEditPart(
						view);

			case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
				return new InternalActionInfrastructureCallsCompartmentEditPart(
						view);

			case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
				return new InfrastructureCallInfrastructureCallInputVariableUsagesEditPart(
						view);

			case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
				return new VariableUsageVariableCharacterisation5EditPart(view);

			case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartmentEditPart(view);

			case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartment2EditPart(
						view);

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
				return new ResourceDemandingBehaviourBehaviourCompartment3EditPart(
						view);

			case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
				return new RecoveryActionRecoveryBlockCompartmentEditPart(view);

			case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
				return new RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart(
						view);

			case SetVariableActionVariableSetterEditPart.VISUAL_ID:
				return new SetVariableActionVariableSetterEditPart(view);

			case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
				return new VariableUsageVariableCharacterisation3EditPart(view);

			case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
				return new SynchronisationPointSynchronisationPointEditPart(
						view);

			case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
				return new ForkedBehaviourSynchronisationPointForkedBehavioursEditPart(
						view);

			case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartment4EditPart(
						view);

			case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartment2EditPart(
						view);

			case InternalActionResourceDemand2EditPart.VISUAL_ID:
				return new InternalActionResourceDemand2EditPart(view);

			case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
				return new InternalActionFailureOccurrenceDescriptions2EditPart(
						view);

			case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
				return new InternalActionInfrastructureCallsCompartment2EditPart(
						view);

			case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
				return new SetVariableActionVariableSetter2EditPart(view);

			case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
				return new ForkActionForkedBehaviours2EditPart(view);

			case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
				return new RecoveryActionRecoveryBlockCompartment2EditPart(view);

			case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
				return new AbstractActionSuccessor_AbstractActionEditPart(view);

			case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
				return new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart(
						view);

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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}

	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
