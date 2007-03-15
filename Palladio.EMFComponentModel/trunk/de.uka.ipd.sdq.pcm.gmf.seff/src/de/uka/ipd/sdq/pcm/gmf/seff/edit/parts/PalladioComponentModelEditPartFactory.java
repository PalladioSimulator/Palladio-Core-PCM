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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
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

			case LoopActionEntityName2EditPart.VISUAL_ID:
				return new LoopActionEntityName2EditPart(view);

			case LoopIterationsLabel2EditPart.VISUAL_ID:
				return new LoopIterationsLabel2EditPart(view);

			case BranchAction2EditPart.VISUAL_ID:
				return new BranchAction2EditPart(view);

			case BranchActionEntityName2EditPart.VISUAL_ID:
				return new BranchActionEntityName2EditPart(view);

			case InternalAction2EditPart.VISUAL_ID:
				return new InternalAction2EditPart(view);

			case InternalActionEntityName2EditPart.VISUAL_ID:
				return new InternalActionEntityName2EditPart(view);

			case CollectionIteratorAction2EditPart.VISUAL_ID:
				return new CollectionIteratorAction2EditPart(view);

			case CollectionIteratorActionEntityName2EditPart.VISUAL_ID:
				return new CollectionIteratorActionEntityName2EditPart(view);

			case CollectionIteratorParameterLabel2EditPart.VISUAL_ID:
				return new CollectionIteratorParameterLabel2EditPart(view);

			case VariableUsageEditPart.VISUAL_ID:
				return new VariableUsageEditPart(view);

			case VariableUsageReferenceLabelEditPart.VISUAL_ID:
				return new VariableUsageReferenceLabelEditPart(view);

			case VariableCharacterisationEditPart.VISUAL_ID:
				return new VariableCharacterisationEditPart(view);

			case ResourceDemandingBehaviourEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourEditPart(view);

			case StartAction2EditPart.VISUAL_ID:
				return new StartAction2EditPart(view);

			case StopAction2EditPart.VISUAL_ID:
				return new StopAction2EditPart(view);

			case LoopAction2EditPart.VISUAL_ID:
				return new LoopAction2EditPart(view);

			case LoopActionEntityNameEditPart.VISUAL_ID:
				return new LoopActionEntityNameEditPart(view);

			case LoopIterationsLabelEditPart.VISUAL_ID:
				return new LoopIterationsLabelEditPart(view);

			case InternalActionEditPart.VISUAL_ID:
				return new InternalActionEditPart(view);

			case InternalActionEntityNameEditPart.VISUAL_ID:
				return new InternalActionEntityNameEditPart(view);

			case ParametricResourceDemandEditPart.VISUAL_ID:
				return new ParametricResourceDemandEditPart(view);

			case BranchActionEditPart.VISUAL_ID:
				return new BranchActionEditPart(view);

			case BranchActionEntityNameEditPart.VISUAL_ID:
				return new BranchActionEntityNameEditPart(view);

			case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
				return new ProbabilisticBranchTransitionEditPart(view);

			case ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID:
				return new ProbabilisticBranchTransitionBranchProbabilityEditPart(
						view);

			case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviour2EditPart(view);

			case ExternalCallAction2EditPart.VISUAL_ID:
				return new ExternalCallAction2EditPart(view);

			case ExternalCallActionEntityName2EditPart.VISUAL_ID:
				return new ExternalCallActionEntityName2EditPart(view);

			case CollectionIteratorActionEditPart.VISUAL_ID:
				return new CollectionIteratorActionEditPart(view);

			case CollectionIteratorActionEntityNameEditPart.VISUAL_ID:
				return new CollectionIteratorActionEntityNameEditPart(view);

			case CollectionIteratorParameterLabelEditPart.VISUAL_ID:
				return new CollectionIteratorParameterLabelEditPart(view);

			case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviour3EditPart(view);

			case ExternalCallActionParameterUsageEditPart.VISUAL_ID:
				return new ExternalCallActionParameterUsageEditPart(view);

			case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
				return new VariableUsageVariableCharacterisationEditPart(view);

			case LoopActionBehaviourCompartmentEditPart.VISUAL_ID:
				return new LoopActionBehaviourCompartmentEditPart(view);

			case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourLoopCompartmentEditPart(
						view);

			case LoopActionBehaviourCompartment2EditPart.VISUAL_ID:
				return new LoopActionBehaviourCompartment2EditPart(view);

			case InternalActionResourceDemandEditPart.VISUAL_ID:
				return new InternalActionResourceDemandEditPart(view);

			case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartmentEditPart(view);

			case ProbabilisticBranchTransitionBehaviourCompartmentEditPart.VISUAL_ID:
				return new ProbabilisticBranchTransitionBehaviourCompartmentEditPart(
						view);

			case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBranchCompartmentEditPart(
						view);

			case ExternalCallActionParameterUsage2EditPart.VISUAL_ID:
				return new ExternalCallActionParameterUsage2EditPart(view);

			case CollectionIteratorActionBehaviourCompartmentEditPart.VISUAL_ID:
				return new CollectionIteratorActionBehaviourCompartmentEditPart(
						view);

			case ResourceDemandingBehaviourLoopCompartment2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourLoopCompartment2EditPart(
						view);

			case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartment2EditPart(
						view);

			case InternalActionResourceDemand2EditPart.VISUAL_ID:
				return new InternalActionResourceDemand2EditPart(view);

			case CollectionIteratorActionBehaviourCompartment2EditPart.VISUAL_ID:
				return new CollectionIteratorActionBehaviourCompartment2EditPart(
						view);

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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrapLabel)
			return new TextCellEditorLocator((WrapLabel) source.getFigure());
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
		private WrapLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrapLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrapLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapped()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						org.eclipse.swt.SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(
						org.eclipse.swt.SWT.DEFAULT,
						org.eclipse.swt.SWT.DEFAULT)).expand(avr * 2, 0));
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
			rect.setSize(new Dimension(text.computeSize(
					org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT))
					.expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
