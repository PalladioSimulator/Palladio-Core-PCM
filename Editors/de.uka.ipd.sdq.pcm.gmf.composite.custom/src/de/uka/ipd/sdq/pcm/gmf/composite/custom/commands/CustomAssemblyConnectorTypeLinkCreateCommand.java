/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
//import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class CustomAssemblyConnectorTypeLinkCreateCommand.
 */
public class CustomAssemblyConnectorTypeLinkCreateCommand extends AssemblyConnectorTypeLinkCreateCommand {
    // these fields need to be defined again in the custom command
    // because generated visibility in the parent is private
    /** The my source. */
    private OperationRequiredRole mySource;

    /** The my target. */
    private OperationProvidedRole myTarget;

    /**
     * Instantiates a new custom assembly connector type link create command.
     * 
     * @param req
     *            the req
     * @param container
     *            the container
     * @param source
     *            the source
     * @param target
     *            the target
     */
    public CustomAssemblyConnectorTypeLinkCreateCommand(CreateRelationshipRequest req, ComposedStructure container,
            OperationRequiredRole source, OperationProvidedRole target) {
        super(req, container, source, target);
        mySource = source;
        myTarget = target;
    }

    /**
     * Do default element creation.
     * 
     * @return the e object
     * @generated not
     */
    protected EObject doDefaultElementCreation() {
        AssemblyConnector newElement = (AssemblyConnector) super.doDefaultElementCreation();
        if (newElement != null) {
            newElement.setProvidedRole_AssemblyConnector(myTarget);
            newElement.setRequiredRole_AssemblyConnector(mySource);
            CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
            newElement.setRequiringAssemblyContext_AssemblyConnector((AssemblyContext) req
                    .getParameter("REQ_CHILD_CONTEXT"));
            newElement.setProvidingAssemblyContext_AssemblyConnector((AssemblyContext) req
                    .getParameter("PROV_CHILD_CONTEXT"));
        }
        return newElement;
    }

}
