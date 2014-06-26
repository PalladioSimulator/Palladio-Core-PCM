/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;

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
 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory
 * @model kind="package"
 * @generated
 */
public interface AbstractSimulationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "abstractsimulation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/AbstractSimulation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ExperimentAutomation.Experiments.AbstractSimulation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractSimulationPackage eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getAbstractSimulationConfiguration()
	 * @generated
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__NAME = ExperimentsPackage.TOOL_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Persistence Framework</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stop Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Random Number Generator Seed</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Simulate Linking Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Simulate Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Probe Spec Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SIMULATION_CONFIGURATION_FEATURE_COUNT = ExperimentsPackage.TOOL_CONFIGURATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.PersistenceFrameworkImpl <em>Persistence Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.PersistenceFrameworkImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getPersistenceFramework()
	 * @generated
	 */
	int PERSISTENCE_FRAMEWORK = 1;

	/**
	 * The number of structural features of the '<em>Persistence Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_FRAMEWORK_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl <em>Random Number Generator Seed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getRandomNumberGeneratorSeed()
	 * @generated
	 */
	int RANDOM_NUMBER_GENERATOR_SEED = 2;

	/**
	 * The feature id for the '<em><b>Seed0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED0 = 0;

	/**
	 * The feature id for the '<em><b>Seed1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED1 = 1;

	/**
	 * The feature id for the '<em><b>Seed2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED2 = 2;

	/**
	 * The feature id for the '<em><b>Seed3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED3 = 3;

	/**
	 * The feature id for the '<em><b>Seed4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED4 = 4;

	/**
	 * The feature id for the '<em><b>Seed5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED__SEED5 = 5;

	/**
	 * The number of structural features of the '<em>Random Number Generator Seed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_GENERATOR_SEED_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.ProbeSpecConfigurationImpl <em>Probe Spec Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.ProbeSpecConfigurationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getProbeSpecConfiguration()
	 * @generated
	 */
	int PROBE_SPEC_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Blackboard Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Probe Spec Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBE_SPEC_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkImpl <em>Sensor Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSensorFramework()
	 * @generated
	 */
	int SENSOR_FRAMEWORK = 4;

	/**
	 * The feature id for the '<em><b>Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK__DATASOURCE = PERSISTENCE_FRAMEWORK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sensor Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_FEATURE_COUNT = PERSISTENCE_FRAMEWORK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkDatasourceImpl <em>Sensor Framework Datasource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkDatasourceImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSensorFrameworkDatasource()
	 * @generated
	 */
	int SENSOR_FRAMEWORK_DATASOURCE = 5;

	/**
	 * The number of structural features of the '<em>Sensor Framework Datasource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_DATASOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MemoryDatasourceImpl <em>Memory Datasource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MemoryDatasourceImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getMemoryDatasource()
	 * @generated
	 */
	int MEMORY_DATASOURCE = 6;

	/**
	 * The number of structural features of the '<em>Memory Datasource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DATASOURCE_FEATURE_COUNT = SENSOR_FRAMEWORK_DATASOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.FileDatasourceImpl <em>File Datasource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.FileDatasourceImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getFileDatasource()
	 * @generated
	 */
	int FILE_DATASOURCE = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DATASOURCE__LOCATION = SENSOR_FRAMEWORK_DATASOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Datasource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DATASOURCE_FEATURE_COUNT = SENSOR_FRAMEWORK_DATASOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.StopConditionImpl <em>Stop Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.StopConditionImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getStopCondition()
	 * @generated
	 */
	int STOP_CONDITION = 10;

	/**
	 * The number of structural features of the '<em>Stop Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_CONDITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MeasurementCountStopConditionImpl <em>Measurement Count Stop Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MeasurementCountStopConditionImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getMeasurementCountStopCondition()
	 * @generated
	 */
	int MEASUREMENT_COUNT_STOP_CONDITION = 8;

	/**
	 * The feature id for the '<em><b>Measurement Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT = STOP_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Measurement Count Stop Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_COUNT_STOP_CONDITION_FEATURE_COUNT = STOP_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SimTimeStopConditionImpl <em>Sim Time Stop Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SimTimeStopConditionImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSimTimeStopCondition()
	 * @generated
	 */
	int SIM_TIME_STOP_CONDITION = 9;

	/**
	 * The feature id for the '<em><b>Simulation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TIME_STOP_CONDITION__SIMULATION_TIME = STOP_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sim Time Stop Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TIME_STOP_CONDITION_FEATURE_COUNT = STOP_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType <em>Blackboard Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getBlackboardType()
	 * @generated
	 */
	int BLACKBOARD_TYPE = 11;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration
	 * @generated
	 */
	EClass getAbstractSimulationConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getPersistenceFramework <em>Persistence Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Persistence Framework</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getPersistenceFramework()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EReference getAbstractSimulationConfiguration_PersistenceFramework();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getStopConditions <em>Stop Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stop Conditions</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getStopConditions()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EReference getAbstractSimulationConfiguration_StopConditions();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getRandomNumberGeneratorSeed <em>Random Number Generator Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Random Number Generator Seed</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getRandomNumberGeneratorSeed()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EReference getAbstractSimulationConfiguration_RandomNumberGeneratorSeed();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#isSimulateLinkingResources <em>Simulate Linking Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulate Linking Resources</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#isSimulateLinkingResources()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EAttribute getAbstractSimulationConfiguration_SimulateLinkingResources();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#isSimulateFailures <em>Simulate Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulate Failures</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#isSimulateFailures()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EAttribute getAbstractSimulationConfiguration_SimulateFailures();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getProbeSpecConfiguration <em>Probe Spec Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Probe Spec Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration#getProbeSpecConfiguration()
	 * @see #getAbstractSimulationConfiguration()
	 * @generated
	 */
	EReference getAbstractSimulationConfiguration_ProbeSpecConfiguration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.PersistenceFramework <em>Persistence Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persistence Framework</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.PersistenceFramework
	 * @generated
	 */
	EClass getPersistenceFramework();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed <em>Random Number Generator Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Number Generator Seed</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed
	 * @generated
	 */
	EClass getRandomNumberGeneratorSeed();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed0 <em>Seed0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed0</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed0()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed0();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed1 <em>Seed1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed1</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed1()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed1();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed2 <em>Seed2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed2</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed2()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed2();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed3 <em>Seed3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed3</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed3()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed3();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed4 <em>Seed4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed4</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed4()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed4();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed5 <em>Seed5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed5</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed#getSeed5()
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 */
	EAttribute getRandomNumberGeneratorSeed_Seed5();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration <em>Probe Spec Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probe Spec Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration
	 * @generated
	 */
	EClass getProbeSpecConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration#getBlackboardType <em>Blackboard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blackboard Type</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration#getBlackboardType()
	 * @see #getProbeSpecConfiguration()
	 * @generated
	 */
	EAttribute getProbeSpecConfiguration_BlackboardType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework <em>Sensor Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework
	 * @generated
	 */
	EClass getSensorFramework();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework#getDatasource <em>Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Datasource</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework#getDatasource()
	 * @see #getSensorFramework()
	 * @generated
	 */
	EReference getSensorFramework_Datasource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource <em>Sensor Framework Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework Datasource</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource
	 * @generated
	 */
	EClass getSensorFrameworkDatasource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MemoryDatasource <em>Memory Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Datasource</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MemoryDatasource
	 * @generated
	 */
	EClass getMemoryDatasource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource <em>File Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Datasource</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource
	 * @generated
	 */
	EClass getFileDatasource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource#getLocation()
	 * @see #getFileDatasource()
	 * @generated
	 */
	EAttribute getFileDatasource_Location();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition <em>Measurement Count Stop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Count Stop Condition</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition
	 * @generated
	 */
	EClass getMeasurementCountStopCondition();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition#getMeasurementCount <em>Measurement Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measurement Count</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition#getMeasurementCount()
	 * @see #getMeasurementCountStopCondition()
	 * @generated
	 */
	EAttribute getMeasurementCountStopCondition_MeasurementCount();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition <em>Sim Time Stop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sim Time Stop Condition</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition
	 * @generated
	 */
	EClass getSimTimeStopCondition();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition#getSimulationTime <em>Simulation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Time</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition#getSimulationTime()
	 * @see #getSimTimeStopCondition()
	 * @generated
	 */
	EAttribute getSimTimeStopCondition_SimulationTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition <em>Stop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Condition</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition
	 * @generated
	 */
	EClass getStopCondition();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType <em>Blackboard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Blackboard Type</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType
	 * @generated
	 */
	EEnum getBlackboardType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AbstractSimulationFactory getAbstractSimulationFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getAbstractSimulationConfiguration()
		 * @generated
		 */
		EClass ABSTRACT_SIMULATION_CONFIGURATION = eINSTANCE.getAbstractSimulationConfiguration();

		/**
		 * The meta object literal for the '<em><b>Persistence Framework</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK = eINSTANCE.getAbstractSimulationConfiguration_PersistenceFramework();

		/**
		 * The meta object literal for the '<em><b>Stop Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS = eINSTANCE.getAbstractSimulationConfiguration_StopConditions();

		/**
		 * The meta object literal for the '<em><b>Random Number Generator Seed</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED = eINSTANCE.getAbstractSimulationConfiguration_RandomNumberGeneratorSeed();

		/**
		 * The meta object literal for the '<em><b>Simulate Linking Resources</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES = eINSTANCE.getAbstractSimulationConfiguration_SimulateLinkingResources();

		/**
		 * The meta object literal for the '<em><b>Simulate Failures</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES = eINSTANCE.getAbstractSimulationConfiguration_SimulateFailures();

		/**
		 * The meta object literal for the '<em><b>Probe Spec Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION = eINSTANCE.getAbstractSimulationConfiguration_ProbeSpecConfiguration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.PersistenceFrameworkImpl <em>Persistence Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.PersistenceFrameworkImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getPersistenceFramework()
		 * @generated
		 */
		EClass PERSISTENCE_FRAMEWORK = eINSTANCE.getPersistenceFramework();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl <em>Random Number Generator Seed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getRandomNumberGeneratorSeed()
		 * @generated
		 */
		EClass RANDOM_NUMBER_GENERATOR_SEED = eINSTANCE.getRandomNumberGeneratorSeed();

		/**
		 * The meta object literal for the '<em><b>Seed0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED0 = eINSTANCE.getRandomNumberGeneratorSeed_Seed0();

		/**
		 * The meta object literal for the '<em><b>Seed1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED1 = eINSTANCE.getRandomNumberGeneratorSeed_Seed1();

		/**
		 * The meta object literal for the '<em><b>Seed2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED2 = eINSTANCE.getRandomNumberGeneratorSeed_Seed2();

		/**
		 * The meta object literal for the '<em><b>Seed3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED3 = eINSTANCE.getRandomNumberGeneratorSeed_Seed3();

		/**
		 * The meta object literal for the '<em><b>Seed4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED4 = eINSTANCE.getRandomNumberGeneratorSeed_Seed4();

		/**
		 * The meta object literal for the '<em><b>Seed5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_NUMBER_GENERATOR_SEED__SEED5 = eINSTANCE.getRandomNumberGeneratorSeed_Seed5();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.ProbeSpecConfigurationImpl <em>Probe Spec Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.ProbeSpecConfigurationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getProbeSpecConfiguration()
		 * @generated
		 */
		EClass PROBE_SPEC_CONFIGURATION = eINSTANCE.getProbeSpecConfiguration();

		/**
		 * The meta object literal for the '<em><b>Blackboard Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE = eINSTANCE.getProbeSpecConfiguration_BlackboardType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkImpl <em>Sensor Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSensorFramework()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK = eINSTANCE.getSensorFramework();

		/**
		 * The meta object literal for the '<em><b>Datasource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENSOR_FRAMEWORK__DATASOURCE = eINSTANCE.getSensorFramework_Datasource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkDatasourceImpl <em>Sensor Framework Datasource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SensorFrameworkDatasourceImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSensorFrameworkDatasource()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK_DATASOURCE = eINSTANCE.getSensorFrameworkDatasource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MemoryDatasourceImpl <em>Memory Datasource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MemoryDatasourceImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getMemoryDatasource()
		 * @generated
		 */
		EClass MEMORY_DATASOURCE = eINSTANCE.getMemoryDatasource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.FileDatasourceImpl <em>File Datasource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.FileDatasourceImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getFileDatasource()
		 * @generated
		 */
		EClass FILE_DATASOURCE = eINSTANCE.getFileDatasource();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_DATASOURCE__LOCATION = eINSTANCE.getFileDatasource_Location();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MeasurementCountStopConditionImpl <em>Measurement Count Stop Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MeasurementCountStopConditionImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getMeasurementCountStopCondition()
		 * @generated
		 */
		EClass MEASUREMENT_COUNT_STOP_CONDITION = eINSTANCE.getMeasurementCountStopCondition();

		/**
		 * The meta object literal for the '<em><b>Measurement Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT = eINSTANCE.getMeasurementCountStopCondition_MeasurementCount();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SimTimeStopConditionImpl <em>Sim Time Stop Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.SimTimeStopConditionImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getSimTimeStopCondition()
		 * @generated
		 */
		EClass SIM_TIME_STOP_CONDITION = eINSTANCE.getSimTimeStopCondition();

		/**
		 * The meta object literal for the '<em><b>Simulation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TIME_STOP_CONDITION__SIMULATION_TIME = eINSTANCE.getSimTimeStopCondition_SimulationTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.StopConditionImpl <em>Stop Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.StopConditionImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getStopCondition()
		 * @generated
		 */
		EClass STOP_CONDITION = eINSTANCE.getStopCondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType <em>Blackboard Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationPackageImpl#getBlackboardType()
		 * @generated
		 */
		EEnum BLACKBOARD_TYPE = eINSTANCE.getBlackboardType();

	}

} //AbstractSimulationPackage
