package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.policies;

import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom allocation diagram canonical EditPolicy.
 */
public class CustomAllocationCanonicalEditPolicy extends AllocationCanonicalEditPolicy {

    /**
     * Get the contained resource container for the resource environment.
     * 
     * In the allocation diagram, the root element is not represented by the canvas, but by the
     * target resource environment. To enable this, this edit policy needs to return the referenced
     * resource environment and not the real children as done in the generated version of this
     * method.
     * 
     * Since GMF3, this modification has to be applied to PalladioComponentModelDiagramUpdater, as
     * well. Even the generated code calls PalladioComponentModelDiagramUpdater, so this
     * modification is no longer required.
     * 
     * @param view
     *            the view
     * @return true, if successful
     */
    // @Override
    // protected List<ResourceContainer> getSemanticChildrenList() {
    // // View viewObject = (View) getHost().getModel();
    // // LinkedList<EObject> result = new LinkedList<EObject>();
    // // List<PalladioComponentModelNodeDescriptor> childDescriptors =
    // PalladioComponentModelDiagramUpdater
    // // .getAllocation_1000SemanticChildren(viewObject);
    // // for (PalladioComponentModelNodeDescriptor d : childDescriptors) {
    // // result.add(d.getModelElement());
    // // }
    // // return result;
    //
    // List result = new LinkedList();
    // EObject modelObject = ((View) getHost().getModel()).getElement();
    // View viewObject = (View) getHost().getModel();
    // ResourceEnvironment re = ((Allocation) modelObject)
    // .getTargetResourceEnvironment_Allocation();
    //
    // return re.getResourceContainer_ResourceEnvironment();
    // }

    @Override
    protected boolean shouldDeleteView(View view) {
        if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
            return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
        }
        int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        return false;
    }
}
