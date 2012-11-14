/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.VariableCharacterisationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class VariableUsageVariableCharacterisationItemSemanticEditPolicy.
 *
 * @generated
 */
public class VariableUsageVariableCharacterisationItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new variable usage variable characterisation item semantic edit policy.
     *
     * @generated
     */
    public VariableUsageVariableCharacterisationItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.VariableUsage_3012);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableCharacterisation_3013 == req.getElementType()) {
            return getGEFWrapper(new VariableCharacterisationCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
