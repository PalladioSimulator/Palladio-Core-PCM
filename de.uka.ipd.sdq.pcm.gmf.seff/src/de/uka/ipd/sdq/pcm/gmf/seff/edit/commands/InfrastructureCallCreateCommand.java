/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
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

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

/**
 * The Class InfrastructureCallCreateCommand.
 *
 * @generated
 */
public class InfrastructureCallCreateCommand extends EditElementCommand {

    /**
     * Default number of calls to use for a infrastructure call.
     * 
     * @generated not
     */
    private static final String DEFAULT_NUMBER_OF_CALLS = "1";

    /**
     * Instantiates a new infrastructure call create command.
     *
     * @param req the req
     * @generated
     */
    public InfrastructureCallCreateCommand(CreateElementRequest req) {
        super(req.getLabel(), null, req);
    }

    /**
     * FIXME: replace with setElementToEdit().
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
        return true;

    }

    /**
     * Additionally adds number of calls to the element.
     *
     * @param monitor the monitor
     * @param info the info
     * @return the command result
     * @throws ExecutionException the execution exception
     * @generated not
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall newElement = de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory.eINSTANCE
                .createInfrastructureCall();
        // add empty random variable
        PCMRandomVariable numberOfCalls = CoreFactory.eINSTANCE.createPCMRandomVariable();
        numberOfCalls.setSpecification(DEFAULT_NUMBER_OF_CALLS);
        newElement.setNumberOfCalls__InfrastructureCall(numberOfCalls);

        AbstractInternalControlFlowAction owner = (AbstractInternalControlFlowAction) getElementToEdit();
        owner.getInfrastructureCall__Action().add(newElement);

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
    protected void doConfigure(de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall newElement,
            IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
