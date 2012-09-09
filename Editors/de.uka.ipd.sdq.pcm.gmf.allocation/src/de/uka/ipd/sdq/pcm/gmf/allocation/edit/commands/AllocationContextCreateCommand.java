/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AllocationContextCreateCommand extends CreateElementCommand {

    /**
     * @generated
     */
    public AllocationContextCreateCommand(CreateElementRequest req) {
        super(req);
    }

    private Allocation allocation;

    /**
     * @generated not
     */
    public AllocationContextCreateCommand(CreateElementRequest req, Allocation a) {
        super(req);
        this.allocation = a;
    }

    /**
     * @generated
     */
    protected EClass getEClassToEdit() {
        return AllocationPackage.eINSTANCE.getAllocation();
    }

    /**
     * @generated not
     */
    protected EObject getElementToEdit() {
        EObject container = allocation;
        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }

    @Override
    protected EObject doDefaultElementCreation() {
        AllocationContext ctx = (AllocationContext) super.doDefaultElementCreation();
        ctx.setResourceContainer_AllocationContext((ResourceContainer) ((CreateElementRequest) this.getRequest())
                .getContainer());
        return ctx;
    }

}
