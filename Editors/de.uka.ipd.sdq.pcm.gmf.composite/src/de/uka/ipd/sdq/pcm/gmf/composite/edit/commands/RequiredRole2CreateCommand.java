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
 * @generated
 */
public class RequiredRole2CreateCommand extends CreateElementCommand {

    /**
     * @generated
     */
    public RequiredRole2CreateCommand(CreateElementRequest req) {
        super(req);
    }

    /**
     * @generated
     */
    protected EClass getEClassToEdit() {
        return EntityPackage.eINSTANCE.getInterfaceRequiringEntity();
    }

    /**
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
