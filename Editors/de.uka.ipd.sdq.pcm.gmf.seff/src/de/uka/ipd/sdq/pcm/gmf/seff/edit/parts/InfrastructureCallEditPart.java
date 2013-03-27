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
 * @generated
 */
public class InfrastructureCallEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3053;

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
    public InfrastructureCallEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InfrastructureCallItemSemanticEditPolicy());
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
        return primaryShape = new InfrastructureCallFigure();
    }

    /**
     * @generated
     */
    public InfrastructureCallFigure getPrimaryShape() {
        return (InfrastructureCallFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof WrappingLabel2EditPart) {
            ((WrappingLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureInfrastructureCallNumberOfCallsLabel());
            return true;
        }
        if (childEditPart instanceof WrappingLabel3EditPart) {
            ((WrappingLabel3EditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureInfrastructureCallTargetLabel());
            return true;
        }
        if (childEditPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            IFigure pane = getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof WrappingLabel2EditPart) {
            return true;
        }
        if (childEditPart instanceof WrappingLabel3EditPart) {
            return true;
        }
        if (childEditPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            IFigure pane = getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
            pane.remove(((InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) childEditPart).getFigure());
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
        if (editPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            return getPrimaryShape().getFigureInfrastructureCallVariableUsagesCompartment();
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
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class InfrastructureCallFigure extends RoundedRectangle {

        /**
         * @generated
         */
        private RectangleFigure fFigureInfrastructureCallVariableUsagesCompartment;

        /**
         * @generated
         */
        private WrappingLabel fFigureInfrastructureCallTargetLabel;

        /**
         * @generated
         */
        private WrappingLabel fFigureInfrastructureCallNumberOfCallsLabel;

        /**
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
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
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

        /**
         * @generated
         */
        public RectangleFigure getFigureInfrastructureCallVariableUsagesCompartment() {
            return fFigureInfrastructureCallVariableUsagesCompartment;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureInfrastructureCallTargetLabel() {
            return fFigureInfrastructureCallTargetLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureInfrastructureCallNumberOfCallsLabel() {
            return fFigureInfrastructureCallNumberOfCallsLabel;
        }

    }

}
