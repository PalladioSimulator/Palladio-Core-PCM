/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.AbstractBorderFigure.POSITION_TYPE;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.BallFigure;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomOperationProvidedRole2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;

/**
 * The Class CustomOperationProvidedRole2EditPart.
 */
public class CustomOperationProvidedRole2EditPart extends OperationProvidedRole2EditPart {

    /**
     * Instantiates a new custom operation provided role2 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomOperationProvidedRole2EditPart(View view) {
        super(view);
    }

    /** size of the figure in LP. @generated not */
    private static final int FIGURE_LOGICAL_SIZE = 60;

    /**
     * Create the Node Plate. This triggers the drawing of the ball figure
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createNodePlate() {
        // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
        // .DPtoLP(20), getMapMode().DPtoLP(20));

        BallFigure result = new BallFigure(getMapMode().DPtoLP(FIGURE_LOGICAL_SIZE), POSITION_TYPE.POS_EXTERNAL);

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
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomOperationProvidedRole2ItemSemanticEditPolicy());
    }
}
