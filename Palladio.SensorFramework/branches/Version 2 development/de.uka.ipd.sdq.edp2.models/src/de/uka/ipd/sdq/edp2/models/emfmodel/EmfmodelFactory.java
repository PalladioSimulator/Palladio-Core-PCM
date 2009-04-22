/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage
 * @generated
 */
public interface EmfmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfmodelFactory eINSTANCE = de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Measurement Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement Range</em>'.
	 * @generated
	 */
	MeasurementRange createMeasurementRange();

	/**
	 * Returns a new object of class '<em>Raw Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raw Measurements</em>'.
	 * @generated
	 */
	RawMeasurements createRawMeasurements();

	/**
	 * Returns a new object of class '<em>Nominal Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nominal Statistics</em>'.
	 * @generated
	 */
	NominalStatistics createNominalStatistics();

	/**
	 * Returns a new object of class '<em>Fixed Width Aggregated Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Width Aggregated Measurements</em>'.
	 * @generated
	 */
	FixedWidthAggregatedMeasurements createFixedWidthAggregatedMeasurements();

	/**
	 * Returns a new object of class '<em>Fixed Intervals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Intervals</em>'.
	 * @generated
	 */
	FixedIntervals createFixedIntervals();

	/**
	 * Returns a new object of class '<em>Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement</em>'.
	 * @generated
	 */
	Measurement createMeasurement();

	/**
	 * Returns a new object of class '<em>Experiment Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment Group</em>'.
	 * @generated
	 */
	ExperimentGroup createExperimentGroup();

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
	 * Returns a new object of class '<em>Base Metric Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Metric Description</em>'.
	 * @generated
	 */
	BaseMetricDescription createBaseMetricDescription();

	/**
	 * Returns a new object of class '<em>Aggregation Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregation Function Description</em>'.
	 * @generated
	 */
	AggregationFunctionDescription createAggregationFunctionDescription();

	/**
	 * Returns a new object of class '<em>Aggregation Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregation Statistics</em>'.
	 * @generated
	 */
	AggregationStatistics createAggregationStatistics();

	/**
	 * Returns a new object of class '<em>Long Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Binary Measurements</em>'.
	 * @generated
	 */
	LongBinaryMeasurements createLongBinaryMeasurements();

	/**
	 * Returns a new object of class '<em>Category Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Identifier</em>'.
	 * @generated
	 */
	CategoryIdentifier createCategoryIdentifier();

	/**
	 * Returns a new object of class '<em>Nominal Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nominal Measurements</em>'.
	 * @generated
	 */
	NominalMeasurements createNominalMeasurements();

	/**
	 * Returns a new object of class '<em>Nominal Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nominal Measure</em>'.
	 * @generated
	 */
	NominalMeasure createNominalMeasure();

	/**
	 * Returns a new object of class '<em>Double Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Binary Measurements</em>'.
	 * @generated
	 */
	DoubleBinaryMeasurements createDoubleBinaryMeasurements();

	/**
	 * Returns a new object of class '<em>Ordinal Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordinal Measure</em>'.
	 * @generated
	 */
	OrdinalMeasure createOrdinalMeasure();

	/**
	 * Returns a new object of class '<em>JS Xml Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JS Xml Measurements</em>'.
	 * @generated
	 */
	JSXmlMeasurements createJSXmlMeasurements();

	/**
	 * Returns a new object of class '<em>Descriptions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptions</em>'.
	 * @generated
	 */
	Descriptions createDescriptions();

	/**
	 * Returns a new object of class '<em>Metric Set Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Set Description</em>'.
	 * @generated
	 */
	MetricSetDescription createMetricSetDescription();

	/**
	 * Returns a new object of class '<em>Ordinal Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordinal Statistics</em>'.
	 * @generated
	 */
	OrdinalStatistics createOrdinalStatistics();

	/**
	 * Returns a new object of class '<em>Percentile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Percentile</em>'.
	 * @generated
	 */
	Percentile createPercentile();

	/**
	 * Returns a new object of class '<em>Interval Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interval Statistics</em>'.
	 * @generated
	 */
	IntervalStatistics createIntervalStatistics();

	/**
	 * Returns a new object of class '<em>Ratio Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ratio Statistics</em>'.
	 * @generated
	 */
	RatioStatistics createRatioStatistics();

	/**
	 * Returns a new object of class '<em>Observed Nominal Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observed Nominal Measurements</em>'.
	 * @generated
	 */
	ObservedNominalMeasurements createObservedNominalMeasurements();

	/**
	 * Returns a new object of class '<em>Observed Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observed Category</em>'.
	 * @generated
	 */
	ObservedCategory createObservedCategory();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmfmodelPackage getEmfmodelPackage();

} //EmfmodelFactory
