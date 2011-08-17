/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryBlockAlternativeBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RecoveryBlockActionRecoveryBlockCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RecoveryBlockActionRecoveryBlockCompartmentItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.RecoveryBlockAction_3056);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviour_3052 == req
				.getElementType()) {
			return getGEFWrapper(new RecoveryBlockAlternativeBehaviourCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
