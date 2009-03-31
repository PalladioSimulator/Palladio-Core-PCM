/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.util;

import de.uka.ipd.sdq.edp2.models.emfmodel.*;

import java.util.Map;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage
 * @generated
 */
public class EmfmodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EmfmodelValidator INSTANCE = new EmfmodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.edp2.models.emfmodel";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statisticsonlyformeasurablevalues' of 'Raw YSeries'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RAW_YSERIES__STATISTICSONLYFORMEASURABLEVALUES = 1;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Persistency Kind Not Emf' of 'Ordinal Scalar Measure'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ORDINAL_SCALAR_MEASURE__PERSISTENCY_KIND_NOT_EMF = 4;

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
	public EmfmodelValidator() {
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
	  return EmfmodelPackage.eINSTANCE;
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS:
				return validateAggregatedMeasurements((AggregatedMeasurements)value, diagnostics, context);
			case EmfmodelPackage.IDENTIFIABLE:
				return validateIdentifiable((Identifiable)value, diagnostics, context);
			case EmfmodelPackage.MEASUREMENT_RANGE:
				return validateMeasurementRange((MeasurementRange)value, diagnostics, context);
			case EmfmodelPackage.RAW_MEASUREMENTS:
				return validateRawMeasurements((RawMeasurements)value, diagnostics, context);
			case EmfmodelPackage.RAW_XSERIES:
				return validateRawXSeries((RawXSeries)value, diagnostics, context);
			case EmfmodelPackage.RAW_YSERIES:
				return validateRawYSeries((RawYSeries)value, diagnostics, context);
			case EmfmodelPackage.NOMINAL_STATISTICS:
				return validateNominalStatistics((NominalStatistics)value, diagnostics, context);
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION:
				return validateFixedWidthAggregation((FixedWidthAggregation)value, diagnostics, context);
			case EmfmodelPackage.INTERVALS:
				return validateIntervals((Intervals)value, diagnostics, context);
			case EmfmodelPackage.MEASUREMENT:
				return validateMeasurement((Measurement)value, diagnostics, context);
			case EmfmodelPackage.PROPERTYABLE:
				return validatePropertyable((Propertyable)value, diagnostics, context);
			case EmfmodelPackage.ESTRINGTO_EOBJECT_MAP_ENTRY:
				return validateEStringtoEObjectMapEntry((Map.Entry<?, ?>)value, diagnostics, context);
			case EmfmodelPackage.MEASURE:
				return validateMeasure((Measure)value, diagnostics, context);
			case EmfmodelPackage.EXPERIMENT_GROUP:
				return validateExperimentGroup((ExperimentGroup)value, diagnostics, context);
			case EmfmodelPackage.EXPERIMENT_SETTING:
				return validateExperimentSetting((ExperimentSetting)value, diagnostics, context);
			case EmfmodelPackage.EXPERIMENT_RUN:
				return validateExperimentRun((ExperimentRun)value, diagnostics, context);
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION:
				return validateBaseMetricDescription((BaseMetricDescription)value, diagnostics, context);
			case EmfmodelPackage.METRIC_DESCRIPTION:
				return validateMetricDescription((MetricDescription)value, diagnostics, context);
			case EmfmodelPackage.DESCRIPTION:
				return validateDescription((Description)value, diagnostics, context);
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION:
				return validateAggregationCharacterization((AggregationCharacterization)value, diagnostics, context);
			case EmfmodelPackage.AGGREGATION_FUNCTION_DESCRIPTION:
				return validateAggregationFunctionDescription((AggregationFunctionDescription)value, diagnostics, context);
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS:
				return validateLongBinaryMeasurements((LongBinaryMeasurements)value, diagnostics, context);
			case EmfmodelPackage.CATEGORY_IDENTIFIER:
				return validateCategoryIdentifier((CategoryIdentifier)value, diagnostics, context);
			case EmfmodelPackage.NOMINAL_MEASUREMENTS:
				return validateNominalMeasurements((NominalMeasurements)value, diagnostics, context);
			case EmfmodelPackage.NOMINAL_MEASURE:
				return validateNominalMeasure((NominalMeasure)value, diagnostics, context);
			case EmfmodelPackage.DOUBLE_BINARY_MEASUREMENTS:
				return validateDoubleBinaryMeasurements((DoubleBinaryMeasurements)value, diagnostics, context);
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE:
				return validateOrdinalScalarMeasure((OrdinalScalarMeasure)value, diagnostics, context);
			case EmfmodelPackage.JS_XML_MEASUREMENTS:
				return validateJSXmlMeasurements((JSXmlMeasurements)value, diagnostics, context);
			case EmfmodelPackage.EVENT_TIME_AGGREGATION:
				return validateEventTimeAggregation((EventTimeAggregation)value, diagnostics, context);
			case EmfmodelPackage.VALUE_AGGREGATION:
				return validateValueAggregation((ValueAggregation)value, diagnostics, context);
			case EmfmodelPackage.STRONG_MONOTONIC_SCALAR_MEASURE:
				return validateStrongMonotonicScalarMeasure((StrongMonotonicScalarMeasure)value, diagnostics, context);
			case EmfmodelPackage.DOUBLE_BINARY_EVENT_TIMES:
				return validateDoubleBinaryEventTimes((DoubleBinaryEventTimes)value, diagnostics, context);
			case EmfmodelPackage.IJS_DURATION:
				return validateIJSDuration((Duration)value, diagnostics, context);
			case EmfmodelPackage.IJS_QUANTITY:
				return validateIJSQuantity((Quantity)value, diagnostics, context);
			case EmfmodelPackage.DESCRIPTIONS:
				return validateDescriptions((Descriptions)value, diagnostics, context);
			case EmfmodelPackage.METRIC_SET_DESCRIPTION:
				return validateMetricSetDescription((MetricSetDescription)value, diagnostics, context);
			case EmfmodelPackage.ORDINAL_STATISTICS:
				return validateOrdinalStatistics((OrdinalStatistics)value, diagnostics, context);
			case EmfmodelPackage.PERCENTILE:
				return validatePercentile((Percentile)value, diagnostics, context);
			case EmfmodelPackage.INTERVAL_STATISTICS:
				return validateIntervalStatistics((IntervalStatistics)value, diagnostics, context);
			case EmfmodelPackage.RATIO_STATISTICS:
				return validateRatioStatistics((RatioStatistics)value, diagnostics, context);
			case EmfmodelPackage.OBSERVED_NOMINAL_MEASUREMENTS:
				return validateObservedNominalMeasurements((ObservedNominalMeasurements)value, diagnostics, context);
			case EmfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return validatePersistenceKindOptions((PersistenceKindOptions)value, diagnostics, context);
			case EmfmodelPackage.CAPTURE_TYPE:
				return validateCaptureType((CaptureType)value, diagnostics, context);
			case EmfmodelPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case EmfmodelPackage.SCALE:
				return validateScale((Scale)value, diagnostics, context);
			case EmfmodelPackage.ENUMERATION1:
				return validateEnumeration1((Enumeration1)value, diagnostics, context);
			case EmfmodelPackage.EJS_MEASURE:
				return validateEJSMeasure((javax.measure.Measure)value, diagnostics, context);
			case EmfmodelPackage.EJS_DURATION_MEASURE:
				return validateEJSDurationMeasure((javax.measure.Measure)value, diagnostics, context);
			case EmfmodelPackage.EJS_UNIT:
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
	public boolean validateMeasurementRange(MeasurementRange measurementRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measurementRange, diagnostics, context);
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
	public boolean validateRawXSeries(RawXSeries rawXSeries, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rawXSeries, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRawYSeries(RawYSeries rawYSeries, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rawYSeries, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYSeries_Statisticsonlyformeasurablevalues(rawYSeries, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Statisticsonlyformeasurablevalues constraint of '<em>Raw YSeries</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRawYSeries_Statisticsonlyformeasurablevalues(RawYSeries rawYSeries, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rawYSeries.Statisticsonlyformeasurablevalues(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNominalStatistics(NominalStatistics nominalStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nominalStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedWidthAggregation(FixedWidthAggregation fixedWidthAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fixedWidthAggregation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntervals(Intervals intervals, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intervals, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurement(Measurement measurement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measurement, diagnostics, context);
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
	public boolean validateMeasure(Measure measure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measure, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateExperimentRun_ExactlyOneDataCollectionPerSensor(experimentRun, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ExactlyOneDataCollectionPerSensor constraint of '<em>Experiment Run</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExperimentRun_ExactlyOneDataCollectionPerSensor(ExperimentRun experimentRun, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return experimentRun.ExactlyOneDataCollectionPerSensor(diagnostics, context);
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
	public boolean validateMetricDescription(MetricDescription metricDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricDescription, diagnostics, context);
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
	public boolean validateAggregationCharacterization(AggregationCharacterization aggregationCharacterization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(aggregationCharacterization, diagnostics, context);
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
	public boolean validateLongBinaryMeasurements(LongBinaryMeasurements longBinaryMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(longBinaryMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYSeries_Statisticsonlyformeasurablevalues(longBinaryMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategoryIdentifier(CategoryIdentifier categoryIdentifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(categoryIdentifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNominalMeasurements(NominalMeasurements nominalMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nominalMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYSeries_Statisticsonlyformeasurablevalues(nominalMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNominalMeasure(NominalMeasure nominalMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nominalMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validateNominalMeasure_PersistenceKindOnlyEmfAllowed(nominalMeasure, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PersistenceKindOnlyEmfAllowed constraint of '<em>Nominal Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNominalMeasure_PersistenceKindOnlyEmfAllowed(NominalMeasure nominalMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nominalMeasure.PersistenceKindOnlyEmfAllowed(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRawYSeries_Statisticsonlyformeasurablevalues(doubleBinaryMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrdinalScalarMeasure(OrdinalScalarMeasure ordinalScalarMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ordinalScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validateOrdinalScalarMeasure_PersistencyKindNotEmf(ordinalScalarMeasure, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PersistencyKindNotEmf constraint of '<em>Ordinal Scalar Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrdinalScalarMeasure_PersistencyKindNotEmf(OrdinalScalarMeasure ordinalScalarMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ordinalScalarMeasure.PersistencyKindNotEmf(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRawYSeries_Statisticsonlyformeasurablevalues(jsXmlMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventTimeAggregation(EventTimeAggregation eventTimeAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventTimeAggregation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueAggregation(ValueAggregation valueAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueAggregation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStrongMonotonicScalarMeasure(StrongMonotonicScalarMeasure strongMonotonicScalarMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(strongMonotonicScalarMeasure, diagnostics, context);
		if (result || diagnostics != null) result &= validateOrdinalScalarMeasure_PersistencyKindNotEmf(strongMonotonicScalarMeasure, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleBinaryEventTimes(DoubleBinaryEventTimes doubleBinaryEventTimes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(doubleBinaryEventTimes, diagnostics, context);
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
	public boolean validateDescriptions(Descriptions descriptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(descriptions, diagnostics, context);
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
	public boolean validateOrdinalStatistics(OrdinalStatistics ordinalStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ordinalStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercentile(Percentile percentile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(percentile, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntervalStatistics(IntervalStatistics intervalStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intervalStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRatioStatistics(RatioStatistics ratioStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ratioStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObservedNominalMeasurements(ObservedNominalMeasurements observedNominalMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(observedNominalMeasurements, diagnostics, context);
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
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateEnumeration1(Enumeration1 enumeration1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEJSMeasure(javax.measure.Measure ejsMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEJSDurationMeasure(javax.measure.Measure ejsDurationMeasure, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //EmfmodelValidator
