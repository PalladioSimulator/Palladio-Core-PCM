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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class AssemblyConnectorReorientCommand.
 * 
 * @author Christian Busch
 * @generated
 */
public class AssemblyConnectorReorientCommand extends EditElementCommand {

    /** The reorient direction. @generated */
    private final int reorientDirection;

    /** The old end. @generated */
    private final EObject oldEnd;

    /** The new end. @generated */
    private final EObject newEnd;

    /**
     * Instantiates a new assembly connector reorient command.
     * 
     * @param request
     *            the request
     * @generated
     */
    public AssemblyConnectorReorientCommand(ReorientRelationshipRequest request) {
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
        if (false == getElementToEdit() instanceof AssemblyConnector) {
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
        OperationProvidedRole target = getLink().getProvidedRole_AssemblyConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canExistAssemblyConnector_4004(
                container, getNewSource(), target);
    }

    /**
     * Can reorient target.
     * 
     * @return true, if successful
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof OperationProvidedRole && newEnd instanceof OperationProvidedRole)) {
            return false;
        }
        OperationRequiredRole source = getLink().getRequiredRole_AssemblyConnector();
        if (!(getLink().eContainer() instanceof ComposedStructure)) {
            return false;
        }
        ComposedStructure container = (ComposedStructure) getLink().eContainer();
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canExistAssemblyConnector_4004(
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
     * @generated NOT
     */
    protected CommandResult reorientSource() throws ExecutionException {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
        messageBox.setText("Notice");
        messageBox.setMessage("Please delete the link and create a new one instead of reorienting it.");
        messageBox.open();
        return CommandResult.newCancelledCommandResult();
    }

    /**
     * Reorient target.
     * 
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated NOT
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
        messageBox.setText("Notice");
        messageBox.setMessage("Please delete the link and create a new one instead of reorienting it.");
        messageBox.open();
        return CommandResult.newCancelledCommandResult();
    }

    /**
     * Gets the link.
     * 
     * @return the link
     * @generated
     */
    protected AssemblyConnector getLink() {
        return (AssemblyConnector) getElementToEdit();
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
    protected OperationProvidedRole getOldTarget() {
        return (OperationProvidedRole) oldEnd;
    }

    /**
     * Gets the new target.
     * 
     * @return the new target
     * @generated
     */
    protected OperationProvidedRole getNewTarget() {
        return (OperationProvidedRole) newEnd;
    }
}
