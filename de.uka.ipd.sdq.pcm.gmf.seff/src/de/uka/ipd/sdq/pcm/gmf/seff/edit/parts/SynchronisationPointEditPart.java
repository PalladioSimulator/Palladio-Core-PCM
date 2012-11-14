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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.SynchronisationPointItemSemanticEditPolicy;

/**
 * The Class SynchronisationPointEditPart.
 *
 * @generated
 */
public class SynchronisationPointEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3038;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new synchronisation point edit part.
     *
     * @param view the view
     * @generated
     */
    public SynchronisationPointEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SynchronisationPointItemSemanticEditPolicy());
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
        SynchronisationPointFigure figure = new SynchronisationPointFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public SynchronisationPointFigure getPrimaryShape() {
        return (SynchronisationPointFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            IFigure pane = getPrimaryShape().getFigureSynchronisationPointCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((SynchronisationPointSynchronisationPointEditPart) childEditPart).getFigure());
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
        if (childEditPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            IFigure pane = getPrimaryShape().getFigureSynchronisationPointCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((SynchronisationPointSynchronisationPointEditPart) childEditPart).getFigure());
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
        if (editPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            return getPrimaryShape().getFigureSynchronisationPointCompartment();
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
     * The Class SynchronisationPointFigure.
     *
     * @generated
     */
    public class SynchronisationPointFigure extends RectangleFigure {

        /** The figure synchronisation point compartment. @generated */
        private RectangleFigure fFigureSynchronisationPointCompartment;

        /**
         * Instantiates a new synchronisation point figure.
         *
         * @generated
         */
        public SynchronisationPointFigure() {

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

            WrappingLabel stereotypeLabelFigure0 = new WrappingLabel();
            stereotypeLabelFigure0.setText("<<Synchronisation Point>>");
            stereotypeLabelFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintStereotypeLabelFigure0 = new GridData();
            constraintStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
            constraintStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
            constraintStereotypeLabelFigure0.horizontalIndent = 0;
            constraintStereotypeLabelFigure0.horizontalSpan = 1;
            constraintStereotypeLabelFigure0.verticalSpan = 1;
            constraintStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
            constraintStereotypeLabelFigure0.grabExcessVerticalSpace = false;
            this.add(stereotypeLabelFigure0, constraintStereotypeLabelFigure0);

            fFigureSynchronisationPointCompartment = new RectangleFigure();
            fFigureSynchronisationPointCompartment.setFill(false);
            fFigureSynchronisationPointCompartment.setOutline(false);
            fFigureSynchronisationPointCompartment.setLineWidth(2);
            fFigureSynchronisationPointCompartment.setLineStyle(Graphics.LINE_DASH);
            fFigureSynchronisationPointCompartment.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(0)));

            GridData constraintFFigureSynchronisationPointCompartment = new GridData();
            constraintFFigureSynchronisationPointCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureSynchronisationPointCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureSynchronisationPointCompartment.horizontalIndent = 0;
            constraintFFigureSynchronisationPointCompartment.horizontalSpan = 1;
            constraintFFigureSynchronisationPointCompartment.verticalSpan = 1;
            constraintFFigureSynchronisationPointCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureSynchronisationPointCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureSynchronisationPointCompartment, constraintFFigureSynchronisationPointCompartment);

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
         * Gets the figure synchronisation point compartment.
         *
         * @return the figure synchronisation point compartment
         * @generated
         */
        public RectangleFigure getFigureSynchronisationPointCompartment() {
            return fFigureSynchronisationPointCompartment;
        }

    }

}
