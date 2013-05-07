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
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomOperationRequiredRole2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;

/**
 * The Class CustomOperationRequiredRole2EditPart.
 */
public class CustomOperationRequiredRole2EditPart extends OperationRequiredRole2EditPart {

    /**
     * Instantiates a new custom operation required role2 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomOperationRequiredRole2EditPart(View view) {
        super(view);
    }

    /** size of the figure in LP. @generated not */
    private static final int FIGURE_LOGICAL_SIZE = 60;

    /**
     * Creates the node plate.
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createNodePlate() {
        // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
        // .DPtoLP(20), getMapMode().DPtoLP(20));

        SocketFigure result = new SocketFigure(getMapMode().DPtoLP(FIGURE_LOGICAL_SIZE), POSITION_TYPE.POS_EXTERNAL);

        // FIXME: workaround for #154536
        result.getBounds().setSize(result.getPreferredSize());
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
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
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomOperationRequiredRole2ItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

}
