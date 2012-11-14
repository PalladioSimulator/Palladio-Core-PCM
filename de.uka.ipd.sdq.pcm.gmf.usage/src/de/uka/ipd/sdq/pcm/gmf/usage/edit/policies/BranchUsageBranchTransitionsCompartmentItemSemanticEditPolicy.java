/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.BranchTransitionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class BranchUsageBranchTransitionsCompartmentItemSemanticEditPolicy.
 *
 * @generated
 */
public class BranchUsageBranchTransitionsCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new branch usage branch transitions compartment item semantic edit policy.
     *
     * @generated
     */
    public BranchUsageBranchTransitionsCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.Branch_3008);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.BranchTransition_3009 == req.getElementType()) {
            return getGEFWrapper(new BranchTransitionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
