/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;

/**
 * The Class BranchBranchCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class BranchBranchCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

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
        for (Iterator values = ((Branch) modelObject).getBranchTransitions_Branch().iterator(); values.hasNext();) {
            nextValue = (EObject) values.next();
            nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
            if (BranchTransitionEditPart.VISUAL_ID == nodeVID) {
                result.add(nextValue);
            }
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
        return view.isSetElement() && view.getElement() != null && view.getElement().eIsProxy();
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
