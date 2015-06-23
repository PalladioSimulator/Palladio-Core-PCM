/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceConnectedResourceContainers_LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.PalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTFEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTREditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationNumberOfReplicasEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.WrappingLabel6EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;

// TODO: Auto-generated Javadoc
/**
 * An edit part factory.
 */
public class CustomPalladioComponentModelEditPartFactory extends PalladioComponentModelEditPartFactory {

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.PalladioComponentModelEditPartFactory#createEditPart
     * (org.eclipse.gef.EditPart, java.lang.Object)
     */
    @Override
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

            case ProcessingResourceSpecificationEditPart.VISUAL_ID:
                return new ProcessingResourceSpecificationEditPart(view);

            case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
                return new ProcessingResourceSpecificationMTTFEditPart(view);

            case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
                return new ProcessingResourceSpecificationMTTREditPart(view);

            case CustomProcessingResourceSpecificationSchedulingPolicyLabelEditPart.VISUAL_ID:
                return new CustomProcessingResourceSpecificationSchedulingPolicyLabelEditPart(view);

            case ProcessingResourceSpecificationNumberOfReplicasEditPart.VISUAL_ID:
                return new ProcessingResourceSpecificationNumberOfReplicasEditPart(view);

            case CustomProcessingResourceSpecificationProcessingRateLabelEditPart.VISUAL_ID:
                return new CustomProcessingResourceSpecificationProcessingRateLabelEditPart(view);

            case CustomProcessingResourceSpecificationActiveResourceTypeLabelEditPart.VISUAL_ID:
                return new CustomProcessingResourceSpecificationActiveResourceTypeLabelEditPart(view);

            case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
                return new CommunicationLinkResourceSpecificationEditPart(view);

            case CustomCommunicationLinkResourceSpecificationFailureProbabilityEditPart.VISUAL_ID:
                return new CustomCommunicationLinkResourceSpecificationFailureProbabilityEditPart(view);

            case CustomCommunicationLinkResourceSpecificationLatencyLabelEditPart.VISUAL_ID:
                return new CustomCommunicationLinkResourceSpecificationLatencyLabelEditPart(view);

            case CustomCommunicationLinkResourceSpecificationThroughputLabelEditPart.VISUAL_ID:
                return new CustomCommunicationLinkResourceSpecificationThroughputLabelEditPart(view);

            case WrappingLabel6EditPart.VISUAL_ID:
                return new WrappingLabel6EditPart(view);

            case CustomResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
                return new CustomResourceContainerResourceContainerCompartmentEditPart(view);

            case CustomProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart.VISUAL_ID:
                return new CustomProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart(view);

            case CustomLinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
                return new CustomLinkingResourceNetworkSwitchCompartmentEditPart(view);

            case LinkingResourceConnectedResourceContainers_LinkingResourceEditPart.VISUAL_ID:
                return new LinkingResourceConnectedResourceContainers_LinkingResourceEditPart(view);

            default:
            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * Creates a new CustomPalladioComponentModelEditPart object.
     * 
     * @param context
     *            an edit part
     * @param model
     *            and Object
     * @return an edit part
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

}
