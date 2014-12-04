/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomAssemblyContextCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomAssemblyContextItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class CustomAssemblyContextEditPart.
 */
public class CustomAssemblyContextEditPart extends AssemblyContextEditPart {

    /**
     * Instantiates a new custom assembly context edit part.
     * 
     * @param view
     *            the view
     */
    public CustomAssemblyContextEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new CustomAssemblyContextItemSemanticEditPolicy/* AssemblyContextItemSemanticEditPolicy */());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new CustomAssemblyContextCanonicalEditPolicy/* AssemblyContextCanonicalEditPolicy */());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

        // Remove popup bar for adding roles (this is not allowed)
        removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
    }
}
