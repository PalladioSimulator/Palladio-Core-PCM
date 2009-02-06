/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage
 * @generated
 */
public interface emfmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	emfmodelFactory eINSTANCE = de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.emfmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Measurement Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement Range</em>'.
	 * @generated
	 */
	MeasurementRange createMeasurementRange();

	/**
	 * Returns a new object of class '<em>Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statistics</em>'.
	 * @generated
	 */
	Statistics createStatistics();

	/**
	 * Returns a new object of class '<em>Intervals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intervals</em>'.
	 * @generated
	 */
	Intervals createIntervals();

	/**
	 * Returns a new object of class '<em>Collected Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collected Data</em>'.
	 * @generated
	 */
	CollectedData createCollectedData();

	/**
	 * Returns a new object of class '<em>Experiment Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment Setting</em>'.
	 * @generated
	 */
	ExperimentSetting createExperimentSetting();

	/**
	 * Returns a new object of class '<em>Experiment Run</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment Run</em>'.
	 * @generated
	 */
	ExperimentRun createExperimentRun();

	/**
	 * Returns a new object of class '<em>Measure Characterization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measure Characterization</em>'.
	 * @generated
	 */
	MeasureCharacterization createMeasureCharacterization();

	/**
	 * Returns a new object of class '<em>Aggregation Characterization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregation Characterization</em>'.
	 * @generated
	 */
	AggregationCharacterization createAggregationCharacterization();

	/**
	 * Returns a new object of class '<em>Long Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Binary Measurements</em>'.
	 * @generated
	 */
	LongBinaryMeasurements createLongBinaryMeasurements();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>State Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Measurements</em>'.
	 * @generated
	 */
	StateMeasurements createStateMeasurements();

	/**
	 * Returns a new object of class '<em>State Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Sensor</em>'.
	 * @generated
	 */
	StateSensor createStateSensor();

	/**
	 * Returns a new object of class '<em>Double Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Binary Measurements</em>'.
	 * @generated
	 */
	DoubleBinaryMeasurements createDoubleBinaryMeasurements();

	/**
	 * Returns a new object of class '<em>Experiment Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment Group</em>'.
	 * @generated
	 */
	ExperimentGroup createExperimentGroup();

	/**
	 * Returns a new object of class '<em>Measurable Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurable Sensor</em>'.
	 * @generated
	 */
	MeasurableSensor createMeasurableSensor();

	/**
	 * Returns a new object of class '<em>JS Xml Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JS Xml Measurements</em>'.
	 * @generated
	 */
	JSXmlMeasurements createJSXmlMeasurements();

	/**
	 * Returns a new object of class '<em>Event Time Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Time Aggregation</em>'.
	 * @generated
	 */
	EventTimeAggregation createEventTimeAggregation();

	/**
	 * Returns a new object of class '<em>Value Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Aggregation</em>'.
	 * @generated
	 */
	ValueAggregation createValueAggregation();

	/**
	 * Returns a new object of class '<em>Increasing Measurable Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increasing Measurable Sensor</em>'.
	 * @generated
	 */
	IncreasingMeasurableSensor createIncreasingMeasurableSensor();

	/**
	 * Returns a new object of class '<em>Advanced Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advanced Statistics</em>'.
	 * @generated
	 */
	AdvancedStatistics createAdvancedStatistics();

	/**
	 * Returns a new object of class '<em>Double Binary Event Times</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Binary Event Times</em>'.
	 * @generated
	 */
	DoubleBinaryEventTimes createDoubleBinaryEventTimes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	emfmodelPackage getemfmodelPackage();

} //emfmodelFactory
