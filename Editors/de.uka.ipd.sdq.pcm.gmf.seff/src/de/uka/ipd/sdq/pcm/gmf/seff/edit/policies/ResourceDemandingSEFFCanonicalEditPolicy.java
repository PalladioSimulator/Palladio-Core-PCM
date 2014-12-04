/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelLinkDescriptor;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class ResourceDemandingSEFFCanonicalEditPolicy extends CanonicalEditPolicy {

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
     * @generated
     */
    protected EStructuralFeature getFeatureToSynchronize() {
        return SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour();
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        LinkedList<EObject> result = new LinkedList<EObject>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getResourceDemandingSEFF_1000SemanticChildren(viewObject);
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
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case StartActionEditPart.VISUAL_ID:
        case StopActionEditPart.VISUAL_ID:
        case ExternalCallActionEditPart.VISUAL_ID:
        case EmitEventActionEditPart.VISUAL_ID:
        case LoopActionEditPart.VISUAL_ID:
        case BranchActionEditPart.VISUAL_ID:
        case InternalActionEditPart.VISUAL_ID:
        case CollectionIteratorActionEditPart.VISUAL_ID:
        case SetVariableActionEditPart.VISUAL_ID:
        case AcquireActionEditPart.VISUAL_ID:
        case ReleaseActionEditPart.VISUAL_ID:
        case ForkActionEditPart.VISUAL_ID:
        case RecoveryActionEditPart.VISUAL_ID:
            return true;
        }
        return false;
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
                .getResourceDemandingSEFF_1000SemanticChildren((View) getHost().getModel());
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
        if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view))) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getResourceDemandingSEFF_1000ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case StartActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getStartAction_2001ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case StopActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getStopAction_2002ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ExternalCallActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getExternalCallAction_2003ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case EmitEventActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getEmitEventAction_2013ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case LoopActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getLoopAction_2004ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case BranchActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getBranchAction_2005ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case InternalActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getInternalAction_2006ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case CollectionIteratorActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getCollectionIteratorAction_2007ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case SetVariableActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getSetVariableAction_2008ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AcquireActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getAcquireAction_2012ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ReleaseActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getReleaseAction_2010ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ForkActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getForkAction_2011ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case RecoveryActionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getRecoveryAction_2017ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case VariableUsageEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getVariableUsage_3042ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case VariableUsage2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getVariableUsage_3049ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case VariableUsage4EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getVariableUsage_3047ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceDemandingBehaviourEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getResourceDemandingBehaviour_3003ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case StartAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getStartAction_3004ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case StopAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getStopAction_3005ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case LoopAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getLoopAction_3006ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case InternalAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getInternalAction_3007ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case InfrastructureCallEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getInfrastructureCall_3053ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case VariableUsage5EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getVariableUsage_3054ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case BranchAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getBranchAction_3009ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getProbabilisticBranchTransition_3010ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getResourceDemandingBehaviour_3011ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ExternalCallAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getExternalCallAction_3012ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case EmitEventAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getEmitEventAction_3046ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case AcquireAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getAcquireAction_3026ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ReleaseAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getReleaseAction_3020ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ForkAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getForkAction_3023ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ForkedBehaviourEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getForkedBehaviour_3027ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case CollectionIteratorAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getCollectionIteratorAction_3013ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getResourceDemandingBehaviour_3014ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case RecoveryAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getRecoveryAction_3061ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case RecoveryActionBehaviourEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getRecoveryActionBehaviour_3062ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case SetVariableAction2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getSetVariableAction_3024ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case VariableUsage3EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getVariableUsage_3036ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case SynchronisationPointEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getSynchronisationPoint_3038ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ForkedBehaviour2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getForkedBehaviour_3039ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case GuardedBranchTransitionEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getGuardedBranchTransition_3017ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getResourceDemandingBehaviour_3018ContainedLinks(view));
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

    /**
     * @generated
     */
    private Collection<IAdaptable> createConnections(Collection<PalladioComponentModelLinkDescriptor> linkDescriptors,
            Domain2Notation domain2NotationMap) {
        LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
        for (PalladioComponentModelLinkDescriptor nextLinkDescriptor : linkDescriptors) {
            EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
            EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
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
