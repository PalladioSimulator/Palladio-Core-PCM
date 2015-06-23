/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomEventChannelSinkConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomEventChannelSourceConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.EventChannelItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class CustomEventChannelItemSemanticEditPolicy.
 */
public class CustomEventChannelItemSemanticEditPolicy extends EventChannelItemSemanticEditPolicy {

    /**
     * Gets the complete create relationship command.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @see de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.EventChannelItemSemanticEditPolicy#getCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.EventChannelSinkConnector_4010 == req.getElementType()) {
            return getGEFWrapper(new /* EventChannelSinkConnectorCreateCommand */CustomEventChannelSinkConnectorCreateCommand(
                    req, req.getSource(), req.getTarget()));
        }
        if (PalladioComponentModelElementTypes.EventChannelSourceConnector_4009 == req.getElementType()) {
            return getGEFWrapper(new /* EventChannelSourceConnectorCreateCommand */CustomEventChannelSourceConnectorCreateCommand(
                    req, req.getSource(), req.getTarget()));
        }
        return null;
    }
}
