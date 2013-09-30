/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomRequiredDelegationConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.RequiredDelegationConnectorReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRole2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class CustomOperationRequiredRole2ItemSemanticEditPolicy.
 */
public class CustomOperationRequiredRole2ItemSemanticEditPolicy extends OperationRequiredRole2ItemSemanticEditPolicy {
    /**
     * Get the create relation ship start command.
     * 
     * This method has manually adopted to disallow any connectors to be started at the system
     * required role. AssemblyConnectors are not allowed anyway and delegation connectors should be
     * started at the inner operation required role.
     * 
     * @param req
     *            the req
     * @return the start create relationship command
     * @generated not
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * Gets the reorient relationship command.
     * 
     * @param req
     *            the req
     * @return the reorient relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRole2ItemSemanticEditPolicy#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case AssemblyConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new CustomAssemblyConnectorReorientCommand(req));
        case RequiredDelegationConnectorEditPart.VISUAL_ID:
            return getGEFWrapper(new RequiredDelegationConnectorReorientCommand(req));
        default:
            // unspecified
        }
        return super.getReorientRelationshipCommand(req);
    }

    /**
     * Gets the complete create relationship command.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRole2ItemSemanticEditPolicy#getCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return null;
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return getGEFWrapper(new CustomRequiredDelegationConnectorCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }
}
