/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.*;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositorySwitch<T> {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected static RepositoryPackage modelPackage;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public RepositorySwitch() {
		if (modelPackage == null) {
			modelPackage = RepositoryPackage.eINSTANCE;
		}
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RepositoryPackage.PASSIVE_RESOURCE: {
				PassiveResource passiveResource = (PassiveResource)theEObject;
				T result = casePassiveResource(passiveResource);
				if (result == null) result = caseEntity(passiveResource);
				if (result == null) result = caseIdentifier(passiveResource);
				if (result == null) result = caseNamedElement(passiveResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.BASIC_COMPONENT: {
				BasicComponent basicComponent = (BasicComponent)theEObject;
				T result = caseBasicComponent(basicComponent);
				if (result == null) result = caseImplementationComponentType(basicComponent);
				if (result == null) result = caseRepositoryComponent(basicComponent);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(basicComponent);
				if (result == null) result = caseInterfaceProvidingEntity(basicComponent);
				if (result == null) result = caseInterfaceRequiringEntity(basicComponent);
				if (result == null) result = caseResourceInterfaceRequiringEntity(basicComponent);
				if (result == null) result = caseEntity(basicComponent);
				if (result == null) result = caseIdentifier(basicComponent);
				if (result == null) result = caseNamedElement(basicComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE: {
				ImplementationComponentType implementationComponentType = (ImplementationComponentType)theEObject;
				T result = caseImplementationComponentType(implementationComponentType);
				if (result == null) result = caseRepositoryComponent(implementationComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(implementationComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(implementationComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(implementationComponentType);
				if (result == null) result = caseResourceInterfaceRequiringEntity(implementationComponentType);
				if (result == null) result = caseEntity(implementationComponentType);
				if (result == null) result = caseIdentifier(implementationComponentType);
				if (result == null) result = caseNamedElement(implementationComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REPOSITORY_COMPONENT: {
				RepositoryComponent repositoryComponent = (RepositoryComponent)theEObject;
				T result = caseRepositoryComponent(repositoryComponent);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(repositoryComponent);
				if (result == null) result = caseInterfaceProvidingEntity(repositoryComponent);
				if (result == null) result = caseInterfaceRequiringEntity(repositoryComponent);
				if (result == null) result = caseResourceInterfaceRequiringEntity(repositoryComponent);
				if (result == null) result = caseEntity(repositoryComponent);
				if (result == null) result = caseIdentifier(repositoryComponent);
				if (result == null) result = caseNamedElement(repositoryComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDED_ROLE: {
				ProvidedRole providedRole = (ProvidedRole)theEObject;
				T result = caseProvidedRole(providedRole);
				if (result == null) result = caseRole(providedRole);
				if (result == null) result = caseEntity(providedRole);
				if (result == null) result = caseIdentifier(providedRole);
				if (result == null) result = caseNamedElement(providedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				T result = caseRepository(repository);
				if (result == null) result = caseEntity(repository);
				if (result == null) result = caseIdentifier(repository);
				if (result == null) result = caseNamedElement(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				T result = caseInterface(interface_);
				if (result == null) result = caseEntity(interface_);
				if (result == null) result = caseIdentifier(interface_);
				if (result == null) result = caseNamedElement(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REQUIRED_CHARACTERISATION: {
				RequiredCharacterisation requiredCharacterisation = (RequiredCharacterisation)theEObject;
				T result = caseRequiredCharacterisation(requiredCharacterisation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.EVENT_GROUP: {
				EventGroup eventGroup = (EventGroup)theEObject;
				T result = caseEventGroup(eventGroup);
				if (result == null) result = caseInterface(eventGroup);
				if (result == null) result = caseEntity(eventGroup);
				if (result == null) result = caseIdentifier(eventGroup);
				if (result == null) result = caseNamedElement(eventGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.EVENT_TYPE: {
				EventType eventType = (EventType)theEObject;
				T result = caseEventType(eventType);
				if (result == null) result = caseSignature(eventType);
				if (result == null) result = caseEntity(eventType);
				if (result == null) result = caseIdentifier(eventType);
				if (result == null) result = caseNamedElement(eventType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.SIGNATURE: {
				Signature signature = (Signature)theEObject;
				T result = caseSignature(signature);
				if (result == null) result = caseEntity(signature);
				if (result == null) result = caseIdentifier(signature);
				if (result == null) result = caseNamedElement(signature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.EXCEPTION_TYPE: {
				ExceptionType exceptionType = (ExceptionType)theEObject;
				T result = caseExceptionType(exceptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INFRASTRUCTURE_SIGNATURE: {
				InfrastructureSignature infrastructureSignature = (InfrastructureSignature)theEObject;
				T result = caseInfrastructureSignature(infrastructureSignature);
				if (result == null) result = caseSignature(infrastructureSignature);
				if (result == null) result = caseEntity(infrastructureSignature);
				if (result == null) result = caseIdentifier(infrastructureSignature);
				if (result == null) result = caseNamedElement(infrastructureSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INFRASTRUCTURE_INTERFACE: {
				InfrastructureInterface infrastructureInterface = (InfrastructureInterface)theEObject;
				T result = caseInfrastructureInterface(infrastructureInterface);
				if (result == null) result = caseInterface(infrastructureInterface);
				if (result == null) result = caseEntity(infrastructureInterface);
				if (result == null) result = caseIdentifier(infrastructureInterface);
				if (result == null) result = caseNamedElement(infrastructureInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE: {
				InfrastructureRequiredRole infrastructureRequiredRole = (InfrastructureRequiredRole)theEObject;
				T result = caseInfrastructureRequiredRole(infrastructureRequiredRole);
				if (result == null) result = caseRequiredRole(infrastructureRequiredRole);
				if (result == null) result = caseRole(infrastructureRequiredRole);
				if (result == null) result = caseEntity(infrastructureRequiredRole);
				if (result == null) result = caseIdentifier(infrastructureRequiredRole);
				if (result == null) result = caseNamedElement(infrastructureRequiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REQUIRED_ROLE: {
				RequiredRole requiredRole = (RequiredRole)theEObject;
				T result = caseRequiredRole(requiredRole);
				if (result == null) result = caseRole(requiredRole);
				if (result == null) result = caseEntity(requiredRole);
				if (result == null) result = caseIdentifier(requiredRole);
				if (result == null) result = caseNamedElement(requiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.OPERATION_SIGNATURE: {
				OperationSignature operationSignature = (OperationSignature)theEObject;
				T result = caseOperationSignature(operationSignature);
				if (result == null) result = caseSignature(operationSignature);
				if (result == null) result = caseEntity(operationSignature);
				if (result == null) result = caseIdentifier(operationSignature);
				if (result == null) result = caseNamedElement(operationSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.OPERATION_INTERFACE: {
				OperationInterface operationInterface = (OperationInterface)theEObject;
				T result = caseOperationInterface(operationInterface);
				if (result == null) result = caseInterface(operationInterface);
				if (result == null) result = caseEntity(operationInterface);
				if (result == null) result = caseIdentifier(operationInterface);
				if (result == null) result = caseNamedElement(operationInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.OPERATION_REQUIRED_ROLE: {
				OperationRequiredRole operationRequiredRole = (OperationRequiredRole)theEObject;
				T result = caseOperationRequiredRole(operationRequiredRole);
				if (result == null) result = caseRequiredRole(operationRequiredRole);
				if (result == null) result = caseRole(operationRequiredRole);
				if (result == null) result = caseEntity(operationRequiredRole);
				if (result == null) result = caseIdentifier(operationRequiredRole);
				if (result == null) result = caseNamedElement(operationRequiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.SOURCE_ROLE: {
				SourceRole sourceRole = (SourceRole)theEObject;
				T result = caseSourceRole(sourceRole);
				if (result == null) result = caseRequiredRole(sourceRole);
				if (result == null) result = caseRole(sourceRole);
				if (result == null) result = caseEntity(sourceRole);
				if (result == null) result = caseIdentifier(sourceRole);
				if (result == null) result = caseNamedElement(sourceRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.SINK_ROLE: {
				SinkRole sinkRole = (SinkRole)theEObject;
				T result = caseSinkRole(sinkRole);
				if (result == null) result = caseProvidedRole(sinkRole);
				if (result == null) result = caseRole(sinkRole);
				if (result == null) result = caseEntity(sinkRole);
				if (result == null) result = caseIdentifier(sinkRole);
				if (result == null) result = caseNamedElement(sinkRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.OPERATION_PROVIDED_ROLE: {
				OperationProvidedRole operationProvidedRole = (OperationProvidedRole)theEObject;
				T result = caseOperationProvidedRole(operationProvidedRole);
				if (result == null) result = caseProvidedRole(operationProvidedRole);
				if (result == null) result = caseRole(operationProvidedRole);
				if (result == null) result = caseEntity(operationProvidedRole);
				if (result == null) result = caseIdentifier(operationProvidedRole);
				if (result == null) result = caseNamedElement(operationProvidedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE: {
				InfrastructureProvidedRole infrastructureProvidedRole = (InfrastructureProvidedRole)theEObject;
				T result = caseInfrastructureProvidedRole(infrastructureProvidedRole);
				if (result == null) result = caseProvidedRole(infrastructureProvidedRole);
				if (result == null) result = caseRole(infrastructureProvidedRole);
				if (result == null) result = caseEntity(infrastructureProvidedRole);
				if (result == null) result = caseIdentifier(infrastructureProvidedRole);
				if (result == null) result = caseNamedElement(infrastructureProvidedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE: {
				CompleteComponentType completeComponentType = (CompleteComponentType)theEObject;
				T result = caseCompleteComponentType(completeComponentType);
				if (result == null) result = caseRepositoryComponent(completeComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(completeComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(completeComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(completeComponentType);
				if (result == null) result = caseResourceInterfaceRequiringEntity(completeComponentType);
				if (result == null) result = caseEntity(completeComponentType);
				if (result == null) result = caseIdentifier(completeComponentType);
				if (result == null) result = caseNamedElement(completeComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE: {
				ProvidesComponentType providesComponentType = (ProvidesComponentType)theEObject;
				T result = caseProvidesComponentType(providesComponentType);
				if (result == null) result = caseRepositoryComponent(providesComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(providesComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(providesComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(providesComponentType);
				if (result == null) result = caseResourceInterfaceRequiringEntity(providesComponentType);
				if (result == null) result = caseEntity(providesComponentType);
				if (result == null) result = caseIdentifier(providesComponentType);
				if (result == null) result = caseNamedElement(providesComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_COMPONENT: {
				CompositeComponent compositeComponent = (CompositeComponent)theEObject;
				T result = caseCompositeComponent(compositeComponent);
				if (result == null) result = caseComposedProvidingRequiringEntity(compositeComponent);
				if (result == null) result = caseImplementationComponentType(compositeComponent);
				if (result == null) result = caseComposedStructure(compositeComponent);
				if (result == null) result = caseRepositoryComponent(compositeComponent);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(compositeComponent);
				if (result == null) result = caseInterfaceProvidingEntity(compositeComponent);
				if (result == null) result = caseInterfaceRequiringEntity(compositeComponent);
				if (result == null) result = caseIdentifier(compositeComponent);
				if (result == null) result = caseNamedElement(compositeComponent);
				if (result == null) result = caseResourceInterfaceRequiringEntity(compositeComponent);
				if (result == null) result = caseEntity(compositeComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PRIMITIVE_DATA_TYPE: {
				PrimitiveDataType primitiveDataType = (PrimitiveDataType)theEObject;
				T result = casePrimitiveDataType(primitiveDataType);
				if (result == null) result = caseDataType(primitiveDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COLLECTION_DATA_TYPE: {
				CollectionDataType collectionDataType = (CollectionDataType)theEObject;
				T result = caseCollectionDataType(collectionDataType);
				if (result == null) result = caseEntity(collectionDataType);
				if (result == null) result = caseDataType(collectionDataType);
				if (result == null) result = caseIdentifier(collectionDataType);
				if (result == null) result = caseNamedElement(collectionDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_DATA_TYPE: {
				CompositeDataType compositeDataType = (CompositeDataType)theEObject;
				T result = caseCompositeDataType(compositeDataType);
				if (result == null) result = caseEntity(compositeDataType);
				if (result == null) result = caseDataType(compositeDataType);
				if (result == null) result = caseIdentifier(compositeDataType);
				if (result == null) result = caseNamedElement(compositeDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INNER_DECLARATION: {
				InnerDeclaration innerDeclaration = (InnerDeclaration)theEObject;
				T result = caseInnerDeclaration(innerDeclaration);
				if (result == null) result = caseNamedElement(innerDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.ROLE: {
				Role role = (Role)theEObject;
				T result = caseRole(role);
				if (result == null) result = caseEntity(role);
				if (result == null) result = caseIdentifier(role);
				if (result == null) result = caseNamedElement(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Passive Resource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passive Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePassiveResource(PassiveResource object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseBasicComponent(BasicComponent object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseImplementationComponentType(ImplementationComponentType object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRepositoryComponent(RepositoryComponent object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Required Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Required Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseRequiredRole(RequiredRole object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Role</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRole(Role object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Interface</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInterface(Interface object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Repository</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRepository(Repository object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataType(DataType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Required Characterisation</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Required Characterisation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseRequiredCharacterisation(RequiredCharacterisation object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameter(Parameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Signature</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseOperationSignature(OperationSignature object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Signature</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSignature(Signature object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseExceptionType(ExceptionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseOperationInterface(OperationInterface object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Signature</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInfrastructureSignature(InfrastructureSignature object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Required Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Required Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInfrastructureRequiredRole(InfrastructureRequiredRole object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Type</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventType(EventType object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Group</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventGroup(EventGroup object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCompleteComponentType(CompleteComponentType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Provides Component Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provides Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseProvidesComponentType(ProvidesComponentType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Required Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Required Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseOperationRequiredRole(OperationRequiredRole object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Source Role</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Source Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceRole(SourceRole object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Provided Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Provided Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInfrastructureProvidedRole(InfrastructureProvidedRole object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Provided Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Provided Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseOperationProvidedRole(OperationProvidedRole object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCompositeComponent(CompositeComponent object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sink Role</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sink Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSinkRole(SinkRole object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Data Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePrimitiveDataType(PrimitiveDataType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Data Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCollectionDataType(CollectionDataType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Data Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCompositeDataType(CompositeDataType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inner Declaration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inner Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInnerDeclaration(InnerDeclaration object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInfrastructureInterface(InfrastructureInterface object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Provided Role</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provided Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseProvidedRole(ProvidedRole object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseNamedElement(NamedElement object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInterfaceProvidingEntity(InterfaceProvidingEntity object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Requiring Entity</em>'.
	 * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInterfaceRequiringEntity(InterfaceRequiringEntity object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Interface Requiring Entity</em>'.
	 * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Interface Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseResourceInterfaceRequiringEntity(ResourceInterfaceRequiringEntity object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInterfaceProvidingRequiringEntity(InterfaceProvidingRequiringEntity object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseComposedStructure(ComposedStructure object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseComposedProvidingRequiringEntity(ComposedProvidingRequiringEntity object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
		return null;
	}

} // RepositorySwitch
