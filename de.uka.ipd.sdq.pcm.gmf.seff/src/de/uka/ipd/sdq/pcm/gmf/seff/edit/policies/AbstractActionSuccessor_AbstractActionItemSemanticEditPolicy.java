/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class AbstractActionSuccessor_AbstractActionItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public AbstractActionSuccessor_AbstractActionItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return getGEFWrapper(new DestroyReferenceCommand(req));
    }
}
