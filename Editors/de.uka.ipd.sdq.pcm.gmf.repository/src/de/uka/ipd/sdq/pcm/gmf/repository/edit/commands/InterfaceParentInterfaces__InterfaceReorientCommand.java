/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.Interface;

/**
 * @generated
 */
public class InterfaceParentInterfaces__InterfaceReorientCommand extends EditElementCommand {

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
    public InterfaceParentInterfaces__InterfaceReorientCommand(ReorientReferenceRelationshipRequest request) {
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
        if (false == referenceOwner instanceof Interface) {
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
        if (!(oldEnd instanceof Interface && newEnd instanceof Interface)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInterfaceParentInterfaces__Interface_4113(getNewSource(), getOldTarget());
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof Interface && newEnd instanceof Interface)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInterfaceParentInterfaces__Interface_4113(getOldSource(), getNewTarget());
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
        getOldSource().getParentInterfaces__Interface().remove(getOldTarget());
        getNewSource().getParentInterfaces__Interface().add(getOldTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().getParentInterfaces__Interface().remove(getOldTarget());
        getOldSource().getParentInterfaces__Interface().add(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected Interface getOldSource() {
        return (Interface) referenceOwner;
    }

    /**
     * @generated
     */
    protected Interface getNewSource() {
        return (Interface) newEnd;
    }

    /**
     * @generated
     */
    protected Interface getOldTarget() {
        return (Interface) oldEnd;
    }

    /**
     * @generated
     */
    protected Interface getNewTarget() {
        return (Interface) newEnd;
    }
}
