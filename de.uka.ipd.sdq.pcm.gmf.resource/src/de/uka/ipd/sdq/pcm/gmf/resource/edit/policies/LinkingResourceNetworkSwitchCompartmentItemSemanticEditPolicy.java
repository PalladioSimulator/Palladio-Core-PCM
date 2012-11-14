/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.commands.CommunicationLinkResourceSpecificationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class LinkingResourceNetworkSwitchCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LinkingResourceNetworkSwitchCompartmentItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.LinkingResource_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.CommunicationLinkResourceSpecification_3004 == req
				.getElementType()) {
			return getGEFWrapper(new CommunicationLinkResourceSpecificationCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
