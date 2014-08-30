/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ParametricResourceDemandCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InternalActionResourceDemandItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public InternalActionResourceDemandItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InternalAction_3007);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ParametricResourceDemand_3051 == req.getElementType()) {
            return getGEFWrapper(new ParametricResourceDemandCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
