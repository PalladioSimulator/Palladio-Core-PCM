/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.FailureOccurrenceDescriptionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InternalActionFailureOccurrences2ItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InternalActionFailureOccurrences2ItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.InternalAction_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.FailureOccurrenceDescription_3041 == req.getElementType()) {
			return getGEFWrapper(new FailureOccurrenceDescriptionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
