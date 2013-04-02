/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.EventChannelCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

public class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy extends
ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyContext_3006 == req.getElementType()) {
            return getGEFWrapper(new CustomAssemblyContextCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EventChannel_3017 == req.getElementType()) {
            return getGEFWrapper(new EventChannelCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
