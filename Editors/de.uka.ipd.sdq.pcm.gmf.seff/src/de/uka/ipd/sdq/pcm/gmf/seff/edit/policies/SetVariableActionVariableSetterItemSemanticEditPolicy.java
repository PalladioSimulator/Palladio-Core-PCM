/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsage3CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class SetVariableActionVariableSetterItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public SetVariableActionVariableSetterItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.SetVariableAction_3024);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3036 == req.getElementType()) {
            return getGEFWrapper(new VariableUsage3CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
