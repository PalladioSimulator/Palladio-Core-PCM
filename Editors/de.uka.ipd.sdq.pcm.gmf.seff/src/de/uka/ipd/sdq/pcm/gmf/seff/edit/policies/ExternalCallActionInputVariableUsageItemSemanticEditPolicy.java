/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsageCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class ExternalCallActionInputVariableUsageItemSemanticEditPolicy.
 *
 * @generated
 */
public class ExternalCallActionInputVariableUsageItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new external call action input variable usage item semantic edit policy.
     *
     * @generated
     */
    public ExternalCallActionInputVariableUsageItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ExternalCallAction_2003);
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
