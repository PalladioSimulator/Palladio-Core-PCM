/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyEventConnectorItemSemanticEditPolicy;

/**
 * @generated
 */
public class AssemblyEventConnectorEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4007;

    /**
     * @generated
     */
    public AssemblyEventConnectorEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssemblyEventConnectorItemSemanticEditPolicy());
    }

    /**
     * @generated
     */

    protected Connection createConnectionFigure() {
        return new AssemblyEventConnectorFigure();
    }

    /**
     * @generated
     */
    public AssemblyEventConnectorFigure getPrimaryShape() {
        return (AssemblyEventConnectorFigure) getFigure();
    }

    /**
     * @generated
     */
    public class AssemblyEventConnectorFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        public AssemblyEventConnectorFigure() {
            this.setLineWidth(1);

            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            df.setLineWidth(1);
            PointList pl = new PointList();
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
            pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
            df.setTemplate(pl);
            df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
            return df;
        }

    }

}
