/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsage5CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class InfrastructureCallInfrastructureCallInputVariableUsagesItemSemanticEditPolicy.
 *
 * @generated
 */
public class InfrastructureCallInfrastructureCallInputVariableUsagesItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new infrastructure call infrastructure call input variable usages item semantic edit policy.
     *
     * @generated
     */
    public InfrastructureCallInfrastructureCallInputVariableUsagesItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InfrastructureCall_3053);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3054 == req.getElementType()) {
            return getGEFWrapper(new VariableUsage5CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
