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
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
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

			case LinkingResourceEditPart.VISUAL_ID:
				return new LinkingResourceEditPart(view);

			case LinkingResourceEntityNameEditPart.VISUAL_ID:
				return new LinkingResourceEntityNameEditPart(view);

			case ProcessingResourceSpecificationEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationEditPart(view);

			case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationMTTFEditPart(view);

			case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationMTTREditPart(view);

			case ProcessingResourceSpecificationSchedulingPolicyLabelEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationSchedulingPolicyLabelEditPart(
						view);

			case ProcessingResourceSpecificationNumberOfReplicasEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationNumberOfReplicasEditPart(
						view);

			case ProcessingResourceSpecificationProcessingRateLabelEditPart.VISUAL_ID:
				return new ProcessingResourceSpecificationProcessingRateLabelEditPart(
						view);

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

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

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
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}
}
