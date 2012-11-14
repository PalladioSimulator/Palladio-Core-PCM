/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;

/**
 * The Class BranchTransitionBranchTransitionCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class BranchTransitionBranchTransitionCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * Gets the semantic children list.
     *
     * @return the semantic children list
     * @generated
     */
    protected List getSemanticChildrenList() {
        List result = new LinkedList();
        EObject modelObject = ((View) getHost().getModel()).getElement();
        View viewObject = (View) getHost().getModel();
        EObject nextValue;
        int nodeVID;
        nextValue = ((BranchTransition) modelObject).getBranchedBehaviour_BranchTransition();
        nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
        if (ScenarioBehaviour3EditPart.VISUAL_ID == nodeVID) {
            result.add(nextValue);
        }
        return result;
    }

    /**
     * Should delete view.
     *
     * @param view the view
     * @return true, if successful
     * @generated
     */
    protected boolean shouldDeleteView(View view) {
        if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
            return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
        }
        int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (nodeVID) {
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return true;
        }
        return false;
    }

    /**
     * Gets the default factory hint.
     *
     * @return the default factory hint
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

}
