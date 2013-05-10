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
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * This class has been moved from GMF2.x. GMF3.x does no longer generate it. FIXME: Can this class
 * be omitted?
 * 
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

}
