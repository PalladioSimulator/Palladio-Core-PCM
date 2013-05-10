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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntity2CanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntity2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntity2EditPart extends AbstractBorderedShapeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2002;

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
    public ComposedProvidingRequiringEntity2EditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ComposedProvidingRequiringEntity2ItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ComposedProvidingRequiringEntity2CanonicalEditPolicy());
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
     * @generated
     */
    protected IFigure createNodeShape() {
        return primaryShape = new CompositeStructureFigure();
    }

    /**
     * @generated
     */
    public CompositeStructureFigure getPrimaryShape() {
        return (CompositeStructureFigure) primaryShape;
    }

    /**
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
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
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
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ComposedProvidingRequiringEntityEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureCompositeStructureInternals();
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
        if (editPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            return getPrimaryShape().getFigureCompositeStructureInternals();
        }
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
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
                .getType(ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class CompositeStructureFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureCompositeStructureNameLabelFigure;
        /**
         * @generated
         */
        private RectangleFigure fFigureCompositeStructureInternals;

        /**
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

            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(500), getMapMode().DPtoLP(500)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            this.setLocation(new Point(getMapMode().DPtoLP(60), getMapMode().DPtoLP(60)));
            createContents();
        }

        /**
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
         * @generated
         */
        public WrappingLabel getFigureCompositeStructureNameLabelFigure() {
            return fFigureCompositeStructureNameLabelFigure;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureCompositeStructureInternals() {
            return fFigureCompositeStructureInternals;
        }

    }

}
