/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart extends
        ShapeCompartmentEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 7002;

    /**
     * @generated
     */
    public ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    public String getCompartmentName() {
        return Messages.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart_title;
    }

    /**
     * @generated
     */
    public IFigure createFigure() {
        ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
        result.setTitleVisibility(false);
        return result;
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
                PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy());
    }

    /**
     * @generated
     */
    protected void setRatio(Double ratio) {
        if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
            super.setRatio(ratio);
        }
    }

}
