/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;

/**
 * The Class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.
 */
public class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart extends
        ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart {

    /**
     * Instantiates a new custom composed providing requiring entity composite structure inner
     * compartment edit part.
     * 
     * @param view
     *            the view
     */
    public CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy());
    }
}
