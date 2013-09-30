/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.BranchCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.DelayCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.EntryLevelSystemCallCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.LoopCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.StartCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.StopCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ScenarioBehaviourScenarioBehaviourStepsCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ScenarioBehaviourScenarioBehaviourStepsCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ScenarioBehaviour_3014);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.Start_3001 == req.getElementType()) {
            return getGEFWrapper(new StartCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.Stop_3002 == req.getElementType()) {
            return getGEFWrapper(new StopCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EntryLevelSystemCall_3003 == req.getElementType()) {
            return getGEFWrapper(new EntryLevelSystemCallCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.Loop_3005 == req.getElementType()) {
            return getGEFWrapper(new LoopCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.Branch_3008 == req.getElementType()) {
            return getGEFWrapper(new BranchCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.Delay_3017 == req.getElementType()) {
            return getGEFWrapper(new DelayCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
