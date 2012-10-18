/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class ProvidedDelegationConnectorItemSemanticEditPolicy.
 *
 * @generated
 */
public class ProvidedDelegationConnectorItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new provided delegation connector item semantic edit policy.
	 *
	 * @generated
	 */
	public ProvidedDelegationConnectorItemSemanticEditPolicy() {
		super(
				PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
	}

	/**
	 * Gets the destroy element command.
	 *
	 * @param req the req
	 * @return the destroy element command
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
