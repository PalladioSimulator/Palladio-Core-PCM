/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import org.palladiosimulator.pcm.allocation.Allocation;
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
     * @generated not
     * 
     * FIXME: Code has been moved to custom plugin, but is never called there!
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.AllocationContext_3002 == req
                .getElementType()) {
//          return getGEFWrapper(new AllocationContextCreateCommand(req));
            // Instead, added the following two lines:
            Allocation a = (Allocation) ((View) getHost().getParent().getParent().getModel()).getElement();
            return getGEFWrapper(new AllocationContextCreateCommand(req, a));
        }
        return super.getCreateCommand(req);
    }

}
