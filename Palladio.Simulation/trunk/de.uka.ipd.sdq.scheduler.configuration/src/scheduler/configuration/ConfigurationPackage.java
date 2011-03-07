/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see scheduler.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/scheduler/configuration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = scheduler.configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PriorityBoostConfigurationImpl <em>Priority Boost Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PriorityBoostConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityBoostConfiguration()
	 * @generated
	 */
	int PRIORITY_BOOST_CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Priority Boost Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl <em>Dynamic Priority Boost Configuratioin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getDynamicPriorityBoostConfiguratioin()
	 * @generated
	 */
	int DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN = 0;

	/**
	 * The feature id for the '<em><b>Max Bonus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Sleep Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dynamic Priority Boost Configuratioin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN_FEATURE_COUNT = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.LoadBalancingImpl <em>Load Balancing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.LoadBalancingImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getLoadBalancing()
	 * @generated
	 */
	int LOAD_BALANCING = 2;

	/**
	 * The feature id for the '<em><b>Balancing Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__BALANCING_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Preferred Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__PREFERRED_WAITING_TIME = 1;

	/**
	 * The feature id for the '<em><b>Preferred Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__PREFERRED_PRIORITY = 2;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__INSTANCES = 3;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__THRESHOLD = 4;

	/**
	 * The feature id for the '<em><b>Max Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__MAX_ITERATIONS = 5;

	/**
	 * The feature id for the '<em><b>Balancing Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING__BALANCING_INTERVAL = 6;

	/**
	 * The number of structural features of the '<em>Load Balancing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_BALANCING_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.QueueingConfigurationImpl <em>Queueing Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.QueueingConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getQueueingConfiguration()
	 * @generated
	 */
	int QUEUEING_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Initial Instance Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION = 0;

	/**
	 * The feature id for the '<em><b>Runqueue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUEING_CONFIGURATION__RUNQUEUE_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Queueing Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUEING_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.MultipleQueueConfigurationImpl <em>Multiple Queue Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.MultipleQueueConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getMultipleQueueConfiguration()
	 * @generated
	 */
	int MULTIPLE_QUEUE_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Initial Instance Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_QUEUE_CONFIGURATION__INITIAL_INSTANCE_SELECTION = QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION;

	/**
	 * The feature id for the '<em><b>Runqueue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_QUEUE_CONFIGURATION__RUNQUEUE_TYPE = QUEUEING_CONFIGURATION__RUNQUEUE_TYPE;

	/**
	 * The feature id for the '<em><b>Load Balancing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING = QUEUEING_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Front When Balancing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING = QUEUEING_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiple Queue Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_QUEUE_CONFIGURATION_FEATURE_COUNT = QUEUEING_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.TimeSliceConfigurationImpl <em>Time Slice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.TimeSliceConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getTimeSliceConfiguration()
	 * @generated
	 */
	int TIME_SLICE_CONFIGURATION = 6;

	/**
	 * The feature id for the '<em><b>Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SLICE_CONFIGURATION__TIMESLICE = 0;

	/**
	 * The number of structural features of the '<em>Time Slice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SLICE_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl <em>Quantum Time Slice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getQuantumTimeSliceConfiguration()
	 * @generated
	 */
	int QUANTUM_TIME_SLICE_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM_TIME_SLICE_CONFIGURATION__TIMESLICE = TIME_SLICE_CONFIGURATION__TIMESLICE;

	/**
	 * The feature id for the '<em><b>Quanta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Quanta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Quantum Time Slice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTUM_TIME_SLICE_CONFIGURATION_FEATURE_COUNT = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PreemptionConfigurationImpl <em>Preemption Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PreemptionConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreemptionConfiguration()
	 * @generated
	 */
	int PREEMPTION_CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Timeslice Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION = 0;

	/**
	 * The number of structural features of the '<em>Preemption Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PriorityConfigurationImpl <em>Priority Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PriorityConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityConfiguration()
	 * @generated
	 */
	int PRIORITY_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_CONFIGURATION__RANGE = 0;

	/**
	 * The feature id for the '<em><b>Boost Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_CONFIGURATION__BOOST_CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Priority Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PriorityRangeImpl <em>Priority Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PriorityRangeImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityRange()
	 * @generated
	 */
	int PRIORITY_RANGE = 9;

	/**
	 * The feature id for the '<em><b>Highest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__HIGHEST = 0;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__HIGH = 1;

	/**
	 * The feature id for the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__AVERAGE = 2;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__LOW = 3;

	/**
	 * The feature id for the '<em><b>Lowest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__LOWEST = 4;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE__DEFAULT = 5;

	/**
	 * The number of structural features of the '<em>Priority Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RANGE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl <em>Priority Dependent Time Slice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityDependentTimeSliceConfiguration()
	 * @generated
	 */
	int PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION = 10;

	/**
	 * The feature id for the '<em><b>Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__TIMESLICE = TIME_SLICE_CONFIGURATION__TIMESLICE;

	/**
	 * The feature id for the '<em><b>Min Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Time To Be Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Priority Dependent Time Slice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION_FEATURE_COUNT = TIME_SLICE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.ActiveResourceConfigurationImpl <em>Active Resource Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.ActiveResourceConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getActiveResourceConfiguration()
	 * @generated
	 */
	int ACTIVE_RESOURCE_CONFIGURATION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_CONFIGURATION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Scheduler Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_CONFIGURATION__REPLICAS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_CONFIGURATION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Active Resource Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_CONFIGURATION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl <em>Passive Resource Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.PassiveResourceConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPassiveResourceConfiguration()
	 * @generated
	 */
	int PASSIVE_RESOURCE_CONFIGURATION = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Static Priority Boost Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__CAPACITY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__TYPE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Managing Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Acquisition Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Passive Resource Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_CONFIGURATION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.StaticPriorityBoostImpl <em>Static Priority Boost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.StaticPriorityBoostImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStaticPriorityBoost()
	 * @generated
	 */
	int STATIC_PRIORITY_BOOST = 13;

	/**
	 * The feature id for the '<em><b>Reset Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST__RESET_TIMESLICE = 0;

	/**
	 * The feature id for the '<em><b>Bonus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST__BONUS = 1;

	/**
	 * The feature id for the '<em><b>Degradation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST__DEGRADATION = 2;

	/**
	 * The feature id for the '<em><b>Time Penalty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST__TIME_PENALTY = 3;

	/**
	 * The number of structural features of the '<em>Static Priority Boost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.ProcessConfigurationImpl <em>Process Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.ProcessConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getProcessConfiguration()
	 * @generated
	 */
	int PROCESS_CONFIGURATION = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION__PRIORITY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION__REPLICAS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Affinity List</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION__AFFINITY_LIST = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Process Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.SingleQueueConfigurationImpl <em>Single Queue Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.SingleQueueConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getSingleQueueConfiguration()
	 * @generated
	 */
	int SINGLE_QUEUE_CONFIGURATION = 15;

	/**
	 * The feature id for the '<em><b>Initial Instance Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_QUEUE_CONFIGURATION__INITIAL_INSTANCE_SELECTION = QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION;

	/**
	 * The feature id for the '<em><b>Runqueue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_QUEUE_CONFIGURATION__RUNQUEUE_TYPE = QUEUEING_CONFIGURATION__RUNQUEUE_TYPE;

	/**
	 * The feature id for the '<em><b>Process Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION = QUEUEING_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Queue Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_QUEUE_CONFIGURATION_FEATURE_COUNT = QUEUEING_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.StaticPriorityBoostConfigurationImpl <em>Static Priority Boost Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.StaticPriorityBoostConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStaticPriorityBoostConfiguration()
	 * @generated
	 */
	int STATIC_PRIORITY_BOOST_CONFIGURATION = 16;

	/**
	 * The feature id for the '<em><b>Starvation Boost</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Static Priority Boost Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT = PRIORITY_BOOST_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.SchedulerConfigurationImpl <em>Scheduler Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.SchedulerConfigurationImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getSchedulerConfiguration()
	 * @generated
	 */
	int SCHEDULER_CONFIGURATION = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Priority Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Preemption Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Queueing Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>In Front After Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Windows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__WINDOWS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__INTERVAL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Starvation Boost</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION__STARVATION_BOOST = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Scheduler Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONFIGURATION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link scheduler.configuration.impl.StarvationBoostImpl <em>Starvation Boost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.impl.StarvationBoostImpl
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStarvationBoost()
	 * @generated
	 */
	int STARVATION_BOOST = 18;

	/**
	 * The feature id for the '<em><b>Starvation Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARVATION_BOOST__STARVATION_LIMIT = 0;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARVATION_BOOST__BOOST = 1;

	/**
	 * The feature id for the '<em><b>Duration In Timeslices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARVATION_BOOST__DURATION_IN_TIMESLICES = 2;

	/**
	 * The number of structural features of the '<em>Starvation Boost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARVATION_BOOST_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link scheduler.configuration.InstanceToBalance <em>Instance To Balance</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.InstanceToBalance
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getInstanceToBalance()
	 * @generated
	 */
	int INSTANCE_TO_BALANCE = 19;

	/**
	 * The meta object id for the '{@link scheduler.configuration.LoadBalancingType <em>Load Balancing Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.LoadBalancingType
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getLoadBalancingType()
	 * @generated
	 */
	int LOAD_BALANCING_TYPE = 20;

	/**
	 * The meta object id for the '{@link scheduler.configuration.PreferredWaitingTime <em>Preferred Waiting Time</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.PreferredWaitingTime
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreferredWaitingTime()
	 * @generated
	 */
	int PREFERRED_WAITING_TIME = 21;

	/**
	 * The meta object id for the '{@link scheduler.configuration.PreferredPriority <em>Preferred Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.PreferredPriority
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreferredPriority()
	 * @generated
	 */
	int PREFERRED_PRIORITY = 22;

	/**
	 * The meta object id for the '{@link scheduler.configuration.ResourceInstanceSelection <em>Resource Instance Selection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.ResourceInstanceSelection
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getResourceInstanceSelection()
	 * @generated
	 */
	int RESOURCE_INSTANCE_SELECTION = 23;

	/**
	 * The meta object id for the '{@link scheduler.configuration.RunQueueType <em>Run Queue Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.RunQueueType
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getRunQueueType()
	 * @generated
	 */
	int RUN_QUEUE_TYPE = 24;

	/**
	 * The meta object id for the '{@link scheduler.configuration.PriorityClass <em>Priority Class</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.PriorityClass
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityClass()
	 * @generated
	 */
	int PRIORITY_CLASS = 25;

	/**
	 * The meta object id for the '{@link scheduler.configuration.PriorityDegradation <em>Priority Degradation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.PriorityDegradation
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityDegradation()
	 * @generated
	 */
	int PRIORITY_DEGRADATION = 26;

	/**
	 * The meta object id for the '{@link scheduler.configuration.ProcessSelection <em>Process Selection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.ProcessSelection
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getProcessSelection()
	 * @generated
	 */
	int PROCESS_SELECTION = 27;

	/**
	 * The meta object id for the '{@link scheduler.configuration.PassiveResourceType <em>Passive Resource Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.configuration.PassiveResourceType
	 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPassiveResourceType()
	 * @generated
	 */
	int PASSIVE_RESOURCE_TYPE = 28;


	/**
	 * Returns the meta object for class '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin <em>Dynamic Priority Boost Configuratioin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Priority Boost Configuratioin</em>'.
	 * @see scheduler.configuration.DynamicPriorityBoostConfiguratioin
	 * @generated
	 */
	EClass getDynamicPriorityBoostConfiguratioin();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxBonus <em>Max Bonus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Bonus</em>'.
	 * @see scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxBonus()
	 * @see #getDynamicPriorityBoostConfiguratioin()
	 * @generated
	 */
	EAttribute getDynamicPriorityBoostConfiguratioin_MaxBonus();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see scheduler.configuration.DynamicPriorityBoostConfiguratioin#getThreshold()
	 * @see #getDynamicPriorityBoostConfiguratioin()
	 * @generated
	 */
	EAttribute getDynamicPriorityBoostConfiguratioin_Threshold();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxSleepAverage <em>Max Sleep Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Sleep Average</em>'.
	 * @see scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxSleepAverage()
	 * @see #getDynamicPriorityBoostConfiguratioin()
	 * @generated
	 */
	EAttribute getDynamicPriorityBoostConfiguratioin_MaxSleepAverage();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PriorityBoostConfiguration <em>Priority Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority Boost Configuration</em>'.
	 * @see scheduler.configuration.PriorityBoostConfiguration
	 * @generated
	 */
	EClass getPriorityBoostConfiguration();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.LoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Balancing</em>'.
	 * @see scheduler.configuration.LoadBalancing
	 * @generated
	 */
	EClass getLoadBalancing();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getBalancingType <em>Balancing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balancing Type</em>'.
	 * @see scheduler.configuration.LoadBalancing#getBalancingType()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_BalancingType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getPreferredWaitingTime <em>Preferred Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Waiting Time</em>'.
	 * @see scheduler.configuration.LoadBalancing#getPreferredWaitingTime()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_PreferredWaitingTime();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getPreferredPriority <em>Preferred Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Priority</em>'.
	 * @see scheduler.configuration.LoadBalancing#getPreferredPriority()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_PreferredPriority();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instances</em>'.
	 * @see scheduler.configuration.LoadBalancing#getInstances()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_Instances();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see scheduler.configuration.LoadBalancing#getThreshold()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_Threshold();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getMaxIterations <em>Max Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Iterations</em>'.
	 * @see scheduler.configuration.LoadBalancing#getMaxIterations()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_MaxIterations();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.LoadBalancing#getBalancingInterval <em>Balancing Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balancing Interval</em>'.
	 * @see scheduler.configuration.LoadBalancing#getBalancingInterval()
	 * @see #getLoadBalancing()
	 * @generated
	 */
	EAttribute getLoadBalancing_BalancingInterval();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.MultipleQueueConfiguration <em>Multiple Queue Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Queue Configuration</em>'.
	 * @see scheduler.configuration.MultipleQueueConfiguration
	 * @generated
	 */
	EClass getMultipleQueueConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.MultipleQueueConfiguration#getLoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Load Balancing</em>'.
	 * @see scheduler.configuration.MultipleQueueConfiguration#getLoadBalancing()
	 * @see #getMultipleQueueConfiguration()
	 * @generated
	 */
	EReference getMultipleQueueConfiguration_LoadBalancing();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.MultipleQueueConfiguration#isInFrontWhenBalancing <em>In Front When Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Front When Balancing</em>'.
	 * @see scheduler.configuration.MultipleQueueConfiguration#isInFrontWhenBalancing()
	 * @see #getMultipleQueueConfiguration()
	 * @generated
	 */
	EAttribute getMultipleQueueConfiguration_InFrontWhenBalancing();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.QueueingConfiguration <em>Queueing Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Queueing Configuration</em>'.
	 * @see scheduler.configuration.QueueingConfiguration
	 * @generated
	 */
	EClass getQueueingConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.QueueingConfiguration#getInitialInstanceSelection <em>Initial Instance Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Instance Selection</em>'.
	 * @see scheduler.configuration.QueueingConfiguration#getInitialInstanceSelection()
	 * @see #getQueueingConfiguration()
	 * @generated
	 */
	EAttribute getQueueingConfiguration_InitialInstanceSelection();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.QueueingConfiguration#getRunqueueType <em>Runqueue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runqueue Type</em>'.
	 * @see scheduler.configuration.QueueingConfiguration#getRunqueueType()
	 * @see #getQueueingConfiguration()
	 * @generated
	 */
	EAttribute getQueueingConfiguration_RunqueueType();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.QuantumTimeSliceConfiguration <em>Quantum Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantum Time Slice Configuration</em>'.
	 * @see scheduler.configuration.QuantumTimeSliceConfiguration
	 * @generated
	 */
	EClass getQuantumTimeSliceConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.QuantumTimeSliceConfiguration#getQuanta <em>Quanta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quanta</em>'.
	 * @see scheduler.configuration.QuantumTimeSliceConfiguration#getQuanta()
	 * @see #getQuantumTimeSliceConfiguration()
	 * @generated
	 */
	EAttribute getQuantumTimeSliceConfiguration_Quanta();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.QuantumTimeSliceConfiguration#getMinQuanta <em>Min Quanta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Quanta</em>'.
	 * @see scheduler.configuration.QuantumTimeSliceConfiguration#getMinQuanta()
	 * @see #getQuantumTimeSliceConfiguration()
	 * @generated
	 */
	EAttribute getQuantumTimeSliceConfiguration_MinQuanta();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.TimeSliceConfiguration <em>Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Slice Configuration</em>'.
	 * @see scheduler.configuration.TimeSliceConfiguration
	 * @generated
	 */
	EClass getTimeSliceConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.TimeSliceConfiguration#getTimeslice <em>Timeslice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeslice</em>'.
	 * @see scheduler.configuration.TimeSliceConfiguration#getTimeslice()
	 * @see #getTimeSliceConfiguration()
	 * @generated
	 */
	EAttribute getTimeSliceConfiguration_Timeslice();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PreemptionConfiguration <em>Preemption Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preemption Configuration</em>'.
	 * @see scheduler.configuration.PreemptionConfiguration
	 * @generated
	 */
	EClass getPreemptionConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.PreemptionConfiguration#getTimesliceConfiguration <em>Timeslice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timeslice Configuration</em>'.
	 * @see scheduler.configuration.PreemptionConfiguration#getTimesliceConfiguration()
	 * @see #getPreemptionConfiguration()
	 * @generated
	 */
	EReference getPreemptionConfiguration_TimesliceConfiguration();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PriorityConfiguration <em>Priority Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority Configuration</em>'.
	 * @see scheduler.configuration.PriorityConfiguration
	 * @generated
	 */
	EClass getPriorityConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.PriorityConfiguration#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see scheduler.configuration.PriorityConfiguration#getRange()
	 * @see #getPriorityConfiguration()
	 * @generated
	 */
	EReference getPriorityConfiguration_Range();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.PriorityConfiguration#getBoostConfiguration <em>Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Boost Configuration</em>'.
	 * @see scheduler.configuration.PriorityConfiguration#getBoostConfiguration()
	 * @see #getPriorityConfiguration()
	 * @generated
	 */
	EReference getPriorityConfiguration_BoostConfiguration();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PriorityRange <em>Priority Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority Range</em>'.
	 * @see scheduler.configuration.PriorityRange
	 * @generated
	 */
	EClass getPriorityRange();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getHighest <em>Highest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highest</em>'.
	 * @see scheduler.configuration.PriorityRange#getHighest()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_Highest();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see scheduler.configuration.PriorityRange#getHigh()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_High();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getAverage <em>Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average</em>'.
	 * @see scheduler.configuration.PriorityRange#getAverage()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_Average();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see scheduler.configuration.PriorityRange#getLow()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_Low();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getLowest <em>Lowest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lowest</em>'.
	 * @see scheduler.configuration.PriorityRange#getLowest()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_Lowest();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityRange#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see scheduler.configuration.PriorityRange#getDefault()
	 * @see #getPriorityRange()
	 * @generated
	 */
	EAttribute getPriorityRange_Default();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration <em>Priority Dependent Time Slice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority Dependent Time Slice Configuration</em>'.
	 * @see scheduler.configuration.PriorityDependentTimeSliceConfiguration
	 * @generated
	 */
	EClass getPriorityDependentTimeSliceConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeslice <em>Min Timeslice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Timeslice</em>'.
	 * @see scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeslice()
	 * @see #getPriorityDependentTimeSliceConfiguration()
	 * @generated
	 */
	EAttribute getPriorityDependentTimeSliceConfiguration_MinTimeslice();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeToBeScheduled <em>Min Time To Be Scheduled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Time To Be Scheduled</em>'.
	 * @see scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeToBeScheduled()
	 * @see #getPriorityDependentTimeSliceConfiguration()
	 * @generated
	 */
	EAttribute getPriorityDependentTimeSliceConfiguration_MinTimeToBeScheduled();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.ActiveResourceConfiguration <em>Active Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Resource Configuration</em>'.
	 * @see scheduler.configuration.ActiveResourceConfiguration
	 * @generated
	 */
	EClass getActiveResourceConfiguration();

	/**
	 * Returns the meta object for the reference '{@link scheduler.configuration.ActiveResourceConfiguration#getSchedulerConfiguration <em>Scheduler Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheduler Configuration</em>'.
	 * @see scheduler.configuration.ActiveResourceConfiguration#getSchedulerConfiguration()
	 * @see #getActiveResourceConfiguration()
	 * @generated
	 */
	EReference getActiveResourceConfiguration_SchedulerConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.ActiveResourceConfiguration#getReplicas <em>Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replicas</em>'.
	 * @see scheduler.configuration.ActiveResourceConfiguration#getReplicas()
	 * @see #getActiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getActiveResourceConfiguration_Replicas();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.ActiveResourceConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.configuration.ActiveResourceConfiguration#getName()
	 * @see #getActiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getActiveResourceConfiguration_Name();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.PassiveResourceConfiguration <em>Passive Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource Configuration</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration
	 * @generated
	 */
	EClass getPassiveResourceConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.PassiveResourceConfiguration#getStaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Static Priority Boost Configuration</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getStaticPriorityBoostConfiguration()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EReference getPassiveResourceConfiguration_StaticPriorityBoostConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PassiveResourceConfiguration#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getCapacity()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getPassiveResourceConfiguration_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PassiveResourceConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getType()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getPassiveResourceConfiguration_Type();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PassiveResourceConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getName()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getPassiveResourceConfiguration_Name();

	/**
	 * Returns the meta object for the reference '{@link scheduler.configuration.PassiveResourceConfiguration#getManagingResource <em>Managing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Managing Resource</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getManagingResource()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EReference getPassiveResourceConfiguration_ManagingResource();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.PassiveResourceConfiguration#getAcquisitionDemand <em>Acquisition Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acquisition Demand</em>'.
	 * @see scheduler.configuration.PassiveResourceConfiguration#getAcquisitionDemand()
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 */
	EAttribute getPassiveResourceConfiguration_AcquisitionDemand();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.StaticPriorityBoost <em>Static Priority Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Priority Boost</em>'.
	 * @see scheduler.configuration.StaticPriorityBoost
	 * @generated
	 */
	EClass getStaticPriorityBoost();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StaticPriorityBoost#isResetTimeslice <em>Reset Timeslice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Timeslice</em>'.
	 * @see scheduler.configuration.StaticPriorityBoost#isResetTimeslice()
	 * @see #getStaticPriorityBoost()
	 * @generated
	 */
	EAttribute getStaticPriorityBoost_ResetTimeslice();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StaticPriorityBoost#getBonus <em>Bonus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bonus</em>'.
	 * @see scheduler.configuration.StaticPriorityBoost#getBonus()
	 * @see #getStaticPriorityBoost()
	 * @generated
	 */
	EAttribute getStaticPriorityBoost_Bonus();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StaticPriorityBoost#getDegradation <em>Degradation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Degradation</em>'.
	 * @see scheduler.configuration.StaticPriorityBoost#getDegradation()
	 * @see #getStaticPriorityBoost()
	 * @generated
	 */
	EAttribute getStaticPriorityBoost_Degradation();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StaticPriorityBoost#getTimePenalty <em>Time Penalty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Penalty</em>'.
	 * @see scheduler.configuration.StaticPriorityBoost#getTimePenalty()
	 * @see #getStaticPriorityBoost()
	 * @generated
	 */
	EAttribute getStaticPriorityBoost_TimePenalty();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.ProcessConfiguration <em>Process Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Configuration</em>'.
	 * @see scheduler.configuration.ProcessConfiguration
	 * @generated
	 */
	EClass getProcessConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.ProcessConfiguration#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see scheduler.configuration.ProcessConfiguration#getPriority()
	 * @see #getProcessConfiguration()
	 * @generated
	 */
	EAttribute getProcessConfiguration_Priority();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.ProcessConfiguration#getReplicas <em>Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replicas</em>'.
	 * @see scheduler.configuration.ProcessConfiguration#getReplicas()
	 * @see #getProcessConfiguration()
	 * @generated
	 */
	EAttribute getProcessConfiguration_Replicas();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.ProcessConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.configuration.ProcessConfiguration#getName()
	 * @see #getProcessConfiguration()
	 * @generated
	 */
	EAttribute getProcessConfiguration_Name();

	/**
	 * Returns the meta object for the attribute list '{@link scheduler.configuration.ProcessConfiguration#getAffinityList <em>Affinity List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Affinity List</em>'.
	 * @see scheduler.configuration.ProcessConfiguration#getAffinityList()
	 * @see #getProcessConfiguration()
	 * @generated
	 */
	EAttribute getProcessConfiguration_AffinityList();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.SingleQueueConfiguration <em>Single Queue Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Queue Configuration</em>'.
	 * @see scheduler.configuration.SingleQueueConfiguration
	 * @generated
	 */
	EClass getSingleQueueConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.SingleQueueConfiguration#getProcessSelection <em>Process Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Selection</em>'.
	 * @see scheduler.configuration.SingleQueueConfiguration#getProcessSelection()
	 * @see #getSingleQueueConfiguration()
	 * @generated
	 */
	EAttribute getSingleQueueConfiguration_ProcessSelection();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.StaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Priority Boost Configuration</em>'.
	 * @see scheduler.configuration.StaticPriorityBoostConfiguration
	 * @generated
	 */
	EClass getStaticPriorityBoostConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.StaticPriorityBoostConfiguration#getStarvationBoost <em>Starvation Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Starvation Boost</em>'.
	 * @see scheduler.configuration.StaticPriorityBoostConfiguration#getStarvationBoost()
	 * @see #getStaticPriorityBoostConfiguration()
	 * @generated
	 */
	EReference getStaticPriorityBoostConfiguration_StarvationBoost();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.SchedulerConfiguration <em>Scheduler Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler Configuration</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration
	 * @generated
	 */
	EClass getSchedulerConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration <em>Priority Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority Configuration</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EReference getSchedulerConfiguration_PriorityConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration <em>Preemption Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Preemption Configuration</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EReference getSchedulerConfiguration_PreemptionConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.SchedulerConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getName()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EAttribute getSchedulerConfiguration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration <em>Queueing Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Queueing Configuration</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EReference getSchedulerConfiguration_QueueingConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting <em>In Front After Waiting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Front After Waiting</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EAttribute getSchedulerConfiguration_InFrontAfterWaiting();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.SchedulerConfiguration#isWindows <em>Windows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Windows</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#isWindows()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EAttribute getSchedulerConfiguration_Windows();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.SchedulerConfiguration#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getInterval()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EAttribute getSchedulerConfiguration_Interval();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.configuration.SchedulerConfiguration#getStarvationBoost <em>Starvation Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Starvation Boost</em>'.
	 * @see scheduler.configuration.SchedulerConfiguration#getStarvationBoost()
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	EReference getSchedulerConfiguration_StarvationBoost();

	/**
	 * Returns the meta object for class '{@link scheduler.configuration.StarvationBoost <em>Starvation Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Starvation Boost</em>'.
	 * @see scheduler.configuration.StarvationBoost
	 * @generated
	 */
	EClass getStarvationBoost();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StarvationBoost#getStarvationLimit <em>Starvation Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Starvation Limit</em>'.
	 * @see scheduler.configuration.StarvationBoost#getStarvationLimit()
	 * @see #getStarvationBoost()
	 * @generated
	 */
	EAttribute getStarvationBoost_StarvationLimit();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StarvationBoost#getBoost <em>Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boost</em>'.
	 * @see scheduler.configuration.StarvationBoost#getBoost()
	 * @see #getStarvationBoost()
	 * @generated
	 */
	EAttribute getStarvationBoost_Boost();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.configuration.StarvationBoost#getDurationInTimeslices <em>Duration In Timeslices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration In Timeslices</em>'.
	 * @see scheduler.configuration.StarvationBoost#getDurationInTimeslices()
	 * @see #getStarvationBoost()
	 * @generated
	 */
	EAttribute getStarvationBoost_DurationInTimeslices();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.InstanceToBalance <em>Instance To Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Instance To Balance</em>'.
	 * @see scheduler.configuration.InstanceToBalance
	 * @generated
	 */
	EEnum getInstanceToBalance();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.LoadBalancingType <em>Load Balancing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Load Balancing Type</em>'.
	 * @see scheduler.configuration.LoadBalancingType
	 * @generated
	 */
	EEnum getLoadBalancingType();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.PreferredWaitingTime <em>Preferred Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Preferred Waiting Time</em>'.
	 * @see scheduler.configuration.PreferredWaitingTime
	 * @generated
	 */
	EEnum getPreferredWaitingTime();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.PreferredPriority <em>Preferred Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Preferred Priority</em>'.
	 * @see scheduler.configuration.PreferredPriority
	 * @generated
	 */
	EEnum getPreferredPriority();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.ResourceInstanceSelection <em>Resource Instance Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Instance Selection</em>'.
	 * @see scheduler.configuration.ResourceInstanceSelection
	 * @generated
	 */
	EEnum getResourceInstanceSelection();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.RunQueueType <em>Run Queue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Run Queue Type</em>'.
	 * @see scheduler.configuration.RunQueueType
	 * @generated
	 */
	EEnum getRunQueueType();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.PriorityClass <em>Priority Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority Class</em>'.
	 * @see scheduler.configuration.PriorityClass
	 * @generated
	 */
	EEnum getPriorityClass();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.PriorityDegradation <em>Priority Degradation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority Degradation</em>'.
	 * @see scheduler.configuration.PriorityDegradation
	 * @generated
	 */
	EEnum getPriorityDegradation();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.ProcessSelection <em>Process Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Process Selection</em>'.
	 * @see scheduler.configuration.ProcessSelection
	 * @generated
	 */
	EEnum getProcessSelection();

	/**
	 * Returns the meta object for enum '{@link scheduler.configuration.PassiveResourceType <em>Passive Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Passive Resource Type</em>'.
	 * @see scheduler.configuration.PassiveResourceType
	 * @generated
	 */
	EEnum getPassiveResourceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

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
		 * The meta object literal for the '{@link scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl <em>Dynamic Priority Boost Configuratioin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getDynamicPriorityBoostConfiguratioin()
		 * @generated
		 */
		EClass DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN = eINSTANCE.getDynamicPriorityBoostConfiguratioin();

		/**
		 * The meta object literal for the '<em><b>Max Bonus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS = eINSTANCE.getDynamicPriorityBoostConfiguratioin_MaxBonus();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD = eINSTANCE.getDynamicPriorityBoostConfiguratioin_Threshold();

		/**
		 * The meta object literal for the '<em><b>Max Sleep Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE = eINSTANCE.getDynamicPriorityBoostConfiguratioin_MaxSleepAverage();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PriorityBoostConfigurationImpl <em>Priority Boost Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PriorityBoostConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityBoostConfiguration()
		 * @generated
		 */
		EClass PRIORITY_BOOST_CONFIGURATION = eINSTANCE.getPriorityBoostConfiguration();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.LoadBalancingImpl <em>Load Balancing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.LoadBalancingImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getLoadBalancing()
		 * @generated
		 */
		EClass LOAD_BALANCING = eINSTANCE.getLoadBalancing();

		/**
		 * The meta object literal for the '<em><b>Balancing Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__BALANCING_TYPE = eINSTANCE.getLoadBalancing_BalancingType();

		/**
		 * The meta object literal for the '<em><b>Preferred Waiting Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__PREFERRED_WAITING_TIME = eINSTANCE.getLoadBalancing_PreferredWaitingTime();

		/**
		 * The meta object literal for the '<em><b>Preferred Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__PREFERRED_PRIORITY = eINSTANCE.getLoadBalancing_PreferredPriority();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__INSTANCES = eINSTANCE.getLoadBalancing_Instances();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__THRESHOLD = eINSTANCE.getLoadBalancing_Threshold();

		/**
		 * The meta object literal for the '<em><b>Max Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__MAX_ITERATIONS = eINSTANCE.getLoadBalancing_MaxIterations();

		/**
		 * The meta object literal for the '<em><b>Balancing Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_BALANCING__BALANCING_INTERVAL = eINSTANCE.getLoadBalancing_BalancingInterval();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.MultipleQueueConfigurationImpl <em>Multiple Queue Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.MultipleQueueConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getMultipleQueueConfiguration()
		 * @generated
		 */
		EClass MULTIPLE_QUEUE_CONFIGURATION = eINSTANCE.getMultipleQueueConfiguration();

		/**
		 * The meta object literal for the '<em><b>Load Balancing</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING = eINSTANCE.getMultipleQueueConfiguration_LoadBalancing();

		/**
		 * The meta object literal for the '<em><b>In Front When Balancing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING = eINSTANCE.getMultipleQueueConfiguration_InFrontWhenBalancing();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.QueueingConfigurationImpl <em>Queueing Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.QueueingConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getQueueingConfiguration()
		 * @generated
		 */
		EClass QUEUEING_CONFIGURATION = eINSTANCE.getQueueingConfiguration();

		/**
		 * The meta object literal for the '<em><b>Initial Instance Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION = eINSTANCE.getQueueingConfiguration_InitialInstanceSelection();

		/**
		 * The meta object literal for the '<em><b>Runqueue Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUEING_CONFIGURATION__RUNQUEUE_TYPE = eINSTANCE.getQueueingConfiguration_RunqueueType();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl <em>Quantum Time Slice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getQuantumTimeSliceConfiguration()
		 * @generated
		 */
		EClass QUANTUM_TIME_SLICE_CONFIGURATION = eINSTANCE.getQuantumTimeSliceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Quanta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA = eINSTANCE.getQuantumTimeSliceConfiguration_Quanta();

		/**
		 * The meta object literal for the '<em><b>Min Quanta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA = eINSTANCE.getQuantumTimeSliceConfiguration_MinQuanta();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.TimeSliceConfigurationImpl <em>Time Slice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.TimeSliceConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getTimeSliceConfiguration()
		 * @generated
		 */
		EClass TIME_SLICE_CONFIGURATION = eINSTANCE.getTimeSliceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Timeslice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SLICE_CONFIGURATION__TIMESLICE = eINSTANCE.getTimeSliceConfiguration_Timeslice();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PreemptionConfigurationImpl <em>Preemption Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PreemptionConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreemptionConfiguration()
		 * @generated
		 */
		EClass PREEMPTION_CONFIGURATION = eINSTANCE.getPreemptionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Timeslice Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION = eINSTANCE.getPreemptionConfiguration_TimesliceConfiguration();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PriorityConfigurationImpl <em>Priority Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PriorityConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityConfiguration()
		 * @generated
		 */
		EClass PRIORITY_CONFIGURATION = eINSTANCE.getPriorityConfiguration();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORITY_CONFIGURATION__RANGE = eINSTANCE.getPriorityConfiguration_Range();

		/**
		 * The meta object literal for the '<em><b>Boost Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORITY_CONFIGURATION__BOOST_CONFIGURATION = eINSTANCE.getPriorityConfiguration_BoostConfiguration();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PriorityRangeImpl <em>Priority Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PriorityRangeImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityRange()
		 * @generated
		 */
		EClass PRIORITY_RANGE = eINSTANCE.getPriorityRange();

		/**
		 * The meta object literal for the '<em><b>Highest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__HIGHEST = eINSTANCE.getPriorityRange_Highest();

		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__HIGH = eINSTANCE.getPriorityRange_High();

		/**
		 * The meta object literal for the '<em><b>Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__AVERAGE = eINSTANCE.getPriorityRange_Average();

		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__LOW = eINSTANCE.getPriorityRange_Low();

		/**
		 * The meta object literal for the '<em><b>Lowest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__LOWEST = eINSTANCE.getPriorityRange_Lowest();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_RANGE__DEFAULT = eINSTANCE.getPriorityRange_Default();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl <em>Priority Dependent Time Slice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityDependentTimeSliceConfiguration()
		 * @generated
		 */
		EClass PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION = eINSTANCE.getPriorityDependentTimeSliceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Min Timeslice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE = eINSTANCE.getPriorityDependentTimeSliceConfiguration_MinTimeslice();

		/**
		 * The meta object literal for the '<em><b>Min Time To Be Scheduled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED = eINSTANCE.getPriorityDependentTimeSliceConfiguration_MinTimeToBeScheduled();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.ActiveResourceConfigurationImpl <em>Active Resource Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.ActiveResourceConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getActiveResourceConfiguration()
		 * @generated
		 */
		EClass ACTIVE_RESOURCE_CONFIGURATION = eINSTANCE.getActiveResourceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Scheduler Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION = eINSTANCE.getActiveResourceConfiguration_SchedulerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVE_RESOURCE_CONFIGURATION__REPLICAS = eINSTANCE.getActiveResourceConfiguration_Replicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVE_RESOURCE_CONFIGURATION__NAME = eINSTANCE.getActiveResourceConfiguration_Name();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl <em>Passive Resource Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.PassiveResourceConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPassiveResourceConfiguration()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE_CONFIGURATION = eINSTANCE.getPassiveResourceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Static Priority Boost Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION = eINSTANCE.getPassiveResourceConfiguration_StaticPriorityBoostConfiguration();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE_CONFIGURATION__CAPACITY = eINSTANCE.getPassiveResourceConfiguration_Capacity();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE_CONFIGURATION__TYPE = eINSTANCE.getPassiveResourceConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE_CONFIGURATION__NAME = eINSTANCE.getPassiveResourceConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Managing Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE = eINSTANCE.getPassiveResourceConfiguration_ManagingResource();

		/**
		 * The meta object literal for the '<em><b>Acquisition Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND = eINSTANCE.getPassiveResourceConfiguration_AcquisitionDemand();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.StaticPriorityBoostImpl <em>Static Priority Boost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.StaticPriorityBoostImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStaticPriorityBoost()
		 * @generated
		 */
		EClass STATIC_PRIORITY_BOOST = eINSTANCE.getStaticPriorityBoost();

		/**
		 * The meta object literal for the '<em><b>Reset Timeslice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PRIORITY_BOOST__RESET_TIMESLICE = eINSTANCE.getStaticPriorityBoost_ResetTimeslice();

		/**
		 * The meta object literal for the '<em><b>Bonus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PRIORITY_BOOST__BONUS = eINSTANCE.getStaticPriorityBoost_Bonus();

		/**
		 * The meta object literal for the '<em><b>Degradation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PRIORITY_BOOST__DEGRADATION = eINSTANCE.getStaticPriorityBoost_Degradation();

		/**
		 * The meta object literal for the '<em><b>Time Penalty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PRIORITY_BOOST__TIME_PENALTY = eINSTANCE.getStaticPriorityBoost_TimePenalty();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.ProcessConfigurationImpl <em>Process Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.ProcessConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getProcessConfiguration()
		 * @generated
		 */
		EClass PROCESS_CONFIGURATION = eINSTANCE.getProcessConfiguration();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_CONFIGURATION__PRIORITY = eINSTANCE.getProcessConfiguration_Priority();

		/**
		 * The meta object literal for the '<em><b>Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_CONFIGURATION__REPLICAS = eINSTANCE.getProcessConfiguration_Replicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_CONFIGURATION__NAME = eINSTANCE.getProcessConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Affinity List</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_CONFIGURATION__AFFINITY_LIST = eINSTANCE.getProcessConfiguration_AffinityList();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.SingleQueueConfigurationImpl <em>Single Queue Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.SingleQueueConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getSingleQueueConfiguration()
		 * @generated
		 */
		EClass SINGLE_QUEUE_CONFIGURATION = eINSTANCE.getSingleQueueConfiguration();

		/**
		 * The meta object literal for the '<em><b>Process Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION = eINSTANCE.getSingleQueueConfiguration_ProcessSelection();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.StaticPriorityBoostConfigurationImpl <em>Static Priority Boost Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.StaticPriorityBoostConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStaticPriorityBoostConfiguration()
		 * @generated
		 */
		EClass STATIC_PRIORITY_BOOST_CONFIGURATION = eINSTANCE.getStaticPriorityBoostConfiguration();

		/**
		 * The meta object literal for the '<em><b>Starvation Boost</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST = eINSTANCE.getStaticPriorityBoostConfiguration_StarvationBoost();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.SchedulerConfigurationImpl <em>Scheduler Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.SchedulerConfigurationImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getSchedulerConfiguration()
		 * @generated
		 */
		EClass SCHEDULER_CONFIGURATION = eINSTANCE.getSchedulerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Priority Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION = eINSTANCE.getSchedulerConfiguration_PriorityConfiguration();

		/**
		 * The meta object literal for the '<em><b>Preemption Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION = eINSTANCE.getSchedulerConfiguration_PreemptionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_CONFIGURATION__NAME = eINSTANCE.getSchedulerConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Queueing Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION = eINSTANCE.getSchedulerConfiguration_QueueingConfiguration();

		/**
		 * The meta object literal for the '<em><b>In Front After Waiting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING = eINSTANCE.getSchedulerConfiguration_InFrontAfterWaiting();

		/**
		 * The meta object literal for the '<em><b>Windows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_CONFIGURATION__WINDOWS = eINSTANCE.getSchedulerConfiguration_Windows();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_CONFIGURATION__INTERVAL = eINSTANCE.getSchedulerConfiguration_Interval();

		/**
		 * The meta object literal for the '<em><b>Starvation Boost</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CONFIGURATION__STARVATION_BOOST = eINSTANCE.getSchedulerConfiguration_StarvationBoost();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.impl.StarvationBoostImpl <em>Starvation Boost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.impl.StarvationBoostImpl
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getStarvationBoost()
		 * @generated
		 */
		EClass STARVATION_BOOST = eINSTANCE.getStarvationBoost();

		/**
		 * The meta object literal for the '<em><b>Starvation Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARVATION_BOOST__STARVATION_LIMIT = eINSTANCE.getStarvationBoost_StarvationLimit();

		/**
		 * The meta object literal for the '<em><b>Boost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARVATION_BOOST__BOOST = eINSTANCE.getStarvationBoost_Boost();

		/**
		 * The meta object literal for the '<em><b>Duration In Timeslices</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARVATION_BOOST__DURATION_IN_TIMESLICES = eINSTANCE.getStarvationBoost_DurationInTimeslices();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.InstanceToBalance <em>Instance To Balance</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.InstanceToBalance
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getInstanceToBalance()
		 * @generated
		 */
		EEnum INSTANCE_TO_BALANCE = eINSTANCE.getInstanceToBalance();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.LoadBalancingType <em>Load Balancing Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.LoadBalancingType
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getLoadBalancingType()
		 * @generated
		 */
		EEnum LOAD_BALANCING_TYPE = eINSTANCE.getLoadBalancingType();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.PreferredWaitingTime <em>Preferred Waiting Time</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.PreferredWaitingTime
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreferredWaitingTime()
		 * @generated
		 */
		EEnum PREFERRED_WAITING_TIME = eINSTANCE.getPreferredWaitingTime();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.PreferredPriority <em>Preferred Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.PreferredPriority
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPreferredPriority()
		 * @generated
		 */
		EEnum PREFERRED_PRIORITY = eINSTANCE.getPreferredPriority();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.ResourceInstanceSelection <em>Resource Instance Selection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.ResourceInstanceSelection
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getResourceInstanceSelection()
		 * @generated
		 */
		EEnum RESOURCE_INSTANCE_SELECTION = eINSTANCE.getResourceInstanceSelection();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.RunQueueType <em>Run Queue Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.RunQueueType
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getRunQueueType()
		 * @generated
		 */
		EEnum RUN_QUEUE_TYPE = eINSTANCE.getRunQueueType();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.PriorityClass <em>Priority Class</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.PriorityClass
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityClass()
		 * @generated
		 */
		EEnum PRIORITY_CLASS = eINSTANCE.getPriorityClass();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.PriorityDegradation <em>Priority Degradation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.PriorityDegradation
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPriorityDegradation()
		 * @generated
		 */
		EEnum PRIORITY_DEGRADATION = eINSTANCE.getPriorityDegradation();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.ProcessSelection <em>Process Selection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.ProcessSelection
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getProcessSelection()
		 * @generated
		 */
		EEnum PROCESS_SELECTION = eINSTANCE.getProcessSelection();

		/**
		 * The meta object literal for the '{@link scheduler.configuration.PassiveResourceType <em>Passive Resource Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.configuration.PassiveResourceType
		 * @see scheduler.configuration.impl.ConfigurationPackageImpl#getPassiveResourceType()
		 * @generated
		 */
		EEnum PASSIVE_RESOURCE_TYPE = eINSTANCE.getPassiveResourceType();

	}

} //ConfigurationPackage
