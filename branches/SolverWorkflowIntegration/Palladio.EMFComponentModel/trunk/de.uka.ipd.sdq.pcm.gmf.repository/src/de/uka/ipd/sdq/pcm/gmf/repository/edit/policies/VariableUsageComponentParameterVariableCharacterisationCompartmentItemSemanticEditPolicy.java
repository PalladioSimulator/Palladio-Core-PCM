/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.VariableCharacterisationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

/**
 * @generated
 */
public class VariableUsageComponentParameterVariableCharacterisationCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.VariableCharacterisation_3105 == req
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
