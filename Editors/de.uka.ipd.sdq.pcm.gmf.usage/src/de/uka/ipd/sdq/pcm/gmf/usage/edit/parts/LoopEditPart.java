/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.LoopCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.LoopItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class LoopEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3005;

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
    public LoopEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LoopItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new LoopCanonicalEditPolicy());
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
        return primaryShape = new UsageLoopFigure();
    }

    /**
     * @generated
     */
    public UsageLoopFigure getPrimaryShape() {
        return (UsageLoopFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof UsageLoopIterationsLabelEditPart) {
            ((UsageLoopIterationsLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureUsageLoopIterationsLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof UsageLoopIterationsLabelEditPart) {
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
                .getType(UsageLoopIterationsLabelEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (targetEditPart instanceof StartEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof StopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof EntryLevelSystemCallEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof BranchEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof DelayEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Start_3001);
            types.add(PalladioComponentModelElementTypes.Stop_3002);
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
            types.add(PalladioComponentModelElementTypes.Loop_3005);
            types.add(PalladioComponentModelElementTypes.Branch_3008);
            types.add(PalladioComponentModelElementTypes.Delay_3017);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Start_3001);
            types.add(PalladioComponentModelElementTypes.Stop_3002);
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
            types.add(PalladioComponentModelElementTypes.Loop_3005);
            types.add(PalladioComponentModelElementTypes.Branch_3008);
            types.add(PalladioComponentModelElementTypes.Delay_3017);
        }
        return types;
    }

    /**
     * @generated
     */
    public class UsageLoopFigure extends RoundedRectangle {

        /**
         * @generated
         */
        private WrappingLabel fFigureUsageLoopIterationsLabelFigure;

        /**
         * @generated
         */
        public UsageLoopFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            WrappingLabel usageLoopStereotypeLabelFigure0 = new WrappingLabel();

            usageLoopStereotypeLabelFigure0.setText("<<Loop>>");
            usageLoopStereotypeLabelFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintUsageLoopStereotypeLabelFigure0 = new GridData();
            constraintUsageLoopStereotypeLabelFigure0.verticalAlignment = GridData.BEGINNING;
            constraintUsageLoopStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
            constraintUsageLoopStereotypeLabelFigure0.horizontalIndent = 0;
            constraintUsageLoopStereotypeLabelFigure0.horizontalSpan = 1;
            constraintUsageLoopStereotypeLabelFigure0.verticalSpan = 1;
            constraintUsageLoopStereotypeLabelFigure0.grabExcessHorizontalSpace = true;
            constraintUsageLoopStereotypeLabelFigure0.grabExcessVerticalSpace = false;
            this.add(usageLoopStereotypeLabelFigure0, constraintUsageLoopStereotypeLabelFigure0);

            fFigureUsageLoopIterationsLabelFigure = new WrappingLabel();

            fFigureUsageLoopIterationsLabelFigure.setText("");
            fFigureUsageLoopIterationsLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureUsageLoopIterationsLabelFigure = new GridData();
            constraintFFigureUsageLoopIterationsLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureUsageLoopIterationsLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureUsageLoopIterationsLabelFigure.horizontalIndent = 0;
            constraintFFigureUsageLoopIterationsLabelFigure.horizontalSpan = 1;
            constraintFFigureUsageLoopIterationsLabelFigure.verticalSpan = 1;
            constraintFFigureUsageLoopIterationsLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureUsageLoopIterationsLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureUsageLoopIterationsLabelFigure, constraintFFigureUsageLoopIterationsLabelFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureUsageLoopIterationsLabelFigure() {
            return fFigureUsageLoopIterationsLabelFigure;
        }

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
