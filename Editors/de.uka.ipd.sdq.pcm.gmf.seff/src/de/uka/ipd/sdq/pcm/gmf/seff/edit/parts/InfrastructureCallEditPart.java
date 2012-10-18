/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InfrastructureCallItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class InfrastructureCallEditPart.
 *
 * @generated
 */
public class InfrastructureCallEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3053;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new infrastructure call edit part.
     *
     * @param view the view
     * @generated
     */
    public InfrastructureCallEditPart(View view) {
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
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InfrastructureCallItemSemanticEditPolicy());
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
        InfrastructureCallFigure figure = new InfrastructureCallFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public InfrastructureCallFigure getPrimaryShape() {
        return (InfrastructureCallFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof InfrastructureCallNumberOfCallsLabelEditPart) {
            ((InfrastructureCallNumberOfCallsLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureInfrastructureCallNumberOfCallsLabel());
            return true;
        }
        if (childEditPart instanceof InfrastructureCallTargetLabelEditPart) {
            ((InfrastructureCallTargetLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureInfrastructureCallTargetLabel());
            return true;
        }
        if (childEditPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            IFigure pane = getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) childEditPart).getFigure());
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
        if (childEditPart instanceof InfrastructureCallNumberOfCallsLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof InfrastructureCallTargetLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            IFigure pane = getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) childEditPart).getFigure());
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
        if (editPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            return getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
        }
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
                .getType(InfrastructureCallNumberOfCallsLabelEditPart.VISUAL_ID));
    }

    /**
     * Gets the target edit part.
     *
     * @param request the request
     * @return the target edit part
     * @generated
     */
    public EditPart getTargetEditPart(Request request) {
        if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
                    .getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == PalladioComponentModelElementTypes.VariableUsage_3054) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * The Class InfrastructureCallFigure.
     *
     * @generated
     */
    public class InfrastructureCallFigure extends RoundedRectangle {

        /** The figure infrastructure call variable usages compartment. @generated */
        private RectangleFigure fFigureInfrastructureCallVariableUsagesCompartment;
        
        /** The figure infrastructure call target label. @generated */
        private WrappingLabel fFigureInfrastructureCallTargetLabel;
        
        /** The figure infrastructure call number of calls label. @generated */
        private WrappingLabel fFigureInfrastructureCallNumberOfCallsLabel;

        /**
         * Instantiates a new infrastructure call figure.
         *
         * @generated
         */
        public InfrastructureCallFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 2;
            layoutThis.makeColumnsEqualWidth = false;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
            this.setLineWidth(1);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated
         */
        private void createContents() {

            fFigureInfrastructureCallNumberOfCallsLabel = new WrappingLabel();
            fFigureInfrastructureCallNumberOfCallsLabel.setText("x");
            fFigureInfrastructureCallNumberOfCallsLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));

            GridData constraintFFigureInfrastructureCallNumberOfCallsLabel = new GridData();
            constraintFFigureInfrastructureCallNumberOfCallsLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.horizontalAlignment = GridData.BEGINNING;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.horizontalIndent = 0;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.horizontalSpan = 1;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.verticalSpan = 1;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.grabExcessHorizontalSpace = false;
            constraintFFigureInfrastructureCallNumberOfCallsLabel.grabExcessVerticalSpace = false;
            this.add(fFigureInfrastructureCallNumberOfCallsLabel, constraintFFigureInfrastructureCallNumberOfCallsLabel);

            fFigureInfrastructureCallTargetLabel = new WrappingLabel();
            fFigureInfrastructureCallTargetLabel.setText("infrastructureCallTargetLabel");
            fFigureInfrastructureCallTargetLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));

            GridData constraintFFigureInfrastructureCallTargetLabel = new GridData();
            constraintFFigureInfrastructureCallTargetLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureInfrastructureCallTargetLabel.horizontalAlignment = GridData.BEGINNING;
            constraintFFigureInfrastructureCallTargetLabel.horizontalIndent = 0;
            constraintFFigureInfrastructureCallTargetLabel.horizontalSpan = 1;
            constraintFFigureInfrastructureCallTargetLabel.verticalSpan = 1;
            constraintFFigureInfrastructureCallTargetLabel.grabExcessHorizontalSpace = false;
            constraintFFigureInfrastructureCallTargetLabel.grabExcessVerticalSpace = false;
            this.add(fFigureInfrastructureCallTargetLabel, constraintFFigureInfrastructureCallTargetLabel);

            fFigureInfrastructureCallVariableUsagesCompartment = new RectangleFigure();
            fFigureInfrastructureCallVariableUsagesCompartment.setFill(false);
            fFigureInfrastructureCallVariableUsagesCompartment.setOutline(false);
            fFigureInfrastructureCallVariableUsagesCompartment.setLineWidth(1);
            fFigureInfrastructureCallVariableUsagesCompartment.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(0)));

            GridData constraintFFigureInfrastructureCallVariableUsagesCompartment = new GridData();
            constraintFFigureInfrastructureCallVariableUsagesCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.horizontalIndent = 0;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.horizontalSpan = 2;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.verticalSpan = 1;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureInfrastructureCallVariableUsagesCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureInfrastructureCallVariableUsagesCompartment,
                    constraintFFigureInfrastructureCallVariableUsagesCompartment);

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
         * Gets the figure infrastructure call variable usages compartment.
         *
         * @return the figure infrastructure call variable usages compartment
         * @generated
         */
        public RectangleFigure getFigureInfrastructureCallVariableUsagesCompartment() {
            return fFigureInfrastructureCallVariableUsagesCompartment;
        }

        /**
         * Gets the figure infrastructure call target label.
         *
         * @return the figure infrastructure call target label
         * @generated
         */
        public WrappingLabel getFigureInfrastructureCallTargetLabel() {
            return fFigureInfrastructureCallTargetLabel;
        }

        /**
         * Gets the figure infrastructure call number of calls label.
         *
         * @return the figure infrastructure call number of calls label
         * @generated
         */
        public WrappingLabel getFigureInfrastructureCallNumberOfCallsLabel() {
            return fFigureInfrastructureCallNumberOfCallsLabel;
        }

    }

}
