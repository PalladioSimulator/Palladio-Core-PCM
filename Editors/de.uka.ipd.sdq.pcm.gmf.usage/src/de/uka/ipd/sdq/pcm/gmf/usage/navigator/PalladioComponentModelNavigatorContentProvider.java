/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

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
            result.addAll(createNavigatorItems(selectViewsByType(topViews, UsageScenarioEditPart.MODEL_ID), file, false));
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

        case DelayEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Delay_3017_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Delay_3017_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
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

        case StopEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Stop_3002_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Stop_3002_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case BranchTransitionEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviour3EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case StartEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Start_3001_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Start_3001_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ScenarioBehaviour2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case LoopEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Loop_3005_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Loop_3005_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviour2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case EntryLevelSystemCallEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EntryLevelSystemCall_3003_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_EntryLevelSystemCall_3003_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(VariableUsageEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ScenarioBehaviour3EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case AbstractUserActionSuccessorEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Edge sv = (Edge) view;
            PalladioComponentModelNavigatorGroup target = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AbstractUserActionSuccessor_4002_target,
                    "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup source = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_AbstractUserActionSuccessor_4002_source,
                    "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksTargetByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
            target.addChildren(createNavigatorItems(connectedViews, target, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            connectedViews = getLinksSourceByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
            source.addChildren(createNavigatorItems(connectedViews, source, true));
            if (!target.isEmpty()) {
                result.add(target);
            }
            if (!source.isEmpty()) {
                result.add(source);
            }
            return result.toArray();
        }

        case UsageScenarioEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Diagram sv = (Diagram) view;
            PalladioComponentModelNavigatorGroup links = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_UsageModel_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(UsageScenario2EditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            links.addChildren(createNavigatorItems(connectedViews, links, false));
            if (!links.isEmpty()) {
                result.add(links);
            }
            return result.toArray();
        }

        case BranchEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            PalladioComponentModelNavigatorGroup incominglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Branch_3008_incominglinks,
                    "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            PalladioComponentModelNavigatorGroup outgoinglinks = new PalladioComponentModelNavigatorGroup(
                    Messages.NavigatorGroupName_Branch_3008_outgoinglinks,
                    "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchTransitionEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
            connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry.getType(AbstractUserActionSuccessorEditPart.VISUAL_ID));
            outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
            if (!incominglinks.isEmpty()) {
                result.add(incominglinks);
            }
            if (!outgoinglinks.isEmpty()) {
                result.add(outgoinglinks);
            }
            return result.toArray();
        }

        case ScenarioBehaviourEditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StartEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(StopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(EntryLevelSystemCallEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(LoopEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(BranchEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(DelayEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            return result.toArray();
        }

        case UsageScenario2EditPart.VISUAL_ID: {
            LinkedList<PalladioComponentModelAbstractNavigatorItem> result = new LinkedList<PalladioComponentModelAbstractNavigatorItem>();
            Node sv = (Node) view;
            Collection<View> connectedViews;
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ScenarioBehaviourEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(ClosedWorkloadEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
            connectedViews = getChildrenByType(Collections.singleton(sv),
                    PalladioComponentModelVisualIDRegistry
                            .getType(UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID));
            connectedViews = getChildrenByType(connectedViews,
                    PalladioComponentModelVisualIDRegistry.getType(OpenWorkloadEditPart.VISUAL_ID));
            result.addAll(createNavigatorItems(connectedViews, parentElement, false));
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
        return UsageScenarioEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
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
