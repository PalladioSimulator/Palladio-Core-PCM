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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.dialogs.seff.OpenBranchConditionDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.GuardedBranchTransitionCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.GuardedBranchTransitionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class GuardedBranchTransitionEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3017;

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
    public GuardedBranchTransitionEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GuardedBranchTransitionItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new GuardedBranchTransitionCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenBranchConditionDialog());
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
        return primaryShape = new BranchTransitionFigure();
    }

    /**
     * @generated
     */
    public BranchTransitionFigure getPrimaryShape() {
        return (BranchTransitionFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof GuardedBranchTransitionEntityNameEditPart) {
            ((GuardedBranchTransitionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureBranchTransitionNameLabel());
            return true;
        }
        if (childEditPart instanceof GuardedBranchTransitionIdEditPart) {
            ((GuardedBranchTransitionIdEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureBranchTransitionConditionLabel());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof GuardedBranchTransitionEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof GuardedBranchTransitionIdEditPart) {
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
                .getType(GuardedBranchTransitionEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class BranchTransitionFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureBranchTransitionNameLabel;

        /**
         * @generated
         */
        private WrappingLabel fFigureBranchTransitionConditionLabel;

        /**
         * @generated
         */
        private WrappingLabel fFigureBranchTransitionProbabilityLabel;

        /**
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
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionProbabilityLabel() {
            return fFigureBranchTransitionProbabilityLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionNameLabel() {
            return fFigureBranchTransitionNameLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureBranchTransitionConditionLabel() {
            return fFigureBranchTransitionConditionLabel;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.draw2d.Figure#add(org.eclipse.draw2d.IFigure, java.lang.Object, int)
         */
        /**
         * Adds the.
         * 
         * @param figure
         *            the figure
         * @param constraint
         *            the constraint
         * @param index
         *            the index
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
