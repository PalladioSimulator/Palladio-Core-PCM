/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.ClosedWorkloadCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.OpenWorkloadCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.ScenarioBehaviourCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class UsageScenarioUsageScenarioCompartmentItemSemanticEditPolicy.
 *
 * @generated
 */
public class UsageScenarioUsageScenarioCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new usage scenario usage scenario compartment item semantic edit policy.
     *
     * @generated
     */
    public UsageScenarioUsageScenarioCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.UsageScenario_2004);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.ScenarioBehaviour_3014 == req.getElementType()) {
            return getGEFWrapper(new ScenarioBehaviourCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ClosedWorkload_3015 == req.getElementType()) {
            return getGEFWrapper(new ClosedWorkloadCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.OpenWorkload_3016 == req.getElementType()) {
            return getGEFWrapper(new OpenWorkloadCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
