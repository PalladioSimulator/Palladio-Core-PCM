/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.CollectionIteratorActionCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.CollectionIteratorActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class CollectionIteratorActionEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2007;

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
    public CollectionIteratorActionEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CollectionIteratorActionItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CollectionIteratorActionCanonicalEditPolicy());
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
        return primaryShape = new CollectionIteratorFigure();
    }

    /**
     * @generated
     */
    public CollectionIteratorFigure getPrimaryShape() {
        return (CollectionIteratorFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof CollectionIteratorActionEntityNameEditPart) {
            ((CollectionIteratorActionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureCollectionIteratorNameLabelFigure());
            return true;
        }
        if (childEditPart instanceof CollectionIteratorParameterLabel2EditPart) {
            ((CollectionIteratorParameterLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureCollectionIteratorParameterLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof CollectionIteratorActionEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof CollectionIteratorParameterLabel2EditPart) {
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
                .getType(CollectionIteratorActionEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (targetEditPart instanceof StartActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StopActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ExternalCallActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof EmitEventActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof LoopActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof BranchActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof InternalActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof SetVariableActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof AcquireActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ReleaseActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ForkActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof RecoveryActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StartAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StopAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof LoopAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof InternalAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof BranchAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ExternalCallAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof EmitEventAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof AcquireAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ReleaseAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ForkAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof RecoveryAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof SetVariableAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_2001);
            types.add(PalladioComponentModelElementTypes.StopAction_2002);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
            types.add(PalladioComponentModelElementTypes.LoopAction_2004);
            types.add(PalladioComponentModelElementTypes.BranchAction_2005);
            types.add(PalladioComponentModelElementTypes.InternalAction_2006);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
            types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
            types.add(PalladioComponentModelElementTypes.ForkAction_2011);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_2017);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_2001);
            types.add(PalladioComponentModelElementTypes.StopAction_2002);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
            types.add(PalladioComponentModelElementTypes.LoopAction_2004);
            types.add(PalladioComponentModelElementTypes.BranchAction_2005);
            types.add(PalladioComponentModelElementTypes.InternalAction_2006);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
            types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
            types.add(PalladioComponentModelElementTypes.ForkAction_2011);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_2017);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
        }
        return types;
    }

    /**
     * @generated
     */
    public class CollectionIteratorFigure extends RoundedRectangle {

        /**
         * @generated
         */
        private WrappingLabel fFigureCollectionIteratorNameLabelFigure;

        /**
         * @generated
         */
        private WrappingLabel fFigureCollectionIteratorParameterLabelFigure;

        /**
         * @generated
         */
        public CollectionIteratorFigure() {

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

            WrappingLabel collectionIteratorStereotype0 = new WrappingLabel();

            collectionIteratorStereotype0.setText("<<CollectionIteratorAction>>");
            collectionIteratorStereotype0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintCollectionIteratorStereotype0 = new GridData();
            constraintCollectionIteratorStereotype0.verticalAlignment = GridData.CENTER;
            constraintCollectionIteratorStereotype0.horizontalAlignment = GridData.CENTER;
            constraintCollectionIteratorStereotype0.horizontalIndent = 0;
            constraintCollectionIteratorStereotype0.horizontalSpan = 1;
            constraintCollectionIteratorStereotype0.verticalSpan = 1;
            constraintCollectionIteratorStereotype0.grabExcessHorizontalSpace = false;
            constraintCollectionIteratorStereotype0.grabExcessVerticalSpace = false;
            this.add(collectionIteratorStereotype0, constraintCollectionIteratorStereotype0);

            fFigureCollectionIteratorNameLabelFigure = new WrappingLabel();

            fFigureCollectionIteratorNameLabelFigure.setText("myLoop");
            fFigureCollectionIteratorNameLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureCollectionIteratorNameLabelFigure = new GridData();
            constraintFFigureCollectionIteratorNameLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureCollectionIteratorNameLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureCollectionIteratorNameLabelFigure.horizontalIndent = 0;
            constraintFFigureCollectionIteratorNameLabelFigure.horizontalSpan = 1;
            constraintFFigureCollectionIteratorNameLabelFigure.verticalSpan = 1;
            constraintFFigureCollectionIteratorNameLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureCollectionIteratorNameLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureCollectionIteratorNameLabelFigure, constraintFFigureCollectionIteratorNameLabelFigure);

            fFigureCollectionIteratorParameterLabelFigure = new WrappingLabel();

            fFigureCollectionIteratorParameterLabelFigure.setText("");
            fFigureCollectionIteratorParameterLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
                    getMapMode().DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureCollectionIteratorParameterLabelFigure = new GridData();
            constraintFFigureCollectionIteratorParameterLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureCollectionIteratorParameterLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureCollectionIteratorParameterLabelFigure.horizontalIndent = 0;
            constraintFFigureCollectionIteratorParameterLabelFigure.horizontalSpan = 1;
            constraintFFigureCollectionIteratorParameterLabelFigure.verticalSpan = 1;
            constraintFFigureCollectionIteratorParameterLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureCollectionIteratorParameterLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureCollectionIteratorParameterLabelFigure,
                    constraintFFigureCollectionIteratorParameterLabelFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureCollectionIteratorNameLabelFigure() {
            return fFigureCollectionIteratorNameLabelFigure;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureCollectionIteratorParameterLabelFigure() {
            return fFigureCollectionIteratorParameterLabelFigure;
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
