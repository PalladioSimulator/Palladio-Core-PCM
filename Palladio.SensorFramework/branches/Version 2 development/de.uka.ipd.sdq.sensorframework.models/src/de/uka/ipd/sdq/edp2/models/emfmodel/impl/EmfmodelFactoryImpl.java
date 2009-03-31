/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.*;

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
public class EmfmodelFactoryImpl extends EFactoryImpl implements EmfmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmfmodelFactory init() {
		try {
			EmfmodelFactory theEmfmodelFactory = (EmfmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/EDP2/0.9.0"); 
			if (theEmfmodelFactory != null) {
				return theEmfmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmfmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfmodelFactoryImpl() {
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
			case EmfmodelPackage.MEASUREMENT_RANGE: return createMeasurementRange();
			case EmfmodelPackage.NOMINAL_STATISTICS: return createNominalStatistics();
			case EmfmodelPackage.INTERVALS: return createIntervals();
			case EmfmodelPackage.MEASUREMENT: return createMeasurement();
			case EmfmodelPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
			case EmfmodelPackage.EXPERIMENT_GROUP: return createExperimentGroup();
			case EmfmodelPackage.EXPERIMENT_SETTING: return createExperimentSetting();
			case EmfmodelPackage.EXPERIMENT_RUN: return createExperimentRun();
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION: return createBaseMetricDescription();
			case EmfmodelPackage.METRIC_DESCRIPTION: return createMetricDescription();
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION: return createAggregationCharacterization();
			case EmfmodelPackage.AGGREGATION_FUNCTION_DESCRIPTION: return createAggregationFunctionDescription();
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS: return createLongBinaryMeasurements();
			case EmfmodelPackage.CATEGORY_IDENTIFIER: return createCategoryIdentifier();
			case EmfmodelPackage.NOMINAL_MEASUREMENTS: return createNominalMeasurements();
			case EmfmodelPackage.NOMINAL_MEASURE: return createNominalMeasure();
			case EmfmodelPackage.DOUBLE_BINARY_MEASUREMENTS: return createDoubleBinaryMeasurements();
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE: return createOrdinalScalarMeasure();
			case EmfmodelPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
			case EmfmodelPackage.EVENT_TIME_AGGREGATION: return createEventTimeAggregation();
			case EmfmodelPackage.VALUE_AGGREGATION: return createValueAggregation();
			case EmfmodelPackage.STRONG_MONOTONIC_SCALAR_MEASURE: return createStrongMonotonicScalarMeasure();
			case EmfmodelPackage.DOUBLE_BINARY_EVENT_TIMES: return createDoubleBinaryEventTimes();
			case EmfmodelPackage.DESCRIPTIONS: return createDescriptions();
			case EmfmodelPackage.METRIC_SET_DESCRIPTION: return createMetricSetDescription();
			case EmfmodelPackage.ORDINAL_STATISTICS: return createOrdinalStatistics();
			case EmfmodelPackage.PERCENTILE: return createPercentile();
			case EmfmodelPackage.INTERVAL_STATISTICS: return createIntervalStatistics();
			case EmfmodelPackage.RATIO_STATISTICS: return createRatioStatistics();
			case EmfmodelPackage.OBSERVED_NOMINAL_MEASUREMENTS: return createObservedNominalMeasurements();
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
			case EmfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return createPersistenceKindOptionsFromString(eDataType, initialValue);
			case EmfmodelPackage.CAPTURE_TYPE:
				return createCaptureTypeFromString(eDataType, initialValue);
			case EmfmodelPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case EmfmodelPackage.SCALE:
				return createScaleFromString(eDataType, initialValue);
			case EmfmodelPackage.ENUMERATION1:
				return createEnumeration1FromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_MEASURE:
				return createEJSMeasureFromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_DURATION_MEASURE:
				return createEJSDurationMeasureFromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_UNIT:
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
			case EmfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return convertPersistenceKindOptionsToString(eDataType, instanceValue);
			case EmfmodelPackage.CAPTURE_TYPE:
				return convertCaptureTypeToString(eDataType, instanceValue);
			case EmfmodelPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case EmfmodelPackage.SCALE:
				return convertScaleToString(eDataType, instanceValue);
			case EmfmodelPackage.ENUMERATION1:
				return convertEnumeration1ToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_MEASURE:
				return convertEJSMeasureToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_DURATION_MEASURE:
				return convertEJSDurationMeasureToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_UNIT:
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
	public Intervals createIntervals() {
		IntervalsImpl intervals = new IntervalsImpl();
		return intervals;
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
	public MetricDescription createMetricDescription() {
		MetricDescriptionImpl metricDescription = new MetricDescriptionImpl();
		return metricDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationCharacterization createAggregationCharacterization() {
		AggregationCharacterizationImpl aggregationCharacterization = new AggregationCharacterizationImpl();
		return aggregationCharacterization;
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
	public OrdinalScalarMeasure createOrdinalScalarMeasure() {
		OrdinalScalarMeasureImpl ordinalScalarMeasure = new OrdinalScalarMeasureImpl();
		return ordinalScalarMeasure;
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
	public EventTimeAggregation createEventTimeAggregation() {
		EventTimeAggregationImpl eventTimeAggregation = new EventTimeAggregationImpl();
		return eventTimeAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueAggregation createValueAggregation() {
		ValueAggregationImpl valueAggregation = new ValueAggregationImpl();
		return valueAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrongMonotonicScalarMeasure createStrongMonotonicScalarMeasure() {
		StrongMonotonicScalarMeasureImpl strongMonotonicScalarMeasure = new StrongMonotonicScalarMeasureImpl();
		return strongMonotonicScalarMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleBinaryEventTimes createDoubleBinaryEventTimes() {
		DoubleBinaryEventTimesImpl doubleBinaryEventTimes = new DoubleBinaryEventTimesImpl();
		return doubleBinaryEventTimes;
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
	public Enumeration1 createEnumeration1FromString(EDataType eDataType, String initialValue) {
		Enumeration1 result = Enumeration1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumeration1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure createEJSMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure createEJSDurationMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSDurationMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createEJSUnitFromString(EDataType eDataType, String initialValue) {
		return (Unit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfmodelPackage getEmfmodelPackage() {
		return (EmfmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmfmodelPackage getPackage() {
		return EmfmodelPackage.eINSTANCE;
	}

} //EmfmodelFactoryImpl
