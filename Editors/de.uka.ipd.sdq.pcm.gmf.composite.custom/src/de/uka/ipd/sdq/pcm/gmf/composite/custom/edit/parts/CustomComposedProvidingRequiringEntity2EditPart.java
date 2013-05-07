/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;

/**
 * The Class CustomComposedProvidingRequiringEntity2EditPart.
 */
public class CustomComposedProvidingRequiringEntity2EditPart extends ComposedProvidingRequiringEntity2EditPart {

    /**
     * Instantiates a new custom composed providing requiring entity2 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomComposedProvidingRequiringEntity2EditPart(View view) {
        super(view);
    }

    /**
     * Gets the content pane for.
     * 
     * @param editPart
     *            the edit part
     * @return the content pane for
     * @generated not
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

        // TODO: Proof necessity of instance of type check
        // We found out that "return editPart.getFigure().getParent();" is sufficient
        // for the InnerCompartment. It might be sufficient for the roles to.
        // This should be proven and instance of separation removed if possible
        // (benjamin klatt)

        if (editPart instanceof OperationProvidedRoleEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        if (editPart instanceof OperationRequiredRoleEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        if (editPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            // get the rectangle figure that should be resized
            return editPart.getFigure().getParent();
        }
        return super.getContentPaneFor(editPart);
    }

}
