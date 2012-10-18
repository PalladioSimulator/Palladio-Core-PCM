/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

/**
 * The Class ResourceDemandingBehaviour3CreateCommand.
 *
 * @generated
 */
public class ResourceDemandingBehaviour3CreateCommand extends EditElementCommand {

    /**
     * Instantiates a new resource demanding behaviour3 create command.
     *
     * @param req the req
     * @generated
     */
    public ResourceDemandingBehaviour3CreateCommand(CreateElementRequest req) {
        super(req.getLabel(), null, req);
    }

    /**
     * Gets the element to edit.
     *
     * @return the element to edit
     * @generated
     */
    protected EObject getElementToEdit() {
        EObject container = ((CreateElementRequest) getRequest()).getContainer();
        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }

    /**
     * Can execute.
     *
     * @return true, if successful
     * @generated
     */
    public boolean canExecute() {
        AbstractLoopAction container = (AbstractLoopAction) getElementToEdit();
        if (container.getBodyBehaviour_Loop() != null) {
            return false;
        }
        return true;

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
        ResourceDemandingBehaviour newElement = SeffFactory.eINSTANCE.createResourceDemandingBehaviour();

        AbstractLoopAction owner = (AbstractLoopAction) getElementToEdit();
        owner.setBodyBehaviour_Loop(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }

    /**
     * Do configure.
     *
     * @param newElement the new element
     * @param monitor the monitor
     * @param info the info
     * @throws ExecutionException the execution exception
     * @generated
     */
    protected void doConfigure(ResourceDemandingBehaviour newElement, IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {
        IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
        ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
        configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
        configureRequest.addParameters(getRequest().getParameters());
        ICommand configureCommand = elementType.getEditCommand(configureRequest);
        if (configureCommand != null && configureCommand.canExecute()) {
            configureCommand.execute(monitor, info);
        }
    }

}
