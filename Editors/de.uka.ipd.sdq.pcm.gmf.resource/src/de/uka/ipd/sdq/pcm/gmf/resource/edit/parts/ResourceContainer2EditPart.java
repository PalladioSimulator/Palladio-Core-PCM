/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
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
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
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

import de.uka.ipd.sdq.pcm.gmf.resource.edit.policies.ResourceContainer2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ResourceContainer2EditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3005;

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
    public ResourceContainer2EditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ResourceContainer2ItemSemanticEditPolicy());
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
        return primaryShape = new ResourceContainerFigure();
    }

    /**
     * @generated
     */
    public ResourceContainerFigure getPrimaryShape() {
        return (ResourceContainerFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ResourceContainerEntityName2EditPart) {
            ((ResourceContainerEntityName2EditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureResourceContainerNameFigure());
            return true;
        }
        if (childEditPart instanceof ResourceContainerProcessingResourceCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureResourceContainerCompartmentFigure();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((ResourceContainerProcessingResourceCompartmentEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof ResourceContainerResourceContainerCompartment3EditPart) {
            IFigure pane = getPrimaryShape().getFigureResourceContainerCompartmentFigure();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
            pane.add(((ResourceContainerResourceContainerCompartment3EditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof ResourceContainerEntityName2EditPart) {
            return true;
        }
        if (childEditPart instanceof ResourceContainerProcessingResourceCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureResourceContainerCompartmentFigure();
            pane.remove(((ResourceContainerProcessingResourceCompartmentEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof ResourceContainerResourceContainerCompartment3EditPart) {
            IFigure pane = getPrimaryShape().getFigureResourceContainerCompartmentFigure();
            pane.remove(((ResourceContainerResourceContainerCompartment3EditPart) childEditPart).getFigure());
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
        if (editPart instanceof ResourceContainerProcessingResourceCompartmentEditPart) {
            return getPrimaryShape().getFigureResourceContainerCompartmentFigure();
        }
        if (editPart instanceof ResourceContainerResourceContainerCompartment3EditPart) {
            return getPrimaryShape().getFigureResourceContainerCompartmentFigure();
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
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
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
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * @param nodeShape instance of generated figure class
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
                .getType(ResourceContainerEntityName2EditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4003);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4003) {
            types.add(PalladioComponentModelElementTypes.LinkingResource_2005);
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
            if (type == PalladioComponentModelElementTypes.ProcessingResourceSpecification_3003) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(ResourceContainerProcessingResourceCompartmentEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * @generated
     */
    public class ResourceContainerFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureResourceContainerNameFigure;
        /**
         * @generated
         */
        private RectangleFigure fFigureResourceContainerCompartmentFigure;

        /**
         * @generated
         */
        public ResourceContainerFigure() {
            this.setLayoutManager(new StackLayout());
            this.setFill(false);
            this.setOutline(false);
            this.setLineWidth(0);
            this.setMaximumSize(new Dimension(getMapMode().DPtoLP(250), getMapMode().DPtoLP(-1)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(250), getMapMode().DPtoLP(250)));

            this.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            ScalablePolygonShape polyline0 = new ScalablePolygonShape();

            polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(1)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode().DPtoLP(0)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(0)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(40)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode().DPtoLP(41)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(41)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(1)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode().DPtoLP(1)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(0)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode().DPtoLP(1)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode().DPtoLP(41)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(40)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode().DPtoLP(41)));
            polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(41)));
            polyline0.setFill(true);

            this.add(polyline0);
            polyline0.setLayoutManager(new StackLayout());

            RectangleFigure rect0 = new RectangleFigure();

            rect0.setFill(false);
            rect0.setOutline(false);

            rect0.setBorder(new MarginBorder(getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(0)));

            this.add(rect0);

            GridLayout layoutRect0 = new GridLayout();
            layoutRect0.numColumns = 1;
            layoutRect0.makeColumnsEqualWidth = true;
            layoutRect0.horizontalSpacing = 0;
            layoutRect0.verticalSpacing = 0;
            layoutRect0.marginWidth = 0;
            layoutRect0.marginHeight = 0;
            rect0.setLayoutManager(layoutRect0);

            fFigureResourceContainerNameFigure = new WrappingLabel();

            fFigureResourceContainerNameFigure.setText("ResourceContainer");

            rect0.add(fFigureResourceContainerNameFigure);

            fFigureResourceContainerCompartmentFigure = new RectangleFigure();

            fFigureResourceContainerCompartmentFigure.setFill(false);
            fFigureResourceContainerCompartmentFigure.setOutline(false);
            fFigureResourceContainerCompartmentFigure.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(0)));

            fFigureResourceContainerCompartmentFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(10), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(10), getMapMode().DPtoLP(14)));

            GridData constraintFFigureResourceContainerCompartmentFigure = new GridData();
            constraintFFigureResourceContainerCompartmentFigure.verticalAlignment = GridData.FILL;
            constraintFFigureResourceContainerCompartmentFigure.horizontalAlignment = GridData.FILL;
            constraintFFigureResourceContainerCompartmentFigure.horizontalIndent = 0;
            constraintFFigureResourceContainerCompartmentFigure.horizontalSpan = 1;
            constraintFFigureResourceContainerCompartmentFigure.verticalSpan = 1;
            constraintFFigureResourceContainerCompartmentFigure.grabExcessHorizontalSpace = true;
            constraintFFigureResourceContainerCompartmentFigure.grabExcessVerticalSpace = true;
            rect0.add(fFigureResourceContainerCompartmentFigure, constraintFFigureResourceContainerCompartmentFigure);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureResourceContainerNameFigure() {
            return fFigureResourceContainerNameFigure;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureResourceContainerCompartmentFigure() {
            return fFigureResourceContainerCompartmentFigure;
        }

    }

}
