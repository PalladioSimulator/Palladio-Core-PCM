/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsage4CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class EmitEventActionInputVariableUsageEvent2ItemSemanticEditPolicy.
 *
 * @generated
 */
public class EmitEventActionInputVariableUsageEvent2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new emit event action input variable usage event2 item semantic edit policy.
     *
     * @generated
     */
    public EmitEventActionInputVariableUsageEvent2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.EmitEventAction_3046);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3047 == req.getElementType()) {
            return getGEFWrapper(new VariableUsage4CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
