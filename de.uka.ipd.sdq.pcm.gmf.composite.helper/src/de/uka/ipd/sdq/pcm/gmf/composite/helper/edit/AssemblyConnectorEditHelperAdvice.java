/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.helper.edit;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * The Class AssemblyConnectorEditHelperAdvice.
 */
public class AssemblyConnectorEditHelperAdvice extends AbstractEditHelperAdvice {
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
        AssemblyConnector con = (AssemblyConnector) req.getElementToConfigure();
        String name = "Connector ";
        name += con.getRequiringAssemblyContext_AssemblyConnector() == null ? "" : con
                .getRequiringAssemblyContext_AssemblyConnector().getEntityName();
        name += " -> ";
        name += con.getProvidingAssemblyContext_AssemblyConnector() == null ? "" : con
                .getProvidingAssemblyContext_AssemblyConnector().getEntityName();

        ICommand cmd2 = new SetValueCommand(new SetRequest(req.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), name));
        return cmd2;
    }

}