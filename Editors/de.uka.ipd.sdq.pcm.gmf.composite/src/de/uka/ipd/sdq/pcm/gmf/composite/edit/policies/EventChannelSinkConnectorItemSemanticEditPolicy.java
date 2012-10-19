/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class EventChannelSinkConnectorItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EventChannelSinkConnectorItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.EventChannelSinkConnector_4010);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
