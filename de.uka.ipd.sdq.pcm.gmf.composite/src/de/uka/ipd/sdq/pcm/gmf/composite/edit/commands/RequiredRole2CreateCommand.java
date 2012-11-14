/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

// TODO: decide whether this file is obsolete

/**
 * The Class RequiredRole2CreateCommand.
 *
 * @generated
 */
public class RequiredRole2CreateCommand extends CreateElementCommand {

    /**
     * Instantiates a new required role2 create command.
     *
     * @param req the req
     * @generated
     */
    public RequiredRole2CreateCommand(CreateElementRequest req) {
        super(req);
    }

    /**
     * Gets the e class to edit.
     *
     * @return the e class to edit
     * @generated
     */
    protected EClass getEClassToEdit() {
        return EntityPackage.eINSTANCE.getInterfaceRequiringEntity();
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

}
