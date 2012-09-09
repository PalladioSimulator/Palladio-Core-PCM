/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;

/**
 * @generated
 */
public class AbstractUserActionSuccessorReorientCommand extends EditElementCommand {

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
    public AbstractUserActionSuccessorReorientCommand(ReorientReferenceRelationshipRequest request) {
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
        if (false == referenceOwner instanceof AbstractUserAction) {
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
        if (!(oldEnd instanceof AbstractUserAction && newEnd instanceof AbstractUserAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistAbstractUserActionSuccessor_4002(getNewSource(), getOldTarget());
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof AbstractUserAction && newEnd instanceof AbstractUserAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistAbstractUserActionSuccessor_4002(getOldSource(), getNewTarget());
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
        getOldSource().setSuccessor(null);
        getNewSource().setSuccessor(getOldTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().setSuccessor(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected AbstractUserAction getOldSource() {
        return (AbstractUserAction) referenceOwner;
    }

    /**
     * @generated
     */
    protected AbstractUserAction getNewSource() {
        return (AbstractUserAction) newEnd;
    }

    /**
     * @generated
     */
    protected AbstractUserAction getOldTarget() {
        return (AbstractUserAction) oldEnd;
    }

    /**
     * @generated
     */
    protected AbstractUserAction getNewTarget() {
        return (AbstractUserAction) newEnd;
    }
}
