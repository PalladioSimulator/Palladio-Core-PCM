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

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * @generated
 */
public class OperationProvidedRoleReorientCommand extends EditElementCommand {

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
    public OperationProvidedRoleReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof OperationProvidedRole) {
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
        if (!(oldEnd instanceof InterfaceProvidingEntity && newEnd instanceof InterfaceProvidingEntity)) {
            return false;
        }
        OperationInterface target = getLink().getProvidedInterface__OperationProvidedRole();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperationProvidedRole_4105(getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof OperationInterface && newEnd instanceof OperationInterface)) {
            return false;
        }
        if (!(getLink().eContainer() instanceof InterfaceProvidingEntity)) {
            return false;
        }
        InterfaceProvidingEntity source = (InterfaceProvidingEntity) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperationProvidedRole_4105(getLink(), source, getNewTarget());
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
        getOldSource().getProvidedRoles_InterfaceProvidingEntity().remove(getLink());
        getNewSource().getProvidedRoles_InterfaceProvidingEntity().add(getLink());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setProvidedInterface__OperationProvidedRole(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected OperationProvidedRole getLink() {
        return (OperationProvidedRole) getElementToEdit();
    }

    /**
     * @generated
     */
    protected InterfaceProvidingEntity getOldSource() {
        return (InterfaceProvidingEntity) oldEnd;
    }

    /**
     * @generated
     */
    protected InterfaceProvidingEntity getNewSource() {
        return (InterfaceProvidingEntity) newEnd;
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
