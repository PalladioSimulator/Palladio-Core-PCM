/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;

/**
 * @generated
 */
public class AbstractActionSuccessor_AbstractActionReorientCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final int reorientDirection;

    /**
     * @generated
     */
    private final EObject referenceOwner;

    /**
     * @generated
     */
    private final EObject oldEnd;

    /**
     * @generated
     */
    private final EObject newEnd;

    /**
     * @generated
     */
    public AbstractActionSuccessor_AbstractActionReorientCommand(ReorientReferenceRelationshipRequest request) {
        super(request.getLabel(), null, request);
        reorientDirection = request.getDirection();
        referenceOwner = request.getReferenceOwner();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == referenceOwner instanceof AbstractAction) {
            return false;
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return canReorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return canReorientTarget();
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean canReorientSource() {
        if (!(oldEnd instanceof AbstractAction && newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAbstractActionSuccessor_AbstractAction_4001(getNewSource(), getOldTarget());
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof AbstractAction && newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAbstractActionSuccessor_AbstractAction_4001(getOldSource(), getNewTarget());
    }

    /**
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return reorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return reorientTarget();
        }
        throw new IllegalStateException();
    }

    /**
     * @generated
     */
    protected CommandResult reorientSource() throws ExecutionException {
        getOldSource().setSuccessor_AbstractAction(null);
        getNewSource().setSuccessor_AbstractAction(getOldTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().setSuccessor_AbstractAction(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected AbstractAction getOldSource() {
        return (AbstractAction) referenceOwner;
    }

    /**
     * @generated
     */
    protected AbstractAction getNewSource() {
        return (AbstractAction) newEnd;
    }

    /**
     * @generated
     */
    protected AbstractAction getOldTarget() {
        return (AbstractAction) oldEnd;
    }

    /**
     * @generated
     */
    protected AbstractAction getNewTarget() {
        return (AbstractAction) newEnd;
    }
}
