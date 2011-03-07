/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.*;

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
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage
 * @generated
 */
public class RawResourceDemandCountsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RawResourceDemandCountsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandCountsSwitch() {
		if (modelPackage == null) {
			modelPackage = RawResourceDemandCountsPackage.eINSTANCE;
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK: {
				RawResourceDemandsLink rawResourceDemandsLink = (RawResourceDemandsLink)theEObject;
				T result = caseRawResourceDemandsLink(rawResourceDemandsLink);
				if (result == null) result = caseIdentifier(rawResourceDemandsLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN: {
				BytecodeMonitoringRun bytecodeMonitoringRun = (BytecodeMonitoringRun)theEObject;
				T result = caseBytecodeMonitoringRun(bytecodeMonitoringRun);
				if (result == null) result = caseIdentifier(bytecodeMonitoringRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.MEASURED_COUNT: {
				MeasuredCount measuredCount = (MeasuredCount)theEObject;
				T result = caseMeasuredCount(measuredCount);
				if (result == null) result = caseIdentifier(measuredCount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.PARAMETER_VALUE: {
				ParameterValue parameterValue = (ParameterValue)theEObject;
				T result = caseParameterValue(parameterValue);
				if (result == null) result = caseIdentifier(parameterValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE: {
				MeasuredCharacterisationValue measuredCharacterisationValue = (MeasuredCharacterisationValue)theEObject;
				T result = caseMeasuredCharacterisationValue(measuredCharacterisationValue);
				if (result == null) result = caseIdentifier(measuredCharacterisationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION: {
				EnvironmentCharacterisation environmentCharacterisation = (EnvironmentCharacterisation)theEObject;
				T result = caseEnvironmentCharacterisation(environmentCharacterisation);
				if (result == null) result = caseIdentifier(environmentCharacterisation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY: {
				RawResourceDemandsRepository rawResourceDemandsRepository = (RawResourceDemandsRepository)theEObject;
				T result = caseRawResourceDemandsRepository(rawResourceDemandsRepository);
				if (result == null) result = caseIdentifier(rawResourceDemandsRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.DOUBLE_CHARACTERISATION_VALUE: {
				DoubleCharacterisationValue doubleCharacterisationValue = (DoubleCharacterisationValue)theEObject;
				T result = caseDoubleCharacterisationValue(doubleCharacterisationValue);
				if (result == null) result = caseMeasuredCharacterisationValue(doubleCharacterisationValue);
				if (result == null) result = caseIdentifier(doubleCharacterisationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.LONG_CHARACTERISATION_VALUE: {
				LongCharacterisationValue longCharacterisationValue = (LongCharacterisationValue)theEObject;
				T result = caseLongCharacterisationValue(longCharacterisationValue);
				if (result == null) result = caseMeasuredCharacterisationValue(longCharacterisationValue);
				if (result == null) result = caseIdentifier(longCharacterisationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RawResourceDemandCountsPackage.BOOLEAN_CHARACTERISATION_VALUE: {
				BooleanCharacterisationValue booleanCharacterisationValue = (BooleanCharacterisationValue)theEObject;
				T result = caseBooleanCharacterisationValue(booleanCharacterisationValue);
				if (result == null) result = caseMeasuredCharacterisationValue(booleanCharacterisationValue);
				if (result == null) result = caseIdentifier(booleanCharacterisationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Resource Demands Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Resource Demands Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawResourceDemandsLink(RawResourceDemandsLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bytecode Monitoring Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bytecode Monitoring Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBytecodeMonitoringRun(BytecodeMonitoringRun object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measured Count</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measured Count</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasuredCount(MeasuredCount object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Measured Characterisation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measured Characterisation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasuredCharacterisationValue(MeasuredCharacterisationValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment Characterisation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment Characterisation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnvironmentCharacterisation(EnvironmentCharacterisation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Resource Demands Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Resource Demands Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawResourceDemandsRepository(RawResourceDemandsRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Characterisation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Characterisation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleCharacterisationValue(DoubleCharacterisationValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Characterisation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Characterisation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongCharacterisationValue(LongCharacterisationValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Characterisation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Characterisation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanCharacterisationValue(BooleanCharacterisationValue object) {
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

} //RawResourceDemandCountsSwitch
