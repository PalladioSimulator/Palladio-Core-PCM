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
 * The Class ClosedWorkloadEditPart.
 *
 * @generated
 */
public class ClosedWorkloadEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3015;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new closed workload edit part.
     *
     * @param view the view
     * @generated
     */
    public ClosedWorkloadEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClosedWorkloadItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * Creates the layout edit policy.
     *
     * @return the layout edit policy
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        LayoutEditPolicy lep = new LayoutEditPolicy() {

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
     * Creates the node shape.
     *
     * @return the i figure
     * @generated
     */
    protected IFigure createNodeShape() {
        ClosedWorkloadFigure figure = new ClosedWorkloadFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public ClosedWorkloadFigure getPrimaryShape() {
        return (ClosedWorkloadFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
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
        if (childEditPart instanceof ClosedWorkloadPopulationEditPart) {
            ((ClosedWorkloadPopulationEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureClosedWorkloadPopulationFigure());
            return true;
        }
        return false;
    }

    /**
     * Removes the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ClosedWorkloadTitleLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadThinkTimeLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof ClosedWorkloadPopulationEditPart) {
            return true;
        }
        return false;
    }

    /**
     * Adds the child visual.
     *
     * @param childEditPart the child edit part
     * @param index the index
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * Removes the child visual.
     *
     * @param childEditPart the child edit part
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * Gets the content pane for.
     *
     * @param editPart the edit part
     * @return the content pane for
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        return getContentPane();
    }

    /**
     * Creates the node plate.
     *
     * @return the node figure
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     *
     * @return the node figure
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
     * Default implementation treats passed figure as content pane. Respects layout one may have set
     * for generated figure.
     *
     * @param nodeShape instance of generated figure class
     * @return the i figure
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
     * Gets the content pane.
     *
     * @return the content pane
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * Sets the foreground color.
     *
     * @param color the new foreground color
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * Sets the background color.
     *
     * @param color the new background color
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * Sets the line width.
     *
     * @param width the new line width
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * Sets the line type.
     *
     * @param style the new line type
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * Gets the primary child edit part.
     *
     * @return the primary child edit part
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                .getType(ClosedWorkloadPopulationEditPart.VISUAL_ID));
    }

    /**
     * The Class ClosedWorkloadFigure.
     *
     * @generated
     */
    public class ClosedWorkloadFigure extends RectangleFigure {
        
        /** The figure closed workload title label figure. @generated */
        private WrappingLabel fFigureClosedWorkloadTitleLabelFigure;
        
        /** The figure closed workload population figure. @generated */
        private WrappingLabel fFigureClosedWorkloadPopulationFigure;
        
        /** The figure closed workload think time label figure. @generated */
        private WrappingLabel fFigureClosedWorkloadThinkTimeLabelFigure;

        /**
         * Instantiates a new closed workload figure.
         *
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

            this.setLineWidth(1);
            this.setBackgroundColor(ColorConstants.yellow);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
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
         * Gets the figure closed workload population figure.
         *
         * @return the figure closed workload population figure
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadPopulationFigure() {
            return fFigureClosedWorkloadPopulationFigure;
        }

        /**
         * Gets the figure closed workload think time label figure.
         *
         * @return the figure closed workload think time label figure
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadThinkTimeLabelFigure() {
            return fFigureClosedWorkloadThinkTimeLabelFigure;
        }

        /**
         * Gets the figure closed workload title label figure.
         *
         * @return the figure closed workload title label figure
         * @generated
         */
        public WrappingLabel getFigureClosedWorkloadTitleLabelFigure() {
            return fFigureClosedWorkloadTitleLabelFigure;
        }

        /** The my use local coordinates. @generated */
        private boolean myUseLocalCoordinates = false;

        /**
         * Use local coordinates.
         *
         * @return true, if successful
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * Sets the use local coordinates.
         *
         * @param useLocalCoordinates the new use local coordinates
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

    }

}
