/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ForkActionForkedBehavioursCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ForkActionForkedBehavioursItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;

/**
 * The Class ForkActionForkedBehavioursEditPart.
 *
 * @generated
 */
public class ForkActionForkedBehavioursEditPart extends ShapeCompartmentEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 7024;

    /**
     * Instantiates a new fork action forked behaviours edit part.
     *
     * @param view the view
     * @generated
     */
    public ForkActionForkedBehavioursEditPart(View view) {
        super(view);
    }

    /**
     * Gets the compartment name.
     *
     * @return the compartment name
     * @generated
     */
    public String getCompartmentName() {
        return Messages.ForkActionForkedBehavioursEditPart_title;
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ForkActionForkedBehavioursItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ForkActionForkedBehavioursCanonicalEditPolicy());
    }

    /**
     * Sets the ratio.
     *
     * @param ratio the new ratio
     * @generated
     */
    protected void setRatio(Double ratio) {
        if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
            super.setRatio(ratio);
        }
    }

}
