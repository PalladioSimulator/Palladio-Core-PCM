/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class AbstractUserActionSuccessorItemSemanticEditPolicy.
 *
 * @generated
 */
public class AbstractUserActionSuccessorItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new abstract user action successor item semantic edit policy.
     *
     * @generated
     */
    public AbstractUserActionSuccessorItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
    }

    /**
     * Gets the destroy reference command.
     *
     * @param req the req
     * @return the destroy reference command
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return getGEFWrapper(new DestroyReferenceCommand(req));
    }
}
