/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.AssemblyEventConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyInfrastructureConnector;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.EventChannelSinkConnector;
import org.palladiosimulator.pcm.core.composition.EventChannelSourceConnector;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.core.composition.RequiredDelegationConnector;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSinkConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelSourceConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_1000SemanticChildren(view);
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_2002SemanticChildren(view);
        case AssemblyContextEditPart.VISUAL_ID:
            return getAssemblyContext_3006SemanticChildren(view);
        case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7002SemanticChildren(view);
        }
        return Collections.emptyList();
    }

    /**
     * Get the semantic children for the providing requiring entity.
     * 
     * In the composite diagram, the root element is not represented by the canvas, but by the first
     * included rectangle. To enable this, this edit policy needs to return the system and not the
     * real children as done in the generated version of this method.
     * 
     * Since GMF3, this modification has to be applied to PalladioComponentModelDiagramUpdater,
     * instead of ComposedProvidingRequiringEntityCanonicalEditPolicy.
     * 
     * @generated not
     * 
     * @param view
     *            a view
     * @return the result
     */
    public static List<PalladioComponentModelNodeDescriptor> getComposedProvidingRequiringEntity_1000SemanticChildren(
            View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        // Resource resource = modelElement.eResource();
        // for (Iterator<EObject> it = getPhantomNodesIterator(resource); it.hasNext();) {
        // EObject childElement = it.next();
        // if (childElement == modelElement) {
        // continue;
        // }
        if (PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, /* childElement */modelElement) == ComposedProvidingRequiringEntity2EditPart.VISUAL_ID) {
            result.add(new PalladioComponentModelNodeDescriptor(/* childElement */modelElement,
                    ComposedProvidingRequiringEntity2EditPart.VISUAL_ID));
            // continue;
        }
        // }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getComposedProvidingRequiringEntity_2002SemanticChildren(
            View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getProvidedRoles_InterfaceProvidingEntity().iterator(); it.hasNext();) {
            ProvidedRole childElement = (ProvidedRole) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationProvidedRole2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        for (Iterator<?> it = modelElement.getRequiredRoles_InterfaceRequiringEntity().iterator(); it.hasNext();) {
            RequiredRole childElement = (RequiredRole) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationRequiredRole2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Get the list of semantic children for an AssemblyContext.
     * 
     * This method is overridden, because it is has to return the provided and required roles of the
     * component encapsulated by the AssemblyContext and not the direct children of the context.
     * 
     * DONE: This method contains duplicated semantic to the AssemblyContextCanonicalEditPolicy The
     * CononicalEditPolicy method might include a call to this one and because of this it has to be
     * checked if the generated not in the AssemblyContextCanonicalEditPolicy could be removed.
     * 
     * @param view
     *            the view
     * @return the assembly context_3006 semantic children
     * 
     * @generated not
     */
    public static List<PalladioComponentModelNodeDescriptor> getAssemblyContext_3006SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }

        // Replaced the following line:
        // AssemblyContext modelElement = (AssemblyContext) view.getElement();
        // Manual navigation from assembly context to the associated component is required
        RepositoryComponent modelElement = ((AssemblyContext) view.getElement())
                .getEncapsulatedComponent__AssemblyContext();
        // Check if the component is really set for this assembly context. otherwise, it will break
        if (modelElement == null) {
            return Collections.emptyList();
        }

        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getProvidedRoles_InterfaceProvidingEntity().iterator(); it.hasNext();) {
            ProvidedRole childElement = (ProvidedRole) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationProvidedRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SinkRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InfrastructureProvidedRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        for (Iterator<?> it = modelElement.getRequiredRoles_InterfaceRequiringEntity().iterator(); it.hasNext();) {
            RequiredRole childElement = (RequiredRole) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == OperationRequiredRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SourceRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InfrastructureRequiredRoleEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the semantic children list.
     * 
     * Since GMF3, this modification has to be applied to PalladioComponentModelDiagramUpdater,
     * instead of
     * ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy.
     * 
     * @param view
     *            the view
     * @return the semantic children list
     * 
     * @generated not
     */
    public static List<PalladioComponentModelNodeDescriptor> getComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7002SemanticChildren(
            View view) {
        if (!(view.eContainer() instanceof View)) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getAssemblyContexts__ComposedStructure()
        /* getProvidedRoles_InterfaceProvidingEntity() */.iterator(); it.hasNext();) {
            AssemblyContext /* ProvidedRole */childElement = (AssemblyContext /* ProvidedRole */) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == AssemblyContextEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        for (Iterator<?> it = modelElement.getEventChannel__ComposedStructure().iterator(); it.hasNext();) {
            EventChannel childElement = (EventChannel) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == EventChannelEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
        // View viewObject = (View) getHost().getModel();
        // EObject modelObject = viewObject.getElement();
        // List result = new LinkedList();
        //
        // if (modelObject != null && modelObject instanceof ComposedStructure) {
        // for (AssemblyContext assemblyContext : ((ComposedStructure) modelObject)
        // .getAssemblyContexts__ComposedStructure()) {
        //
        // int assemblyNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject,
        // assemblyContext);
        // if (AssemblyContextEditPart.VISUAL_ID == assemblyNodeVID) {
        // result.add(assemblyContext);
        // }
        // }
        // for (EventChannel eventChannel : ((ComposedStructure)
        // modelObject).getEventChannel__ComposedStructure()) {
        //
        // int channelNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject,
        // eventChannel);
        // if (EventChannelEditPart.VISUAL_ID == channelNodeVID) {
        // result.add(eventChannel);
        // }
        // }
        // }
        // return result;
    }

    /**
     * @generated
     */
    private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
        return resource.getAllContents();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_1000ContainedLinks(view);
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_2002ContainedLinks(view);
        case AssemblyContextEditPart.VISUAL_ID:
            return getAssemblyContext_3006ContainedLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_3007ContainedLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_3008ContainedLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_3013ContainedLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_3014ContainedLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_3015ContainedLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_3016ContainedLinks(view);
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return getOperationProvidedRole_3011ContainedLinks(view);
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return getOperationRequiredRole_3012ContainedLinks(view);
        case EventChannelEditPart.VISUAL_ID:
            return getEventChannel_3017ContainedLinks(view);
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getEventChannelSinkConnector_4010ContainedLinks(view);
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getEventChannelSourceConnector_4009ContainedLinks(view);
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getAssemblyConnector_4004ContainedLinks(view);
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getAssemblyEventConnector_4007ContainedLinks(view);
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getRequiredDelegationConnector_4005ContainedLinks(view);
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getProvidedDelegationConnector_4006ContainedLinks(view);
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getAssemblyInfrastructureConnector_4008ContainedLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_2002IncomingLinks(view);
        case AssemblyContextEditPart.VISUAL_ID:
            return getAssemblyContext_3006IncomingLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_3007IncomingLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_3008IncomingLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_3013IncomingLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_3014IncomingLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_3015IncomingLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_3016IncomingLinks(view);
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return getOperationProvidedRole_3011IncomingLinks(view);
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return getOperationRequiredRole_3012IncomingLinks(view);
        case EventChannelEditPart.VISUAL_ID:
            return getEventChannel_3017IncomingLinks(view);
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getEventChannelSinkConnector_4010IncomingLinks(view);
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getEventChannelSourceConnector_4009IncomingLinks(view);
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getAssemblyConnector_4004IncomingLinks(view);
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getAssemblyEventConnector_4007IncomingLinks(view);
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getRequiredDelegationConnector_4005IncomingLinks(view);
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getProvidedDelegationConnector_4006IncomingLinks(view);
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getAssemblyInfrastructureConnector_4008IncomingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntity_2002OutgoingLinks(view);
        case AssemblyContextEditPart.VISUAL_ID:
            return getAssemblyContext_3006OutgoingLinks(view);
        case OperationProvidedRoleEditPart.VISUAL_ID:
            return getOperationProvidedRole_3007OutgoingLinks(view);
        case OperationRequiredRoleEditPart.VISUAL_ID:
            return getOperationRequiredRole_3008OutgoingLinks(view);
        case SourceRoleEditPart.VISUAL_ID:
            return getSourceRole_3013OutgoingLinks(view);
        case SinkRoleEditPart.VISUAL_ID:
            return getSinkRole_3014OutgoingLinks(view);
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
            return getInfrastructureProvidedRole_3015OutgoingLinks(view);
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return getInfrastructureRequiredRole_3016OutgoingLinks(view);
        case OperationProvidedRole2EditPart.VISUAL_ID:
            return getOperationProvidedRole_3011OutgoingLinks(view);
        case OperationRequiredRole2EditPart.VISUAL_ID:
            return getOperationRequiredRole_3012OutgoingLinks(view);
        case EventChannelEditPart.VISUAL_ID:
            return getEventChannel_3017OutgoingLinks(view);
        case EventChannelSinkConnectorEditPart.VISUAL_ID:
            return getEventChannelSinkConnector_4010OutgoingLinks(view);
        case EventChannelSourceConnectorEditPart.VISUAL_ID:
            return getEventChannelSourceConnector_4009OutgoingLinks(view);
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getAssemblyConnector_4004OutgoingLinks(view);
        case AssemblyEventConnectorEditPart.VISUAL_ID:
            return getAssemblyEventConnector_4007OutgoingLinks(view);
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getRequiredDelegationConnector_4005OutgoingLinks(view);
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getProvidedDelegationConnector_4006OutgoingLinks(view);
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
            return getAssemblyInfrastructureConnector_4008OutgoingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getComposedProvidingRequiringEntity_1000ContainedLinks(
            View view) {
        ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getComposedProvidingRequiringEntity_2002ContainedLinks(
            View view) {
        ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyContext_3006ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3007ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3008ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_3013ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_3014ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_3015ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_3016ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3011ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3012ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannel_3017ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSinkConnector_4010ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSourceConnector_4009ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyConnector_4004ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyEventConnector_4007ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRequiredDelegationConnector_4005ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidedDelegationConnector_4006ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyInfrastructureConnector_4008ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getComposedProvidingRequiringEntity_2002IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyContext_3006IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3007IncomingLinks(View view) {
        OperationProvidedRole modelElement = (OperationProvidedRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_AssemblyConnector_4004(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3008IncomingLinks(View view) {
        OperationRequiredRole modelElement = (OperationRequiredRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_3013IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_3014IncomingLinks(View view) {
        SinkRole modelElement = (SinkRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_3015IncomingLinks(View view) {
        InfrastructureProvidedRole modelElement = (InfrastructureProvidedRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_3016IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3011IncomingLinks(View view) {
        OperationProvidedRole modelElement = (OperationProvidedRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_AssemblyConnector_4004(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3012IncomingLinks(View view) {
        OperationRequiredRole modelElement = (OperationRequiredRole) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannel_3017IncomingLinks(View view) {
        EventChannel modelElement = (EventChannel) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSinkConnector_4010IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSourceConnector_4009IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyConnector_4004IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyEventConnector_4007IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRequiredDelegationConnector_4005IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidedDelegationConnector_4006IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyInfrastructureConnector_4008IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getComposedProvidingRequiringEntity_2002OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyContext_3006OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3007OutgoingLinks(View view) {
        OperationProvidedRole modelElement = (OperationProvidedRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3008OutgoingLinks(View view) {
        OperationRequiredRole modelElement = (OperationRequiredRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
        result.addAll(getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSourceRole_3013OutgoingLinks(View view) {
        SourceRole modelElement = (SourceRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
        result.addAll(getOutgoingTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSinkRole_3014OutgoingLinks(View view) {
        SinkRole modelElement = (SinkRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureProvidedRole_3015OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureRequiredRole_3016OutgoingLinks(View view) {
        InfrastructureRequiredRole modelElement = (InfrastructureRequiredRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationProvidedRole_3011OutgoingLinks(View view) {
        OperationProvidedRole modelElement = (OperationProvidedRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOperationRequiredRole_3012OutgoingLinks(View view) {
        OperationRequiredRole modelElement = (OperationRequiredRole) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
        result.addAll(getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannel_3017OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSinkConnector_4010OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEventChannelSourceConnector_4009OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyConnector_4004OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyEventConnector_4007OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRequiredDelegationConnector_4005OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProvidedDelegationConnector_4006OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAssemblyInfrastructureConnector_4008OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof EventChannelSinkConnector) {
                continue;
            }
            EventChannelSinkConnector link = (EventChannelSinkConnector) linkObject;
            if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            EventChannel dst = link.getEventChannel__EventChannelSinkConnector();
            SinkRole src = link.getSinkRole__EventChannelSinkConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
                    EventChannelSinkConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof EventChannelSourceConnector) {
                continue;
            }
            EventChannelSourceConnector link = (EventChannelSourceConnector) linkObject;
            if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            EventChannel dst = link.getEventChannel__EventChannelSourceConnector();
            SourceRole src = link.getSourceRole__EventChannelSourceRole();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
                    EventChannelSourceConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_AssemblyConnector_4004(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyConnector) {
                continue;
            }
            AssemblyConnector link = (AssemblyConnector) linkObject;
            if (AssemblyConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationProvidedRole dst = link.getProvidedRole_AssemblyConnector();
            OperationRequiredRole src = link.getRequiredRole_AssemblyConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyConnector_4004, AssemblyConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyEventConnector) {
                continue;
            }
            AssemblyEventConnector link = (AssemblyEventConnector) linkObject;
            if (AssemblyEventConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            SinkRole dst = link.getSinkRole__AssemblyEventConnector();
            SourceRole src = link.getSourceRole__AssemblyEventConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
                    AssemblyEventConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof RequiredDelegationConnector) {
                continue;
            }
            RequiredDelegationConnector link = (RequiredDelegationConnector) linkObject;
            if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationRequiredRole dst = link.getOuterRequiredRole_RequiredDelegationConnector();
            OperationRequiredRole src = link.getInnerRequiredRole_RequiredDelegationConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
                    RequiredDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof ProvidedDelegationConnector) {
                continue;
            }
            ProvidedDelegationConnector link = (ProvidedDelegationConnector) linkObject;
            if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationProvidedRole dst = link.getInnerProvidedRole_ProvidedDelegationConnector();
            OperationProvidedRole src = link.getOuterProvidedRole_ProvidedDelegationConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
                    ProvidedDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
            ComposedStructure container) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyInfrastructureConnector) {
                continue;
            }
            AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) linkObject;
            if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            InfrastructureProvidedRole dst = link.getProvidedRole__AssemblyInfrastructureConnector();
            InfrastructureRequiredRole src = link.getRequiredRole__AssemblyInfrastructureConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
                    AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_EventChannelSinkConnector_4010(
            EventChannel target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getEventChannelSinkConnector_EventChannel__EventChannelSinkConnector()
                    || false == setting.getEObject() instanceof EventChannelSinkConnector) {
                continue;
            }
            EventChannelSinkConnector link = (EventChannelSinkConnector) setting.getEObject();
            if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            SinkRole src = link.getSinkRole__EventChannelSinkConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
                    EventChannelSinkConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_EventChannelSourceConnector_4009(
            EventChannel target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getEventChannelSourceConnector_EventChannel__EventChannelSourceConnector()
                    || false == setting.getEObject() instanceof EventChannelSourceConnector) {
                continue;
            }
            EventChannelSourceConnector link = (EventChannelSourceConnector) setting.getEObject();
            if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            SourceRole src = link.getSourceRole__EventChannelSourceRole();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
                    EventChannelSourceConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_AssemblyConnector_4004(
            OperationProvidedRole target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getAssemblyConnector_ProvidedRole_AssemblyConnector()
                    || false == setting.getEObject() instanceof AssemblyConnector) {
                continue;
            }
            AssemblyConnector link = (AssemblyConnector) setting.getEObject();
            if (AssemblyConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationRequiredRole src = link.getRequiredRole_AssemblyConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.AssemblyConnector_4004, AssemblyConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_AssemblyEventConnector_4007(
            SinkRole target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getAssemblyEventConnector_SinkRole__AssemblyEventConnector()
                    || false == setting.getEObject() instanceof AssemblyEventConnector) {
                continue;
            }
            AssemblyEventConnector link = (AssemblyEventConnector) setting.getEObject();
            if (AssemblyEventConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            SourceRole src = link.getSourceRole__AssemblyEventConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
                    AssemblyEventConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(
            OperationRequiredRole target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector()
                    || false == setting.getEObject() instanceof RequiredDelegationConnector) {
                continue;
            }
            RequiredDelegationConnector link = (RequiredDelegationConnector) setting.getEObject();
            if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationRequiredRole src = link.getInnerRequiredRole_RequiredDelegationConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
                    RequiredDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
            OperationProvidedRole target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector()
                    || false == setting.getEObject() instanceof ProvidedDelegationConnector) {
                continue;
            }
            ProvidedDelegationConnector link = (ProvidedDelegationConnector) setting.getEObject();
            if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationProvidedRole src = link.getOuterProvidedRole_ProvidedDelegationConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
                    ProvidedDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
            InfrastructureProvidedRole target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
                    .getAssemblyInfrastructureConnector_ProvidedRole__AssemblyInfrastructureConnector()
                    || false == setting.getEObject() instanceof AssemblyInfrastructureConnector) {
                continue;
            }
            AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) setting.getEObject();
            if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            InfrastructureRequiredRole src = link.getRequiredRole__AssemblyInfrastructureConnector();
            result.add(new PalladioComponentModelLinkDescriptor(src, target, link,
                    PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
                    AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_EventChannelSinkConnector_4010(
            SinkRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof EventChannelSinkConnector) {
                continue;
            }
            EventChannelSinkConnector link = (EventChannelSinkConnector) linkObject;
            if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            EventChannel dst = link.getEventChannel__EventChannelSinkConnector();
            SinkRole src = link.getSinkRole__EventChannelSinkConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
                    EventChannelSinkConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_EventChannelSourceConnector_4009(
            SourceRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof EventChannelSourceConnector) {
                continue;
            }
            EventChannelSourceConnector link = (EventChannelSourceConnector) linkObject;
            if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            EventChannel dst = link.getEventChannel__EventChannelSourceConnector();
            SourceRole src = link.getSourceRole__EventChannelSourceRole();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
                    EventChannelSourceConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(
            OperationRequiredRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyConnector) {
                continue;
            }
            AssemblyConnector link = (AssemblyConnector) linkObject;
            if (AssemblyConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationProvidedRole dst = link.getProvidedRole_AssemblyConnector();
            OperationRequiredRole src = link.getRequiredRole_AssemblyConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyConnector_4004, AssemblyConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_AssemblyEventConnector_4007(
            SourceRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyEventConnector) {
                continue;
            }
            AssemblyEventConnector link = (AssemblyEventConnector) linkObject;
            if (AssemblyEventConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            SinkRole dst = link.getSinkRole__AssemblyEventConnector();
            SourceRole src = link.getSourceRole__AssemblyEventConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
                    AssemblyEventConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(
            OperationRequiredRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof RequiredDelegationConnector) {
                continue;
            }
            RequiredDelegationConnector link = (RequiredDelegationConnector) linkObject;
            if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationRequiredRole dst = link.getOuterRequiredRole_RequiredDelegationConnector();
            OperationRequiredRole src = link.getInnerRequiredRole_RequiredDelegationConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
                    RequiredDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
            OperationProvidedRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof ProvidedDelegationConnector) {
                continue;
            }
            ProvidedDelegationConnector link = (ProvidedDelegationConnector) linkObject;
            if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperationProvidedRole dst = link.getInnerProvidedRole_ProvidedDelegationConnector();
            OperationProvidedRole src = link.getOuterProvidedRole_ProvidedDelegationConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
                    ProvidedDelegationConnectorEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
            InfrastructureRequiredRole source) {
        ComposedStructure container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element.eContainer()) {
            if (element instanceof ComposedStructure) {
                container = (ComposedStructure) element;
            }
        }
        if (container == null) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> links = container.getConnectors__ComposedStructure().iterator(); links.hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof AssemblyInfrastructureConnector) {
                continue;
            }
            AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) linkObject;
            if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            InfrastructureProvidedRole dst = link.getProvidedRole__AssemblyInfrastructureConnector();
            InfrastructureRequiredRole src = link.getRequiredRole__AssemblyInfrastructureConnector();
            if (src != source) {
                continue;
            }
            result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
                    PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
                    AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
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
