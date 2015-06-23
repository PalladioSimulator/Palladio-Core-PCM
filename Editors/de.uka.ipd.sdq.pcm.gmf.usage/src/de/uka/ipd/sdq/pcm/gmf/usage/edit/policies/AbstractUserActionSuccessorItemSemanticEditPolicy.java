/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class AbstractUserActionSuccessorItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public AbstractUserActionSuccessorItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return getGEFWrapper(new DestroyReferenceCommand(req));
    }
}
