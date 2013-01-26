/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class
 * ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy.
 * 
 * @generated
 */
public class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new composed providing requiring entity composite structure inner compartment
     * item semantic edit policy.
     * 
     * @generated
     */
    public ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002);
    }

    /**
     * Gets the creates the command.
     * 
     * @param req
     *            the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyContext_3006 == req.getElementType()) {
            return getGEFWrapper(new AssemblyContextCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EventChannel_3017 == req.getElementType()) {
            return getGEFWrapper(new EventChannelCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
