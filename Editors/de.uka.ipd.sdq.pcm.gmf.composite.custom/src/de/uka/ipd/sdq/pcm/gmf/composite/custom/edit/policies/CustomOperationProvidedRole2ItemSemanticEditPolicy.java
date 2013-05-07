/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationProvidedRole2ItemSemanticEditPolicy;

/**
 * The Class CustomOperationProvidedRole2ItemSemanticEditPolicy.
 */
public class CustomOperationProvidedRole2ItemSemanticEditPolicy extends OperationProvidedRole2ItemSemanticEditPolicy {
    /**
     * Gets the complete create relationship command.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
        // if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req
        // .getElementType()) {
        // return getGEFWrapper(new AssemblyConnectorCreateCommand(req, req
        // .getSource(), req.getTarget()));
        // }
        // if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req
        // .getElementType()) {
        // return getGEFWrapper(new ProvidedDelegationConnectorCreateCommand(
        // req, req.getSource(), req.getTarget()));
        // }
        // return null;
    }

    /**
     * Gets the reorient relationship command.
     * 
     * @param req
     *            the req
     * @return the reorient relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationProvidedRole2ItemSemanticEditPolicy#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
     */
    @Override
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new CustomAssemblyConnectorReorientCommand(req));
        case ProvidedDelegationConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new ProvidedDelegationConnectorReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }
}
