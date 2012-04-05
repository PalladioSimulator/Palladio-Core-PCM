/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.commands.CustomInfrastructureCallCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

public class CustomInternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy
		extends InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy {

	public CustomInternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy() {
		super();
	}

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.InfrastructureCall_3053 == req
				.getElementType()) {
			return getGEFWrapper(new CustomInfrastructureCallCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
