/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.PassiveResourceCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BasicComponentPassiveResourceCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public BasicComponentPassiveResourceCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.BasicComponent_2102);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.PassiveResource_3103 == req.getElementType()) {
            return getGEFWrapper(new PassiveResourceCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
