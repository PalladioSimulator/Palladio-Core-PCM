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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * @generated
 */
public class OperationRequiredRoleReorientCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final int reorientDirection;

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
    public OperationRequiredRoleReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof OperationRequiredRole) {
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
        if (!(oldEnd instanceof InterfaceRequiringEntity && newEnd instanceof InterfaceRequiringEntity)) {
            return false;
        }
        OperationInterface target = getLink().getRequiredInterface__OperationRequiredRole();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperationRequiredRole_4106(getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof OperationInterface && newEnd instanceof OperationInterface)) {
            return false;
        }
        if (!(getLink().eContainer() instanceof InterfaceRequiringEntity)) {
            return false;
        }
        InterfaceRequiringEntity source = (InterfaceRequiringEntity) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperationRequiredRole_4106(getLink(), source, getNewTarget());
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
        getOldSource().getRequiredRoles_InterfaceRequiringEntity().remove(getLink());
        getNewSource().getRequiredRoles_InterfaceRequiringEntity().add(getLink());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setRequiredInterface__OperationRequiredRole(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected OperationRequiredRole getLink() {
        return (OperationRequiredRole) getElementToEdit();
    }

    /**
     * @generated
     */
    protected InterfaceRequiringEntity getOldSource() {
        return (InterfaceRequiringEntity) oldEnd;
    }

    /**
     * @generated
     */
    protected InterfaceRequiringEntity getNewSource() {
        return (InterfaceRequiringEntity) newEnd;
    }

    /**
     * @generated
     */
    protected OperationInterface getOldTarget() {
        return (OperationInterface) oldEnd;
    }

    /**
     * @generated
     */
    protected OperationInterface getNewTarget() {
        return (OperationInterface) newEnd;
    }
}
