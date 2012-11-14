/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;

/**
 * The Class LoopLoopCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class LoopLoopCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

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
        nextValue = ((Loop) modelObject).getBodyBehaviour_Loop();
        nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
        if (ScenarioBehaviour2EditPart.VISUAL_ID == nodeVID) {
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
