/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.util;

import de.uka.ipd.sdq.experimentautomation.experiments.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage
 * @generated
 */
public class ExperimentsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExperimentsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExperimentsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentsSwitch<Adapter> modelSwitch =
		new ExperimentsSwitch<Adapter>() {
			@Override
			public Adapter caseExperimentRepository(ExperimentRepository object) {
				return createExperimentRepositoryAdapter();
			}
			@Override
			public Adapter caseExperiment(Experiment object) {
				return createExperimentAdapter();
			}
			@Override
			public Adapter caseVariation(Variation object) {
				return createVariationAdapter();
			}
			@Override
			public Adapter caseValueProvider(ValueProvider object) {
				return createValueProviderAdapter();
			}
			@Override
			public Adapter casePCMModelFiles(PCMModelFiles object) {
				return createPCMModelFilesAdapter();
			}
			@Override
			public Adapter caseToolConfiguration(ToolConfiguration object) {
				return createToolConfigurationAdapter();
			}
			@Override
			public Adapter caseExperimentDesign(ExperimentDesign object) {
				return createExperimentDesignAdapter();
			}
			@Override
			public Adapter caseResponseMeasurement(ResponseMeasurement object) {
				return createResponseMeasurementAdapter();
			}
			@Override
			public Adapter casePolynomialValueProvider(PolynomialValueProvider object) {
				return createPolynomialValueProviderAdapter();
			}
			@Override
			public Adapter caseExponentialValueProvider(ExponentialValueProvider object) {
				return createExponentialValueProviderAdapter();
			}
			@Override
			public Adapter caseSetValueProvider(SetValueProvider object) {
				return createSetValueProviderAdapter();
			}
			@Override
			public Adapter casePlacketBurmanDesign(PlacketBurmanDesign object) {
				return createPlacketBurmanDesignAdapter();
			}
			@Override
			public Adapter caseFullFactorialDesign(FullFactorialDesign object) {
				return createFullFactorialDesignAdapter();
			}
			@Override
			public Adapter caseFractionalFactorialDesign(FractionalFactorialDesign object) {
				return createFractionalFactorialDesignAdapter();
			}
			@Override
			public Adapter caseOneFactorAtATime(OneFactorAtATime object) {
				return createOneFactorAtATimeAdapter();
			}
			@Override
			public Adapter caseSimulationDurationMeasurement(SimulationDurationMeasurement object) {
				return createSimulationDurationMeasurementAdapter();
			}
			@Override
			public Adapter caseProfilingMeasurement(ProfilingMeasurement object) {
				return createProfilingMeasurementAdapter();
			}
			@Override
			public Adapter caseJMXMeasurement(JMXMeasurement object) {
				return createJMXMeasurementAdapter();
			}
			@Override
			public Adapter caseLinearValueProvider(LinearValueProvider object) {
				return createLinearValueProviderAdapter();
			}
			@Override
			public Adapter caseModification(Modification object) {
				return createModificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository <em>Experiment Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository
	 * @generated
	 */
	public Adapter createExperimentRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment <em>Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Experiment
	 * @generated
	 */
	public Adapter createExperimentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation <em>Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Variation
	 * @generated
	 */
	public Adapter createVariationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider <em>Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ValueProvider
	 * @generated
	 */
	public Adapter createValueProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles <em>PCM Model Files</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles
	 * @generated
	 */
	public Adapter createPCMModelFilesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration <em>Tool Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration
	 * @generated
	 */
	public Adapter createToolConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign <em>Experiment Design</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign
	 * @generated
	 */
	public Adapter createExperimentDesignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement <em>Response Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement
	 * @generated
	 */
	public Adapter createResponseMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider <em>Polynomial Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider
	 * @generated
	 */
	public Adapter createPolynomialValueProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider <em>Exponential Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider
	 * @generated
	 */
	public Adapter createExponentialValueProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider <em>Set Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider
	 * @generated
	 */
	public Adapter createSetValueProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign <em>Placket Burman Design</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.PlacketBurmanDesign
	 * @generated
	 */
	public Adapter createPlacketBurmanDesignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.FullFactorialDesign <em>Full Factorial Design</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.FullFactorialDesign
	 * @generated
	 */
	public Adapter createFullFactorialDesignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.FractionalFactorialDesign <em>Fractional Factorial Design</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.FractionalFactorialDesign
	 * @generated
	 */
	public Adapter createFractionalFactorialDesignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime <em>One Factor At ATime</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.OneFactorAtATime
	 * @generated
	 */
	public Adapter createOneFactorAtATimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement <em>Simulation Duration Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement
	 * @generated
	 */
	public Adapter createSimulationDurationMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement <em>Profiling Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement
	 * @generated
	 */
	public Adapter createProfilingMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement <em>JMX Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement
	 * @generated
	 */
	public Adapter createJMXMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider <em>Linear Value Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider
	 * @generated
	 */
	public Adapter createLinearValueProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification <em>Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.Modification
	 * @generated
	 */
	public Adapter createModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExperimentsAdapterFactory
