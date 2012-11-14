/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsage3CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class SetVariableActionVariableSetterItemSemanticEditPolicy.
 *
 * @generated
 */
public class SetVariableActionVariableSetterItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new sets the variable action variable setter item semantic edit policy.
     *
     * @generated
     */
    public SetVariableActionVariableSetterItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.SetVariableAction_3024);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3036 == req.getElementType()) {
            return getGEFWrapper(new VariableUsage3CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
