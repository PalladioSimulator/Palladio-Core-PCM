/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableCharacterisation2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class VariableUsageVariableCharacterisation2ItemSemanticEditPolicy.
 *
 * @generated
 */
public class VariableUsageVariableCharacterisation2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new variable usage variable characterisation2 item semantic edit policy.
     *
     * @generated
     */
    public VariableUsageVariableCharacterisation2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.VariableUsage_3049);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableCharacterisation_3035 == req.getElementType()) {
            return getGEFWrapper(new VariableCharacterisation2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
