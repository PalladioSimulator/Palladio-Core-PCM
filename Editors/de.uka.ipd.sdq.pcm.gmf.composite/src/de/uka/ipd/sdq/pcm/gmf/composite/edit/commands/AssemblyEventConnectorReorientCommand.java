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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * The Class AssemblyEventConnectorReorientCommand.
 * 
 * @generated
 */
public class AssemblyEventConnectorReorientCommand extends EditElementCommand {

    /** The reorient direction. @generated */
    private final int reorientDirection;

    /** The old end. @generated */
    private final EObject oldEnd;

    /** The new end. @generated */
    private final EObject newEnd;

    /**
     * Instantiates a new assembly event connector reorient command.
     * 
     * @param request
     *            the request
     * @generated
     */
    public AssemblyEventConnectorReorientCommand(ReorientRelationshipRequest request) {
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
        if (false == getElementToEdit() instanceof AssemblyEventConnector) {
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
        if (!(oldEnd instanceof SourceRole && newEnd instanceof SourceRole)) {
            return false;
        }
        SinkRole target = getLink().getSinkRole__AssemblyEventConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canExistAssemblyEventConnector_4007(
                container, getNewSource(), target);
    }

    /**
     * Can reorient target.
     * 
     * @return true, if successful
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof SinkRole && newEnd instanceof SinkRole)) {
            return false;
        }
        SourceRole source = getLink().getSourceRole__AssemblyEventConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canExistAssemblyEventConnector_4007(
                container, source, getNewTarget());
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
        getLink().setSourceRole__AssemblyEventConnector(getNewSource());
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
        getLink().setSinkRole__AssemblyEventConnector(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * Gets the link.
     * 
     * @return the link
     * @generated
     */
    protected AssemblyEventConnector getLink() {
        return (AssemblyEventConnector) getElementToEdit();
    }

    /**
     * Gets the old source.
     * 
     * @return the old source
     * @generated
     */
    protected SourceRole getOldSource() {
        return (SourceRole) oldEnd;
    }

    /**
     * Gets the new source.
     * 
     * @return the new source
     * @generated
     */
    protected SourceRole getNewSource() {
        return (SourceRole) newEnd;
    }

    /**
     * Gets the old target.
     * 
     * @return the old target
     * @generated
     */
    protected SinkRole getOldTarget() {
        return (SinkRole) oldEnd;
    }

    /**
     * Gets the new target.
     * 
     * @return the new target
     * @generated
     */
    protected SinkRole getNewTarget() {
        return (SinkRole) newEnd;
    }
}
