/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableUsage2CreateCommand;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class SetVariableActionParameterUsageItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.VariableUsage_3015 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getSetVariableAction_VariableUsage_SetVariableAction());
			}
			return getMSLWrapper(new VariableUsage2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
