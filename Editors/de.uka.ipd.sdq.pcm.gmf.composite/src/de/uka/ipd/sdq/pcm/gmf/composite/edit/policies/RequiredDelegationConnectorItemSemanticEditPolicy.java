/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class RequiredDelegationConnectorItemSemanticEditPolicy.
 * 
 * @generated
 */
public class RequiredDelegationConnectorItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new required delegation connector item semantic edit policy.
     * 
     * @generated
     */
    public RequiredDelegationConnectorItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
    }

    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        return getGEFWrapper(new DestroyElementCommand(req));
    }

}
