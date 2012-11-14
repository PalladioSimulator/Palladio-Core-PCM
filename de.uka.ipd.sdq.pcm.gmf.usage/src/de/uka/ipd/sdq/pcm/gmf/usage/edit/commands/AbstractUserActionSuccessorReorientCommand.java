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
 * The Class AbstractUserActionSuccessorReorientCommand.
 *
 * @generated
 */
public class AbstractUserActionSuccessorReorientCommand extends EditElementCommand {

    /** The reorient direction. @generated */
    private final int reorientDirection;

    /** The reference owner. @generated */
    private final EObject referenceOwner;

    /** The old end. @generated */
    private final EObject oldEnd;

    /** The new end. @generated */
    private final EObject newEnd;

    /**
     * Instantiates a new abstract user action successor reorient command.
     *
     * @param request the request
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
     * Can execute.
     *
     * @return true, if successful
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
     * Can reorient source.
     *
     * @return true, if successful
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
     * Can reorient target.
     *
     * @return true, if successful
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
     * Do execute with result.
     *
     * @param monitor the monitor
     * @param info the info
     * @return the command result
     * @throws ExecutionException the execution exception
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
     * Reorient source.
     *
     * @return the command result
     * @throws ExecutionException the execution exception
     * @generated
     */
    protected CommandResult reorientSource() throws ExecutionException {
        getOldSource().setSuccessor(null);
        getNewSource().setSuccessor(getOldTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * Reorient target.
     *
     * @return the command result
     * @throws ExecutionException the execution exception
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().setSuccessor(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * Gets the old source.
     *
     * @return the old source
     * @generated
     */
    protected AbstractUserAction getOldSource() {
        return (AbstractUserAction) referenceOwner;
    }

    /**
     * Gets the new source.
     *
     * @return the new source
     * @generated
     */
    protected AbstractUserAction getNewSource() {
        return (AbstractUserAction) newEnd;
    }

    /**
     * Gets the old target.
     *
     * @return the old target
     * @generated
     */
    protected AbstractUserAction getOldTarget() {
        return (AbstractUserAction) oldEnd;
    }

    /**
     * Gets the new target.
     *
     * @return the new target
     * @generated
     */
    protected AbstractUserAction getNewTarget() {
        return (AbstractUserAction) newEnd;
    }
}
