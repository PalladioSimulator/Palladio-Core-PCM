/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * @generated
 */
public class AssemblyConnectorTypeLinkCreateCommand extends CreateRelationshipCommand {

    /**
     * @generated
     */
    private ComposedStructure myContainer;

    /**
     * @generated
     */
    private OperationRequiredRole mySource;

    /**
     * @generated
     */
    private OperationProvidedRole myTarget;

    /**
     * @generated
     */
    public AssemblyConnectorTypeLinkCreateCommand(CreateRelationshipRequest req, ComposedStructure container,
            OperationRequiredRole source, OperationProvidedRole target) {
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
