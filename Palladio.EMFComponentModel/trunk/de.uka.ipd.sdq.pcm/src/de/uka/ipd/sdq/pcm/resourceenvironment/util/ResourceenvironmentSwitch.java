/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.resourceenvironment.*;

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
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage
 * @generated
 */
public class ResourceenvironmentSwitch {
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
	protected static ResourceenvironmentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentSwitch() {
		if (modelPackage == null) {
			modelPackage = ResourceenvironmentPackage.eINSTANCE;
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
			case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT: {
				ResourceEnvironment resourceEnvironment = (ResourceEnvironment)theEObject;
				Object result = caseResourceEnvironment(resourceEnvironment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentPackage.LINKING_RESOURCE: {
				LinkingResource linkingResource = (LinkingResource)theEObject;
				Object result = caseLinkingResource(linkingResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION: {
				CommunicationLinkResourceSpecification communicationLinkResourceSpecification = (CommunicationLinkResourceSpecification)theEObject;
				Object result = caseCommunicationLinkResourceSpecification(communicationLinkResourceSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION: {
				ProcessingResourceSpecification processingResourceSpecification = (ProcessingResourceSpecification)theEObject;
				Object result = caseProcessingResourceSpecification(processingResourceSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION: {
				PassiveResourceSpecification passiveResourceSpecification = (PassiveResourceSpecification)theEObject;
				Object result = casePassiveResourceSpecification(passiveResourceSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentPackage.RESOURCE_CONTAINER: {
				ResourceContainer resourceContainer = (ResourceContainer)theEObject;
				Object result = caseResourceContainer(resourceContainer);
				if (result == null) result = caseEntity(resourceContainer);
				if (result == null) result = caseIdentifier(resourceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Resource Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Resource Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResourceEnvironment(ResourceEnvironment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Linking Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Linking Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLinkingResource(LinkingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Communication Link Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Communication Link Resource Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationLinkResourceSpecification(CommunicationLinkResourceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Processing Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Processing Resource Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessingResourceSpecification(ProcessingResourceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Passive Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Passive Resource Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePassiveResourceSpecification(PassiveResourceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Resource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResourceContainer(ResourceContainer object) {
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

} //ResourceenvironmentSwitch
