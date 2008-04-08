/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory
 * @model kind="package"
 * @generated
 */
public interface SimucomstatusPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simucomstatus";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/SimuComStatus/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simucomstatus";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimucomstatusPackage eINSTANCE = de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl <em>Simu Com Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimuComStatus()
	 * @generated
	 */
	int SIMU_COM_STATUS = 0;

	/**
	 * The feature id for the '<em><b>Process Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_STATUS__PROCESS_STATUS = 0;

	/**
	 * The feature id for the '<em><b>Resource Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_STATUS__RESOURCE_STATUS = 1;

	/**
	 * The feature id for the '<em><b>Current Simulation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_STATUS__CURRENT_SIMULATION_TIME = 2;

	/**
	 * The number of structural features of the '<em>Simu Com Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_STATUS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedProcessesImpl <em>Simulated Processes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedProcessesImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimulatedProcesses()
	 * @generated
	 */
	int SIMULATED_PROCESSES = 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_PROCESSES__PROCESSES = 0;

	/**
	 * The number of structural features of the '<em>Simulated Processes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_PROCESSES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 2;

	/**
	 * The feature id for the '<em><b>Current Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CURRENT_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ID = 1;

	/**
	 * The feature id for the '<em><b>Process Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PROCESS_START_TIME = 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Action Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_START_TIME = 0;

	/**
	 * The feature id for the '<em><b>Action Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_DURATION = 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl <em>Simulated Resources</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimulatedResources()
	 * @generated
	 */
	int SIMULATED_RESOURCES = 4;

	/**
	 * The feature id for the '<em><b>Active Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_RESOURCES__ACTIVE_RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Passive Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_RESOURCES__PASSIVE_RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>Simulated Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_RESOURCES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActiveResouceImpl <em>Active Resouce</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActiveResouceImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getActiveResouce()
	 * @generated
	 */
	int ACTIVE_RESOUCE = 5;

	/**
	 * The feature id for the '<em><b>Waiting Demands</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOUCE__WAITING_DEMANDS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOUCE__ID = 1;

	/**
	 * The number of structural features of the '<em>Active Resouce</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOUCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl <em>Wait For Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForDemand()
	 * @generated
	 */
	int WAIT_FOR_DEMAND = 6;

	/**
	 * The feature id for the '<em><b>Action Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DEMAND__ACTION_START_TIME = ACTION__ACTION_START_TIME;

	/**
	 * The feature id for the '<em><b>Action Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DEMAND__ACTION_DURATION = ACTION__ACTION_DURATION;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DEMAND__DEMAND = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DEMAND__RESOURCE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wait For Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DEMAND_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getPassiveResource()
	 * @generated
	 */
	int PASSIVE_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Waiting Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__WAITING_PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Initial Resource Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Resources Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__RESOURCES_AVAILABLE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__ID = 3;

	/**
	 * The number of structural features of the '<em>Passive Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForAcquireImpl <em>Wait For Acquire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForAcquireImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForAcquire()
	 * @generated
	 */
	int WAIT_FOR_ACQUIRE = 8;

	/**
	 * The feature id for the '<em><b>Action Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_ACQUIRE__ACTION_START_TIME = ACTION__ACTION_START_TIME;

	/**
	 * The feature id for the '<em><b>Action Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_ACQUIRE__ACTION_DURATION = ACTION__ACTION_DURATION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_ACQUIRE__RESOURCE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait For Acquire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_ACQUIRE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDelayImpl <em>Wait For Delay</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDelayImpl
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForDelay()
	 * @generated
	 */
	int WAIT_FOR_DELAY = 9;

	/**
	 * The feature id for the '<em><b>Action Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DELAY__ACTION_START_TIME = ACTION__ACTION_START_TIME;

	/**
	 * The feature id for the '<em><b>Action Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DELAY__ACTION_DURATION = ACTION__ACTION_DURATION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DELAY__DELAY = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait For Delay</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DELAY_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus <em>Simu Com Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simu Com Status</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus
	 * @generated
	 */
	EClass getSimuComStatus();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getProcessStatus <em>Process Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process Status</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getProcessStatus()
	 * @see #getSimuComStatus()
	 * @generated
	 */
	EReference getSimuComStatus_ProcessStatus();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getResourceStatus <em>Resource Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Status</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getResourceStatus()
	 * @see #getSimuComStatus()
	 * @generated
	 */
	EReference getSimuComStatus_ResourceStatus();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getCurrentSimulationTime <em>Current Simulation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Simulation Time</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getCurrentSimulationTime()
	 * @see #getSimuComStatus()
	 * @generated
	 */
	EAttribute getSimuComStatus_CurrentSimulationTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses <em>Simulated Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Processes</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses
	 * @generated
	 */
	EClass getSimulatedProcesses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses#getProcesses()
	 * @see #getSimulatedProcesses()
	 * @generated
	 */
	EReference getSimulatedProcesses_Processes();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getCurrentAction <em>Current Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current Action</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getCurrentAction()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_CurrentAction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getId()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getProcessStartTime <em>Process Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Start Time</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getProcessStartTime()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_ProcessStartTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionStartTime <em>Action Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Start Time</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionStartTime()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ActionStartTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionDuration <em>Action Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Duration</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionDuration()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ActionDuration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources <em>Simulated Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Resources</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources
	 * @generated
	 */
	EClass getSimulatedResources();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getActiveResources <em>Active Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Active Resources</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getActiveResources()
	 * @see #getSimulatedResources()
	 * @generated
	 */
	EReference getSimulatedResources_ActiveResources();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getPassiveResources <em>Passive Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Passive Resources</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getPassiveResources()
	 * @see #getSimulatedResources()
	 * @generated
	 */
	EReference getSimulatedResources_PassiveResources();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce <em>Active Resouce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Resouce</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce
	 * @generated
	 */
	EClass getActiveResouce();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getWaitingDemands <em>Waiting Demands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Waiting Demands</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getWaitingDemands()
	 * @see #getActiveResouce()
	 * @generated
	 */
	EReference getActiveResouce_WaitingDemands();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getId()
	 * @see #getActiveResouce()
	 * @generated
	 */
	EAttribute getActiveResouce_Id();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand <em>Wait For Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Demand</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand
	 * @generated
	 */
	EClass getWaitForDemand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getDemand()
	 * @see #getWaitForDemand()
	 * @generated
	 */
	EAttribute getWaitForDemand_Demand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource()
	 * @see #getWaitForDemand()
	 * @generated
	 */
	EReference getWaitForDemand_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource
	 * @generated
	 */
	EClass getPassiveResource();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getWaitingProcesses <em>Waiting Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Waiting Processes</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getWaitingProcesses()
	 * @see #getPassiveResource()
	 * @generated
	 */
	EReference getPassiveResource_WaitingProcesses();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getInitialResourceCount <em>Initial Resource Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Resource Count</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getInitialResourceCount()
	 * @see #getPassiveResource()
	 * @generated
	 */
	EAttribute getPassiveResource_InitialResourceCount();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getResourcesAvailable <em>Resources Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resources Available</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getResourcesAvailable()
	 * @see #getPassiveResource()
	 * @generated
	 */
	EAttribute getPassiveResource_ResourcesAvailable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getId()
	 * @see #getPassiveResource()
	 * @generated
	 */
	EAttribute getPassiveResource_Id();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire <em>Wait For Acquire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Acquire</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire
	 * @generated
	 */
	EClass getWaitForAcquire();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource()
	 * @see #getWaitForAcquire()
	 * @generated
	 */
	EReference getWaitForAcquire_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay <em>Wait For Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Delay</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay
	 * @generated
	 */
	EClass getWaitForDelay();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay#getDelay()
	 * @see #getWaitForDelay()
	 * @generated
	 */
	EAttribute getWaitForDelay_Delay();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimucomstatusFactory getSimucomstatusFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl <em>Simu Com Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimuComStatus()
		 * @generated
		 */
		EClass SIMU_COM_STATUS = eINSTANCE.getSimuComStatus();

		/**
		 * The meta object literal for the '<em><b>Process Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMU_COM_STATUS__PROCESS_STATUS = eINSTANCE.getSimuComStatus_ProcessStatus();

		/**
		 * The meta object literal for the '<em><b>Resource Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMU_COM_STATUS__RESOURCE_STATUS = eINSTANCE.getSimuComStatus_ResourceStatus();

		/**
		 * The meta object literal for the '<em><b>Current Simulation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMU_COM_STATUS__CURRENT_SIMULATION_TIME = eINSTANCE.getSimuComStatus_CurrentSimulationTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedProcessesImpl <em>Simulated Processes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedProcessesImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimulatedProcesses()
		 * @generated
		 */
		EClass SIMULATED_PROCESSES = eINSTANCE.getSimulatedProcesses();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATED_PROCESSES__PROCESSES = eINSTANCE.getSimulatedProcesses_Processes();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Current Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__CURRENT_ACTION = eINSTANCE.getProcess_CurrentAction();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__ID = eINSTANCE.getProcess_Id();

		/**
		 * The meta object literal for the '<em><b>Process Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__PROCESS_START_TIME = eINSTANCE.getProcess_ProcessStartTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Action Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__ACTION_START_TIME = eINSTANCE.getAction_ActionStartTime();

		/**
		 * The meta object literal for the '<em><b>Action Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__ACTION_DURATION = eINSTANCE.getAction_ActionDuration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl <em>Simulated Resources</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getSimulatedResources()
		 * @generated
		 */
		EClass SIMULATED_RESOURCES = eINSTANCE.getSimulatedResources();

		/**
		 * The meta object literal for the '<em><b>Active Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATED_RESOURCES__ACTIVE_RESOURCES = eINSTANCE.getSimulatedResources_ActiveResources();

		/**
		 * The meta object literal for the '<em><b>Passive Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATED_RESOURCES__PASSIVE_RESOURCES = eINSTANCE.getSimulatedResources_PassiveResources();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActiveResouceImpl <em>Active Resouce</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActiveResouceImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getActiveResouce()
		 * @generated
		 */
		EClass ACTIVE_RESOUCE = eINSTANCE.getActiveResouce();

		/**
		 * The meta object literal for the '<em><b>Waiting Demands</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVE_RESOUCE__WAITING_DEMANDS = eINSTANCE.getActiveResouce_WaitingDemands();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVE_RESOUCE__ID = eINSTANCE.getActiveResouce_Id();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl <em>Wait For Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForDemand()
		 * @generated
		 */
		EClass WAIT_FOR_DEMAND = eINSTANCE.getWaitForDemand();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_FOR_DEMAND__DEMAND = eINSTANCE.getWaitForDemand_Demand();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIT_FOR_DEMAND__RESOURCE = eINSTANCE.getWaitForDemand_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getPassiveResource()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE = eINSTANCE.getPassiveResource();

		/**
		 * The meta object literal for the '<em><b>Waiting Processes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSIVE_RESOURCE__WAITING_PROCESSES = eINSTANCE.getPassiveResource_WaitingProcesses();

		/**
		 * The meta object literal for the '<em><b>Initial Resource Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT = eINSTANCE.getPassiveResource_InitialResourceCount();

		/**
		 * The meta object literal for the '<em><b>Resources Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE__RESOURCES_AVAILABLE = eINSTANCE.getPassiveResource_ResourcesAvailable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE__ID = eINSTANCE.getPassiveResource_Id();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForAcquireImpl <em>Wait For Acquire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForAcquireImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForAcquire()
		 * @generated
		 */
		EClass WAIT_FOR_ACQUIRE = eINSTANCE.getWaitForAcquire();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIT_FOR_ACQUIRE__RESOURCE = eINSTANCE.getWaitForAcquire_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDelayImpl <em>Wait For Delay</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDelayImpl
		 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimucomstatusPackageImpl#getWaitForDelay()
		 * @generated
		 */
		EClass WAIT_FOR_DELAY = eINSTANCE.getWaitForDelay();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_FOR_DELAY__DELAY = eINSTANCE.getWaitForDelay_Delay();

	}

} //SimucomstatusPackage
