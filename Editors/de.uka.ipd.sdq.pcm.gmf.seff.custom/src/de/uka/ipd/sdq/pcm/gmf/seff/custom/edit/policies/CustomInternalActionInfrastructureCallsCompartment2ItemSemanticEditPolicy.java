/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.commands.CustomInfrastructureCallCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The customized internal action infrastructure calls compartment2 item semantic edit policy class.
 */
public class CustomInternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy extends
        InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy {

    /**
     * Instantiates a new customized internal action infrastructure calls compartment2 item semantic
     * edit policy.
     */
    public CustomInternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.
     * InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy
     * #getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
     */
    /**
     * Gets the creates the command.
     * 
     * @param req
     *            the req
     * @return the creates the command
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy#getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
     */
    @Override
    protected Command getCreateCommand(final CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.InfrastructureCall_3053 == req.getElementType()) {
            return this.getGEFWrapper(new CustomInfrastructureCallCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
