/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.pcm.repository.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositorySwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RepositoryPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositorySwitch() {
		if (modelPackage == null) {
			modelPackage = RepositoryPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RepositoryPackage.SIGNATURE: {
				Signature signature = (Signature)theEObject;
				Object result = caseSignature(signature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				Object result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				Object result = caseDataType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				Object result = caseRepository(repository);
				if (result == null) result = caseEntity(repository);
				if (result == null) result = caseIdentifier(repository);
				if (result == null) result = caseNamedElement(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE: {
				ProvidesComponentType providesComponentType = (ProvidesComponentType)theEObject;
				Object result = caseProvidesComponentType(providesComponentType);
				if (result == null) result = caseEntity(providesComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(providesComponentType);
				if (result == null) result = caseIdentifier(providesComponentType);
				if (result == null) result = caseNamedElement(providesComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(providesComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(providesComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REQUIRED_ROLE: {
				RequiredRole requiredRole = (RequiredRole)theEObject;
				Object result = caseRequiredRole(requiredRole);
				if (result == null) result = caseRole(requiredRole);
				if (result == null) result = caseEntity(requiredRole);
				if (result == null) result = caseIdentifier(requiredRole);
				if (result == null) result = caseNamedElement(requiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.ROLE: {
				Role role = (Role)theEObject;
				Object result = caseRole(role);
				if (result == null) result = caseEntity(role);
				if (result == null) result = caseIdentifier(role);
				if (result == null) result = caseNamedElement(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				Object result = caseInterface(interface_);
				if (result == null) result = caseEntity(interface_);
				if (result == null) result = caseIdentifier(interface_);
				if (result == null) result = caseNamedElement(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.EXCEPTION_TYPE: {
				ExceptionType exceptionType = (ExceptionType)theEObject;
				Object result = caseExceptionType(exceptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE: {
				ImplementationComponentType implementationComponentType = (ImplementationComponentType)theEObject;
				Object result = caseImplementationComponentType(implementationComponentType);
				if (result == null) result = caseCompleteComponentType(implementationComponentType);
				if (result == null) result = caseProvidesComponentType(implementationComponentType);
				if (result == null) result = caseEntity(implementationComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(implementationComponentType);
				if (result == null) result = caseIdentifier(implementationComponentType);
				if (result == null) result = caseNamedElement(implementationComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(implementationComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(implementationComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE: {
				CompleteComponentType completeComponentType = (CompleteComponentType)theEObject;
				Object result = caseCompleteComponentType(completeComponentType);
				if (result == null) result = caseProvidesComponentType(completeComponentType);
				if (result == null) result = caseEntity(completeComponentType);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(completeComponentType);
				if (result == null) result = caseIdentifier(completeComponentType);
				if (result == null) result = caseNamedElement(completeComponentType);
				if (result == null) result = caseInterfaceProvidingEntity(completeComponentType);
				if (result == null) result = caseInterfaceRequiringEntity(completeComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.DELEGATION_CONNECTOR: {
				DelegationConnector delegationConnector = (DelegationConnector)theEObject;
				Object result = caseDelegationConnector(delegationConnector);
				if (result == null) result = caseConnector(delegationConnector);
				if (result == null) result = caseEntity(delegationConnector);
				if (result == null) result = caseIdentifier(delegationConnector);
				if (result == null) result = caseNamedElement(delegationConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_COMPONENT: {
				CompositeComponent compositeComponent = (CompositeComponent)theEObject;
				Object result = caseCompositeComponent(compositeComponent);
				if (result == null) result = caseImplementationComponentType(compositeComponent);
				if (result == null) result = caseComposedStructure(compositeComponent);
				if (result == null) result = caseCompleteComponentType(compositeComponent);
				if (result == null) result = caseEntity(compositeComponent);
				if (result == null) result = caseProvidesComponentType(compositeComponent);
				if (result == null) result = caseIdentifier(compositeComponent);
				if (result == null) result = caseNamedElement(compositeComponent);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(compositeComponent);
				if (result == null) result = caseInterfaceProvidingEntity(compositeComponent);
				if (result == null) result = caseInterfaceRequiringEntity(compositeComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.BASIC_COMPONENT: {
				BasicComponent basicComponent = (BasicComponent)theEObject;
				Object result = caseBasicComponent(basicComponent);
				if (result == null) result = caseImplementationComponentType(basicComponent);
				if (result == null) result = caseCompleteComponentType(basicComponent);
				if (result == null) result = caseProvidesComponentType(basicComponent);
				if (result == null) result = caseEntity(basicComponent);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(basicComponent);
				if (result == null) result = caseIdentifier(basicComponent);
				if (result == null) result = caseNamedElement(basicComponent);
				if (result == null) result = caseInterfaceProvidingEntity(basicComponent);
				if (result == null) result = caseInterfaceRequiringEntity(basicComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PRIMITIVE_DATA_TYPE: {
				PrimitiveDataType primitiveDataType = (PrimitiveDataType)theEObject;
				Object result = casePrimitiveDataType(primitiveDataType);
				if (result == null) result = caseDataType(primitiveDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COLLECTION_DATA_TYPE: {
				CollectionDataType collectionDataType = (CollectionDataType)theEObject;
				Object result = caseCollectionDataType(collectionDataType);
				if (result == null) result = caseEntity(collectionDataType);
				if (result == null) result = caseDataType(collectionDataType);
				if (result == null) result = caseIdentifier(collectionDataType);
				if (result == null) result = caseNamedElement(collectionDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_DATA_TYPE: {
				CompositeDataType compositeDataType = (CompositeDataType)theEObject;
				Object result = caseCompositeDataType(compositeDataType);
				if (result == null) result = caseEntity(compositeDataType);
				if (result == null) result = caseDataType(compositeDataType);
				if (result == null) result = caseIdentifier(compositeDataType);
				if (result == null) result = caseNamedElement(compositeDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INNER_DECLARATION: {
				InnerDeclaration innerDeclaration = (InnerDeclaration)theEObject;
				Object result = caseInnerDeclaration(innerDeclaration);
				if (result == null) result = caseNamedElement(innerDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDED_ROLE: {
				ProvidedRole providedRole = (ProvidedRole)theEObject;
				Object result = caseProvidedRole(providedRole);
				if (result == null) result = caseRole(providedRole);
				if (result == null) result = caseEntity(providedRole);
				if (result == null) result = caseIdentifier(providedRole);
				if (result == null) result = caseNamedElement(providedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSignature(Signature object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRepository(Repository object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Provides Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Provides Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProvidesComponentType(ProvidesComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Required Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Required Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRequiredRole(RequiredRole object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Exception Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Exception Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExceptionType(ExceptionType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Implementation Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImplementationComponentType(ImplementationComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Complete Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompleteComponentType(CompleteComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Delegation Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDelegationConnector(DelegationConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composite Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeComponent(CompositeComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Basic Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBasicComponent(BasicComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveDataType(PrimitiveDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionDataType(CollectionDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Composite Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composite Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeDataType(CompositeDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Inner Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Inner Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInnerDeclaration(InnerDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Provided Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Provided Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProvidedRole(ProvidedRole object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfaceProvidingEntity(InterfaceProvidingEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Interface Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Interface Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfaceRequiringEntity(InterfaceRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfaceProvidingRequiringEntity(InterfaceProvidingRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Composed Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composed Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComposedStructure(ComposedStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //RepositorySwitch
