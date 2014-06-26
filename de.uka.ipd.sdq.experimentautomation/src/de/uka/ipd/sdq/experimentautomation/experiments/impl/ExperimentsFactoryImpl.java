/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.*;

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
public class ExperimentsFactoryImpl extends EFactoryImpl implements ExperimentsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExperimentsFactory init() {
		try {
			ExperimentsFactory theExperimentsFactory = (ExperimentsFactory)EPackage.Registry.INSTANCE.getEFactory(ExperimentsPackage.eNS_URI);
			if (theExperimentsFactory != null) {
				return theExperimentsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExperimentsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentsFactoryImpl() {
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
			case ExperimentsPackage.EXPERIMENT_REPOSITORY: return createExperimentRepository();
			case ExperimentsPackage.EXPERIMENT: return createExperiment();
			case ExperimentsPackage.VARIATION: return createVariation();
			case ExperimentsPackage.PCM_MODEL_FILES: return createPCMModelFiles();
			case ExperimentsPackage.POLYNOMIAL_VALUE_PROVIDER: return createPolynomialValueProvider();
			case ExperimentsPackage.EXPONENTIAL_VALUE_PROVIDER: return createExponentialValueProvider();
			case ExperimentsPackage.SET_VALUE_PROVIDER: return createSetValueProvider();
			case ExperimentsPackage.PLACKET_BURMAN_DESIGN: return createPlacketBurmanDesign();
			case ExperimentsPackage.FULL_FACTORIAL_DESIGN: return createFullFactorialDesign();
			case ExperimentsPackage.FRACTIONAL_FACTORIAL_DESIGN: return createFractionalFactorialDesign();
			case ExperimentsPackage.ONE_FACTOR_AT_ATIME: return createOneFactorAtATime();
			case ExperimentsPackage.SIMULATION_DURATION_MEASUREMENT: return createSimulationDurationMeasurement();
			case ExperimentsPackage.PROFILING_MEASUREMENT: return createProfilingMeasurement();
			case ExperimentsPackage.JMX_MEASUREMENT: return createJMXMeasurement();
			case ExperimentsPackage.LINEAR_VALUE_PROVIDER: return createLinearValueProvider();
			case ExperimentsPackage.MODIFICATION: return createModification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRepository createExperimentRepository() {
		ExperimentRepositoryImpl experimentRepository = new ExperimentRepositoryImpl();
		return experimentRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Experiment createExperiment() {
		ExperimentImpl experiment = new ExperimentImpl();
		return experiment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variation createVariation() {
		VariationImpl variation = new VariationImpl();
		return variation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMModelFiles createPCMModelFiles() {
		PCMModelFilesImpl pcmModelFiles = new PCMModelFilesImpl();
		return pcmModelFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialValueProvider createPolynomialValueProvider() {
		PolynomialValueProviderImpl polynomialValueProvider = new PolynomialValueProviderImpl();
		return polynomialValueProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExponentialValueProvider createExponentialValueProvider() {
		ExponentialValueProviderImpl exponentialValueProvider = new ExponentialValueProviderImpl();
		return exponentialValueProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValueProvider createSetValueProvider() {
		SetValueProviderImpl setValueProvider = new SetValueProviderImpl();
		return setValueProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacketBurmanDesign createPlacketBurmanDesign() {
		PlacketBurmanDesignImpl placketBurmanDesign = new PlacketBurmanDesignImpl();
		return placketBurmanDesign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullFactorialDesign createFullFactorialDesign() {
		FullFactorialDesignImpl fullFactorialDesign = new FullFactorialDesignImpl();
		return fullFactorialDesign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FractionalFactorialDesign createFractionalFactorialDesign() {
		FractionalFactorialDesignImpl fractionalFactorialDesign = new FractionalFactorialDesignImpl();
		return fractionalFactorialDesign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OneFactorAtATime createOneFactorAtATime() {
		OneFactorAtATimeImpl oneFactorAtATime = new OneFactorAtATimeImpl();
		return oneFactorAtATime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDurationMeasurement createSimulationDurationMeasurement() {
		SimulationDurationMeasurementImpl simulationDurationMeasurement = new SimulationDurationMeasurementImpl();
		return simulationDurationMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingMeasurement createProfilingMeasurement() {
		ProfilingMeasurementImpl profilingMeasurement = new ProfilingMeasurementImpl();
		return profilingMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMXMeasurement createJMXMeasurement() {
		JMXMeasurementImpl jmxMeasurement = new JMXMeasurementImpl();
		return jmxMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearValueProvider createLinearValueProvider() {
		LinearValueProviderImpl linearValueProvider = new LinearValueProviderImpl();
		return linearValueProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Modification createModification() {
		ModificationImpl modification = new ModificationImpl();
		return modification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentsPackage getExperimentsPackage() {
		return (ExperimentsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExperimentsPackage getPackage() {
		return ExperimentsPackage.eINSTANCE;
	}

} //ExperimentsFactoryImpl
