/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SignatureCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InterfaceSignatureListItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceSignatureListItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.Interface_2101);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.Signature_3101 == req
				.getElementType()) {
			return getGEFWrapper(new SignatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
