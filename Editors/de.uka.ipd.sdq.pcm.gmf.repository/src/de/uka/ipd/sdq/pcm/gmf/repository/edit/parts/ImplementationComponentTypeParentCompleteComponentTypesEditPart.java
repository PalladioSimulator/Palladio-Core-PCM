/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.ImplementationComponentTypeParentCompleteComponentTypesItemSemanticEditPolicy;

/**
 * @generated
 */
public class ImplementationComponentTypeParentCompleteComponentTypesEditPart extends ConnectionNodeEditPart implements
        ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4103;

    /**
     * @generated
     */
    public ImplementationComponentTypeParentCompleteComponentTypesEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new ImplementationComponentTypeParentCompleteComponentTypesItemSemanticEditPolicy());
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ImplementationComponentTypeParentCompleteTypesLabelEditPart) {
            ((ImplementationComponentTypeParentCompleteTypesLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureCompleteParentStereotypeLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, index);
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ImplementationComponentTypeParentCompleteTypesLabelEditPart) {
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * @generated
     */
    protected Connection createConnectionFigure() {
        return new ParentCompleteTypeFigure();
    }

    /**
     * @generated
     */
    public ParentCompleteTypeFigure getPrimaryShape() {
        return (ParentCompleteTypeFigure) getFigure();
    }

    /**
     * @generated
     */
    public class ParentCompleteTypeFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        private WrappingLabel fFigureCompleteParentStereotypeLabelFigure;

        /**
         * @generated
         */
        public ParentCompleteTypeFigure() {

            createContents();
            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureCompleteParentStereotypeLabelFigure = new WrappingLabel();

            fFigureCompleteParentStereotypeLabelFigure.setText("<<Conforms>>");

            this.add(fFigureCompleteParentStereotypeLabelFigure);

        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            PointList pl = new PointList();
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
            pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
            pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
            df.setTemplate(pl);
            df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
            return df;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureCompleteParentStereotypeLabelFigure() {
            return fFigureCompleteParentStereotypeLabelFigure;
        }

    }

}
