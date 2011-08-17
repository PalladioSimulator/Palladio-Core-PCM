/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;

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

			case ResourceEnvironmentEditPart.VISUAL_ID:
				return new ResourceEnvironmentEditPart(view);

			case ResourceContainerEditPart.VISUAL_ID:
				return new ResourceContainerEditPart(view);

			case ResourceContainerEntityNameEditPart.VISUAL_ID:
				return new ResourceContainerEntityNameEditPart(view);

			case LinkingResource2EditPart.VISUAL_ID:
				return new LinkingResource2EditPart(view);

			case ProcessingResourceSpecificationEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationEditPart(view);

			case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationMTTFEditPart(view);

			case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationMTTREditPart(view);

			case ProcessingResourceSpecificationSchedulingPolicyEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationSchedulingPolicyEditPart(
						view);

			case ProcessingResourceSpecificationNumberOfReplicasEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationNumberOfReplicasEditPart(
						view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case ProcessingResourceSpecificationActiveResourceTypeLabelEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationActiveResourceTypeLabelEditPart(
						view);

			case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
				return new CommunicationLinkResourceSpecificationEditPart(view);

			case CommunicationLinkResourceSpecificationFailureProbabilityEditPart.VISUAL_ID:
				return new CommunicationLinkResourceSpecificationFailureProbabilityEditPart(
						view);

			case CommunicationLinkResourceSpecificationLatencyLabelEditPart.VISUAL_ID:
				return new CommunicationLinkResourceSpecificationLatencyLabelEditPart(
						view);

			case CommunicationLinkResourceSpecificationThroughputLabelEditPart.VISUAL_ID:
				return new CommunicationLinkResourceSpecificationThroughputLabelEditPart(
						view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
				return new ResourceContainerResourceContainerCompartmentEditPart(
						view);

			case ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart(
						view);

			case LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
				return new LinkingResourceNetworkSwitchCompartmentEditPart(view);

			case LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID:
				return new LinkingResourceConnectedResourceContainers_LinkingResourceEditPart(
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
