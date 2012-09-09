/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalFailureOccurrenceDescriptionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InternalActionFailureOccurrenceDescriptions2ItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public InternalActionFailureOccurrenceDescriptions2ItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.InternalAction_2006);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050 == req.getElementType()) {
            return getGEFWrapper(new InternalFailureOccurrenceDescriptionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
