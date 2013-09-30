/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;

import org.eclipse.emf.ecore.EClass;
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
public class SimucomstatusFactoryImpl extends EFactoryImpl implements SimucomstatusFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimucomstatusFactory init() {
		try {
			SimucomstatusFactory theSimucomstatusFactory = (SimucomstatusFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/SimuComStatus/1.0"); 
			if (theSimucomstatusFactory != null) {
				return theSimucomstatusFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimucomstatusFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimucomstatusFactoryImpl() {
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
			case SimucomstatusPackage.SIMU_COM_STATUS: return createSimuComStatus();
			case SimucomstatusPackage.SIMULATED_PROCESSES: return createSimulatedProcesses();
			case SimucomstatusPackage.PROCESS: return createProcess();
			case SimucomstatusPackage.SIMULATED_RESOURCES: return createSimulatedResources();
			case SimucomstatusPackage.ACTIVE_RESOUCE: return createActiveResouce();
			case SimucomstatusPackage.WAIT_FOR_DEMAND: return createWaitForDemand();
			case SimucomstatusPackage.PASSIVE_RESOURCE: return createPassiveResource();
			case SimucomstatusPackage.WAIT_FOR_ACQUIRE: return createWaitForAcquire();
			case SimucomstatusPackage.WAIT_FOR_DELAY: return createWaitForDelay();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComStatus createSimuComStatus() {
		SimuComStatusImpl simuComStatus = new SimuComStatusImpl();
		return simuComStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedProcesses createSimulatedProcesses() {
		SimulatedProcessesImpl simulatedProcesses = new SimulatedProcessesImpl();
		return simulatedProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.simucomframework.simucomstatus.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedResources createSimulatedResources() {
		SimulatedResourcesImpl simulatedResources = new SimulatedResourcesImpl();
		return simulatedResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResouce createActiveResouce() {
		ActiveResouceImpl activeResouce = new ActiveResouceImpl();
		return activeResouce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitForDemand createWaitForDemand() {
		WaitForDemandImpl waitForDemand = new WaitForDemandImpl();
		return waitForDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource createPassiveResource() {
		PassiveResourceImpl passiveResource = new PassiveResourceImpl();
		return passiveResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitForAcquire createWaitForAcquire() {
		WaitForAcquireImpl waitForAcquire = new WaitForAcquireImpl();
		return waitForAcquire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitForDelay createWaitForDelay() {
		WaitForDelayImpl waitForDelay = new WaitForDelayImpl();
		return waitForDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimucomstatusPackage getSimucomstatusPackage() {
		return (SimucomstatusPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimucomstatusPackage getPackage() {
		return SimucomstatusPackage.eINSTANCE;
	}

} //SimucomstatusFactoryImpl
