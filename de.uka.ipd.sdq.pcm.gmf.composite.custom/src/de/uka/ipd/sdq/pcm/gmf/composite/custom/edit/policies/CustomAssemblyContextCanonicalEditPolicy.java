/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyContextCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy.CanonicalElementAdapter;

/**
 * The Class CustomAssemblyContextCanonicalEditPolicy.
 */
public class CustomAssemblyContextCanonicalEditPolicy extends AssemblyContextCanonicalEditPolicy {

    // Reverted to generated code, since original code works, as it calls modified
    // PalladioComponentModelDiagramUpdater.
    // /**
    // * Get the semantic children of an assembly context.
    // *
    // * This has been adopted manually for the composite editor diagram. The direct semantic child
    // of
    // * an assembly context is the encapsulated component. In case of the composite diagram we
    // * present the provided and required roles of the component to the user instead. For this, the
    // * getSemanticChildrenList method collects all roles from the encapsulated component.
    // *
    // * @return The list of prov. and req. roles of the encapsulated component
    // *
    // * @generated not
    // */
    // protected List getSemanticChildrenList() {
    // List result = new LinkedList();
    // EObject modelObject = ((View) getHost().getModel()).getElement();
    // AssemblyContext ctx = (AssemblyContext) modelObject;
    // modelObject = ctx.getEncapsulatedComponent__AssemblyContext();
    // View viewObject = (View) getHost().getModel();
    // EObject nextValue;
    // int nodeVID;
    // if (modelObject != null) {
    // for (Iterator values = ((InterfaceProvidingEntity)
    // modelObject).getProvidedRoles_InterfaceProvidingEntity()
    // .iterator(); values.hasNext();) {
    // nextValue = (EObject) values.next();
    // nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
    // // if (OperationProvidedRoleEditPart.VISUAL_ID == nodeVID) {
    // result.add(nextValue);
    // // }
    // }
    // for (Iterator values = ((InterfaceRequiringEntity)
    // modelObject).getRequiredRoles_InterfaceRequiringEntity()
    // .iterator(); values.hasNext();) {
    // nextValue = (EObject) values.next();
    // nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
    // // if (OperationRequiredRoleEditPart.VISUAL_ID == nodeVID) {
    // result.add(nextValue);
    // // }
    // }
    // }
    // return result;
    // }

    /**
     * This method updates the diagram from the model's subtree starting at assembly contexts.
     * 
     * Fixed a bug where layouting is started, but the assembly context figure is not yet set to its
     * size. This causes the role figures to be positioned incorrectly by the BorderItemLocator.
     * 
     * @generated not
     * @author Andreas Rentschler
     */
    protected void refreshSemantic() {
        if (resolveSemanticElement() == null) {
            return;
        }
        LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getAssemblyContext_3006SemanticChildren((View) getHost().getModel());
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
        // Removed the following layout command:
        // if (createdViews.size() > 1) {
        // // perform a layout of the container
        // DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(),
        // createdViews, host());
        // executeCommand(new ICommandProxy(layoutCmd));
        // }

        makeViewsImmutable(createdViews);
    }

    /**
     * Just copied this private method because it is not accessible for overridden
     * refreshSemantic().
     * 
     * @param view
     * @return boolean
     * 
     * @generated
     */
    private boolean isMyDiagramElement(View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case OperationProvidedRoleEditPart.VISUAL_ID:
        case OperationRequiredRoleEditPart.VISUAL_ID:
        case SourceRoleEditPart.VISUAL_ID:
        case SinkRoleEditPart.VISUAL_ID:
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            return true;
        }
        return false;
    }

}
