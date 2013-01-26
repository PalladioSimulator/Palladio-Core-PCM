/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class RequiredDelegationConnectorReorientCommand.
 * 
 * @generated
 */
public class RequiredDelegationConnectorReorientCommand extends EditElementCommand {

    /** The reorient direction. @generated */
    private final int reorientDirection;

    /** The old end. @generated */
    private final EObject oldEnd;

    /** The new end. @generated */
    private final EObject newEnd;

    /**
     * Instantiates a new required delegation connector reorient command.
     * 
     * @param request
     *            the request
     * @generated
     */
    public RequiredDelegationConnectorReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
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
        if (false == getElementToEdit() instanceof RequiredDelegationConnector) {
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
        if (!(oldEnd instanceof OperationRequiredRole && newEnd instanceof OperationRequiredRole)) {
            return false;
        }
        OperationRequiredRole target = getLink().getOuterRequiredRole_RequiredDelegationConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistRequiredDelegationConnector_4005(container, getNewSource(), target);
    }

    /**
     * Can reorient target.
     * 
     * @return true, if successful
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof OperationRequiredRole && newEnd instanceof OperationRequiredRole)) {
            return false;
        }
        OperationRequiredRole source = getLink().getInnerRequiredRole_RequiredDelegationConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistRequiredDelegationConnector_4005(container, source, getNewTarget());
    }

    /**
     * Do execute with result.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
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
     * @throws ExecutionException
     *             the execution exception
     * @generated
     */
    protected CommandResult reorientSource() throws ExecutionException {
        getLink().setInnerRequiredRole_RequiredDelegationConnector(getNewSource());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * Reorient target.
     * 
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setOuterRequiredRole_RequiredDelegationConnector(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * Gets the link.
     * 
     * @return the link
     * @generated
     */
    protected RequiredDelegationConnector getLink() {
        return (RequiredDelegationConnector) getElementToEdit();
    }

    /**
     * Gets the old source.
     * 
     * @return the old source
     * @generated
     */
    protected OperationRequiredRole getOldSource() {
        return (OperationRequiredRole) oldEnd;
    }

    /**
     * Gets the new source.
     * 
     * @return the new source
     * @generated
     */
    protected OperationRequiredRole getNewSource() {
        return (OperationRequiredRole) newEnd;
    }

    /**
     * Gets the old target.
     * 
     * @return the old target
     * @generated
     */
    protected OperationRequiredRole getOldTarget() {
        return (OperationRequiredRole) oldEnd;
    }

    /**
     * Gets the new target.
     * 
     * @return the new target
     * @generated
     */
    protected OperationRequiredRole getNewTarget() {
        return (OperationRequiredRole) newEnd;
    }
}
