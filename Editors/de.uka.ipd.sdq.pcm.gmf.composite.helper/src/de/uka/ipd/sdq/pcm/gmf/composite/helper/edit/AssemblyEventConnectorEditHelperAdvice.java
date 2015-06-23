/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.helper.edit;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.palladiosimulator.pcm.core.composition.AssemblyEventConnector;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

/**
 * The Class AssemblyEventConnectorEditHelperAdvice.
 */
public class AssemblyEventConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

    /**
     * Get the configuration command for an AssemblyConnector.
     * 
     * This is modified manually to create the assumed name for the new connector.
     * 
     * @param req
     *            the req
     * @return the configure command
     * @generated not
     */
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest req) {
        AssemblyEventConnector con = (AssemblyEventConnector) req.getElementToConfigure();
        String name = "EventConnector ";
        name += con.getSourceAssemblyContext__AssemblyEventConnector() == null ? "" : con
                .getSourceAssemblyContext__AssemblyEventConnector().getEntityName();
        name += " -> ";
        name += con.getSinkAssemblyContext__AssemblyEventConnector() == null ? "" : con
                .getSinkAssemblyContext__AssemblyEventConnector().getEntityName();

        ICommand cmd2 = new SetValueCommand(new SetRequest(req.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), name));
        return cmd2;
    }
}
