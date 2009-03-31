/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.util;

import de.uka.ipd.sdq.edp2.models.emfmodel.*;

import java.util.List;
import java.util.Map;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage
 * @generated
 */
public class EmfmodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmfmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = EmfmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS: {
				AggregatedMeasurements aggregatedMeasurements = (AggregatedMeasurements)theEObject;
				T result = caseAggregatedMeasurements(aggregatedMeasurements);
				if (result == null) result = caseIdentifiable(aggregatedMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.IDENTIFIABLE: {
				Identifiable identifiable = (Identifiable)theEObject;
				T result = caseIdentifiable(identifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.MEASUREMENT_RANGE: {
				MeasurementRange measurementRange = (MeasurementRange)theEObject;
				T result = caseMeasurementRange(measurementRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.RAW_MEASUREMENTS: {
				RawMeasurements rawMeasurements = (RawMeasurements)theEObject;
				T result = caseRawMeasurements(rawMeasurements);
				if (result == null) result = caseIdentifiable(rawMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.RAW_XSERIES: {
				RawXSeries rawXSeries = (RawXSeries)theEObject;
				T result = caseRawXSeries(rawXSeries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.RAW_YSERIES: {
				RawYSeries rawYSeries = (RawYSeries)theEObject;
				T result = caseRawYSeries(rawYSeries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.NOMINAL_STATISTICS: {
				NominalStatistics nominalStatistics = (NominalStatistics)theEObject;
				T result = caseNominalStatistics(nominalStatistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION: {
				FixedWidthAggregation fixedWidthAggregation = (FixedWidthAggregation)theEObject;
				T result = caseFixedWidthAggregation(fixedWidthAggregation);
				if (result == null) result = caseAggregatedMeasurements(fixedWidthAggregation);
				if (result == null) result = caseIdentifiable(fixedWidthAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.INTERVALS: {
				Intervals intervals = (Intervals)theEObject;
				T result = caseIntervals(intervals);
				if (result == null) result = caseRawXSeries(intervals);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.MEASUREMENT: {
				Measurement measurement = (Measurement)theEObject;
				T result = caseMeasurement(measurement);
				if (result == null) result = casePropertyable(measurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.PROPERTYABLE: {
				Propertyable propertyable = (Propertyable)theEObject;
				T result = casePropertyable(propertyable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Object> eStringtoEObjectMapEntry = (Map.Entry<String, Object>)theEObject;
				T result = caseEStringtoEObjectMapEntry(eStringtoEObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.MEASURE: {
				Measure measure = (Measure)theEObject;
				T result = caseMeasure(measure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.EXPERIMENT_GROUP: {
				ExperimentGroup experimentGroup = (ExperimentGroup)theEObject;
				T result = caseExperimentGroup(experimentGroup);
				if (result == null) result = caseIdentifiable(experimentGroup);
				if (result == null) result = casePropertyable(experimentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.EXPERIMENT_SETTING: {
				ExperimentSetting experimentSetting = (ExperimentSetting)theEObject;
				T result = caseExperimentSetting(experimentSetting);
				if (result == null) result = casePropertyable(experimentSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.EXPERIMENT_RUN: {
				ExperimentRun experimentRun = (ExperimentRun)theEObject;
				T result = caseExperimentRun(experimentRun);
				if (result == null) result = caseIdentifiable(experimentRun);
				if (result == null) result = casePropertyable(experimentRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION: {
				BaseMetricDescription baseMetricDescription = (BaseMetricDescription)theEObject;
				T result = caseBaseMetricDescription(baseMetricDescription);
				if (result == null) result = caseMetricDescription(baseMetricDescription);
				if (result == null) result = caseDescription(baseMetricDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.METRIC_DESCRIPTION: {
				MetricDescription metricDescription = (MetricDescription)theEObject;
				T result = caseMetricDescription(metricDescription);
				if (result == null) result = caseDescription(metricDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION: {
				AggregationCharacterization aggregationCharacterization = (AggregationCharacterization)theEObject;
				T result = caseAggregationCharacterization(aggregationCharacterization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.AGGREGATION_FUNCTION_DESCRIPTION: {
				AggregationFunctionDescription aggregationFunctionDescription = (AggregationFunctionDescription)theEObject;
				T result = caseAggregationFunctionDescription(aggregationFunctionDescription);
				if (result == null) result = caseDescription(aggregationFunctionDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS: {
				LongBinaryMeasurements longBinaryMeasurements = (LongBinaryMeasurements)theEObject;
				T result = caseLongBinaryMeasurements(longBinaryMeasurements);
				if (result == null) result = caseRawYSeries(longBinaryMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.CATEGORY_IDENTIFIER: {
				CategoryIdentifier categoryIdentifier = (CategoryIdentifier)theEObject;
				T result = caseCategoryIdentifier(categoryIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.NOMINAL_MEASUREMENTS: {
				NominalMeasurements nominalMeasurements = (NominalMeasurements)theEObject;
				T result = caseNominalMeasurements(nominalMeasurements);
				if (result == null) result = caseRawYSeries(nominalMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.NOMINAL_MEASURE: {
				NominalMeasure nominalMeasure = (NominalMeasure)theEObject;
				T result = caseNominalMeasure(nominalMeasure);
				if (result == null) result = caseMeasure(nominalMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.DOUBLE_BINARY_MEASUREMENTS: {
				DoubleBinaryMeasurements doubleBinaryMeasurements = (DoubleBinaryMeasurements)theEObject;
				T result = caseDoubleBinaryMeasurements(doubleBinaryMeasurements);
				if (result == null) result = caseRawYSeries(doubleBinaryMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.ORDINAL_SCALAR_MEASURE: {
				OrdinalScalarMeasure ordinalScalarMeasure = (OrdinalScalarMeasure)theEObject;
				T result = caseOrdinalScalarMeasure(ordinalScalarMeasure);
				if (result == null) result = caseMeasure(ordinalScalarMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.JS_XML_MEASUREMENTS: {
				JSXmlMeasurements jsXmlMeasurements = (JSXmlMeasurements)theEObject;
				T result = caseJSXmlMeasurements(jsXmlMeasurements);
				if (result == null) result = caseRawYSeries(jsXmlMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.EVENT_TIME_AGGREGATION: {
				EventTimeAggregation eventTimeAggregation = (EventTimeAggregation)theEObject;
				T result = caseEventTimeAggregation(eventTimeAggregation);
				if (result == null) result = caseFixedWidthAggregation(eventTimeAggregation);
				if (result == null) result = caseAggregatedMeasurements(eventTimeAggregation);
				if (result == null) result = caseIdentifiable(eventTimeAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.VALUE_AGGREGATION: {
				ValueAggregation valueAggregation = (ValueAggregation)theEObject;
				T result = caseValueAggregation(valueAggregation);
				if (result == null) result = caseFixedWidthAggregation(valueAggregation);
				if (result == null) result = caseAggregatedMeasurements(valueAggregation);
				if (result == null) result = caseIdentifiable(valueAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.STRONG_MONOTONIC_SCALAR_MEASURE: {
				StrongMonotonicScalarMeasure strongMonotonicScalarMeasure = (StrongMonotonicScalarMeasure)theEObject;
				T result = caseStrongMonotonicScalarMeasure(strongMonotonicScalarMeasure);
				if (result == null) result = caseOrdinalScalarMeasure(strongMonotonicScalarMeasure);
				if (result == null) result = caseMeasure(strongMonotonicScalarMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.DOUBLE_BINARY_EVENT_TIMES: {
				DoubleBinaryEventTimes doubleBinaryEventTimes = (DoubleBinaryEventTimes)theEObject;
				T result = caseDoubleBinaryEventTimes(doubleBinaryEventTimes);
				if (result == null) result = caseRawXSeries(doubleBinaryEventTimes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.DESCRIPTIONS: {
				Descriptions descriptions = (Descriptions)theEObject;
				T result = caseDescriptions(descriptions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.METRIC_SET_DESCRIPTION: {
				MetricSetDescription metricSetDescription = (MetricSetDescription)theEObject;
				T result = caseMetricSetDescription(metricSetDescription);
				if (result == null) result = caseMetricDescription(metricSetDescription);
				if (result == null) result = caseDescription(metricSetDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.ORDINAL_STATISTICS: {
				OrdinalStatistics ordinalStatistics = (OrdinalStatistics)theEObject;
				T result = caseOrdinalStatistics(ordinalStatistics);
				if (result == null) result = caseNominalStatistics(ordinalStatistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.PERCENTILE: {
				Percentile percentile = (Percentile)theEObject;
				T result = casePercentile(percentile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.INTERVAL_STATISTICS: {
				IntervalStatistics intervalStatistics = (IntervalStatistics)theEObject;
				T result = caseIntervalStatistics(intervalStatistics);
				if (result == null) result = caseOrdinalStatistics(intervalStatistics);
				if (result == null) result = caseNominalStatistics(intervalStatistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.RATIO_STATISTICS: {
				RatioStatistics ratioStatistics = (RatioStatistics)theEObject;
				T result = caseRatioStatistics(ratioStatistics);
				if (result == null) result = caseIntervalStatistics(ratioStatistics);
				if (result == null) result = caseOrdinalStatistics(ratioStatistics);
				if (result == null) result = caseNominalStatistics(ratioStatistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfmodelPackage.OBSERVED_NOMINAL_MEASUREMENTS: {
				ObservedNominalMeasurements observedNominalMeasurements = (ObservedNominalMeasurements)theEObject;
				T result = caseObservedNominalMeasurements(observedNominalMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregated Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregated Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregatedMeasurements(AggregatedMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementRange(MeasurementRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawMeasurements(RawMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw XSeries</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw XSeries</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawXSeries(RawXSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw YSeries</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw YSeries</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawYSeries(RawYSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nominal Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nominal Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNominalStatistics(NominalStatistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Width Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Width Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedWidthAggregation(FixedWidthAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intervals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intervals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervals(Intervals object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurement(Measurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Propertyable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Propertyable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyable(Propertyable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EStringto EObject Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStringto EObject Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringtoEObjectMapEntry(Map.Entry<String, Object> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasure(Measure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentGroup(ExperimentGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentSetting(ExperimentSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentRun(ExperimentRun object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Metric Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Metric Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseMetricDescription(BaseMetricDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetricDescription(MetricDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescription(Description object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Characterization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Characterization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregationCharacterization(AggregationCharacterization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Function Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregationFunctionDescription(AggregationFunctionDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Binary Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongBinaryMeasurements(LongBinaryMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoryIdentifier(CategoryIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nominal Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nominal Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNominalMeasurements(NominalMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nominal Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nominal Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNominalMeasure(NominalMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Binary Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Binary Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleBinaryMeasurements(DoubleBinaryMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordinal Scalar Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordinal Scalar Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrdinalScalarMeasure(OrdinalScalarMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JS Xml Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JS Xml Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJSXmlMeasurements(JSXmlMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Time Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Time Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventTimeAggregation(EventTimeAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueAggregation(ValueAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strong Monotonic Scalar Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strong Monotonic Scalar Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrongMonotonicScalarMeasure(StrongMonotonicScalarMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Binary Event Times</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Binary Event Times</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleBinaryEventTimes(DoubleBinaryEventTimes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IJS Duration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IJS Duration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIJSDuration(Duration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IJS Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IJS Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIJSQuantity(Quantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptions(Descriptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric Set Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric Set Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetricSetDescription(MetricSetDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordinal Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordinal Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrdinalStatistics(OrdinalStatistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Percentile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Percentile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePercentile(Percentile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervalStatistics(IntervalStatistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ratio Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ratio Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRatioStatistics(RatioStatistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observed Nominal Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observed Nominal Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservedNominalMeasurements(ObservedNominalMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EmfmodelSwitch
