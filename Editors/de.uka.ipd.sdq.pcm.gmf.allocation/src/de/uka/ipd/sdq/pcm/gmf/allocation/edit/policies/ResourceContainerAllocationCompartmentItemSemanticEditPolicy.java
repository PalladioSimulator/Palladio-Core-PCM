/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.AllocationContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ResourceContainerAllocationCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ResourceContainerAllocationCompartmentItemSemanticEditPolicy() {
		super(PalladioComponentModelElementTypes.ResourceContainer_2003);
	}
    /**
     * @generated
     */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.AllocationContext_3002 == req
				.getElementType()) {
			return getGEFWrapper(new AllocationContextCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
