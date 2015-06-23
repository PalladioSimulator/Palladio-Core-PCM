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
 * @generated
 */
public class SynchronisationPointEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3038;

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
    public SynchronisationPointEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SynchronisationPointItemSemanticEditPolicy());
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
        return primaryShape = new SynchronisationPointFigure();
    }

    /**
     * @generated
     */
    public SynchronisationPointFigure getPrimaryShape() {
        return (SynchronisationPointFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            IFigure pane = getPrimaryShape().getFigureSynchronisationPointCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((SynchronisationPointSynchronisationPointEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            IFigure pane = getPrimaryShape().getFigureSynchronisationPointCompartment();
            pane.remove(((SynchronisationPointSynchronisationPointEditPart) childEditPart).getFigure());
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
        if (editPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            return getPrimaryShape().getFigureSynchronisationPointCompartment();
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
    public class SynchronisationPointFigure extends RectangleFigure {

        /**
         * @generated
         */
        private RectangleFigure fFigureSynchronisationPointCompartment;

        /**
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

        /**
         * @generated
         */
        public RectangleFigure getFigureSynchronisationPointCompartment() {
            return fFigureSynchronisationPointCompartment;
        }

    }

}
