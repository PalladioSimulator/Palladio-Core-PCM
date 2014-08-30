/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import org.eclipse.draw2d.ColorConstants;
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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.OpenWorkloadItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class OpenWorkloadEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3016;

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
    public OpenWorkloadEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OpenWorkloadItemSemanticEditPolicy());
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
        return primaryShape = new OpenWorkloadFigure();
    }

    /**
     * @generated
     */
    public OpenWorkloadFigure getPrimaryShape() {
        return (OpenWorkloadFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof OpenWorkloadSpecLabelEditPart) {
            ((OpenWorkloadSpecLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureOpenWorkloadSpecLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof OpenWorkloadSpecLabelEditPart) {
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
                .getType(OpenWorkloadSpecLabelEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class OpenWorkloadFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureOpenWorkloadSpecLabelFigure;

        /**
         * @generated
         */
        public OpenWorkloadFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setBackgroundColor(ColorConstants.yellow);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            WrappingLabel openWorkloadStereotypeLabelFigure0 = new WrappingLabel();

            openWorkloadStereotypeLabelFigure0.setText("<<Open Workload>>");
            openWorkloadStereotypeLabelFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintOpenWorkloadStereotypeLabelFigure0 = new GridData();
            constraintOpenWorkloadStereotypeLabelFigure0.verticalAlignment = GridData.BEGINNING;
            constraintOpenWorkloadStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
            constraintOpenWorkloadStereotypeLabelFigure0.horizontalIndent = 0;
            constraintOpenWorkloadStereotypeLabelFigure0.horizontalSpan = 1;
            constraintOpenWorkloadStereotypeLabelFigure0.verticalSpan = 1;
            constraintOpenWorkloadStereotypeLabelFigure0.grabExcessHorizontalSpace = true;
            constraintOpenWorkloadStereotypeLabelFigure0.grabExcessVerticalSpace = false;
            this.add(openWorkloadStereotypeLabelFigure0, constraintOpenWorkloadStereotypeLabelFigure0);

            fFigureOpenWorkloadSpecLabelFigure = new WrappingLabel();

            fFigureOpenWorkloadSpecLabelFigure.setText("<spec>");

            GridData constraintFFigureOpenWorkloadSpecLabelFigure = new GridData();
            constraintFFigureOpenWorkloadSpecLabelFigure.verticalAlignment = GridData.END;
            constraintFFigureOpenWorkloadSpecLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureOpenWorkloadSpecLabelFigure.horizontalIndent = 0;
            constraintFFigureOpenWorkloadSpecLabelFigure.horizontalSpan = 1;
            constraintFFigureOpenWorkloadSpecLabelFigure.verticalSpan = 1;
            constraintFFigureOpenWorkloadSpecLabelFigure.grabExcessHorizontalSpace = true;
            constraintFFigureOpenWorkloadSpecLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureOpenWorkloadSpecLabelFigure, constraintFFigureOpenWorkloadSpecLabelFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureOpenWorkloadSpecLabelFigure() {
            return fFigureOpenWorkloadSpecLabelFigure;
        }

    }

}
