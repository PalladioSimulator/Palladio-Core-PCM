/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.VariableUsageCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class EntryLevelSystemCallParameterUsageItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public EntryLevelSystemCallParameterUsageItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableUsage_3012 == req.getElementType()) {
            return getGEFWrapper(new VariableUsageCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
