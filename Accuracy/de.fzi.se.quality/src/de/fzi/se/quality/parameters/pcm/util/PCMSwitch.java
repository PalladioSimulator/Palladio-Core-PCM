/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.util;

import de.fzi.se.quality.parameters.BusinessOperationReference;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.InfrastructureOperationReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;

import de.fzi.se.quality.parameters.pcm.*;

import de.uka.ipd.sdq.identifier.Identifier;

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
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage
 * @generated
 */
public class PCMSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PCMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMSwitch() {
		if (modelPackage == null) {
			modelPackage = PCMPackage.eINSTANCE;
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
			case PCMPackage.PCM_PARAMETER_REFERENCE: {
				PCMParameterReference pcmParameterReference = (PCMParameterReference)theEObject;
				T result = casePCMParameterReference(pcmParameterReference);
				if (result == null) result = caseParameterReference(pcmParameterReference);
				if (result == null) result = caseIdentifier(pcmParameterReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_PARAMETER_VALUE: {
				PCMParameterValue pcmParameterValue = (PCMParameterValue)theEObject;
				T result = casePCMParameterValue(pcmParameterValue);
				if (result == null) result = caseParameterValue(pcmParameterValue);
				if (result == null) result = caseIdentifier(pcmParameterValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE: {
				PCMInfrastructureOperationReference pcmInfrastructureOperationReference = (PCMInfrastructureOperationReference)theEObject;
				T result = casePCMInfrastructureOperationReference(pcmInfrastructureOperationReference);
				if (result == null) result = caseInfrastructureOperationReference(pcmInfrastructureOperationReference);
				if (result == null) result = caseOperationReference(pcmInfrastructureOperationReference);
				if (result == null) result = caseIdentifier(pcmInfrastructureOperationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE: {
				PCMBusinessOperationReference pcmBusinessOperationReference = (PCMBusinessOperationReference)theEObject;
				T result = casePCMBusinessOperationReference(pcmBusinessOperationReference);
				if (result == null) result = caseBusinessOperationReference(pcmBusinessOperationReference);
				if (result == null) result = caseOperationReference(pcmBusinessOperationReference);
				if (result == null) result = caseIdentifier(pcmBusinessOperationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_COMPONENT_REFERENCE: {
				PCMComponentReference pcmComponentReference = (PCMComponentReference)theEObject;
				T result = casePCMComponentReference(pcmComponentReference);
				if (result == null) result = caseComponentReference(pcmComponentReference);
				if (result == null) result = caseIdentifier(pcmComponentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE: {
				PCMComponentParameterReference pcmComponentParameterReference = (PCMComponentParameterReference)theEObject;
				T result = casePCMComponentParameterReference(pcmComponentParameterReference);
				if (result == null) result = casePCMParameterReference(pcmComponentParameterReference);
				if (result == null) result = caseParameterReference(pcmComponentParameterReference);
				if (result == null) result = caseIdentifier(pcmComponentParameterReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE: {
				PCMOperationParameterReference pcmOperationParameterReference = (PCMOperationParameterReference)theEObject;
				T result = casePCMOperationParameterReference(pcmOperationParameterReference);
				if (result == null) result = casePCMParameterReference(pcmOperationParameterReference);
				if (result == null) result = caseParameterReference(pcmOperationParameterReference);
				if (result == null) result = caseIdentifier(pcmOperationParameterReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE: {
				PCMRequiredBusinessOperationReturnParameterReference pcmRequiredBusinessOperationReturnParameterReference = (PCMRequiredBusinessOperationReturnParameterReference)theEObject;
				T result = casePCMRequiredBusinessOperationReturnParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
				if (result == null) result = casePCMParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
				if (result == null) result = caseParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
				if (result == null) result = caseIdentifier(pcmRequiredBusinessOperationReturnParameterReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMParameterReference(PCMParameterReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMParameterValue(PCMParameterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMInfrastructureOperationReference(PCMInfrastructureOperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMBusinessOperationReference(PCMBusinessOperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMComponentReference(PCMComponentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMComponentParameterReference(PCMComponentParameterReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMOperationParameterReference(PCMOperationParameterReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Required Business Operation Return Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Required Business Operation Return Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMRequiredBusinessOperationReturnParameterReference(PCMRequiredBusinessOperationReturnParameterReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterReference(ParameterReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterValue(ParameterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationReference(OperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfrastructureOperationReference(InfrastructureOperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessOperationReference(BusinessOperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentReference(ComponentReference object) {
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

} //PCMSwitch
