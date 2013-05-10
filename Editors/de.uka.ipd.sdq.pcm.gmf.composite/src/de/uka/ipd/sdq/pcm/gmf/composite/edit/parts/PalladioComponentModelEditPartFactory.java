/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

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

            case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityEditPart(view);

            case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntity2EditPart(view);

            case ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityEntityNameEditPart(view);

            case AssemblyContextEditPart.VISUAL_ID:
                return new AssemblyContextEditPart(view);

            case AssemblyContextEntityNameEditPart.VISUAL_ID:
                return new AssemblyContextEntityNameEditPart(view);

            case OperationProvidedRoleEditPart.VISUAL_ID:
                return new OperationProvidedRoleEditPart(view);

            case OperationProvidedRoleEntityNameEditPart.VISUAL_ID:
                return new OperationProvidedRoleEntityNameEditPart(view);

            case OperationRequiredRoleEditPart.VISUAL_ID:
                return new OperationRequiredRoleEditPart(view);

            case OperationRequiredRoleEntityNameEditPart.VISUAL_ID:
                return new OperationRequiredRoleEntityNameEditPart(view);

            case SourceRoleEditPart.VISUAL_ID:
                return new SourceRoleEditPart(view);

            case SourceRoleEntityNameEditPart.VISUAL_ID:
                return new SourceRoleEntityNameEditPart(view);

            case SinkRoleEditPart.VISUAL_ID:
                return new SinkRoleEditPart(view);

            case SinkRoleEntityNameEditPart.VISUAL_ID:
                return new SinkRoleEntityNameEditPart(view);

            case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEditPart(view);

            case InfrastructureProvidedRoleEntityNameEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEntityNameEditPart(view);

            case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEditPart(view);

            case InfrastructureRequiredRoleEntityNameEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEntityNameEditPart(view);

            case OperationProvidedRole2EditPart.VISUAL_ID:
                return new OperationProvidedRole2EditPart(view);

            case OperationProvidedRoleEntityName2EditPart.VISUAL_ID:
                return new OperationProvidedRoleEntityName2EditPart(view);

            case OperationRequiredRole2EditPart.VISUAL_ID:
                return new OperationRequiredRole2EditPart(view);

            case OperationRequiredRoleEntityName2EditPart.VISUAL_ID:
                return new OperationRequiredRoleEntityName2EditPart(view);

            case EventChannelEditPart.VISUAL_ID:
                return new EventChannelEditPart(view);

            case EventChannelEntityNameEditPart.VISUAL_ID:
                return new EventChannelEntityNameEditPart(view);

            case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(view);

            case EventChannelSinkConnectorEditPart.VISUAL_ID:
                return new EventChannelSinkConnectorEditPart(view);

            case EventChannelSourceConnectorEditPart.VISUAL_ID:
                return new EventChannelSourceConnectorEditPart(view);

            case AssemblyConnectorEditPart.VISUAL_ID:
                return new AssemblyConnectorEditPart(view);

            case AssemblyEventConnectorEditPart.VISUAL_ID:
                return new AssemblyEventConnectorEditPart(view);

            case RequiredDelegationConnectorEditPart.VISUAL_ID:
                return new RequiredDelegationConnectorEditPart(view);

            case ProvidedDelegationConnectorEditPart.VISUAL_ID:
                return new ProvidedDelegationConnectorEditPart(view);

            case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
                return new AssemblyInfrastructureConnectorEditPart(view);

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
        return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
    }

}
