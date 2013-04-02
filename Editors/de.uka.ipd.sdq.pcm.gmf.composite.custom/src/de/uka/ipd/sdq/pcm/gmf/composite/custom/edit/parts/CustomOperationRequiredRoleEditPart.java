/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.AbstractBorderFigure.POSITION_TYPE;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.SocketFigure;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomOperationRequiredRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;

public class CustomOperationRequiredRoleEditPart extends OperationRequiredRoleEditPart {

    public CustomOperationRequiredRoleEditPart(View view) {
		super(view);
	}

	/** size of the figure in LP. @generated not */
    private static final int FIGURE_LOGICAL_SIZE = 30;

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     * 
     * Manually modified to generate a specific socket figure instead of the standard shape
     * configured in the map model.
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createMainFigure() {
        SocketFigure figure = new SocketFigure(getMapMode().DPtoLP(FIGURE_LOGICAL_SIZE), POSITION_TYPE.POS_INTERNAL);
        figure.getBounds().setSize(figure.getPreferredSize());

        return figure;
    }

    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomOperationRequiredRoleItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }
}
