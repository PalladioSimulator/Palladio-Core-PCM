/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryActionBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class RecoveryActionRecoveryBlockCompartmentItemSemanticEditPolicy.
 *
 * @generated
 */
public class RecoveryActionRecoveryBlockCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new recovery action recovery block compartment item semantic edit policy.
     *
     * @generated
     */
    public RecoveryActionRecoveryBlockCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.RecoveryAction_3057);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058 == req.getElementType()) {
            return getGEFWrapper(new RecoveryActionBehaviourCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}