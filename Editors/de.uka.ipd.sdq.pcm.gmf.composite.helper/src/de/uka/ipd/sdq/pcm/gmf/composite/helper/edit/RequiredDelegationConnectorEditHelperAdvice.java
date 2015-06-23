/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.helper.edit;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.palladiosimulator.pcm.core.composition.RequiredDelegationConnector;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

/**
 * The Class RequiredDelegationConnectorEditHelper.
 * 
 * @generated not
 */
public class RequiredDelegationConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getConfigureCommand(org
     * .eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest req) {
        RequiredDelegationConnector con = (RequiredDelegationConnector) req.getElementToConfigure();
        String name = "ReqDelegation ";
        name += con.getInnerRequiredRole_RequiredDelegationConnector() == null ? "" : con
                .getInnerRequiredRole_RequiredDelegationConnector().getEntityName();
        name += " -> ";
        name += con.getOuterRequiredRole_RequiredDelegationConnector() == null ? "" : con
                .getOuterRequiredRole_RequiredDelegationConnector().getEntityName();

        ICommand cmd2 = new SetValueCommand(new SetRequest(req.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), name));
        return cmd2;
    }
}