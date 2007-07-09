/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ResourceDemandingBehaviour3CreateCommand;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ForkActionForkedBehaviours2ItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3021 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getForkAction_ForkedBehaviours_Fork());
			}
			return getGEFWrapper(new ResourceDemandingBehaviour3CreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}
}
