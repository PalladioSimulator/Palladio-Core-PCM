/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

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
			case RepositoryPackage.EXCEPTION_TYPE: {
				ExceptionType exceptionType = (ExceptionType)theEObject;
				Object result = caseExceptionType(exceptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.ROLE: {
				Role role = (Role)theEObject;
				Object result = caseRole(role);
				if (result == null) result = caseEntity(role);
				if (result == null) result = caseIdentifier(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REQUIRED_ROLE: {
				RequiredRole requiredRole = (RequiredRole)theEObject;
				Object result = caseRequiredRole(requiredRole);
				if (result == null) result = caseRole(requiredRole);
				if (result == null) result = caseEntity(requiredRole);
				if (result == null) result = caseIdentifier(requiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				Object result = caseInterface(interface_);
				if (result == null) result = caseEntity(interface_);
				if (result == null) result = caseIdentifier(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR: {
				RequiredDelegationConnector requiredDelegationConnector = (RequiredDelegationConnector)theEObject;
				Object result = caseRequiredDelegationConnector(requiredDelegationConnector);
				if (result == null) result = caseDelegationConnector(requiredDelegationConnector);
				if (result == null) result = caseConnector(requiredDelegationConnector);
				if (result == null) result = caseEntity(requiredDelegationConnector);
				if (result == null) result = caseIdentifier(requiredDelegationConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.DELEGATION_CONNECTOR: {
				DelegationConnector delegationConnector = (DelegationConnector)theEObject;
				Object result = caseDelegationConnector(delegationConnector);
				if (result == null) result = caseConnector(delegationConnector);
				if (result == null) result = caseEntity(delegationConnector);
				if (result == null) result = caseIdentifier(delegationConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT: {
				ChildComponentContext childComponentContext = (ChildComponentContext)theEObject;
				Object result = caseChildComponentContext(childComponentContext);
				if (result == null) result = caseEntity(childComponentContext);
				if (result == null) result = caseIdentifier(childComponentContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				Object result = caseRepository(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDED_ROLE: {
				ProvidedRole providedRole = (ProvidedRole)theEObject;
				Object result = caseProvidedRole(providedRole);
				if (result == null) result = caseRole(providedRole);
				if (result == null) result = caseEntity(providedRole);
				if (result == null) result = caseIdentifier(providedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDED_DELEGATION_CONNECTOR: {
				ProvidedDelegationConnector providedDelegationConnector = (ProvidedDelegationConnector)theEObject;
				Object result = caseProvidedDelegationConnector(providedDelegationConnector);
				if (result == null) result = caseDelegationConnector(providedDelegationConnector);
				if (result == null) result = caseConnector(providedDelegationConnector);
				if (result == null) result = caseEntity(providedDelegationConnector);
				if (result == null) result = caseIdentifier(providedDelegationConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE: {
				ImplementationComponentType implementationComponentType = (ImplementationComponentType)theEObject;
				Object result = caseImplementationComponentType(implementationComponentType);
				if (result == null) result = caseCompleteComponentType(implementationComponentType);
				if (result == null) result = caseProvidesComponentType(implementationComponentType);
				if (result == null) result = caseEntity(implementationComponentType);
				if (result == null) result = caseIdentifier(implementationComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE: {
				CompleteComponentType completeComponentType = (CompleteComponentType)theEObject;
				Object result = caseCompleteComponentType(completeComponentType);
				if (result == null) result = caseProvidesComponentType(completeComponentType);
				if (result == null) result = caseEntity(completeComponentType);
				if (result == null) result = caseIdentifier(completeComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_COMPONENT: {
				CompositeComponent compositeComponent = (CompositeComponent)theEObject;
				Object result = caseCompositeComponent(compositeComponent);
				if (result == null) result = caseImplementationComponentType(compositeComponent);
				if (result == null) result = caseCompleteComponentType(compositeComponent);
				if (result == null) result = caseProvidesComponentType(compositeComponent);
				if (result == null) result = caseEntity(compositeComponent);
				if (result == null) result = caseIdentifier(compositeComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.COMPOSITE_ASSEMBLY_CONNECTOR: {
				CompositeAssemblyConnector compositeAssemblyConnector = (CompositeAssemblyConnector)theEObject;
				Object result = caseCompositeAssemblyConnector(compositeAssemblyConnector);
				if (result == null) result = caseConnector(compositeAssemblyConnector);
				if (result == null) result = caseEntity(compositeAssemblyConnector);
				if (result == null) result = caseIdentifier(compositeAssemblyConnector);
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
				if (result == null) result = caseIdentifier(basicComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE: {
				ProvidesComponentType providesComponentType = (ProvidesComponentType)theEObject;
				Object result = caseProvidesComponentType(providesComponentType);
				if (result == null) result = caseEntity(providesComponentType);
				if (result == null) result = caseIdentifier(providesComponentType);
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
	 * Returns the result of interpretting the object as an instance of '<em>Required Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Required Delegation Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRequiredDelegationConnector(RequiredDelegationConnector object) {
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
	 * Returns the result of interpretting the object as an instance of '<em>Child Component Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Child Component Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseChildComponentContext(ChildComponentContext object) {
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
	 * Returns the result of interpretting the object as an instance of '<em>Provided Delegation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Provided Delegation Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProvidedDelegationConnector(ProvidedDelegationConnector object) {
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
	 * Returns the result of interpretting the object as an instance of '<em>Composite Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composite Assembly Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeAssemblyConnector(CompositeAssemblyConnector object) {
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
