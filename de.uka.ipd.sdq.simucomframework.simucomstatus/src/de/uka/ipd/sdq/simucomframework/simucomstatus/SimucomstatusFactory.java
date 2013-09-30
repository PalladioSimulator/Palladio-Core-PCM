/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage
 * @generated
 */
public interface SimucomstatusFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimucomstatusFactory eINSTANCE = de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simu Com Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simu Com Status</em>'.
	 * @generated
	 */
	SimuComStatus createSimuComStatus();

	/**
	 * Returns a new object of class '<em>Simulated Processes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Processes</em>'.
	 * @generated
	 */
	SimulatedProcesses createSimulatedProcesses();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	de.uka.ipd.sdq.simucomframework.simucomstatus.Process createProcess();

	/**
	 * Returns a new object of class '<em>Simulated Resources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Resources</em>'.
	 * @generated
	 */
	SimulatedResources createSimulatedResources();

	/**
	 * Returns a new object of class '<em>Active Resouce</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Resouce</em>'.
	 * @generated
	 */
	ActiveResouce createActiveResouce();

	/**
	 * Returns a new object of class '<em>Wait For Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Demand</em>'.
	 * @generated
	 */
	WaitForDemand createWaitForDemand();

	/**
	 * Returns a new object of class '<em>Passive Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource</em>'.
	 * @generated
	 */
	PassiveResource createPassiveResource();

	/**
	 * Returns a new object of class '<em>Wait For Acquire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Acquire</em>'.
	 * @generated
	 */
	WaitForAcquire createWaitForAcquire();

	/**
	 * Returns a new object of class '<em>Wait For Delay</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Delay</em>'.
	 * @generated
	 */
	WaitForDelay createWaitForDelay();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimucomstatusPackage getSimucomstatusPackage();

} //SimucomstatusFactory
