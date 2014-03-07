/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage
 * @generated
 */
public interface ExperimentDataFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ExperimentDataFactory eINSTANCE = de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Measurements Range</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Measurements Range</em>'.
     * @generated
     */
	MeasurementsRange createMeasurementsRange();

	/**
     * Returns a new object of class '<em>Raw Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Raw Measurements</em>'.
     * @generated
     */
	RawMeasurements createRawMeasurements();

	/**
     * Returns a new object of class '<em>Numerical Nominal Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Nominal Statistics</em>'.
     * @generated
     */
	NumericalNominalStatistics createNumericalNominalStatistics();

	/**
     * Returns a new object of class '<em>Numerical Mass Distribution</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Mass Distribution</em>'.
     * @generated
     */
	NumericalMassDistribution createNumericalMassDistribution();

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
     * Returns a new object of class '<em>Textual Nominal Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Textual Nominal Statistics</em>'.
     * @generated
     */
	TextualNominalStatistics createTextualNominalStatistics();

	/**
     * Returns a new object of class '<em>Textual Mass Distribution</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Textual Mass Distribution</em>'.
     * @generated
     */
	TextualMassDistribution createTextualMassDistribution();

	/**
     * Returns a new object of class '<em>Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Measurements</em>'.
     * @generated
     */
	Measurements createMeasurements();

	/**
     * Returns a new object of class '<em>Edp2 Measure</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Edp2 Measure</em>'.
     * @generated
     */
	Edp2Measure createEdp2Measure();

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
     * Returns a new object of class '<em>Identifier</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Identifier</em>'.
     * @generated
     */
	Identifier createIdentifier();
	
	/**
     * Returns a new object of class '<em>Textual Base Metric Description</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Textual Base Metric Description</em>'.
     * @generated
     */
	TextualBaseMetricDescription createTextualBaseMetricDescription();

	/**Factory method to create a new identifier.
	 * @param literal The literal of the identifier.
	 * @return New identifier.
	 * @generated NOT
	 */
	Identifier createIdentifier(String literal);

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
     * Returns a new object of class '<em>Double Binary Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Double Binary Measurements</em>'.
     * @generated
     */
	<Q extends Quantity> DoubleBinaryMeasurements<Q> createDoubleBinaryMeasurements();

	/**
     * Returns a new object of class '<em>Numerical Interval Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Interval Statistics</em>'.
     * @generated
     */
	NumericalIntervalStatistics createNumericalIntervalStatistics();

	/**
     * Returns a new object of class '<em>Numerical Ordinal Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Ordinal Statistics</em>'.
     * @generated
     */
	NumericalOrdinalStatistics createNumericalOrdinalStatistics();

	/**
     * Returns a new object of class '<em>Numerical Percentile</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Percentile</em>'.
     * @generated
     */
	NumericalPercentile createNumericalPercentile();

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
     * Returns a new object of class '<em>Identifier Based Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Identifier Based Measurements</em>'.
     * @generated
     */
	IdentifierBasedMeasurements createIdentifierBasedMeasurements();

	/**
     * Returns a new object of class '<em>Observed Identifier</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Observed Identifier</em>'.
     * @generated
     */
	ObservedIdentifier createObservedIdentifier();

	/**
     * Returns a new object of class '<em>Observed Identifier Based Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Observed Identifier Based Measurements</em>'.
     * @generated
     */
	ObservedIdentifierBasedMeasurements createObservedIdentifierBasedMeasurements();

	/**
     * Returns a new object of class '<em>Numerical Ratio Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Ratio Statistics</em>'.
     * @generated
     */
	NumericalRatioStatistics createNumericalRatioStatistics();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ExperimentDataPackage getExperimentDataPackage();

	/**
     * Returns a new object of class '<em>Sensor Framework V1 Double Binary Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sensor Framework V1 Double Binary Measurements</em>'.
     * @generated
     */
	SensorFrameworkV1DoubleBinaryMeasurements createSensorFrameworkV1DoubleBinaryMeasurements();

	/**
     * Returns a new object of class '<em>Sensor Framework V1 Identifier Based Measurements</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sensor Framework V1 Identifier Based Measurements</em>'.
     * @generated
     */
	SensorFrameworkV1IdentifierBasedMeasurements createSensorFrameworkV1IdentifierBasedMeasurements();

	/**
     * Returns a new object of class '<em>Numerical Base Metric Description</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Numerical Base Metric Description</em>'.
     * @generated
     */
	NumericalBaseMetricDescription createNumericalBaseMetricDescription();

	/**
     * Returns a new object of class '<em>Textual Ordinal Statistics</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Textual Ordinal Statistics</em>'.
     * @generated
     */
	TextualOrdinalStatistics createTextualOrdinalStatistics();

	/**Factory method to create a new numerical base metric description with the given arguments.
	 * @param uuid Universal unique identifier of the description.
	 * @param name Name of the description.
	 * @param textualDescription Textual description of the description.
	 * @param captureType Capture type of the description.
	 * @param scale Scale of the description.
	 * @param dataType Data type of the description.
	 * @param defaultUnit Default unit of the description.
	 * @param monotonic Monotonic property of the description.
	 * @param persistenceKind Preferred persistence kind for the metric.
	 * @return New numerical base metric description.
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public NumericalBaseMetricDescription createNumericalBaseMetricDescription(
			final String name, final String textualDescription,
			final CaptureType captureType, final Scale scale,
			final DataType dataType, final Unit defaultUnit,
			final Monotonic monotonic,
			final PersistenceKindOptions persistenceKind);

	/**Factory method to create a new textual base metric description with the given arguments.
	 * @param uuid Universal unique identifier of the description.
	 * @param name Name of the description.
	 * @param textualDescription Textual description of the description.
	 * @param captureType Capture type of the description.
	 * @param scale Scale of the description.
	 * @param dataType Data type of the description.
	 * @param defaultUnit Default unit of the description.
	 * @param monotonic Monotonic property of the description.
	 * @return New textual base metric description.
	 * @generated NOT
	 */
	public TextualBaseMetricDescription createTextualBaseMetricDescription(
			final String name, final String textualDescription,
			final Scale scale, final DataType dataType,
			final Monotonic monotonic);
	
	/**Factory method to create a new metric set description with the given arguments.
	 * @param uuid Universal unique identifier of the description.
	 * @param name Name of the description.
	 * @param textualDescription Textual description of the description.
	 * @return New metric set description.
	 * @generated NOT
	 */
	public MetricSetDescription createMetricSetDescription(String name,
			String textualDescription);
	
	/**Factory method to create a new number-based measure with the given arguments.
	 * @param persistenceOptions Persistence kind options of the measure.
	 * @param measuredObject Name of the measured object.
	 * @param metricDescription Metric description used by this measure.
	 * @return New number-based measure.
	 * @generated NOT
	 */
	public Edp2Measure createEdp2Measure(String measuredObject,
			MetricDescription metricDescription);
	
	/**Factory method to create a new experiment setting with the given arguments.
	 * @param experimentGroup The experiment group which the new setting is assigned to.
	 * @param description Description of the setting.
	 * @return New experiment setting.
	 * @generated NOT
	 */
	public ExperimentSetting createExperimentSetting(
			ExperimentGroup experimentGroup, String description);
	
	/**Factory method to create a new experiment group with the given arguments.
	 * @param purpose The purpose of the group.
	 * @return New experiment group.
	 * @generated NOT
	 */
	public ExperimentGroup createExperimentGroup(String purpose);
	
	/**Factory method to create a new measurement with the given arguments.
	 * @param forMeasure The measure for which the measurement should be created.
	 * @return New measurement.
	 * @generated NOT
	 */
	public Measurements createMeasurements(Edp2Measure forMeasure);
	
	/**Factory method to create a new experiment run with the given arguments.
	 * @param forExperimentSetting The setting for which the run should be created.
	 * @return New experiment run.
	 * @generated NOT
	 */
	public ExperimentRun createExperimentRun(
			ExperimentSetting forExperimentSetting);
	
	/**Factory method to create a new raw measurements with the given arguments.
	 * The corresponding data series are automatically created from the measure definitions.
	 * @param forMeasurementRange The measurement range for which the run should be created.
	 * @return New raw measurements.
	 * @generated NOT
	 */
	public RawMeasurements createRawMeasurements(
			MeasurementsRange forMeasurementsRange);
	
	/**Factory method to create a new measurements range with the given arguments.
	 * @param forMeasurements The measurements for which the range should be created.
	 * @return New measurements range.
	 * @generated NOT
	 */
	public MeasurementsRange createMeasurementsRange(Measurements forMeasurements);
	
	/**Factory method to create a new identifier-based measurements with the given arguments.
	 * @param forRawMeasurement The raw measurement for which the measurements should be created.
	 * @param valesUuid The UUID for the values.
	 * @return New identifier-based measurements.
	 * @generated NOT
	 */
	public IdentifierBasedMeasurements createIdentifierBasedMeasurements(
			RawMeasurements forRawMeasurements, String valesUuid);

	/**Factory method to create a new long binary measurements with the given arguments.
	 * @param forRawMeasurement The raw measurement for which the measurements should be created.
	 * @param valuesUuid The UUID for the values.
	 * @param defaultUnit The default unit of the values.
	 * @return New long binary measurements.
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public LongBinaryMeasurements createLongBinaryMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid,
			Unit defaultUnit);

	/**Factory method to create a new double binary measurements with the given arguments.
	 * @param forRawMeasurement The raw measurement for which the measurements should be created.
	 * @param valuesUuid The UUID for the values.
	 * @param defaultUnit The default unit of the values.
	 * @return New double binary measurements.
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public DoubleBinaryMeasurements createDoubleBinaryMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid,
			Unit defaultUnit);
	
	/**Factory method to create a new JScience XML measurements with the given arguments.
	 * @param forRawMeasurements The raw measurement for which the measurements should be created.
	 * @param valuesUuid The UUID for the values.
	 * @return New JScience XML measurements.
	 * @generated NOT
	 */
	public JSXmlMeasurements createJSXmlMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid);
	
	/**Factory method to create a new observed identifier.
	 * @param forOIBM The observed identifier-based measurements for which the identifier should be created.
	 * @param identifier The identifier.
	 * @return New observed identifier.
	 * @generated NOT
	 */
	public ObservedIdentifier createObservedIdentifier(
			ObservedIdentifierBasedMeasurements forOIBM, Identifier identifier);
	

} //EmfmodelFactory
