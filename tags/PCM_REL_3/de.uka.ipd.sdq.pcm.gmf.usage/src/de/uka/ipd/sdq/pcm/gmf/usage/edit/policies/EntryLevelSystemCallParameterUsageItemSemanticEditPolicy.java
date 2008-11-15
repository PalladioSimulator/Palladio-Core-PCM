/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.VariableUsageCreateCommand;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class EntryLevelSystemCallParameterUsageItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.VariableUsage_3011 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(UsagemodelPackage.eINSTANCE
								.getEntryLevelSystemCall_InputParameterUsages_EntryLevelSystemCall());
			}
			return getGEFWrapper(new VariableUsageCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
