/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "schedulers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Schedulers/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capra.schedulers";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulersPackage eINSTANCE = de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl <em>Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getScheduler()
	 * @generated
	 */
	int SCHEDULER = 0;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__ASSIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>Selectionpolicy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SELECTIONPOLICY = 1;

	/**
	 * The feature id for the '<em><b>Timeconsumption</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__TIMECONSUMPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__NAME = 3;

	/**
	 * The feature id for the '<em><b>Load Balancing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__LOAD_BALANCING = 4;

	/**
	 * The number of structural features of the '<em>Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.AssignmentImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.SelectionPolicyImpl <em>Selection Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SelectionPolicyImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getSelectionPolicy()
	 * @generated
	 */
	int SELECTION_POLICY = 2;

	/**
	 * The number of structural features of the '<em>Selection Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_POLICY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl <em>Time Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getTimeConsumption()
	 * @generated
	 */
	int TIME_CONSUMPTION = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSUMPTION__TIME = 0;

	/**
	 * The feature id for the '<em><b>Scaling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSUMPTION__SCALING = 1;

	/**
	 * The number of structural features of the '<em>Time Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSUMPTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.NonPreemptiveImpl <em>Non Preemptive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.NonPreemptiveImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getNonPreemptive()
	 * @generated
	 */
	int NON_PREEMPTIVE = 4;

	/**
	 * The number of structural features of the '<em>Non Preemptive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_PREEMPTIVE_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl <em>Preemptive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPreemptive()
	 * @generated
	 */
	int PREEMPTIVE = 5;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTIVE__IMMEDIATE = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Quantum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTIVE__QUANTUM = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Preemptive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTIVE_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.QuantumImpl <em>Quantum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.QuantumImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getQuantum()
	 * @generated
	 */
	int QUANTUM = 6;

	/**
	 * The feature id for the '<em><b>Time Slice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM__TIME_SLICE = 0;

	/**
	 * The number of structural features of the '<em>Quantum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.WaitingTimeImpl <em>Waiting Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.WaitingTimeImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getWaitingTime()
	 * @generated
	 */
	int WAITING_TIME = 7;

	/**
	 * The number of structural features of the '<em>Waiting Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAITING_TIME_FEATURE_COUNT = SELECTION_POLICY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl <em>Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 8;

	/**
	 * The feature id for the '<em><b>Has Dynamic Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__HAS_DYNAMIC_PRIORITY = SELECTION_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__PREFERENCE = SELECTION_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_FEATURE_COUNT = SELECTION_POLICY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl <em>Priorty Quantums</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriortyQuantums()
	 * @generated
	 */
	int PRIORTY_QUANTUMS = 9;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORTY_QUANTUMS__PRIORITY = 0;

	/**
	 * The feature id for the '<em><b>Number Of Quantums</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS = 1;

	/**
	 * The number of structural features of the '<em>Priorty Quantums</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORTY_QUANTUMS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.BigOClass <em>Big OClass</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.BigOClass
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getBigOClass()
	 * @generated
	 */
	int BIG_OCLASS = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.LoadBalancing <em>Load Balancing</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.LoadBalancing
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getLoadBalancing()
	 * @generated
	 */
	int LOAD_BALANCING = 11;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.Preference <em>Preference</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.Preference
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPreference()
	 * @generated
	 */
	int PREFERENCE = 12;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.schedulers.PriorityType <em>Priority Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.schedulers.PriorityType
	 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriorityType()
	 * @generated
	 */
	int PRIORITY_TYPE = 13;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler
	 * @generated
	 */
	EClass getScheduler();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assignment</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler#getAssignment()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Assignment();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getSelectionpolicy <em>Selectionpolicy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selectionpolicy</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler#getSelectionpolicy()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Selectionpolicy();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getTimeconsumption <em>Timeconsumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timeconsumption</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler#getTimeconsumption()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Timeconsumption();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler#getName()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getLoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Balancing</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Scheduler#getLoadBalancing()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_LoadBalancing();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.SelectionPolicy <em>Selection Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Policy</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.SelectionPolicy
	 * @generated
	 */
	EClass getSelectionPolicy();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption <em>Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.TimeConsumption
	 * @generated
	 */
	EClass getTimeConsumption();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getTime()
	 * @see #getTimeConsumption()
	 * @generated
	 */
	EReference getTimeConsumption_Time();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getScaling <em>Scaling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scaling</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getScaling()
	 * @see #getTimeConsumption()
	 * @generated
	 */
	EAttribute getTimeConsumption_Scaling();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.NonPreemptive <em>Non Preemptive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Preemptive</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.NonPreemptive
	 * @generated
	 */
	EClass getNonPreemptive();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.Preemptive <em>Preemptive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preemptive</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preemptive
	 * @generated
	 */
	EClass getPreemptive();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preemptive#isImmediate()
	 * @see #getPreemptive()
	 * @generated
	 */
	EAttribute getPreemptive_Immediate();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#getQuantum <em>Quantum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Quantum</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preemptive#getQuantum()
	 * @see #getPreemptive()
	 * @generated
	 */
	EReference getPreemptive_Quantum();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.Quantum <em>Quantum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantum</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Quantum
	 * @generated
	 */
	EClass getQuantum();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Quantum#getTimeSlice <em>Time Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Slice</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Quantum#getTimeSlice()
	 * @see #getQuantum()
	 * @generated
	 */
	EAttribute getQuantum_TimeSlice();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.WaitingTime <em>Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Waiting Time</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.WaitingTime
	 * @generated
	 */
	EClass getWaitingTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Priority
	 * @generated
	 */
	EClass getPriority();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Priority#isHasDynamicPriority <em>Has Dynamic Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Dynamic Priority</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Priority#isHasDynamicPriority()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_HasDynamicPriority();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.schedulers.Priority#getPreference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preference</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Priority#getPreference()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_Preference();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums <em>Priorty Quantums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priorty Quantums</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.PriortyQuantums
	 * @generated
	 */
	EClass getPriortyQuantums();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Priority</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getPriority()
	 * @see #getPriortyQuantums()
	 * @generated
	 */
	EReference getPriortyQuantums_Priority();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getNumberOfQuantums <em>Number Of Quantums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Number Of Quantums</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getNumberOfQuantums()
	 * @see #getPriortyQuantums()
	 * @generated
	 */
	EReference getPriortyQuantums_NumberOfQuantums();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.capra.schedulers.BigOClass <em>Big OClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Big OClass</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.BigOClass
	 * @generated
	 */
	EEnum getBigOClass();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.capra.schedulers.LoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Load Balancing</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.LoadBalancing
	 * @generated
	 */
	EEnum getLoadBalancing();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.capra.schedulers.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Preference</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preference
	 * @generated
	 */
	EEnum getPreference();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.capra.schedulers.PriorityType <em>Priority Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority Type</em>'.
	 * @see de.uka.ipd.sdq.capra.schedulers.PriorityType
	 * @generated
	 */
	EEnum getPriorityType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulersFactory getSchedulersFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl <em>Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulerImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getScheduler()
		 * @generated
		 */
		EClass SCHEDULER = eINSTANCE.getScheduler();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__ASSIGNMENT = eINSTANCE.getScheduler_Assignment();

		/**
		 * The meta object literal for the '<em><b>Selectionpolicy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__SELECTIONPOLICY = eINSTANCE.getScheduler_Selectionpolicy();

		/**
		 * The meta object literal for the '<em><b>Timeconsumption</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__TIMECONSUMPTION = eINSTANCE.getScheduler_Timeconsumption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__NAME = eINSTANCE.getScheduler_Name();

		/**
		 * The meta object literal for the '<em><b>Load Balancing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__LOAD_BALANCING = eINSTANCE.getScheduler_LoadBalancing();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.AssignmentImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.SelectionPolicyImpl <em>Selection Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SelectionPolicyImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getSelectionPolicy()
		 * @generated
		 */
		EClass SELECTION_POLICY = eINSTANCE.getSelectionPolicy();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl <em>Time Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getTimeConsumption()
		 * @generated
		 */
		EClass TIME_CONSUMPTION = eINSTANCE.getTimeConsumption();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_CONSUMPTION__TIME = eINSTANCE.getTimeConsumption_Time();

		/**
		 * The meta object literal for the '<em><b>Scaling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSUMPTION__SCALING = eINSTANCE.getTimeConsumption_Scaling();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.NonPreemptiveImpl <em>Non Preemptive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.NonPreemptiveImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getNonPreemptive()
		 * @generated
		 */
		EClass NON_PREEMPTIVE = eINSTANCE.getNonPreemptive();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl <em>Preemptive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.PreemptiveImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPreemptive()
		 * @generated
		 */
		EClass PREEMPTIVE = eINSTANCE.getPreemptive();

		/**
		 * The meta object literal for the '<em><b>Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREEMPTIVE__IMMEDIATE = eINSTANCE.getPreemptive_Immediate();

		/**
		 * The meta object literal for the '<em><b>Quantum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREEMPTIVE__QUANTUM = eINSTANCE.getPreemptive_Quantum();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.QuantumImpl <em>Quantum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.QuantumImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getQuantum()
		 * @generated
		 */
		EClass QUANTUM = eINSTANCE.getQuantum();

		/**
		 * The meta object literal for the '<em><b>Time Slice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTUM__TIME_SLICE = eINSTANCE.getQuantum_TimeSlice();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.WaitingTimeImpl <em>Waiting Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.WaitingTimeImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getWaitingTime()
		 * @generated
		 */
		EClass WAITING_TIME = eINSTANCE.getWaitingTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl <em>Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.PriorityImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriority()
		 * @generated
		 */
		EClass PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '<em><b>Has Dynamic Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY__HAS_DYNAMIC_PRIORITY = eINSTANCE.getPriority_HasDynamicPriority();

		/**
		 * The meta object literal for the '<em><b>Preference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY__PREFERENCE = eINSTANCE.getPriority_Preference();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl <em>Priorty Quantums</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.PriortyQuantumsImpl
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriortyQuantums()
		 * @generated
		 */
		EClass PRIORTY_QUANTUMS = eINSTANCE.getPriortyQuantums();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORTY_QUANTUMS__PRIORITY = eINSTANCE.getPriortyQuantums_Priority();

		/**
		 * The meta object literal for the '<em><b>Number Of Quantums</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS = eINSTANCE.getPriortyQuantums_NumberOfQuantums();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.BigOClass <em>Big OClass</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.BigOClass
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getBigOClass()
		 * @generated
		 */
		EEnum BIG_OCLASS = eINSTANCE.getBigOClass();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.LoadBalancing <em>Load Balancing</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.LoadBalancing
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getLoadBalancing()
		 * @generated
		 */
		EEnum LOAD_BALANCING = eINSTANCE.getLoadBalancing();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.Preference <em>Preference</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.Preference
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPreference()
		 * @generated
		 */
		EEnum PREFERENCE = eINSTANCE.getPreference();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.schedulers.PriorityType <em>Priority Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.schedulers.PriorityType
		 * @see de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl#getPriorityType()
		 * @generated
		 */
		EEnum PRIORITY_TYPE = eINSTANCE.getPriorityType();

	}

} //SchedulersPackage
