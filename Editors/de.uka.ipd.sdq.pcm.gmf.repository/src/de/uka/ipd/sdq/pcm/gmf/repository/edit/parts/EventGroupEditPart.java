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
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.EventGroupItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class EventGroupEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2108;

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
    public EventGroupEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EventGroupItemSemanticEditPolicy());
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
        return primaryShape = new EventGroupFigure();
    }

    /**
     * @generated
     */
    public EventGroupFigure getPrimaryShape() {
        return (EventGroupFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof EventGroupEntityNameEditPart) {
            ((EventGroupEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureEventGroup_Name_LabelFigure());
            return true;
        }
        if (childEditPart instanceof EventGroupEventTypeListEditPart) {
            IFigure pane = getPrimaryShape().getFigureEventGroupCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((EventGroupEventTypeListEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof EventGroupEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof EventGroupEventTypeListEditPart) {
            IFigure pane = getPrimaryShape().getFigureEventGroupCompartment();
            pane.remove(((EventGroupEventTypeListEditPart) childEditPart).getFigure());
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
        if (editPart instanceof EventGroupEventTypeListEditPart) {
            return getPrimaryShape().getFigureEventGroupCompartment();
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
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     * 
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
                .getType(EventGroupEntityNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (targetEditPart instanceof OperationInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEditPart) {
            types.add(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
        }
        if (targetEditPart instanceof InfrastructureInterfaceEditPart) {
            types.add(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113) {
            types.add(PalladioComponentModelElementTypes.OperationInterface_2107);
            types.add(PalladioComponentModelElementTypes.EventGroup_2108);
            types.add(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(3);
        types.add(PalladioComponentModelElementTypes.SinkRole_4109);
        types.add(PalladioComponentModelElementTypes.SourceRole_4110);
        types.add(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.SinkRole_4109) {
            types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
            types.add(PalladioComponentModelElementTypes.CompositeComponent_2103);
            types.add(PalladioComponentModelElementTypes.CompleteComponentType_2104);
            types.add(PalladioComponentModelElementTypes.ProvidesComponentType_2105);
            types.add(PalladioComponentModelElementTypes.SubSystem_2106);
        } else if (relationshipType == PalladioComponentModelElementTypes.SourceRole_4110) {
            types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
            types.add(PalladioComponentModelElementTypes.CompositeComponent_2103);
            types.add(PalladioComponentModelElementTypes.CompleteComponentType_2104);
            types.add(PalladioComponentModelElementTypes.ProvidesComponentType_2105);
            types.add(PalladioComponentModelElementTypes.SubSystem_2106);
        } else if (relationshipType == PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113) {
            types.add(PalladioComponentModelElementTypes.OperationInterface_2107);
            types.add(PalladioComponentModelElementTypes.EventGroup_2108);
            types.add(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
        }
        return types;
    }

    /**
     * @generated
     */
    public EditPart getTargetEditPart(Request request) {
        if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
                    .getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == PalladioComponentModelElementTypes.EventType_3107) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(EventGroupEventTypeListEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * @generated
     */
    public class EventGroupFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureEventGroup_Name_LabelFigure;
        /**
         * @generated
         */
        private RectangleFigure fFigureEventGroupCompartment;

        /**
         * @generated
         */
        public EventGroupFigure() {

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

            fFigureEventGroup_Name_LabelFigure = new WrappingLabel();

            fFigureEventGroup_Name_LabelFigure.setText("<...>");
            fFigureEventGroup_Name_LabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureEventGroup_Name_LabelFigure = new GridData();
            constraintFFigureEventGroup_Name_LabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureEventGroup_Name_LabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureEventGroup_Name_LabelFigure.horizontalIndent = 0;
            constraintFFigureEventGroup_Name_LabelFigure.horizontalSpan = 1;
            constraintFFigureEventGroup_Name_LabelFigure.verticalSpan = 1;
            constraintFFigureEventGroup_Name_LabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureEventGroup_Name_LabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureEventGroup_Name_LabelFigure, constraintFFigureEventGroup_Name_LabelFigure);

            fFigureEventGroupCompartment = new RectangleFigure();

            fFigureEventGroupCompartment.setFill(false);
            fFigureEventGroupCompartment.setOutline(false);
            fFigureEventGroupCompartment.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

            this.add(fFigureEventGroupCompartment);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureEventGroup_Name_LabelFigure() {
            return fFigureEventGroup_Name_LabelFigure;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureEventGroupCompartment() {
            return fFigureEventGroupCompartment;
        }

    }

}
