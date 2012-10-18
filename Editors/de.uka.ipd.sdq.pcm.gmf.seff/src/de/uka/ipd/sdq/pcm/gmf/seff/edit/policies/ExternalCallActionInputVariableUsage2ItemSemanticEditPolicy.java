/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsageCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class ExternalCallActionInputVariableUsage2ItemSemanticEditPolicy.
 *
 * @generated
 */
public class ExternalCallActionInputVariableUsage2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new external call action input variable usage2 item semantic edit policy.
     *
     * @generated
     */
    public ExternalCallActionInputVariableUsage2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ExternalCallAction_3012);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3042 == req.getElementType()) {
            return getGEFWrapper(new VariableUsageCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
