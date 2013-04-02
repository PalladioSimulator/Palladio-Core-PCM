/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.AbstractUserActionSuccessorItemSemanticEditPolicy;

/**
 * @generated
 */
public class AbstractUserActionSuccessorEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4002;

    /**
     * @generated
     */
    public AbstractUserActionSuccessorEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AbstractUserActionSuccessorItemSemanticEditPolicy());
    }

    /**
     * @generated
     */
    protected Connection createConnectionFigure() {
        return new ControlFlowConnectionFigure();
    }

    /**
     * @generated
     */
    public ControlFlowConnectionFigure getPrimaryShape() {
        return (ControlFlowConnectionFigure) getFigure();
    }

    /**
     * @generated
     */
    public class ControlFlowConnectionFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        public ControlFlowConnectionFigure() {

            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            PointList pl = new PointList();
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
            pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
            df.setTemplate(pl);
            df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
            return df;
        }

    }

}
