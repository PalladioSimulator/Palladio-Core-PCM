/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyInfrastructureConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
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
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelLinkDescriptor;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.Role;

/**
 * Edit policy for the element represented by the canvas. This is not the root element of the system
 * model to be edited.
 * 
 * @generated
 */
public class ComposedProvidingRequiringEntityCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	/**
	 * Get the semantic children for the providing requiring entity.
	 * 
	 * In the composite diagram, the root element is not represented by the canvas, but by the first
	 * included rectangle. To enable this, this edit policy needs to return the system and not the
	 * real children as done in the generated version of this method.
	 *
	 * @return the semantic children list
	 * @generated not
	 */
	@Override
    protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		result.add(modelObject);
		return result;
	}

	// TODO: Find out whether this method has been modified.
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
    protected boolean shouldDeleteView(View view) {
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return view.isSetElement()
					&& (view.getElement() == null || view.getElement()
							.eIsProxy());
		}
		return false;
	}

	/**
	 * Checks if is orphaned.
	 *
	 * @param semanticChildren the semantic children
	 * @param view the view
	 * @return true, if is orphaned
	 * @generated
	 */
	@Override
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the default factory hint.
	 *
	 * @return the default factory hint
	 * @generated
	 */
	@Override
    protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * Gets the semantic connections list.
	 *
	 * @return the semantic connections list
	 * @generated
	 */
	@Override
    protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the source element.
	 *
	 * @param relationship the relationship
	 * @return the source element
	 * @generated
	 */
	@Override
    protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * Gets the target element.
	 *
	 * @param relationship the relationship
	 * @return the target element
	 * @generated
	 */
	@Override
    protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * Should include connection.
	 *
	 * @param connector the connector
	 * @param children the children
	 * @return true, if successful
	 * @generated
	 */
	@Override
    protected boolean shouldIncludeConnection(Edge connector,
			Collection children) {
		return false;
	}

	/**
	 * Refresh semantic.
	 *
	 * @generated
	 */
	@Override
    protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
					.getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * Refresh connections.
	 *
	 * @return the collection
	 * @generated
	 */
	private Collection refreshConnections() {
		Map domain2NotationMap = new HashMap();
		Collection linkDescriptors = collectAllLinks(getDiagram(),
				domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator
				.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = PalladioComponentModelVisualIDRegistry
					.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null
						&& nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
					.hasNext();) {
				PalladioComponentModelLinkDescriptor nextLinkDescriptor = (PalladioComponentModelLinkDescriptor) linkDescriptorsIterator
						.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement()
						&& diagramLinkSrc == nextLinkDescriptor.getSource()
						&& diagramLinkDst == nextLinkDescriptor
								.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor
								.getVisualID()) {
					linksIterator.remove();
					linkDescriptorsIterator.remove();
					break;
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * Collect all links.
	 *
	 * @param view the view
	 * @param domain2NotationMap the domain2 notation map
	 * @return the collection
	 * @generated
	 */
	private Collection collectAllLinks(View view, Map domain2NotationMap) {
		if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID
				.equals(PalladioComponentModelVisualIDRegistry.getModelID(view))) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getComposedProvidingRequiringEntity_1000ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getComposedProvidingRequiringEntity_2002ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case AssemblyContextEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getAssemblyContext_3006ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case OperationProvidedRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getOperationProvidedRole_3007ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case OperationRequiredRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getOperationRequiredRole_3008ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case SourceRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getSourceRole_3013ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case SinkRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getSinkRole_3014ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case InfrastructureProvidedRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getInfrastructureProvidedRole_3015ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case InfrastructureRequiredRoleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getInfrastructureRequiredRole_3016ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case OperationProvidedRole2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getOperationProvidedRole_3011ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case OperationRequiredRole2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getOperationRequiredRole_3012ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case EventChannelEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getEventChannel_3017ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case EventChannelSinkConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getEventChannelSinkConnector_4010ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case EventChannelSourceConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getEventChannelSourceConnector_4009ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case AssemblyConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getAssemblyConnector_4004ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case AssemblyEventConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(PalladioComponentModelDiagramUpdater
						.getAssemblyEventConnector_4007ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case RequiredDelegationConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getRequiredDelegationConnector_4005ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case ProvidedDelegationConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getProvidedDelegationConnector_4006ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case AssemblyInfrastructureConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(PalladioComponentModelDiagramUpdater
								.getAssemblyInfrastructureConnector_4008ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement())
					|| view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children
				.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(),
					domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(),
					domain2NotationMap));
		}
		return result;
	}


	// newly created, may cause problems!
	// well, it actually did cause problems and it will again in the future. so here follows the
	// warning: :P
	// ---------------------------------------------------------------------------------------------------------------------
	// WARNING: THIS WILL BREAK EASYLY BY ADDING OR MODIFYING NEW CONNECTORS OR IF THE VISUAL ID OF
	// COMPARTEMENTS CHANGES!!!
	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * This method is responsible for creating the links between the connectors/roles. The default
	 * behavior has been augmented so not only the role will be considered but the context, too.
	 * Modifications became necessary as multiple instances of one or more components in a composite
	 * component would otherwise lead to false connections in the graphical editors only regarding
	 * one element as source and one as destination. The second parameter of type Map doesn't need
	 * to be specified, as it will not be used, it's still there only for compatibility.
	 * 
	 * @param linkDescriptors
	 *            - collection of linkDescriptors
	 * @param domain2NotationMap
	 *            - will not be considered, thus can be any value
	 * 
	 * @return list of adapters
	 * 
	 *         This method has been manually modified.
	 * 
	 * @generated NOT
	 */
	private Collection createConnections(Collection linkDescriptors,
			Map domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
				.hasNext();) {
			final PalladioComponentModelLinkDescriptor nextLinkDescriptor = (PalladioComponentModelLinkDescriptor) linkDescriptorsIterator
					.next();

			// begin of modified code
			EditPart sourceEditPart = null;
			EditPart targetEditPart = null;

			if (nextLinkDescriptor.getModelElement() instanceof AssemblyConnector) {
				AssemblyConnector ctx = (AssemblyConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), ctx
						.getRequiringAssemblyContext_AssemblyConnector());
				targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getDestination(), ctx
						.getProvidingAssemblyContext_AssemblyConnector());
			} else if (nextLinkDescriptor.getModelElement() instanceof AssemblyEventConnector) {
				AssemblyEventConnector ctx = (AssemblyEventConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), ctx
						.getSourceAssemblyContext__AssemblyEventConnector());
				targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getDestination(), ctx
						.getSinkAssemblyContext__AssemblyEventConnector());
			} else if (nextLinkDescriptor.getModelElement() instanceof EventChannelSourceConnector) {
				EventChannelSourceConnector ctx = (EventChannelSourceConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), ctx
						.getAssemblyContext__EventChannelSourceConnector());
				targetEditPart = getEditPart(nextLinkDescriptor
						.getDestination(), domain2NotationMap);
			} else if (nextLinkDescriptor.getModelElement() instanceof EventChannelSinkConnector) {
				EventChannelSinkConnector ctx = (EventChannelSinkConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), ctx
						.getAssemblyContext__EventChannelSinkConnector());
				targetEditPart = getEditPart(nextLinkDescriptor
						.getDestination(), domain2NotationMap);
			} else if (nextLinkDescriptor.getModelElement() instanceof AssemblyInfrastructureConnector) {
				AssemblyInfrastructureConnector ctx = (AssemblyInfrastructureConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor(
						(Role) nextLinkDescriptor.getSource(),
						ctx
								.getRequiringAssemblyContext__AssemblyInfrastructureConnector());
				targetEditPart = myGetEditPartFor(
						(Role) nextLinkDescriptor.getDestination(),
						ctx
								.getProvidingAssemblyContext__AssemblyInfrastructureConnector());
			} else if (nextLinkDescriptor.getModelElement() instanceof ProvidedDelegationConnector) {
				ProvidedDelegationConnector ctx = (ProvidedDelegationConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), null);
				targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getDestination(), ctx
						.getAssemblyContext_ProvidedDelegationConnector());
			} else if (nextLinkDescriptor.getModelElement() instanceof RequiredDelegationConnector) {
				RequiredDelegationConnector ctx = (RequiredDelegationConnector) nextLinkDescriptor
						.getModelElement();
				sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getSource(), ctx
						.getAssemblyContext_RequiredDelegationConnector());
				targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor
						.getDestination(), null);
			}
			// end of modified code
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
					nextLinkDescriptor.getSemanticAdapter(), String
							.valueOf(nextLinkDescriptor.getVisualID()),
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost())
							.getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(
					descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * Gets the edits the part.
	 *
	 * @param domainModelElement the domain model element
	 * @param domain2NotationMap the domain2 notation map
	 * @return the edits the part
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement,
			Map domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(
					view);
		}
		return null;
	}

	/**
	 * Returns the EditPart for a given combination of Role and AssemblyContext. This is crucial for
	 * correctly displaying links if there are multiple instances of the same component in an
	 * assemblyContext, hence multiple times the same role (with identical ID). This method has been
	 * most likely manually added.
	 * 
	 * @param modelElement
	 *            - Role to be searched
	 * @param ctx
	 *            - AssemblyContext to be searched
	 * @return EditPart that belongs to the Role in the AssemblyContext if existent, null otherwise
	 * 
	 * @generated not
	 */
	private EditPart myGetEditPartFor(Role modelElement, AssemblyContext ctx) {
		View view = null;
		Diagram dia = getDiagram();
		Node pseudoNode = (Node) dia.getChildren().get(0);
		if (ctx == null) {
			for (Object n : pseudoNode.getChildren()) {
				if (n instanceof Node) {
					Node node = (Node) n;
					if (!node.getType().equals("7002")
							&& node.getElement() == modelElement) {
                        view = node;
                    }
				}
			}
		} else {
			Node compartment = getCompartmentNode(pseudoNode.getChildren());
			for (Object n : compartment.getChildren()) {
				if (n instanceof Node) {
					Node node = (Node) n;
					if (node.getElement() == ctx) {
						view = getRoleChild(node, modelElement);
					}
				}
			}
		}
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(
					view);
		}
		return null;
	}

	/**
	 * Returns the the child node of myNode, thats element attribute references modelElement. This
	 * method was manually added.
	 * 
	 * @param myNode
	 *            - parent node whose children will be checked
	 * @param modelElement
	 *            - role for which to search
	 * @return node - the child node of myNode, thats element attribute references the role
	 *         modelElement, if existent, null otherwise
	 * 
	 * @generated NOT
	 */
	private View getRoleChild(Node myNode, Role modelElement) {
		for (Object n : myNode.getChildren()) {
			if (n instanceof Node) {
				Node node = (Node) n;
				if (node.getElement() == modelElement) {
					return node;
				}
			}
		}
		return null;
	}

	/**
	 * Returns one CompartmentNode out of a list of nodes if there is at least one included. This
	 * method was manually added.
	 *
	 * @param nodeList the node list
	 * @return node - one compartementNode if there is a node of that type, null otherwise
	 * @generated NOT
	 */
	private Node getCompartmentNode(EList nodeList) {
		for (Object n : nodeList) {
			if (n instanceof Node) {
				Node node = (Node) n;
				if (node.getType().equals("7002")) {
                    return node;
                }

			}
		}
		return null;
	}

	/**
	 * Gets the diagram.
	 *
	 * @return the diagram
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

}
