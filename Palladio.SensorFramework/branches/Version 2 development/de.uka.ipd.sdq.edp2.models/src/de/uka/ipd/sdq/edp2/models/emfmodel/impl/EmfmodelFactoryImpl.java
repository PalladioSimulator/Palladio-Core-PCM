/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.*;

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
			case EmfmodelPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
			case EmfmodelPackage.RAW_MEASUREMENTS: return createRawMeasurements();
			case EmfmodelPackage.NOMINAL_STATISTICS: return createNominalStatistics();
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS: return createFixedWidthAggregatedMeasurements();
			case EmfmodelPackage.FIXED_INTERVALS: return createFixedIntervals();
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION: return createBaseMetricDescription();
			case EmfmodelPackage.MEASUREMENT: return createMeasurement();
			case EmfmodelPackage.EXPERIMENT_GROUP: return createExperimentGroup();
			case EmfmodelPackage.EXPERIMENT_SETTING: return createExperimentSetting();
			case EmfmodelPackage.EXPERIMENT_RUN: return createExperimentRun();
			case EmfmodelPackage.AGGREGATION_FUNCTION_DESCRIPTION: return createAggregationFunctionDescription();
			case EmfmodelPackage.AGGREGATION_STATISTICS: return createAggregationStatistics();
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS: return createLongBinaryMeasurements();
			case EmfmodelPackage.CATEGORY_IDENTIFIER: return createCategoryIdentifier();
			case EmfmodelPackage.NOMINAL_MEASUREMENTS: return createNominalMeasurements();
			case EmfmodelPackage.NOMINAL_MEASURE: return createNominalMeasure();
			case EmfmodelPackage.DOUBLE_BINARY_MEASUREMENTS: return createDoubleBinaryMeasurements();
			case EmfmodelPackage.ORDINAL_MEASURE: return createOrdinalMeasure();
			case EmfmodelPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
			case EmfmodelPackage.DESCRIPTIONS: return createDescriptions();
			case EmfmodelPackage.METRIC_SET_DESCRIPTION: return createMetricSetDescription();
			case EmfmodelPackage.ORDINAL_STATISTICS: return createOrdinalStatistics();
			case EmfmodelPackage.PERCENTILE: return createPercentile();
			case EmfmodelPackage.INTERVAL_STATISTICS: return createIntervalStatistics();
			case EmfmodelPackage.RATIO_STATISTICS: return createRatioStatistics();
			case EmfmodelPackage.OBSERVED_NOMINAL_MEASUREMENTS: return createObservedNominalMeasurements();
			case EmfmodelPackage.OBSERVED_CATEGORY: return createObservedCategory();
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
			case EmfmodelPackage.CAPTURE_TYPE:
				return createCaptureTypeFromString(eDataType, initialValue);
			case EmfmodelPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case EmfmodelPackage.SCALE:
				return createScaleFromString(eDataType, initialValue);
			case EmfmodelPackage.MONOTONIC:
				return createMonotonicFromString(eDataType, initialValue);
			case EmfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return createPersistenceKindOptionsFromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_MEASURE:
				return createEJSMeasureFromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_UNIT:
				return createEJSUnitFromString(eDataType, initialValue);
			case EmfmodelPackage.EJS_DURATION_MEASURE:
				return createEJSDurationMeasureFromString(eDataType, initialValue);
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
			case EmfmodelPackage.CAPTURE_TYPE:
				return convertCaptureTypeToString(eDataType, instanceValue);
			case EmfmodelPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case EmfmodelPackage.SCALE:
				return convertScaleToString(eDataType, instanceValue);
			case EmfmodelPackage.MONOTONIC:
				return convertMonotonicToString(eDataType, instanceValue);
			case EmfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return convertPersistenceKindOptionsToString(eDataType, instanceValue);
			case EmfmodelPackage.ENUMERATION1:
				return convertEnumeration1ToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_MEASURE:
				return convertEJSMeasureToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_UNIT:
				return convertEJSUnitToString(eDataType, instanceValue);
			case EmfmodelPackage.EJS_DURATION_MEASURE:
				return convertEJSDurationMeasureToString(eDataType, instanceValue);
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
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Unit createEJSUnitFromString(EDataType eDataType, String initialValue) {
		//return (Unit)super.createFromString(eDataType, initialValue);
		if (initialValue == null) {
			return null;
		}
		return Unit.valueOf(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public String convertEJSUnitToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) {
			return null;
		}
		return ((Unit) instanceValue).toString();
		
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
