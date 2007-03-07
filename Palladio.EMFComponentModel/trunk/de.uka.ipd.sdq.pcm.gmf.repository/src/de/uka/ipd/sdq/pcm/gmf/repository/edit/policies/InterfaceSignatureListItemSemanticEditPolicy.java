/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SignatureCreateCommand;

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class InterfaceSignatureListItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.Signature_3101 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getInterface_Signatures__Interface());
			}
			return getMSLWrapper(new SignatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
