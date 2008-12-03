/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.VariableCharacterisationCreateCommand;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VariableUsageVariableCharacterisationItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.VariableCharacterisation_3013 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(ParameterPackage.eINSTANCE
								.getVariableUsage_VariableCharacterisation_VariableUsage());
			}
			return getGEFWrapper(new VariableCharacterisationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
