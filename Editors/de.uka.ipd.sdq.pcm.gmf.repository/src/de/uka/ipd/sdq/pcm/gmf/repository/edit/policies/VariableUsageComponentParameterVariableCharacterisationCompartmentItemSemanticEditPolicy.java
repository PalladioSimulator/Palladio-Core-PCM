/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.VariableCharacterisationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class VariableUsageComponentParameterVariableCharacterisationCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public VariableUsageComponentParameterVariableCharacterisationCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.VariableUsage_3104);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableCharacterisation_3105 == req.getElementType()) {
            return getGEFWrapper(new VariableCharacterisationCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
