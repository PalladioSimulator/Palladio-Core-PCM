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

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.CompleteComponentTypeParentProvidesComponentTypesItemSemanticEditPolicy;

/**
 * @generated
 */
public class CompleteComponentTypeParentProvidesComponentTypesEditPart extends ConnectionNodeEditPart implements
        ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4104;

    /**
     * @generated
     */
    public CompleteComponentTypeParentProvidesComponentTypesEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new CompleteComponentTypeParentProvidesComponentTypesItemSemanticEditPolicy());
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof CompleteComponentTypeParentProvidesComponentTypesLabelEditPart) {
            ((CompleteComponentTypeParentProvidesComponentTypesLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureProvidesParentStereotypeLabelFigure());
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
        if (childEditPart instanceof CompleteComponentTypeParentProvidesComponentTypesLabelEditPart) {
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
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     * 
     * @generated
     */
    protected Connection createConnectionFigure() {
        return new ParentProvidesTypeFigure();
    }

    /**
     * @generated
     */
    public ParentProvidesTypeFigure getPrimaryShape() {
        return (ParentProvidesTypeFigure) getFigure();
    }

    /**
     * @generated
     */
    public class ParentProvidesTypeFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        private WrappingLabel fFigureProvidesParentStereotypeLabelFigure;

        /**
         * @generated
         */
        public ParentProvidesTypeFigure() {

            createContents();
            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureProvidesParentStereotypeLabelFigure = new WrappingLabel();

            fFigureProvidesParentStereotypeLabelFigure.setText("<<Conforms>>");

            this.add(fFigureProvidesParentStereotypeLabelFigure);

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
        public WrappingLabel getFigureProvidesParentStereotypeLabelFigure() {
            return fFigureProvidesParentStereotypeLabelFigure;
        }

    }

}
