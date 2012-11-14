/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkedBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.SynchronisationPointCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class ForkActionForkedBehavioursItemSemanticEditPolicy.
 *
 * @generated
 */
public class ForkActionForkedBehavioursItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new fork action forked behaviours item semantic edit policy.
     *
     * @generated
     */
    public ForkActionForkedBehavioursItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ForkAction_3023);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ForkedBehaviour_3027 == req.getElementType()) {
            return getGEFWrapper(new ForkedBehaviourCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.SynchronisationPoint_3038 == req.getElementType()) {
            return getGEFWrapper(new SynchronisationPointCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
