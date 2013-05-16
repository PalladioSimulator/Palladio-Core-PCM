/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;

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
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelLinkDescriptor;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.Role;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntityCanonicalEditPolicy extends CanonicalEditPolicy {

    // TODO: Find out whether this method has been added manually.
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldDeleteView
     * (org.eclipse.gmf.runtime.notation.View)
     */
    @Override
    protected boolean shouldDeleteView(View view) {
        if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
            return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
        }
        return false;
    }

    /**
     * @generated
     */
    protected void refreshOnActivate() {
        // Need to activate editpart children before invoking the canonical refresh for EditParts to
        // add event listeners
        List<?> c = getHost().getChildren();
        for (int i = 0; i < c.size(); i++) {
            ((EditPart) c.get(i)).activate();
        }
        super.refreshOnActivate();
    }

    /**
     * Get the semantic children for the providing requiring entity.
     * 
     * In the composite diagram, the root element is not represented by the canvas, but by the first
     * included rectangle. To enable this, this edit policy needs to return the system and not the
     * real children as done in the generated version of this method.
     * 
     * Since GMF3, this modification is applied to PalladioComponentModelDiagramUpdater, as well (or
     * instead). Thus, this modification is currently reverted to generated code.
     * 
     * @return the semantic children list
     * @generated
     */
    @Override
    @SuppressWarnings("rawtypes")
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        LinkedList<EObject> result = new LinkedList<EObject>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getComposedProvidingRequiringEntity_1000SemanticChildren(viewObject);
        for (PalladioComponentModelNodeDescriptor d : childDescriptors) {
            result.add(d.getModelElement());
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
        return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
    }

    /**
     * @generated
     */
    private boolean isMyDiagramElement(View view) {
        return ComposedProvidingRequiringEntity2EditPart.VISUAL_ID == PalladioComponentModelVisualIDRegistry
                .getVisualID(view);
    }

    /**
     * @generated
     */
    protected void refreshSemantic() {
        if (resolveSemanticElement() == null) {
            return;
        }
        LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getComposedProvidingRequiringEntity_1000SemanticChildren((View) getHost().getModel());
        LinkedList<View> orphaned = new LinkedList<View>();
        // we care to check only views we recognize as ours
        LinkedList<View> knownViewChildren = new LinkedList<View>();
        for (View v : getViewChildren()) {
            if (isMyDiagramElement(v)) {
                knownViewChildren.add(v);
            }
        }
        // alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
        //
        // iteration happens over list of desired semantic elements, trying to find best matching
        // View, while original CEP
        // iterates views, potentially losing view (size/bounds) information - i.e. if there are few
        // views to reference same EObject, only last one
        // to answer isOrphaned == true will be used for the domain element representation, see
        // #cleanCanonicalSemanticChildren()
        for (Iterator<PalladioComponentModelNodeDescriptor> descriptorsIterator = childDescriptors.iterator(); descriptorsIterator
                .hasNext();) {
            PalladioComponentModelNodeDescriptor next = descriptorsIterator.next();
            String hint = PalladioComponentModelVisualIDRegistry.getType(next.getVisualID());
            LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint
                                                                    // match that of NodeDescriptor
            for (View childView : getViewChildren()) {
                EObject semanticElement = childView.getElement();
                if (next.getModelElement().equals(semanticElement)) {
                    if (hint.equals(childView.getType())) {
                        perfectMatch.add(childView);
                        // actually, can stop iteration over view children here, but
                        // may want to use not the first view but last one as a 'real' match (the
                        // way original CEP does
                        // with its trick with viewToSemanticMap inside
                        // #cleanCanonicalSemanticChildren
                    }
                }
            }
            if (perfectMatch.size() > 0) {
                descriptorsIterator.remove(); // precise match found no need to create anything for
                                              // the NodeDescriptor
                // use only one view (first or last?), keep rest as orphaned for further
                // consideration
                knownViewChildren.remove(perfectMatch.getFirst());
            }
        }
        // those left in knownViewChildren are subject to removal - they are our diagram elements we
        // didn't find match to,
        // or those we have potential matches to, and thus need to be recreated, preserving
        // size/location information.
        orphaned.addAll(knownViewChildren);
        //
        ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
                childDescriptors.size());
        for (PalladioComponentModelNodeDescriptor next : childDescriptors) {
            String hint = PalladioComponentModelVisualIDRegistry.getType(next.getVisualID());
            IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
            CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter,
                    Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
            viewDescriptors.add(descriptor);
        }

        boolean changed = deleteViews(orphaned.iterator());
        //
        CreateViewRequest request = getCreateViewRequest(viewDescriptors);
        Command cmd = getCreateViewCommand(request);
        if (cmd != null && cmd.canExecute()) {
            SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
            executeCommand(cmd);
            @SuppressWarnings("unchecked")
            List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
            createdViews.addAll(nl);
        }
        if (changed || createdViews.size() > 0) {
            postProcessRefreshSemantic(createdViews);
        }

        Collection<IAdaptable> createdConnectionViews = refreshConnections();

        if (createdViews.size() > 1) {
            // perform a layout of the container
            DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
            executeCommand(new ICommandProxy(layoutCmd));
        }

        createdViews.addAll(createdConnectionViews);

        makeViewsImmutable(createdViews);
    }

    /**
     * @generated
     */
    private Collection<IAdaptable> refreshConnections() {
        Domain2Notation domain2NotationMap = new Domain2Notation();
        Collection<PalladioComponentModelLinkDescriptor> linkDescriptors = collectAllLinks(getDiagram(),
                domain2NotationMap);
        Collection existingLinks = new LinkedList(getDiagram().getEdges());
        for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
            Edge nextDiagramLink = (Edge) linksIterator.next();
            int diagramLinkVisualID = PalladioComponentModelVisualIDRegistry.getVisualID(nextDiagramLink);
            if (diagramLinkVisualID == -1) {
                if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
                    linksIterator.remove();
                }
                continue;
            }
            EObject diagramLinkObject = nextDiagramLink.getElement();
            EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
            EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
            for (Iterator<PalladioComponentModelLinkDescriptor> linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
                    .hasNext();) {
                PalladioComponentModelLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator.next();
                if (diagramLinkObject == nextLinkDescriptor.getModelElement()
                        && diagramLinkSrc == nextLinkDescriptor.getSource()
                        && diagramLinkDst == nextLinkDescriptor.getDestination()
                        && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
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
     * @generated
     */
    private Collection<PalladioComponentModelLinkDescriptor> collectAllLinks(View view,
            Domain2Notation domain2NotationMap) {
        if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(view))) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getComposedProvidingRequiringEntity_1000ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getComposedProvidingRequiringEntity_2002ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AssemblyContextEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getAssemblyContext_3006ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case OperationProvidedRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getOperationProvidedRole_3007ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case OperationRequiredRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getOperationRequiredRole_3008ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case SourceRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getSourceRole_3013ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case SinkRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getSinkRole_3014ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case InfrastructureProvidedRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getInfrastructureProvidedRole_3015ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case InfrastructureRequiredRoleEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getInfrastructureRequiredRole_3016ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case OperationProvidedRole2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getOperationProvidedRole_3011ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case OperationRequiredRole2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getOperationRequiredRole_3012ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case EventChannelEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getEventChannel_3017ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case EventChannelSinkConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getEventChannelSinkConnector_4010ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case EventChannelSourceConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getEventChannelSourceConnector_4009ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AssemblyConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getAssemblyConnector_4004ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AssemblyEventConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getAssemblyEventConnector_4007ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case RequiredDelegationConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getRequiredDelegationConnector_4005ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ProvidedDelegationConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getProvidedDelegationConnector_4006ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getAssemblyInfrastructureConnector_4008ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        }
        for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
            result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
        }
        for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
            result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
        }
        return result;
    }

    // Newly created, may cause problems!
    // Well, it actually did cause problems and it will again in the future. so here follows the
    // warning: :P
    // ---------------------------------------------------------------------------------------------------------------------
    // WARNING: THIS WILL BREAK EASILY BY ADDING OR MODIFYING NEW CONNECTORS, OR IF THE VISUAL ID OF
    // COMPARTMENTS CHANGES!!!
    // ---------------------------------------------------------------------------------------------------------------------
    /**
     * This method is responsible for creating the links between the connectors/roles. The default
     * behavior has been augmented so not only the role will be considered but the context, too.
     * Modifications became necessary as multiple instances of one or more components in a composite
     * component would otherwise lead to false connections in the graphical editors only regarding
     * one element as source and one as destination. The second parameter of type Map doesn't need
     * to be specified, as it will not be used, it's still there only for compatibility.
     * 
     * Cannot be moved to custom plugin, since it is internally called.
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
     * @generated not
     */
    private Collection<IAdaptable> createConnections(Collection<PalladioComponentModelLinkDescriptor> linkDescriptors,
            Domain2Notation domain2NotationMap) {
        // LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
        // for (PalladioComponentModelLinkDescriptor nextLinkDescriptor : linkDescriptors) {
        // EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
        // EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
        // if (sourceEditPart == null || targetEditPart == null) {
        // continue;
        // }
        // CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new
        // CreateConnectionViewRequest.ConnectionViewDescriptor(
        // nextLinkDescriptor.getSemanticAdapter(),
        // PalladioComponentModelVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()),
        // ViewUtil.APPEND,
        // false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
        // CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
        // ccr.setType(RequestConstants.REQ_CONNECTION_START);
        // ccr.setSourceEditPart(sourceEditPart);
        // sourceEditPart.getCommand(ccr);
        // ccr.setTargetEditPart(targetEditPart);
        // ccr.setType(RequestConstants.REQ_CONNECTION_END);
        // Command cmd = targetEditPart.getCommand(ccr);
        // if (cmd != null && cmd.canExecute()) {
        // executeCommand(cmd);
        // IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
        // if (viewAdapter != null) {
        // adapters.add(viewAdapter);
        // }
        // }
        // }
        // return adapters;
        LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
        for (PalladioComponentModelLinkDescriptor nextLinkDescriptor : linkDescriptors) {
            // EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(),
            // domain2NotationMap);
            // EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(),
            // domain2NotationMap);

            // Beginning of modified code
            EditPart sourceEditPart = null;
            EditPart targetEditPart = null;

            if (nextLinkDescriptor.getModelElement() instanceof AssemblyConnector) {
                AssemblyConnector ctx = (AssemblyConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getRequiringAssemblyContext_AssemblyConnector());
                targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getDestination(),
                        ctx.getProvidingAssemblyContext_AssemblyConnector());
            } else if (nextLinkDescriptor.getModelElement() instanceof AssemblyEventConnector) {
                AssemblyEventConnector ctx = (AssemblyEventConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getSourceAssemblyContext__AssemblyEventConnector());
                targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getDestination(),
                        ctx.getSinkAssemblyContext__AssemblyEventConnector());
            } else if (nextLinkDescriptor.getModelElement() instanceof EventChannelSourceConnector) {
                EventChannelSourceConnector ctx = (EventChannelSourceConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getAssemblyContext__EventChannelSourceConnector());
                targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
            } else if (nextLinkDescriptor.getModelElement() instanceof EventChannelSinkConnector) {
                EventChannelSinkConnector ctx = (EventChannelSinkConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getAssemblyContext__EventChannelSinkConnector());
                targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
            } else if (nextLinkDescriptor.getModelElement() instanceof AssemblyInfrastructureConnector) {
                AssemblyInfrastructureConnector ctx = (AssemblyInfrastructureConnector) nextLinkDescriptor
                        .getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getRequiringAssemblyContext__AssemblyInfrastructureConnector());
                targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getDestination(),
                        ctx.getProvidingAssemblyContext__AssemblyInfrastructureConnector());
            } else if (nextLinkDescriptor.getModelElement() instanceof ProvidedDelegationConnector) {
                ProvidedDelegationConnector ctx = (ProvidedDelegationConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(), null);
                targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getDestination(),
                        ctx.getAssemblyContext_ProvidedDelegationConnector());
            } else if (nextLinkDescriptor.getModelElement() instanceof RequiredDelegationConnector) {
                RequiredDelegationConnector ctx = (RequiredDelegationConnector) nextLinkDescriptor.getModelElement();
                sourceEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getSource(),
                        ctx.getAssemblyContext_RequiredDelegationConnector());
                targetEditPart = myGetEditPartFor((Role) nextLinkDescriptor.getDestination(), null);
            }
            // End of modified code

            if (sourceEditPart == null || targetEditPart == null) {
                continue;
            }
            CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
                    nextLinkDescriptor.getSemanticAdapter(),
                    PalladioComponentModelVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND,
                    false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
            CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
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
     * @generated
     */
    private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
        View view = domain2NotationMap.get(domainModelElement);
        if (view != null) {
            return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
        }
        return null;
    }

    /**
     * Returns the EditPart for a given combination of Role and AssemblyContext. This is crucial for
     * correctly displaying links if there are multiple instances of the same component in an
     * assemblyContext, hence multiple times the same role (with identical ID). This method has been
     * most likely manually added.
     * 
     * Cannot be moved to custom plugin, since it depends on a function that is internally called.
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
        if (dia.getChildren().size() == 0) {
            return null; // TODO: This check should never fail, else the diagram is empty
        }
        Node pseudoNode = (Node) dia.getChildren().get(0);
        if (ctx == null) {
            for (Object n : pseudoNode.getChildren()) {
                if (n instanceof Node) {
                    Node node = (Node) n;
                    if (!node
                            .getType()
                            .equals(Integer
                                    .toString(ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID))
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
            return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
        }
        return null;
    }

    /**
     * Returns the the child node of myNode, thats element attribute references modelElement. This
     * method was manually added.
     * 
     * Cannot be moved to custom plugin, since it depends on a function that is internally called.
     * 
     * @param myNode
     *            - parent node whose children will be checked
     * @param modelElement
     *            - role for which to search
     * @return node - the child node of myNode, thats element attribute references the role
     *         modelElement, if existent, null otherwise
     * 
     * @generated not
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
     * Cannot be moved to custom plugin, since it depends on a function that is internally called.
     * 
     * @param nodeList
     *            the node list
     * @return node - one compartementNode if there is a node of that type, null otherwise
     * @generated not
     */
    private Node getCompartmentNode(EList nodeList) {
        for (Object n : nodeList) {
            if (n instanceof Node) {
                Node node = (Node) n;
                if (node.getType()
                        .equals(Integer
                                .toString(ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID))) {
                    return node;
                }

            }
        }
        return null;
    }

    /**
     * @generated
     */
    private Diagram getDiagram() {
        return ((View) getHost().getModel()).getDiagram();
    }

    /**
     * @generated
     */
    private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
        return getEditPart(descriptor.getSource(), domain2NotationMap);
    }

    /**
     * @generated
     */
    private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
        return getEditPart(descriptor.getDestination(), domain2NotationMap);
    }

    /**
     * @generated
     */
    protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap,
            int hintVisualId) {
        View view = domain2NotationMap.getHinted(domainModelElement,
                PalladioComponentModelVisualIDRegistry.getType(hintVisualId));
        if (view != null) {
            return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
        }
        return null;
    }

    /**
     * @generated
     */
    @SuppressWarnings("serial")
    protected static class Domain2Notation extends HashMap<EObject, View> {
        /**
         * @generated
         */
        public boolean containsDomainElement(EObject domainElement) {
            return this.containsKey(domainElement);
        }

        /**
         * @generated
         */
        public View getHinted(EObject domainEObject, String hint) {
            return this.get(domainEObject);
        }

        /**
         * @generated
         */
        public void putView(EObject domainElement, View view) {
            if (!containsKey(view.getElement())) {
                this.put(domainElement, view);
            }
        }

    }
}
