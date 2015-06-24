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
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class AbstractActionSuccessor_AbstractActionCreateCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final EObject source;

    /**
     * @generated
     */
    private final EObject target;

    /**
     * @generated
     */
    public AbstractActionSuccessor_AbstractActionCreateCommand(final CreateRelationshipRequest request,
            final EObject source, final EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;
    }

    /**
     * @generated
     */
    @Override
    public boolean canExecute() {
        if (this.source == null && this.target == null) {
            return false;
        }
        if (this.source != null && false == this.source instanceof AbstractAction) {
            return false;
        }
        if (this.target != null && false == this.target instanceof AbstractAction) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        return PalladioComponentModelBaseItemSemanticEditPolicy.getLinkConstraints()
                .canCreateAbstractActionSuccessor_AbstractAction_4001(getSource(), getTarget());
    }

    /**
     * @generated
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        if (getSource() != null && getTarget() != null) {
            getSource().setSuccessor_AbstractAction(getTarget());
        }
        return CommandResult.newOKCommandResult();

    }

    /**
     * @generated
     */
    @Override
    protected void setElementToEdit(final EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * @generated
     */
    protected AbstractAction getSource() {
        return (AbstractAction) this.source;
    }

    /**
     * @generated
     */
    protected AbstractAction getTarget() {
        return (AbstractAction) this.target;
    }
}
