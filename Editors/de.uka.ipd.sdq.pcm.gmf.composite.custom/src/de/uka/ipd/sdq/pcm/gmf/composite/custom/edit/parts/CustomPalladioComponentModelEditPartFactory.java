/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.PalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom Palladio component model EditPart factory.
 */
public class CustomPalladioComponentModelEditPartFactory extends PalladioComponentModelEditPartFactory {

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case CustomAssemblyContextEditPart.VISUAL_ID:
                return new CustomAssemblyContextEditPart(view);

            case CustomAssemblyEventConnectorEditPart.VISUAL_ID:
                return new CustomAssemblyEventConnectorEditPart(view);

            case CustomComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
                return new CustomComposedProvidingRequiringEntity2EditPart(view);

            case CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
                return new CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(view);

            case CustomEventChannelEditPart.VISUAL_ID:
                return new CustomEventChannelEditPart(view);

            case CustomEventChannelSinkConnectorEditPart.VISUAL_ID:
                return new CustomEventChannelSinkConnectorEditPart(view);

            case CustomInfrastructureProvidedRoleEditPart.VISUAL_ID:
                return new CustomInfrastructureProvidedRoleEditPart(view);

            case CustomInfrastructureRequiredRoleEditPart.VISUAL_ID:
                return new CustomInfrastructureRequiredRoleEditPart(view);

            case CustomOperationProvidedRole2EditPart.VISUAL_ID:
                return new CustomOperationProvidedRole2EditPart(view);

            case CustomOperationProvidedRoleEditPart.VISUAL_ID:
                return new CustomOperationProvidedRoleEditPart(view);

            case CustomOperationRequiredRole2EditPart.VISUAL_ID:
                return new CustomOperationRequiredRole2EditPart(view);

            case CustomOperationRequiredRoleEditPart.VISUAL_ID:
                return new CustomOperationRequiredRoleEditPart(view);

            case CustomSinkRoleEditPart.VISUAL_ID:
                return new CustomSinkRoleEditPart(view);

            case CustomSourceRoleEditPart.VISUAL_ID:
                return new CustomSourceRoleEditPart(view);

            default:
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
}
