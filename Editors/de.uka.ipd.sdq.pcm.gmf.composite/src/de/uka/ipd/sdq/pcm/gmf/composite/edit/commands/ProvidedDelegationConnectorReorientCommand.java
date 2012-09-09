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
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * @generated
 */
public class ProvidedDelegationConnectorReorientCommand extends EditElementCommand {

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
    public ProvidedDelegationConnectorReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof ProvidedDelegationConnector) {
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
        if (!(oldEnd instanceof OperationProvidedRole && newEnd instanceof OperationProvidedRole)) {
            return false;
        }
        OperationProvidedRole target = getLink().getInnerProvidedRole_ProvidedDelegationConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistProvidedDelegationConnector_4006(container, getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof OperationProvidedRole && newEnd instanceof OperationProvidedRole)) {
            return false;
        }
        OperationProvidedRole source = getLink().getOuterProvidedRole_ProvidedDelegationConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canExistProvidedDelegationConnector_4006(container, source, getNewTarget());
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
        getLink().setOuterProvidedRole_ProvidedDelegationConnector(getNewSource());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setInnerProvidedRole_ProvidedDelegationConnector(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected ProvidedDelegationConnector getLink() {
        return (ProvidedDelegationConnector) getElementToEdit();
    }

    /**
     * @generated
     */
    protected OperationProvidedRole getOldSource() {
        return (OperationProvidedRole) oldEnd;
    }

    /**
     * @generated
     */
    protected OperationProvidedRole getNewSource() {
        return (OperationProvidedRole) newEnd;
    }

    /**
     * @generated
     */
    protected OperationProvidedRole getOldTarget() {
        return (OperationProvidedRole) oldEnd;
    }

    /**
     * @generated
     */
    protected OperationProvidedRole getNewTarget() {
        return (OperationProvidedRole) newEnd;
    }
}
