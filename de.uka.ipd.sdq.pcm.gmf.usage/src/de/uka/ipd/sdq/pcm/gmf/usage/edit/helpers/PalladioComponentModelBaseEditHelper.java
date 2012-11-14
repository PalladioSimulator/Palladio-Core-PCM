/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * The Class PalladioComponentModelBaseEditHelper.
 *
 * @generated
 */
public class PalladioComponentModelBaseEditHelper extends AbstractEditHelper {

    /** The Constant EDIT_POLICY_COMMAND. @generated */
    public static final String EDIT_POLICY_COMMAND = "edit policy command"; //$NON-NLS-1$

    /** The Constant CONTEXT_ELEMENT_TYPE. @generated */
    public static final String CONTEXT_ELEMENT_TYPE = "context element type"; //$NON-NLS-1$

    /**
     * Gets the edits the helper advice.
     *
     * @param req the req
     * @return the edits the helper advice
     * @generated
     */
    protected IEditHelperAdvice[] getEditHelperAdvice(IEditCommandRequest req) {
        if (req.getParameter(CONTEXT_ELEMENT_TYPE) instanceof IElementType) {
            return ElementTypeRegistry.getInstance().getEditHelperAdvice(
                    (IElementType) req.getParameter(CONTEXT_ELEMENT_TYPE));
        }
        return super.getEditHelperAdvice(req);
    }

    /**
     * Gets the instead command.
     *
     * @param req the req
     * @return the instead command
     * @generated
     */
    protected ICommand getInsteadCommand(IEditCommandRequest req) {
        ICommand epCommand = (ICommand) req.getParameter(EDIT_POLICY_COMMAND);
        req.setParameter(EDIT_POLICY_COMMAND, null);
        ICommand ehCommand = super.getInsteadCommand(req);
        if (epCommand == null) {
            return ehCommand;
        }
        if (ehCommand == null) {
            return epCommand;
        }
        CompositeCommand command = new CompositeCommand(null);
        command.add(epCommand);
        command.add(ehCommand);
        return command;
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected ICommand getCreateCommand(CreateElementRequest req) {
        return null;
    }

    /**
     * Gets the creates the relationship command.
     *
     * @param req the req
     * @return the creates the relationship command
     * @generated
     */
    protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * Gets the destroy element command.
     *
     * @param req the req
     * @return the destroy element command
     * @generated
     */
    protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
        return null;
    }

    /**
     * Gets the destroy reference command.
     *
     * @param req the req
     * @return the destroy reference command
     * @generated
     */
    protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return null;
    }
}