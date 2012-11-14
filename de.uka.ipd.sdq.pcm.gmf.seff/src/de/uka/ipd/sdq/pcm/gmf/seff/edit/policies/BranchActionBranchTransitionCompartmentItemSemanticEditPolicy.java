/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.GuardedBranchTransitionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ProbabilisticBranchTransitionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class BranchActionBranchTransitionCompartmentItemSemanticEditPolicy.
 *
 * @generated
 */
public class BranchActionBranchTransitionCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new branch action branch transition compartment item semantic edit policy.
     *
     * @generated
     */
    public BranchActionBranchTransitionCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.BranchAction_3009);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010 == req.getElementType()) {
            return getGEFWrapper(new ProbabilisticBranchTransitionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.GuardedBranchTransition_3017 == req.getElementType()) {
            return getGEFWrapper(new GuardedBranchTransitionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
