/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationSignatureCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class OperationInterfaceSignatureListItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public OperationInterfaceSignatureListItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.OperationInterface_2107);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.OperationSignature_3106 == req.getElementType()) {
            return getGEFWrapper(new OperationSignatureCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
