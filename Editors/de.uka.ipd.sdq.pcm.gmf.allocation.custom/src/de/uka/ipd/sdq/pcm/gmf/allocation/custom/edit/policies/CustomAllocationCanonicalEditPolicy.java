package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.policies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * FIXME: unused.
 * a custom Allocation CanoncialEditPolicy.
 * 
 */
public class CustomAllocationCanonicalEditPolicy extends AllocationCanonicalEditPolicy {

    @Override
    protected List<ResourceContainer> getSemanticChildrenList() {
        EObject modelObject = ((View) getHost().getModel()).getElement();
        ResourceEnvironment re = ((Allocation) modelObject).getTargetResourceEnvironment_Allocation();
        return re.getResourceContainer_ResourceEnvironment();
    }

    @Override
    protected boolean shouldDeleteView(View view) {
        if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
            return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
        }
        int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        return false;
    }
}
