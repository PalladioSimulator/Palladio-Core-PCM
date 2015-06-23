/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ResourceDemandingSEFFCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BasicComponentSEFFCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public BasicComponentSEFFCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.BasicComponent_2102);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102 == req.getElementType()) {
            return getGEFWrapper(new ResourceDemandingSEFFCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
