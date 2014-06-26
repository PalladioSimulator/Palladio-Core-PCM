/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage
 * @generated
 */
public interface ExperimentsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentsFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Experiment Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment Repository</em>'.
	 * @generated
	 */
	ExperimentRepository createExperimentRepository();

	/**
	 * Returns a new object of class '<em>Experiment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment</em>'.
	 * @generated
	 */
	Experiment createExperiment();

	/**
	 * Returns a new object of class '<em>Variation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation</em>'.
	 * @generated
	 */
	Variation createVariation();

	/**
	 * Returns a new object of class '<em>PCM Model Files</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Model Files</em>'.
	 * @generated
	 */
	PCMModelFiles createPCMModelFiles();

	/**
	 * Returns a new object of class '<em>Polynomial Value Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polynomial Value Provider</em>'.
	 * @generated
	 */
	PolynomialValueProvider createPolynomialValueProvider();

	/**
	 * Returns a new object of class '<em>Exponential Value Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exponential Value Provider</em>'.
	 * @generated
	 */
	ExponentialValueProvider createExponentialValueProvider();

	/**
	 * Returns a new object of class '<em>Set Value Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Value Provider</em>'.
	 * @generated
	 */
	SetValueProvider createSetValueProvider();

	/**
	 * Returns a new object of class '<em>Placket Burman Design</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placket Burman Design</em>'.
	 * @generated
	 */
	PlacketBurmanDesign createPlacketBurmanDesign();

	/**
	 * Returns a new object of class '<em>Full Factorial Design</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Full Factorial Design</em>'.
	 * @generated
	 */
	FullFactorialDesign createFullFactorialDesign();

	/**
	 * Returns a new object of class '<em>Fractional Factorial Design</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fractional Factorial Design</em>'.
	 * @generated
	 */
	FractionalFactorialDesign createFractionalFactorialDesign();

	/**
	 * Returns a new object of class '<em>One Factor At ATime</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>One Factor At ATime</em>'.
	 * @generated
	 */
	OneFactorAtATime createOneFactorAtATime();

	/**
	 * Returns a new object of class '<em>Simulation Duration Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Duration Measurement</em>'.
	 * @generated
	 */
	SimulationDurationMeasurement createSimulationDurationMeasurement();

	/**
	 * Returns a new object of class '<em>Profiling Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profiling Measurement</em>'.
	 * @generated
	 */
	ProfilingMeasurement createProfilingMeasurement();

	/**
	 * Returns a new object of class '<em>JMX Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMX Measurement</em>'.
	 * @generated
	 */
	JMXMeasurement createJMXMeasurement();

	/**
	 * Returns a new object of class '<em>Linear Value Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Value Provider</em>'.
	 * @generated
	 */
	LinearValueProvider createLinearValueProvider();

	/**
	 * Returns a new object of class '<em>Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modification</em>'.
	 * @generated
	 */
	Modification createModification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExperimentsPackage getExperimentsPackage();

} //ExperimentsFactory
