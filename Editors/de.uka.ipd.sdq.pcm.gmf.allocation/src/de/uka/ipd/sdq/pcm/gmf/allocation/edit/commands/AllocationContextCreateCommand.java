/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands;

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

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * @generated
 */
public class AllocationContextCreateCommand extends EditElementCommand {

    /**
     * @generated
     */
    public AllocationContextCreateCommand(CreateElementRequest req) {
        super(req.getLabel(), null, req);
    }

    private Allocation allocation;

    /**
     * @generated not
     * 
     * @param req
     *            a CreateElementRequest
     * @param a
     *            an Allocation
     */
    public AllocationContextCreateCommand(CreateElementRequest req, Allocation a) {
        super(req.getLabel(), null, req);
        this.allocation = a;
    }

    /**
     * @generated not
     * 
     * @return the element to edit
     */
    protected EObject getElementToEdit() {
        // EObject container = ((CreateElementRequest) getRequest()).getContainer();
        // Replaced previous line with the following line:
        EObject container = allocation;

        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        return true;

    }

    /**
     * * Extended to automatically set the ressourceContainer Reference.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated not
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        AllocationContext newElement = AllocationFactory.eINSTANCE.createAllocationContext();

        // Added the following line:
        newElement
                .setResourceContainer_AllocationContext((ResourceContainer) ((CreateElementRequest) this.getRequest())
                        .getContainer());

        Allocation owner = (Allocation) getElementToEdit();
        owner.getAllocationContexts_Allocation().add(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }

    /**
     * @generated
     */
    protected void doConfigure(AllocationContext newElement, IProgressMonitor monitor, IAdaptable info)
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
