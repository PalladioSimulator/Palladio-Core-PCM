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
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;

/**
 * @generated
 */
public class InfrastructureProvidedRoleReorientCommand extends EditElementCommand {

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
    public InfrastructureProvidedRoleReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof InfrastructureProvidedRole) {
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
        InfrastructureInterface target = getLink().getProvidedInterface__InfrastructureProvidedRole();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInfrastructureProvidedRole_4111(getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof InfrastructureInterface && newEnd instanceof InfrastructureInterface)) {
            return false;
        }
        if (!(getLink().eContainer() instanceof InterfaceProvidingEntity)) {
            return false;
        }
        InterfaceProvidingEntity source = (InterfaceProvidingEntity) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistInfrastructureProvidedRole_4111(getLink(), source, getNewTarget());
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
        getLink().setProvidedInterface__InfrastructureProvidedRole(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected InfrastructureProvidedRole getLink() {
        return (InfrastructureProvidedRole) getElementToEdit();
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
