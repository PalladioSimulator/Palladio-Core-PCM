/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.util;

import de.uka.ipd.sdq.sensorframework.*;

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

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage
 * @generated
 */
public class sensorframeworkValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final sensorframeworkValidator INSTANCE = new sensorframeworkValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.sensorframework";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statisticsonlyformeasurablevalues' of 'Raw YValues'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RAW_YVALUES__STATISTICSONLYFORMEASURABLEVALUES = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactly One Data Collection Per Sensor' of 'Experiment Run'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPERIMENT_RUN__EXACTLY_ONE_DATA_COLLECTION_PER_SENSOR = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Persistence Kind Only Emf Allowed' of 'State Sensor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_SENSOR__PERSISTENCE_KIND_ONLY_EMF_ALLOWED = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Persistency Kind Not Emf' of 'Measurable Sensor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEASURABLE_SENSOR__PERSISTENCY_KIND_NOT_EMF = 4;

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
	public sensorframeworkValidator() {
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
	  return sensorframeworkPackage.eINSTANCE;
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS:
				return validateAggregatedMeasurements((AggregatedMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.MEASUREMENT_RANGE:
				return validateMeasurementRange((MeasurementRange)value, diagnostics, context);
			case sensorframeworkPackage.RAW_MEASUREMENTS:
				return validateRawMeasurements((RawMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.RAW_XVALUES:
				return validateRawXValues((RawXValues)value, diagnostics, context);
			case sensorframeworkPackage.RAW_YVALUES:
				return validateRawYValues((RawYValues)value, diagnostics, context);
			case sensorframeworkPackage.STATISTICS:
				return validateStatistics((Statistics)value, diagnostics, context);
			case sensorframeworkPackage.COLLECTED_DATA:
				return validateCollectedData((CollectedData)value, diagnostics, context);
			case sensorframeworkPackage.PROPERTYABLE:
				return validatePropertyable((Propertyable)value, diagnostics, context);
			case sensorframeworkPackage.ESTRINGTO_EOBJECT_MAP_ENTRY:
				return validateEStringtoEObjectMapEntry((Map.Entry<?, ?>)value, diagnostics, context);
			case sensorframeworkPackage.SENSOR_DECLARATION:
				return validateSensorDeclaration((SensorDeclaration)value, diagnostics, context);
			case sensorframeworkPackage.EXPERIMENT_SETTING:
				return validateExperimentSetting((ExperimentSetting)value, diagnostics, context);
			case sensorframeworkPackage.EXPERIMENT_RUN:
				return validateExperimentRun((ExperimentRun)value, diagnostics, context);
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION:
				return validateMeasureCharacterization((MeasureCharacterization)value, diagnostics, context);
			case sensorframeworkPackage.LONG_MEASUREMENTS:
				return validateLongMeasurements((LongMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case sensorframeworkPackage.STATE_MEASUREMENTS:
				return validateStateMeasurements((StateMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.STATE_SENSOR:
				return validateStateSensor((StateSensor)value, diagnostics, context);
			case sensorframeworkPackage.DOUBLE_MEASUREMENTS:
				return validateDoubleMeasurements((DoubleMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.EXPERIMENT_GROUP:
				return validateExperimentGroup((ExperimentGroup)value, diagnostics, context);
			case sensorframeworkPackage.MEASURABLE_SENSOR:
				return validateMeasurableSensor((MeasurableSensor)value, diagnostics, context);
			case sensorframeworkPackage.JS_XML_MEASUREMENTS:
				return validateJSXmlMeasurements((JSXmlMeasurements)value, diagnostics, context);
			case sensorframeworkPackage.EVENT_TIME_AGGREGATION:
				return validateEventTimeAggregation((EventTimeAggregation)value, diagnostics, context);
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION:
				return validateFixedWidthAggregation((FixedWidthAggregation)value, diagnostics, context);
			case sensorframeworkPackage.INTERVALS:
				return validateIntervals((Intervals)value, diagnostics, context);
			case sensorframeworkPackage.VALUE_AGGREGATION:
				return validateValueAggregation((ValueAggregation)value, diagnostics, context);
			case sensorframeworkPackage.INCREASING_MEASURABLE_SENSOR:
				return validateIncreasingMeasurableSensor((IncreasingMeasurableSensor)value, diagnostics, context);
			case sensorframeworkPackage.ADVANCED_STATISTICS:
				return validateAdvancedStatistics((AdvancedStatistics)value, diagnostics, context);
			case sensorframeworkPackage.JS_XML_EVENT_TIMES:
				return validateJSXmlEventTimes((JSXmlEventTimes)value, diagnostics, context);
			case sensorframeworkPackage.DOUBLE_EVENT_TIMES:
				return validateDoubleEventTimes((DoubleEventTimes)value, diagnostics, context);
			case sensorframeworkPackage.IJS_DURATION:
				return validateIJSDuration((Duration)value, diagnostics, context);
			case sensorframeworkPackage.IJS_QUANTITY:
				return validateIJSQuantity((Quantity)value, diagnostics, context);
			case sensorframeworkPackage.PERSISTENCE_KIND_OPTIONS:
				return validatePersistenceKindOptions((PersistenceKindOptions)value, diagnostics, context);
			case sensorframeworkPackage.EJS_MEASURE:
				return validateEJSMeasure((Measure)value, diagnostics, context);
			case sensorframeworkPackage.EJS_DURATION_MEASURE:
				return validateEJSDurationMeasure((Measure)value, diagnostics, context);
			case sensorframeworkPackage.EJS_UNIT:
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
	public boolean validateRawXValues(RawXValues rawXValues, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rawXValues, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRawYValues(RawYValues rawYValues, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rawYValues, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYValues_Statisticsonlyformeasurablevalues(rawYValues, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Statisticsonlyformeasurablevalues constraint of '<em>Raw YValues</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRawYValues_Statisticsonlyformeasurablevalues(RawYValues rawYValues, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rawYValues.Statisticsonlyformeasurablevalues(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatistics(Statistics statistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectedData(CollectedData collectedData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collectedData, diagnostics, context);
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
	public boolean validateSensorDeclaration(SensorDeclaration sensorDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sensorDeclaration, diagnostics, context);
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
	public boolean validateMeasureCharacterization(MeasureCharacterization measureCharacterization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measureCharacterization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongMeasurements(LongMeasurements longMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(longMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYValues_Statisticsonlyformeasurablevalues(longMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(state, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMeasurements(StateMeasurements stateMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stateMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYValues_Statisticsonlyformeasurablevalues(stateMeasurements, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateSensor(StateSensor stateSensor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stateSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validateStateSensor_PersistenceKindOnlyEmfAllowed(stateSensor, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PersistenceKindOnlyEmfAllowed constraint of '<em>State Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateSensor_PersistenceKindOnlyEmfAllowed(StateSensor stateSensor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stateSensor.PersistenceKindOnlyEmfAllowed(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleMeasurements(DoubleMeasurements doubleMeasurements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(doubleMeasurements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRawYValues_Statisticsonlyformeasurablevalues(doubleMeasurements, diagnostics, context);
		return result;
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
	public boolean validateMeasurableSensor(MeasurableSensor measurableSensor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(measurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validateMeasurableSensor_PersistencyKindNotEmf(measurableSensor, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PersistencyKindNotEmf constraint of '<em>Measurable Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurableSensor_PersistencyKindNotEmf(MeasurableSensor measurableSensor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return measurableSensor.PersistencyKindNotEmf(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRawYValues_Statisticsonlyformeasurablevalues(jsXmlMeasurements, diagnostics, context);
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
	public boolean validateValueAggregation(ValueAggregation valueAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueAggregation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncreasingMeasurableSensor(IncreasingMeasurableSensor increasingMeasurableSensor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(increasingMeasurableSensor, diagnostics, context);
		if (result || diagnostics != null) result &= validateMeasurableSensor_PersistencyKindNotEmf(increasingMeasurableSensor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAdvancedStatistics(AdvancedStatistics advancedStatistics, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(advancedStatistics, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJSXmlEventTimes(JSXmlEventTimes jsXmlEventTimes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jsXmlEventTimes, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleEventTimes(DoubleEventTimes doubleEventTimes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(doubleEventTimes, diagnostics, context);
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

} //sensorframeworkValidator
