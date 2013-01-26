/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntity2CanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntity2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The edit part for the inner containment rectangle. It is mapped with the composed providing
 * requiring entity as the outer part. For this, the index "2" has been added to the name.
 * 
 * @generated
 */
public class ComposedProvidingRequiringEntity2EditPart extends AbstractBorderedShapeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 2002;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new composed providing requiring entity2 edit part.
     * 
     * @param view
     *            the view
     * @generated
     */
    public ComposedProvidingRequiringEntity2EditPart(View view) {
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
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ComposedProvidingRequiringEntity2ItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ComposedProvidingRequiringEntity2CanonicalEditPolicy());
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
                View childView = (View) child.getModel();
                switch (PalladioComponentModelVisualIDRegistry.getVisualID(childView)) {
                case OperationProvidedRole2EditPart.VISUAL_ID:
                case OperationRequiredRole2EditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
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
        CompositeStructureFigure figure = new CompositeStructureFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     * 
     * @return the primary shape
     * @generated
     */
    public CompositeStructureFigure getPrimaryShape() {
        return (CompositeStructureFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     * 
     * @param childEditPart
     *            the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ComposedProvidingRequiringEntityEntityNameEditPart) {
            ((ComposedProvidingRequiringEntityEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureCompositeStructureNameLabelFigure());
            return true;
        }
        if (childEditPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureCompositeStructureInternals();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        if (childEditPart instanceof OperationProvidedRole2EditPart) {
            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
            getBorderedFigure().getBorderItemContainer().add(
                    ((OperationProvidedRole2EditPart) childEditPart).getFigure(), locator);
            return true;
        }
        if (childEditPart instanceof OperationRequiredRole2EditPart) {
            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
            getBorderedFigure().getBorderItemContainer().add(
                    ((OperationRequiredRole2EditPart) childEditPart).getFigure(), locator);
            return true;
        }
        return false;
    }

    /**
     * Removes the fixed child.
     * 
     * @param childEditPart
     *            the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ComposedProvidingRequiringEntityEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureCompositeStructureInternals();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        if (childEditPart instanceof OperationProvidedRole2EditPart) {
            getBorderedFigure().getBorderItemContainer().remove(
                    ((OperationProvidedRole2EditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof OperationRequiredRole2EditPart) {
            getBorderedFigure().getBorderItemContainer().remove(
                    ((OperationRequiredRole2EditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * Adds the child visual.
     * 
     * @param childEditPart
     *            the child edit part
     * @param index
     *            the index
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
     * @param childEditPart
     *            the child edit part
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
     * @param editPart
     *            the edit part
     * @return the content pane for
     * @generated not
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

        // TODO: Proof necessity of instance of type check
        // We found out that "return editPart.getFigure().getParent();" is sufficient
        // for the InnerCompartment. It might be sufficient for the roles to.
        // This should be proven and instance of separation removed if possible
        // (benjamin klatt)

        if (editPart instanceof OperationProvidedRoleEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        if (editPart instanceof OperationRequiredRoleEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        if (editPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            // get the rectangle figure that should be resized
            return editPart.getFigure().getParent();
        }
        return super.getContentPaneFor(editPart);
    }

    /**
     * Creates the node plate.
     * 
     * @return the node figure
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(500, 500);
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
    protected NodeFigure createMainFigure() {
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
     * @param nodeShape
     *            instance of generated figure class
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
     * @param color
     *            the new foreground color
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
     * @param color
     *            the new background color
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
     * @param width
     *            the new line width
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
     * @param style
     *            the new line type
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
                .getType(ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID));
    }

    /**
     * The Class CompositeStructureFigure.
     * 
     * @generated
     */
    public class CompositeStructureFigure extends RectangleFigure {

        /** The figure composite structure name label figure. @generated */
        private WrappingLabel fFigureCompositeStructureNameLabelFigure;

        /** The figure composite structure internals. @generated */
        private RectangleFigure fFigureCompositeStructureInternals;

        /**
         * Instantiates a new composite structure figure.
         * 
         * @generated
         */
        public CompositeStructureFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(1);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(500), getMapMode().DPtoLP(500)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            this.setLocation(new Point(getMapMode().DPtoLP(60), getMapMode().DPtoLP(60)));
            createContents();
        }

        /**
         * Creates the contents.
         * 
         * @generated
         */
        private void createContents() {

            WrappingLabel compositeStructureStereotypeLabelFigure0 = new WrappingLabel();
            compositeStructureStereotypeLabelFigure0.setText("<<CompositeStructure>>");
            compositeStructureStereotypeLabelFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintCompositeStructureStereotypeLabelFigure0 = new GridData();
            constraintCompositeStructureStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
            constraintCompositeStructureStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
            constraintCompositeStructureStereotypeLabelFigure0.horizontalIndent = 0;
            constraintCompositeStructureStereotypeLabelFigure0.horizontalSpan = 1;
            constraintCompositeStructureStereotypeLabelFigure0.verticalSpan = 1;
            constraintCompositeStructureStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
            constraintCompositeStructureStereotypeLabelFigure0.grabExcessVerticalSpace = false;
            this.add(compositeStructureStereotypeLabelFigure0, constraintCompositeStructureStereotypeLabelFigure0);

            fFigureCompositeStructureNameLabelFigure = new WrappingLabel();
            fFigureCompositeStructureNameLabelFigure.setText("<myComposite>");
            fFigureCompositeStructureNameLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureCompositeStructureNameLabelFigure = new GridData();
            constraintFFigureCompositeStructureNameLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureCompositeStructureNameLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureCompositeStructureNameLabelFigure.horizontalIndent = 0;
            constraintFFigureCompositeStructureNameLabelFigure.horizontalSpan = 1;
            constraintFFigureCompositeStructureNameLabelFigure.verticalSpan = 1;
            constraintFFigureCompositeStructureNameLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureCompositeStructureNameLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureCompositeStructureNameLabelFigure, constraintFFigureCompositeStructureNameLabelFigure);

            fFigureCompositeStructureInternals = new RectangleFigure();
            fFigureCompositeStructureInternals.setFill(false);
            fFigureCompositeStructureInternals.setOutline(false);
            fFigureCompositeStructureInternals.setLineWidth(1);
            fFigureCompositeStructureInternals.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(0)));

            GridData constraintFFigureCompositeStructureInternals = new GridData();
            constraintFFigureCompositeStructureInternals.verticalAlignment = GridData.FILL;
            constraintFFigureCompositeStructureInternals.horizontalAlignment = GridData.FILL;
            constraintFFigureCompositeStructureInternals.horizontalIndent = 0;
            constraintFFigureCompositeStructureInternals.horizontalSpan = 1;
            constraintFFigureCompositeStructureInternals.verticalSpan = 1;
            constraintFFigureCompositeStructureInternals.grabExcessHorizontalSpace = true;
            constraintFFigureCompositeStructureInternals.grabExcessVerticalSpace = true;
            this.add(fFigureCompositeStructureInternals, constraintFFigureCompositeStructureInternals);

        }

        /**
         * Gets the figure composite structure name label figure.
         * 
         * @return the figure composite structure name label figure
         * @generated
         */
        public WrappingLabel getFigureCompositeStructureNameLabelFigure() {
            return fFigureCompositeStructureNameLabelFigure;
        }

        /**
         * Gets the figure composite structure internals.
         * 
         * @return the figure composite structure internals
         * @generated
         */
        public RectangleFigure getFigureCompositeStructureInternals() {
            return fFigureCompositeStructureInternals;
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
         * @param useLocalCoordinates
         *            the new use local coordinates
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

    }

}
