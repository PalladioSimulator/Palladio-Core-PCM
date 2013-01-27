/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.commands.ProcessingResourceSpecificationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ResourceContainerResourceContainerCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ResourceContainerResourceContainerCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ResourceContainer_2004);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ProcessingResourceSpecification_3003 == req.getElementType()) {
            return getGEFWrapper(new ProcessingResourceSpecificationCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
