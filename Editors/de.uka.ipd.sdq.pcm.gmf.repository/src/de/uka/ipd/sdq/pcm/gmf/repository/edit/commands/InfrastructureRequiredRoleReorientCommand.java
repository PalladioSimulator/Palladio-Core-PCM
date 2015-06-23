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
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * @generated
 */
public class InfrastructureRequiredRoleReorientCommand extends EditElementCommand {

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
    public InfrastructureRequiredRoleReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof InfrastructureRequiredRole) {
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
        InfrastructureInterface target = getLink().getRequiredInterface__InfrastructureRequiredRole();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInfrastructureRequiredRole_4112(getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof InfrastructureInterface && newEnd instanceof InfrastructureInterface)) {
            return false;
        }
        if (!(getLink().eContainer() instanceof InterfaceRequiringEntity)) {
            return false;
        }
        InterfaceRequiringEntity source = (InterfaceRequiringEntity) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInfrastructureRequiredRole_4112(getLink(), source, getNewTarget());
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
        getLink().setRequiredInterface__InfrastructureRequiredRole(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected InfrastructureRequiredRole getLink() {
        return (InfrastructureRequiredRole) getElementToEdit();
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
    protected InfrastructureInterface getOldTarget() {
        return (InfrastructureInterface) oldEnd;
    }

    /**
     * @generated
     */
    protected InfrastructureInterface getNewTarget() {
        return (InfrastructureInterface) newEnd;
    }
}
