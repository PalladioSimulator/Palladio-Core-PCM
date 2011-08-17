/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.probespec.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class probespecFactoryImpl extends EFactoryImpl implements probespecFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static probespecFactory init() {
		try {
			probespecFactory theprobespecFactory = (probespecFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ProbeSpec/0.1"); 
			if (theprobespecFactory != null) {
				return theprobespecFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new probespecFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case probespecPackage.PASSIVE_RESOURCE_CALCULATOR: return createPassiveResourceCalculator();
			case probespecPackage.PROBE_SET: return createProbeSet();
			case probespecPackage.PASSIVE_RESOURCE_STATE_PROBE: return createPassiveResourceStateProbe();
			case probespecPackage.STO_EX_PROBE: return createStoExProbe();
			case probespecPackage.SEFF_PARAMETER_PROBE: return createSEFFParameterProbe();
			case probespecPackage.CURRENT_TIME_PROBE: return createCurrentTimeProbe();
			case probespecPackage.STO_EX_CALCULATOR: return createStoExCalculator();
			case probespecPackage.SEFF_PARAMETER_CALCULATOR: return createSEFFParameterCalculator();
			case probespecPackage.RESPONSE_TIME_CALCULATOR: return createResponseTimeCalculator();
			case probespecPackage.WAITING_TIME_CALCULATOR: return createWaitingTimeCalculator();
			case probespecPackage.PROBE_SPEC_REPOSITORY: return createProbeSpecRepository();
			case probespecPackage.CPU_STATE_PROBE: return createCPUStateProbe();
			case probespecPackage.HDD_STATE_PROBE: return createHDDStateProbe();
			case probespecPackage.CPU_DEMAND_PROBE: return createCPUDemandProbe();
			case probespecPackage.HDD_DEMAND_PROBE: return createHDDDemandProbe();
			case probespecPackage.HDD_STATE_CALCULATOR: return createHDDStateCalculator();
			case probespecPackage.CPU_STATE_CALCULATOR: return createCPUStateCalculator();
			case probespecPackage.CPU_DEMAND_CALCULATOR: return createCPUDemandCalculator();
			case probespecPackage.HDD_DEMAND_CALCULATOR: return createHDDDemandCalculator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case probespecPackage.PROBE_SET_POSITION:
				return createProbeSetPositionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case probespecPackage.PROBE_SET_POSITION:
				return convertProbeSetPositionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceCalculator createPassiveResourceCalculator() {
		PassiveResourceCalculatorImpl passiveResourceCalculator = new PassiveResourceCalculatorImpl();
		return passiveResourceCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSet createProbeSet() {
		ProbeSetImpl probeSet = new ProbeSetImpl();
		return probeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceStateProbe createPassiveResourceStateProbe() {
		PassiveResourceStateProbeImpl passiveResourceStateProbe = new PassiveResourceStateProbeImpl();
		return passiveResourceStateProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExProbe createStoExProbe() {
		StoExProbeImpl stoExProbe = new StoExProbeImpl();
		return stoExProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEFFParameterProbe createSEFFParameterProbe() {
		SEFFParameterProbeImpl seffParameterProbe = new SEFFParameterProbeImpl();
		return seffParameterProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentTimeProbe createCurrentTimeProbe() {
		CurrentTimeProbeImpl currentTimeProbe = new CurrentTimeProbeImpl();
		return currentTimeProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoExCalculator createStoExCalculator() {
		StoExCalculatorImpl stoExCalculator = new StoExCalculatorImpl();
		return stoExCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEFFParameterCalculator createSEFFParameterCalculator() {
		SEFFParameterCalculatorImpl seffParameterCalculator = new SEFFParameterCalculatorImpl();
		return seffParameterCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseTimeCalculator createResponseTimeCalculator() {
		ResponseTimeCalculatorImpl responseTimeCalculator = new ResponseTimeCalculatorImpl();
		return responseTimeCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitingTimeCalculator createWaitingTimeCalculator() {
		WaitingTimeCalculatorImpl waitingTimeCalculator = new WaitingTimeCalculatorImpl();
		return waitingTimeCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSpecRepository createProbeSpecRepository() {
		ProbeSpecRepositoryImpl probeSpecRepository = new ProbeSpecRepositoryImpl();
		return probeSpecRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUStateProbe createCPUStateProbe() {
		CPUStateProbeImpl cpuStateProbe = new CPUStateProbeImpl();
		return cpuStateProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HDDStateProbe createHDDStateProbe() {
		HDDStateProbeImpl hddStateProbe = new HDDStateProbeImpl();
		return hddStateProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUDemandProbe createCPUDemandProbe() {
		CPUDemandProbeImpl cpuDemandProbe = new CPUDemandProbeImpl();
		return cpuDemandProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HDDDemandProbe createHDDDemandProbe() {
		HDDDemandProbeImpl hddDemandProbe = new HDDDemandProbeImpl();
		return hddDemandProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HDDStateCalculator createHDDStateCalculator() {
		HDDStateCalculatorImpl hddStateCalculator = new HDDStateCalculatorImpl();
		return hddStateCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUStateCalculator createCPUStateCalculator() {
		CPUStateCalculatorImpl cpuStateCalculator = new CPUStateCalculatorImpl();
		return cpuStateCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUDemandCalculator createCPUDemandCalculator() {
		CPUDemandCalculatorImpl cpuDemandCalculator = new CPUDemandCalculatorImpl();
		return cpuDemandCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HDDDemandCalculator createHDDDemandCalculator() {
		HDDDemandCalculatorImpl hddDemandCalculator = new HDDDemandCalculatorImpl();
		return hddDemandCalculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSetPosition createProbeSetPositionFromString(EDataType eDataType, String initialValue) {
		ProbeSetPosition result = ProbeSetPosition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProbeSetPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecPackage getprobespecPackage() {
		return (probespecPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static probespecPackage getPackage() {
		return probespecPackage.eINSTANCE;
	}

} //probespecFactoryImpl
