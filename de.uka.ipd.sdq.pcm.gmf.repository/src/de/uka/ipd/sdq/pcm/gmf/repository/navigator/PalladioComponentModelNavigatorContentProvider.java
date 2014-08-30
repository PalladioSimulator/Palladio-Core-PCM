/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
import de.uka.ipd.sdq.pcm.gmf.repository.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

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

        case InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InterfaceParentInterfaces__Interface_4113_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InterfaceParentInterfaces__Interface_4113_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case OperationRequiredRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_4106_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationRequiredRole_4106_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case CompleteComponentTypeEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CompleteComponentType_2104_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CompleteComponentType_2104_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            return result.toArray();
        }

        case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ImplementationComponentTypeParentCompleteComponentTypes_4103_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ImplementationComponentTypeParentCompleteComponentTypes_4103_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case VariableUsageEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case InfrastructureInterfaceEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureInterface_2109_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureInterface_2109_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureSignatureEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case RepositoryEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            result.addAll(getForeignShortcuts((Diagram) view, parentElement));
            Diagram sv = (Diagram) view;
            PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Repository_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            if (!links.isEmpty()) {
                result.add(links);
            }
            return result.toArray();
        }

        case SinkRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SinkRole_4109_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SinkRole_4109_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case SubSystemEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SubSystem_2106_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case InfrastructureRequiredRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureRequiredRole_4112_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureRequiredRole_4112_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
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
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_4105_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationProvidedRole_4105_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case CompositeComponentEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CompositeComponent_2103_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case BasicComponentEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_BasicComponent_2102_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentSEFFCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingSEFFEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(PassiveResourceEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsageEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case InfrastructureProvidedRoleEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureProvidedRole_4111_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InfrastructureProvidedRole_4111_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureInterfaceEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CompleteComponentTypeParentProvidesComponentTypes_4104_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CompleteComponentTypeParentProvidesComponentTypes_4104_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case OperationInterfaceEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationInterface_2107_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_OperationInterface_2107_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationInterfaceSignatureListEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(OperationSignatureEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ProvidesComponentTypeEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ProvidesComponentType_2105_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ProvidesComponentType_2105_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureProvidedRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(OperationRequiredRoleEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
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
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SourceRole_4110_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SourceRole_4110_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BasicComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompositeComponentEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CompleteComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ProvidesComponentTypeEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SubSystemEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case EventGroupEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventGroup_2108_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EventGroup_2108_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EventGroupEventTypeListEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EventTypeEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SinkRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SourceRoleEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InterfaceParentInterfaces__InterfaceEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
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
        return RepositoryEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
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
    private Collection<PalladioComponentModelNavigatorItem> getForeignShortcuts(Diagram diagram, Object parent) {
        LinkedList<View> result = new LinkedList<View>();
        for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
            View nextView = it.next();
            if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
                result.add(nextView);
            }
        }
        return createNavigatorItems(result, parent, false);
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
