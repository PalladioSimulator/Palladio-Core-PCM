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

/**
 * @generated
 */
public class RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourReorientCommand extends
        EditElementCommand {

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
    public RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourReorientCommand(
            ReorientReferenceRelationshipRequest request) {
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
        if (false == referenceOwner instanceof de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) {
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
        if (!(oldEnd instanceof de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour && newEnd instanceof de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                        getNewSource(), getOldTarget());
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour && newEnd instanceof de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                        getOldSource(), getNewTarget());
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
        getOldSource().getFailureHandlingAlternatives__RecoveryActionBehaviour().remove(getOldTarget());
        getNewSource().getFailureHandlingAlternatives__RecoveryActionBehaviour().add(getOldTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().getFailureHandlingAlternatives__RecoveryActionBehaviour().remove(getOldTarget());
        getOldSource().getFailureHandlingAlternatives__RecoveryActionBehaviour().add(getNewTarget());
        return CommandResult.newOKCommandResult(referenceOwner);
    }

    /**
     * @generated
     */
    protected de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour getOldSource() {
        return (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) referenceOwner;
    }

    /**
     * @generated
     */
    protected de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour getNewSource() {
        return (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) newEnd;
    }

    /**
     * @generated
     */
    protected de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour getOldTarget() {
        return (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) oldEnd;
    }

    /**
     * @generated
     */
    protected de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour getNewTarget() {
        return (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) newEnd;
    }
}
