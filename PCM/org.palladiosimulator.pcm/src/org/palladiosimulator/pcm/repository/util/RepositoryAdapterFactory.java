/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.core.composition.ComposedStructure;

import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity;

import org.palladiosimulator.pcm.repository.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositoryAdapterFactory extends AdapterFactoryImpl {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static RepositoryPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RepositoryAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RepositoryPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RepositorySwitch<Adapter> modelSwitch = new RepositorySwitch<Adapter>() {

        @Override
        public Adapter casePassiveResource(PassiveResource object) {
            return createPassiveResourceAdapter();
        }

        @Override
        public Adapter caseBasicComponent(BasicComponent object) {
            return createBasicComponentAdapter();
        }

        @Override
        public Adapter caseImplementationComponentType(ImplementationComponentType object) {
            return createImplementationComponentTypeAdapter();
        }

        @Override
        public Adapter caseRepositoryComponent(RepositoryComponent object) {
            return createRepositoryComponentAdapter();
        }

        @Override
        public Adapter caseProvidedRole(ProvidedRole object) {
            return createProvidedRoleAdapter();
        }

        @Override
        public Adapter caseParameter(Parameter object) {
            return createParameterAdapter();
        }

        @Override
        public Adapter caseDataType(DataType object) {
            return createDataTypeAdapter();
        }

        @Override
        public Adapter caseRepository(Repository object) {
            return createRepositoryAdapter();
        }

        @Override
        public Adapter caseInterface(Interface object) {
            return createInterfaceAdapter();
        }

        @Override
        public Adapter caseRequiredCharacterisation(RequiredCharacterisation object) {
            return createRequiredCharacterisationAdapter();
        }

        @Override
        public Adapter caseEventGroup(EventGroup object) {
            return createEventGroupAdapter();
        }

        @Override
        public Adapter caseEventType(EventType object) {
            return createEventTypeAdapter();
        }

        @Override
        public Adapter caseSignature(Signature object) {
            return createSignatureAdapter();
        }

        @Override
        public Adapter caseExceptionType(ExceptionType object) {
            return createExceptionTypeAdapter();
        }

        @Override
        public Adapter caseInfrastructureSignature(InfrastructureSignature object) {
            return createInfrastructureSignatureAdapter();
        }

        @Override
        public Adapter caseInfrastructureInterface(InfrastructureInterface object) {
            return createInfrastructureInterfaceAdapter();
        }

        @Override
        public Adapter caseInfrastructureRequiredRole(InfrastructureRequiredRole object) {
            return createInfrastructureRequiredRoleAdapter();
        }

        @Override
        public Adapter caseRequiredRole(RequiredRole object) {
            return createRequiredRoleAdapter();
        }

        @Override
        public Adapter caseOperationSignature(OperationSignature object) {
            return createOperationSignatureAdapter();
        }

        @Override
        public Adapter caseOperationInterface(OperationInterface object) {
            return createOperationInterfaceAdapter();
        }

        @Override
        public Adapter caseOperationRequiredRole(OperationRequiredRole object) {
            return createOperationRequiredRoleAdapter();
        }

        @Override
        public Adapter caseSourceRole(SourceRole object) {
            return createSourceRoleAdapter();
        }

        @Override
        public Adapter caseSinkRole(SinkRole object) {
            return createSinkRoleAdapter();
        }

        @Override
        public Adapter caseOperationProvidedRole(OperationProvidedRole object) {
            return createOperationProvidedRoleAdapter();
        }

        @Override
        public Adapter caseInfrastructureProvidedRole(InfrastructureProvidedRole object) {
            return createInfrastructureProvidedRoleAdapter();
        }

        @Override
        public Adapter caseCompleteComponentType(CompleteComponentType object) {
            return createCompleteComponentTypeAdapter();
        }

        @Override
        public Adapter caseProvidesComponentType(ProvidesComponentType object) {
            return createProvidesComponentTypeAdapter();
        }

        @Override
        public Adapter caseCompositeComponent(CompositeComponent object) {
            return createCompositeComponentAdapter();
        }

        @Override
        public Adapter casePrimitiveDataType(PrimitiveDataType object) {
            return createPrimitiveDataTypeAdapter();
        }

        @Override
        public Adapter caseCollectionDataType(CollectionDataType object) {
            return createCollectionDataTypeAdapter();
        }

        @Override
        public Adapter caseCompositeDataType(CompositeDataType object) {
            return createCompositeDataTypeAdapter();
        }

        @Override
        public Adapter caseInnerDeclaration(InnerDeclaration object) {
            return createInnerDeclarationAdapter();
        }

        @Override
        public Adapter caseRole(Role object) {
            return createRoleAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter caseInterfaceProvidingEntity(InterfaceProvidingEntity object) {
            return createInterfaceProvidingEntityAdapter();
        }

        @Override
        public Adapter caseResourceInterfaceRequiringEntity(ResourceInterfaceRequiringEntity object) {
            return createResourceInterfaceRequiringEntityAdapter();
        }

        @Override
        public Adapter caseInterfaceRequiringEntity(InterfaceRequiringEntity object) {
            return createInterfaceRequiringEntityAdapter();
        }

        @Override
        public Adapter caseInterfaceProvidingRequiringEntity(InterfaceProvidingRequiringEntity object) {
            return createInterfaceProvidingRequiringEntityAdapter();
        }

        @Override
        public Adapter caseComposedStructure(ComposedStructure object) {
            return createComposedStructureAdapter();
        }

        @Override
        public Adapter caseComposedProvidingRequiringEntity(ComposedProvidingRequiringEntity object) {
            return createComposedProvidingRequiringEntityAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.PassiveResource <em>Passive Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.PassiveResource
     * @generated
     */
    public Adapter createPassiveResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.BasicComponent <em>Basic Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.BasicComponent
     * @generated
     */
    public Adapter createBasicComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.ImplementationComponentType <em>Implementation Component Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.ImplementationComponentType
     * @generated
     */
    public Adapter createImplementationComponentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.RepositoryComponent <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.RepositoryComponent
     * @generated
     */
    public Adapter createRepositoryComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.ProvidedRole <em>Provided Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.ProvidedRole
     * @generated
     */
    public Adapter createProvidedRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.Parameter
     * @generated
     */
    public Adapter createParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.DataType
     * @generated
     */
    public Adapter createDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.Repository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.Repository
     * @generated
     */
    public Adapter createRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.Interface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.Interface
     * @generated
     */
    public Adapter createInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.RequiredCharacterisation <em>Required Characterisation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.RequiredCharacterisation
     * @generated
     */
    public Adapter createRequiredCharacterisationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.EventGroup <em>Event Group</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.EventGroup
     * @generated
     */
    public Adapter createEventGroupAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.EventType <em>Event Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.EventType
     * @generated
     */
    public Adapter createEventTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.Signature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.Signature
     * @generated
     */
    public Adapter createSignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.ExceptionType <em>Exception Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.ExceptionType
     * @generated
     */
    public Adapter createExceptionTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.InfrastructureSignature <em>Infrastructure Signature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.InfrastructureSignature
     * @generated
     */
    public Adapter createInfrastructureSignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.InfrastructureInterface <em>Infrastructure Interface</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.InfrastructureInterface
     * @generated
     */
    public Adapter createInfrastructureInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.InfrastructureRequiredRole <em>Infrastructure Required Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.InfrastructureRequiredRole
     * @generated
     */
    public Adapter createInfrastructureRequiredRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.RequiredRole <em>Required Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.RequiredRole
     * @generated
     */
    public Adapter createRequiredRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.OperationSignature <em>Operation Signature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.OperationSignature
     * @generated
     */
    public Adapter createOperationSignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.OperationInterface <em>Operation Interface</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.OperationInterface
     * @generated
     */
    public Adapter createOperationInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.OperationRequiredRole <em>Operation Required Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.OperationRequiredRole
     * @generated
     */
    public Adapter createOperationRequiredRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.SourceRole <em>Source Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.SourceRole
     * @generated
     */
    public Adapter createSourceRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.SinkRole <em>Sink Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.SinkRole
     * @generated
     */
    public Adapter createSinkRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.OperationProvidedRole <em>Operation Provided Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.OperationProvidedRole
     * @generated
     */
    public Adapter createOperationProvidedRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.InfrastructureProvidedRole <em>Infrastructure Provided Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.InfrastructureProvidedRole
     * @generated
     */
    public Adapter createInfrastructureProvidedRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.CompleteComponentType <em>Complete Component Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.CompleteComponentType
     * @generated
     */
    public Adapter createCompleteComponentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.ProvidesComponentType <em>Provides Component Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.ProvidesComponentType
     * @generated
     */
    public Adapter createProvidesComponentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.CompositeComponent <em>Composite Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.CompositeComponent
     * @generated
     */
    public Adapter createCompositeComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.PrimitiveDataType <em>Primitive Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.PrimitiveDataType
     * @generated
     */
    public Adapter createPrimitiveDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.CollectionDataType <em>Collection Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.CollectionDataType
     * @generated
     */
    public Adapter createCollectionDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.CompositeDataType <em>Composite Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.CompositeDataType
     * @generated
     */
    public Adapter createCompositeDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.InnerDeclaration <em>Inner Declaration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.InnerDeclaration
     * @generated
     */
    public Adapter createInnerDeclarationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.repository.Role <em>Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.repository.Role
     * @generated
     */
    public Adapter createRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity <em>Interface Providing Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity
     * @generated
     */
    public Adapter createInterfaceProvidingEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity <em>Resource Interface Requiring Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity
     * @generated
     */
    public Adapter createResourceInterfaceRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity <em>Interface Requiring Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity
     * @generated
     */
    public Adapter createInterfaceRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity <em>Interface Providing Requiring Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity
     * @generated
     */
    public Adapter createInterfaceProvidingRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.composition.ComposedStructure <em>Composed Structure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.composition.ComposedStructure
     * @generated
     */
    public Adapter createComposedStructureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity <em>Composed Providing Requiring Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity
     * @generated
     */
    public Adapter createComposedProvidingRequiringEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //RepositoryAdapterFactory
