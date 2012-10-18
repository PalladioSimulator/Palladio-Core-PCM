/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AcquireActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.BranchActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.CollectionIteratorActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.EmitEventActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ExternalCallActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.LoopActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.RecoveryActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ReleaseActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.SetVariableActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StartActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StopActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class ResourceDemandingSEFFItemSemanticEditPolicy.
 *
 * @generated
 */
public class ResourceDemandingSEFFItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new resource demanding seff item semantic edit policy.
     *
     * @generated
     */
    public ResourceDemandingSEFFItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.ResourceDemandingSEFF_1000);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.StartAction_2001 == req.getElementType()) {
            return getGEFWrapper(new StartActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.StopAction_2002 == req.getElementType()) {
            return getGEFWrapper(new StopActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ExternalCallAction_2003 == req.getElementType()) {
            return getGEFWrapper(new ExternalCallActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EmitEventAction_2013 == req.getElementType()) {
            return getGEFWrapper(new EmitEventActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.LoopAction_2004 == req.getElementType()) {
            return getGEFWrapper(new LoopActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.BranchAction_2005 == req.getElementType()) {
            return getGEFWrapper(new BranchActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.InternalAction_2006 == req.getElementType()) {
            return getGEFWrapper(new InternalActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.CollectionIteratorAction_2007 == req.getElementType()) {
            return getGEFWrapper(new CollectionIteratorActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.SetVariableAction_2008 == req.getElementType()) {
            return getGEFWrapper(new SetVariableActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.AcquireAction_2012 == req.getElementType()) {
            return getGEFWrapper(new AcquireActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ReleaseAction_2010 == req.getElementType()) {
            return getGEFWrapper(new ReleaseActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ForkAction_2011 == req.getElementType()) {
            return getGEFWrapper(new ForkActionCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.RecoveryAction_2016 == req.getElementType()) {
            return getGEFWrapper(new RecoveryActionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * Gets the duplicate command.
     *
     * @param req the req
     * @return the duplicate command
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
        return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
    }

    /**
     * The Class DuplicateAnythingCommand.
     *
     * @generated
     */
    private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

        /**
         * Instantiates a new duplicate anything command.
         *
         * @param editingDomain the editing domain
         * @param req the req
         * @generated
         */
        public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
            super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
        }
    }
}
