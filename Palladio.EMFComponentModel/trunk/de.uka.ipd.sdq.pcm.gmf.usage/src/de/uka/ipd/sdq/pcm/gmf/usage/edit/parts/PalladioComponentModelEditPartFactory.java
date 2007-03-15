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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

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

			case ScenarioBehaviourEditPart.VISUAL_ID:
				return new ScenarioBehaviourEditPart(view);

			case ScenarioBehaviourId3EditPart.VISUAL_ID:
				return new ScenarioBehaviourId3EditPart(view);

			case ClosedWorkloadEditPart.VISUAL_ID:
				return new ClosedWorkloadEditPart(view);

			case ClosedWorkloadPopulationEditPart.VISUAL_ID:
				return new ClosedWorkloadPopulationEditPart(view);

			case ClosedWorkloadTitleLabelEditPart.VISUAL_ID:
				return new ClosedWorkloadTitleLabelEditPart(view);

			case OpenWorkloadEditPart.VISUAL_ID:
				return new OpenWorkloadEditPart(view);

			case StartEditPart.VISUAL_ID:
				return new StartEditPart(view);

			case StopEditPart.VISUAL_ID:
				return new StopEditPart(view);

			case EntryLevelSystemCallEditPart.VISUAL_ID:
				return new EntryLevelSystemCallEditPart(view);

			case VariableUsageEditPart.VISUAL_ID:
				return new VariableUsageEditPart(view);

			case VariableCharacterisationEditPart.VISUAL_ID:
				return new VariableCharacterisationEditPart(view);

			case LoopEditPart.VISUAL_ID:
				return new LoopEditPart(view);

			case ScenarioBehaviour2EditPart.VISUAL_ID:
				return new ScenarioBehaviour2EditPart(view);

			case ScenarioBehaviourId2EditPart.VISUAL_ID:
				return new ScenarioBehaviourId2EditPart(view);

			case BranchEditPart.VISUAL_ID:
				return new BranchEditPart(view);

			case BranchTransitionEditPart.VISUAL_ID:
				return new BranchTransitionEditPart(view);

			case ScenarioBehaviour3EditPart.VISUAL_ID:
				return new ScenarioBehaviour3EditPart(view);

			case ScenarioBehaviourIdEditPart.VISUAL_ID:
				return new ScenarioBehaviourIdEditPart(view);

			case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
				return new ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart(
						view);

			case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
				return new EntryLevelSystemCallParameterUsageEditPart(view);

			case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
				return new VariableUsageVariableCharacterisationEditPart(view);

			case LoopLoopCompartmentEditPart.VISUAL_ID:
				return new LoopLoopCompartmentEditPart(view);

			case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
				return new ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart(
						view);

			case BranchBranchCompartmentEditPart.VISUAL_ID:
				return new BranchBranchCompartmentEditPart(view);

			case BranchTransitionBranchTransitionCompartmentEditPart.VISUAL_ID:
				return new BranchTransitionBranchTransitionCompartmentEditPart(
						view);

			case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
				return new ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart(
						view);

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
