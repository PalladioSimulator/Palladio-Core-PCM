/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableCharacterisation3CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class VariableUsageVariableCharacterisation4ItemSemanticEditPolicy.
 *
 * @generated
 */
public class VariableUsageVariableCharacterisation4ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new variable usage variable characterisation4 item semantic edit policy.
     *
     * @generated
     */
    public VariableUsageVariableCharacterisation4ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.VariableUsage_3047);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableCharacterisation_3037 == req.getElementType()) {
            return getGEFWrapper(new VariableCharacterisation3CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
