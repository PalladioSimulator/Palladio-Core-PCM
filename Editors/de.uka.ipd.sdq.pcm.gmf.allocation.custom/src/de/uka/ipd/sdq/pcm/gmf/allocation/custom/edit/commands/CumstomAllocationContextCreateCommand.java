package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.commands;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.AllocationContextCreateCommand;

public class CumstomAllocationContextCreateCommand extends AllocationContextCreateCommand {

    private Allocation allocation;

    public CumstomAllocationContextCreateCommand(CreateElementRequest req, Allocation a) {
        super(req);
        this.allocation = a;
    }

    @Override
    protected EObject getElementToEdit() {
        EObject container = allocation;
        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }
}
