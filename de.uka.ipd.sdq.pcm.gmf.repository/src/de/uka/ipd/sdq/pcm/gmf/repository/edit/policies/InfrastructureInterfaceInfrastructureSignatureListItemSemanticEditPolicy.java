/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureSignatureCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InfrastructureInterfaceInfrastructureSignatureListItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public InfrastructureInterfaceInfrastructureSignatureListItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InfrastructureInterface_2109);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.InfrastructureSignature_3108 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureSignatureCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
