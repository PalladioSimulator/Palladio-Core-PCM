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
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;

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
    public AbstractActionSuccessor_AbstractActionReorientCommand(final ReorientReferenceRelationshipRequest request) {
        super(request.getLabel(), null, request);
        this.reorientDirection = request.getDirection();
        this.referenceOwner = request.getReferenceOwner();
        this.oldEnd = request.getOldRelationshipEnd();
        this.newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    @Override
    public boolean canExecute() {
        if (false == this.referenceOwner instanceof AbstractAction) {
            return false;
        }
        if (this.reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return canReorientSource();
        }
        if (this.reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return canReorientTarget();
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean canReorientSource() {
        if (!(this.oldEnd instanceof AbstractAction && this.newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAbstractActionSuccessor_AbstractAction_4001(getNewSource(), getOldTarget());
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(this.oldEnd instanceof AbstractAction && this.newEnd instanceof AbstractAction)) {
            return false;
        }
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistAbstractActionSuccessor_AbstractAction_4001(getOldSource(), getNewTarget());
    }

    /**
     * @generated
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
        }
        if (this.reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return reorientSource();
        }
        if (this.reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
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
        return CommandResult.newOKCommandResult(this.referenceOwner);
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getOldSource().setSuccessor_AbstractAction(getNewTarget());
        return CommandResult.newOKCommandResult(this.referenceOwner);
    }

    /**
     * @generated
     */
    protected AbstractAction getOldSource() {
        return (AbstractAction) this.referenceOwner;
    }

    /**
     * @generated
     */
    protected AbstractAction getNewSource() {
        return (AbstractAction) this.newEnd;
    }

    /**
     * @generated
     */
    protected AbstractAction getOldTarget() {
        return (AbstractAction) this.oldEnd;
    }

    /**
     * @generated
     */
    protected AbstractAction getNewTarget() {
        return (AbstractAction) this.newEnd;
    }
}
