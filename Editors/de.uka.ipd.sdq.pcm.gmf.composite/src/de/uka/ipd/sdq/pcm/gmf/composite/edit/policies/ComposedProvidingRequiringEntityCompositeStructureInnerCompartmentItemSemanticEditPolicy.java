/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy() {
		super(
				PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.AssemblyContext_3006 == req
				.getElementType()) {
			return getGEFWrapper(new AssemblyContextCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
