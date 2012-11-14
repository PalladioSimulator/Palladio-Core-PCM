/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InfrastructureCallCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy.
 *
 * @generated
 */
public class InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new internal action infrastructure calls compartment2 item semantic edit policy.
     *
     * @generated
     */
    public InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InternalAction_2006);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.InfrastructureCall_3053 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureCallCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
