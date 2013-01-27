/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * @generated
 */
public class ProvidedDelegationConnectorTypeLinkCreateCommand extends CreateRelationshipCommand {

    /**
     * @generated
     */
    private ComposedStructure myContainer;

    /**
     * @generated
     */
    private OperationProvidedRole mySource;

    /**
     * @generated
     */
    private OperationProvidedRole myTarget;

    /**
     * @generated
     */
    public ProvidedDelegationConnectorTypeLinkCreateCommand(CreateRelationshipRequest req, ComposedStructure container,
            OperationProvidedRole source, OperationProvidedRole target) {
        super(req);
        super.setElementToEdit(container);
        myContainer = container;
        mySource = source;
        myTarget = target;
    }

    /**
     * @generated
     */
    public ComposedStructure getContainer() {
        return myContainer;
    }

    /**
     * @generated
     */
    public EObject getSource() {
        return mySource;
    }

    /**
     * @generated
     */
    public EObject getTarget() {
        return myTarget;
    }

    /**
     * @generated
     */
    protected EClass getEClassToEdit() {
        return CompositionPackage.eINSTANCE.getComposedStructure();
    }

    /**
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
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
            newElement.setInnerProvidedRole_ProvidedDelegationConnector(myTarget);
            newElement.setOuterProvidedRole_ProvidedDelegationConnector(mySource);
            CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
            newElement.setAssemblyContext_ProvidedDelegationConnector((AssemblyContext) req
                    .getParameter("CHILD_CONTEXT"));
        }
        return newElement;
    }

}
