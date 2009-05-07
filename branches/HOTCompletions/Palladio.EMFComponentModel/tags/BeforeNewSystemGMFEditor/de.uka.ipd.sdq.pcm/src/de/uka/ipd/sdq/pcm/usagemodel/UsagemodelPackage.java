/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory
 * @model kind="package"
 * @generated
 */
public interface UsagemodelPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usagemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/UsageModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.usagemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsagemodelPackage eINSTANCE = de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.WorkloadImpl <em>Workload</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.WorkloadImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getWorkload()
	 * @generated
	 */
	int WORKLOAD = 0;

	/**
	 * The number of structural features of the '<em>Workload</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl <em>Usage Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getUsageScenario()
	 * @generated
	 */
	int USAGE_SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_SCENARIO__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_SCENARIO__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Workload Usage Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenario Behaviour Usage Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Usage Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_SCENARIO_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl <em>Scenario Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getScenarioBehaviour()
	 * @generated
	 */
	int SCENARIO_BEHAVIOUR = 2;

	/**
	 * The feature id for the '<em><b>Actions Scenario Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR = 0;

	/**
	 * The number of structural features of the '<em>Scenario Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_BEHAVIOUR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl <em>Abstract User Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getAbstractUserAction()
	 * @generated
	 */
	int ABSTRACT_USER_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_USER_ACTION__SUCCESSOR = 0;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_USER_ACTION__PREDECESSOR = 1;

	/**
	 * The number of structural features of the '<em>Abstract User Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_USER_ACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl <em>Usage Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getUsageModel()
	 * @generated
	 */
	int USAGE_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Usage Scenario Usage Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL = 0;

	/**
	 * The number of structural features of the '<em>Usage Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.StopImpl <em>Stop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.StopImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getStop()
	 * @generated
	 */
	int STOP = 5;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP__SUCCESSOR = ABSTRACT_USER_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP__PREDECESSOR = ABSTRACT_USER_ACTION__PREDECESSOR;

	/**
	 * The number of structural features of the '<em>Stop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FEATURE_COUNT = ABSTRACT_USER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.StartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.StartImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getStart()
	 * @generated
	 */
	int START = 6;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__SUCCESSOR = ABSTRACT_USER_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__PREDECESSOR = ABSTRACT_USER_ACTION__PREDECESSOR;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_FEATURE_COUNT = ABSTRACT_USER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl <em>Open Workload</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getOpenWorkload()
	 * @generated
	 */
	int OPEN_WORKLOAD = 7;

	/**
	 * The feature id for the '<em><b>Arrival Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_WORKLOAD__ARRIVAL_RATE = WORKLOAD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Workload</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_WORKLOAD_FEATURE_COUNT = WORKLOAD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 8;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__SUCCESSOR = ABSTRACT_USER_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__PREDECESSOR = ABSTRACT_USER_ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__BODY_BEHAVIOUR_LOOP = ABSTRACT_USER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ITERATIONS = ABSTRACT_USER_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = ABSTRACT_USER_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl <em>Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getEntryLevelSystemCall()
	 * @generated
	 */
	int ENTRY_LEVEL_SYSTEM_CALL = 9;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL__SUCCESSOR = ABSTRACT_USER_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL__PREDECESSOR = ABSTRACT_USER_ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Actual Parameter Usage Entry Level System Call</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL = ABSTRACT_USER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System Provided Role Entry Level System Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL = ABSTRACT_USER_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signature Entry Level System Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL = ABSTRACT_USER_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = ABSTRACT_USER_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl <em>Closed Workload</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getClosedWorkload()
	 * @generated
	 */
	int CLOSED_WORKLOAD = 10;

	/**
	 * The feature id for the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_WORKLOAD__POPULATION = WORKLOAD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Think Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_WORKLOAD__THINK_TIME = WORKLOAD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Closed Workload</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_WORKLOAD_FEATURE_COUNT = WORKLOAD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl
	 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 11;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__SUCCESSOR = ABSTRACT_USER_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__PREDECESSOR = ABSTRACT_USER_ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Branched Behaviour Branch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__BRANCHED_BEHAVIOUR_BRANCH = ABSTRACT_USER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = ABSTRACT_USER_ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.Workload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workload</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Workload
	 * @generated
	 */
	EClass getWorkload();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario <em>Usage Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage Scenario</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
	 * @generated
	 */
	EClass getUsageScenario();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getWorkload_UsageScenario <em>Workload Usage Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Workload Usage Scenario</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getWorkload_UsageScenario()
	 * @see #getUsageScenario()
	 * @generated
	 */
	EReference getUsageScenario_Workload_UsageScenario();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getScenarioBehaviour_UsageScenario <em>Scenario Behaviour Usage Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenario Behaviour Usage Scenario</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsageScenario#getScenarioBehaviour_UsageScenario()
	 * @see #getUsageScenario()
	 * @generated
	 */
	EReference getUsageScenario_ScenarioBehaviour_UsageScenario();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour <em>Scenario Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour
	 * @generated
	 */
	EClass getScenarioBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour#getActions_ScenarioBehaviour <em>Actions Scenario Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Scenario Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour#getActions_ScenarioBehaviour()
	 * @see #getScenarioBehaviour()
	 * @generated
	 */
	EReference getScenarioBehaviour_Actions_ScenarioBehaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction <em>Abstract User Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract User Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
	 * @generated
	 */
	EClass getAbstractUserAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor()
	 * @see #getAbstractUserAction()
	 * @generated
	 */
	EReference getAbstractUserAction_Successor();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor()
	 * @see #getAbstractUserAction()
	 * @generated
	 */
	EReference getAbstractUserAction_Predecessor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageModel <em>Usage Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage Model</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsageModel
	 * @generated
	 */
	EClass getUsageModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.usagemodel.UsageModel#getUsageScenario_UsageModel <em>Usage Scenario Usage Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usage Scenario Usage Model</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsageModel#getUsageScenario_UsageModel()
	 * @see #getUsageModel()
	 * @generated
	 */
	EReference getUsageModel_UsageScenario_UsageModel();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.Stop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Stop
	 * @generated
	 */
	EClass getStop();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Start
	 * @generated
	 */
	EClass getStart();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload <em>Open Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Workload</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload
	 * @generated
	 */
	EClass getOpenWorkload();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getArrivalRate <em>Arrival Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Rate</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getArrivalRate()
	 * @see #getOpenWorkload()
	 * @generated
	 */
	EAttribute getOpenWorkload_ArrivalRate();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Behaviour Loop</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_BodyBehaviour_Loop();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations <em>Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterations</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations()
	 * @see #getLoop()
	 * @generated
	 */
	EAttribute getLoop_Iterations();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall <em>Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Level System Call</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
	 * @generated
	 */
	EClass getEntryLevelSystemCall();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getActualParameterUsage_EntryLevelSystemCall <em>Actual Parameter Usage Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Parameter Usage Entry Level System Call</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getActualParameterUsage_EntryLevelSystemCall()
	 * @see #getEntryLevelSystemCall()
	 * @generated
	 */
	EReference getEntryLevelSystemCall_ActualParameterUsage_EntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSystemProvidedRole_EntryLevelSystemCall <em>System Provided Role Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Provided Role Entry Level System Call</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSystemProvidedRole_EntryLevelSystemCall()
	 * @see #getEntryLevelSystemCall()
	 * @generated
	 */
	EReference getEntryLevelSystemCall_SystemProvidedRole_EntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSignature_EntryLevelSystemCall <em>Signature Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature Entry Level System Call</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall#getSignature_EntryLevelSystemCall()
	 * @see #getEntryLevelSystemCall()
	 * @generated
	 */
	EReference getEntryLevelSystemCall_Signature_EntryLevelSystemCall();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload <em>Closed Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closed Workload</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload
	 * @generated
	 */
	EClass getClosedWorkload();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getPopulation()
	 * @see #getClosedWorkload()
	 * @generated
	 */
	EAttribute getClosedWorkload_Population();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime <em>Think Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Think Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime()
	 * @see #getClosedWorkload()
	 * @generated
	 */
	EAttribute getClosedWorkload_ThinkTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.usagemodel.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.usagemodel.Branch#getBranchedBehaviour_Branch <em>Branched Behaviour Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branched Behaviour Branch</em>'.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.Branch#getBranchedBehaviour_Branch()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_BranchedBehaviour_Branch();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsagemodelFactory getUsagemodelFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.WorkloadImpl <em>Workload</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.WorkloadImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getWorkload()
		 * @generated
		 */
		EClass WORKLOAD = eINSTANCE.getWorkload();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl <em>Usage Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getUsageScenario()
		 * @generated
		 */
		EClass USAGE_SCENARIO = eINSTANCE.getUsageScenario();

		/**
		 * The meta object literal for the '<em><b>Workload Usage Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO = eINSTANCE.getUsageScenario_Workload_UsageScenario();

		/**
		 * The meta object literal for the '<em><b>Scenario Behaviour Usage Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO = eINSTANCE.getUsageScenario_ScenarioBehaviour_UsageScenario();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl <em>Scenario Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getScenarioBehaviour()
		 * @generated
		 */
		EClass SCENARIO_BEHAVIOUR = eINSTANCE.getScenarioBehaviour();

		/**
		 * The meta object literal for the '<em><b>Actions Scenario Behaviour</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR = eINSTANCE.getScenarioBehaviour_Actions_ScenarioBehaviour();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl <em>Abstract User Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getAbstractUserAction()
		 * @generated
		 */
		EClass ABSTRACT_USER_ACTION = eINSTANCE.getAbstractUserAction();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_USER_ACTION__SUCCESSOR = eINSTANCE.getAbstractUserAction_Successor();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_USER_ACTION__PREDECESSOR = eINSTANCE.getAbstractUserAction_Predecessor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl <em>Usage Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getUsageModel()
		 * @generated
		 */
		EClass USAGE_MODEL = eINSTANCE.getUsageModel();

		/**
		 * The meta object literal for the '<em><b>Usage Scenario Usage Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL = eINSTANCE.getUsageModel_UsageScenario_UsageModel();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.StopImpl <em>Stop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.StopImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getStop()
		 * @generated
		 */
		EClass STOP = eINSTANCE.getStop();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.StartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.StartImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getStart()
		 * @generated
		 */
		EClass START = eINSTANCE.getStart();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl <em>Open Workload</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getOpenWorkload()
		 * @generated
		 */
		EClass OPEN_WORKLOAD = eINSTANCE.getOpenWorkload();

		/**
		 * The meta object literal for the '<em><b>Arrival Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_WORKLOAD__ARRIVAL_RATE = eINSTANCE.getOpenWorkload_ArrivalRate();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Body Behaviour Loop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__BODY_BEHAVIOUR_LOOP = eINSTANCE.getLoop_BodyBehaviour_Loop();

		/**
		 * The meta object literal for the '<em><b>Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP__ITERATIONS = eINSTANCE.getLoop_Iterations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl <em>Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getEntryLevelSystemCall()
		 * @generated
		 */
		EClass ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getEntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Actual Parameter Usage Entry Level System Call</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getEntryLevelSystemCall_ActualParameterUsage_EntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>System Provided Role Entry Level System Call</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getEntryLevelSystemCall_SystemProvidedRole_EntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Signature Entry Level System Call</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getEntryLevelSystemCall_Signature_EntryLevelSystemCall();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl <em>Closed Workload</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getClosedWorkload()
		 * @generated
		 */
		EClass CLOSED_WORKLOAD = eINSTANCE.getClosedWorkload();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSED_WORKLOAD__POPULATION = eINSTANCE.getClosedWorkload_Population();

		/**
		 * The meta object literal for the '<em><b>Think Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSED_WORKLOAD__THINK_TIME = eINSTANCE.getClosedWorkload_ThinkTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl
		 * @see de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Branched Behaviour Branch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__BRANCHED_BEHAVIOUR_BRANCH = eINSTANCE.getBranch_BranchedBehaviour_Branch();

	}

} //UsagemodelPackage
