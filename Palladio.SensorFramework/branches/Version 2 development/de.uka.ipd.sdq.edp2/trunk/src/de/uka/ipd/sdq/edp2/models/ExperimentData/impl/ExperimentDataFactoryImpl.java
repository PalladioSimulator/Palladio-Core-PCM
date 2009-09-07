/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.intrnal.SerializationUtil;
import de.uka.ipd.sdq.edp2.models.ExperimentData.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
import java.nio.charset.Charset;
import java.util.Map;

import javax.measure.Measure;

import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ExperimentDataFactoryImpl extends EFactoryImpl implements ExperimentDataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExperimentDataFactory init() {
		try {
			ExperimentDataFactory theExperimentDataFactory = (ExperimentDataFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/EDP2/ExperimentData/0.9.1"); 
			if (theExperimentDataFactory != null) {
				return theExperimentDataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExperimentDataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDataFactoryImpl() {
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
			case ExperimentDataPackage.MEASUREMENT_RANGE: return createMeasurementRange();
			case ExperimentDataPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
			case ExperimentDataPackage.RAW_MEASUREMENTS: return createRawMeasurements();
			case ExperimentDataPackage.NOMINAL_STATISTICS: return createNominalStatistics();
			case ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS: return createFixedWidthAggregatedMeasurements();
			case ExperimentDataPackage.FIXED_INTERVALS: return createFixedIntervals();
			case ExperimentDataPackage.MEASUREMENT: return createMeasurement();
			case ExperimentDataPackage.EXPERIMENT_GROUP: return createExperimentGroup();
			case ExperimentDataPackage.EXPERIMENT_SETTING: return createExperimentSetting();
			case ExperimentDataPackage.EXPERIMENT_RUN: return createExperimentRun();
			case ExperimentDataPackage.AGGREGATION_FUNCTION_DESCRIPTION: return createAggregationFunctionDescription();
			case ExperimentDataPackage.AGGREGATION_STATISTICS: return createAggregationStatistics();
			case ExperimentDataPackage.BASE_METRIC_DESCRIPTION: return createBaseMetricDescription();
			case ExperimentDataPackage.CATEGORY_IDENTIFIER: return createCategoryIdentifier();
			case ExperimentDataPackage.DESCRIPTIONS: return createDescriptions();
			case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS: return createDoubleBinaryMeasurements();
			case ExperimentDataPackage.INTERVAL_STATISTICS: return createIntervalStatistics();
			case ExperimentDataPackage.ORDINAL_STATISTICS: return createOrdinalStatistics();
			case ExperimentDataPackage.PERCENTILE: return createPercentile();
			case ExperimentDataPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
			case ExperimentDataPackage.LONG_BINARY_MEASUREMENTS: return createLongBinaryMeasurements();
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION: return createMetricSetDescription();
			case ExperimentDataPackage.NOMINAL_MEASURE: return createNominalMeasure();
			case ExperimentDataPackage.NOMINAL_MEASUREMENTS: return createNominalMeasurements();
			case ExperimentDataPackage.OBSERVED_CATEGORY: return createObservedCategory();
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS: return createObservedNominalMeasurements();
			case ExperimentDataPackage.ORDINAL_MEASURE: return createOrdinalMeasure();
			case ExperimentDataPackage.RATIO_STATISTICS: return createRatioStatistics();
			case ExperimentDataPackage.SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS: return createSensorFrameworkV1DoubleBinaryMeasurements();
			case ExperimentDataPackage.SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS: return createSensorFrameworkV1NominalMeasurements();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExperimentDataPackage.PERSISTENCE_KIND_OPTIONS:
				return createPersistenceKindOptionsFromString(eDataType, initialValue);
			case ExperimentDataPackage.CAPTURE_TYPE:
				return createCaptureTypeFromString(eDataType, initialValue);
			case ExperimentDataPackage.SCALE:
				return createScaleFromString(eDataType, initialValue);
			case ExperimentDataPackage.MONOTONIC:
				return createMonotonicFromString(eDataType, initialValue);
			case ExperimentDataPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case ExperimentDataPackage.EJS_MEASURE:
				return createEJSMeasureFromString(eDataType, initialValue);
			case ExperimentDataPackage.EJS_DURATION_MEASURE:
				return createEJSDurationMeasureFromString(eDataType, initialValue);
			case ExperimentDataPackage.EJS_UNIT:
				return createEJSUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExperimentDataPackage.PERSISTENCE_KIND_OPTIONS:
				return convertPersistenceKindOptionsToString(eDataType, instanceValue);
			case ExperimentDataPackage.CAPTURE_TYPE:
				return convertCaptureTypeToString(eDataType, instanceValue);
			case ExperimentDataPackage.SCALE:
				return convertScaleToString(eDataType, instanceValue);
			case ExperimentDataPackage.MONOTONIC:
				return convertMonotonicToString(eDataType, instanceValue);
			case ExperimentDataPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case ExperimentDataPackage.EJS_MEASURE:
				return convertEJSMeasureToString(eDataType, instanceValue);
			case ExperimentDataPackage.EJS_DURATION_MEASURE:
				return convertEJSDurationMeasureToString(eDataType, instanceValue);
			case ExperimentDataPackage.EJS_UNIT:
				return convertEJSUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange createMeasurementRange() {
		MeasurementRangeImpl measurementRange = new MeasurementRangeImpl();
		return measurementRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalStatistics createNominalStatistics() {
		NominalStatisticsImpl nominalStatistics = new NominalStatisticsImpl();
		return nominalStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedWidthAggregatedMeasurements createFixedWidthAggregatedMeasurements() {
		FixedWidthAggregatedMeasurementsImpl fixedWidthAggregatedMeasurements = new FixedWidthAggregatedMeasurementsImpl();
		return fixedWidthAggregatedMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedIntervals createFixedIntervals() {
		FixedIntervalsImpl fixedIntervals = new FixedIntervalsImpl();
		return fixedIntervals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measurement createMeasurement() {
		MeasurementImpl measurement = new MeasurementImpl();
		return measurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createEStringtoEObjectMapEntry() {
		EStringtoEObjectMapEntryImpl eStringtoEObjectMapEntry = new EStringtoEObjectMapEntryImpl();
		return eStringtoEObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawMeasurements createRawMeasurements() {
		RawMeasurementsImpl rawMeasurements = new RawMeasurementsImpl();
		return rawMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentGroup createExperimentGroup() {
		ExperimentGroupImpl experimentGroup = new ExperimentGroupImpl();
		return experimentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentSetting createExperimentSetting() {
		ExperimentSettingImpl experimentSetting = new ExperimentSettingImpl();
		return experimentSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRun createExperimentRun() {
		ExperimentRunImpl experimentRun = new ExperimentRunImpl();
		return experimentRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricDescription createBaseMetricDescription() {
		BaseMetricDescriptionImpl baseMetricDescription = new BaseMetricDescriptionImpl();
		return baseMetricDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationFunctionDescription createAggregationFunctionDescription() {
		AggregationFunctionDescriptionImpl aggregationFunctionDescription = new AggregationFunctionDescriptionImpl();
		return aggregationFunctionDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationStatistics createAggregationStatistics() {
		AggregationStatisticsImpl aggregationStatistics = new AggregationStatisticsImpl();
		return aggregationStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongBinaryMeasurements createLongBinaryMeasurements() {
		LongBinaryMeasurementsImpl longBinaryMeasurements = new LongBinaryMeasurementsImpl();
		return longBinaryMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryIdentifier createCategoryIdentifier() {
		CategoryIdentifierImpl categoryIdentifier = new CategoryIdentifierImpl();
		return categoryIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalMeasurements createNominalMeasurements() {
		NominalMeasurementsImpl nominalMeasurements = new NominalMeasurementsImpl();
		return nominalMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalMeasure createNominalMeasure() {
		NominalMeasureImpl nominalMeasure = new NominalMeasureImpl();
		return nominalMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleBinaryMeasurements createDoubleBinaryMeasurements() {
		DoubleBinaryMeasurementsImpl doubleBinaryMeasurements = new DoubleBinaryMeasurementsImpl();
		return doubleBinaryMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalMeasure createOrdinalMeasure() {
		OrdinalMeasureImpl ordinalMeasure = new OrdinalMeasureImpl();
		return ordinalMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXmlMeasurements createJSXmlMeasurements() {
		JSXmlMeasurementsImpl jsXmlMeasurements = new JSXmlMeasurementsImpl();
		return jsXmlMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Descriptions createDescriptions() {
		DescriptionsImpl descriptions = new DescriptionsImpl();
		return descriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSetDescription createMetricSetDescription() {
		MetricSetDescriptionImpl metricSetDescription = new MetricSetDescriptionImpl();
		return metricSetDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalStatistics createOrdinalStatistics() {
		OrdinalStatisticsImpl ordinalStatistics = new OrdinalStatisticsImpl();
		return ordinalStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Percentile createPercentile() {
		PercentileImpl percentile = new PercentileImpl();
		return percentile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntervalStatistics createIntervalStatistics() {
		IntervalStatisticsImpl intervalStatistics = new IntervalStatisticsImpl();
		return intervalStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RatioStatistics createRatioStatistics() {
		RatioStatisticsImpl ratioStatistics = new RatioStatisticsImpl();
		return ratioStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedNominalMeasurements createObservedNominalMeasurements() {
		ObservedNominalMeasurementsImpl observedNominalMeasurements = new ObservedNominalMeasurementsImpl();
		return observedNominalMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedCategory createObservedCategory() {
		ObservedCategoryImpl observedCategory = new ObservedCategoryImpl();
		return observedCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkV1NominalMeasurements createSensorFrameworkV1NominalMeasurements() {
		SensorFrameworkV1NominalMeasurementsImpl sensorFrameworkV1NominalMeasurements = new SensorFrameworkV1NominalMeasurementsImpl();
		return sensorFrameworkV1NominalMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkV1DoubleBinaryMeasurements createSensorFrameworkV1DoubleBinaryMeasurements() {
		SensorFrameworkV1DoubleBinaryMeasurementsImpl sensorFrameworkV1DoubleBinaryMeasurements = new SensorFrameworkV1DoubleBinaryMeasurementsImpl();
		return sensorFrameworkV1DoubleBinaryMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersistenceKindOptions createPersistenceKindOptionsFromString(EDataType eDataType, String initialValue) {
		PersistenceKindOptions result = PersistenceKindOptions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPersistenceKindOptionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaptureType createCaptureTypeFromString(EDataType eDataType, String initialValue) {
		CaptureType result = CaptureType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCaptureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scale createScaleFromString(EDataType eDataType, String initialValue) {
		Scale result = Scale.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monotonic createMonotonicFromString(EDataType eDataType, String initialValue) {
		Monotonic result = Monotonic.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMonotonicToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Measure createEJSMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEJSMeasureToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Measure createEJSDurationMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEJSDurationMeasureToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Unit createEJSUnitFromString(EDataType eDataType, String initialValue) {
		return (Unit) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public String convertEJSUnitToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDataPackage getExperimentDataPackage() {
		return (ExperimentDataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExperimentDataPackage getPackage() {
		return ExperimentDataPackage.eINSTANCE;
	}

} //EmfmodelFactoryImpl
