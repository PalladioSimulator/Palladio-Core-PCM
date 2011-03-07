/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

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

			case ResourceDemandingSEFFEditPart.VISUAL_ID:
				return new ResourceDemandingSEFFEditPart(view);

			case StartActionEditPart.VISUAL_ID:
				return new StartActionEditPart(view);

			case StopActionEditPart.VISUAL_ID:
				return new StopActionEditPart(view);

			case ExternalCallActionEditPart.VISUAL_ID:
				return new ExternalCallActionEditPart(view);

			case ExternalCallActionEntityNameEditPart.VISUAL_ID:
				return new ExternalCallActionEntityNameEditPart(view);

			case LoopActionEditPart.VISUAL_ID:
				return new LoopActionEditPart(view);

			case LoopActionEntityNameEditPart.VISUAL_ID:
				return new LoopActionEntityNameEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

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

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case SetVariableActionEditPart.VISUAL_ID:
				return new SetVariableActionEditPart(view);

			case SetVariableActionEntityNameEditPart.VISUAL_ID:
				return new SetVariableActionEntityNameEditPart(view);

			case AcquireActionEditPart.VISUAL_ID:
				return new AcquireActionEditPart(view);

			case AcquireActionEntityNameEditPart.VISUAL_ID:
				return new AcquireActionEntityNameEditPart(view);

			case ReleaseActionEditPart.VISUAL_ID:
				return new ReleaseActionEditPart(view);

			case ReleaseActionEntityNameEditPart.VISUAL_ID:
				return new ReleaseActionEntityNameEditPart(view);

			case ForkActionEditPart.VISUAL_ID:
				return new ForkActionEditPart(view);

			case ForkActionEntityNameEditPart.VISUAL_ID:
				return new ForkActionEntityNameEditPart(view);

			case VariableUsageEditPart.VISUAL_ID:
				return new VariableUsageEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case VariableCharacterisationEditPart.VISUAL_ID:
				return new VariableCharacterisationEditPart(view);

			case VariableUsage2EditPart.VISUAL_ID:
				return new VariableUsage2EditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case VariableCharacterisation2EditPart.VISUAL_ID:
				return new VariableCharacterisation2EditPart(view);

			case ResourceDemandingBehaviourEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourEditPart(view);

			case StartAction2EditPart.VISUAL_ID:
				return new StartAction2EditPart(view);

			case StopAction2EditPart.VISUAL_ID:
				return new StopAction2EditPart(view);

			case LoopAction2EditPart.VISUAL_ID:
				return new LoopAction2EditPart(view);

			case LoopActionEntityName2EditPart.VISUAL_ID:
				return new LoopActionEntityName2EditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case InternalAction2EditPart.VISUAL_ID:
				return new InternalAction2EditPart(view);

			case InternalActionEntityName2EditPart.VISUAL_ID:
				return new InternalActionEntityName2EditPart(view);

			case ParametricResourceDemandEditPart.VISUAL_ID:
				return new ParametricResourceDemandEditPart(view);

			case FailureOccurrenceDescriptionEditPart.VISUAL_ID:
				return new FailureOccurrenceDescriptionEditPart(view);

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
				return new ExternalCallActionEntityName2EditPart(view);

			case AcquireAction2EditPart.VISUAL_ID:
				return new AcquireAction2EditPart(view);

			case AcquireActionEntityName2EditPart.VISUAL_ID:
				return new AcquireActionEntityName2EditPart(view);

			case ReleaseAction2EditPart.VISUAL_ID:
				return new ReleaseAction2EditPart(view);

			case ReleaseActionEntityName2EditPart.VISUAL_ID:
				return new ReleaseActionEntityName2EditPart(view);

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

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviour3EditPart(view);

			case SetVariableAction2EditPart.VISUAL_ID:
				return new SetVariableAction2EditPart(view);

			case SetVariableActionEntityName2EditPart.VISUAL_ID:
				return new SetVariableActionEntityName2EditPart(view);

			case VariableUsage3EditPart.VISUAL_ID:
				return new VariableUsage3EditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case VariableCharacterisation3EditPart.VISUAL_ID:
				return new VariableCharacterisation3EditPart(view);

			case GuardedBranchTransitionEditPart.VISUAL_ID:
				return new GuardedBranchTransitionEditPart(view);

			case GuardedBranchTransitionEntityNameEditPart.VISUAL_ID:
				return new GuardedBranchTransitionEntityNameEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

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

			case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartmentEditPart(view);

			case InternalActionResourceDemandEditPart.VISUAL_ID:
				return new InternalActionResourceDemandEditPart(view);

			case InternalActionFailureOccurrencesEditPart.VISUAL_ID:
				return new InternalActionFailureOccurrencesEditPart(view);

			case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartmentEditPart(view);

			case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartment2EditPart(view);

			case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
				return new ExternalCallActionInputVariableUsage2EditPart(view);

			case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
				return new ExternalCallActionOutputVariableUsage2EditPart(view);

			case ForkActionForkedBehavioursEditPart.VISUAL_ID:
				return new ForkActionForkedBehavioursEditPart(view);

			case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
				return new ForkedBehaviourBehaviourCompartmentEditPart(view);

			case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartment3EditPart(view);

			case SetVariableActionVariableSetterEditPart.VISUAL_ID:
				return new SetVariableActionVariableSetterEditPart(view);

			case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
				return new VariableUsageVariableCharacterisation3EditPart(view);

			case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBehaviourCompartment4EditPart(view);

			case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartment2EditPart(view);

			case InternalActionResourceDemand2EditPart.VISUAL_ID:
				return new InternalActionResourceDemand2EditPart(view);

			case InternalActionFailureOccurrences2EditPart.VISUAL_ID:
				return new InternalActionFailureOccurrences2EditPart(view);

			case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
				return new SetVariableActionVariableSetter2EditPart(view);

			case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
				return new ForkActionForkedBehaviours2EditPart(view);

			case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
				return new AbstractActionSuccessor_AbstractActionEditPart(view);

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
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
