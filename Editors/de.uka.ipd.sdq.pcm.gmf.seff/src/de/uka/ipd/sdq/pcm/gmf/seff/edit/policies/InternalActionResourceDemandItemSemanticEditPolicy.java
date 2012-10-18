/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ParametricResourceDemandCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class InternalActionResourceDemandItemSemanticEditPolicy.
 *
 * @generated
 */
public class InternalActionResourceDemandItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new internal action resource demand item semantic edit policy.
     *
     * @generated
     */
    public InternalActionResourceDemandItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InternalAction_3007);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ParametricResourceDemand_3051 == req.getElementType()) {
            return getGEFWrapper(new ParametricResourceDemandCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
