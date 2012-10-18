/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;

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
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage
 * @generated
 */
public class EntitySwitch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EntityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitySwitch() {
		if (modelPackage == null) {
			modelPackage = EntityPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EntityPackage.RESOURCE_PROVIDED_ROLE: {
				ResourceProvidedRole resourceProvidedRole = (ResourceProvidedRole)theEObject;
				T result = caseResourceProvidedRole(resourceProvidedRole);
				if (result == null) result = caseRole(resourceProvidedRole);
				if (result == null) result = caseEntity(resourceProvidedRole);
				if (result == null) result = caseIdentifier(resourceProvidedRole);
				if (result == null) result = caseNamedElement(resourceProvidedRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY: {
				InterfaceProvidingRequiringEntity interfaceProvidingRequiringEntity = (InterfaceProvidingRequiringEntity)theEObject;
				T result = caseInterfaceProvidingRequiringEntity(interfaceProvidingRequiringEntity);
				if (result == null) result = caseInterfaceProvidingEntity(interfaceProvidingRequiringEntity);
				if (result == null) result = caseInterfaceRequiringEntity(interfaceProvidingRequiringEntity);
				if (result == null) result = caseResourceInterfaceRequiringEntity(interfaceProvidingRequiringEntity);
				if (result == null) result = caseEntity(interfaceProvidingRequiringEntity);
				if (result == null) result = caseIdentifier(interfaceProvidingRequiringEntity);
				if (result == null) result = caseNamedElement(interfaceProvidingRequiringEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.INTERFACE_PROVIDING_ENTITY: {
				InterfaceProvidingEntity interfaceProvidingEntity = (InterfaceProvidingEntity)theEObject;
				T result = caseInterfaceProvidingEntity(interfaceProvidingEntity);
				if (result == null) result = caseEntity(interfaceProvidingEntity);
				if (result == null) result = caseIdentifier(interfaceProvidingEntity);
				if (result == null) result = caseNamedElement(interfaceProvidingEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.INTERFACE_REQUIRING_ENTITY: {
				InterfaceRequiringEntity interfaceRequiringEntity = (InterfaceRequiringEntity)theEObject;
				T result = caseInterfaceRequiringEntity(interfaceRequiringEntity);
				if (result == null) result = caseResourceInterfaceRequiringEntity(interfaceRequiringEntity);
				if (result == null) result = caseEntity(interfaceRequiringEntity);
				if (result == null) result = caseIdentifier(interfaceRequiringEntity);
				if (result == null) result = caseNamedElement(interfaceRequiringEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY: {
				ResourceInterfaceRequiringEntity resourceInterfaceRequiringEntity = (ResourceInterfaceRequiringEntity)theEObject;
				T result = caseResourceInterfaceRequiringEntity(resourceInterfaceRequiringEntity);
				if (result == null) result = caseEntity(resourceInterfaceRequiringEntity);
				if (result == null) result = caseIdentifier(resourceInterfaceRequiringEntity);
				if (result == null) result = caseNamedElement(resourceInterfaceRequiringEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.RESOURCE_REQUIRED_ROLE: {
				ResourceRequiredRole resourceRequiredRole = (ResourceRequiredRole)theEObject;
				T result = caseResourceRequiredRole(resourceRequiredRole);
				if (result == null) result = caseRole(resourceRequiredRole);
				if (result == null) result = caseEntity(resourceRequiredRole);
				if (result == null) result = caseIdentifier(resourceRequiredRole);
				if (result == null) result = caseNamedElement(resourceRequiredRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY: {
				ResourceInterfaceProvidingEntity resourceInterfaceProvidingEntity = (ResourceInterfaceProvidingEntity)theEObject;
				T result = caseResourceInterfaceProvidingEntity(resourceInterfaceProvidingEntity);
				if (result == null) result = caseEntity(resourceInterfaceProvidingEntity);
				if (result == null) result = caseIdentifier(resourceInterfaceProvidingEntity);
				if (result == null) result = caseNamedElement(resourceInterfaceProvidingEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY: {
				ComposedProvidingRequiringEntity composedProvidingRequiringEntity = (ComposedProvidingRequiringEntity)theEObject;
				T result = caseComposedProvidingRequiringEntity(composedProvidingRequiringEntity);
				if (result == null) result = caseComposedStructure(composedProvidingRequiringEntity);
				if (result == null) result = caseInterfaceProvidingRequiringEntity(composedProvidingRequiringEntity);
				if (result == null) result = caseInterfaceProvidingEntity(composedProvidingRequiringEntity);
				if (result == null) result = caseInterfaceRequiringEntity(composedProvidingRequiringEntity);
				if (result == null) result = caseIdentifier(composedProvidingRequiringEntity);
				if (result == null) result = caseNamedElement(composedProvidingRequiringEntity);
				if (result == null) result = caseResourceInterfaceRequiringEntity(composedProvidingRequiringEntity);
				if (result == null) result = caseEntity(composedProvidingRequiringEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_REQUIRING_ENTITY: {
				ResourceInterfaceProvidingRequiringEntity resourceInterfaceProvidingRequiringEntity = (ResourceInterfaceProvidingRequiringEntity)theEObject;
				T result = caseResourceInterfaceProvidingRequiringEntity(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = caseResourceInterfaceRequiringEntity(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = caseResourceInterfaceProvidingEntity(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = caseEntity(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = caseIdentifier(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = caseNamedElement(resourceInterfaceProvidingRequiringEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseIdentifier(entity);
				if (result == null) result = caseNamedElement(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Provided Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Provided Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceProvidedRole(ResourceProvidedRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Interface Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Interface Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceInterfaceProvidingRequiringEntity(ResourceInterfaceProvidingRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Providing Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceProvidingEntity(InterfaceProvidingEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceProvidingRequiringEntity(InterfaceProvidingRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Interface Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceInterfaceRequiringEntity(ResourceInterfaceRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Required Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Required Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceRequiredRole(ResourceRequiredRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Providing Requiring Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Providing Requiring Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposedProvidingRequiringEntity(ComposedProvidingRequiringEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Interface Providing Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Interface Providing Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceInterfaceProvidingEntity(ResourceInterfaceProvidingEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposedStructure(ComposedStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EntitySwitch
