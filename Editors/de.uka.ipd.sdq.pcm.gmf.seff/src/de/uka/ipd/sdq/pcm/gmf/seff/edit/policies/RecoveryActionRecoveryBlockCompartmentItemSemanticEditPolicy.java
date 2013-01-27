/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryActionBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RecoveryActionRecoveryBlockCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public RecoveryActionRecoveryBlockCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.RecoveryAction_3057);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058 == req.getElementType()) {
            return getGEFWrapper(new RecoveryActionBehaviourCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
