/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;

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
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsFactory
 * @model kind="package"
 * @generated
 */
public interface ExperimentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "experiments";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ExperimentAutomation.Experiments";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentsPackage eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl <em>Experiment Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperimentRepository()
	 * @generated
	 */
	int EXPERIMENT_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Experiments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_REPOSITORY__EXPERIMENTS = 0;

	/**
	 * The feature id for the '<em><b>Tool Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Repetitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_REPOSITORY__REPETITIONS = 2;

	/**
	 * The number of structural features of the '<em>Experiment Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_REPOSITORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl <em>Experiment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperiment()
	 * @generated
	 */
	int EXPERIMENT = 1;

	/**
	 * The feature id for the '<em><b>Variations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__VARIATIONS = 0;

	/**
	 * The feature id for the '<em><b>Modifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__MODIFICATIONS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__ID = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Initial Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__INITIAL_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Tool Configuration</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__TOOL_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Stop Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__STOP_CONDITIONS = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Experiment Design</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__EXPERIMENT_DESIGN = 8;

	/**
	 * The feature id for the '<em><b>Response Measurement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT__RESPONSE_MEASUREMENT = 9;

	/**
	 * The number of structural features of the '<em>Experiment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl <em>Variation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getVariation()
	 * @generated
	 */
	int VARIATION = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Value Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__VALUE_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__MIN_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__MAX_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Max Variations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__MAX_VARIATIONS = 4;

	/**
	 * The feature id for the '<em><b>Varied Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__VARIED_OBJECT_ID = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION__NAME = 6;

	/**
	 * The number of structural features of the '<em>Variation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ValueProviderImpl <em>Value Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ValueProviderImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getValueProvider()
	 * @generated
	 */
	int VALUE_PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Value Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl <em>PCM Model Files</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPCMModelFiles()
	 * @generated
	 */
	int PCM_MODEL_FILES = 4;

	/**
	 * The feature id for the '<em><b>Allocation File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__ALLOCATION_FILE = 0;

	/**
	 * The feature id for the '<em><b>Usagemodel File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__USAGEMODEL_FILE = 1;

	/**
	 * The feature id for the '<em><b>System File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__SYSTEM_FILE = 2;

	/**
	 * The feature id for the '<em><b>Repository File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__REPOSITORY_FILE = 3;

	/**
	 * The feature id for the '<em><b>Resourceenvironment File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE = 4;

	/**
	 * The feature id for the '<em><b>Middleware Repository File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE = 5;

	/**
	 * The feature id for the '<em><b>Event Middleware Repository File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE = 6;

	/**
	 * The number of structural features of the '<em>PCM Model Files</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_MODEL_FILES_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl <em>Tool Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getToolConfiguration()
	 * @generated
	 */
	int TOOL_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Tool Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentDesignImpl <em>Experiment Design</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentDesignImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperimentDesign()
	 * @generated
	 */
	int EXPERIMENT_DESIGN = 6;

	/**
	 * The number of structural features of the '<em>Experiment Design</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_DESIGN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ResponseMeasurementImpl <em>Response Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ResponseMeasurementImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getResponseMeasurement()
	 * @generated
	 */
	int RESPONSE_MEASUREMENT = 7;

	/**
	 * The number of structural features of the '<em>Response Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_MEASUREMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PolynomialValueProviderImpl <em>Polynomial Value Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PolynomialValueProviderImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPolynomialValueProvider()
	 * @generated
	 */
	int POLYNOMIAL_VALUE_PROVIDER = 8;

	/**
	 * The feature id for the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VALUE_PROVIDER__EXPONENT = VALUE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VALUE_PROVIDER__FACTOR = VALUE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Polynomial Value Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYNOMIAL_VALUE_PROVIDER_FEATURE_COUNT = VALUE_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExponentialValueProviderImpl <em>Exponential Value Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExponentialValueProviderImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExponentialValueProvider()
	 * @generated
	 */
	int EXPONENTIAL_VALUE_PROVIDER = 9;

	/**
	 * The feature id for the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_VALUE_PROVIDER__BASE = VALUE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exponential Value Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_VALUE_PROVIDER_FEATURE_COUNT = VALUE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.SetValueProviderImpl <em>Set Value Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.SetValueProviderImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getSetValueProvider()
	 * @generated
	 */
	int SET_VALUE_PROVIDER = 10;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_PROVIDER__VALUES = VALUE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Value Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_PROVIDER_FEATURE_COUNT = VALUE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PlacketBurmanDesignImpl <em>Placket Burman Design</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PlacketBurmanDesignImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPlacketBurmanDesign()
	 * @generated
	 */
	int PLACKET_BURMAN_DESIGN = 11;

	/**
	 * The number of structural features of the '<em>Placket Burman Design</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACKET_BURMAN_DESIGN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.FullFactorialDesignImpl <em>Full Factorial Design</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.FullFactorialDesignImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getFullFactorialDesign()
	 * @generated
	 */
	int FULL_FACTORIAL_DESIGN = 12;

	/**
	 * The number of structural features of the '<em>Full Factorial Design</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_FACTORIAL_DESIGN_FEATURE_COUNT = EXPERIMENT_DESIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.FractionalFactorialDesignImpl <em>Fractional Factorial Design</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.FractionalFactorialDesignImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getFractionalFactorialDesign()
	 * @generated
	 */
	int FRACTIONAL_FACTORIAL_DESIGN = 13;

	/**
	 * The number of structural features of the '<em>Fractional Factorial Design</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRACTIONAL_FACTORIAL_DESIGN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.OneFactorAtATimeImpl <em>One Factor At ATime</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.OneFactorAtATimeImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getOneFactorAtATime()
	 * @generated
	 */
	int ONE_FACTOR_AT_ATIME = 14;

	/**
	 * The number of structural features of the '<em>One Factor At ATime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_FACTOR_AT_ATIME_FEATURE_COUNT = EXPERIMENT_DESIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.SimulationDurationMeasurementImpl <em>Simulation Duration Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.SimulationDurationMeasurementImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getSimulationDurationMeasurement()
	 * @generated
	 */
	int SIMULATION_DURATION_MEASUREMENT = 15;

	/**
	 * The number of structural features of the '<em>Simulation Duration Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DURATION_MEASUREMENT_FEATURE_COUNT = RESPONSE_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ProfilingMeasurementImpl <em>Profiling Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ProfilingMeasurementImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getProfilingMeasurement()
	 * @generated
	 */
	int PROFILING_MEASUREMENT = 16;

	/**
	 * The number of structural features of the '<em>Profiling Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MEASUREMENT_FEATURE_COUNT = RESPONSE_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.JMXMeasurementImpl <em>JMX Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.JMXMeasurementImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getJMXMeasurement()
	 * @generated
	 */
	int JMX_MEASUREMENT = 17;

	/**
	 * The feature id for the '<em><b>Polling Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMX_MEASUREMENT__POLLING_PERIOD = RESPONSE_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JMX Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMX_MEASUREMENT_FEATURE_COUNT = RESPONSE_MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.LinearValueProviderImpl <em>Linear Value Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.LinearValueProviderImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getLinearValueProvider()
	 * @generated
	 */
	int LINEAR_VALUE_PROVIDER = 18;

	/**
	 * The feature id for the '<em><b>Summand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_VALUE_PROVIDER__SUMMAND = VALUE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_VALUE_PROVIDER__FACTOR = VALUE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Linear Value Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_VALUE_PROVIDER_FEATURE_COUNT = VALUE_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ModificationImpl <em>Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ModificationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getModification()
	 * @generated
	 */
	int MODIFICATION = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Varied Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__VARIED_OBJECT_ID = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository <em>Experiment Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Repository</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository
	 * @generated
	 */
	EClass getExperimentRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getExperiments <em>Experiments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Experiments</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getExperiments()
	 * @see #getExperimentRepository()
	 * @generated
	 */
	EReference getExperimentRepository_Experiments();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getToolConfiguration <em>Tool Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tool Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getToolConfiguration()
	 * @see #getExperimentRepository()
	 * @generated
	 */
	EReference getExperimentRepository_ToolConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getRepetitions <em>Repetitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repetitions</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getRepetitions()
	 * @see #getExperimentRepository()
	 * @generated
	 */
	EAttribute getExperimentRepository_Repetitions();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment <em>Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment
	 * @generated
	 */
	EClass getExperiment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getVariations <em>Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variations</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getVariations()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_Variations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getModifications <em>Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifications</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getModifications()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_Modifications();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getId()
	 * @see #getExperiment()
	 * @generated
	 */
	EAttribute getExperiment_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getName()
	 * @see #getExperiment()
	 * @generated
	 */
	EAttribute getExperiment_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getInitialModel <em>Initial Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Model</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getInitialModel()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_InitialModel();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getToolConfiguration <em>Tool Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tool Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getToolConfiguration()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_ToolConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getStopConditions <em>Stop Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stop Conditions</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getStopConditions()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_StopConditions();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getDescription()
	 * @see #getExperiment()
	 * @generated
	 */
	EAttribute getExperiment_Description();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getExperimentDesign <em>Experiment Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Experiment Design</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getExperimentDesign()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_ExperimentDesign();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getResponseMeasurement <em>Response Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response Measurement</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment#getResponseMeasurement()
	 * @see #getExperiment()
	 * @generated
	 */
	EReference getExperiment_ResponseMeasurement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation <em>Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation
	 * @generated
	 */
	EClass getVariation();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getType()
	 * @see #getVariation()
	 * @generated
	 */
	EReference getVariation_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getValueProvider <em>Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getValueProvider()
	 * @see #getVariation()
	 * @generated
	 */
	EReference getVariation_ValueProvider();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMinValue()
	 * @see #getVariation()
	 * @generated
	 */
	EAttribute getVariation_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxValue()
	 * @see #getVariation()
	 * @generated
	 */
	EAttribute getVariation_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxVariations <em>Max Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Variations</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxVariations()
	 * @see #getVariation()
	 * @generated
	 */
	EAttribute getVariation_MaxVariations();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getVariedObjectId <em>Varied Object Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varied Object Id</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getVariedObjectId()
	 * @see #getVariation()
	 * @generated
	 */
	EAttribute getVariation_VariedObjectId();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation#getName()
	 * @see #getVariation()
	 * @generated
	 */
	EAttribute getVariation_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider <em>Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider
	 * @generated
	 */
	EClass getValueProvider();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles <em>PCM Model Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Model Files</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles
	 * @generated
	 */
	EClass getPCMModelFiles();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getAllocationFile <em>Allocation File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allocation File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getAllocationFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_AllocationFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getUsagemodelFile <em>Usagemodel File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usagemodel File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getUsagemodelFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_UsagemodelFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getSystemFile <em>System File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getSystemFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_SystemFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getRepositoryFile <em>Repository File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getRepositoryFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_RepositoryFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getResourceenvironmentFile <em>Resourceenvironment File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resourceenvironment File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getResourceenvironmentFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_ResourceenvironmentFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getMiddlewareRepositoryFile <em>Middleware Repository File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middleware Repository File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getMiddlewareRepositoryFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_MiddlewareRepositoryFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getEventMiddlewareRepositoryFile <em>Event Middleware Repository File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Middleware Repository File</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles#getEventMiddlewareRepositoryFile()
	 * @see #getPCMModelFiles()
	 * @generated
	 */
	EAttribute getPCMModelFiles_EventMiddlewareRepositoryFile();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration <em>Tool Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration
	 * @generated
	 */
	EClass getToolConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration#getName()
	 * @see #getToolConfiguration()
	 * @generated
	 */
	EAttribute getToolConfiguration_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign <em>Experiment Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Design</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign
	 * @generated
	 */
	EClass getExperimentDesign();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement <em>Response Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Measurement</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement
	 * @generated
	 */
	EClass getResponseMeasurement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider <em>Polynomial Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polynomial Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider
	 * @generated
	 */
	EClass getPolynomialValueProvider();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getExponent()
	 * @see #getPolynomialValueProvider()
	 * @generated
	 */
	EAttribute getPolynomialValueProvider_Exponent();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getFactor()
	 * @see #getPolynomialValueProvider()
	 * @generated
	 */
	EAttribute getPolynomialValueProvider_Factor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider <em>Exponential Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exponential Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider
	 * @generated
	 */
	EClass getExponentialValueProvider();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider#getBase()
	 * @see #getExponentialValueProvider()
	 * @generated
	 */
	EAttribute getExponentialValueProvider_Base();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider <em>Set Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider
	 * @generated
	 */
	EClass getSetValueProvider();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider#getValues()
	 * @see #getSetValueProvider()
	 * @generated
	 */
	EAttribute getSetValueProvider_Values();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign <em>Placket Burman Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placket Burman Design</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign
	 * @generated
	 */
	EClass getPlacketBurmanDesign();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.FullFactorialDesign <em>Full Factorial Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Full Factorial Design</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.FullFactorialDesign
	 * @generated
	 */
	EClass getFullFactorialDesign();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.FractionalFactorialDesign <em>Fractional Factorial Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fractional Factorial Design</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.FractionalFactorialDesign
	 * @generated
	 */
	EClass getFractionalFactorialDesign();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime <em>One Factor At ATime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>One Factor At ATime</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime
	 * @generated
	 */
	EClass getOneFactorAtATime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement <em>Simulation Duration Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Duration Measurement</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement
	 * @generated
	 */
	EClass getSimulationDurationMeasurement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement <em>Profiling Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiling Measurement</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement
	 * @generated
	 */
	EClass getProfilingMeasurement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement <em>JMX Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMX Measurement</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement
	 * @generated
	 */
	EClass getJMXMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement#getPollingPeriod <em>Polling Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polling Period</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement#getPollingPeriod()
	 * @see #getJMXMeasurement()
	 * @generated
	 */
	EAttribute getJMXMeasurement_PollingPeriod();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider <em>Linear Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Value Provider</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider
	 * @generated
	 */
	EClass getLinearValueProvider();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getSummand <em>Summand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Summand</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getSummand()
	 * @see #getLinearValueProvider()
	 * @generated
	 */
	EAttribute getLinearValueProvider_Summand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getFactor()
	 * @see #getLinearValueProvider()
	 * @generated
	 */
	EAttribute getLinearValueProvider_Factor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification <em>Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modification</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification
	 * @generated
	 */
	EClass getModification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification#getType()
	 * @see #getModification()
	 * @generated
	 */
	EReference getModification_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification#getName()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getVariedObjectId <em>Varied Object Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varied Object Id</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification#getVariedObjectId()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_VariedObjectId();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification#getValue()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExperimentsFactory getExperimentsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl <em>Experiment Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperimentRepository()
		 * @generated
		 */
		EClass EXPERIMENT_REPOSITORY = eINSTANCE.getExperimentRepository();

		/**
		 * The meta object literal for the '<em><b>Experiments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_REPOSITORY__EXPERIMENTS = eINSTANCE.getExperimentRepository_Experiments();

		/**
		 * The meta object literal for the '<em><b>Tool Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION = eINSTANCE.getExperimentRepository_ToolConfiguration();

		/**
		 * The meta object literal for the '<em><b>Repetitions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_REPOSITORY__REPETITIONS = eINSTANCE.getExperimentRepository_Repetitions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl <em>Experiment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperiment()
		 * @generated
		 */
		EClass EXPERIMENT = eINSTANCE.getExperiment();

		/**
		 * The meta object literal for the '<em><b>Variations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__VARIATIONS = eINSTANCE.getExperiment_Variations();

		/**
		 * The meta object literal for the '<em><b>Modifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__MODIFICATIONS = eINSTANCE.getExperiment_Modifications();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT__ID = eINSTANCE.getExperiment_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT__NAME = eINSTANCE.getExperiment_Name();

		/**
		 * The meta object literal for the '<em><b>Initial Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__INITIAL_MODEL = eINSTANCE.getExperiment_InitialModel();

		/**
		 * The meta object literal for the '<em><b>Tool Configuration</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__TOOL_CONFIGURATION = eINSTANCE.getExperiment_ToolConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stop Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__STOP_CONDITIONS = eINSTANCE.getExperiment_StopConditions();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT__DESCRIPTION = eINSTANCE.getExperiment_Description();

		/**
		 * The meta object literal for the '<em><b>Experiment Design</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__EXPERIMENT_DESIGN = eINSTANCE.getExperiment_ExperimentDesign();

		/**
		 * The meta object literal for the '<em><b>Response Measurement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT__RESPONSE_MEASUREMENT = eINSTANCE.getExperiment_ResponseMeasurement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl <em>Variation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.VariationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getVariation()
		 * @generated
		 */
		EClass VARIATION = eINSTANCE.getVariation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION__TYPE = eINSTANCE.getVariation_Type();

		/**
		 * The meta object literal for the '<em><b>Value Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION__VALUE_PROVIDER = eINSTANCE.getVariation_ValueProvider();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION__MIN_VALUE = eINSTANCE.getVariation_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION__MAX_VALUE = eINSTANCE.getVariation_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Max Variations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION__MAX_VARIATIONS = eINSTANCE.getVariation_MaxVariations();

		/**
		 * The meta object literal for the '<em><b>Varied Object Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION__VARIED_OBJECT_ID = eINSTANCE.getVariation_VariedObjectId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION__NAME = eINSTANCE.getVariation_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ValueProviderImpl <em>Value Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ValueProviderImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getValueProvider()
		 * @generated
		 */
		EClass VALUE_PROVIDER = eINSTANCE.getValueProvider();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl <em>PCM Model Files</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPCMModelFiles()
		 * @generated
		 */
		EClass PCM_MODEL_FILES = eINSTANCE.getPCMModelFiles();

		/**
		 * The meta object literal for the '<em><b>Allocation File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__ALLOCATION_FILE = eINSTANCE.getPCMModelFiles_AllocationFile();

		/**
		 * The meta object literal for the '<em><b>Usagemodel File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__USAGEMODEL_FILE = eINSTANCE.getPCMModelFiles_UsagemodelFile();

		/**
		 * The meta object literal for the '<em><b>System File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__SYSTEM_FILE = eINSTANCE.getPCMModelFiles_SystemFile();

		/**
		 * The meta object literal for the '<em><b>Repository File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__REPOSITORY_FILE = eINSTANCE.getPCMModelFiles_RepositoryFile();

		/**
		 * The meta object literal for the '<em><b>Resourceenvironment File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE = eINSTANCE.getPCMModelFiles_ResourceenvironmentFile();

		/**
		 * The meta object literal for the '<em><b>Middleware Repository File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE = eINSTANCE.getPCMModelFiles_MiddlewareRepositoryFile();

		/**
		 * The meta object literal for the '<em><b>Event Middleware Repository File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE = eINSTANCE.getPCMModelFiles_EventMiddlewareRepositoryFile();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl <em>Tool Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getToolConfiguration()
		 * @generated
		 */
		EClass TOOL_CONFIGURATION = eINSTANCE.getToolConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_CONFIGURATION__NAME = eINSTANCE.getToolConfiguration_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentDesignImpl <em>Experiment Design</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentDesignImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExperimentDesign()
		 * @generated
		 */
		EClass EXPERIMENT_DESIGN = eINSTANCE.getExperimentDesign();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ResponseMeasurementImpl <em>Response Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ResponseMeasurementImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getResponseMeasurement()
		 * @generated
		 */
		EClass RESPONSE_MEASUREMENT = eINSTANCE.getResponseMeasurement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PolynomialValueProviderImpl <em>Polynomial Value Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PolynomialValueProviderImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPolynomialValueProvider()
		 * @generated
		 */
		EClass POLYNOMIAL_VALUE_PROVIDER = eINSTANCE.getPolynomialValueProvider();

		/**
		 * The meta object literal for the '<em><b>Exponent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYNOMIAL_VALUE_PROVIDER__EXPONENT = eINSTANCE.getPolynomialValueProvider_Exponent();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYNOMIAL_VALUE_PROVIDER__FACTOR = eINSTANCE.getPolynomialValueProvider_Factor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExponentialValueProviderImpl <em>Exponential Value Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExponentialValueProviderImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getExponentialValueProvider()
		 * @generated
		 */
		EClass EXPONENTIAL_VALUE_PROVIDER = eINSTANCE.getExponentialValueProvider();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPONENTIAL_VALUE_PROVIDER__BASE = eINSTANCE.getExponentialValueProvider_Base();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.SetValueProviderImpl <em>Set Value Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.SetValueProviderImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getSetValueProvider()
		 * @generated
		 */
		EClass SET_VALUE_PROVIDER = eINSTANCE.getSetValueProvider();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VALUE_PROVIDER__VALUES = eINSTANCE.getSetValueProvider_Values();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PlacketBurmanDesignImpl <em>Placket Burman Design</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.PlacketBurmanDesignImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getPlacketBurmanDesign()
		 * @generated
		 */
		EClass PLACKET_BURMAN_DESIGN = eINSTANCE.getPlacketBurmanDesign();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.FullFactorialDesignImpl <em>Full Factorial Design</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.FullFactorialDesignImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getFullFactorialDesign()
		 * @generated
		 */
		EClass FULL_FACTORIAL_DESIGN = eINSTANCE.getFullFactorialDesign();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.FractionalFactorialDesignImpl <em>Fractional Factorial Design</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.FractionalFactorialDesignImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getFractionalFactorialDesign()
		 * @generated
		 */
		EClass FRACTIONAL_FACTORIAL_DESIGN = eINSTANCE.getFractionalFactorialDesign();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.OneFactorAtATimeImpl <em>One Factor At ATime</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.OneFactorAtATimeImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getOneFactorAtATime()
		 * @generated
		 */
		EClass ONE_FACTOR_AT_ATIME = eINSTANCE.getOneFactorAtATime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.SimulationDurationMeasurementImpl <em>Simulation Duration Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.SimulationDurationMeasurementImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getSimulationDurationMeasurement()
		 * @generated
		 */
		EClass SIMULATION_DURATION_MEASUREMENT = eINSTANCE.getSimulationDurationMeasurement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ProfilingMeasurementImpl <em>Profiling Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ProfilingMeasurementImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getProfilingMeasurement()
		 * @generated
		 */
		EClass PROFILING_MEASUREMENT = eINSTANCE.getProfilingMeasurement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.JMXMeasurementImpl <em>JMX Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.JMXMeasurementImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getJMXMeasurement()
		 * @generated
		 */
		EClass JMX_MEASUREMENT = eINSTANCE.getJMXMeasurement();

		/**
		 * The meta object literal for the '<em><b>Polling Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMX_MEASUREMENT__POLLING_PERIOD = eINSTANCE.getJMXMeasurement_PollingPeriod();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.LinearValueProviderImpl <em>Linear Value Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.LinearValueProviderImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getLinearValueProvider()
		 * @generated
		 */
		EClass LINEAR_VALUE_PROVIDER = eINSTANCE.getLinearValueProvider();

		/**
		 * The meta object literal for the '<em><b>Summand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_VALUE_PROVIDER__SUMMAND = eINSTANCE.getLinearValueProvider_Summand();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_VALUE_PROVIDER__FACTOR = eINSTANCE.getLinearValueProvider_Factor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ModificationImpl <em>Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ModificationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl#getModification()
		 * @generated
		 */
		EClass MODIFICATION = eINSTANCE.getModification();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATION__TYPE = eINSTANCE.getModification_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__NAME = eINSTANCE.getModification_Name();

		/**
		 * The meta object literal for the '<em><b>Varied Object Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__VARIED_OBJECT_ID = eINSTANCE.getModification_VariedObjectId();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__VALUE = eINSTANCE.getModification_Value();

	}

} //ExperimentsPackage
