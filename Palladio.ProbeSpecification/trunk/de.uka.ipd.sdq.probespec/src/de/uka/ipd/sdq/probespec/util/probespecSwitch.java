/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.probespec.*;

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
 * @see de.uka.ipd.sdq.probespec.probespecPackage
 * @generated
 */
public class probespecSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static probespecPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecSwitch() {
		if (modelPackage == null) {
			modelPackage = probespecPackage.eINSTANCE;
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
			case probespecPackage.CALCULATOR: {
				Calculator calculator = (Calculator)theEObject;
				T result = caseCalculator(calculator);
				if (result == null) result = caseIdentifier(calculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.PASSIVE_RESOURCE_CALCULATOR: {
				PassiveResourceCalculator passiveResourceCalculator = (PassiveResourceCalculator)theEObject;
				T result = casePassiveResourceCalculator(passiveResourceCalculator);
				if (result == null) result = caseUnaryCalculator(passiveResourceCalculator);
				if (result == null) result = caseCalculator(passiveResourceCalculator);
				if (result == null) result = caseIdentifier(passiveResourceCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.UNARY_CALCULATOR: {
				UnaryCalculator unaryCalculator = (UnaryCalculator)theEObject;
				T result = caseUnaryCalculator(unaryCalculator);
				if (result == null) result = caseCalculator(unaryCalculator);
				if (result == null) result = caseIdentifier(unaryCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.PROBE_SET: {
				ProbeSet probeSet = (ProbeSet)theEObject;
				T result = caseProbeSet(probeSet);
				if (result == null) result = caseIdentifier(probeSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.PROBE: {
				Probe probe = (Probe)theEObject;
				T result = caseProbe(probe);
				if (result == null) result = caseIdentifier(probe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.PASSIVE_RESOURCE_STATE_PROBE: {
				PassiveResourceStateProbe passiveResourceStateProbe = (PassiveResourceStateProbe)theEObject;
				T result = casePassiveResourceStateProbe(passiveResourceStateProbe);
				if (result == null) result = caseProbe(passiveResourceStateProbe);
				if (result == null) result = caseIdentifier(passiveResourceStateProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.STO_EX_PROBE: {
				StoExProbe stoExProbe = (StoExProbe)theEObject;
				T result = caseStoExProbe(stoExProbe);
				if (result == null) result = caseProbe(stoExProbe);
				if (result == null) result = caseIdentifier(stoExProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.SEFF_PARAMETER_PROBE: {
				SEFFParameterProbe seffParameterProbe = (SEFFParameterProbe)theEObject;
				T result = caseSEFFParameterProbe(seffParameterProbe);
				if (result == null) result = caseProbe(seffParameterProbe);
				if (result == null) result = caseIdentifier(seffParameterProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.CURRENT_TIME_PROBE: {
				CurrentTimeProbe currentTimeProbe = (CurrentTimeProbe)theEObject;
				T result = caseCurrentTimeProbe(currentTimeProbe);
				if (result == null) result = caseProbe(currentTimeProbe);
				if (result == null) result = caseIdentifier(currentTimeProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.STO_EX_CALCULATOR: {
				StoExCalculator stoExCalculator = (StoExCalculator)theEObject;
				T result = caseStoExCalculator(stoExCalculator);
				if (result == null) result = caseUnaryCalculator(stoExCalculator);
				if (result == null) result = caseCalculator(stoExCalculator);
				if (result == null) result = caseIdentifier(stoExCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.SEFF_PARAMETER_CALCULATOR: {
				SEFFParameterCalculator seffParameterCalculator = (SEFFParameterCalculator)theEObject;
				T result = caseSEFFParameterCalculator(seffParameterCalculator);
				if (result == null) result = caseUnaryCalculator(seffParameterCalculator);
				if (result == null) result = caseCalculator(seffParameterCalculator);
				if (result == null) result = caseIdentifier(seffParameterCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.RESPONSE_TIME_CALCULATOR: {
				ResponseTimeCalculator responseTimeCalculator = (ResponseTimeCalculator)theEObject;
				T result = caseResponseTimeCalculator(responseTimeCalculator);
				if (result == null) result = caseBinaryCalculator(responseTimeCalculator);
				if (result == null) result = caseCalculator(responseTimeCalculator);
				if (result == null) result = caseIdentifier(responseTimeCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.BINARY_CALCULATOR: {
				BinaryCalculator binaryCalculator = (BinaryCalculator)theEObject;
				T result = caseBinaryCalculator(binaryCalculator);
				if (result == null) result = caseCalculator(binaryCalculator);
				if (result == null) result = caseIdentifier(binaryCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.WAITING_TIME_CALCULATOR: {
				WaitingTimeCalculator waitingTimeCalculator = (WaitingTimeCalculator)theEObject;
				T result = caseWaitingTimeCalculator(waitingTimeCalculator);
				if (result == null) result = caseBinaryCalculator(waitingTimeCalculator);
				if (result == null) result = caseCalculator(waitingTimeCalculator);
				if (result == null) result = caseIdentifier(waitingTimeCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.PROBE_SPEC_REPOSITORY: {
				ProbeSpecRepository probeSpecRepository = (ProbeSpecRepository)theEObject;
				T result = caseProbeSpecRepository(probeSpecRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.CPU_STATE_PROBE: {
				CPUStateProbe cpuStateProbe = (CPUStateProbe)theEObject;
				T result = caseCPUStateProbe(cpuStateProbe);
				if (result == null) result = caseProbe(cpuStateProbe);
				if (result == null) result = caseIdentifier(cpuStateProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.HDD_STATE_PROBE: {
				HDDStateProbe hddStateProbe = (HDDStateProbe)theEObject;
				T result = caseHDDStateProbe(hddStateProbe);
				if (result == null) result = caseProbe(hddStateProbe);
				if (result == null) result = caseIdentifier(hddStateProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.CPU_DEMAND_PROBE: {
				CPUDemandProbe cpuDemandProbe = (CPUDemandProbe)theEObject;
				T result = caseCPUDemandProbe(cpuDemandProbe);
				if (result == null) result = caseProbe(cpuDemandProbe);
				if (result == null) result = caseIdentifier(cpuDemandProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.HDD_DEMAND_PROBE: {
				HDDDemandProbe hddDemandProbe = (HDDDemandProbe)theEObject;
				T result = caseHDDDemandProbe(hddDemandProbe);
				if (result == null) result = caseProbe(hddDemandProbe);
				if (result == null) result = caseIdentifier(hddDemandProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.HDD_STATE_CALCULATOR: {
				HDDStateCalculator hddStateCalculator = (HDDStateCalculator)theEObject;
				T result = caseHDDStateCalculator(hddStateCalculator);
				if (result == null) result = caseUnaryCalculator(hddStateCalculator);
				if (result == null) result = caseCalculator(hddStateCalculator);
				if (result == null) result = caseIdentifier(hddStateCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.CPU_STATE_CALCULATOR: {
				CPUStateCalculator cpuStateCalculator = (CPUStateCalculator)theEObject;
				T result = caseCPUStateCalculator(cpuStateCalculator);
				if (result == null) result = caseUnaryCalculator(cpuStateCalculator);
				if (result == null) result = caseCalculator(cpuStateCalculator);
				if (result == null) result = caseIdentifier(cpuStateCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.CPU_DEMAND_CALCULATOR: {
				CPUDemandCalculator cpuDemandCalculator = (CPUDemandCalculator)theEObject;
				T result = caseCPUDemandCalculator(cpuDemandCalculator);
				if (result == null) result = caseUnaryCalculator(cpuDemandCalculator);
				if (result == null) result = caseCalculator(cpuDemandCalculator);
				if (result == null) result = caseIdentifier(cpuDemandCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probespecPackage.HDD_DEMAND_CALCULATOR: {
				HDDDemandCalculator hddDemandCalculator = (HDDDemandCalculator)theEObject;
				T result = caseHDDDemandCalculator(hddDemandCalculator);
				if (result == null) result = caseUnaryCalculator(hddDemandCalculator);
				if (result == null) result = caseCalculator(hddDemandCalculator);
				if (result == null) result = caseIdentifier(hddDemandCalculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculator(Calculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Passive Resource Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passive Resource Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassiveResourceCalculator(PassiveResourceCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryCalculator(UnaryCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probe Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probe Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbeSet(ProbeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbe(Probe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Passive Resource State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passive Resource State Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassiveResourceStateProbe(PassiveResourceStateProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sto Ex Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sto Ex Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoExProbe(StoExProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SEFF Parameter Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SEFF Parameter Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSEFFParameterProbe(SEFFParameterProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Current Time Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Current Time Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCurrentTimeProbe(CurrentTimeProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sto Ex Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sto Ex Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoExCalculator(StoExCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SEFF Parameter Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SEFF Parameter Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSEFFParameterCalculator(SEFFParameterCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response Time Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response Time Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponseTimeCalculator(ResponseTimeCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryCalculator(BinaryCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Waiting Time Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Waiting Time Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitingTimeCalculator(WaitingTimeCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probe Spec Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probe Spec Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbeSpecRepository(ProbeSpecRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPU State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPU State Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPUStateProbe(CPUStateProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HDD State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HDD State Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHDDStateProbe(HDDStateProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPU Demand Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPU Demand Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPUDemandProbe(CPUDemandProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HDD Demand Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HDD Demand Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHDDDemandProbe(HDDDemandProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HDD State Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HDD State Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHDDStateCalculator(HDDStateCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPU State Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPU State Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPUStateCalculator(CPUStateCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPU Demand Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPU Demand Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPUDemandCalculator(CPUDemandCalculator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HDD Demand Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HDD Demand Calculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHDDDemandCalculator(HDDDemandCalculator object) {
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

} //probespecSwitch
