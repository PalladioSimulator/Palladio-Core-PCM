/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.VariableUsageItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * The Class VariableUsageEditPart.
 *
 * @generated
 */
public class VariableUsageEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3012;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new variable usage edit part.
     *
     * @param view the view
     * @generated
     */
    public VariableUsageEditPart(View view) {
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
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new VariableUsageItemSemanticEditPolicy());
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
        ParametricParameterUsageFigure figure = new ParametricParameterUsageFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public ParametricParameterUsageFigure getPrimaryShape() {
        return (ParametricParameterUsageFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof WrappingLabelEditPart) {
            ((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureVariableUsageReferenceLabelFigure());
            return true;
        }
        if (childEditPart instanceof VariableUsageVariableCharacterisationEditPart) {
            IFigure pane = getPrimaryShape().getFigureParametricParameterUsageRectangleCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((VariableUsageVariableCharacterisationEditPart) childEditPart).getFigure());
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
        if (childEditPart instanceof WrappingLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof VariableUsageVariableCharacterisationEditPart) {
            IFigure pane = getPrimaryShape().getFigureParametricParameterUsageRectangleCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((VariableUsageVariableCharacterisationEditPart) childEditPart).getFigure());
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
        if (editPart instanceof VariableUsageVariableCharacterisationEditPart) {
            return getPrimaryShape().getFigureParametricParameterUsageRectangleCompartment();
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
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
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
            if (type == PalladioComponentModelElementTypes.VariableCharacterisation_3013) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(VariableUsageVariableCharacterisationEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * The Class ParametricParameterUsageFigure.
     *
     * @generated
     */
    public class ParametricParameterUsageFigure extends RectangleFigure {
        
        /** The figure variable usage reference label figure. @generated */
        private WrappingLabel fFigureVariableUsageReferenceLabelFigure;

        /** The figure parametric parameter usage rectangle compartment. @generated */
        private RectangleFigure fFigureParametricParameterUsageRectangleCompartment;

        /**
         * Instantiates a new parametric parameter usage figure.
         *
         * @generated
         */
        public ParametricParameterUsageFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(1);
            this.setBackgroundColor(THIS_BACK);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated not
         */
        private void createContents() {

            fFigureVariableUsageReferenceLabelFigure = new WrappingLabel();
            fFigureVariableUsageReferenceLabelFigure.setText(new PCMStoExPrettyPrintVisitor()
                    .prettyPrint(((VariableUsage) resolveSemanticElement()).getNamedReference__VariableUsage()));
            fFigureVariableUsageReferenceLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureVariableUsageReferenceLabelFigure = new GridData();
            constraintFFigureVariableUsageReferenceLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalIndent = 0;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.verticalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureVariableUsageReferenceLabelFigure, constraintFFigureVariableUsageReferenceLabelFigure);

            fFigureParametricParameterUsageRectangleCompartment = new RectangleFigure();
            fFigureParametricParameterUsageRectangleCompartment.setFill(false);
            fFigureParametricParameterUsageRectangleCompartment.setOutline(false);

            GridData constraintFFigureParametricParameterUsageRectangleCompartment = new GridData();
            constraintFFigureParametricParameterUsageRectangleCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalIndent = 0;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalSpan = 1;
            constraintFFigureParametricParameterUsageRectangleCompartment.verticalSpan = 1;
            constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureParametricParameterUsageRectangleCompartment,
                    constraintFFigureParametricParameterUsageRectangleCompartment);

        }

        /**
         * Gets the figure variable usage reference label figure.
         *
         * @return the figure variable usage reference label figure
         * @generated
         */
        public WrappingLabel getFigureVariableUsageReferenceLabelFigure() {
            return fFigureVariableUsageReferenceLabelFigure;
        }

        /**
         * Gets the figure parametric parameter usage rectangle compartment.
         *
         * @return the figure parametric parameter usage rectangle compartment
         * @generated
         */
        public RectangleFigure getFigureParametricParameterUsageRectangleCompartment() {
            return fFigureParametricParameterUsageRectangleCompartment;
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

    /** The Constant THIS_BACK. @generated */
    static final Color THIS_BACK = new Color(null, 220, 220, 220);

}
