/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.BranchTransitionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BranchUsageBranchTransitionsCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public BranchUsageBranchTransitionsCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.Branch_3008);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.BranchTransition_3009 == req.getElementType()) {
            return getGEFWrapper(new BranchTransitionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
