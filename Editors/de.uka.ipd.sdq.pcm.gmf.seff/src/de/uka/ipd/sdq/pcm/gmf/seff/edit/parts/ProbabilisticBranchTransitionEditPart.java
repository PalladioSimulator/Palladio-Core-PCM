/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.Graphics;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ProbabilisticBranchTransitionCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ProbabilisticBranchTransitionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class ProbabilisticBranchTransitionEditPart.
 *
 * @generated
 */
public class ProbabilisticBranchTransitionEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3010;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new probabilistic branch transition edit part.
     *
     * @param view the view
     * @generated
     */
    public ProbabilisticBranchTransitionEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProbabilisticBranchTransitionItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ProbabilisticBranchTransitionCanonicalEditPolicy());
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
        BranchTransitionFigure figure = new BranchTransitionFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public BranchTransitionFigure getPrimaryShape() {
        return (BranchTransitionFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ProbabilisticBranchTransitionEntityNameEditPart) {
            ((ProbabilisticBranchTransitionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureBranchTransitionNameLabel());
            return true;
        }
        if (childEditPart instanceof ProbabilisticBranchTransitionBranchProbabilityEditPart) {
            ((ProbabilisticBranchTransitionBranchProbabilityEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureBranchTransitionProbabilityLabel());
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
        if (childEditPart instanceof ProbabilisticBranchTransitionEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof ProbabilisticBranchTransitionBranchProbabilityEditPart) {
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
                .getType(ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID));
    }

    /**
     * The Class BranchTransitionFigure.
     *
     * @generated
     */
    public class BranchTransitionFigure extends RectangleFigure {
        
        /** The figure branch transition name label. @generated */
        private WrappingLabel fFigureBranchTransitionNameLabel;
        
        /** The figure branch transition condition label. @generated */
        private WrappingLabel fFigureBranchTransitionConditionLabel;
        
        /** The figure branch transition probability label. @generated */
        private WrappingLabel fFigureBranchTransitionProbabilityLabel;

        /**
         * Instantiates a new branch transition figure.
         *
         * @generated
         */
        public BranchTransitionFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(2);
            this.setLineStyle(Graphics.LINE_DASH);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated
         */
        private void createContents() {

            fFigureBranchTransitionNameLabel = new WrappingLabel();
            fFigureBranchTransitionNameLabel.setText("");
            fFigureBranchTransitionNameLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureBranchTransitionNameLabel = new GridData();
            constraintFFigureBranchTransitionNameLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionNameLabel.horizontalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionNameLabel.horizontalIndent = 0;
            constraintFFigureBranchTransitionNameLabel.horizontalSpan = 1;
            constraintFFigureBranchTransitionNameLabel.verticalSpan = 1;
            constraintFFigureBranchTransitionNameLabel.grabExcessHorizontalSpace = false;
            constraintFFigureBranchTransitionNameLabel.grabExcessVerticalSpace = false;
            this.add(fFigureBranchTransitionNameLabel, constraintFFigureBranchTransitionNameLabel);

            fFigureBranchTransitionProbabilityLabel = new WrappingLabel();
            fFigureBranchTransitionProbabilityLabel.setText("");
            fFigureBranchTransitionProbabilityLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureBranchTransitionProbabilityLabel = new GridData();
            constraintFFigureBranchTransitionProbabilityLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionProbabilityLabel.horizontalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionProbabilityLabel.horizontalIndent = 0;
            constraintFFigureBranchTransitionProbabilityLabel.horizontalSpan = 1;
            constraintFFigureBranchTransitionProbabilityLabel.verticalSpan = 1;
            constraintFFigureBranchTransitionProbabilityLabel.grabExcessHorizontalSpace = false;
            constraintFFigureBranchTransitionProbabilityLabel.grabExcessVerticalSpace = false;
            this.add(fFigureBranchTransitionProbabilityLabel, constraintFFigureBranchTransitionProbabilityLabel);

            fFigureBranchTransitionConditionLabel = new WrappingLabel();
            fFigureBranchTransitionConditionLabel.setText("");
            fFigureBranchTransitionConditionLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureBranchTransitionConditionLabel = new GridData();
            constraintFFigureBranchTransitionConditionLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionConditionLabel.horizontalAlignment = GridData.CENTER;
            constraintFFigureBranchTransitionConditionLabel.horizontalIndent = 0;
            constraintFFigureBranchTransitionConditionLabel.horizontalSpan = 1;
            constraintFFigureBranchTransitionConditionLabel.verticalSpan = 1;
            constraintFFigureBranchTransitionConditionLabel.grabExcessHorizontalSpace = false;
            constraintFFigureBranchTransitionConditionLabel.grabExcessVerticalSpace = false;
            this.add(fFigureBranchTransitionConditionLabel, constraintFFigureBranchTransitionConditionLabel);

        }

        /**
         * Gets the figure branch transition probability label.
         *
         * @return the figure branch transition probability label
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionProbabilityLabel() {
            return fFigureBranchTransitionProbabilityLabel;
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

        /**
         * Gets the figure branch transition name label.
         *
         * @return the figure branch transition name label
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionNameLabel() {
            return fFigureBranchTransitionNameLabel;
        }

        /**
         * Gets the figure branch transition condition label.
         *
         * @return the figure branch transition condition label
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionConditionLabel() {
            return fFigureBranchTransitionConditionLabel;
        }

        /* (non-Javadoc)
         * @see org.eclipse.draw2d.Figure#add(org.eclipse.draw2d.IFigure, java.lang.Object, int)
         */
        /**
         * Adds the.
         *
         * @param figure the figure
         * @param constraint the constraint
         * @param index the index
         * @see org.eclipse.draw2d.Figure#add(org.eclipse.draw2d.IFigure, java.lang.Object, int)
         */
        @Override
        public void add(IFigure figure, Object constraint, int index) {
            Object newConstraint = constraint;
            if (newConstraint == null) {
                GridData layout = new GridData();
                layout.grabExcessHorizontalSpace = true;
                layout.grabExcessVerticalSpace = true;
                layout.horizontalAlignment = SWT.FILL;
                layout.verticalAlignment = SWT.FILL;
                layout.horizontalSpan = 1;
                layout.verticalSpan = 1;

                newConstraint = layout;
            }
            super.add(figure, newConstraint, index);
        }
    }

}
