/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.commands.ResourceContainer2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ResourceContainerResourceContainerCompartment2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ResourceContainerResourceContainerCompartment2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ResourceContainer_2004);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ResourceContainer_3005 == req.getElementType()) {
            return getGEFWrapper(new ResourceContainer2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
