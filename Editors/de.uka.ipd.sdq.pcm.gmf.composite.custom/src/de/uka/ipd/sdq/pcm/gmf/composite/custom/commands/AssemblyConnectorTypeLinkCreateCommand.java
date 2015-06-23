/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;

/**
 * This class has been moved from GMF2.x. GMF3.x does no longer generate it. FIXME: Can this class
 * be omitted?
 * 
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
}
