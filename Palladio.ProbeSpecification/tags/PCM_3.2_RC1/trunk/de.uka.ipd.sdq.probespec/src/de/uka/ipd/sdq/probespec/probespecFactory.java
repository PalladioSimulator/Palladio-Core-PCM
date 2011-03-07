/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.probespec.probespecPackage
 * @generated
 */
public interface probespecFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	probespecFactory eINSTANCE = de.uka.ipd.sdq.probespec.impl.probespecFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Passive Resource Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource Calculator</em>'.
	 * @generated
	 */
	PassiveResourceCalculator createPassiveResourceCalculator();

	/**
	 * Returns a new object of class '<em>Probe Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probe Set</em>'.
	 * @generated
	 */
	ProbeSet createProbeSet();

	/**
	 * Returns a new object of class '<em>Passive Resource State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource State Probe</em>'.
	 * @generated
	 */
	PassiveResourceStateProbe createPassiveResourceStateProbe();

	/**
	 * Returns a new object of class '<em>Sto Ex Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sto Ex Probe</em>'.
	 * @generated
	 */
	StoExProbe createStoExProbe();

	/**
	 * Returns a new object of class '<em>SEFF Parameter Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SEFF Parameter Probe</em>'.
	 * @generated
	 */
	SEFFParameterProbe createSEFFParameterProbe();

	/**
	 * Returns a new object of class '<em>Current Time Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Current Time Probe</em>'.
	 * @generated
	 */
	CurrentTimeProbe createCurrentTimeProbe();

	/**
	 * Returns a new object of class '<em>Sto Ex Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sto Ex Calculator</em>'.
	 * @generated
	 */
	StoExCalculator createStoExCalculator();

	/**
	 * Returns a new object of class '<em>SEFF Parameter Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SEFF Parameter Calculator</em>'.
	 * @generated
	 */
	SEFFParameterCalculator createSEFFParameterCalculator();

	/**
	 * Returns a new object of class '<em>Response Time Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response Time Calculator</em>'.
	 * @generated
	 */
	ResponseTimeCalculator createResponseTimeCalculator();

	/**
	 * Returns a new object of class '<em>Waiting Time Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Waiting Time Calculator</em>'.
	 * @generated
	 */
	WaitingTimeCalculator createWaitingTimeCalculator();

	/**
	 * Returns a new object of class '<em>Probe Spec Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probe Spec Repository</em>'.
	 * @generated
	 */
	ProbeSpecRepository createProbeSpecRepository();

	/**
	 * Returns a new object of class '<em>CPU State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPU State Probe</em>'.
	 * @generated
	 */
	CPUStateProbe createCPUStateProbe();

	/**
	 * Returns a new object of class '<em>HDD State Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HDD State Probe</em>'.
	 * @generated
	 */
	HDDStateProbe createHDDStateProbe();

	/**
	 * Returns a new object of class '<em>CPU Demand Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPU Demand Probe</em>'.
	 * @generated
	 */
	CPUDemandProbe createCPUDemandProbe();

	/**
	 * Returns a new object of class '<em>HDD Demand Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HDD Demand Probe</em>'.
	 * @generated
	 */
	HDDDemandProbe createHDDDemandProbe();

	/**
	 * Returns a new object of class '<em>HDD State Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HDD State Calculator</em>'.
	 * @generated
	 */
	HDDStateCalculator createHDDStateCalculator();

	/**
	 * Returns a new object of class '<em>CPU State Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPU State Calculator</em>'.
	 * @generated
	 */
	CPUStateCalculator createCPUStateCalculator();

	/**
	 * Returns a new object of class '<em>CPU Demand Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPU Demand Calculator</em>'.
	 * @generated
	 */
	CPUDemandCalculator createCPUDemandCalculator();

	/**
	 * Returns a new object of class '<em>HDD Demand Calculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HDD Demand Calculator</em>'.
	 * @generated
	 */
	HDDDemandCalculator createHDDDemandCalculator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	probespecPackage getprobespecPackage();

} //probespecFactory
