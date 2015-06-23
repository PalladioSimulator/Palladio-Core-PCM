/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.ClosedWorkloadItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ClosedWorkloadEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3015;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    protected IFigure primaryShape;

    /**
     * @generated
     */
    public ClosedWorkloadEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClosedWorkloadItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated
     */
    protected IFigure createNodeShape() {
        return primaryShape = new ClosedWorkloadFigure();
    }

    /**
     * @generated
     */
    public ClosedWorkloadFigure getPrimaryShape() {
        return (ClosedWorkloadFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ClosedWorkloadPopulationEditPart) {
            ((ClosedWorkloadPopulationEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureClosedWorkloadPopulationFigure());
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadTitleLabelEditPart) {
            ((ClosedWorkloadTitleLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureClosedWorkloadTitleLabelFigure());
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadThinkTimeLabelEditPart) {
            ((ClosedWorkloadThinkTimeLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureClosedWorkloadThinkTimeLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ClosedWorkloadPopulationEditPart) {
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadTitleLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadThinkTimeLabelEditPart) {
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
        super.addChildVisual(childEditPart, -1);
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
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        return getContentPane();
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * @generated
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                .getType(ClosedWorkloadPopulationEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class ClosedWorkloadFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureClosedWorkloadTitleLabelFigure;

        /**
         * @generated
         */
        private WrappingLabel fFigureClosedWorkloadPopulationFigure;

        /**
         * @generated
         */
        private WrappingLabel fFigureClosedWorkloadThinkTimeLabelFigure;

        /**
         * @generated
         */
        public ClosedWorkloadFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setBackgroundColor(ColorConstants.yellow);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureClosedWorkloadTitleLabelFigure = new WrappingLabel();

            fFigureClosedWorkloadTitleLabelFigure.setText("<<ClosedWorkload>>");
            fFigureClosedWorkloadTitleLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureClosedWorkloadTitleLabelFigure = new GridData();
            constraintFFigureClosedWorkloadTitleLabelFigure.verticalAlignment = GridData.BEGINNING;
            constraintFFigureClosedWorkloadTitleLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureClosedWorkloadTitleLabelFigure.horizontalIndent = 0;
            constraintFFigureClosedWorkloadTitleLabelFigure.horizontalSpan = 1;
            constraintFFigureClosedWorkloadTitleLabelFigure.verticalSpan = 1;
            constraintFFigureClosedWorkloadTitleLabelFigure.grabExcessHorizontalSpace = true;
            constraintFFigureClosedWorkloadTitleLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureClosedWorkloadTitleLabelFigure, constraintFFigureClosedWorkloadTitleLabelFigure);

            fFigureClosedWorkloadPopulationFigure = new WrappingLabel();

            fFigureClosedWorkloadPopulationFigure.setText("<...>");
            fFigureClosedWorkloadPopulationFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureClosedWorkloadPopulationFigure = new GridData();
            constraintFFigureClosedWorkloadPopulationFigure.verticalAlignment = GridData.BEGINNING;
            constraintFFigureClosedWorkloadPopulationFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureClosedWorkloadPopulationFigure.horizontalIndent = 0;
            constraintFFigureClosedWorkloadPopulationFigure.horizontalSpan = 1;
            constraintFFigureClosedWorkloadPopulationFigure.verticalSpan = 1;
            constraintFFigureClosedWorkloadPopulationFigure.grabExcessHorizontalSpace = true;
            constraintFFigureClosedWorkloadPopulationFigure.grabExcessVerticalSpace = false;
            this.add(fFigureClosedWorkloadPopulationFigure, constraintFFigureClosedWorkloadPopulationFigure);

            fFigureClosedWorkloadThinkTimeLabelFigure = new WrappingLabel();

            fFigureClosedWorkloadThinkTimeLabelFigure.setText("");
            fFigureClosedWorkloadThinkTimeLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureClosedWorkloadThinkTimeLabelFigure = new GridData();
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.verticalAlignment = GridData.BEGINNING;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.horizontalIndent = 0;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.horizontalSpan = 1;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.verticalSpan = 1;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.grabExcessHorizontalSpace = true;
            constraintFFigureClosedWorkloadThinkTimeLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureClosedWorkloadThinkTimeLabelFigure, constraintFFigureClosedWorkloadThinkTimeLabelFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadPopulationFigure() {
            return fFigureClosedWorkloadPopulationFigure;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadThinkTimeLabelFigure() {
            return fFigureClosedWorkloadThinkTimeLabelFigure;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadTitleLabelFigure() {
            return fFigureClosedWorkloadTitleLabelFigure;
        }

    }

}
