/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies.CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;

/**
 * The Class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.
 */
public class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart extends
        ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart {

    /**
     * Instantiates a new custom composed providing requiring entity composite structure inner
     * compartment edit part.
     * 
     * @param view
     *            the view
     */
    public CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.
     * ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart
     * #createDefaultEditPolicies()
     */
    @Override
    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart#createDefaultEditPolicies()
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getCommand(org.eclipse.gef
     * .Request)
     */
    /**
     * This hack is just to omit the following exception when trying to resize an affixed side node
     * of the assembly contexts or the composite component: java.lang.ClassCastException:
     * org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator cannot be cast to
     * org.eclipse.draw2d.geometry.Rectangle.
     * 
     * @param request
     *            the request
     * @return the command
     */
    @Override
    public Command getCommand(Request request) {
        if (request instanceof ChangeBoundsRequest) {
            for (Object o : ((ChangeBoundsRequest) request).getEditParts()) {
                EditPart ep = (EditPart) o;
                if (ep instanceof OperationProvidedRoleEditPart || ep instanceof OperationRequiredRoleEditPart
                        || ep instanceof OperationProvidedRole2EditPart || ep instanceof OperationRequiredRole2EditPart
                        || ep instanceof InfrastructureProvidedRoleEditPart
                        || ep instanceof InfrastructureRequiredRoleEditPart || ep instanceof SinkRoleEditPart
                        || ep instanceof SourceRoleEditPart) {
                    return null;
                }
            }
        }
        return super.getCommand(request);
    }

}
