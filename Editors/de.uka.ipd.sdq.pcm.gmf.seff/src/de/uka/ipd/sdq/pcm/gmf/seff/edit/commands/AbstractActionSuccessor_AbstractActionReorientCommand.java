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
 * The Class AbstractActionSuccessor_AbstractActionReorientCommand.
 *
 * @generated
 */
public class AbstractActionSuccessor_AbstractActionReorientCommand extends EditElementCommand {

    /** The reorient direction. @generated */
    private final int reorientDirection;

    /** The reference owner. @generated */
    private final EObject referenceOwner;

    /** The old end. @generated */
    private final EObject oldEnd;

    /** The new end. @generated */
    private final EObject newEnd;

    /**
     * Instantiates a new abstract action successor_ abstract action reorient command.
     *
     * @param request the request
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
     * Can execute.
     *
     * @return true, if successful
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
     * Can reorient source.
     *
     * @return true, if successful
     * @generated
     */
    protected boolean canReorientSource() {
        if (!(oldEnd instanceof AbstractAction && newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistAbstractActionSuccessor_AbstractAction_4001(getNewSource(), getOldTarget());
    }

    /**
     * Can reorient target.
     *
     * @return true, if successful
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof AbstractAction && newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistAbstractActionSuccessor_AbstractAction_4001(getOldSource(), getNewTarget());
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
        getOldSource().setSuccessor_AbstractAction(null);
        getNewSource().setSuccessor_AbstractAction(getOldTarget());
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
        getOldSource().setSuccessor_AbstractAction(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * Gets the old source.
     *
     * @return the old source
     * @generated
     */
    protected AbstractAction getOldSource() {
        return (AbstractAction) referenceOwner;
    }

    /**
     * Gets the new source.
     *
     * @return the new source
     * @generated
     */
    protected AbstractAction getNewSource() {
        return (AbstractAction) newEnd;
    }

    /**
     * Gets the old target.
     *
     * @return the old target
     * @generated
     */
    protected AbstractAction getOldTarget() {
        return (AbstractAction) oldEnd;
    }

    /**
     * Gets the new target.
     *
     * @return the new target
     * @generated
     */
    protected AbstractAction getNewTarget() {
        return (AbstractAction) newEnd;
    }
}
