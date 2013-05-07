/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.AbstractBorderFigure.POSITION_TYPE;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.BallFigure;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomOperationProvidedRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;

/**
 * The Class CustomOperationProvidedRoleEditPart.
 */
public class CustomOperationProvidedRoleEditPart extends OperationProvidedRoleEditPart {
    /** size of the figure in LP. @generated not */
    private static final int FIGURE_LOGICAL_SIZE = 30;

    /**
     * Instantiates a new custom operation provided role edit part.
     * 
     * @param view
     *            the view
     */
    public CustomOperationProvidedRoleEditPart(View view) {
        super(view);
    }

    /**
     * Create the Node Plate. This triggers the drawing of the ball figure
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createNodePlate() {
        // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
        // .DPtoLP(20), getMapMode().DPtoLP(20));

        BallFigure result = new BallFigure(getMapMode().DPtoLP(FIGURE_LOGICAL_SIZE), POSITION_TYPE.POS_INTERNAL);

        // FIXME: workaround for #154536
        result.getBounds().setSize(result.getPreferredSize());
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Call the createNodePlate() method
     * 
     * Original generated Comment: Body of this method does not depend on settings in generation
     * model so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        // figure.setLayoutManager(new StackLayout());
        // IFigure shape = createNodeShape();
        // figure.add(shape);
        // contentPane = setupContentPane(shape);

        return figure;
    }

    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomOperationProvidedRoleItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }
}
