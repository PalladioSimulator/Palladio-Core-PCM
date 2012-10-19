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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
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
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * The Class PalladioComponentModelDiagramUpdater.
 *
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

	/**
	 * Gets the semantic children.
	 *
	 * @param view the view
	 * @return the semantic children
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntity_2002SemanticChildren(view);
		case AssemblyContextEditPart.VISUAL_ID:
			return getAssemblyContext_3006SemanticChildren(view);
		case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7002SemanticChildren(view);
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
			return getComposedProvidingRequiringEntity_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the composed providing requiring entity_2002 semantic children.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_2002 semantic children
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_2002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
				.getProvidedRoles_InterfaceProvidingEntity().iterator(); it
				.hasNext();) {
			ProvidedRole childElement = (ProvidedRole) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == OperationProvidedRole2EditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement
				.getRequiredRoles_InterfaceRequiringEntity().iterator(); it
				.hasNext();) {
			RequiredRole childElement = (RequiredRole) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == OperationRequiredRole2EditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
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
	 * TODO: This method contains duplicated semantic to the AssemblyContextCanonicalEditPolicy The
	 * CononicalEditPolicy method might include a call to this one and because of this it has to be
	 * checked if the generated not in the AssemblyContextCanonicalEditPolicy could be removed
	 *
	 * @param view the view
	 * @return the assembly context_3006 semantic children
	 * @generated not
	 */
	public static List getAssemblyContext_3006SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AssemblyContext modelElement = (AssemblyContext) view.getElement();
		// Manual navigation to the associated component is required
		RepositoryComponent component = modelElement
				.getEncapsulatedComponent__AssemblyContext();

		// check if the component is really set for this assembly context. otherwise, it will break
		if (component == null) {
			return Collections.EMPTY_LIST;
		}

		List result = new LinkedList();
		for (Iterator it = component
				.getProvidedRoles_InterfaceProvidingEntity().iterator(); it
				.hasNext();) {
			ProvidedRole childElement = (ProvidedRole) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == OperationProvidedRoleEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator it = component
				.getRequiredRoles_InterfaceRequiringEntity().iterator(); it
				.hasNext();) {
			RequiredRole childElement = (RequiredRole) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == OperationRequiredRoleEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * Gets the composed providing requiring entity composite structure inner compartment_7002 semantic children.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity composite structure inner compartment_7002 semantic children
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntityCompositeStructureInnerCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement
				.getProvidedRoles_InterfaceProvidingEntity().iterator(); it
				.hasNext();) {
			ProvidedRole childElement = (ProvidedRole) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == AssemblyContextEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getEventChannel__ComposedStructure()
				.iterator(); it.hasNext();) {
			EventChannel childElement = (EventChannel) it.next();
			int visualID = PalladioComponentModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == EventChannelEditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * Gets the composed providing requiring entity_1000 semantic children.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_1000 semantic children
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view
				.getElement();
		List result = new LinkedList();
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator
				.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (PalladioComponentModelVisualIDRegistry.getNodeVisualID(view,
					childElement) == ComposedProvidingRequiringEntity2EditPart.VISUAL_ID) {
				result.add(new PalladioComponentModelNodeDescriptor(
						childElement,
						ComposedProvidingRequiringEntity2EditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * Gets the phantom nodes iterator.
	 *
	 * @param resource the resource
	 * @return the phantom nodes iterator
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * Gets the contained links.
	 *
	 * @param view the view
	 * @return the contained links
	 * @generated
	 */
	public static List getContainedLinks(View view) {
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
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the incoming links.
	 *
	 * @param view the view
	 * @return the incoming links
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
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
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the outgoing links.
	 *
	 * @param view the view
	 * @return the outgoing links
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
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
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the composed providing requiring entity_1000 contained links.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_1000 contained links
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_1000ContainedLinks(
			View view) {
		ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
		return result;
	}

	/**
	 * Gets the composed providing requiring entity_2002 contained links.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_2002 contained links
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_2002ContainedLinks(
			View view) {
		ComposedProvidingRequiringEntity modelElement = (ComposedProvidingRequiringEntity) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
		return result;
	}

	/**
	 * Gets the assembly context_3006 contained links.
	 *
	 * @param view the view
	 * @return the assembly context_3006 contained links
	 * @generated
	 */
	public static List getAssemblyContext_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation provided role_3007 contained links.
	 *
	 * @param view the view
	 * @return the operation provided role_3007 contained links
	 * @generated
	 */
	public static List getOperationProvidedRole_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation required role_3008 contained links.
	 *
	 * @param view the view
	 * @return the operation required role_3008 contained links
	 * @generated
	 */
	public static List getOperationRequiredRole_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the source role_3013 contained links.
	 *
	 * @param view the view
	 * @return the source role_3013 contained links
	 * @generated
	 */
	public static List getSourceRole_3013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the sink role_3014 contained links.
	 *
	 * @param view the view
	 * @return the sink role_3014 contained links
	 * @generated
	 */
	public static List getSinkRole_3014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the infrastructure provided role_3015 contained links.
	 *
	 * @param view the view
	 * @return the infrastructure provided role_3015 contained links
	 * @generated
	 */
	public static List getInfrastructureProvidedRole_3015ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the infrastructure required role_3016 contained links.
	 *
	 * @param view the view
	 * @return the infrastructure required role_3016 contained links
	 * @generated
	 */
	public static List getInfrastructureRequiredRole_3016ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation provided role_3011 contained links.
	 *
	 * @param view the view
	 * @return the operation provided role_3011 contained links
	 * @generated
	 */
	public static List getOperationProvidedRole_3011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation required role_3012 contained links.
	 *
	 * @param view the view
	 * @return the operation required role_3012 contained links
	 * @generated
	 */
	public static List getOperationRequiredRole_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly connector_4004 contained links.
	 *
	 * @param view the view
	 * @return the assembly connector_4004 contained links
	 * @generated
	 */
	public static List getEventChannel_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSinkConnector_4010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSourceConnector_4009ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssemblyConnector_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly event connector_4007 contained links.
	 *
	 * @param view the view
	 * @return the assembly event connector_4007 contained links
	 * @generated
	 */
	public static List getAssemblyEventConnector_4007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the required delegation connector_4005 contained links.
	 *
	 * @param view the view
	 * @return the required delegation connector_4005 contained links
	 * @generated
	 */
	public static List getRequiredDelegationConnector_4005ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the provided delegation connector_4006 contained links.
	 *
	 * @param view the view
	 * @return the provided delegation connector_4006 contained links
	 * @generated
	 */
	public static List getProvidedDelegationConnector_4006ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly infrastructure connector_4008 contained links.
	 *
	 * @param view the view
	 * @return the assembly infrastructure connector_4008 contained links
	 * @generated
	 */
	public static List getAssemblyInfrastructureConnector_4008ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the composed providing requiring entity_2002 incoming links.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_2002 incoming links
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_2002IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly context_3006 incoming links.
	 *
	 * @param view the view
	 * @return the assembly context_3006 incoming links
	 * @generated
	 */
	public static List getAssemblyContext_3006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation provided role_3007 incoming links.
	 *
	 * @param view the view
	 * @return the operation provided role_3007 incoming links
	 * @generated
	 */
	public static List getOperationProvidedRole_3007IncomingLinks(View view) {
		OperationProvidedRole modelElement = (OperationProvidedRole) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssemblyConnector_4004(
				modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the operation required role_3008 incoming links.
	 *
	 * @param view the view
	 * @return the operation required role_3008 incoming links
	 * @generated
	 */
	public static List getOperationRequiredRole_3008IncomingLinks(View view) {
		OperationRequiredRole modelElement = (OperationRequiredRole) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the source role_3013 incoming links.
	 *
	 * @param view the view
	 * @return the source role_3013 incoming links
	 * @generated
	 */
	public static List getSourceRole_3013IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the sink role_3014 incoming links.
	 *
	 * @param view the view
	 * @return the sink role_3014 incoming links
	 * @generated
	 */
	public static List getSinkRole_3014IncomingLinks(View view) {
		SinkRole modelElement = (SinkRole) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_AssemblyEventConnector_4007(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the infrastructure provided role_3015 incoming links.
	 *
	 * @param view the view
	 * @return the infrastructure provided role_3015 incoming links
	 * @generated
	 */
	public static List getInfrastructureProvidedRole_3015IncomingLinks(View view) {
		InfrastructureProvidedRole modelElement = (InfrastructureProvidedRole) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the infrastructure required role_3016 incoming links.
	 *
	 * @param view the view
	 * @return the infrastructure required role_3016 incoming links
	 * @generated
	 */
	public static List getInfrastructureRequiredRole_3016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation provided role_3011 incoming links.
	 *
	 * @param view the view
	 * @return the operation provided role_3011 incoming links
	 * @generated
	 */
	public static List getOperationProvidedRole_3011IncomingLinks(View view) {
		OperationProvidedRole modelElement = (OperationProvidedRole) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssemblyConnector_4004(
				modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the operation required role_3012 incoming links.
	 *
	 * @param view the view
	 * @return the operation required role_3012 incoming links
	 * @generated
	 */
	public static List getOperationRequiredRole_3012IncomingLinks(View view) {
		OperationRequiredRole modelElement = (OperationRequiredRole) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * Gets the assembly connector_4004 incoming links.
	 *
	 * @param view the view
	 * @return the assembly connector_4004 incoming links
	 * @generated
	 */
	public static List getEventChannel_3017IncomingLinks(View view) {
		EventChannel modelElement = (EventChannel) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_EventChannelSinkConnector_4010(
						modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_EventChannelSourceConnector_4009(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSinkConnector_4010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSourceConnector_4009IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssemblyConnector_4004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly event connector_4007 incoming links.
	 *
	 * @param view the view
	 * @return the assembly event connector_4007 incoming links
	 * @generated
	 */
	public static List getAssemblyEventConnector_4007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the required delegation connector_4005 incoming links.
	 *
	 * @param view the view
	 * @return the required delegation connector_4005 incoming links
	 * @generated
	 */
	public static List getRequiredDelegationConnector_4005IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the provided delegation connector_4006 incoming links.
	 *
	 * @param view the view
	 * @return the provided delegation connector_4006 incoming links
	 * @generated
	 */
	public static List getProvidedDelegationConnector_4006IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly infrastructure connector_4008 incoming links.
	 *
	 * @param view the view
	 * @return the assembly infrastructure connector_4008 incoming links
	 * @generated
	 */
	public static List getAssemblyInfrastructureConnector_4008IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the composed providing requiring entity_2002 outgoing links.
	 *
	 * @param view the view
	 * @return the composed providing requiring entity_2002 outgoing links
	 * @generated
	 */
	public static List getComposedProvidingRequiringEntity_2002OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly context_3006 outgoing links.
	 *
	 * @param view the view
	 * @return the assembly context_3006 outgoing links
	 * @generated
	 */
	public static List getAssemblyContext_3006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the operation provided role_3007 outgoing links.
	 *
	 * @param view the view
	 * @return the operation provided role_3007 outgoing links
	 * @generated
	 */
	public static List getOperationProvidedRole_3007OutgoingLinks(View view) {
		OperationProvidedRole modelElement = (OperationProvidedRole) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
		return result;
	}

	/**
	 * Gets the operation required role_3008 outgoing links.
	 *
	 * @param view the view
	 * @return the operation required role_3008 outgoing links
	 * @generated
	 */
	public static List getOperationRequiredRole_3008OutgoingLinks(View view) {
		OperationRequiredRole modelElement = (OperationRequiredRole) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
		return result;
	}

	/**
	 * Gets the source role_3013 outgoing links.
	 *
	 * @param view the view
	 * @return the source role_3013 outgoing links
	 * @generated
	 */
	public static List getSourceRole_3013OutgoingLinks(View view) {
		SourceRole modelElement = (SourceRole) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_EventChannelSourceConnector_4009(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssemblyEventConnector_4007(modelElement));
		return result;
	}

	/**
	 * Gets the sink role_3014 outgoing links.
	 *
	 * @param view the view
	 * @return the sink role_3014 outgoing links
	 * @generated
	 */
	public static List getSinkRole_3014OutgoingLinks(View view) {
		SinkRole modelElement = (SinkRole) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_EventChannelSinkConnector_4010(modelElement));
		return result;
	}

	/**
	 * Gets the infrastructure provided role_3015 outgoing links.
	 *
	 * @param view the view
	 * @return the infrastructure provided role_3015 outgoing links
	 * @generated
	 */
	public static List getInfrastructureProvidedRole_3015OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the infrastructure required role_3016 outgoing links.
	 *
	 * @param view the view
	 * @return the infrastructure required role_3016 outgoing links
	 * @generated
	 */
	public static List getInfrastructureRequiredRole_3016OutgoingLinks(View view) {
		InfrastructureRequiredRole modelElement = (InfrastructureRequiredRole) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(modelElement));
		return result;
	}

	/**
	 * Gets the operation provided role_3011 outgoing links.
	 *
	 * @param view the view
	 * @return the operation provided role_3011 outgoing links
	 * @generated
	 */
	public static List getOperationProvidedRole_3011OutgoingLinks(View view) {
		OperationProvidedRole modelElement = (OperationProvidedRole) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(modelElement));
		return result;
	}

	/**
	 * Gets the operation required role_3012 outgoing links.
	 *
	 * @param view the view
	 * @return the operation required role_3012 outgoing links
	 * @generated
	 */
	public static List getOperationRequiredRole_3012OutgoingLinks(View view) {
		OperationRequiredRole modelElement = (OperationRequiredRole) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(modelElement));
		return result;
	}

	/**
	 * Gets the assembly connector_4004 outgoing links.
	 *
	 * @param view the view
	 * @return the assembly connector_4004 outgoing links
	 * @generated
	 */
	public static List getEventChannel_3017OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSinkConnector_4010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventChannelSourceConnector_4009OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssemblyConnector_4004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly event connector_4007 outgoing links.
	 *
	 * @param view the view
	 * @return the assembly event connector_4007 outgoing links
	 * @generated
	 */
	public static List getAssemblyEventConnector_4007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the required delegation connector_4005 outgoing links.
	 *
	 * @param view the view
	 * @return the required delegation connector_4005 outgoing links
	 * @generated
	 */
	public static List getRequiredDelegationConnector_4005OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the provided delegation connector_4006 outgoing links.
	 *
	 * @param view the view
	 * @return the provided delegation connector_4006 outgoing links
	 * @generated
	 */
	public static List getProvidedDelegationConnector_4006OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the assembly infrastructure connector_4008 outgoing links.
	 *
	 * @param view the view
	 * @return the assembly infrastructure connector_4008 outgoing links
	 * @generated
	 */
	public static List getAssemblyInfrastructureConnector_4008OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the contained type model facet links_ assembly connector_4004.
	 *
	 * @param container the container
	 * @return the contained type model facet links_ assembly connector_4004
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EventChannelSinkConnector_4010(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof EventChannelSinkConnector) {
				continue;
			}
			EventChannelSinkConnector link = (EventChannelSinkConnector) linkObject;
			if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventChannel dst = link
					.getEventChannel__EventChannelSinkConnector();
			SinkRole src = link.getSinkRole__EventChannelSinkConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
							EventChannelSinkConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EventChannelSourceConnector_4009(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof EventChannelSourceConnector) {
				continue;
			}
			EventChannelSourceConnector link = (EventChannelSourceConnector) linkObject;
			if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventChannel dst = link
					.getEventChannel__EventChannelSourceConnector();
			SourceRole src = link.getSourceRole__EventChannelSourceRole();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
							EventChannelSourceConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_AssemblyConnector_4004(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssemblyConnector) {
				continue;
			}
			AssemblyConnector link = (AssemblyConnector) linkObject;
			if (AssemblyConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationProvidedRole dst = link
					.getProvidedRole_AssemblyConnector();
			OperationRequiredRole src = link
					.getRequiredRole_AssemblyConnector();
			result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
					PalladioComponentModelElementTypes.AssemblyConnector_4004,
					AssemblyConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the contained type model facet links_ assembly event connector_4007.
	 *
	 * @param container the container
	 * @return the contained type model facet links_ assembly event connector_4007
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_AssemblyEventConnector_4007(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
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
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
							AssemblyEventConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the contained type model facet links_ required delegation connector_4005.
	 *
	 * @param container the container
	 * @return the contained type model facet links_ required delegation connector_4005
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_RequiredDelegationConnector_4005(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RequiredDelegationConnector) {
				continue;
			}
			RequiredDelegationConnector link = (RequiredDelegationConnector) linkObject;
			if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationRequiredRole dst = link
					.getOuterRequiredRole_RequiredDelegationConnector();
			OperationRequiredRole src = link
					.getInnerRequiredRole_RequiredDelegationConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
							RequiredDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the contained type model facet links_ provided delegation connector_4006.
	 *
	 * @param container the container
	 * @return the contained type model facet links_ provided delegation connector_4006
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProvidedDelegationConnector_4006(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ProvidedDelegationConnector) {
				continue;
			}
			ProvidedDelegationConnector link = (ProvidedDelegationConnector) linkObject;
			if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationProvidedRole dst = link
					.getInnerProvidedRole_ProvidedDelegationConnector();
			OperationProvidedRole src = link
					.getOuterProvidedRole_ProvidedDelegationConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
							ProvidedDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the contained type model facet links_ assembly infrastructure connector_4008.
	 *
	 * @param container the container
	 * @return the contained type model facet links_ assembly infrastructure connector_4008
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
			ComposedStructure container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssemblyInfrastructureConnector) {
				continue;
			}
			AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) linkObject;
			if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InfrastructureProvidedRole dst = link
					.getProvidedRole__AssemblyInfrastructureConnector();
			InfrastructureRequiredRole src = link
					.getRequiredRole__AssemblyInfrastructureConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
							AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the incoming type model facet links_ assembly connector_4004.
	 *
	 * @param target the target
	 * @param crossReferences the cross references
	 * @return the incoming type model facet links_ assembly connector_4004
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_EventChannelSinkConnector_4010(
			EventChannel target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getEventChannelSinkConnector_EventChannel__EventChannelSinkConnector()
					|| false == setting.getEObject() instanceof EventChannelSinkConnector) {
				continue;
			}
			EventChannelSinkConnector link = (EventChannelSinkConnector) setting
					.getEObject();
			if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			SinkRole src = link.getSinkRole__EventChannelSinkConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
							EventChannelSinkConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_EventChannelSourceConnector_4009(
			EventChannel target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getEventChannelSourceConnector_EventChannel__EventChannelSourceConnector()
					|| false == setting.getEObject() instanceof EventChannelSourceConnector) {
				continue;
			}
			EventChannelSourceConnector link = (EventChannelSourceConnector) setting
					.getEObject();
			if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			SourceRole src = link.getSourceRole__EventChannelSourceRole();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
							EventChannelSourceConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_AssemblyConnector_4004(
			OperationProvidedRole target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
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
			OperationRequiredRole src = link
					.getRequiredRole_AssemblyConnector();
			result.add(new PalladioComponentModelLinkDescriptor(src, target,
					link,
					PalladioComponentModelElementTypes.AssemblyConnector_4004,
					AssemblyConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the incoming type model facet links_ assembly event connector_4007.
	 *
	 * @param target the target
	 * @param crossReferences the cross references
	 * @return the incoming type model facet links_ assembly event connector_4007
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_AssemblyEventConnector_4007(
			SinkRole target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getAssemblyEventConnector_SinkRole__AssemblyEventConnector()
					|| false == setting.getEObject() instanceof AssemblyEventConnector) {
				continue;
			}
			AssemblyEventConnector link = (AssemblyEventConnector) setting
					.getEObject();
			if (AssemblyEventConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			SourceRole src = link.getSourceRole__AssemblyEventConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
							AssemblyEventConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the incoming type model facet links_ required delegation connector_4005.
	 *
	 * @param target the target
	 * @param crossReferences the cross references
	 * @return the incoming type model facet links_ required delegation connector_4005
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_RequiredDelegationConnector_4005(
			OperationRequiredRole target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector()
					|| false == setting.getEObject() instanceof RequiredDelegationConnector) {
				continue;
			}
			RequiredDelegationConnector link = (RequiredDelegationConnector) setting
					.getEObject();
			if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationRequiredRole src = link
					.getInnerRequiredRole_RequiredDelegationConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
							RequiredDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the incoming type model facet links_ provided delegation connector_4006.
	 *
	 * @param target the target
	 * @param crossReferences the cross references
	 * @return the incoming type model facet links_ provided delegation connector_4006
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
			OperationProvidedRole target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector()
					|| false == setting.getEObject() instanceof ProvidedDelegationConnector) {
				continue;
			}
			ProvidedDelegationConnector link = (ProvidedDelegationConnector) setting
					.getEObject();
			if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationProvidedRole src = link
					.getOuterProvidedRole_ProvidedDelegationConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
							ProvidedDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the incoming type model facet links_ assembly infrastructure connector_4008.
	 *
	 * @param target the target
	 * @param crossReferences the cross references
	 * @return the incoming type model facet links_ assembly infrastructure connector_4008
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
			InfrastructureProvidedRole target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CompositionPackage.eINSTANCE
					.getAssemblyInfrastructureConnector_ProvidedRole__AssemblyInfrastructureConnector()
					|| false == setting.getEObject() instanceof AssemblyInfrastructureConnector) {
				continue;
			}
			AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) setting
					.getEObject();
			if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InfrastructureRequiredRole src = link
					.getRequiredRole__AssemblyInfrastructureConnector();
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							target,
							link,
							PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
							AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the outgoing type model facet links_ assembly connector_4004.
	 *
	 * @param source the source
	 * @return the outgoing type model facet links_ assembly connector_4004
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_EventChannelSinkConnector_4010(
			SinkRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof EventChannelSinkConnector) {
				continue;
			}
			EventChannelSinkConnector link = (EventChannelSinkConnector) linkObject;
			if (EventChannelSinkConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventChannel dst = link
					.getEventChannel__EventChannelSinkConnector();
			SinkRole src = link.getSinkRole__EventChannelSinkConnector();
			if (src != source) {
				continue;
			}
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.EventChannelSinkConnector_4010,
							EventChannelSinkConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_EventChannelSourceConnector_4009(
			SourceRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof EventChannelSourceConnector) {
				continue;
			}
			EventChannelSourceConnector link = (EventChannelSourceConnector) linkObject;
			if (EventChannelSourceConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			EventChannel dst = link
					.getEventChannel__EventChannelSourceConnector();
			SourceRole src = link.getSourceRole__EventChannelSourceRole();
			if (src != source) {
				continue;
			}
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.EventChannelSourceConnector_4009,
							EventChannelSourceConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_AssemblyConnector_4004(
			OperationRequiredRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssemblyConnector) {
				continue;
			}
			AssemblyConnector link = (AssemblyConnector) linkObject;
			if (AssemblyConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationProvidedRole dst = link
					.getProvidedRole_AssemblyConnector();
			OperationRequiredRole src = link
					.getRequiredRole_AssemblyConnector();
			if (src != source) {
				continue;
			}
			result.add(new PalladioComponentModelLinkDescriptor(src, dst, link,
					PalladioComponentModelElementTypes.AssemblyConnector_4004,
					AssemblyConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the outgoing type model facet links_ assembly event connector_4007.
	 *
	 * @param source the source
	 * @return the outgoing type model facet links_ assembly event connector_4007
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_AssemblyEventConnector_4007(
			SourceRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
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
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.AssemblyEventConnector_4007,
							AssemblyEventConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the outgoing type model facet links_ required delegation connector_4005.
	 *
	 * @param source the source
	 * @return the outgoing type model facet links_ required delegation connector_4005
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_RequiredDelegationConnector_4005(
			OperationRequiredRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof RequiredDelegationConnector) {
				continue;
			}
			RequiredDelegationConnector link = (RequiredDelegationConnector) linkObject;
			if (RequiredDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationRequiredRole dst = link
					.getOuterRequiredRole_RequiredDelegationConnector();
			OperationRequiredRole src = link
					.getInnerRequiredRole_RequiredDelegationConnector();
			if (src != source) {
				continue;
			}
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.RequiredDelegationConnector_4005,
							RequiredDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the outgoing type model facet links_ provided delegation connector_4006.
	 *
	 * @param source the source
	 * @return the outgoing type model facet links_ provided delegation connector_4006
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ProvidedDelegationConnector_4006(
			OperationProvidedRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ProvidedDelegationConnector) {
				continue;
			}
			ProvidedDelegationConnector link = (ProvidedDelegationConnector) linkObject;
			if (ProvidedDelegationConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OperationProvidedRole dst = link
					.getInnerProvidedRole_ProvidedDelegationConnector();
			OperationProvidedRole src = link
					.getOuterProvidedRole_ProvidedDelegationConnector();
			if (src != source) {
				continue;
			}
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006,
							ProvidedDelegationConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Gets the outgoing type model facet links_ assembly infrastructure connector_4008.
	 *
	 * @param source the source
	 * @return the outgoing type model facet links_ assembly infrastructure connector_4008
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_AssemblyInfrastructureConnector_4008(
			InfrastructureRequiredRole source) {
		ComposedStructure container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ComposedStructure) {
				container = (ComposedStructure) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors__ComposedStructure()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssemblyInfrastructureConnector) {
				continue;
			}
			AssemblyInfrastructureConnector link = (AssemblyInfrastructureConnector) linkObject;
			if (AssemblyInfrastructureConnectorEditPart.VISUAL_ID != PalladioComponentModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InfrastructureProvidedRole dst = link
					.getProvidedRole__AssemblyInfrastructureConnector();
			InfrastructureRequiredRole src = link
					.getRequiredRole__AssemblyInfrastructureConnector();
			if (src != source) {
				continue;
			}
			result
					.add(new PalladioComponentModelLinkDescriptor(
							src,
							dst,
							link,
							PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008,
							AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

}
