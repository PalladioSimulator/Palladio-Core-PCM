/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.UsageScenarioCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.UsageScenarioItemSemanticEditPolicy;

/**
 * The Class UsageScenarioEditPart.
 *
 * @generated
 */
public class UsageScenarioEditPart extends DiagramEditPart {

    /** The Constant MODEL_ID. @generated */
    public final static String MODEL_ID = "PCM Usage Model"; //$NON-NLS-1$

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 1000;

    /**
     * Instantiates a new usage scenario edit part.
     *
     * @param view the view
     * @generated
     */
    public UsageScenarioEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new UsageScenarioItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new UsageScenarioCanonicalEditPolicy());
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    }
}
