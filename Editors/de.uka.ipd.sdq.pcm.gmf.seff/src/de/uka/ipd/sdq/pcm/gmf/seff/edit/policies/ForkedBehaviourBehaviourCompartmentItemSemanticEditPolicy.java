/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AcquireAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.BranchAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.CollectionIteratorAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.EmitEventAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ExternalCallAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.LoopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ReleaseAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StartAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ForkedBehaviourBehaviourCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ForkedBehaviourBehaviourCompartmentItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.StartAction_3004 == req.getElementType()) {
            return getGEFWrapper(new StartAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.StopAction_3005 == req.getElementType()) {
            return getGEFWrapper(new StopAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.LoopAction_3006 == req.getElementType()) {
            return getGEFWrapper(new LoopAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.InternalAction_3007 == req.getElementType()) {
            return getGEFWrapper(new InternalAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.BranchAction_3009 == req.getElementType()) {
            return getGEFWrapper(new BranchAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ExternalCallAction_3012 == req.getElementType()) {
            return getGEFWrapper(new ExternalCallAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EmitEventAction_3046 == req.getElementType()) {
            return getGEFWrapper(new EmitEventAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.CollectionIteratorAction_3013 == req.getElementType()) {
            return getGEFWrapper(new CollectionIteratorAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.AcquireAction_3026 == req.getElementType()) {
            return getGEFWrapper(new AcquireAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ReleaseAction_3020 == req.getElementType()) {
            return getGEFWrapper(new ReleaseAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ForkAction_3023 == req.getElementType()) {
            return getGEFWrapper(new ForkAction2CreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.RecoveryAction_3057 == req.getElementType()) {
            return getGEFWrapper(new RecoveryAction2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
