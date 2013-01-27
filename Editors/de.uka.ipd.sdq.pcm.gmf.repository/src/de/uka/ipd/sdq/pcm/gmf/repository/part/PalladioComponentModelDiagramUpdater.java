/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentComponentParameterCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentPassiveResourceCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeParentProvidesComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEventTypeListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceInfrastructureSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceParentInterfaces__InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * @generated
     */
    public static boolean isShortcutOrphaned(View view) {
        return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case RepositoryEditPart.VISUAL_ID:
            return getRepository_1000SemanticChildren(view);
        case OperationInterfaceSignatureListEditPart.VISUAL_ID:
            return getOperationInterfaceSignatureList_7106SemanticChildren(view);
        case EventGroupEventTypeListEditPart.VISUAL_ID:
            return getEventGroupEventTypeList_7107SemanticChildren(view);
        case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
            return getBasicComponentSEFFCompartment_7102SemanticChildren(view);
        case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
            return getBasicComponentPassiveResourceCompartment_7103SemanticChildren(view);
        case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
            return getBasicComponentComponentParameterCompartment_7104SemanticChildren(view);
        case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
            return getVariableUsageComponentParameterVariableCharacterisationCompartment_7105SemanticChildren(view);
        case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
            return getInfrastructureInterfaceInfrastructureSignatureList_7108SemanticChildren(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getOperationInterfaceSignatureList_7106SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        OperationInterface modelElement = (OperationInterface) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSignatures__OperationInterface().iterator(); it.hasNext();) {
            OperationSignature childElement = (OperationSignature) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationSignatureEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getEventGroupEventTypeList_7107SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        EventGroup modelElement = (EventGroup) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getEventTypes__EventGroup().iterator(); it.hasNext();) {
            EventType childElement = (EventType) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == EventTypeEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getBasicComponentSEFFCompartment_7102SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        BasicComponent modelElement = (BasicComponent) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getServiceEffectSpecifications__BasicComponent().iterator(); it.hasNext();) {
            ServiceEffectSpecification childElement = (ServiceEffectSpecification) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingSEFFEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getBasicComponentPassiveResourceCompartment_7103SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        BasicComponent modelElement = (BasicComponent) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getPassiveResource_BasicComponent().iterator(); it.hasNext();) {
            PassiveResource childElement = (PassiveResource) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == PassiveResourceEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getBasicComponentComponentParameterCompartment_7104SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        BasicComponent modelElement = (BasicComponent) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getComponentParameterUsage_ImplementationComponentType().iterator(); it
                .hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsageEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageComponentParameterVariableCharacterisationCompartment_7105SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisationEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInfrastructureInterfaceInfrastructureSignatureList_7108SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InfrastructureInterface modelElement = (InfrastructureInterface) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInfrastructureSignatures__InfrastructureInterface().iterator(); it
                .hasNext();) {
            InfrastructureSignature childElement = (InfrastructureSignature) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == InfrastructureSignatureEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getRepository_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        Repository modelElement = (Repository) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInterfaces__Repository().iterator(); it.hasNext();) {
            Interface childElement = (Interface) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationInterfaceEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EventGroupEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InfrastructureInterfaceEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        for (Iterator<?> it = modelElement.getComponents__Repository().iterator(); it.hasNext();) {
            RepositoryComponent childElement = (RepositoryComponent) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == BasicComponentEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CompositeComponentEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CompleteComponentTypeEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ProvidesComponentTypeEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SubSystemEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case RepositoryEditPart.VISUAL_ID:
            return getRepository_1000ContainedLinks(view);
        case OperationInterfaceEditPart.VISUAL_ID:
            return getOperationInterface_2107ContainedLinks(view);
        case EventGroupEditPart.VISUAL_ID:
            return getEventGroup_2108ContainedLinks(view);
        case BasicComponentEditPart.VISUAL_ID:
            return getBasicComponent_2102ContainedLinks(view);
        case CompositeComponentEditPart.VISUAL_ID:
            return getCompositeComponent_2103ContainedLinks(view);
        case CompleteComponentTypeEditPart.VISUAL_ID:
            return getCompleteComponentType_2104ContainedLinks(view);
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            return getProvidesComponentType_2105ContainedLinks(view);
        case SubSystemEditPart.VISUAL_ID:
            return getSubSystem_2106ContainedLinks(view);
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return getInfrastructureInterface_2109ContainedLinks(view);
        case OperationSignatureEditPart.VISUAL_ID:
            return getOperationSignature_3106ContainedLinks(view);
        case EventTypeEditPart.VISUAL_ID:
            return getEventType_3107ContainedLinks(view);
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_3102ContainedLinks(view);
        case PassiveResourceEditPart.VISUAL_ID:
            return getPassiveResource_3103ContainedLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3104ContainedLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3105ContainedLinks(view);
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getInfrastructureSignature_3108ContainedLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_4105ContainedLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_4111ContainedLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_4112ContainedLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_4109ContainedLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_4106ContainedLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_4110ContainedLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case OperationInterfaceEditPart.VISUAL_ID:
            return getOperationInterface_2107IncomingLinks(view);
        case EventGroupEditPart.VISUAL_ID:
            return getEventGroup_2108IncomingLinks(view);
        case BasicComponentEditPart.VISUAL_ID:
            return getBasicComponent_2102IncomingLinks(view);
        case CompositeComponentEditPart.VISUAL_ID:
            return getCompositeComponent_2103IncomingLinks(view);
        case CompleteComponentTypeEditPart.VISUAL_ID:
            return getCompleteComponentType_2104IncomingLinks(view);
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            return getProvidesComponentType_2105IncomingLinks(view);
        case SubSystemEditPart.VISUAL_ID:
            return getSubSystem_2106IncomingLinks(view);
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return getInfrastructureInterface_2109IncomingLinks(view);
        case OperationSignatureEditPart.VISUAL_ID:
            return getOperationSignature_3106IncomingLinks(view);
        case EventTypeEditPart.VISUAL_ID:
            return getEventType_3107IncomingLinks(view);
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_3102IncomingLinks(view);
        case PassiveResourceEditPart.VISUAL_ID:
            return getPassiveResource_3103IncomingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3104IncomingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3105IncomingLinks(view);
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getInfrastructureSignature_3108IncomingLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_4105IncomingLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_4111IncomingLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_4112IncomingLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_4109IncomingLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_4106IncomingLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_4110IncomingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case OperationInterfaceEditPart.VISUAL_ID:
            return getOperationInterface_2107OutgoingLinks(view);
        case EventGroupEditPart.VISUAL_ID:
            return getEventGroup_2108OutgoingLinks(view);
        case BasicComponentEditPart.VISUAL_ID:
            return getBasicComponent_2102OutgoingLinks(view);
        case CompositeComponentEditPart.VISUAL_ID:
            return getCompositeComponent_2103OutgoingLinks(view);
        case CompleteComponentTypeEditPart.VISUAL_ID:
            return getCompleteComponentType_2104OutgoingLinks(view);
        case ProvidesComponentTypeEditPart.VISUAL_ID:
            return getProvidesComponentType_2105OutgoingLinks(view);
        case SubSystemEditPart.VISUAL_ID:
            return getSubSystem_2106OutgoingLinks(view);
        case InfrastructureInterfaceEditPart.VISUAL_ID:
            return getInfrastructureInterface_2109OutgoingLinks(view);
        case OperationSignatureEditPart.VISUAL_ID:
            return getOperationSignature_3106OutgoingLinks(view);
        case EventTypeEditPart.VISUAL_ID:
            return getEventType_3107OutgoingLinks(view);
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_3102OutgoingLinks(view);
        case PassiveResourceEditPart.VISUAL_ID:
            return getPassiveResource_3103OutgoingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3104OutgoingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3105OutgoingLinks(view);
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getInfrastructureSignature_3108OutgoingLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_4105OutgoingLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_4111OutgoingLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_4112OutgoingLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_4109OutgoingLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_4106OutgoingLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_4110OutgoingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRepository_1000ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationInterface_2107ContainedLinks(View view) {
        OperationInterface modelElement = (OperationInterface) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventGroup_2108ContainedLinks(View view) {
        EventGroup modelElement = (EventGroup) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBasicComponent_2102ContainedLinks(View view) {
        BasicComponent modelElement = (BasicComponent) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompositeComponent_2103ContainedLinks(View view) {
        CompositeComponent modelElement = (CompositeComponent) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompleteComponentType_2104ContainedLinks(View view) {
        CompleteComponentType modelElement = (CompleteComponentType) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidesComponentType_2105ContainedLinks(View view) {
        ProvidesComponentType modelElement = (ProvidesComponentType) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSubSystem_2106ContainedLinks(View view) {
        SubSystem modelElement = (SubSystem) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureInterface_2109ContainedLinks(View view) {
        InfrastructureInterface modelElement = (InfrastructureInterface) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationSignature_3106ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventType_3107ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingSEFF_3102ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getPassiveResource_3103ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3104ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3105ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureSignature_3108ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_4105ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_4111ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_4112ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_4109ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_4106ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_4110ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationInterface_2107IncomingLinks(View view) {
        OperationInterface modelElement = (OperationInterface) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperationProvidedRole_4105(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_OperationRequiredRole_4106(modelElement, crossReferences));
        result.addAll(getIncomingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventGroup_2108IncomingLinks(View view) {
        EventGroup modelElement = (EventGroup) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_SinkRole_4109(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_SourceRole_4110(modelElement, crossReferences));
        result.addAll(getIncomingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBasicComponent_2102IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompositeComponent_2103IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompleteComponentType_2104IncomingLinks(View view) {
        CompleteComponentType modelElement = (CompleteComponentType) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidesComponentType_2105IncomingLinks(View view) {
        ProvidesComponentType modelElement = (ProvidesComponentType) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSubSystem_2106IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureInterface_2109IncomingLinks(View view) {
        InfrastructureInterface modelElement = (InfrastructureInterface) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement, crossReferences));
        result.addAll(getIncomingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationSignature_3106IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventType_3107IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingSEFF_3102IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getPassiveResource_3103IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3104IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3105IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureSignature_3108IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_4105IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_4111IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_4112IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_4109IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_4106IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_4110IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationInterface_2107OutgoingLinks(View view) {
        OperationInterface modelElement = (OperationInterface) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventGroup_2108OutgoingLinks(View view) {
        EventGroup modelElement = (EventGroup) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBasicComponent_2102OutgoingLinks(View view) {
        BasicComponent modelElement = (BasicComponent) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompositeComponent_2103OutgoingLinks(View view) {
        CompositeComponent modelElement = (CompositeComponent) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCompleteComponentType_2104OutgoingLinks(View view) {
        CompleteComponentType modelElement = (CompleteComponentType) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidesComponentType_2105OutgoingLinks(View view) {
        ProvidesComponentType modelElement = (ProvidesComponentType) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSubSystem_2106OutgoingLinks(View view) {
        SubSystem modelElement = (SubSystem) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperationProvidedRole_4105(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SinkRole_4109(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperationRequiredRole_4106(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_SourceRole_4110(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureInterface_2109OutgoingLinks(View view) {
        InfrastructureInterface modelElement = (InfrastructureInterface) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationSignature_3106OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventType_3107OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingSEFF_3102OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getPassiveResource_3103OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3104OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3105OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureSignature_3108OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_4105OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_4111OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_4112OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_4109OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_4106OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_4110OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_OperationProvidedRole_4105(
            InterfaceProvidingEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getProvidedRoles_InterfaceProvidingEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof OperationProvidedRole) {
                continue;
            }
            OperationProvidedRole link = (OperationProvidedRole) linkObject;
            if (OperationProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationInterface dst = link.getProvidedInterface__OperationProvidedRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.OperationProvidedRole_4105,
                    OperationProvidedRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_InfrastructureProvidedRole_4111(
            InterfaceProvidingEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getProvidedRoles_InterfaceProvidingEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof InfrastructureProvidedRole) {
                continue;
            }
            InfrastructureProvidedRole link = (InfrastructureProvidedRole) linkObject;
            if (InfrastructureProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            InfrastructureInterface dst = link.getProvidedInterface__InfrastructureProvidedRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111,
                    InfrastructureProvidedRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_InfrastructureRequiredRole_4112(
            InterfaceRequiringEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getRequiredRoles_InterfaceRequiringEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof InfrastructureRequiredRole) {
                continue;
            }
            InfrastructureRequiredRole link = (InfrastructureRequiredRole) linkObject;
            if (InfrastructureRequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            InfrastructureInterface dst = link.getRequiredInterface__InfrastructureRequiredRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112,
                    InfrastructureRequiredRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_SinkRole_4109(
            InterfaceProvidingEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getProvidedRoles_InterfaceProvidingEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof SinkRole) {
                continue;
            }
            SinkRole link = (SinkRole) linkObject;
            if (SinkRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(link)) {
                continue;
            }
            EventGroup dst = link.getEventGroup__SinkRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.SinkRole_4109, SinkRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_OperationRequiredRole_4106(
            InterfaceRequiringEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getRequiredRoles_InterfaceRequiringEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof OperationRequiredRole) {
                continue;
            }
            OperationRequiredRole link = (OperationRequiredRole) linkObject;
            if (OperationRequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationInterface dst = link.getRequiredInterface__OperationRequiredRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.OperationRequiredRole_4106,
                    OperationRequiredRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_SourceRole_4110(
            InterfaceRequiringEntity container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getRequiredRoles_InterfaceRequiringEntity().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof SourceRole) {
                continue;
            }
            SourceRole link = (SourceRole) linkObject;
            if (SourceRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(link)) {
                continue;
            }
            EventGroup dst = link.getEventGroup__SourceRole();
            result.add(new PalladioComponentModelLinkDescriptor(container, dst, link,
                    PalladioComponentModelElementTypes.SourceRole_4110, SourceRoleEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_OperationProvidedRole_4105(
            OperationInterface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
                    .getOperationProvidedRole_ProvidedInterface__OperationProvidedRole()
                    || false == setting.getEObject() instanceof OperationProvidedRole) {
                continue;
            }
            OperationProvidedRole link = (OperationProvidedRole) setting.getEObject();
            if (OperationProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceProvidingEntity) {
                continue;
            }
            InterfaceProvidingEntity container = (InterfaceProvidingEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.OperationProvidedRole_4105,
                    OperationProvidedRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_InfrastructureProvidedRole_4111(
            InfrastructureInterface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
                    .getInfrastructureProvidedRole_ProvidedInterface__InfrastructureProvidedRole()
                    || false == setting.getEObject() instanceof InfrastructureProvidedRole) {
                continue;
            }
            InfrastructureProvidedRole link = (InfrastructureProvidedRole) setting.getEObject();
            if (InfrastructureProvidedRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceProvidingEntity) {
                continue;
            }
            InterfaceProvidingEntity container = (InterfaceProvidingEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111,
                    InfrastructureProvidedRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_InfrastructureRequiredRole_4112(
            InfrastructureInterface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
                    .getInfrastructureRequiredRole_RequiredInterface__InfrastructureRequiredRole()
                    || false == setting.getEObject() instanceof InfrastructureRequiredRole) {
                continue;
            }
            InfrastructureRequiredRole link = (InfrastructureRequiredRole) setting.getEObject();
            if (InfrastructureRequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceRequiringEntity) {
                continue;
            }
            InterfaceRequiringEntity container = (InterfaceRequiringEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112,
                    InfrastructureRequiredRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_SinkRole_4109(
            EventGroup target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE.getSinkRole_EventGroup__SinkRole()
                    || false == setting.getEObject() instanceof SinkRole) {
                continue;
            }
            SinkRole link = (SinkRole) setting.getEObject();
            if (SinkRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceProvidingEntity) {
                continue;
            }
            InterfaceProvidingEntity container = (InterfaceProvidingEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.SinkRole_4109, SinkRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_OperationRequiredRole_4106(
            OperationInterface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE
                    .getOperationRequiredRole_RequiredInterface__OperationRequiredRole()
                    || false == setting.getEObject() instanceof OperationRequiredRole) {
                continue;
            }
            OperationRequiredRole link = (OperationRequiredRole) setting.getEObject();
            if (OperationRequiredRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceRequiringEntity) {
                continue;
            }
            InterfaceRequiringEntity container = (InterfaceRequiringEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.OperationRequiredRole_4106,
                    OperationRequiredRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
            CompleteComponentType target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() == RepositoryPackage.eINSTANCE
                    .getImplementationComponentType_ParentCompleteComponentTypes()) {
                result.add(new PalladioComponentModelLinkDescriptor(
                        setting.getEObject(),
                        target,
                        PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
                        ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
            ProvidesComponentType target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() == RepositoryPackage.eINSTANCE
                    .getCompleteComponentType_ParentProvidesComponentTypes()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
                        PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
                        CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_SourceRole_4110(
            EventGroup target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != RepositoryPackage.eINSTANCE.getSourceRole_EventGroup__SourceRole()
                    || false == setting.getEObject() instanceof SourceRole) {
                continue;
            }
            SourceRole link = (SourceRole) setting.getEObject();
            if (SourceRoleEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof InterfaceRequiringEntity) {
                continue;
            }
            InterfaceRequiringEntity container = (InterfaceRequiringEntity) link.eContainer();
            result.add(new PalladioComponentModelLinkDescriptor(container, target, link,
                    PalladioComponentModelElementTypes.SourceRole_4110, SourceRoleEditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(
            Interface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() == RepositoryPackage.eINSTANCE
                    .getInterface_ParentInterfaces__Interface()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
                        PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113,
                        InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_ImplementationComponentType_ParentCompleteComponentTypes_4103(
            ImplementationComponentType source) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> destinations = source.getParentCompleteComponentTypes().iterator(); destinations.hasNext();) {
            CompleteComponentType destination = (CompleteComponentType) destinations.next();
            result.add(new PalladioComponentModelLinkDescriptor(source, destination,
                    PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103,
                    ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_CompleteComponentType_ParentProvidesComponentTypes_4104(
            CompleteComponentType source) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> destinations = source.getParentProvidesComponentTypes().iterator(); destinations.hasNext();) {
            ProvidesComponentType destination = (ProvidesComponentType) destinations.next();
            result.add(new PalladioComponentModelLinkDescriptor(source, destination,
                    PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104,
                    CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Interface_ParentInterfaces__Interface_4113(
            Interface source) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> destinations = source.getParentInterfaces__Interface().iterator(); destinations.hasNext();) {
            Interface destination = (Interface) destinations.next();
            result.add(new PalladioComponentModelLinkDescriptor(source, destination,
                    PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113,
                    InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelNodeDescriptor> getSemanticChildren(View view) {
            return PalladioComponentModelDiagramUpdater.getSemanticChildren(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getContainedLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getContainedLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getIncomingLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getIncomingLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getOutgoingLinks(view);
        }
    };

}
