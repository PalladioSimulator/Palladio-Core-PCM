/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.ProvidesComponentTypeItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ProvidesComponentTypeEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2105;

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
    public ProvidesComponentTypeEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProvidesComponentTypeItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
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
        return primaryShape = new ProvidesComponentTypeFigure();
    }

    /**
     * @generated
     */
    public ProvidesComponentTypeFigure getPrimaryShape() {
        return (ProvidesComponentTypeFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ProvidesComponentTypeEntityNameEditPart) {
            ((ProvidesComponentTypeEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureProvidesComponentTypeLabelFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ProvidesComponentTypeEntityNameEditPart) {
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
                .getType(ProvidesComponentTypeEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(6);
        types.add(PalladioComponentModelElementTypes.OperationProvidedRole_4105);
        types.add(PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111);
        types.add(PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112);
        types.add(PalladioComponentModelElementTypes.SinkRole_4109);
        types.add(PalladioComponentModelElementTypes.OperationRequiredRole_4106);
        types.add(PalladioComponentModelElementTypes.SourceRole_4110);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (targetEditPart instanceof OperationInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_4105);
        }
        if (targetEditPart instanceof InfrastructureInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111);
        }
        if (targetEditPart instanceof InfrastructureInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112);
        }
        if (targetEditPart instanceof EventGroupEditPart) {
            types.add(PalladioComponentModelElementTypes.SinkRole_4109);
        }
        if (targetEditPart instanceof OperationInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.OperationRequiredRole_4106);
        }
        if (targetEditPart instanceof EventGroupEditPart) {
            types.add(PalladioComponentModelElementTypes.SourceRole_4110);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.OperationProvidedRole_4105) {
            types.add(PalladioComponentModelElementTypes.OperationInterface_2107);
        } else if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
            types.add(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
        } else if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
            types.add(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
        } else if (relationshipType == PalladioComponentModelElementTypes.SinkRole_4109) {
            types.add(PalladioComponentModelElementTypes.EventGroup_2108);
        } else if (relationshipType == PalladioComponentModelElementTypes.OperationRequiredRole_4106) {
            types.add(PalladioComponentModelElementTypes.OperationInterface_2107);
        } else if (relationshipType == PalladioComponentModelElementTypes.SourceRole_4110) {
            types.add(PalladioComponentModelElementTypes.EventGroup_2108);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104) {
            types.add(PalladioComponentModelElementTypes.CompleteComponentType_2104);
        }
        return types;
    }

    /**
     * @generated
     */
    public class ProvidesComponentTypeFigure extends RectangleFigure {
        /**
         * @generated
         */
        private WrappingLabel fFigureProvidesComponentTypeLabelFigure;

        /**
         * @generated
         */
        public ProvidesComponentTypeFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureProvidesComponentTypeLabelFigure = new WrappingLabel();

            fFigureProvidesComponentTypeLabelFigure.setText("<...>");
            fFigureProvidesComponentTypeLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureProvidesComponentTypeLabelFigure = new GridData();
            constraintFFigureProvidesComponentTypeLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureProvidesComponentTypeLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureProvidesComponentTypeLabelFigure.horizontalIndent = 0;
            constraintFFigureProvidesComponentTypeLabelFigure.horizontalSpan = 1;
            constraintFFigureProvidesComponentTypeLabelFigure.verticalSpan = 1;
            constraintFFigureProvidesComponentTypeLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureProvidesComponentTypeLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureProvidesComponentTypeLabelFigure, constraintFFigureProvidesComponentTypeLabelFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureProvidesComponentTypeLabelFigure() {
            return fFigureProvidesComponentTypeLabelFigure;
        }

    }

}
