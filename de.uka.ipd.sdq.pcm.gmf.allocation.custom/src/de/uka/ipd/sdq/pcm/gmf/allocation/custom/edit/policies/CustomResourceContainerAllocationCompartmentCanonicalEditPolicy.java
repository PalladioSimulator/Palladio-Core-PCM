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
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom resource container allocation compartment canoncial EditPolicy.
 */
public class CustomResourceContainerAllocationCompartmentCanonicalEditPolicy extends
        ResourceContainerAllocationCompartmentCanonicalEditPolicy {

    @Override
    protected List<AllocationContext> getSemanticChildrenList() {
        List result = new LinkedList();

        EObject modelObject = ((View) getHost().getModel()).getElement();
        EObject allocation = ((View) getHost().getParent().getParent().getModel()).getElement();
        View viewObject = (View) getHost().getModel();
        EObject nextValue;
        int nodeVID;
        for (Iterator values = ((Allocation) allocation).getAllocationContexts_Allocation().iterator(); values
                .hasNext();) {
            nextValue = (EObject) values.next();
            AllocationContext ac = (AllocationContext) nextValue;
            if (ac.getResourceContainer_AllocationContext() == modelObject) {
                nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
                if (AllocationContextEditPart.VISUAL_ID == nodeVID) {
                    result.add(nextValue);
                }
            }
        }
        return result;
    }
}
