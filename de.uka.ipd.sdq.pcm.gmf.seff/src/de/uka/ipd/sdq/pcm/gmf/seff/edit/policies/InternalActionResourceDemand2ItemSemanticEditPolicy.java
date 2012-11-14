/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ParametricResourceDemandCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class InternalActionResourceDemand2ItemSemanticEditPolicy.
 *
 * @generated
 */
public class InternalActionResourceDemand2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new internal action resource demand2 item semantic edit policy.
     *
     * @generated
     */
    public InternalActionResourceDemand2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InternalAction_2006);
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
