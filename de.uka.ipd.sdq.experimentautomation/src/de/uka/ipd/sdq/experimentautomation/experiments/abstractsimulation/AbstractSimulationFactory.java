/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage
 * @generated
 */
public interface AbstractSimulationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractSimulationFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Random Number Generator Seed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Number Generator Seed</em>'.
	 * @generated
	 */
	RandomNumberGeneratorSeed createRandomNumberGeneratorSeed();

	/**
	 * Returns a new object of class '<em>Probe Spec Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probe Spec Configuration</em>'.
	 * @generated
	 */
	ProbeSpecConfiguration createProbeSpecConfiguration();

	/**
	 * Returns a new object of class '<em>Sensor Framework</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sensor Framework</em>'.
	 * @generated
	 */
	SensorFramework createSensorFramework();

	/**
	 * Returns a new object of class '<em>Memory Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Datasource</em>'.
	 * @generated
	 */
	MemoryDatasource createMemoryDatasource();

	/**
	 * Returns a new object of class '<em>File Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Datasource</em>'.
	 * @generated
	 */
	FileDatasource createFileDatasource();

	/**
	 * Returns a new object of class '<em>Measurement Count Stop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement Count Stop Condition</em>'.
	 * @generated
	 */
	MeasurementCountStopCondition createMeasurementCountStopCondition();

	/**
	 * Returns a new object of class '<em>Sim Time Stop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sim Time Stop Condition</em>'.
	 * @generated
	 */
	SimTimeStopCondition createSimTimeStopCondition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AbstractSimulationPackage getAbstractSimulationPackage();

} //AbstractSimulationFactory
