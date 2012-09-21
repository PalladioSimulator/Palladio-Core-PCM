/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InterfaceParentInterfaces__InterfaceItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public InterfaceParentInterfaces__InterfaceItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InterfaceParentInterfaces__Interface_4113);
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return getGEFWrapper(new DestroyReferenceCommand(req));
    }

}
