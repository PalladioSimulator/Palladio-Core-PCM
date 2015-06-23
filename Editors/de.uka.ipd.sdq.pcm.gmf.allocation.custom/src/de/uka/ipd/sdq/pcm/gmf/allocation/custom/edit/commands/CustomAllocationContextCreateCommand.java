package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.AllocationContextCreateCommand;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * a custom AllocationContext CreateCommand. FIXME: Never used?
 */
public class CustomAllocationContextCreateCommand extends AllocationContextCreateCommand {

    /**
     * An Allocation.
     */
    private Allocation allocation;

    /**
     * The constructor.
     * 
     * @param req
     *            a CreateElementRequst
     * @param a
     *            an Allocation
     */
    public CustomAllocationContextCreateCommand(CreateElementRequest req, Allocation a) {
        super(req);
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

}
