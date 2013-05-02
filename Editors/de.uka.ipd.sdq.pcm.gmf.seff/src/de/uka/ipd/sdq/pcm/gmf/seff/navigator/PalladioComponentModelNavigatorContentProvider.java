/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.navigator;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionInputVariableUsageEvent2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionInputVariableUsageEventEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourSynchronisationPointForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallInfrastructureCallInputVariableUsagesEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrenceDescriptions2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrenceDescriptionsEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionInfrastructureCallsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionInfrastructureCallsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetter2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetterEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointSynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

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
            result.addAll(createNavigatorItems(selectViewsByType(topViews, ResourceDemandingSEFFEditPart.MODEL_ID),
                    file, false));
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

        case ReleaseAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ReleaseAction_3020_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ReleaseAction_3020_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case SynchronisationPointEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(SynchronisationPointSynchronisationPointEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviour2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case EmitEventAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EmitEventAction_3046_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EmitEventAction_3046_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage4EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case CollectionIteratorActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CollectionIteratorAction_2007_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CollectionIteratorAction_2007_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case InfrastructureCallEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage5EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case AcquireAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AcquireAction_3026_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AcquireAction_3026_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case BranchAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_BranchAction_3009_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_BranchAction_3009_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ProbabilisticBranchTransitionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ExternalCallActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ExternalCallAction_2003_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ExternalCallAction_2003_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ExternalCallActionInputVariableUsageEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsageEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case LoopActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_LoopAction_2004_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_LoopAction_2004_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ForkAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ForkAction_3023_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ForkAction_3023_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SynchronisationPointEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case SetVariableActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SetVariableAction_2008_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SetVariableAction_2008_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableActionVariableSetter2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case GuardedBranchTransitionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour4EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case VariableUsage2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageVariableCharacterisation2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case StartAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StartAction_3004_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StartAction_3004_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case VariableUsage3EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageVariableCharacterisation3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation5EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case VariableUsageEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageVariableCharacterisationEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case ForkedBehaviourEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case ForkActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ForkAction_2011_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ForkAction_2011_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehaviours2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkedBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionForkedBehaviours2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SynchronisationPointEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case RecoveryActionBehaviourEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryActionBehaviour_3062_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryActionBehaviour_3062_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case StopActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StopAction_2002_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StopAction_2002_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ResourceDemandingBehaviour2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case VariableUsage4EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageVariableCharacterisation4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AbstractActionSuccessor_AbstractAction_4001_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AcquireActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AcquireActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case InternalAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InternalAction_3007_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InternalAction_3007_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalActionResourceDemandEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ParametricResourceDemandEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureCallEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case VariableUsage5EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(VariableUsageVariableCharacterisation5EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation4EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case StopAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StopAction_3005_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StopAction_3005_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case RecoveryAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryAction_3061_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryAction_3061_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ProbabilisticBranchTransitionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case LoopAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_LoopAction_3006_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_LoopAction_3006_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ResourceDemandingBehaviour4EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case ResourceDemandingSEFFEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Diagram sv = (Diagram) view;
            PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ResourceDemandingSEFF_1000_links,
                    "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AcquireActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ForkActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            connectedViews = getDiagramLinksByType(
                    Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            if (!links.isEmpty()) {
                result.add(links);
            }
            return result.toArray();
        }

        case ForkedBehaviour2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case RecoveryActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryAction_2017_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_RecoveryAction_2017_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case InternalActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InternalAction_2006_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_InternalAction_2006_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(InternalActionResourceDemand2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ParametricResourceDemandEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InfrastructureCallEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case EmitEventActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EmitEventAction_2013_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EmitEventAction_2013_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage4EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case AcquireActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AcquireAction_2012_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AcquireAction_2012_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case CollectionIteratorAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CollectionIteratorAction_3013_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_CollectionIteratorAction_3013_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ResourceDemandingBehaviour3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ResourceDemandingBehaviour3EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case ReleaseActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ReleaseAction_2010_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ReleaseAction_2010_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ResourceDemandingBehaviourEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(InternalAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ExternalCallAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EmitEventAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(AcquireAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ReleaseAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ForkAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(RecoveryAction2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case ExternalCallAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ExternalCallAction_3012_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_ExternalCallAction_3012_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsageEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case StartActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StartAction_2001_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_StartAction_2001_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case SetVariableAction2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SetVariableAction_3024_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_SetVariableAction_3024_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(SetVariableActionVariableSetterEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsage3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case BranchActionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_BranchAction_2005_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_BranchAction_2005_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ProbabilisticBranchTransitionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
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
        return ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
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
