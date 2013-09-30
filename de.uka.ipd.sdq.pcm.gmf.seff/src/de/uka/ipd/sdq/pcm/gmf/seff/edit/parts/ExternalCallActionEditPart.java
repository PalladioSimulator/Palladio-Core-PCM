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
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ExternalCallActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ExternalCallActionEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2003;

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
    public ExternalCallActionEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ExternalCallActionItemSemanticEditPolicy());
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
        return primaryShape = new ExternalCallActionFigure();
    }

    /**
     * @generated
     */
    public ExternalCallActionFigure getPrimaryShape() {
        return (ExternalCallActionFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ExternalCallActionEntityNameEditPart) {
            ((ExternalCallActionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureComponentExternalCallName());
            return true;
        }
        if (childEditPart instanceof ExternalCallActionInputVariableUsageEditPart) {
            IFigure pane = getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((ExternalCallActionInputVariableUsageEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof ExternalCallActionOutputVariableUsageEditPart) {
            IFigure pane = getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((ExternalCallActionOutputVariableUsageEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ExternalCallActionEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof ExternalCallActionInputVariableUsageEditPart) {
            IFigure pane = getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
            pane.remove(((ExternalCallActionInputVariableUsageEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof ExternalCallActionOutputVariableUsageEditPart) {
            IFigure pane = getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
            pane.remove(((ExternalCallActionOutputVariableUsageEditPart) childEditPart).getFigure());
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
        if (editPart instanceof ExternalCallActionInputVariableUsageEditPart) {
            return getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
        }
        if (editPart instanceof ExternalCallActionOutputVariableUsageEditPart) {
            return getPrimaryShape().getFigureExternalCallActionCompartmentRectangle();
        }
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
                .getType(ExternalCallActionEntityNameEditPart.VISUAL_ID));
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
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart) {
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
        if (targetEditPart instanceof CollectionIteratorActionEditPart) {
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
    public EditPart getTargetEditPart(Request request) {
        if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
                    .getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == PalladioComponentModelElementTypes.VariableUsage_3042) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(ExternalCallActionInputVariableUsageEditPart.VISUAL_ID));
            }
            if (type == PalladioComponentModelElementTypes.VariableUsage_3049) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * @generated
     */
    public class ExternalCallActionFigure extends RoundedRectangle {

        /**
         * @generated
         */
        private WrappingLabel fFigureComponentExternalCallName;

        /**
         * @generated
         */
        private RectangleFigure fFigureExternalCallActionCompartmentRectangle;

        /**
         * @generated
         */
        public ExternalCallActionFigure() {

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

            WrappingLabel stereotypeLabel0 = new WrappingLabel();

            stereotypeLabel0.setText("<<ExternalCallAction>>");
            stereotypeLabel0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintStereotypeLabel0 = new GridData();
            constraintStereotypeLabel0.verticalAlignment = GridData.CENTER;
            constraintStereotypeLabel0.horizontalAlignment = GridData.CENTER;
            constraintStereotypeLabel0.horizontalIndent = 0;
            constraintStereotypeLabel0.horizontalSpan = 1;
            constraintStereotypeLabel0.verticalSpan = 1;
            constraintStereotypeLabel0.grabExcessHorizontalSpace = false;
            constraintStereotypeLabel0.grabExcessVerticalSpace = false;
            this.add(stereotypeLabel0, constraintStereotypeLabel0);

            fFigureComponentExternalCallName = new WrappingLabel();

            fFigureComponentExternalCallName.setText("myCall");
            fFigureComponentExternalCallName.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureComponentExternalCallName = new GridData();
            constraintFFigureComponentExternalCallName.verticalAlignment = GridData.CENTER;
            constraintFFigureComponentExternalCallName.horizontalAlignment = GridData.CENTER;
            constraintFFigureComponentExternalCallName.horizontalIndent = 0;
            constraintFFigureComponentExternalCallName.horizontalSpan = 1;
            constraintFFigureComponentExternalCallName.verticalSpan = 1;
            constraintFFigureComponentExternalCallName.grabExcessHorizontalSpace = false;
            constraintFFigureComponentExternalCallName.grabExcessVerticalSpace = false;
            this.add(fFigureComponentExternalCallName, constraintFFigureComponentExternalCallName);

            fFigureExternalCallActionCompartmentRectangle = new RectangleFigure();

            fFigureExternalCallActionCompartmentRectangle.setFill(false);
            fFigureExternalCallActionCompartmentRectangle.setOutline(false);
            fFigureExternalCallActionCompartmentRectangle.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(0)));

            GridData constraintFFigureExternalCallActionCompartmentRectangle = new GridData();
            constraintFFigureExternalCallActionCompartmentRectangle.verticalAlignment = GridData.FILL;
            constraintFFigureExternalCallActionCompartmentRectangle.horizontalAlignment = GridData.FILL;
            constraintFFigureExternalCallActionCompartmentRectangle.horizontalIndent = 0;
            constraintFFigureExternalCallActionCompartmentRectangle.horizontalSpan = 1;
            constraintFFigureExternalCallActionCompartmentRectangle.verticalSpan = 1;
            constraintFFigureExternalCallActionCompartmentRectangle.grabExcessHorizontalSpace = true;
            constraintFFigureExternalCallActionCompartmentRectangle.grabExcessVerticalSpace = true;
            this.add(fFigureExternalCallActionCompartmentRectangle,
                    constraintFFigureExternalCallActionCompartmentRectangle);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureComponentExternalCallName() {
            return fFigureComponentExternalCallName;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureExternalCallActionCompartmentRectangle() {
            return fFigureExternalCallActionCompartmentRectangle;
        }

    }

}
