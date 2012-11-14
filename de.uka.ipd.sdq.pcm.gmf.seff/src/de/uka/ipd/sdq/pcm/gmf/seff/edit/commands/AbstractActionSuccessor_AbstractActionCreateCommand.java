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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;

/**
 * The Class AbstractActionSuccessor_AbstractActionCreateCommand.
 *
 * @generated
 */
public class AbstractActionSuccessor_AbstractActionCreateCommand extends EditElementCommand {

    /** The source. @generated */
    private final EObject source;

    /** The target. @generated */
    private final EObject target;

    /**
     * Instantiates a new abstract action successor_ abstract action create command.
     *
     * @param request the request
     * @param source the source
     * @param target the target
     * @generated
     */
    public AbstractActionSuccessor_AbstractActionCreateCommand(CreateRelationshipRequest request, EObject source,
            EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;
    }

    /**
     * Can execute.
     *
     * @return true, if successful
     * @generated
     */
    public boolean canExecute() {
        if (source == null && target == null) {
            return false;
        }
        if (source != null && false == source instanceof AbstractAction) {
            return false;
        }
        if (target != null && false == target instanceof AbstractAction) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateAbstractActionSuccessor_AbstractAction_4001(getSource(), getTarget());
    }

    /**
     * Do execute with result.
     *
     * @param monitor the monitor
     * @param info the info
     * @return the command result
     * @throws ExecutionException the execution exception
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        if (getSource() != null && getTarget() != null) {
            getSource().setSuccessor_AbstractAction(getTarget());
        }
        return CommandResult.newOKCommandResult();

    }

    /**
     * Sets the element to edit.
     *
     * @param element the new element to edit
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the source.
     *
     * @return the source
     * @generated
     */
    protected AbstractAction getSource() {
        return (AbstractAction) source;
    }

    /**
     * Gets the target.
     *
     * @return the target
     * @generated
     */
    protected AbstractAction getTarget() {
        return (AbstractAction) target;
    }
}
