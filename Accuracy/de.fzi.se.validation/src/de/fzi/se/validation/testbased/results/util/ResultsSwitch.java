/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.util;

import de.fzi.se.validation.testbased.results.*;

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
 * @see de.fzi.se.validation.testbased.results.ResultsPackage
 * @generated
 */
public class ResultsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResultsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsSwitch() {
		if (modelPackage == null) {
			modelPackage = ResultsPackage.eINSTANCE;
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
			case ResultsPackage.VALIDATION_FAILURE_NOTICE: {
				ValidationFailureNotice validationFailureNotice = (ValidationFailureNotice)theEObject;
				T result = caseValidationFailureNotice(validationFailureNotice);
				if (result == null) result = caseIdentifier(validationFailureNotice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResultsPackage.PARAMETER_VFN: {
				ParameterVFN parameterVFN = (ParameterVFN)theEObject;
				T result = caseParameterVFN(parameterVFN);
				if (result == null) result = caseValidationFailureNotice(parameterVFN);
				if (result == null) result = caseIdentifier(parameterVFN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN: {
				InfrastructureCallVFN infrastructureCallVFN = (InfrastructureCallVFN)theEObject;
				T result = caseInfrastructureCallVFN(infrastructureCallVFN);
				if (result == null) result = caseValidationFailureNotice(infrastructureCallVFN);
				if (result == null) result = caseIdentifier(infrastructureCallVFN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResultsPackage.EXTERNAL_CALL_VFN: {
				ExternalCallVFN externalCallVFN = (ExternalCallVFN)theEObject;
				T result = caseExternalCallVFN(externalCallVFN);
				if (result == null) result = caseValidationFailureNotice(externalCallVFN);
				if (result == null) result = caseIdentifier(externalCallVFN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResultsPackage.EXECUTION_TRACE_VFN: {
				ExecutionTraceVFN executionTraceVFN = (ExecutionTraceVFN)theEObject;
				T result = caseExecutionTraceVFN(executionTraceVFN);
				if (result == null) result = caseValidationFailureNotice(executionTraceVFN);
				if (result == null) result = caseIdentifier(executionTraceVFN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResultsPackage.RUN_PROTOCOL: {
				RunProtocol runProtocol = (RunProtocol)theEObject;
				T result = caseRunProtocol(runProtocol);
				if (result == null) result = caseIdentifier(runProtocol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validation Failure Notice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validation Failure Notice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidationFailureNotice(ValidationFailureNotice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter VFN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter VFN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterVFN(ParameterVFN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Call VFN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Call VFN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfrastructureCallVFN(InfrastructureCallVFN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Call VFN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Call VFN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalCallVFN(ExternalCallVFN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Trace VFN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Trace VFN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionTraceVFN(ExecutionTraceVFN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Run Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunProtocol(RunProtocol object) {
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

} //ResultsSwitch
