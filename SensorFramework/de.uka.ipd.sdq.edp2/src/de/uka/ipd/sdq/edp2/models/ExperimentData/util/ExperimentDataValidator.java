/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.util;

import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage
 * @generated
 */
public class ExperimentDataValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ExperimentDataValidator INSTANCE = new ExperimentDataValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.edp2.models.ExperimentData";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statisticsonlyformeasurablevalues' of 'Data Series'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_SERIES__STATISTICSONLYFORMEASURABLEVALUES = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactly One Data Collection Per Sensor' of 'Experiment Run'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPERIMENT_RUN__EXACTLY_ONE_DATA_COLLECTION_PER_SENSOR = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Persistence Kind Only Emf Allowed' of 'Nominal Measure'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NOMINAL_MEASURE__PERSISTENCE_KIND_ONLY_EMF_ALLOWED = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Persistency Kind Not Emf' of 'Ordinal Measure'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ORDINAL_MEASURE__PERSISTENCY_KIND_NOT_EMF = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDataValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ExperimentDataPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ExperimentDataPackage.AGGREGATED_MEASUREMENTS:
				return validateAggregatedMeasurements((AggregatedMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.IDENTIFIABLE:
				return validateIdentifiable((Identifiable)value, diagnostics, context);
			case ExperimentDataPackage.MEASUREMENTS_RANGE:
				return validateMeasurementsRange((MeasurementsRange)value, diagnostics, context);
			case ExperimentDataPackage.PROPERTYABLE:
				return validatePropertyable((Propertyable)value, diagnostics, context);
			case ExperimentDataPackage.ESTRINGTO_EOBJECT_MAP_ENTRY:
				return validateEStringtoEObjectMapEntry((Map.Entry<?, ?>)value, diagnostics, context);
			case ExperimentDataPackage.RAW_MEASUREMENTS:
				return validateRawMeasurements((RawMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.DATA_SERIES:
				return validateDataSeries((DataSeries)value, diagnostics, context);
			case ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS:
				return validateFixedWidthAggregatedMeasurements((FixedWidthAggregatedMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.FIXED_INTERVALS:
				return validateFixedIntervals((FixedIntervals)value, diagnostics, context);
			case ExperimentDataPackage.MEASUREMENTS:
				return validateMeasurements((Measurements)value, diagnostics, context);
			case ExperimentDataPackage.EDP2_MEASURE:
				return validateEdp2Measure((Edp2Measure)value, diagnostics, context);
			case ExperimentDataPackage.EXPERIMENT_GROUP:
				return validateExperimentGroup((ExperimentGroup)value, diagnostics, context);
			case ExperimentDataPackage.EXPERIMENT_SETTING:
				return validateExperimentSetting((ExperimentSetting)value, diagnostics, context);
			case ExperimentDataPackage.EXPERIMENT_RUN:
				return validateExperimentRun((ExperimentRun)value, diagnostics, context);
			case ExperimentDataPackage.DESCRIPTION:
				return validateDescription((Description)value, diagnostics, context);
			case ExperimentDataPackage.METRIC_DESCRIPTION:
				return validateMetricDescription((MetricDescription)value, diagnostics, context);
			case ExperimentDataPackage.AGGREGATION_FUNCTION_DESCRIPTION:
				return validateAggregationFunctionDescription((AggregationFunctionDescription)value, diagnostics, context);
			case ExperimentDataPackage.AGGREGATION_STATISTICS:
				return validateAggregationStatistics((AggregationStatistics)value, diagnostics, context);
			case ExperimentDataPackage.BASE_METRIC_DESCRIPTION:
				return validateBaseMetricDescription((BaseMetricDescription)value, diagnostics, context);
			case ExperimentDataPackage.DESCRIPTIONS:
				return validateDescriptions((Descriptions)value, diagnostics, context);
			case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS:
				return validateDoubleBinaryMeasurements((DoubleBinaryMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.JS_XML_MEASUREMENTS:
				return validateJSXmlMeasurements((JSXmlMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.LONG_BINARY_MEASUREMENTS:
				return validateLongBinaryMeasurements((LongBinaryMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION:
				return validateMetricSetDescription((MetricSetDescription)value, diagnostics, context);
			case ExperimentDataPackage.SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS:
				return validateSensorFrameworkV1DoubleBinaryMeasurements((SensorFrameworkV1DoubleBinaryMeasurements)value, diagnostics, context);
			case ExperimentDataPackage.IJS_DURATION:
				return validateIJSDuration((Duration)value, diagnostics, context);
			case ExperimentDataPackage.IJS_QUANTITY:
				return validateIJSQuantity((Quantity)value, diagnostics, context);
			case ExperimentDataPackage.PERSISTENCE_KIND_OPTIONS:
				return validatePersistenceKindOptions((PersistenceKindOptions)value, diagnostics, context);
			case ExperimentDataPackage.CAPTURE_TYPE:
				return validateCaptureType((CaptureType)value, diagnostics, context);
			case ExperimentDataPackage.SCALE:
				return validateScale((Scale)value, diagnostics, context);
			case ExperimentDataPackage.MONOTONIC:
				return validateMonotonic((Monotonic)value, diagnostics, context);
			case ExperimentDataPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case ExperimentDataPackage.EJS_MEASURE:
				return validateEJSMeasure((Measure)value, diagnostics, context);
			case ExperimentDataPackage.EJS_DURATION_MEASURE:
				return validateEJSDurationMeasure((Measure)value, diagnostics, context);
			case ExperimentDataPackage.EJS_UNIT:
				return validateEJSUnit((Unit)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregatedMeasurements(AggregatedMeasurements aggregatedMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aggregatedMeasurements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIdentifiable(Identifiable identifiable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(identifiable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurementsRange(MeasurementsRange measurementsRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measurementsRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyable(Propertyable propertyable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringtoEObjectMapEntry(Map.Entry<?, ?> eStringtoEObjectMapEntry, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringtoEObjectMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRawMeasurements(RawMeasurements rawMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rawMeasurements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataSeries(DataSeries dataSeries, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataSeries, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedWidthAggregatedMeasurements(FixedWidthAggregatedMeasurements fixedWidthAggregatedMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fixedWidthAggregatedMeasurements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedIntervals(FixedIntervals fixedIntervals, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fixedIntervals, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurements(Measurements measurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measurements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdp2Measure(Edp2Measure edp2Measure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(edp2Measure, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExperimentGroup(ExperimentGroup experimentGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(experimentGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExperimentSetting(ExperimentSetting experimentSetting, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(experimentSetting, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExperimentRun(ExperimentRun experimentRun, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(experimentRun, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(experimentRun, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescription(Description description, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(description, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricDescription(MetricDescription metricDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregationFunctionDescription(AggregationFunctionDescription aggregationFunctionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aggregationFunctionDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregationStatistics(AggregationStatistics aggregationStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aggregationStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBaseMetricDescription(BaseMetricDescription baseMetricDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseMetricDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescriptions(Descriptions descriptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(descriptions, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleBinaryMeasurements(DoubleBinaryMeasurements doubleBinaryMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(doubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(doubleBinaryMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJSXmlMeasurements(JSXmlMeasurements jsXmlMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(jsXmlMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(jsXmlMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongBinaryMeasurements(LongBinaryMeasurements longBinaryMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(longBinaryMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricSetDescription(MetricSetDescription metricSetDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricSetDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSensorFrameworkV1DoubleBinaryMeasurements(SensorFrameworkV1DoubleBinaryMeasurements sensorFrameworkV1DoubleBinaryMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sensorFrameworkV1DoubleBinaryMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIJSDuration(Duration ijsDuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)ijsDuration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIJSQuantity(Quantity ijsQuantity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)ijsQuantity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePersistenceKindOptions(PersistenceKindOptions persistenceKindOptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCaptureType(CaptureType captureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScale(Scale scale, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMonotonic(Monotonic monotonic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEJSMeasure(Measure ejsMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEJSDurationMeasure(Measure ejsDurationMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEJSUnit(Unit ejsUnit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ExperimentDataValidator
