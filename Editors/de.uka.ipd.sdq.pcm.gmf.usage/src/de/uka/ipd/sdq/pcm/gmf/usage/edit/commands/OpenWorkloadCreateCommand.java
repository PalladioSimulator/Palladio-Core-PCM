/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.commands;

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

import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;

/**
 * The Class OpenWorkloadCreateCommand.
 *
 * @generated
 */
public class OpenWorkloadCreateCommand extends EditElementCommand {

    /**
     * Instantiates a new open workload create command.
     *
     * @param req the req
     * @generated
     */
    public OpenWorkloadCreateCommand(CreateElementRequest req) {
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
        UsageScenario container = (UsageScenario) getElementToEdit();
        if (container.getWorkload_UsageScenario() != null) {
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
        OpenWorkload newElement = UsagemodelFactory.eINSTANCE.createOpenWorkload();

        UsageScenario owner = (UsageScenario) getElementToEdit();
        owner.setWorkload_UsageScenario(newElement);

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
    protected void doConfigure(OpenWorkload newElement, IProgressMonitor monitor, IAdaptable info)
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
