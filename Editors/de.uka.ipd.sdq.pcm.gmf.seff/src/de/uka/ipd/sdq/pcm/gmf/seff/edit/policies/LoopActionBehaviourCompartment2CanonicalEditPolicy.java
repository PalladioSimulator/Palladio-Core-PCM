/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.palladiosimulator.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class LoopActionBehaviourCompartment2CanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    protected List getSemanticChildrenList() {
        List result = new LinkedList();
        EObject modelObject = ((View) getHost().getModel()).getElement();
        View viewObject = (View) getHost().getModel();
        EObject nextValue;
        int nodeVID;
        nextValue = ((AbstractLoopAction) modelObject).getBodyBehaviour_Loop();
        nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
        if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVID) {
            result.add(nextValue);
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean shouldDeleteView(View view) {
        if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
            return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
        }
        int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (nodeVID) {
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

}
