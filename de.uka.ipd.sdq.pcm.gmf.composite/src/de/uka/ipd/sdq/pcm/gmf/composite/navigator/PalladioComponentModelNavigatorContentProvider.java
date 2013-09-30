/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

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
import de.uka.ipd.sdq.pcm.gmf.composite.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorContentProvider implements ICommonContentProvider {

    /**
     * @generated
     */
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /**
     * @generated
     */
    private Viewer myViewer;

    /**
     * @generated
     */
    private AdapterFactoryEditingDomain myEditingDomain;

    /**
     * @generated
     */
    private WorkspaceSynchronizer myWorkspaceSynchronizer;

    /**
     * @generated
     */
    private Runnable myViewerRefreshRunnable;

    /**
     * @generated
     */
    @SuppressWarnings({ "unchecked", "serial", "rawtypes" })
    public PalladioComponentModelNavigatorContentProvider() {
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
        myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
        myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
            public Object get(Object key) {
                if (!containsKey(key)) {
                    put(key, Boolean.TRUE);
                }
                return super.get(key);
            }
        });
        myViewerRefreshRunnable = new Runnable() {
            public void run() {
                if (myViewer != null) {
                    myViewer.refresh();
                }
            }
        };
        myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
            public void dispose() {
            }

            public boolean handleResourceChanged(final Resource resource) {
                unloadAllResources();
                asyncRefresh();
                return true;
            }

            public boolean handleResourceDeleted(Resource resource) {
                unloadAllResources();
                asyncRefresh();
                return true;
            }

            public boolean handleResourceMoved(Resource resource, final URI newURI) {
                unloadAllResources();
                asyncRefresh();
                return true;
            }
        });
    }

    /**
     * @generated
     */
    public void dispose() {
        myWorkspaceSynchronizer.dispose();
        myWorkspaceSynchronizer = null;
        myViewerRefreshRunnable = null;
        myViewer = null;
        unloadAllResources();
        ((TransactionalEditingDomain) myEditingDomain).dispose();
        myEditingDomain = null;
    }

    /**
     * @generated
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        myViewer = viewer;
    }

    /**
     * @generated
     */
    void unloadAllResources() {
        for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
            nextResource.unload();
        }
    }

    /**
     * @generated
     */
    void asyncRefresh() {
        if (myViewer != null && !myViewer.getControl().isDisposed()) {
            myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
        }
    }

    /**
     * @generated
     */
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    /**
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * @generated
     */
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof IFile) {
            IFile file = (IFile) parentElement;
            URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
            Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
            ArrayList<PalladioComponentModelNavigatorItem> result = new ArrayList<PalladioComponentModelNavigatorItem>();
            ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
            for (EObject o : resource.getContents()) {
                if (o instanceof View) {
                    topViews.add((View) o);
                }
            }
            result.addAll(createNavigatorItems(
                    selectViewsByType(topViews, ComposedProvidingRequiringEntityEditPart.MODEL_ID), file, false));
            return result.toArray();
        }

        if (parentElement instanceof PalladioComponentModelNavigatorGroup) {
            PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) parentElement;
            return group.getChildren();
        }

        if (parentElement instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) parentElement;
            if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
                return EMPTY_ARRAY;
            }
            return getViewChildren(navigatorItem.getView(), parentElement);
        }

        return EMPTY_ARRAY;
    }

    /**
     * @generated
     */
    private Object[] getViewChildren(View view, Object parentElement) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

        case AssemblyInfrastructureConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyInfrastructureConnector_4008_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyInfrastructureConnector_4008_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case EventChannelSinkConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventChannelSinkConnector_4010_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventChannelSinkConnector_4010_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case AssemblyEventConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyEventConnector_4007_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyEventConnector_4007_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case ProvidedDelegationConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ProvidedDelegationConnector_4006_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ProvidedDelegationConnector_4006_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRole2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRole2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case EventChannelEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventChannel_3017_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSinkConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSourceConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }

        case OperationRequiredRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_3008_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_3008_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }

        case SourceRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SourceRole_3013_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSourceConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyEventConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case RequiredDelegationConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RequiredDelegationConnector_4005_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RequiredDelegationConnector_4005_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRole2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRole2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case ComposedProvidingRequiringEntityEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Diagram sv = (Diagram) view;
            PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ComposedProvidingRequiringEntity_1000_links,
                    "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ComposedProvidingRequiringEntity2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSinkConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSourceConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyEventConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            if (!links.isEmpty()) {
                result.add(links);
            }
            return result.toArray();
        }

        case SinkRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SinkRole_3014_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SinkRole_3014_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelSinkConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyEventConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }

        case InfrastructureRequiredRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureRequiredRole_3016_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case AssemblyContextEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case EventChannelSourceConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventChannelSourceConnector_4009_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventChannelSourceConnector_4009_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case OperationProvidedRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_3007_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_3007_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case OperationProvidedRole2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_3011_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_3011_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidedDelegationConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyContextEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRole2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRole2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EventChannelEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case AssemblyConnectorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyConnector_4004_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AssemblyConnector_4004_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRole2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRole2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case OperationRequiredRole2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_3012_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_3012_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RequiredDelegationConnectorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }

        case InfrastructureProvidedRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureProvidedRole_3015_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AssemblyInfrastructureConnectorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }
        }
        return EMPTY_ARRAY;
    }

    /**
     * @generated
     */
    private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (Edge nextEdge : edges) {
            View nextEdgeSource = nextEdge.getSource();
            if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
                result.add(nextEdgeSource);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (Edge nextEdge : edges) {
            View nextEdgeTarget = nextEdge.getTarget();
            if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
                result.add(nextEdgeTarget);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getChildren(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
        ArrayList<View> result = new ArrayList<View>();
        for (Diagram nextDiagram : diagrams) {
            result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
        }
        return result;
    }

    // TODO refactor as static method
    /**
     * @generated
     */
    private Collection<View> selectViewsByType(Collection<View> views, String type) {
        ArrayList<View> result = new ArrayList<View>();
        for (View nextView : views) {
            if (type.equals(nextView.getType()) && isOwnView(nextView)) {
                result.add(nextView);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private boolean isOwnView(View view) {
        return ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(view));
    }

    /**
     * @generated
     */
    private Collection<PalladioComponentModelNavigatorItem> createNavigatorItems(Collection<View> views, Object parent,
            boolean isLeafs) {
        ArrayList<PalladioComponentModelNavigatorItem> result = new ArrayList<PalladioComponentModelNavigatorItem>(
                views.size());
        for (View nextView : views) {
            result.add(new PalladioComponentModelNavigatorItem(nextView, parent, isLeafs));
        }
        return result;
    }

    /**
     * @generated
     */
    public Object getParent(Object element) {
        if (element instanceof PalladioComponentModelAbstractNavigatorItem) {
            PalladioComponentModelAbstractNavigatorItem abstractNavigatorItem = (PalladioComponentModelAbstractNavigatorItem) element;
            return abstractNavigatorItem.getParent();
        }
        return null;
    }

    /**
     * @generated
     */
    public boolean hasChildren(Object element) {
        return element instanceof IFile || getChildren(element).length > 0;
    }

}
