/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.EventTypeCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class EventGroupEventTypeListItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public EventGroupEventTypeListItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.EventGroup_2108);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.EventType_3107 == req.getElementType()) {
            return getGEFWrapper(new EventTypeCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
