/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEventTypeListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteTypesLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceInfrastructureSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrappingLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom Palladio component model EditPart factory.
 */
public class CustomPalladioComponentModelEditPartFactory extends PalladioComponentModelEditPartFactory {

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case CustomRepositoryEditPart.VISUAL_ID:
                return new CustomRepositoryEditPart(view);

            case OperationInterfaceEditPart.VISUAL_ID:
                return new OperationInterfaceEditPart(view);

            case OperationInterfaceEntityNameEditPart.VISUAL_ID:
                return new OperationInterfaceEntityNameEditPart(view);

            case EventGroupEditPart.VISUAL_ID:
                return new EventGroupEditPart(view);

            case EventGroupEntityNameEditPart.VISUAL_ID:
                return new EventGroupEntityNameEditPart(view);

            case BasicComponentEditPart.VISUAL_ID:
                return new BasicComponentEditPart(view);

            case BasicComponentEntityNameEditPart.VISUAL_ID:
                return new BasicComponentEntityNameEditPart(view);

            case CustomCompositeComponentEditPart.VISUAL_ID:
                return new CustomCompositeComponentEditPart(view);

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

            case SubSystemEditPart.VISUAL_ID:
                return new SubSystemEditPart(view);

            case SubSystemEntityNameEditPart.VISUAL_ID:
                return new SubSystemEntityNameEditPart(view);

            case InfrastructureInterfaceEditPart.VISUAL_ID:
                return new InfrastructureInterfaceEditPart(view);

            case InfrastructureInterfaceEntityNameEditPart.VISUAL_ID:
                return new InfrastructureInterfaceEntityNameEditPart(view);

            case CustomOperationSignatureEditPart.VISUAL_ID:
                return new CustomOperationSignatureEditPart(view);

            case EventTypeEditPart.VISUAL_ID:
                return new EventTypeEditPart(view);

            case CustomResourceDemandingSEFFEditPart.VISUAL_ID:
                return new CustomResourceDemandingSEFFEditPart(view);

            case CustomPassiveResourceEditPart.VISUAL_ID:
                return new CustomPassiveResourceEditPart(view);

            case CustomVariableUsageEditPart.VISUAL_ID:
                return new CustomVariableUsageEditPart(view);

            case VariableUsageLabelEditPart.VISUAL_ID:
                return new VariableUsageLabelEditPart(view);

            case CustomVariableCharacterisationEditPart.VISUAL_ID:
                return new CustomVariableCharacterisationEditPart(view);

            case CustomInfrastructureSignatureEditPart.VISUAL_ID:
                return new CustomInfrastructureSignatureEditPart(view);

            case OperationInterfaceSignatureListEditPart.VISUAL_ID:
                return new OperationInterfaceSignatureListEditPart(view);

            case EventGroupEventTypeListEditPart.VISUAL_ID:
                return new EventGroupEventTypeListEditPart(view);

            case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
                return new BasicComponentSEFFCompartmentEditPart(view);

            case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
                return new BasicComponentPassiveResourceCompartmentEditPart(view);

            case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
                return new BasicComponentComponentParameterCompartmentEditPart(view);

            case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
                return new VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart(view);

            case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
                return new InfrastructureInterfaceInfrastructureSignatureListEditPart(view);

            case OperationProvidedRoleEditPart.VISUAL_ID:
                return new OperationProvidedRoleEditPart(view);

            case OperationProvidedRoleLabelEditPart.VISUAL_ID:
                return new OperationProvidedRoleLabelEditPart(view);

            case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEditPart(view);

            case WrappingLabelEditPart.VISUAL_ID:
                return new WrappingLabelEditPart(view);

            case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEditPart(view);

            case WrappingLabel2EditPart.VISUAL_ID:
                return new WrappingLabel2EditPart(view);

            case SinkRoleEditPart.VISUAL_ID:
                return new SinkRoleEditPart(view);

            case SinkRoleLabelEditPart.VISUAL_ID:
                return new SinkRoleLabelEditPart(view);

            case OperationRequiredRoleEditPart.VISUAL_ID:
                return new OperationRequiredRoleEditPart(view);

            case OperationRequiredRoleLabelEditPart.VISUAL_ID:
                return new OperationRequiredRoleLabelEditPart(view);

            case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
                return new ImplementationComponentTypeParentCompleteComponentTypesEditPart(view);

            case ImplementationComponentTypeParentCompleteTypesLabelEditPart.VISUAL_ID:
                return new ImplementationComponentTypeParentCompleteTypesLabelEditPart(view);

            case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
                return new CompleteComponentTypeParentProvidesComponentTypesEditPart(view);

            case CompleteComponentTypeParentProvidesComponentTypesLabelEditPart.VISUAL_ID:
                return new CompleteComponentTypeParentProvidesComponentTypesLabelEditPart(view);

            case SourceRoleEditPart.VISUAL_ID:
                return new SourceRoleEditPart(view);

            case SourceRoleLabelEditPart.VISUAL_ID:
                return new SourceRoleLabelEditPart(view);

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
