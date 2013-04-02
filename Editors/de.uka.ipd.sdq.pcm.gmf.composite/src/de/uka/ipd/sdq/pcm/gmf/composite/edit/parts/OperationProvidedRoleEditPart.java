/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationProvidedRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class OperationProvidedRoleEditPart extends BorderedBorderItemEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3007;

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
    public OperationProvidedRoleEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OperationProvidedRoleItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        LayoutEditPolicy lep = new LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (PalladioComponentModelVisualIDRegistry.getVisualID(childView)) {
                case OperationProvidedRoleEntityNameEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy() {

                        protected List createSelectionHandles() {
                            MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
                            mh.setBorder(null);
                            return Collections.singletonList(mh);
                        }
                    };
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
        OperationProvidedRoleFigure figure = new OperationProvidedRoleFigure();
        return primaryShape = figure;
    }

    /**
     * @generated
     */
    public OperationProvidedRoleFigure getPrimaryShape() {
        return (OperationProvidedRoleFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
        if (borderItemEditPart instanceof OperationProvidedRoleEntityNameEditPart) {
            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
            locator.setBorderItemOffset(new Dimension(-20, -20));
            borderItemContainer.add(borderItemEditPart.getFigure(), locator);
        } else {
            super.addBorderItem(borderItemContainer, borderItemEditPart);
        }
    }

    /**
     * @generated
     */
    public EditPolicy getPrimaryDragEditPolicy() {
        EditPolicy result = super.getPrimaryDragEditPolicy();
        if (result instanceof ResizableEditPolicy) {
            ResizableEditPolicy ep = (ResizableEditPolicy) result;
            ep.setResizeDirections(PositionConstants.NONE);
        }
        return result;
    }

    /**
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
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
                .getType(OperationProvidedRoleEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
            IGraphicalEditPart targetEditPart) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart) {
            types.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
        }
        if (targetEditPart instanceof OperationProvidedRole2EditPart) {
            types.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
        }
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006) {
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006) {
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
        }
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.AssemblyConnector_4004);
        types.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4004) {
            types.add(PalladioComponentModelElementTypes.OperationRequiredRole_3008);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4004) {
            types.add(PalladioComponentModelElementTypes.OperationRequiredRole_3012);
        }
        if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006) {
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006) {
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
        }
        return types;
    }

    /**
     * @generated
     */
    public class OperationProvidedRoleFigure extends RectangleFigure {

        /**
         * @generated
         */
        public OperationProvidedRoleFigure() {
            this.setLineWidth(1);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            this.setLocation(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40)));
        }

        /**
         * @generated
         */
        private boolean myUseLocalCoordinates = false;

        /**
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

    }

    /**
     * @generated
     */
	@Override
	protected NodeFigure createMainFigure() {
		// FIXME: regenerate
		return null;
	}

}
