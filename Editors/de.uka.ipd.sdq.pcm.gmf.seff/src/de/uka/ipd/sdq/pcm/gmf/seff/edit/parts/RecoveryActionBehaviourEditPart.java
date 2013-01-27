/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.ArrayList;
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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.RecoveryActionBehaviourItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RecoveryActionBehaviourEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3058;

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
    public RecoveryActionBehaviourEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RecoveryActionBehaviourItemSemanticEditPolicy());
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
        RecoveryActionBehaviourFigure figure = new RecoveryActionBehaviourFigure();
        return primaryShape = figure;
    }

    /**
     * @generated
     */
    public RecoveryActionBehaviourFigure getPrimaryShape() {
        return (RecoveryActionBehaviourFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof RecoveryActionBehaviourEntityNameEditPart) {
            ((RecoveryActionBehaviourEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureRecoveryActionBehaviourNameLabel());
            return true;
        }
        if (childEditPart instanceof RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureRecoveryActionBehaviourCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof RecoveryActionBehaviourEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureRecoveryActionBehaviourCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) childEditPart).getFigure());
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
        if (editPart instanceof RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) {
            return getPrimaryShape().getFigureRecoveryActionBehaviourCompartment();
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
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                .getType(RecoveryActionBehaviourEntityNameEditPart.VISUAL_ID));
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
        types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004);
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
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart) {
            types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004);
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
        if (relationshipType == PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004) {
            types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058);
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
        types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004);
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
        if (relationshipType == PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004) {
            types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058);
        }
        return types;
    }

    /**
     * @generated
     */
    public class RecoveryActionBehaviourFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureRecoveryActionBehaviourNameLabel;

        /**
         * @generated
         */
        private RectangleFigure fFigureRecoveryActionBehaviourCompartment;

        /**
         * @generated
         */
        public RecoveryActionBehaviourFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(1);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            WrappingLabel recoveryActionBehaviourStereotype0 = new WrappingLabel();
            recoveryActionBehaviourStereotype0.setText("<<RecoveryActionBehaviour>>");
            recoveryActionBehaviourStereotype0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintRecoveryActionBehaviourStereotype0 = new GridData();
            constraintRecoveryActionBehaviourStereotype0.verticalAlignment = GridData.CENTER;
            constraintRecoveryActionBehaviourStereotype0.horizontalAlignment = GridData.CENTER;
            constraintRecoveryActionBehaviourStereotype0.horizontalIndent = 0;
            constraintRecoveryActionBehaviourStereotype0.horizontalSpan = 1;
            constraintRecoveryActionBehaviourStereotype0.verticalSpan = 1;
            constraintRecoveryActionBehaviourStereotype0.grabExcessHorizontalSpace = false;
            constraintRecoveryActionBehaviourStereotype0.grabExcessVerticalSpace = false;
            this.add(recoveryActionBehaviourStereotype0, constraintRecoveryActionBehaviourStereotype0);

            fFigureRecoveryActionBehaviourNameLabel = new WrappingLabel();
            fFigureRecoveryActionBehaviourNameLabel.setText("");
            fFigureRecoveryActionBehaviourNameLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureRecoveryActionBehaviourNameLabel = new GridData();
            constraintFFigureRecoveryActionBehaviourNameLabel.verticalAlignment = GridData.CENTER;
            constraintFFigureRecoveryActionBehaviourNameLabel.horizontalAlignment = GridData.CENTER;
            constraintFFigureRecoveryActionBehaviourNameLabel.horizontalIndent = 0;
            constraintFFigureRecoveryActionBehaviourNameLabel.horizontalSpan = 1;
            constraintFFigureRecoveryActionBehaviourNameLabel.verticalSpan = 1;
            constraintFFigureRecoveryActionBehaviourNameLabel.grabExcessHorizontalSpace = false;
            constraintFFigureRecoveryActionBehaviourNameLabel.grabExcessVerticalSpace = false;
            this.add(fFigureRecoveryActionBehaviourNameLabel, constraintFFigureRecoveryActionBehaviourNameLabel);

            fFigureRecoveryActionBehaviourCompartment = new RectangleFigure();
            fFigureRecoveryActionBehaviourCompartment.setFill(false);
            fFigureRecoveryActionBehaviourCompartment.setOutline(false);
            fFigureRecoveryActionBehaviourCompartment.setLineWidth(1);
            fFigureRecoveryActionBehaviourCompartment.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(0)));

            GridData constraintFFigureRecoveryActionBehaviourCompartment = new GridData();
            constraintFFigureRecoveryActionBehaviourCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureRecoveryActionBehaviourCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureRecoveryActionBehaviourCompartment.horizontalIndent = 0;
            constraintFFigureRecoveryActionBehaviourCompartment.horizontalSpan = 1;
            constraintFFigureRecoveryActionBehaviourCompartment.verticalSpan = 1;
            constraintFFigureRecoveryActionBehaviourCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureRecoveryActionBehaviourCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureRecoveryActionBehaviourCompartment, constraintFFigureRecoveryActionBehaviourCompartment);

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

        /**
         * @generated
         */
        public WrappingLabel getFigureRecoveryActionBehaviourNameLabel() {
            return fFigureRecoveryActionBehaviourNameLabel;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureRecoveryActionBehaviourCompartment() {
            return fFigureRecoveryActionBehaviourCompartment;
        }

    }

}
