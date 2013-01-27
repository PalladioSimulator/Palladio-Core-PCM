/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourItemSemanticEditPolicy;

/**
 * @generated
 */
public class RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart extends
        ConnectionNodeEditPart implements ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4004;

    /**
     * @generated
     */
    public RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourItemSemanticEditPolicy());
    }

    /**
     * @generated
     */

    protected Connection createConnectionFigure() {
        return new RecoveryFlowConnectionFigure();
    }

    /**
     * @generated
     */
    public RecoveryFlowConnectionFigure getPrimaryShape() {
        return (RecoveryFlowConnectionFigure) getFigure();
    }

    /**
     * @generated
     */
    public class RecoveryFlowConnectionFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        public RecoveryFlowConnectionFigure() {
            this.setLineWidth(2);
            this.setLineStyle(Graphics.LINE_DOT);

            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            df.setLineWidth(2);
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
