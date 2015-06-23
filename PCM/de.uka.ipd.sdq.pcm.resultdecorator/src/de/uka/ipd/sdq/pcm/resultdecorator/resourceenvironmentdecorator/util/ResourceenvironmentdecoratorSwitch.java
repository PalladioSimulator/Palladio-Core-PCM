/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

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
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage
 * @generated
 */
public class ResourceenvironmentdecoratorSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResourceenvironmentdecoratorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentdecoratorSwitch() {
		if (modelPackage == null) {
			modelPackage = ResourceenvironmentdecoratorPackage.eINSTANCE;
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
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS: {
				LinkingResourceResults linkingResourceResults = (LinkingResourceResults)theEObject;
				T result = caseLinkingResourceResults(linkingResourceResults);
				if (result == null) result = caseActiveResourceUtilisationResult(linkingResourceResults);
				if (result == null) result = caseUtilisationResult(linkingResourceResults);
				if (result == null) result = caseNamedElement(linkingResourceResults);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT: {
				ActiveResourceUtilisationResult activeResourceUtilisationResult = (ActiveResourceUtilisationResult)theEObject;
				T result = caseActiveResourceUtilisationResult(activeResourceUtilisationResult);
				if (result == null) result = caseUtilisationResult(activeResourceUtilisationResult);
				if (result == null) result = caseNamedElement(activeResourceUtilisationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT: {
				UtilisationResult utilisationResult = (UtilisationResult)theEObject;
				T result = caseUtilisationResult(utilisationResult);
				if (result == null) result = caseNamedElement(utilisationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS: {
				ResourceContainerResults resourceContainerResults = (ResourceContainerResults)theEObject;
				T result = caseResourceContainerResults(resourceContainerResults);
				if (result == null) result = caseActiveResourceUtilisationResult(resourceContainerResults);
				if (result == null) result = caseUtilisationResult(resourceContainerResults);
				if (result == null) result = caseNamedElement(resourceContainerResults);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT: {
				ProcessingResourceSpecificationResult processingResourceSpecificationResult = (ProcessingResourceSpecificationResult)theEObject;
				T result = caseProcessingResourceSpecificationResult(processingResourceSpecificationResult);
				if (result == null) result = caseActiveResourceUtilisationResult(processingResourceSpecificationResult);
				if (result == null) result = caseUtilisationResult(processingResourceSpecificationResult);
				if (result == null) result = caseNamedElement(processingResourceSpecificationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT: {
				PassiveResourceResult passiveResourceResult = (PassiveResourceResult)theEObject;
				T result = casePassiveResourceResult(passiveResourceResult);
				if (result == null) result = caseUtilisationResult(passiveResourceResult);
				if (result == null) result = caseNamedElement(passiveResourceResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linking Resource Results</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linking Resource Results</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkingResourceResults(LinkingResourceResults object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Active Resource Utilisation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Active Resource Utilisation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActiveResourceUtilisationResult(ActiveResourceUtilisationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Utilisation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Utilisation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUtilisationResult(UtilisationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Container Results</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Container Results</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceContainerResults(ResourceContainerResults object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Resource Specification Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Resource Specification Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingResourceSpecificationResult(ProcessingResourceSpecificationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Passive Resource Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passive Resource Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassiveResourceResult(PassiveResourceResult object) {
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

} //ResourceenvironmentdecoratorSwitch
