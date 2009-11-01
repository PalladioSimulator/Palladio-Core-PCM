/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class LinkingResourceFromResourceContainer_LinkingResourceItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LinkingResourceFromResourceContainer_LinkingResourceItemSemanticEditPolicy() {
		super(
				PalladioComponentModelElementTypes.LinkingResourceFromResourceContainer_LinkingResource_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
