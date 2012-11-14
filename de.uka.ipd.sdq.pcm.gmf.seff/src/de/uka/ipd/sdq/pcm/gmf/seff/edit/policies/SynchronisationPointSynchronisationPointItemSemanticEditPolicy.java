/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkedBehaviour2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class SynchronisationPointSynchronisationPointItemSemanticEditPolicy.
 *
 * @generated
 */
public class SynchronisationPointSynchronisationPointItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new synchronisation point synchronisation point item semantic edit policy.
     *
     * @generated
     */
    public SynchronisationPointSynchronisationPointItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.SynchronisationPoint_3038);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ForkedBehaviour_3039 == req.getElementType()) {
            return getGEFWrapper(new ForkedBehaviour2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
