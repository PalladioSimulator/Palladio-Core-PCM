package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom resource container allocation compartment canonical EditPolicy.
 */
public class CustomResourceContainerAllocationCompartmentCanonicalEditPolicy extends
        ResourceContainerAllocationCompartmentCanonicalEditPolicy {

	/**
	 * Since GMF3, this modification has to be applied to PalladioComponentModelDiagramUpdater, as well.
	 * Even the generated code calls PalladioComponentModelDiagramUpdater, so this modification is no longer required.
	 */
//	@Override
//    protected List<AllocationContext> getSemanticChildrenList() {
////		View viewObject = (View) getHost().getModel();
////		LinkedList<EObject> result = new LinkedList<EObject>();
////		List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
////				.getResourceContainerAllocationCompartment_7003SemanticChildren(viewObject);
////		for (PalladioComponentModelNodeDescriptor d : childDescriptors) {
////			result.add(d.getModelElement());
////		}
////		return result;
//        List result = new LinkedList();
//
//        EObject modelObject = ((View) getHost().getModel()).getElement();
//        EObject allocation = ((View) getHost().getParent().getParent().getModel()).getElement();
//        View viewObject = (View) getHost().getModel();
//        EObject nextValue;
//        int nodeVID;
//        for (Iterator values = ((Allocation) allocation).getAllocationContexts_Allocation().iterator(); values
//                .hasNext();) {
//            nextValue = (EObject) values.next();
//            AllocationContext ac = (AllocationContext) nextValue;
//            if (ac.getResourceContainer_AllocationContext() == modelObject) {
//                nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
//                if (AllocationContextEditPart.VISUAL_ID == nodeVID) {
//                    result.add(nextValue);
//                }
//            }
//        }
//        return result;
//    }
	
	/**
	 * TODO: Find out what this fix is needed for.
	 * 
	 * @generated not
	 */
	protected void refreshSemantic() {
		// FIXME: this override needs to be adjusted similar to the above method, wasn't overridden in older GMF
		super.refreshSemantic();
//		if (resolveSemanticElement() == null) {
//			return;
//		}
//		LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
//		List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
//				.getResourceContainerAllocationCompartment_7003SemanticChildren((View) getHost()
//						.getModel());
//		LinkedList<View> orphaned = new LinkedList<View>();
//		// we care to check only views we recognize as ours
//		LinkedList<View> knownViewChildren = new LinkedList<View>();
//		for (View v : getViewChildren()) {
//			if (isMyDiagramElement(v)) {
//				knownViewChildren.add(v);
//			}
//		}
//		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
//		//
//		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
//		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
//		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
//		for (Iterator<PalladioComponentModelNodeDescriptor> descriptorsIterator = childDescriptors
//				.iterator(); descriptorsIterator.hasNext();) {
//			PalladioComponentModelNodeDescriptor next = descriptorsIterator
//					.next();
//			String hint = PalladioComponentModelVisualIDRegistry.getType(next
//					.getVisualID());
//			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
//			for (View childView : getViewChildren()) {
//				EObject semanticElement = childView.getElement();
//				if (next.getModelElement().equals(semanticElement)) {
//					if (hint.equals(childView.getType())) {
//						perfectMatch.add(childView);
//						// actually, can stop iteration over view children here, but
//						// may want to use not the first view but last one as a 'real' match (the way original CEP does
//						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
//					}
//				}
//			}
//			if (perfectMatch.size() > 0) {
//				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
//				// use only one view (first or last?), keep rest as orphaned for further consideration
//				knownViewChildren.remove(perfectMatch.getFirst());
//			}
//		}
//		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
//		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
//		orphaned.addAll(knownViewChildren);
//		//
//		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
//				childDescriptors.size());
//		for (PalladioComponentModelNodeDescriptor next : childDescriptors) {
//			String hint = PalladioComponentModelVisualIDRegistry.getType(next
//					.getVisualID());
//			IAdaptable elementAdapter = new CanonicalElementAdapter(
//					next.getModelElement(), hint);
//			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(
//					elementAdapter, Node.class, hint, ViewUtil.APPEND, false,
//					host().getDiagramPreferencesHint());
//			viewDescriptors.add(descriptor);
//		}
//
//		boolean changed = deleteViews(orphaned.iterator());
//		//
//		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
//		Command cmd = getCreateViewCommand(request);
//		if (cmd != null && cmd.canExecute()) {
//			SetViewMutabilityCommand.makeMutable(
//					new EObjectAdapter(host().getNotationView())).execute();
//			executeCommand(cmd);
//			@SuppressWarnings("unchecked")
//			List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
//			createdViews.addAll(nl);
//		}
//		if (changed || createdViews.size() > 0) {
//			postProcessRefreshSemantic(createdViews);
//		}
//		if (createdViews.size() > 1) {
//			// perform a layout of the container
//			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
//					.getEditingDomain(), createdViews, host());
//			executeCommand(new ICommandProxy(layoutCmd));
//		}
//
//		makeViewsImmutable(createdViews);
	}
	
}
