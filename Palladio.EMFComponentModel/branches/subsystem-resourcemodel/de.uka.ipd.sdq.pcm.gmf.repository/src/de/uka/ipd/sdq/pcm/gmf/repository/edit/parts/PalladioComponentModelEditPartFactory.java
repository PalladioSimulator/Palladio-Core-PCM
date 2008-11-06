/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

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

			case RepositoryEditPart.VISUAL_ID:
				return new RepositoryEditPart(view);

			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);

			case InterfaceEntityNameEditPart.VISUAL_ID:
				return new InterfaceEntityNameEditPart(view);

			case BasicComponentEditPart.VISUAL_ID:
				return new BasicComponentEditPart(view);

			case BasicComponentEntityNameEditPart.VISUAL_ID:
				return new BasicComponentEntityNameEditPart(view);

			case CompositeComponentEditPart.VISUAL_ID:
				return new CompositeComponentEditPart(view);

			case CompositeComponentEntityNameEditPart.VISUAL_ID:
				return new CompositeComponentEntityNameEditPart(view);

			case CompleteComponentTypeEditPart.VISUAL_ID:
				return new CompleteComponentTypeEditPart(view);

			case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
				return new CompleteComponentTypeEntityNameEditPart(view);

			case ProvidesComponentTypeEditPart.VISUAL_ID:
				return new ProvidesComponentTypeEditPart(view);

			case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
				return new ProvidesComponentTypeEntityNameEditPart(view);

			case SignatureEditPart.VISUAL_ID:
				return new SignatureEditPart(view);

			case ResourceDemandingSEFFEditPart.VISUAL_ID:
				return new ResourceDemandingSEFFEditPart(view);

			case PassiveResourceEditPart.VISUAL_ID:
				return new PassiveResourceEditPart(view);

			case VariableUsageEditPart.VISUAL_ID:
				return new VariableUsageEditPart(view);

			case WrapLabelEditPart.VISUAL_ID:
				return new WrapLabelEditPart(view);

			case VariableCharacterisationEditPart.VISUAL_ID:
				return new VariableCharacterisationEditPart(view);

			case InterfaceSignatureListEditPart.VISUAL_ID:
				return new InterfaceSignatureListEditPart(view);

			case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
				return new BasicComponentSEFFCompartmentEditPart(view);

			case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
				return new BasicComponentPassiveResourceCompartmentEditPart(
						view);

			case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
				return new BasicComponentComponentParameterCompartmentEditPart(
						view);

			case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
				return new VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart(
						view);

			case ProvidedRoleEditPart.VISUAL_ID:
				return new ProvidedRoleEditPart(view);

			case ProvidesStereotypeLabelEditPart.VISUAL_ID:
				return new ProvidesStereotypeLabelEditPart(view);

			case RequiredRoleEditPart.VISUAL_ID:
				return new RequiredRoleEditPart(view);

			case RequiresStereotypeLabelEditPart.VISUAL_ID:
				return new RequiresStereotypeLabelEditPart(view);

			case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
				return new ImplementationComponentTypeParentCompleteComponentTypesEditPart(
						view);

			case CompleteParentStereotypeLabelEditPart.VISUAL_ID:
				return new CompleteParentStereotypeLabelEditPart(view);

			case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
				return new CompleteComponentTypeParentProvidesComponentTypesEditPart(
						view);

			case ProvidesParentStereotypeLabelEditPart.VISUAL_ID:
				return new ProvidesParentStereotypeLabelEditPart(view);

			case ResourceRequiredRoleEditPart.VISUAL_ID:
				return new ResourceRequiredRoleEditPart(view);

			case WrapLabel2EditPart.VISUAL_ID:
				return new WrapLabel2EditPart(view);
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
