/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
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
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceParentInterfaces__InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrappingLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrappingLabel3EditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.WrappingLabelEditPart;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.subsystem.SubsystemPackage;

/**
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

    /**
     * @generated
     */
    private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.repository/debug/visualID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static int getVisualID(View view) {
        if (view instanceof Diagram) {
            if (RepositoryEditPart.MODEL_ID.equals(view.getType())) {
                return RepositoryEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                .getVisualID(view.getType());
    }

    /**
     * @generated
     */
    public static String getModelID(View view) {
        View diagram = view.getDiagram();
        while (view != diagram) {
            EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
            if (annotation != null) {
                return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
            }
            view = (View) view.eContainer();
        }
        return diagram != null ? diagram.getType() : null;
    }

    /**
     * @generated
     */
    public static int getVisualID(String type) {
        try {
            return Integer.parseInt(type);
        } catch (NumberFormatException e) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
                PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: " + type);
            }
        }
        return -1;
    }

    /**
     * @generated
     */
    public static String getType(int visualID) {
        return Integer.toString(visualID);
    }

    /**
     * @generated
     */
    public static int getDiagramVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (RepositoryPackage.eINSTANCE.getRepository().isSuperTypeOf(domainElement.eClass())
                && isDiagram((Repository) domainElement)) {
            return RepositoryEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static int getNodeVisualID(View containerView, EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = RepositoryEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
        case RepositoryEditPart.VISUAL_ID:
            if (RepositoryPackage.eINSTANCE.getOperationInterface().isSuperTypeOf(domainElement.eClass())) {
                return OperationInterfaceEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getEventGroup().isSuperTypeOf(domainElement.eClass())) {
                return EventGroupEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isSuperTypeOf(domainElement.eClass())) {
                return BasicComponentEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getCompositeComponent().isSuperTypeOf(domainElement.eClass())) {
                return CompositeComponentEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getCompleteComponentType().isSuperTypeOf(domainElement.eClass())) {
                return CompleteComponentTypeEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getProvidesComponentType().isSuperTypeOf(domainElement.eClass())) {
                return ProvidesComponentTypeEditPart.VISUAL_ID;
            }
            if (SubsystemPackage.eINSTANCE.getSubSystem().isSuperTypeOf(domainElement.eClass())) {
                return SubSystemEditPart.VISUAL_ID;
            }
            if (RepositoryPackage.eINSTANCE.getInfrastructureInterface().isSuperTypeOf(domainElement.eClass())) {
                return InfrastructureInterfaceEditPart.VISUAL_ID;
            }
            break;
        case OperationInterfaceSignatureListEditPart.VISUAL_ID:
            if (RepositoryPackage.eINSTANCE.getOperationSignature().isSuperTypeOf(domainElement.eClass())) {
                return OperationSignatureEditPart.VISUAL_ID;
            }
            break;
        case EventGroupEventTypeListEditPart.VISUAL_ID:
            if (RepositoryPackage.eINSTANCE.getEventType().isSuperTypeOf(domainElement.eClass())) {
                return EventTypeEditPart.VISUAL_ID;
            }
            break;
        case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingSEFFEditPart.VISUAL_ID;
            }
            break;
        case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
            if (RepositoryPackage.eINSTANCE.getPassiveResource().isSuperTypeOf(domainElement.eClass())) {
                return PassiveResourceEditPart.VISUAL_ID;
            }
            break;
        case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsageEditPart.VISUAL_ID;
            }
            break;
        case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisationEditPart.VISUAL_ID;
            }
            break;
        case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
            if (RepositoryPackage.eINSTANCE.getInfrastructureSignature().isSuperTypeOf(domainElement.eClass())) {
                return InfrastructureSignatureEditPart.VISUAL_ID;
            }
            break;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (RepositoryEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = RepositoryEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
        case RepositoryEditPart.VISUAL_ID:
            if (OperationInterfaceEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EventGroupEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BasicComponentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CompositeComponentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CompleteComponentTypeEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ProvidesComponentTypeEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SubSystemEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InfrastructureInterfaceEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case OperationInterfaceEditPart.VISUAL_ID:
            if (OperationInterfaceEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (OperationInterfaceSignatureListEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EventGroupEditPart.VISUAL_ID:
            if (EventGroupEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EventGroupEventTypeListEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BasicComponentEditPart.VISUAL_ID:
            if (BasicComponentEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BasicComponentSEFFCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case CompositeComponentEditPart.VISUAL_ID:
            if (CompositeComponentEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case CompleteComponentTypeEditPart.VISUAL_ID:
            if (CompleteComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            if (ProvidesComponentTypeEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SubSystemEditPart.VISUAL_ID:
            if (SubSystemEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            if (InfrastructureInterfaceEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageEditPart.VISUAL_ID:
            if (VariableUsageLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case OperationInterfaceSignatureListEditPart.VISUAL_ID:
            if (OperationSignatureEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EventGroupEventTypeListEditPart.VISUAL_ID:
            if (EventTypeEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
            if (ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
            if (PassiveResourceEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
            if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
            if (VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
            if (InfrastructureSignatureEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case OperationProvidedRoleEditPart.VISUAL_ID:
            if (OperationProvidedRoleLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SinkRoleEditPart.VISUAL_ID:
            if (SinkRoleLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case OperationRequiredRoleEditPart.VISUAL_ID:
            if (OperationRequiredRoleLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
            if (ImplementationComponentTypeParentCompleteTypesLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
            if (CompleteComponentTypeParentProvidesComponentTypesLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SourceRoleEditPart.VISUAL_ID:
            if (SourceRoleLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID:
            if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static int getLinkWithClassVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (RepositoryPackage.eINSTANCE.getOperationProvidedRole().isSuperTypeOf(domainElement.eClass())) {
            return OperationProvidedRoleEditPart.VISUAL_ID;
        }
        if (RepositoryPackage.eINSTANCE.getInfrastructureProvidedRole().isSuperTypeOf(domainElement.eClass())) {
            return InfrastructureProvidedRoleEditPart.VISUAL_ID;
        }
        if (RepositoryPackage.eINSTANCE.getInfrastructureRequiredRole().isSuperTypeOf(domainElement.eClass())) {
            return InfrastructureRequiredRoleEditPart.VISUAL_ID;
        }
        if (RepositoryPackage.eINSTANCE.getSinkRole().isSuperTypeOf(domainElement.eClass())) {
            return SinkRoleEditPart.VISUAL_ID;
        }
        if (RepositoryPackage.eINSTANCE.getOperationRequiredRole().isSuperTypeOf(domainElement.eClass())) {
            return OperationRequiredRoleEditPart.VISUAL_ID;
        }
        if (RepositoryPackage.eINSTANCE.getSourceRole().isSuperTypeOf(domainElement.eClass())) {
            return SourceRoleEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * @generated
     */
    private static boolean isDiagram(Repository element) {
        return true;
    }

    /**
     * @generated
     */
    public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
        if (candidate == -1) {
            // unrecognized id is always bad
            return false;
        }
        int basic = getNodeVisualID(containerView, domainElement);
        return basic == candidate;
    }

    /**
     * @generated
     */
    public static boolean isCompartmentVisualID(int visualID) {
        switch (visualID) {
        case OperationInterfaceSignatureListEditPart.VISUAL_ID:
        case EventGroupEventTypeListEditPart.VISUAL_ID:
        case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
        case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
        case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
        case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
        case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
            return true;
        default:
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static boolean isSemanticLeafVisualID(int visualID) {
        switch (visualID) {
        case RepositoryEditPart.VISUAL_ID:
            return false;
        case CompositeComponentEditPart.VISUAL_ID:
        case CompleteComponentTypeEditPart.VISUAL_ID:
        case ProvidesComponentTypeEditPart.VISUAL_ID:
        case SubSystemEditPart.VISUAL_ID:
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
        case PassiveResourceEditPart.VISUAL_ID:
        case VariableCharacterisationEditPart.VISUAL_ID:
        case OperationSignatureEditPart.VISUAL_ID:
        case EventTypeEditPart.VISUAL_ID:
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return true;
        default:
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
        /**
         * @generated
         */
        @Override
        public int getVisualID(View view) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry.getVisualID(view);
        }

        /**
         * @generated
         */
        @Override
        public String getModelID(View view) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry.getModelID(view);
        }

        /**
         * @generated
         */
        @Override
        public int getNodeVisualID(View containerView, EObject domainElement) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(
                    containerView, domainElement);
        }

        /**
         * @generated
         */
        @Override
        public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry.checkNodeVisualID(
                    containerView, domainElement, candidate);
        }

        /**
         * @generated
         */
        @Override
        public boolean isCompartmentVisualID(int visualID) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                    .isCompartmentVisualID(visualID);
        }

        /**
         * @generated
         */
        @Override
        public boolean isSemanticLeafVisualID(int visualID) {
            return de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry
                    .isSemanticLeafVisualID(visualID);
        }
    };
}
