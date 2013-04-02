/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

public class CustomProvidedDelegationConnectorTypeLinkCreateCommand extends ProvidedDelegationConnectorTypeLinkCreateCommand {
    public CustomProvidedDelegationConnectorTypeLinkCreateCommand(
			CreateRelationshipRequest req, ComposedStructure container,
			OperationProvidedRole source, OperationProvidedRole target) {
		super(req, container, source, target);
	}

	/**
     * Do default element creation.
     * 
     * @return the e object
     * @generated not
     */
    protected EObject doDefaultElementCreation() {
        ProvidedDelegationConnector newElement = (ProvidedDelegationConnector) super.doDefaultElementCreation();
        if (newElement != null) {
            newElement.setInnerProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) getTarget());
            newElement.setOuterProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) getSource());
            CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
            newElement.setAssemblyContext_ProvidedDelegationConnector((AssemblyContext) req
                    .getParameter("CHILD_CONTEXT"));
        }
        return newElement;
    }

}
